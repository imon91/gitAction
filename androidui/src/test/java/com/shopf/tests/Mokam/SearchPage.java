package com.shopf.tests.Mokam;

import coreUtils.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import utils.*;

import java.util.Random;

public class SearchPage extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private SearchPageObjects searchPageObjects;
    private ServiceRequestLayer serviceRequestLayer;
    private Random random;
    private SoftAssert softAssert;
    String recentlyViewedText_English = "Recently Viewed";

    public void pageInitializer(){
        homePageObjects = new HomePageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        loginPageObjects = new LoginPageObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        searchPageObjects = new SearchPageObjects(androidDriver);
    }

    @BeforeSuite(alwaysRun = true)
    public void searchPageBeforeSuite(){
        androidDriver = getBaseDriver();
        pageInitializer();
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        random = new Random();
        softAssert = new SoftAssert();
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
        actionBarObjects.clickOnSearchImageButton();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 0)
    public void verifyCurrentActivity(){
        String currentActivity = androidDriver.currentActivity();
        Assert.assertEquals(currentActivity, AndroidActivities.resellerActivities.searchActivity);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifyBackButtonClickable(){
        WebElement backButtonElement = searchPageObjects.getSearchBackButtonElement();
        Assert.assertEquals(backButtonElement.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifySearchButtonClickable(){
        WebElement searchButtonElement = searchPageObjects.getSearchButtonElement();
        Assert.assertEquals(searchButtonElement.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyRecentlyViewedText(){
        String recentlyViewedText = searchPageObjects.getRecentlyViewedText();
        Assert.assertEquals(recentlyViewedText,recentlyViewedText_English);
    }

    @AfterSuite(alwaysRun = true)
    public void searchPageAfterSuite(){
        quitBaseDriver();
    }

}
