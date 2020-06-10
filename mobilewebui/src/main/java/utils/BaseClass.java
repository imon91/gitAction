package utils;

import helper.GetDriverFromCore;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;

import java.net.ServerSocket;
import java.net.URL;

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


    public AndroidDriver<WebElement> getDriver(String device,String version)throws Exception{
        System.out.println("Control came to getDriver");
        return getDriverFromCore.getAndroidDriverForChrome(device,version);

    }
}
