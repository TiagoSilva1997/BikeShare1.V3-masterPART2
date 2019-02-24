package com.example.tiago.bikeshare1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartRideActivity extends AppCompatActivity {

    private TextView mLastAdded;
    private TextView mWhatBike;
    private TextView mWhere;
    private Button StartRide;
    private Ride newRide = new Ride("", "", "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ride);

        mLastAdded = (TextView) findViewById(R.id.last_added);
        updateUI();
        mWhatBike = (TextView) findViewById(R.id.what_bike);
        mWhere = (TextView) findViewById(R.id.where);
        StartRide = (Button) findViewById(R.id.buttonPanel);

        StartRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mWhatBike.getText().length() > 0) && (mWhere.getText().length() > 0)) {
                    newRide.setsBikeName(mWhatBike.getText().toString().trim());
                    newRide.setsStartRide(mWhere.getText().toString().trim());
                    mWhatBike.setText("");
                    mWhere.setText("");
                    updateUI();
                }
            }
        });
    }

    private void updateUI() {
        mLastAdded.setText(newRide.toString());
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, StartRideActivity.class);
        return intent;
    }
}
