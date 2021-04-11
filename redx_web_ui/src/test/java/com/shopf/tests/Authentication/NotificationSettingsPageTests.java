package com.shopf.tests.Authentication;

import com.gurock.testrail.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class NotificationSettingsPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private NotificationSettingsPageObjects notificationSettingsPageObjects;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void notificationSettingsTestsBeforeClass() throws Exception
    {
        System.out.println("Notification Settings Page Tests Before Class");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        notificationSettingsPageObjects = new NotificationSettingsPageObjects(driver);

        actionBarObjects.clickOnNotificationSettingsDropDown();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("BeforeMethod is called");
        System.out.println("\n /****************************************************************************************************/ \n");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, NotificationSettingsPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "343")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Toast Msg Value",
            priority = 1101 )
    public void verifyToastMsgValue()
    {
        System.out.println("Verifying Toast Msg Value");
        String[] data = notificationSettingsPageObjects.getDataFromCsv("NSD01");
        notificationSettingsPageObjects.saveNotificationDetails(data[0],data[1]);
        String toastMsg = notificationSettingsPageObjects.getToastMsg();
        System.out.println("Toast Msg : " + toastMsg);
        Assert.assertEquals(toastMsg,"Nothing found to save.");
    }

    @TestRails(caseId = "344")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Error Msg Value",
            priority = 1102 )
    public void verifyErrorMsgValue()
    {
        System.out.println("Verifying Error Msg Value");
        String[] data = notificationSettingsPageObjects.getDataFromCsv("NSD02");
        notificationSettingsPageObjects.saveNotificationDetails(data[0],data[1]);
        List<String> errorMsg = notificationSettingsPageObjects.getAllErrorMsg();
        System.out.println(errorMsg.toString());
    }

    @TestRails(caseId = "345")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Notification Details Functionality",
            priority = 1103 )
    public void verifyNotificationDetailsFunctionality()
    {
        System.out.println("Verifying Notification Details Functionality");
        String[] data = notificationSettingsPageObjects.getDataFromCsv("NSD03");
        notificationSettingsPageObjects.saveNotificationDetails(data[0],data[1]);
        String toastMsg = notificationSettingsPageObjects.getToastMsg();
        System.out.println("Toast Msg : " + toastMsg);
        Assert.assertEquals(toastMsg,"Saved successfully.");
    }
}
