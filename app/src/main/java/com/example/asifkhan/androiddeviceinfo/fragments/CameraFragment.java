package com.example.asifkhan.androiddeviceinfo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asifkhan.androiddeviceinfo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_camera, container, false);
        return view;
    }
}
