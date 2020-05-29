package com.shopup.utils;

import io.appium.java_client.android.AndroidElement;

public class MyActions {

    public void action_click(AndroidElement element){
        element.click();
    }

    public void action_sendKeys(AndroidElement element, String data){
        CommonUtils.threadSleep(3000);
        element.sendKeys(data);
    }

    public String action_getText(AndroidElement element){
        CommonUtils.threadSleep(1000);
        return element.getText();
    }

    public String action_getTagName(AndroidElement element){
        CommonUtils.threadSleep(1000);
        return element.getTagName();
    }
}
