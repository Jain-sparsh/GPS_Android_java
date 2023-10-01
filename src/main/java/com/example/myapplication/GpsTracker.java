package com.example.myapplication;


import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.List;

/**
 * Created by shiva on 8/4/17.
 */

public class GpsTracker implements LocationListener {

    Context context;

    public GpsTracker(Context c) {

        context = c;
    }
public Location getLocation(){

    if (ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
        Toast.makeText(context,"permission not granted",Toast.LENGTH_SHORT).show();
        return null;
    }
    LocationManager lm=(LocationManager)context.getSystemService(Context.LOCATION_SERVICE);

    boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    if (isGPSEnabled){
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000,10,this);

        Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        return l;


    }else{
        Toast.makeText(context,"please enable gps",Toast.LENGTH_LONG).show();
    }
return null;

    }
    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {
        LocationListener.super.onLocationChanged(locations);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        LocationListener.super.onStatusChanged(provider, status, extras);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }
}