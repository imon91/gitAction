package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.util.*;

public class NotificationSettingsPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private NotificationSettingsPageObjects notificationSettingsPageObjects;

    private String cookie;

    @BeforeSuite(alwaysRun = true)
    public void redXWebBeforeSuite() throws  Exception
    {
        System.out.println("RedX Web Before Suite");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getWebBaseUrl());
        driver.manage().window().maximize();
    }

    @BeforeClass(alwaysRun = true)
    public void notificationSettingsTestsBeforeClass() throws Exception
    {
        System.out.println("Notification Settings Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        notificationSettingsPageObjects = new NotificationSettingsPageObjects(driver);

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

//        actionBarObjects.clickModalCloseButton();
        actionBarObjects.clickOnNotificationSettingsDropDown();
    }

    @BeforeMethod(alwaysRun = true)
    public void notificationSettingsPageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Toast Msg Value",
            priority = 1 )
    public void verifyToastMsgValue()
    {
        System.out.println("Verifying Toast Msg Value");
        String[] data = notificationSettingsPageObjects.getDataFromCsv("NSD01");
        notificationSettingsPageObjects.saveNotificationDetails(data[0],data[1]);
        String toastMsg = notificationSettingsPageObjects.getToastMsg();
        System.out.println("Toast Msg : " + toastMsg);
        Assert.assertEquals(toastMsg,"Nothing found to save.");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Error Msg Value",
            priority = 2 )
    public void verifyErrorMsgValue()
    {
        System.out.println("Verifying Error Msg Value");
        String[] data = notificationSettingsPageObjects.getDataFromCsv("NSD02");
        notificationSettingsPageObjects.saveNotificationDetails(data[0],data[1]);
        List<String> errorMsg = notificationSettingsPageObjects.getAllErrorMsg();
        System.out.println(errorMsg.toString());
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Notification Details Functionality",
            priority = 3 )
    public void verifyNotificationDetailsFunctionality()
    {
        System.out.println("Verifying Notification Details Functionality");
        String[] data = notificationSettingsPageObjects.getDataFromCsv("NSD03");
        notificationSettingsPageObjects.saveNotificationDetails(data[0],data[1]);
        String toastMsg = notificationSettingsPageObjects.getToastMsg();
        System.out.println("Toast Msg : " + toastMsg);
        Assert.assertEquals(toastMsg,"Saved successfully.");
    }

    @AfterClass(alwaysRun = true)
    public void notificationSettingsPageTestsAfterClass()
    {
        System.out.println("Notification Settings Page Tests After Class");
    }

    @AfterSuite(alwaysRun = true)
    public void notificationSettingsPageTestsAfterSuite()
    {
        System.out.println("Notification Settings Page Tests After Suite");
        driver.quit();
    }
}
