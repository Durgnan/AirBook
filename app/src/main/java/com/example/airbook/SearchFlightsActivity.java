package com.example.airbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.example.airbook.adapters.Flight;
import com.example.airbook.adapters.FlightAdapter;
import com.example.airbook.models.DatabaseHelper;

public class SearchFlightsActivity extends AppCompatActivity {
    Flight[] flights= new Flight[6];
    FlightAdapter adapter;
    RecyclerView recyclerView;
    Bundle bundle;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flights);
        //recyclerView = findViewById(R.id.recycler_view);
        bundle = getIntent().getExtras();
        createObjects();
        invokeAdapter();
    }
    public void createObjects()
    {
        flights[0] = new Flight("AIRBUS380","10:30","12:30","Bangalore-BLR","Pune-PNQ","02:00 HRS","Non-Stop");
        flights[1] = new Flight("AIRBUS381","11:30","18:30","Bangalore-BLR","Pune-PNQ","07:00  HRS","1 Stop");
        flights[2] = new Flight("AIRBUS383","13:30","15:30","Bangalore-BLR","Pune-PNQ","02:00  HRS","2 Stops");
        flights[3] = new Flight("AIRBUS456","15:30","20:30","Bangalore-BLR","Pune-PNQ","05:00  HRS","Non-Stop");
        flights[4] = new Flight("AIRBUS457","18:30","22:30","Bangalore-BLR","Pune-PNQ","04:00  HRS","1 Stop");
        flights[5] = new Flight("AIRBUS645","20:00","23:00","Bangalore-BLR","Pune-PNQ","03:00  HRS","Non-Stop");

    }
    public void invokeAdapter()
    {
        String source = bundle.getString("source");
        String destination = bundle.getString("destination");
        Log.e("Message",flights.length+"");
        adapter = new FlightAdapter(getApplicationContext(),flights);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchFlightsActivity.this));

    }
}
