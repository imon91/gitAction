package com.redx.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class Authentication extends RedXBaseClass
{

    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private HomePageObjects homePageObjects;
    private MyActions myActions;
    private SettingsPageObjects settingsPageObjects;


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
        myActions = new MyActions();
        settingsPageObjects = new SettingsPageObjects();
    }


    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp() throws Exception
    {
        System.out.println("authenticationSetUp is called");
        pageInitializer();
        switchFromWebToNative();
        sleep(8000);
        try {
            WebElement updateButton = idSetter("android:id/button1");
            myActions.action_click(updateButton);
            sleep(2000);
        }catch (Exception e){System.out.println("No update button");}
        sleep(3000);
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
        System.out.println(homePageObjects.getCurrentShopName());   }

    @Test(  groups = {"Authentication.verifyAuthenticationWithEditMobileNo",
            CoreConstants.GROUP_SANITY},
            description = "Verifies Authentication With Edit MobileNo",
            priority = 1,
            dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationByEditMobileNo(String mobileNumber,String otp)
    {
        System.out.println("Verify Authentication with Edit MobileNo was called");
        loginPageObjects.performAuthenticationWithChangeNumber(mobileNumber,otp);
    }

    @Test(  groups = {"Authentication.verifyAuthenticationWithWrongOTP",
            CoreConstants.GROUP_SANITY},
            description = "Verifies Authentication With Wrong OTP",
            priority = 2,
            dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationWithWrongOTP(String mobileNumber,String otp)
    {
        System.out.println("Verify authentication with Wrong OTP was called");
        loginPageObjects.performAuthenticationWithWrongOTP(mobileNumber,otp);
    }


    @AfterMethod(  groups = {"Authentication.AfterMethod",
            CoreConstants.GROUP_SANITY},
            description = "Verifies Authentication With Wrong OTP")
    public void authenticationAfterMethod()
    {
        homePageObjects.clickSettingsButton();
        settingsPageObjects.performLogout();
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
