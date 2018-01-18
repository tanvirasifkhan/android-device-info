package com.example.asifkhan.androiddeviceinfo.helpers;

import android.os.Build;

import com.example.asifkhan.androiddeviceinfo.R;

/**
 * Created by asifkhan on 1/19/18.
 */

public class OSInfoHelper {
    public static final String VERSION_TEXT="Version";
    public static final String VERSION_NAME="Version Name";
    public static final String VERSION_API="API Level";
    public static final String BUILD_ID_TEXT="Build ID";
    public static final String FINGERPRINT_TEXT="Fingerprint";
    public static final String KERNEL_TEXT="Kernel";

    public static final String OS_VERSION= Build.VERSION.RELEASE;
    public static final String OS_NAME=fetchOSName();
    public static final int OS_API=Build.VERSION.SDK_INT;
    public static final String OS_BUILD_ID=Build.ID;
    public static final String OS_KERNEL=System.getProperty("os.name")+" " + System.getProperty("os.version");
    public static final String OS_FINGERPRINT=Build.FINGERPRINT;
    public static final String PRINT_OS_NAME_VERSION=OSInfoHelper.OS_NAME+" "+OSInfoHelper.OS_VERSION;

    //fetch os logo
    public static int fetchOSImg(){
        switch (Build.VERSION.SDK_INT){
            case 16:
                return R.drawable.jelly_bean;
            case 17:
                return R.drawable.jelly_bean;
            case 18:
                return R.drawable.jelly_bean;
            case 19:
                return R.drawable.android_kitkat;
            case 20:
                return R.drawable.android_kitkat;
            case 21:
                return R.drawable.android_lollipop;
            case 22:
                return R.drawable.android_lollipop;
            case 23:
                return R.drawable.marshmallow;
            case 24:
                return R.drawable.nougat;
            case 25:
                return R.drawable.nougat;
            case 26:
                return R.drawable.oreo;
            default:
                return R.drawable.default_img;
        }
    }

    //fetch the os name
    private static String fetchOSName(){
        switch (Build.VERSION.SDK_INT){
            case 16:
                return "Jelly Bean";
            case 17:
                return "Jelly Bean MR1";
            case 18:
                return "Jelly Bean MR2";
            case 19:
                return "Kitkat";
            case 20:
                return "Kitkat Watch";
            case 21:
                return "Lollipop";
            case 22:
                return "Lollipop MR1";
            case 23:
                return "Mashmallow";
            case 24:
                return "Nougat";
            case 25:
                return "Nougat MR1";
            case 26:
                return "Oreo";
            default:
                return "not found !";

        }
    }
}
