package com.shopf.tests.Mokam;

import coreUtils.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import services.responseModels.commerceModels.*;
import utils.*;

import java.util.*;

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
    String productName = "Dettol";
    String recentlyViewedText_English = "Recently Viewed";
    String searchInputBoxText_English = "Search";

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
        Assert.assertEquals(currentActivity, AndroidActivities.mokamActivities.searchActivity);
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

    public void verifyRecentlyViewedFirstProductDetails(){
        List<SearchRecentProductsModel.ResultsBean> recentlyViewedProductsResultsList_backend = searchPageObjects.getResultsOfRecentProductsFromApiList();
        List<String> recentlyViewedProductsResultsList_UI = searchPageObjects.recentProductContainerDataFromUI(0);

        String firstRecentProductName = searchPageObjects.getRecentProductName(0);
        String firstRecentProductName_Backend = recentlyViewedProductsResultsList_backend.get(0).getName();
        softAssert.assertEquals(firstRecentProductName,firstRecentProductName_Backend);

        String firstRecentProductPrice = recentlyViewedProductsResultsList_UI.get(0);
        String firstRecentProductPrice_Backend = recentlyViewedProductsResultsList_backend.get(0).getPrice();
        softAssert.assertEquals(firstRecentProductPrice,firstRecentProductPrice_Backend);


        softAssert.assertEquals(recentlyViewedProductsResultsList_UI.get(1),recentlyViewedProductsResultsList_backend.get(0).getOriginal_price());


    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyRecentlyViewedFirstProductClickable(){
        WebElement recentlyViewedFirstProductElement = searchPageObjects.getRecentlyViewedProductElement(0);
        Assert.assertEquals(recentlyViewedFirstProductElement.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifyRecentlyViewedPanelScrollable(){
        WebElement recentlyViewedPanelElement = searchPageObjects.getRecentlyViewedContainerElement();
        Assert.assertEquals(recentlyViewedPanelElement.getAttribute("scrollable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifyTextInSearchInputBox(){
        WebElement searchEditTextElement = searchPageObjects.searchBarEditText();
        Assert.assertEquals(searchEditTextElement.getText(),searchInputBoxText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifyEnteringTextInSearchInputBox(){
        searchPageObjects.enterProductName(productName);
        Assert.assertEquals(searchPageObjects.searchBarEditText().getText(),productName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyFirstSuggestionClickable(){
        System.out.println(searchPageObjects.getSuggestionElementUI(0));
        WebElement firstSuggestionElement = searchPageObjects.getSuggestionElementUI(0);
        Assert.assertEquals(firstSuggestionElement.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifyFirstSuggestionAutoSuggestButtonClickable(){
        WebElement firstSuggestionAutoSuggestButtonElement = searchPageObjects.getAutoSuggestButtonList().get(0);
        Assert.assertEquals(firstSuggestionAutoSuggestButtonElement.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyFirstSuggestion(){
        List<SearchSuggestionsModel.ResultsBean.SuggestionsBean> suggestionsBeanList = searchPageObjects.searchSuggestionListFromApi(productName);

        String firstTitle = searchPageObjects.getSearchSuggestionDataFromUI(0,"title");
        String firstTitle_Backend = suggestionsBeanList.get(0).getValue().getTitle();
        softAssert.assertEquals(firstTitle,firstTitle_Backend);

        String firstInLineLabel = searchPageObjects.getSearchSuggestionDataFromUI(0,"inLineLabel");
        String firstInLineLabel_Backend = suggestionsBeanList.get(0).getValue().getInline_label();
        softAssert.assertEquals(firstInLineLabel,firstInLineLabel_Backend);

        softAssert.assertAll();
    }

    @AfterSuite(alwaysRun = true)
    public void searchPageAfterSuite(){
        quitBaseDriver();
    }

}
