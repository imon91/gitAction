package com.shopf.tests.Mokam;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import services.responseModels.commerceModels.MokamHomePageModel;
import utils.*;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private HomePageObjects homePageObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private BottomNavigationObjects bottomNavigationObjects;
    private String packageName;
    private ServiceRequestLayer serviceRequestLayer;
    private SoftAssert softAssert;

    @BeforeSuite(alwaysRun = true)
    public void homePageBeforeSuite() throws Exception {
        androidDriver = getBaseDriver();
        pageInitializer();
        packageName = getAppPackage();
        softAssert = new SoftAssert();
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        loginPageObjects.performAuthentication("1877755590","666666");
        sleep(4000);
        //        homePageObjects.selectAddress(0);
        homePageObjects.createNewAddress();
        sleep(2000);
        switchFromWebToNative();
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(5000);
    }

    public void pageInitializer(){
        loginPageObjects = new LoginPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 0)
    public void verifyCurrentActivity(){
        String currentActivity = androidDriver.currentActivity();
        Assert.assertEquals(currentActivity,CoreConstants.ANDROID_HOME_ACTIVITY);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifySelectedAddress(){
        List<String> selectedAddressNameAndAddressList = new ArrayList<>();
        int cart_Item_Count = homePageObjects.getCartItemCount();
        selectedAddressNameAndAddressList = homePageObjects.getNameAndAddress_Backend(0,cart_Item_Count);
        WebElement nameOfSelectedAddress = actionBarObjects.getAddressNameAndAddressElement().get(0);
        softAssert.assertEquals(nameOfSelectedAddress.getText(),selectedAddressNameAndAddressList.get(0));

        WebElement addressOfSelectedAddress = actionBarObjects.getAddressNameAndAddressElement().get(1);
        softAssert.assertEquals(addressOfSelectedAddress.getText(),selectedAddressNameAndAddressList.get(1));

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyButtonsInActionBarAreClickable(){
        WebElement sideMenuButtonElement = actionBarObjects.getActionBarButtonElements().get(0);
        softAssert.assertEquals(sideMenuButtonElement.getAttribute("clickable"),"true");

        WebElement searchButtonElement = actionBarObjects.getActionBarButtonElements().get(1);
        softAssert.assertEquals(searchButtonElement.getAttribute("clickable"),"true");

        WebElement profileButtonElement = actionBarObjects.getActionBarButtonElements().get(2);
        softAssert.assertEquals(profileButtonElement.getAttribute("clickable"),"true");

        WebElement cartButtonElement = actionBarObjects.getActionBarButtonElements().get(3);
        softAssert.assertEquals(cartButtonElement.getAttribute("clickable"),"true");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyButtonsInBottomNavigationBarAreClickable(){
        WebElement homeButtonElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(0);
        softAssert.assertEquals(homeButtonElement.getAttribute("clickable"),"false");

        WebElement myOrdersButtonElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(1);
        softAssert.assertEquals(myOrdersButtonElement.getAttribute("clickable"),"true");

        WebElement khataButtonElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(2);
        softAssert.assertEquals(khataButtonElement.getAttribute("clickable"),"true");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyTextsInBottomNavigationBarButtons(){
        WebElement homeButtonTextElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(0);
        softAssert.assertEquals(homeButtonTextElement.getAttribute("content-desc"),"Home");

        WebElement myOrdersButtonTextElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(1);
        softAssert.assertEquals(myOrdersButtonTextElement.getAttribute("content-desc"),"My Orders");

        WebElement khataButtonTextElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(2);
        softAssert.assertEquals(khataButtonTextElement.getAttribute("content-desc"),"Khata");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5,enabled = false)
    public void verifyHomePageScrollable(){
        WebElement element = homePageObjects.getHomePageWebElement();
        Assert.assertEquals(element.getAttribute("scrollable"),"false");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6, enabled = false)
    public void verifyLedgerTexts(){
        WebElement giveTitleText = homePageObjects.getLedgerTextsListElement().get(0);
        softAssert.assertEquals(giveTitleText.getText(),"You'll give");

        WebElement getTitleText = homePageObjects.getLedgerTextsListElement().get(1);
        softAssert.assertEquals(getTitleText.getText(),"You'll get");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7, enabled = false)
    public void verifyLedgerValues(){
        WebElement giveMoney = homePageObjects.getLedgerValuesListElement().get(0);
        softAssert.assertEquals(Double.parseDouble(giveMoney.getText().substring(1)),homePageObjects.getTotalCredit());

        WebElement getMoney = homePageObjects.getLedgerValuesListElement().get(1);
        softAssert.assertEquals(Double.parseDouble(getMoney.getText().substring(1)),homePageObjects.getTotalDebit());

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8, enabled = false)
    public void verifyLedgerClickable(){
        WebElement ledgerElement = homePageObjects.getLedgerElement();
        Assert.assertEquals(ledgerElement.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyBannerHeadingTexts(){
//        List<MokamHomePageModel.CollectionsBean> collectionsBeanList = homePageObjects.getCollections();
//        List<WebElement> headingElementList = idListSetter("com.mokam.app:id/title_header_item");
//
//        int firstSeenHeadingSize = headingElementList.size(), totalHeadings = collectionsBeanList.size();
//
//        for (int i=0;i<firstSeenHeadingSize;i++){
//            softAssert.assertEquals(headingElementList.get(i),collectionsBeanList.get(i+1));
//        }
//
//        homePageObjects.scrollToAElementWithIdInHomePage("com.mokam.app:id/credit_widget_title");
//        List<WebElement> headingElementList1 = idListSetter("com.mokam.app:id/title_header_item");
//        softAssert.assertEquals(headingElementList1.get(1),collectionsBeanList.get(4));
//
//        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10,enabled = false)
    public void verifyHorizontalBannerScrolling(){
        homePageObjects.scrollToAElementWithIdInHomePage(packageName+":id/recycler_icon_widget");
        WebElement element = homePageObjects.getHorizontalBannerElement();
        Assert.assertEquals(element.getAttribute("scrollable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11,enabled = false)
    public void verifyBannersAreClickable(){
//        List<WebElement> bannerList = idListSetter("com.mokam.app:id/banner_image");
//        softAssert.assertEquals(bannerList.get(0).getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 12,enabled = false)
    public void verifyBakiText(){
        homePageObjects.scrollToAElementWithIdInHomePage(packageName+":id/action_view_credits");
        WebElement bakiTextElement = homePageObjects.getBakiTextElement();
        Assert.assertEquals(bakiTextElement.getText(),"Baki");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 13,enabled = false)
    public void verifyBakiAmount(){
        homePageObjects.scrollToAElementWithIdInHomePage(packageName+":id/credit_widget_amount");
        WebElement bakiAmountElement = homePageObjects.getBakiAmountElement();
        Assert.assertEquals(bakiAmountElement.getText().substring(1),""+homePageObjects.getBakiAmount());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 14,enabled = false)
    public void verifyViewBakiSummaryButtonClickable(){
        homePageObjects.scrollToAElementWithIdInHomePage(packageName+":id/action_view_credits");
        WebElement element = homePageObjects.getBakiSummaryButtonElement();
        Assert.assertEquals(element.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 15,enabled = false)
    public void verifyViewBakiSummaryButtonText(){
        WebElement element = homePageObjects.getBakiSummaryButtonElement();
        Assert.assertEquals(element.getText(),"View Baki Summary");
    }

    @AfterSuite(alwaysRun = true)
    public void homePageAfterSuite(){
        quitBaseDriver();
    }

}
