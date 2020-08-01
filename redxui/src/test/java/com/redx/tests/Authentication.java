package com.redx.tests;

import coreUtils.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class Authentication extends RedXBaseClass
{

    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private HomePageObjects homePageObjects;


    @BeforeSuite(alwaysRun = true)
    public void redXAndroidBeforeSuite()
    {
        System.out.println("redXAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
    }

    public void pageInitializer()
    {
        loginPageObjects = new LoginPageObjects();
        homePageObjects = new HomePageObjects();
    }


    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp() throws Exception
    {
        System.out.println("authenticationSetUp is called");
        pageInitializer();
    }



    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        return new Object[][]{
                {"01401122188","6666"}
        };
    }



    @Test(  groups = {"Authentication.verifyAuthenticationWithValidCredentials",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With Valid Credentials",
            dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationWithValidCredentials(String mobileNumber,String otp)
    {
        System.out.println("Verify Authentication is called");
        loginPageObjects.performAuthentication(mobileNumber,otp);
        Assert.assertEquals(homePageObjects.getCurrentShopName(),"SHOPUP_TEST");
    }



    @AfterClass(alwaysRun = true)
    public void closeAuthenticationClass(){
        System.out.println("AuthenticationAfterClass Is Called");
        //closeApp();

    }
    

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){
        System.out.println("redXAndroidAfterSuite Is Called");
        quitBaseDriver();
    }

}
