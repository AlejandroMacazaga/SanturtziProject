package com.example.santurtzi.Inicio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.santurtzi.R;
import com.google.gson.JsonObject;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;
import com.mapbox.mapboxsdk.maps.MapboxMap;



import android.os.Bundle;

public class TestMapa extends AppCompatActivity {

    private MapView mapView;
    private CarmenFeature home;
    private LatLng point;
    public MapboxMap mapboxMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this,getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_test_mapa);
        mapView = (MapView) findViewById(R.id.mapView);



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