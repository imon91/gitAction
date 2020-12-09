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
    private ServiceRequestLayer serviceRequestLayer;
    private SoftAssert softAssert;

    @BeforeSuite(alwaysRun = true)
    public void homePageBeforeSuite(){
        androidDriver = getBaseDriver();
        pageInitializer();
        softAssert = new SoftAssert();
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        loginPageObjects.performAuthentication("1877755590","666666");
        sleep(4000);
        homePageObjects.selectAddress(0);
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
        WebElement nameOfSelectedAddress = idSetter("com.mokam.app:id/address_name");
        softAssert.assertEquals(nameOfSelectedAddress.getText(),selectedAddressNameAndAddressList.get(0));

        WebElement addressOfSelectedAddress = idSetter("com.mokam.app:id/address_details");
        softAssert.assertEquals(addressOfSelectedAddress.getText(),selectedAddressNameAndAddressList.get(1));

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyButtonsInActionBarAreClickable(){
        WebElement sideMenuButtonElement = idSetter("com.mokam.app:id/side_menu_button");
        softAssert.assertEquals(sideMenuButtonElement.getAttribute("clickable"),"true");

        WebElement searchButtonElement = idSetter("com.mokam.app:id/searchButton");
        softAssert.assertEquals(searchButtonElement.getAttribute("clickable"),"true");

        WebElement profileButtonElement = idSetter("com.mokam.app:id/profile");
        softAssert.assertEquals(profileButtonElement.getAttribute("clickable"),"true");

        WebElement cartButtonElement = idSetter("com.mokam.app:id/cart_icon_container");
        softAssert.assertEquals(cartButtonElement.getAttribute("clickable"),"true");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyButtonsInBottomNavigationBarAreClickable(){
        WebElement homeButtonElement = idSetter("com.mokam.app:id/homeBottomBar");
        softAssert.assertEquals(homeButtonElement.getAttribute("clickable"),"false");

        WebElement myOrdersButtonElement = idSetter("com.mokam.app:id/myOrderBottomBar");
        softAssert.assertEquals(myOrdersButtonElement.getAttribute("clickable"),"true");

        WebElement khataButtonElement = idSetter("com.mokam.app:id/ledger_bottom_bar");
        softAssert.assertEquals(khataButtonElement.getAttribute("clickable"),"true");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyTextsInBottomNavigationBarButtons(){
        WebElement homeButtonTextElement = idSetter("com.mokam.app:id/homeBottomBar");
        softAssert.assertEquals(homeButtonTextElement.getAttribute("content-desc"),"Home");

        WebElement myOrdersButtonTextElement = idSetter("com.mokam.app:id/myOrderBottomBar");
        softAssert.assertEquals(myOrdersButtonTextElement.getAttribute("content-desc"),"My Orders");

        WebElement khataButtonTextElement = idSetter("com.mokam.app:id/ledger_bottom_bar");
        softAssert.assertEquals(khataButtonTextElement.getAttribute("content-desc"),"Khata");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifyHomePageScrollable(){
        WebElement element = idSetter("com.mokam.app:id/recycler_home_fragment");
        Assert.assertEquals(element.getAttribute("scrollable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6, enabled = false)
    public void verifyLedgerTexts(){
        WebElement giveTitleText = idSetter("com.mokam.app:id/ledger_widget_give_title");
        softAssert.assertEquals(giveTitleText.getText(),"You'll give");

        WebElement getTitleText = idSetter("com.mokam.app:id/ledger_widget_get_title");
        softAssert.assertEquals(getTitleText.getText(),"You'll get");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7, enabled = false)
    public void verifyLedgerValues(){
        WebElement giveMoney = idSetter("com.mokam.app:id/ledger_widget_give_money");
        softAssert.assertEquals(Double.parseDouble(giveMoney.getText().substring(1)),homePageObjects.getTotalCredit());

        WebElement getMoney = idSetter("com.mokam.app:id/ledger_widget_get_money");
        softAssert.assertEquals(Double.parseDouble(getMoney.getText().substring(1)),homePageObjects.getTotalDebit());

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8, enabled = false)
    public void verifyLedgerClickable(){
        WebElement ledgerElement = xpathSetter("//android.view.ViewGroup[@index='0']//androidx.cardview.widget.CardView[@index='0']");
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

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifyHorizontalBannerScrolling(){
        homePageObjects.scrollToAElementWithIdInHomePage("com.mokam.app:id/recycler_icon_widget");
        WebElement element = idSetter("com.mokam.app:id/recycler_icon_widget");
        Assert.assertEquals(element.getAttribute("scrollable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifyBannersAreClickable(){
//        List<WebElement> bannerList = idListSetter("com.mokam.app:id/banner_image");
//        softAssert.assertEquals(bannerList.get(0).getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 12)
    public void verifyBakiText(){
        homePageObjects.scrollToAElementWithIdInHomePage("com.mokam.app:id/action_view_credits");
        WebElement bakiTextElement = idSetter("com.mokam.app:id/credit_widget_title");
        Assert.assertEquals(bakiTextElement.getText(),"Baki");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 13)
    public void verifyBakiAmount(){
        homePageObjects.scrollToAElementWithIdInHomePage("com.mokam.app:id/credit_widget_amount");
        WebElement bakiAmountElement = idSetter("com.mokam.app:id/credit_widget_amount");
        Assert.assertEquals(bakiAmountElement.getText().substring(1),""+homePageObjects.getBakiAmount());
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 14)
    public void verifyViewBakiSummaryButtonClickable(){
        homePageObjects.scrollToAElementWithIdInHomePage("com.mokam.app:id/action_view_credits");
        WebElement element = idSetter("com.mokam.app:id/action_view_credits");
        Assert.assertEquals(element.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 15)
    public void verifyViewBakiSummaryButtonText(){
        WebElement element = idSetter("com.mokam.app:id/action_view_credits");
        Assert.assertEquals(element.getText(),"View Baki Summary");
    }

    @AfterSuite(alwaysRun = true)
    public void homePageAfterSuite(){
        quitBaseDriver();
    }

}
