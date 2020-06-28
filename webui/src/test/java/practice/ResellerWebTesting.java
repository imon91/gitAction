package practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import pageObjects.MyShopPageObjects;
import utils.WebBaseClass;

import java.util.concurrent.TimeUnit;

public class ResellerWebTesting extends WebBaseClass {
    private WebDriver driver;
    private LoginPageObject loginPageObject;
    private MyShopPageObjects myShopPageObjects;


    @BeforeTest
    public void LaunchBrowser() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/asokan/Downloads/chromedriver");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPageObject = new LoginPageObject(driver);
        driver.get("https://uatwap.shopups1.xyz/r");
    }


    @Test
    public void VerifyAuthentication() throws Exception {

        loginPageObject.performAuthentication("1877755590", "666666");
    }

    @Test
    public void secondtest() {
        loginPageObject.performAuthentication("1877755590", "666666");
        MyShopPageObjects myShopPageObjects = new MyShopPageObjects(driver);
        myShopPageObjects.createNewCollection();
    }

    @AfterTest
    public void exit() throws Exception {
        System.out.println("exited");
    }


}
