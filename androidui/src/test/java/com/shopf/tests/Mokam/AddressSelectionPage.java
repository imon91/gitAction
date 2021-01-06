package com.shopf.tests.Mokam;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.util.*;

public class AddressSelectionPage extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private YourAccountPageObjects yourAccountPageObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private SalesRepFeaturePageObject salesRepFeaturePageObject;
    private HomePageObjects homePageObjects;
    private ServiceRequestLayer serviceRequestLayer;

    @BeforeSuite(alwaysRun = true)
    public void addressSelectionPageBeforeSuite() throws Exception {
        androidDriver = getBaseDriver();
        pageInitializer();
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        loginPageObjects.performAuthentication("1877755590","666666");
        sleep(4000);
//        xpathSetter("//androidx.cardview.widget.CardView[@index='0']/android.view.ViewGroup[@index='0']").click();
        homePageObjects.createNewAddress();
        sleep(2000);
        switchFromWebToNative();
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(5000);
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemLogout();
        loginPageObjects.performAuthentication("1877755590","666666");
        sleep(4000);
    }

    public void pageInitializer(){
        loginPageObjects = new LoginPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        yourAccountPageObjects = new YourAccountPageObjects(androidDriver);
        salesRepFeaturePageObject = new SalesRepFeaturePageObject(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 0)
    public void verifyCurrentActivity(){
        String currentActivity = androidDriver.currentActivity();
        Assert.assertEquals(currentActivity,CoreConstants.ANDROID_PROFILE_ACTIVITY);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifyBackButtonClickable(){
        WebElement element = homePageObjects.getBackButtonInAddressSelectionPageElement();
        Assert.assertEquals(element.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyPageTitle(){
        WebElement pageTitleElement = homePageObjects.getPageTitleElementOfAddressSelection();
        Assert.assertEquals(pageTitleElement.getText(),"Select an Address");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyFirstAddressShopName(){
        Assert.assertEquals(yourAccountPageObjects.getShopNameInAddress(0),yourAccountPageObjects.getShopNameInAddress_Backend(0));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyFirstAddressEditButtonClickable(){
        List<WebElement> elementList = yourAccountPageObjects.getEditButtonsInAddressList();
        Assert.assertEquals(elementList.get(0).getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifyFirstAddressDeleteButtonClickable(){
        List<WebElement> elementList = yourAccountPageObjects.getDeleteButtonsInAddressList();
        Assert.assertEquals(elementList.get(0).getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyAddNewAddressButtonText(){
        String text = yourAccountPageObjects.getAddNewAddressButtonText();
        Assert.assertEquals(text,"Add New Address");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifyAddNewAddressButtonClickable(){
        WebElement element = yourAccountPageObjects.addNewAddressButtonElement();
        Assert.assertEquals(element.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifyNoAddressesFoundTextForNewUser(){
        homePageObjects.selectAddress(0);
        sleep(2000);
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemLogout();
        String newMobileNumber = "018"+RandomStringUtils.randomNumeric(8);
        loginPageObjects.performAuthentication(newMobileNumber,"666666");
        salesRepFeaturePageObject.enterShopNameText("ShopName : "+RandomStringUtils.randomAlphabetic(6));
        salesRepFeaturePageObject.enterOwnerNameText("OwnerName : "+RandomStringUtils.randomAlphabetic(6));
        salesRepFeaturePageObject.clickOnRetailerIcon();
        salesRepFeaturePageObject.clickOnNextButtonAtOnboardingScreen();
        sleep(2000);
        WebElement element1 = homePageObjects.getNoAddressesFoundTextElement();
        Assert.assertEquals(element1.getText(),"No addresses found");
    }

    @AfterSuite(alwaysRun = true)
    public void addressSelectionAfterSuite(){
        quitBaseDriver();
    }

}
