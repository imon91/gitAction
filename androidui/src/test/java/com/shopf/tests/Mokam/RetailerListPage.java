package com.shopf.tests.Mokam;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import services.responseModels.commerceModels.MokamRetailerListModel;
import utils.*;

import java.util.*;

public class RetailerListPage extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private SalesRepFeaturePageObject salesRepFeaturePageObject;
    private ServiceRequestLayer serviceRequestLayer;
    private Random random;
    private SoftAssert softAssert;
    String selectARetailerText_English = "Select a Retailer";
    String searchInputBoxText_English = "Enter shop name or phone number";
    String addANewRetailerButtonText_English = "Add a New Retailer";
    String nextButtonText_English = "NEXT";

    @BeforeSuite(alwaysRun = true)
    public void retailerListPageBeforeSuite(){
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
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemLogout();
        sleep(1000);
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        loginPageObjects.performAuthentication("1877775590","666666");
        sleep(1000);
    }

    public void pageInitializer(){
        homePageObjects = new HomePageObjects(androidDriver);
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
        WebElement searchInputBoxElement = salesRepFeaturePageObject.getSearchInputBoxElement();
        String searchValue = "ShopName";
        salesRepFeaturePageObject.enterTextInSearchInputBox(searchValue);
        Assert.assertEquals(searchValue,searchInputBoxElement.getText());
        searchInputBoxElement.clear();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifySearchingAShopWithName(){
        MokamRetailerListModel mokamRetailerListModel = salesRepFeaturePageObject.salesRepResultsApi();
        int totalRetailerSize = mokamRetailerListModel.getUser_data().size();
        System.out.println(totalRetailerSize);
        int randomNo = random.nextInt(totalRetailerSize);
        String randomShopName = null;
        if(mokamRetailerListModel.getUser_data().get(randomNo).getName()!=null ||
                mokamRetailerListModel.getUser_data().get(randomNo).getShop_name()!=null) {
            if (mokamRetailerListModel.getUser_data().get(randomNo).getShop_name()!=null) {
                randomShopName = mokamRetailerListModel.getUser_data().get(randomNo).getShop_name();
                salesRepFeaturePageObject.enterTextInSearchInputBox(randomShopName);
                List<String> retailerDataUIList = salesRepFeaturePageObject.getRetailerDataUI(0);
                Assert.assertEquals(randomShopName,retailerDataUIList.get(0));
                salesRepFeaturePageObject.getSearchInputBoxElement().clear();
            }else if (mokamRetailerListModel.getUser_data().get(randomNo).getName()!=null){
                randomShopName = mokamRetailerListModel.getUser_data().get(randomNo).getName();
                salesRepFeaturePageObject.enterTextInSearchInputBox(randomShopName);
                List<String> retailerDataUIList = salesRepFeaturePageObject.getRetailerDataUI(0);
                Assert.assertEquals(randomShopName,retailerDataUIList.get(0));
                salesRepFeaturePageObject.getSearchInputBoxElement().clear();
            }
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifySearchingAShopWithMobileNumber(){
        MokamRetailerListModel mokamRetailerListModel = salesRepFeaturePageObject.salesRepResultsApi();
        int totalRetailerSize = mokamRetailerListModel.getUser_data().size();
        System.out.println(totalRetailerSize);
        int randomNo = random.nextInt(totalRetailerSize);
        String randomMobileNumber = mokamRetailerListModel.getUser_data().get(randomNo).getPhone();
        salesRepFeaturePageObject.enterTextInSearchInputBox(randomMobileNumber);
        List<String> retailerDataUIList = salesRepFeaturePageObject.getRetailerDataUI(0);
        Assert.assertEquals(randomMobileNumber,retailerDataUIList.get(1));
        salesRepFeaturePageObject.getSearchInputBoxElement().clear();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifyFirstRetailerDetails(){
        MokamRetailerListModel mokamRetailerListModel = salesRepFeaturePageObject.salesRepResultsApi();
        List<String> retailerDataUIList = salesRepFeaturePageObject.getRetailerDataUI(0);
        List<String> firstRetailerDetails_Backend = new ArrayList<>();
        if(mokamRetailerListModel.getUser_data().get(0).getName()!=null ||
                mokamRetailerListModel.getUser_data().get(0).getShop_name()!=null) {
            if (mokamRetailerListModel.getUser_data().get(0).getShop_name()!=null) {
                firstRetailerDetails_Backend.add(0,mokamRetailerListModel.getUser_data().get(0).getShop_name());
                softAssert.assertEquals(retailerDataUIList.get(0),firstRetailerDetails_Backend.get(0));
            }else if (mokamRetailerListModel.getUser_data().get(0).getName()!=null){
                firstRetailerDetails_Backend.add(0,mokamRetailerListModel.getUser_data().get(0).getName());
                softAssert.assertEquals(retailerDataUIList.get(0),firstRetailerDetails_Backend.get(0));
            }
        }
        firstRetailerDetails_Backend.add(1,mokamRetailerListModel.getUser_data().get(0).getPhone());
        softAssert.assertEquals(retailerDataUIList.get(1),firstRetailerDetails_Backend.get(1));

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifySelectingAShop(){
        salesRepFeaturePageObject.clickARetailer(0);
        Assert.assertEquals(salesRepFeaturePageObject.getARetailerElement(0).getAttribute("selected"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyNextButtonClickable(){
        Assert.assertEquals(salesRepFeaturePageObject.getNextButtonInRetailerListPageElement().getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyNextButtonText(){
        String nextButtonText = salesRepFeaturePageObject.getNextButtonTextInRetailerListPage();
        Assert.assertEquals(nextButtonText,nextButtonText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifyAddNewRetailerButtonText(){
        salesRepFeaturePageObject.scrollToEndAtSalesRepList();
        Assert.assertEquals(salesRepFeaturePageObject.getAddNewRetailerButtonElement().getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifyAddNewRetailerButtonClickable(){
        String addNewRetailerButtonText = salesRepFeaturePageObject.getAddNewRetailerButtonText();
        Assert.assertEquals(addNewRetailerButtonText,addANewRetailerButtonText_English);
    }

    @AfterSuite(alwaysRun = true)
    public void retailerListPageAfterSuite(){
        quitBaseDriver();
    }

}
