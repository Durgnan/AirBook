package com.example.airbook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airbook.R;

public class FlightAdapter extends RecyclerView.Adapter<FlightViewHolder> {
    Context context;
    Flight[] flights;

    public FlightAdapter(Context context, Flight[] flights) {
        this.context = context;
        this.flights = flights;
    }

    @NonNull
    @Override
    public FlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View flightView = inflater.inflate(R.layout.flights_card,parent,false);
        FlightViewHolder flightViewHolder=new FlightViewHolder(flightView,this.context);
        return flightViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FlightViewHolder holder, int position) {
        holder.id.setText(flights[position].getFlight_id());
        holder.etd.setText(flights[position].getETD());
        holder.eta.setText(flights[position].getETA());
        holder.source.setText(flights[position].getSource());
        holder.destination.setText(flights[position].getDestination());
        holder.duration.setText(flights[position].getDuration());
        holder.stops.setText(flights[position].getStops());
    }

    @Override
    public int getItemCount() {
        return flights.length;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
