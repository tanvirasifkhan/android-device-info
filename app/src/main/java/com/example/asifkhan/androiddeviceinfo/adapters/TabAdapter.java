package com.example.asifkhan.androiddeviceinfo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.asifkhan.androiddeviceinfo.fragments.BatteryFragment;
import com.example.asifkhan.androiddeviceinfo.fragments.CPUFragment;
import com.example.asifkhan.androiddeviceinfo.fragments.CameraFragment;
import com.example.asifkhan.androiddeviceinfo.fragments.DeviceFragment;
import com.example.asifkhan.androiddeviceinfo.fragments.NetworkFragment;
import com.example.asifkhan.androiddeviceinfo.fragments.OSFragment;
import com.example.asifkhan.androiddeviceinfo.fragments.SensorsFragment;
import com.example.asifkhan.androiddeviceinfo.fragments.StorageFragment;

/**
 * Created by asifkhan on 1/18/18.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private int tabCount;

    public TabAdapter(FragmentManager fm,int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OSFragment();
            case 1:
                return new DeviceFragment();
            case 2:
                return new CPUFragment();
            case 3:
                return new BatteryFragment();
            case 4:
                return new StorageFragment();
            case 5:
                return new CameraFragment();
            case 6:
                return new NetworkFragment();
            case 7:
                return new SensorsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
