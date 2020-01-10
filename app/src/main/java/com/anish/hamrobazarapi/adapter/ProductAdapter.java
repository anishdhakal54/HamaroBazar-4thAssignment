package com.anish.hamrobazarapi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anish.hamrobazarapi.R;
import com.anish.hamrobazarapi.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.Viewholder>  {
    Context context;
    List<Product> productList;

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView tvName, tvPrice, tvCondition;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.imageAd);
            tvName = itemView.findViewById(R.id.tvAdName);
            tvPrice = itemView.findViewById(R.id.tvAdPrice);
            tvCondition = itemView.findViewById(R.id.tvProductType);
        }
    }
}
