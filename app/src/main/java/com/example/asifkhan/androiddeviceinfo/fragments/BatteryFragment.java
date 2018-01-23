package com.example.asifkhan.androiddeviceinfo.fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dinuscxj.progressbar.CircleProgressBar;
import com.example.asifkhan.androiddeviceinfo.R;
import com.example.asifkhan.androiddeviceinfo.adapters.BatteryDetailsAdapter;
import com.example.asifkhan.androiddeviceinfo.helpers.BatteryDetailsHelper;
import com.example.asifkhan.androiddeviceinfo.helpers.BatteryInfoHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BatteryFragment extends Fragment {
    private RecyclerView batteryInfo;
    private TextView batteryTitle;
    private LinearLayoutManager linearLayoutManager;
    private BatteryDetailsAdapter batteryDetailsAdapter;
    private ArrayList<BatteryDetailsHelper> batteryDetailsHelpers;
    private BatteryReceiver batteryReceiver;
    private CircleProgressBar circleProgressBar;
    private String batteryType,batteryLevel,batteryPowerSource,
            batteryTemperature,batteryVoltage,batteryStatus;


    private String[] detailTitles={
            BatteryInfoHelper.BATTERY_LEVEL_TEXT,BatteryInfoHelper.BATTERY_TYPE_TEXT,
            BatteryInfoHelper.POWER_SOURCE_TEXT,BatteryInfoHelper.BATTERY_TEMPERATURE_TEXT,
            BatteryInfoHelper.BATTERY_VOLTAGE_TEXT,BatteryInfoHelper.BATTERY_STATUS
    };

    private String[] detailValues={
            batteryLevel,batteryType,batteryPowerSource,batteryTemperature,batteryVoltage,batteryStatus
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_battery, container, false);
        batteryInfo=(RecyclerView)view.findViewById(R.id.battery_info);
        circleProgressBar=(CircleProgressBar)view.findViewById(R.id.progress);
        batteryTitle=(TextView)view.findViewById(R.id.battery);
        batteryDetailsHelpers=new ArrayList<>();
        batteryDetailsAdapter=new BatteryDetailsAdapter(batteryDetailsHelpers,getActivity());
        linearLayoutManager=new LinearLayoutManager(getActivity());
        batteryInfo.setAdapter(batteryDetailsAdapter);
        batteryInfo.setLayoutManager(linearLayoutManager);
        addBatteryInfos();
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(batteryInfo.getContext(),linearLayoutManager.getOrientation());
        batteryInfo.addItemDecoration(itemDecoration);
        batteryReceiver=new BatteryReceiver();
        getActivity().registerReceiver(batteryReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        return view;
    }

    //add all the battery infos
    private void addBatteryInfos(){
        for(int count=0;count<detailTitles.length;count++){
            batteryDetailsHelpers.add(new BatteryDetailsHelper(detailTitles[count],detailValues[count]));
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().registerReceiver(batteryReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().unregisterReceiver(batteryReceiver);
    }

    class BatteryReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale=intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
            float percent=level/(float)scale*100;
            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            float temperature=(float)(intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0))/10;
            float firehnhite=(temperature*(9/5))+32;
            float voltage=(float)(intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,0)*0.001);
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

            circleProgressBar.setProgressTextSize(50);
            circleProgressBar.setProgress((int)percent);
            circleProgressBar.setBackgroundColor(Color.WHITE);
            circleProgressBar.setProgressBackgroundColor(getResources().getColor(R.color.colorPrimary));
            circleProgressBar.setProgressTextColor(getResources().getColor(R.color.colorPrimary));

            batteryLevel=String.valueOf(percent+" %");
            batteryType=intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY)+ " Battery";
            batteryTitle.setText(batteryType);
            batteryPowerSource=powerSource(chargePlug);
            batteryTemperature=String.valueOf(temperature +" "+(char)0x00B0+"C"+" / " + firehnhite + " " + (char)0x00B0+"F");
            batteryVoltage=String.valueOf(voltage+" v");
            batteryStatus=getBatteryStatus(status);
        }
    }

    // determining battery power source
    private String powerSource(int plug){
        switch (plug){
            case BatteryManager.BATTERY_PLUGGED_AC:
                return "AC";
            case BatteryManager.BATTERY_PLUGGED_USB:
                return "USB";
            case BatteryManager.BATTERY_PLUGGED_WIRELESS:
                return "Wireless";
            default:
                return "Battery";
        }
    }

    //determining battery status
    private String getBatteryStatus(int status){
        switch (status){
            case BatteryManager.BATTERY_STATUS_DISCHARGING:
                return "Discharging";
            case BatteryManager.BATTERY_STATUS_CHARGING:
                return "Charging";
            case BatteryManager.BATTERY_STATUS_FULL:
                return "Full";
            case BatteryManager.BATTERY_STATUS_UNKNOWN:
                return "Unknown";
            case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                return "Not charging";
            default:
                return "Unknown";
        }
    }
}
