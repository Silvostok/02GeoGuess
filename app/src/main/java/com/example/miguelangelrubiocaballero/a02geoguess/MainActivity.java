package com.example.miguelangelrubiocaballero.a02geoguess;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // initialize variables
    SwipeController swipeController = null;
    GeoObjectAdapter mAdapter;
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

    // setup Adapter for GeoLocation
    private void setGeoLocationDataAdapter() {
        mGeoObjects = new ArrayList<>();
        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS.length; i++) {
            mGeoObjects.add(new GeoObject(i));
        }
        mAdapter = new GeoObjectAdapter(mGeoObjects);
    }

    // setup recycler view
    private void setupRecyclerView() {

        RecyclerView mGeoRecyclerView = findViewById(R.id.recyclerview);

        mGeoRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mGeoRecyclerView.setAdapter(mAdapter);

        swipeController = new SwipeController(new SwipeControllerActions() {

            @Override
            public void onRightClicked(int position) {
                mGeoObject = mGeoObjects.get(position);
                if (!mGeoObject.getIsEurope()) {
                    mAdapter.listGeoObject.remove(position);
                    mAdapter.notifyItemRemoved(position);
                    mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
                    Toast.makeText(MainActivity.this, "Yess correct",Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this, "Not correct", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLeftClicked(int position) {
                mGeoObject = mGeoObjects.get(position);
                if (mGeoObject.getIsEurope()){
                    mAdapter.listGeoObject.remove(position);
                    mAdapter.notifyItemRemoved(position);
                    mAdapter.notifyItemRangeChanged(position,mAdapter.getItemCount());
                    Toast.makeText(MainActivity.this,"Yess correct",Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this, "Not correct", Toast.LENGTH_SHORT).show();

            }
        });

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(mGeoRecyclerView);

        mGeoRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });

    }


}
