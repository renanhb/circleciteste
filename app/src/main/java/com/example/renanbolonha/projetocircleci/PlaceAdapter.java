package com.example.renanbolonha.projetocircleci;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyViewHolder> {

    private List<Place> items;

    public PlaceAdapter(List<Place> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Place place = items.get(position);
        holder.bind(place);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textId;
        TextView textName;

        public MyViewHolder(View itemView) {
            super(itemView);
            textId = itemView.findViewById(R.id.text_id);
            textName = itemView.findViewById(R.id.text_name);
        }

        public void bind(Place place) {
            textId.setText(String.valueOf(place.getId()));
            textName.setText(place.getName());
        }
    }
}
