package activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.MainActivity;
import com.example.shoppingapp.R;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<Product> products = new ArrayList<>();

    public  RecyclerAdapter (Context context, List<Product> products){
        this.mContext = context;
        this.products = products;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_list_item_layout,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Product product=products.get(position);
        System.out.println(product.toString());
        System.out.println("meawww "+product.getName());
        holder.name.setText(product.getName());
//        holder.Productid.setText(product.getProductid());
     holder.description.setText(product.getDescription());
      // holder.image.setImageResource(product.getImage());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public Object mImageView;
       // public BreakIterator specialoffer;
        private TextView name,description,Productid;
        private LinearLayout productIntent;
        private ImageView image;
        private final Context context;

        public MyViewHolder (View view){
            super(view);

            name=view.findViewById(R.id.product_title);
            productIntent = view.findViewById(R.id.product_btn);

            context = itemView.getContext();


            productIntent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, DetailActivity.class);
                    context.startActivity(intent);
                }
            });

         description=view.findViewById(R.id.product_description);
//            Productid=view.findViewById(R.id.product_id);
//            image=view.findViewById(R.id);

        }


    }


}
