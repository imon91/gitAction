package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.*;
import utils.RedXBaseClass;

public class CreateParcel extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private AddParcelPageObjects addParcelPageObjects;

    public void pageInitializer()
    {
        homePageObjects = new HomePageObjects();
        addParcelPageObjects = new AddParcelPageObjects();
    }

    @BeforeClass(alwaysRun = true)
    public void beforeCreateParcelClass() throws Exception
    {
        System.out.println("Before Create Parcel Class");
        androidDriver = getBaseDriver();
        pageInitializer();
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Create New Parcel",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void createNewParcel()
    {
        System.out.println("Creating New Parcel");
        homePageObjects.clickDeliverYourParcelModule();
        addParcelPageObjects.addParcel();
    }

    @AfterClass(alwaysRun = true)
    public void afterCreateParcelClass()
    {
        System.out.println("After Create Parcel Class");
    }
}
