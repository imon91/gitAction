package utils;

import helper.GetDriverFromCore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {

    private GetDriverFromCore getDriverFromCore = new GetDriverFromCore();


    public WebDriver getDriver
            (String operating_system, String os_version,String browser,String browser_version)
            throws Exception{
        System.out.println("Control came to getDriver");
        return getDriverFromCore.getChromeDriver(operating_system,os_version,browser,browser_version);

    }
}
