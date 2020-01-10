package com.anish.hamrobazarapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TrendingAdsAdapter  extends RecyclerView.Adapter<TrendingAdsAdapter.TrendingAdsViewHolder>  {

    Context mContext;
    List<TrendingAds> treandingAdsList;



    @NonNull
    @Override
    public TrendingAdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_trending,parent,false);
        return new TrendingAdsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdsViewHolder holder, int position) {
        TrendingAds treandingAds=treandingAdsList.get(position);
        holder.imageProduct.setImageResource(treandingAds.getImageId());
        holder.tvType.setText(treandingAds.getType());
        holder.tvProductName.setText(treandingAds.getName());
        holder.tvPrice.setText(treandingAds.getPrice());
    }

    @Override
    public int getItemCount() {
        return treandingAdsList.size();
    }

    public class TrendingAdsViewHolder extends RecyclerView.ViewHolder{

        ImageView imageProduct;
        TextView tvProductName,tvPrice,tvType;
        public TrendingAdsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageProduct=itemView.findViewById(R.id.imageProduct);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            tvProductName=itemView.findViewById(R.id.tvProductName);
            tvType=itemView.findViewById(R.id.tvType);
        }
    }
}
