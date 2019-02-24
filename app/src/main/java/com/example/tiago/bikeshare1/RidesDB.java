package com.example.tiago.bikeshare1;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class RidesDB {

    private static RidesDB sRidesDB;
    private ArrayList<Ride> mAllRides;
    private Ride mLastRide;

    private RidesDB(Context context) {
        mLastRide = new Ride("", "", "");
        mAllRides = new ArrayList<>();
        mAllRides.add(new Ride("Chuck Norris bike", "ITU", "Fields"));
        mAllRides.add(new Ride("Chuck Norris bike", "Fields", " ,  Kongens Nytorv"));
        mAllRides.add(new Ride("Bruce Lee bike", "Kobenhavns ,  Lufthavn", "Kobenhavns Hovedbanegard"));

    }

    public static RidesDB get(Context context) {
        if (sRidesDB == null)
            sRidesDB = new RidesDB(context);
        return sRidesDB;
    }

    public List<Ride> getRidesDB() {
        return mAllRides;
    }

    public void addRide(String what, String where) {
        // Implement your code here }
    }

    public void endRide(String what, String where) {
        // Implement your code here }
    }
    public Ride getRide(UUID id) {
        for (Ride ride : mAllRides) {
            if (ride.getId().equals(id)) {
                return ride;
            }
        }
        return null;
    }
}