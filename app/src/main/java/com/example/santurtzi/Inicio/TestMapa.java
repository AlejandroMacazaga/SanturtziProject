package com.example.santurtzi.Inicio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.santurtzi.R;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.*;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;
import com.mapbox.*;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

public class TestMapa extends AppCompatActivity {

    private MapView mapView;
    private MapboxMap mapboxMap;
    //public MapboxMap mapboxMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this,getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_test_mapa);
        mapView = (MapView) findViewById(R.id.mapView);
        //mapView.getMapAsync(this);

        //xd
        
        
    }



    @Override
    protected void onStart(){
        super.onStart();
        mapView.onStart();
    }


    @Override
    protected void onStop(){
        super.onStop();
        mapView.onStop();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        //mapView.onSaveInstanceState(outState);
    }
    @Override
    public void onLowMemory(){
        super.onLowMemory();
        mapView.onLowMemory();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        mapView.onDestroy();
    }

}