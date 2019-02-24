package com.example.tiago.bikeshare1;



import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Adapter;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;
import java.util.UUID;

public class BikeShareFragment extends Fragment implements AdapterView.OnItemClickListener, RideArrayAdapter.onItemClickListener {



    private Button StartRide;
    private Button EndRide;
    private static RidesDB sRidesDB;
    private ListView mRecyclerView;
    private Adapter mAdapter;
    private Ride mride;


    private Ride newRide = new Ride("", "" ,"");
    private static final String ARG_RIDE_ID = "com.bignerdranch.android.bikeshare.ride_id";

    public static BikeShareFragment newInstance(UUID rideID){
        Bundle args = new Bundle();
        args.putSerializable(ARG_RIDE_ID, rideID);

        BikeShareFragment fragment = new BikeShareFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID rideID = (UUID) getArguments().getSerializable("ARG_RIDE_ID");
        mride = RidesDB.get(getActivity()).getRide(rideID);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bike_share,container,false);
        RecyclerView recyclerView = v.findViewById(R.id.rv_item_list);
        List <Ride> values = sRidesDB.getRidesDB();
        RideArrayAdapter adapter = new RideArrayAdapter(getActivity(),values);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setOnItemClickListener(BikeShareFragment.this);

        //    mAdapter = new RideArrayAdapter(this,values);
        mRecyclerView = (ListView) v.findViewById(R.id.rv_item_list);
        //  mRecyclerView.setAdapter((ListAdapter) mAdapter);
        StartRide = (Button) v.findViewById(R.id.start_ride);
        EndRide = (Button) v.findViewById(R.id.end_ride);
        StartRide.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             Intent intent = StartRideActivity.newIntent(getActivity());
                                             startActivity(intent);
                                         }
                                     }
        );
        EndRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = EndRideActivity.newIntent(getActivity());
                startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemClick(int position) {

    }
}
