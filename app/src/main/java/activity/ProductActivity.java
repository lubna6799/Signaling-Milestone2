package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shoppingapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private List<Product> products;
    private RecyclerAdapter mAdapter;
    private static final String BASE_URL="http://71.1.1.233/android_login_api/product.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        products=new ArrayList<>();
        System.out.println("LOOOOl");
        getproduct();

        recyclerView = findViewById(R.id.products_recyclerView);
        manager = new LinearLayoutManager(ProductActivity.this);
        recyclerView.setHasFixedSize(true);



    }
    private void getproduct(){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, BASE_URL,new Response.Listener<String >() {
            @Override
            public void onResponse(String response) {
                System.out.println("TSTSTTSTS");
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);

                        String name = object.getString("name");
                        int Productid = object.getInt("Product_id");
                        String description = object.getString("description");
                        String image = object.getString("image");

                        Product product = new Product(name, Productid, description, image);
                        products.add(product);

//                        Intent intent = new Intent(ProductActivity.this,
//                                DetailActivity.class);
//                        startActivity(intent);
//                        finish();
                    }
                    System.out.print(products);

                } catch (Exception e) {

                }
                recyclerView=findViewById(R.id.products_recyclerView);
                mAdapter = new RecyclerAdapter(ProductActivity.this, products);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setLayoutManager(manager);

            }

            },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("MEAW"+error.toString());
                Toast.makeText(ProductActivity.this,error.toString(),Toast.LENGTH_LONG).show();

            }
        });
        System.out.println("lolol");
        Volley.newRequestQueue(ProductActivity.this).add(stringRequest);
        System.out.println("mfrod 5elws");
    }

        }
