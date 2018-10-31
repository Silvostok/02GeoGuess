package com.example.miguelangelrubiocaballero.a02geoguess;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GeoObjectAdapter extends RecyclerView.Adapter<GeoObjectViewHolder>{

   private Context context;
   public List<GeoObject> listGeoObject;

    // Provide a suitable constructor (depends on the kind of dataset)
    public GeoObjectAdapter(List<GeoObject> listGeoObject) {

        this.listGeoObject = listGeoObject;
    }


    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public GeoObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new GeoObjectViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull GeoObjectViewHolder holder, int position) {
        // Gets a single item in the list from its position
        final GeoObject geoObject = listGeoObject.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.geoImage.setImageResource(geoObject.getmGeoImageName());
    }

    // Return the size of the of de geo objects
    @Override
    public int getItemCount() {
        return listGeoObject.size();
    }


}
