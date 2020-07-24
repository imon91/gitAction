package com.shopf.wapTests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ActionBarObjects;
import pageObjects.PLPPageObject;
import pageObjects.PaymentPageObject;
import utils.WebBaseClass;

public class LogOutFunction extends WebBaseClass {


    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private PLPPageObject plpPageObject;
    private PaymentPageObject paymentPageObject;


    @BeforeClass(alwaysRun = true)
    public void logoutVerificationBeforeClass() throws Exception {
        System.out.println("logoutVerificationBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        paymentPageObject = new PaymentPageObject(driver);
    }



    @Test(groups = {"Home.VerifyLogout",
            (CoreConstants.GROUP_SMOKE)},
            dependsOnGroups = ("OrderSuccessfull.VerifyPlacingOrder"))
    public void logoutVerification() {
        System.out.println("logoutVerification is called");
        actionBarObjects.clickOnLoginButton();
        actionBarObjects.dropDownLogout();
    }



    @AfterClass(alwaysRun = true)
    public void logoutVerificationAfterClass() {
        System.out.println("logoutVerificationAfterclass is called");
    }

}
