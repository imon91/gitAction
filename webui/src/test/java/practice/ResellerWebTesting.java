package practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import utils.BaseClass;
import utils.DriverControls;

import javax.crypto.Mac;

public class ResellerWebTesting extends BaseClass {
    private WebDriver driver;
    private DriverControls driverControls;
    private LoginPageObject loginPageObject;



    public static void main(String[] args) throws Exception {
        new ResellerWebTesting().LaunchBrowser();

    }

    public void LaunchBrowser() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Users/asokan/Downloads/chromedriver");
        ChromeOptions opt =new ChromeOptions();
        opt.addArguments("--disable-notifications");
        driver = new ChromeDriver(opt);
        driver.get("https://uatwap.shopups1.xyz/r");
        driverControls = new DriverControls(driver);
        driverControls.setImplicitWait(20);
        driver.manage().window().maximize();
        loginPageObject.performAuthentication("1877755590", "666666");
        loginPageObject.wait(2000);

    }


}
