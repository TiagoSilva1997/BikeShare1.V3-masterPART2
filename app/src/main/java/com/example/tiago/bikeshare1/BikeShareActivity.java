package com.example.tiago.bikeshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class BikeShareActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, RideArrayAdapter.onItemClickListener{



    private Button StartRide;
    private Button EndRide;
    private static RidesDB sRidesDB;
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;


    private Ride newRide = new Ride("", "" ,"");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_share);
        sRidesDB = RidesDB.get(this);

        RecyclerView recyclerView = findViewById(R.id.rv_item_list);
        List <Ride> values = sRidesDB.getRidesDB();
        RideArrayAdapter adapter = new RideArrayAdapter(this,values);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemClickListener(BikeShareActivity.this);

        //    mAdapter = new RideArrayAdapter(this,values);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_item_list);
        //  mRecyclerView.setAdapter((ListAdapter) mAdapter);
        StartRide = (Button) findViewById(R.id.start_ride);
        EndRide = (Button) findViewById(R.id.end_ride);
        StartRide.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             Intent intent = StartRideActivity.newIntent(BikeShareActivity.this);
                                             startActivity(intent);
                                         }
                                     }
        );
        EndRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = EndRideActivity.newIntent(BikeShareActivity.this);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemClick(int position) {

    }
}
