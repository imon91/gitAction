package com.shopf.tests.Authentication;

import com.gurock.testrail.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.*;
import services.responseModels.redxModels.*;
import utils.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class ChangePasswordPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private ChangePasswordPageObjects changePasswordPageObjects;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    private String shopName = "Password Page Sanity Test Shop";
    private String currentPwd = "passwordSanityTest";
    private String newPwd = "passwordSanityTest";
    private String confirmPwd = "passwordSanityTest";
    private String wrongPwd = "passwordSanity";

    @BeforeClass(alwaysRun = true)
    public void changePasswordPageTestsBeforeClass() throws Exception
    {
        System.out.println("Change Password Page Tests Before Class");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        changePasswordPageObjects =  new ChangePasswordPageObjects(driver);

        actionBarObjects.changeShop(shopName);
        setImplicitWait(10000);

        actionBarObjects.clickOnChangePasswordDropDown();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, ChangePasswordPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "366")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Change Password Error Msg Values",
            priority = 1301 )
    public void verifyChangePasswordErrorMsgValues()
    {
        System.out.println("Verifying Change Password Error Msg Values");
        changePasswordPageObjects.clickSaveButton();
        List<String> errorMsgs = changePasswordPageObjects.getAllErrorMsg();
        System.out.println("Error Messages" + errorMsgs);
    }

    @TestRails(caseId = "928")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Change Password Functionality With Wrong Password",
            priority = 1302 )
    public void verifyChangePasswordFunctionalityWithWrongPassword()
    {
        System.out.println("Verifying Change Password Functionality With Wrong Password");
        changePasswordPageObjects.performChangePassword(wrongPwd,newPwd,confirmPwd);
        String toastMsg = changePasswordPageObjects.getToastMsg();
        System.out.println("Toast Msg : " + toastMsg);
        setImplicitWait(10000);
        Assert.assertEquals(toastMsg,"Current Password dont match");
    }

    @TestRails(caseId = "367")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Change Password Functionality",
            priority = 1303 )
    public void verifyChangePasswordFunctionality()
    {
        System.out.println("Verifying Change Password Functionality");
        changePasswordPageObjects.performChangePassword(currentPwd,newPwd,confirmPwd);
        String toastMsg = changePasswordPageObjects.getToastMsg();
        System.out.println("Toast Msg : " + toastMsg);
        Assert.assertEquals(toastMsg,"Password update succesfully");
    }

    @TestRails(caseId = "368")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Reset Button Functionality",
            priority = 1304 )
    public void verifyResetButtonFunctionality()
    {
        System.out.println("Verifying Reset Button Functionality");
        changePasswordPageObjects.clickResetButton();
        String  currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL : " + currentUrl);
        Assert.assertEquals(currentUrl,"https://redx.shopups1.xyz/forgot-password/");
    }
}
