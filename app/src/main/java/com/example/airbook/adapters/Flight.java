package com.example.airbook.adapters;

public class Flight {
    String flight_id, ETD,ETA,source,destination,duration,stops;

    public Flight(String flight_id, String ETD, String ETA, String source, String destination, String duration, String stops) {
        this.flight_id = flight_id;
        this.ETD = ETD;
        this.ETA = ETA;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.stops = stops;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public String getETD() {
        return ETD;
    }

    public String getETA() {
        return ETA;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDuration() {
        return duration;
    }

    public String getStops() {
        return stops;
    }
}
