package com.project.koslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class KostAdapter extends RecyclerView.Adapter<KostAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Kost> kostArrayList;

    public KostAdapter(Context ctx, ArrayList<Kost> kostArrayList){
        this.ctx = ctx;
        this.kostArrayList = kostArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.kost_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Kost kost = kostArrayList.get(position);

//        Load image
        Glide.with(ctx).load(kost.kosThumbnail).into(holder.kostThumbnail);

        holder.kostName.setText(kost.getKosName());
        holder.kostFacilities.setText(kost.getKosFacility());
        holder.kostPrice.setText("Rp. " + String.valueOf(kost.getKosPrice()) + ",-");

    }

    @Override
    public int getItemCount() {
        return kostArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView kostThumbnail;
        TextView kostName;
        TextView kostPrice;
        TextView kostFacilities;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            kostThumbnail = itemView.findViewById(R.id.kosThumbnail);
            kostName = itemView.findViewById(R.id.kosName);
            kostPrice = itemView.findViewById(R.id.kosPrice);
            kostFacilities = itemView.findViewById(R.id.kosFacility);

        }
    }
}
