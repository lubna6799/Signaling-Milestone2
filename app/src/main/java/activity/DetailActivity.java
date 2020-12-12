package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shoppingapp.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
//private TextView price,description,offer;
//private ImageView image;
    private CardView card;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private List<ShopDetail> shops;
    private RecyclerAdapterShopDetail mAdapter;
    private static  String BASE_URL="http://71.1.1.233/android_login_api/shop-product.php?id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int price = intent.getIntExtra("price", 0);
        String offer = intent.getStringExtra("offer");
       // String description = intent.getStringExtra("description");
        //String image = intent.getStringExtra("image");


        shops=new ArrayList<>();
        System.out.println("LOOOOl");
        getShopProduct();
        int productId = 1; //get from intent extra from prev activity
       // BASE_URL+=productId;
          //  card=findViewById(R.id.cardView);
     //  recyclerView = findViewById(R.id.shops_recyvle_view);
        manager = new LinearLayoutManager(DetailActivity.this);
       recyclerView.setHasFixedSize(true);



//        if (intent != null) {

//            description.setText(title);
//            offer.setText("Rating :"+rate+" /2");
//            price.setText(String.valueOf(price));
            //Glide.with(DetailedProductsActivity.this).load(image).into(mImage);
        }
//    }

    private void getShopProduct(){
        System.out.println("yarrrrb");
        //RequestQueue initialized
        RequestQueue mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        StringRequest mStringRequest = new StringRequest(Request.Method.GET, BASE_URL+"1", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen

                try{
                    System.out.println("lol1");
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        int Shop_Id=object.getInt("Shop_Id");
                        String name = object.getString("name");
                        double longtitude=object.getDouble("longtitude");
                        double latitude=object.getDouble("latitude");
                        int id=object.getInt("id");
                        int ProductId = object.getInt("ProductId");
                        int Price=object.getInt("Price");
                        String SpecialOffer=object.getString("SpecialOffer");

                        System.out.println("name shops" + name);
                        ShopDetail shopDetail = new ShopDetail(Shop_Id,name,longtitude,latitude,id,ProductId,Price,SpecialOffer);
                        shops.add(shopDetail);

//                        Intent intent = new Intent(ProductActivity.this,
//                                DetailActivity.class);
//                        startActivity(intent);
//                        finish();
                    }
                    System.out.println("lol2");
//                    System.out.print("shopssss");
                }
                catch(Exception e){
                    System.out.println(e.toString());
                }





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println("ERROR"+error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);

        System.out.println("lol3");
        recyclerView = findViewById(R.id.detail_recyclerView);
        System.out.println("shops.toArray()dddd"+shops.toArray());
        mAdapter = new RecyclerAdapterShopDetail(DetailActivity.this,shops);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(manager);
    }


}