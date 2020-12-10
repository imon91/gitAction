package com.shopf.tests.Mokam;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import utils.*;

import java.util.*;

public class ProfilePage extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private HomePageObjects homePageObjects;
    private YourAccountPageObjects yourAccountPageObjects;
    private ServiceRequestLayer serviceRequestLayer;
    private Random random;
    private SoftAssert softAssert;
    String shopName;
    String ownerName;
    int randomBusinessType;

    @BeforeSuite(alwaysRun = true)
    public void profilePageBeforeSuite() throws Exception {
        androidDriver = getBaseDriver();
        pageInitializer();
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        random = new Random();
        softAssert = new SoftAssert();
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
        rightNavigationDrawer.clickOnItemMyAccount();
        shopName = "ShopName : "+random.nextInt(1000);
        ownerName = "OwnerName : "+random.nextInt(1000);
        randomBusinessType = random.nextInt(3);
    }

    public void pageInitializer(){
        loginPageObjects = new LoginPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        yourAccountPageObjects = new YourAccountPageObjects(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 0)
    public void verifyCurrentActivity(){
        String currentActivity = androidDriver.currentActivity();
        Assert.assertEquals(currentActivity,CoreConstants.ANDROID_PROFILE_ACTIVITY);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifyPageTitle(){
        String pageTitle = yourAccountPageObjects.getPageTitle();
        Assert.assertEquals(pageTitle,"Your Account");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyBackButtonClickable(){
        WebElement backButtonElement = xpathSetter("//android.widget.ImageView[@resource-id='com.mokam.app:id/back_button_profile']");
        Assert.assertEquals(backButtonElement.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyEditBusinessInfoButtonClickable(){
        WebElement element = xpathSetter("//android.view.ViewGroup[@index='0']//android.widget.TextView[@resource-id='com.mokam.app:id/action_edit']");
        Assert.assertEquals(element.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyEditBusinessInfo(){
        WebElement element = xpathSetter("//android.view.ViewGroup[@index='0']//android.widget.TextView[@resource-id='com.mokam.app:id/action_edit']");
        element.click();
        rightNavigationDrawer.shopNameEdit().clear();
        rightNavigationDrawer.shopNameEdit().sendKeys(shopName);
        rightNavigationDrawer.ownerNameEdit().clear();
        rightNavigationDrawer.ownerNameEdit().sendKeys(ownerName);
        rightNavigationDrawer.businessTypeEdit(randomBusinessType);
        rightNavigationDrawer.clickOnProfileSaveButton();
        sleep(5000);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifyBusinessInfoText(){
        String text = yourAccountPageObjects.getBusinessInfoText();
        Assert.assertEquals(text,"Business Info");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifyBusinessAddressText(){
        String text = yourAccountPageObjects.getBusinessAddressHeadingText();
        Assert.assertEquals(text,"Business Address");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifyHeadingTexts(){
        String shopNameHeading = yourAccountPageObjects.getShopNameHeadingText();
        softAssert.assertEquals(shopNameHeading,"Shop Name");
        String ownerNameHeading = yourAccountPageObjects.getNameOfOwnerHeadingText();
        softAssert.assertEquals(ownerNameHeading,"Name of Owner");
        String mobileNumberHeading = yourAccountPageObjects.getRegisterMobileNumberHeadingText();
        softAssert.assertEquals(mobileNumberHeading,"Registered Phone Number");
        String retailerTypeHeading = yourAccountPageObjects.getBusinessTypeHeadingText();
        softAssert.assertEquals(retailerTypeHeading,"Business Type");
        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyShopDetails(){
        List<String> shopDetails = yourAccountPageObjects.getShopDetails_BackEnd();
        String shopName = yourAccountPageObjects.getShopName();
        softAssert.assertEquals(shopName,shopDetails.get(0));
        String ownerName = yourAccountPageObjects.getNameOfOwner();
        softAssert.assertEquals(ownerName,shopDetails.get(1));
        String mobileNumber = yourAccountPageObjects.getRegisteredMobileNumber();
        softAssert.assertEquals(mobileNumber,shopDetails.get(2));
        String retailerType = yourAccountPageObjects.getBusinessType();
        softAssert.assertEquals(retailerType,shopDetails.get(3));
        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyFirstAddressShopName(){
        Assert.assertEquals(yourAccountPageObjects.getShopNameInAddress(0),yourAccountPageObjects.getShopNameInAddress_Backend(0));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifyFirstAddressEditButtonClickable(){
        List<WebElement> elementList = xpathListSetter("//androidx.recyclerview.widget.RecyclerView//android.widget.TextView[@resource-id='com.mokam.app:id/action_edit']");
        Assert.assertEquals(elementList.get(0).getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifyFirstAddressDeleteButtonClickable(){
        List<WebElement> elementList = xpathListSetter("//androidx.recyclerview.widget.RecyclerView//android.widget.ImageView[@resource-id='com.mokam.app:id/action_delete']");
        Assert.assertEquals(elementList.get(0).getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 12)
    public void verifyAddNewAddressButtonText(){
        yourAccountPageObjects.scrollToAddNewAddressButton();
        String text = yourAccountPageObjects.getAddNewAddressButtonText();
        Assert.assertEquals(text,"Add New Address");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 13)
    public void verifyAddNewAddressButtonClickable(){
        WebElement element = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/action_add_address']");
        Assert.assertEquals(element.getAttribute("clickable"),"true");
    }

    @AfterSuite(alwaysRun = true)
    public void profilePageAfterSuite(){
        quitBaseDriver();
    }

}
