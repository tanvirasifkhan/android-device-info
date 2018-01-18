package com.example.asifkhan.androiddeviceinfo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asifkhan.androiddeviceinfo.R;
import com.example.asifkhan.androiddeviceinfo.helpers.OSDetailsHelper;

import java.util.ArrayList;

/**
 * Created by asifkhan on 1/19/18.
 */

public class OSDetailsAdapter extends RecyclerView.Adapter<OSDetailsAdapter.DataHolder> {
    private ArrayList<OSDetailsHelper> osDetailsHelpers;
    private Context context;

    public OSDetailsAdapter(ArrayList<OSDetailsHelper> osDetailsHelpers, Context context) {
        this.osDetailsHelpers = osDetailsHelpers;
        this.context = context;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_os_details_layout,parent,false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        OSDetailsHelper osDetailsHelper=osDetailsHelpers.get(position);
        holder.detailTitle.setText(osDetailsHelper.getDetailTitle());
        holder.detailValue.setText(String.valueOf(osDetailsHelper.getDetailValue()));
    }

    @Override
    public int getItemCount() {
        return osDetailsHelpers.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder{
        TextView detailTitle,detailValue;
        public DataHolder(View itemView) {
            super(itemView);
            detailTitle=(TextView)itemView.findViewById(R.id.os_detail_title);
            detailValue=(TextView)itemView.findViewById(R.id.os_detail_value);
        }
    }
}
