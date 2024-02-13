package com.example.weatherapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherapp.Domains.FutureDomain;
import com.example.weatherapp.Domains.Hourly;
import com.example.weatherapp.R;

import java.util.ArrayList;

public class FutureAdapter extends RecyclerView.Adapter<FutureAdapter.ViewHolder> {
    ArrayList<FutureDomain> items;
    Context context;

    public FutureAdapter(ArrayList<FutureDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FutureAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_feture, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FutureAdapter.ViewHolder holder, int position) {

    holder.dayTxt.setText(items.get(position).getDay());
    holder.statusTxt.setText(items.get(position).getStatus());
    holder.lowTxt.setText(items.get(position).getLowTemp()+"°");
    holder.highTxt.setText(items.get(position).getHighTemp()+"°");

        int drawabelResourceId=holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawabelResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dayTxt, statusTxt, lowTxt, highTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lowTxt = itemView.findViewById(R.id.lowTxt);
            dayTxt = itemView.findViewById(R.id.dayTxt);
            pic = itemView.findViewById(R.id.pic);
            highTxt = itemView.findViewById(R.id.highTxt);
            statusTxt = itemView.findViewById(R.id.statusTxt);
        }
    }
}
