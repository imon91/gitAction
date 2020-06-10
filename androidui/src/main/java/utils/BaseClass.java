package utils;


import helper.GetDriverFromCore;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseClass {

    private GetDriverFromCore getDriverFromCore = new GetDriverFromCore();
    // Start AppiumDriverLocalService
    public void startService(){
        getDriverFromCore.startService();
    }
//
//    // Stop AppiumDriverLocalService
    public void stopService(){
        getDriverFromCore.stopService();
    }


    public AndroidDriver<AndroidElement> getDriver(String device,String version)throws Exception{

            return getDriverFromCore.getAndroidDriver(device,version);

    }

}

