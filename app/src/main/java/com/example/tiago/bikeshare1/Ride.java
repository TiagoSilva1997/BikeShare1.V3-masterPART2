package com.example.tiago.bikeshare1;

import java.util.Random;
import java.util.UUID;

public class Ride {
    private UUID id;
    private String mBikeName;
    private String mStartRide;
    private String mEndRide;

    public Ride (String mBikeName,String mStartRide,String mEndRide){
        this.mBikeName=mBikeName;
        this.mStartRide=mStartRide;
        this.mEndRide=mEndRide;
    }
    public Ride() {
        id = UUID.randomUUID();
    }

    public String getEndRide() {
        return mEndRide;
    }
    public void setEndRide(String endRide) {
        mEndRide = endRide;
    }
    public String getmBikeName() {
        return mBikeName;
    }

    public void setsBikeName(String mBikeName) {
        this.mBikeName = mBikeName;
    }

    public String getmStartRide()
    {
        return mStartRide;
    }

    public void setsStartRide(String mStartRide) {
        this.mStartRide = mStartRide;
    }

    public String toString(){
        return mBikeName.equals("") && mStartRide.equals("") ? "no ride selected." : mBikeName + " started here: " + mStartRide;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}