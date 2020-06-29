package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import utils.WmsBaseClass;

public class Logout extends WmsBaseClass {
    private WebDriver driver;
    private HomePageObject homePageObject;

    @BeforeClass(alwaysRun = true)
    public void logoutBeforeClass(){
        System.out.println("Logout Before Class is called");
        homePageObject = new HomePageObject(driver);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},
            description = "Logout on click",
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials")
    public void verifyLogout(){
        System.out.println("Verify Logout is being called");
        sleep(2000);
        homePageObject.clickLogout();
        sleep(2000);
    }

    @AfterClass(alwaysRun = true)
    public void logoutAfterClass(){
        System.out.println("Logout After Class Is Called");

    }
}
