package smokeTests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.DriverControls;

public class SmokeTests extends BaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private DriverControls driverControls;
    private String host;


    @BeforeSuite
    public void smokeSetUp() throws Exception{
        host = System.getProperty("Host");
        System.out.println("Host is :"+host);
        if(host.equalsIgnoreCase("local")){
            // 1 : Start Appium Service
            startService();
            androidDriver = getDriver(null,null);
        }else {
            System.out.println("Control came to BrowserStack");
            // Call a method to supply data to getDriver
            androidDriver = getDriver("Samsung Galaxy S10e","9.0");
        }
        // 3 : Set DriverControls
        driverControls = new DriverControls(androidDriver);
    }


    @Test
    public void test() throws Exception{

        androidDriver.get("https://uatwap.shopups1.xyz/r");

    }

    @AfterSuite
    public void smokeTearDown(){
        androidDriver.quit();
        if(host.equalsIgnoreCase("local")){
            stopService();
        }
    }
}
