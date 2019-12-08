package com.example.airbook.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Health.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Flight ( flight_ID integer PRIMARY KEY AUTOINCREMENT, airline TEXT, source TEXT, dest TEXT );");
        sqLiteDatabase.execSQL("CREATE TABLE Airport ( airport_ID integer PRIMARY KEY AUTOINCREMENT, city TEXT, dest TEXT );");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LAB ");
        onCreate(sqLiteDatabase);
    }

    public boolean insert() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        ContentValues cv1 = new ContentValues();

        List<String> source = new ArrayList<String>();
        List<String> dest = new ArrayList<>();
        List<String> airline = new ArrayList<String>();
        List<String> airport_city = new ArrayList<>();

        source.add("Hyderabad");
        source.add("Bangalore");
        source.add("Hubli");
        source.add("Chennai");
        source.add("Kochi");
        source.add("Vizag");

        dest.add("Vizag");
        dest.add("Chennai");
        dest.add("Kochi");
        dest.add("Hyderabad");
        dest.add("Bangalore");
        dest.add("Hubli");

        airline.add("Spicejet");
        airline.add("Indigo");
        airline.add("Air India");
        airline.add("Air Asia");
        airline.add("GoAir");
        airline.add("Indigo");

        airport_city.add("Vizag");
        airport_city.add("Chennai");
        airport_city.add("Kochi");
        airport_city.add("Hyderabad");
        airport_city.add("Bangalore");
        airport_city.add("Hubli");

        for(int i=0;i<6;i++)
        {
            cv.put("airline", airline.get(i));
            cv.put("source", source.get(i));
            cv.put("dest", dest.get(i));
            long status = db.insert("Flight", null, cv);
            cv1.put("city", airport_city.get(i));

        }

        return true;
    }

    public Cursor search(String src, String dstn) {
        String columns[] = {"flight_ID, airline, source, dest"};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.query("Flight", columns, "source = ? and dest = ?", new String[]{src, dstn}, null, null   , null);
        return cr;
    }
}

