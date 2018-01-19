package com.example.asifkhan.androiddeviceinfo.helpers;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by asifkhan on 1/19/18.
 */

public class DeviceInfoHelper {
    public static final String MANUFACTURER_TEXT="Manufactured By";
    public static final String BRAND_TEXT="Brand";
    public static final String MODEL_TEXT="Device Model";
    public static final String BOARD_TEXT="Board";
    public static final String HARDWARE_TEXT="Hardware";
    public static final String USER_TEXT="User";
    public static final String HOST_TEXT="Host";
    public static final String BOOTLOADER_TEXT="Bootloader";
    public static final String SERIAL_TEXT="Serial No.";
    public static final String SCREEN_RESOLUTION_TEXT="Screen Resolution";

    public static final String MANUFACTURER=Build.MANUFACTURER;
    public static final String BRAND=Build.BRAND;
    public static final String MODEL=Build.MODEL;
    public static final String BOARD=Build.BOARD;
    public static final String HARDWARE=Build.HARDWARE;
    public static final String USER=Build.USER;
    public static final String HOST=Build.HOST;
    public static final String BOOTLOADER=Build.BOOTLOADER;
    public static final String SERIAL=Build.SERIAL;
    public static final String SCREEN_RESOLUTION=fetchDisplay();

    //fetch display resolution
    public static String fetchDisplay(){
        return Resources.getSystem().getDisplayMetrics().heightPixels+
                "x"+Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
