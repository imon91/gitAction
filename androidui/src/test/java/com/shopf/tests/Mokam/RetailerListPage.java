package com.shopf.tests.Mokam;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.responseModels.commerceModels.MokamRetailerListModel;
import utils.*;

import java.util.*;

public class RetailerListPage extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private SalesRepFeaturePageObject salesRepFeaturePageObject;
    private ServiceRequestLayer serviceRequestLayer;
    private Random random;
    private WebElement addNewRetailerButtonElement;
    private WebElement nextButtonElement;
    private WebElement searchInputBoxElement;
    String selectARetailerText_English = "Select a Retailer";
    String searchInputBoxText_English = "Enter shop name or phone number";
    String addANewRetailerButtonText_English = "";
    String nextButtonText_English = "";

    @BeforeSuite(alwaysRun = true)
    public void retailerListPageBeforeSuite(){
        androidDriver = getBaseDriver();
        pageInitializer();
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        random = new Random();
        loginPageObjects.performAuthentication("1877755590","666666");
        sleep(4000);
        xpathSetter("//androidx.cardview.widget.CardView[@index='0']/android.view.ViewGroup[@index='0']").click();
        sleep(2000);
        switchFromWebToNative();
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(5000);
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemLogout();
        sleep(1000);
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        loginPageObjects.performAuthentication("1877775590","666666");
        sleep(1000);
    }

    public void pageInitializer(){
        loginPageObjects = new LoginPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        salesRepFeaturePageObject = new SalesRepFeaturePageObject(androidDriver);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 0)
    public void verifyCurrentActivity(){
        String currentActivity = androidDriver.currentActivity();
        Assert.assertEquals(currentActivity,CoreConstants.ANDROID_SALES_REP_LIST_ACTIVITY);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifySelectARetailerText(){
        String selectARetailerText = salesRepFeaturePageObject.getSelectARetailerText();
        Assert.assertEquals(selectARetailerText, selectARetailerText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyTextInSearchInputBox(){
        String searchInputBoxText = salesRepFeaturePageObject.getTextInSearchInputBox();
        Assert.assertEquals(searchInputBoxText,searchInputBoxText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyEnteringTextInSearchInputBox(){
        searchInputBoxElement = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/retailer_search']");
        String searchValue = "ShopName";
        salesRepFeaturePageObject.enterTextInSearchInputBox(searchValue);
        Assert.assertEquals(searchValue,searchInputBoxElement.getText());
        searchInputBoxElement.clear();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifySearchingAShopWithName(){
        MokamRetailerListModel mokamRetailerListModel = salesRepFeaturePageObject.salesRepResultsApi();
        System.out.println(mokamRetailerListModel.getUser_data());
        int totalRetailerSize = mokamRetailerListModel.getUser_data().size();
        System.out.println(totalRetailerSize);
        int randomNo = random.nextInt(totalRetailerSize);
        String randomShopName = mokamRetailerListModel.getUser_data().get(randomNo).getName();
        salesRepFeaturePageObject.enterTextInSearchInputBox(randomShopName);
        List<String> retailerList = salesRepFeaturePageObject.getRetailerDataUI(randomNo);
        Assert.assertEquals(randomShopName,retailerList.get(0));
    }

    public void verifySearchingAShopWithMobileNumber(){

    }

    @AfterSuite(alwaysRun = true)
    public void retailerListPageAfterSuite(){
        quitBaseDriver();
    }

}
