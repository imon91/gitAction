package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;

public class Logout {
    private WebDriver driver;
    private HomePageObject homePageObject;

    @BeforeClass(alwaysRun = true)
    public void logoutBeforeClass(){
        System.out.println("Logout Before Class is called");
        homePageObject = new HomePageObject(driver);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},
            description = "Logout on click")
    public void verifyLogout(){
        homePageObject.clickLogout();
        String message = homePageObject.getPopUpMessage();
        System.out.println(message);
    }

    @AfterClass(alwaysRun = true)
    public void logoutAfterClass(){
        System.out.println("Logout After Class Is Called");

    }
}
