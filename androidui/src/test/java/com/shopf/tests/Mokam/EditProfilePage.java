package com.shopf.tests.Mokam;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import utils.*;

import java.util.Random;

public class EditProfilePage extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private HomePageObjects homePageObjects;
    private ServiceRequestLayer serviceRequestLayer;
    private Random random;
    private SoftAssert softAssert;
    private WebElement shopNameEditElement;
    private WebElement ownerNameEditElement;
    private WebElement saveButtonElement;

    @BeforeSuite(alwaysRun = true)
    public void editProfileBeforeSuite() throws Exception {
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
        rightNavigationDrawer.clickProfileEditButton();
        shopNameEditElement = rightNavigationDrawer.shopNameEdit();
        ownerNameEditElement = rightNavigationDrawer.ownerNameEdit();
    }

    public void pageInitializer(){
        loginPageObjects = new LoginPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
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
        WebElement backButtonElement = rightNavigationDrawer.getBackButtonElement();
        Assert.assertEquals(backButtonElement.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyPageTitle(){
        String pageTitle = rightNavigationDrawer.getEditProfilePageTitle();
        Assert.assertEquals(pageTitle,"EDIT BUSINESS INFO");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyShopNameHeadingText(){
        shopNameEditElement.clear();
        Assert.assertEquals(shopNameEditElement.getText(),"Shop Name");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyOwnerNameHeadingText(){
        ownerNameEditElement.clear();
        Assert.assertEquals(ownerNameEditElement.getText(),"Name of Owner");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifyBusinessTypeHeadingText(){
        String title = rightNavigationDrawer.getBusinessTypeHeadingText();
        Assert.assertEquals(title,"Business Type");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifyEnteringShopName(){
        String shopName = "Shop Name : "+random.nextInt(1000);
        shopNameEditElement.sendKeys(shopName);
        Assert.assertEquals(shopNameEditElement.getText(),shopName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifyEnteringOwnerName(){
        String ownerName = "Owner Name : "+random.nextInt(1000);
        ownerNameEditElement.sendKeys(ownerName);
        Assert.assertEquals(ownerNameEditElement.getText(),ownerName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyTextsInBusinessTypeButtons(){
        String retailerButtonText = rightNavigationDrawer.getBusinessTypeElement(1).getText();
        softAssert.assertEquals(retailerButtonText,"Retailer");
        String wholeSaleButtonText = rightNavigationDrawer.getBusinessTypeElement(2).getText();
        softAssert.assertEquals(wholeSaleButtonText,"Wholesaler");
        String bothButtonText = rightNavigationDrawer.getBusinessTypeElement(3).getText();
        softAssert.assertEquals(bothButtonText,"Both");
        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyBusinessTypeButtonsClickable(){
        softAssert.assertEquals(rightNavigationDrawer.getBusinessTypeElement(1).getAttribute("clickable"),"true");
        softAssert.assertEquals(rightNavigationDrawer.getBusinessTypeElement(2).getAttribute("clickable"),"true");
        softAssert.assertEquals(rightNavigationDrawer.getBusinessTypeElement(3).getAttribute("clickable"),"true");
        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifySaveButtonText(){
        saveButtonElement = rightNavigationDrawer.getProfileSaveButtonElement();
        String saveButtonText = saveButtonElement.getText();
        Assert.assertEquals(saveButtonText,"SAVE");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifySaveButtonClickable(){
        saveButtonElement = rightNavigationDrawer.getProfileSaveButtonElement();
        Assert.assertEquals(saveButtonElement.getAttribute("clickable"),"true");
    }

    @AfterSuite(alwaysRun = true)
    public void editProfileAfterSuite(){
        quitBaseDriver();
    }

}
