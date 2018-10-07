package com.example.miguelangelrubiocaballero.a02geoguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //SwipeController swipeController = null;
    //GeoObjectAdapter mAdapter;
    private boolean isEurope = false;
    private List<GeoObject> mGeoObjects;
    private GeoObject mGeoObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setGeoLocationDataAdapter();
        setupRecyclerView();



    }

    private void setGeoLocationDataAdapter() {




    }

    private void setupRecyclerView() {

    }


}
