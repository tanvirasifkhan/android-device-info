package com.example.asifkhan.androiddeviceinfo.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asifkhan.androiddeviceinfo.R;
import com.example.asifkhan.androiddeviceinfo.adapters.DeviceDetailsAdapter;
import com.example.asifkhan.androiddeviceinfo.adapters.OSDetailsAdapter;
import com.example.asifkhan.androiddeviceinfo.helpers.DeviceDetailsHelper;
import com.example.asifkhan.androiddeviceinfo.helpers.DeviceInfoHelper;
import com.example.asifkhan.androiddeviceinfo.helpers.OSDetailsHelper;
import com.example.asifkhan.androiddeviceinfo.helpers.OSInfoHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceFragment extends Fragment {
    private RecyclerView deviceDetails;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<DeviceDetailsHelper> deviceDetailsHelpers;
    private DeviceDetailsAdapter deviceDetailsAdapter;

    private String[] detail_titles={
            DeviceInfoHelper.MANUFACTURER_TEXT,DeviceInfoHelper.BRAND_TEXT,DeviceInfoHelper.MODEL_TEXT,
            DeviceInfoHelper.BOARD_TEXT,DeviceInfoHelper.HARDWARE_TEXT,DeviceInfoHelper.USER_TEXT,
            DeviceInfoHelper.HOST_TEXT,DeviceInfoHelper.BOOTLOADER_TEXT,DeviceInfoHelper.SERIAL_TEXT,
            DeviceInfoHelper.SCREEN_RESOLUTION_TEXT
    };

    private String[] detail_values={
            DeviceInfoHelper.MANUFACTURER,DeviceInfoHelper.BRAND,DeviceInfoHelper.MODEL,
            DeviceInfoHelper.BOARD,DeviceInfoHelper.HARDWARE,DeviceInfoHelper.USER,
            DeviceInfoHelper.HOST,DeviceInfoHelper.BOOTLOADER,DeviceInfoHelper.SERIAL,
            DeviceInfoHelper.SCREEN_RESOLUTION
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_device, container, false);
        deviceDetails=(RecyclerView)view.findViewById(R.id.device_details);
        linearLayoutManager=new LinearLayoutManager(getActivity());
        deviceDetailsHelpers=new ArrayList<>();
        deviceDetailsAdapter=new DeviceDetailsAdapter(deviceDetailsHelpers,getActivity());
        deviceDetails.setAdapter(deviceDetailsAdapter);
        deviceDetails.setLayoutManager(linearLayoutManager);
        addDeviceInfos();
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(deviceDetails.getContext(),linearLayoutManager.getOrientation());
        deviceDetails.addItemDecoration(itemDecoration);
        return view;
    }

    //add all the datas
    private void addDeviceInfos(){
        for(int count=0;count<detail_titles.length;count++){
            deviceDetailsHelpers.add(new DeviceDetailsHelper(detail_titles[count],detail_values[count]));
        }
    }
}
