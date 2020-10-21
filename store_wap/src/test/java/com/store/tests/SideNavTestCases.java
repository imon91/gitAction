package com.store.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObejcts.*;
import utils.StoreWapBaseClass;

public class SideNavTestCases extends StoreWapBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private FacebookPageObjects facebookPageObjects;
    private DashBoardPageObjects dashBoardPageObjects;
    private SideNavPageObjects sideNavPageObjects;
    private BusinessInfoPageObjects businessInfoPageObjects;

    public void pageInitializer(){
        facebookPageObjects = new FacebookPageObjects(androidDriver);
        dashBoardPageObjects = new DashBoardPageObjects(androidDriver);
        sideNavPageObjects = new SideNavPageObjects(androidDriver);
        businessInfoPageObjects = new BusinessInfoPageObjects(androidDriver);
    }

    @BeforeClass(alwaysRun = true)
    public void sideNavTestCasesBeforeClass() throws Exception {
        androidDriver = getBaseDriver();
        System.out.println("sideNavTestCasesBeforeClass is called");
        pageInitializer();
        String facebookPage = facebookPageObjects.connectRandomFacebookPage(2);
        System.out.println(facebookPage + " is selected");
        facebookPageObjects.clickContinueAfterConnectFacebookPage();
        sleep(3000);
        dashBoardPageObjects.clickSideNavButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyEditBusinessInfo(){
        System.out.println("verifyEditBusinessInfo is called");
        sideNavPageObjects.clickBusinessInfoButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyEditBusinessInfo")
    public void editMerchantName(){
        System.out.println("editMerchantName is called");
        businessInfoPageObjects.clearMerchantNameField();
        businessInfoPageObjects.enterTextInMerchantName("Dhool");
        businessInfoPageObjects.clickOnSaveButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "editMerchantName")
    public void changeFBPage(){
        System.out.println("changeFBPage is called");
        sideNavPageObjects.clickChangePageButton();
        sleep(3000);
        String facebookPage = facebookPageObjects.connectRandomFacebookPage(3);
        System.out.println(facebookPage + " is selected");
        facebookPageObjects.clickContinueAfterConnectFacebookPage();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "changeFBPage")
    public void verifyLogout(){
        System.out.println("VerifyLogout is called");
        dashBoardPageObjects.clickSideNavButton();
        sideNavPageObjects.clickLogoutButton();
    }

    @AfterClass(alwaysRun = true)
    public void sideNavTestCasesAfterClass(){
        System.out.println("sideNavTestCasesAfterClass is called");
    }

}
