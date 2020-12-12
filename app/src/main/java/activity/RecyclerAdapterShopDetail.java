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

import com.example.shoppingapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterShopDetail extends  RecyclerView.Adapter<RecyclerAdapterShopDetail.MyViewHolder> {

    private Context mContext;
    private List<ShopDetail> details = new ArrayList<>();

    public RecyclerAdapterShopDetail(Context context, List<ShopDetail> details){
        this.mContext = context;
        this.details = details;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_list_item_layout_detail,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ShopDetail detail=details.get(position);

        System.out.println(detail.toString());
        System.out.println("xdxdxd "+detail.toString());
        holder.name.setText(detail.getName());
        holder.price.setText(detail.getPrice());
     holder.Productid.setText(detail.getProductId());
     holder.longtitude.setText((int) detail.getLongtitude());
     holder.latitude.setText((int) detail.getLatitude());
     holder.SpecialOffer.setText(detail.getSpecialOffer());
//     holder.description.setText(product.getDescription());
      // holder.image.setImageResource(product.getImage());
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public Object mImageView;
       // public BreakIterator specialoffer;
        private TextView name,price,Productid,SpecialOffer;
        private LinearLayout productIntent;
        private TextView longtitude;
        private TextView latitude;
        private final Context context;

        public MyViewHolder (View view){
            super(view);

            name=view.findViewById(R.id.detail_title);

            name.setText("LOLOL");
//            productIntent = view.findViewById(R.id.product_btn);

            context = itemView.getContext();


            productIntent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, DetailActivity.class);
                    context.startActivity(intent);
                }
            });

//         description=view.findViewById(R.id.product_description);
//            Productid=view.findViewById(R.id.product_id);
//            image=view.findViewById(R.id);

        }


    }


}
