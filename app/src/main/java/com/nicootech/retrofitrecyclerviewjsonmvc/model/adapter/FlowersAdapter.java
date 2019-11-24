package com.nicootech.retrofitrecyclerviewjsonmvc.model.adapter;

import android.provider.SyncStateContract;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nicootech.retrofitrecyclerviewjsonmvc.R;
import com.nicootech.retrofitrecyclerviewjsonmvc.model.pojo.Flower;
import com.squareup.picasso.Picasso;



import java.util.List;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.Holder> {

    public static String TAG = FlowersAdapter.class.getSimpleName();

    private List<Flower> mFlowers;

    public FlowersAdapter(List<Flower> flowers) {
        mFlowers = flowers;
    }

    public void addFlower(Flower flower) {
        mFlowers.add(flower);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Flower currentFlower = mFlowers.get(position);
        holder.mName.setText(currentFlower.mName);
        holder.mCategory.setText(currentFlower.mCategory);
        holder.mPrice.setText(Double.toString(currentFlower.mPrice));
        holder.mInstructions.setText(currentFlower.mInstructions);

        Picasso.with(holder.itemView.getContext()).load(SyncStateContract.Constants._ID
        + currentFlower.mPhoto).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mFlowers.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView mName, mCategory, mPrice, mInstructions;
        public ImageView mImage;

        public Holder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.flowerImage);
            mName = itemView.findViewById(R.id.flowerName);
            mCategory =itemView.findViewById(R.id.flowerCategory);
            mPrice =  itemView.findViewById(R.id.flowerPrice);
            mInstructions = itemView.findViewById(R.id.flowerInstruction);
        }
    }
}