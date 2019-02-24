package com.example.tiago.bikeshare1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

//VIDEO YOUTUBE




public class RideArrayAdapter extends RecyclerView.Adapter<RideArrayAdapter.myViewHolder>  {
    private onItemClickListener mListener;

    public interface onItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener){
        mListener=listener;
    }
    Context mContext;
    List<Ride> mData;


    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView SR_tv,ER_tv,BN_tv;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            SR_tv = (TextView)  itemView.findViewById(R.id.start_ride);
            ER_tv = (TextView)  itemView.findViewById(R.id.end_ride);
            BN_tv = (TextView)  itemView.findViewById(R.id.what_bike_ride);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(mListener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public View getView(int position, View concertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_ride, parent, false);
        TextView bikeView = (TextView) rowView.findViewById(R.id.what_bike_ride);
        bikeView.append(mData.get(position).getmBikeName());
        return rowView;
    }
    public RideArrayAdapter(Context mContext, List<Ride> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override

    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.list_item_ride,viewGroup,false);
        return new myViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.SR_tv.setText(mData.get(position).getmStartRide());
        holder.ER_tv.setText(mData.get(position).getEndRide());
        holder.BN_tv.setText(mData.get(position).getmBikeName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    // private final Context mContext;
    // private final List<Ride> mValues;





// VIDEO YOUTUBE

















    //   public RideArrayAdapter(Context context, List<Ride> values) {
    //      super(context, R.layout.list_item_ride, values);
    //       mContext = context;
    //       mValues = values;
    //   }


}


