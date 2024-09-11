package com.map;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


import android.util.Log;

public class MapMarker extends ReactContextBaseJavaModule {
    MapMarker(ReactApplicationContext context){
        super(context);
    }

    @Override 
    public String getName(){
        return "MapMarker";
    }

    @ReactMethod
    public void MarkerEvent(String name , String location){
     
    }
}
