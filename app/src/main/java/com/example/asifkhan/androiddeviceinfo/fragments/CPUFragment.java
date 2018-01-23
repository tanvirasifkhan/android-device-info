package com.example.asifkhan.androiddeviceinfo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asifkhan.androiddeviceinfo.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * A simple {@link Fragment} subclass.
 */
public class CPUFragment extends Fragment {
    private TextView cpuInfo;
    private ProcessBuilder processBuilder;
    private String Holder = "";
    private String[] DATA = {"/system/bin/cat", "/proc/cpuinfo"};
    private InputStream inputStream;
    private Process process ;
    private byte[] byteArray ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_cpu, container, false);
        cpuInfo=(TextView)view.findViewById(R.id.cpuinfo);
        byteArray = new byte[1024];
        try{
            processBuilder = new ProcessBuilder(DATA);

            process = processBuilder.start();

            inputStream = process.getInputStream();

            while(inputStream.read(byteArray) != -1){

                Holder = Holder + new String(byteArray);
            }

            inputStream.close();

        } catch(IOException ex){

            ex.printStackTrace();
        }

        cpuInfo.setText(Holder);
        return view;
    }
}
