package com.example.asifkhan.androiddeviceinfo.helpers;

/**
 * Created by asifkhan on 1/19/18.
 */

public class DeviceDetailsHelper {
    private String detailTitle,detailValue;

    public DeviceDetailsHelper(String detailTitle, String detailValue) {
        this.detailTitle = detailTitle;
        this.detailValue = detailValue;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public String getDetailValue() {
        return detailValue;
    }
}
