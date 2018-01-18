package com.example.asifkhan.androiddeviceinfo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asifkhan.androiddeviceinfo.R;
import com.example.asifkhan.androiddeviceinfo.adapters.OSDetailsAdapter;
import com.example.asifkhan.androiddeviceinfo.helpers.OSDetailsHelper;
import com.example.asifkhan.androiddeviceinfo.helpers.OSInfoHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OSFragment extends Fragment {
    private RecyclerView osDetails;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<OSDetailsHelper> osDetailsHelpers;
    private OSDetailsAdapter osDetailsAdapter;
    private ImageView osImage;
    private TextView osName;

    private String[] detail_titles={
            OSInfoHelper.VERSION_TEXT,OSInfoHelper.VERSION_NAME,OSInfoHelper.VERSION_API,
            OSInfoHelper.BUILD_ID_TEXT,OSInfoHelper.KERNEL_TEXT,OSInfoHelper.FINGERPRINT_TEXT
    };

    private String[] detail_values={
            OSInfoHelper.OS_VERSION,OSInfoHelper.OS_NAME,String.valueOf(OSInfoHelper.OS_API),
            OSInfoHelper.OS_BUILD_ID,OSInfoHelper.OS_KERNEL,OSInfoHelper.OS_FINGERPRINT
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_os, container, false);
        osDetails=(RecyclerView)view.findViewById(R.id.os_details);
        osImage=(ImageView)view.findViewById(R.id.os_img);
        osName=(TextView)view.findViewById(R.id.os_title);
        linearLayoutManager=new LinearLayoutManager(getActivity());
        osDetailsHelpers=new ArrayList<>();
        osDetailsAdapter=new OSDetailsAdapter(osDetailsHelpers,getActivity());
        osDetails.setAdapter(osDetailsAdapter);
        osDetails.setLayoutManager(linearLayoutManager);
        addOSInfos();
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(osDetails.getContext(),linearLayoutManager.getOrientation());
        osDetails.addItemDecoration(itemDecoration);
        osName.setText(OSInfoHelper.PRINT_OS_NAME_VERSION);
        osImage.setImageResource(OSInfoHelper.fetchOSImg());
        return view;
    }

    //add all the datas
    private void addOSInfos(){
        for(int count=0;count<detail_titles.length;count++){
            osDetailsHelpers.add(new OSDetailsHelper(detail_titles[count],detail_values[count]));
        }
    }
}
