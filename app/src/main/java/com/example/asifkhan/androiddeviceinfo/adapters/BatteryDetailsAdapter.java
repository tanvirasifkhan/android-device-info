package com.example.asifkhan.androiddeviceinfo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asifkhan.androiddeviceinfo.R;
import com.example.asifkhan.androiddeviceinfo.helpers.BatteryDetailsHelper;

import java.util.ArrayList;

/**
 * Created by asifkhan on 1/19/18.
 */

public class BatteryDetailsAdapter extends RecyclerView.Adapter<BatteryDetailsAdapter.DataHolder> {
    private ArrayList<BatteryDetailsHelper> batteryDetailsHelpers;
    private Context context;

    public BatteryDetailsAdapter(ArrayList<BatteryDetailsHelper> batteryDetailsHelpers, Context context) {
        this.batteryDetailsHelpers = batteryDetailsHelpers;
        this.context = context;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_battery_details_layout,parent,false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        BatteryDetailsHelper batteryDetailsHelper=batteryDetailsHelpers.get(position);
        holder.detailTitle.setText(batteryDetailsHelper.getDetailTitle());
        holder.detailValue.setText(String.valueOf(batteryDetailsHelper.getDetailValue()));
    }

    @Override
    public int getItemCount() {
        return batteryDetailsHelpers.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder{
        TextView detailTitle,detailValue;
        public DataHolder(View itemView) {
            super(itemView);
            detailTitle=(TextView)itemView.findViewById(R.id.battery_detail_title);
            detailValue=(TextView)itemView.findViewById(R.id.battery_detail_value);
        }
    }
}
