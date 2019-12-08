package com.example.airbook.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airbook.FlightDetails;
import com.example.airbook.R;

public class FlightViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    Context context;
    TextView id,eta,etd,duration,stops,source,destination;

    public FlightViewHolder(@NonNull View itemView,Context context) {
        super(itemView);
        id = itemView.findViewById(R.id.flight_id);
        eta = itemView.findViewById(R.id.flight_eta);
        etd = itemView.findViewById(R.id.flight_etd);
        duration = itemView.findViewById(R.id.flight_duration);
        stops = itemView.findViewById(R.id.flight_stop);
        source = itemView.findViewById(R.id.flight_source);
        destination = itemView.findViewById(R.id.flight_destination);
        this.context=context;
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), FlightDetails.class).putExtra("id",id.getText());
        v.getContext().startActivity(i);
    }
}
