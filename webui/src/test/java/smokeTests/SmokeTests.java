package smokeTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.DriverControls;

public class SmokeTests extends BaseClass {

    private WebDriver webDriver;
    private DriverControls driverControls;
    private String host;


    @BeforeSuite
    public void smokeSetUp() throws Exception{
        host = System.getProperty("Host");
        System.out.println("Host is :"+host);
        if(host.equalsIgnoreCase("local")){
            System.out.println("Control came into Selenium Local");
            // 1 : Start Appium Service
            webDriver = getDriver(null,null,null,null);
        }else {
            System.out.println("Control came into Selenium BrowserStack");
            // Call a method to supply data to getDriver
            webDriver = getDriver("OS X","Catalina","Chrome","84.0 beta");
        }
        // 3 : Set DriverControls
        driverControls = new DriverControls(webDriver);
    }

    @Test
    public void nikhilTest() throws Exception{

        webDriver.get("https://uatwap.shopups1.xyz/r");
        Thread.sleep(5000);
        webDriver.quit();

    }

}
