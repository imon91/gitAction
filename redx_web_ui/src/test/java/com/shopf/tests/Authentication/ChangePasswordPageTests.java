package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.util.*;

public class ChangePasswordPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private ChangePasswordPageObjects changePasswordPageObjects;

    private String cookie;
    private String shopName = "Password Page Sanity Test Shop";
    private String currentPwd = "passwordSanityTest";
    private String newPwd = "passwordSanityTest";
    private String confirmPwd = "passwordSanityTest";

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
    public void changePasswordPageTestsBeforeClass() throws Exception
    {
        System.out.println("Change Password Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        changePasswordPageObjects =  new ChangePasswordPageObjects(driver);

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

        actionBarObjects.changeShop(shopName);
        setImplicitWait(10000);

        actionBarObjects.clickOnChangePasswordDropDown();
    }

    @BeforeMethod(alwaysRun = true)
    public void changePasswordPageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Change Password Error Msg Values",
            priority = 1 )
    public void verifyChangePasswordErrorMsgValues()
    {
        System.out.println("Verifying Change Password Error Msg Values");
        changePasswordPageObjects.clickSaveButton();
        List<String> errorMsgs = changePasswordPageObjects.getAllErrorMsg();
        System.out.println("Error Messages" + errorMsgs);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Change Password Functionality",
            priority = 2 )
    public void verifyChangePasswordFunctionality()
    {
        System.out.println("Verifying Change Password Functionality");
        changePasswordPageObjects.performChangePassword(currentPwd,newPwd,confirmPwd);
        String toastMsg = changePasswordPageObjects.getToastMsg();
        System.out.println("Toast Msg : " + toastMsg);
        Assert.assertEquals(toastMsg,"Password update succesfully");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Reset Button Functionality",
            priority = 3 )
    public void verifyResetButtonFunctionality()
    {
        System.out.println("Verifying Reset Button Functionality");
        changePasswordPageObjects.clickResetButton();
        String  currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL : " + currentUrl);
        Assert.assertEquals(currentUrl,"https://redx.shopups1.xyz/forgot-password/");
    }

    @AfterClass(alwaysRun = true)
    public void changePasswordPageTestsAfterClass()
    {
        System.out.println("Change Password Page Tests After Class");
        actionBarObjects.clickOnDashboardLink();
    }

    @AfterSuite(alwaysRun = true)
    public void changePasswordPageTestsAfterSuite()
    {
        System.out.println("Change Password Page Tests After Suite");
        driver.quit();
    }
}
