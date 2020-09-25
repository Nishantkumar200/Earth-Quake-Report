package com.example.quakereport;

import java.net.URL;

public class QuakeInformation {

    private long mTimeInMilliseconds;
    private double mMagnitude;
    private String mlocation;
    private String  mURL;


    public QuakeInformation(long mTimeInMilliseconds, double mMagnitude, String mlocation,String url) {
        this.mTimeInMilliseconds = mTimeInMilliseconds;
        this.mMagnitude = mMagnitude;
        this.mlocation = mlocation;
        this.mURL = url;
    }




    public double getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(int mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public String getMlocation() {
        return mlocation;
    }

    public void setMlocation(String mlocation) {
        this.mlocation = mlocation;
    }

    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public void setmTimeInMilliseconds(long mTimeInMilliseconds) {
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }


    public String getmURL() {
        return mURL;
    }
}
