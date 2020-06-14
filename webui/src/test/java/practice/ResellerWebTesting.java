package practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.LoginPageObject;

import pageObjects.MyShopPageObjects;
import utils.WebBaseClass;

import java.util.concurrent.TimeUnit;

public class ResellerWebTesting extends WebBaseClass {
    private WebDriver driver;
    private LoginPageObject loginPageObject;
    private MyShopPageObjects myShopPageObjects;


    public static void main(String[] args) throws Exception {
        new ResellerWebTesting().LaunchBrowser();

    }

    public void LaunchBrowser() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Users/asokan/Downloads/chromedriver");
        ChromeOptions opt =new ChromeOptions();
        opt.addArguments("--disable-notifications");
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,   TimeUnit.SECONDS);
        loginPageObject = new LoginPageObject(driver);
        driver.get("https://uatwap.shopups1.xyz/r");
        loginPageObject.performAuthentication("1877755590", "666666");
        MyShopPageObjects myShopPageObjects = new MyShopPageObjects(driver);
        myShopPageObjects.createNewCollection();

    }


}
