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
    public void searchPageBeforeSuite() throws Exception {
        androidDriver = getBaseDriver();
        pageInitializer();
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        random = new Random();
        softAssert = new SoftAssert();
        loginPageObjects.performAuthentication("1877755590","666666");
        sleep(4000);
        try {
            homePageObjects.selectAddress(0);
        } catch (Exception e){
            homePageObjects.createNewAddress();
        }
        sleep(2000);
        switchFromWebToNative();
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(5000);
        actionBarObjects.clickOnSearchImageButton();
        androidDriver.hideKeyboard();
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

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6,enabled = false)
    public void verifyRecentlyViewedFirstProductDetails(){
        String productName;
        String productNameFromUI;

        List<SearchRecentProductsModel.ResultsBean> resultsBeansFromApi = searchPageObjects.getResultsOfRecentProductsFromApiList();

        productName = resultsBeansFromApi.get(0).getName();
        softAssert.assertTrue(searchPageObjects.verifyScroll());
        sleep(1000);

        productNameFromUI = searchPageObjects.searchRecentProductsNameListUI().get(0).getText();
        if (productName.equals(productNameFromUI)) {
            //ui data
            List<String> containerDataUI = searchPageObjects.recentProductContainerDataFromUI(0);
            //api data
            List<String> containerDataApi = new ArrayList<>();
            containerDataApi.add(resultsBeansFromApi.get(0).getPrice());
            containerDataApi.add(resultsBeansFromApi.get(0).getOriginal_price());
            containerDataApi.add(resultsBeansFromApi.get(0).getProduct_stamp());
            String discount = String.valueOf(resultsBeansFromApi.get(0).getDiscount());
            containerDataApi.add(discount);
            //verify price
            softAssert.assertEquals(containerDataApi.get(0), containerDataUI.get(0));
            //verify original price and discount
            if (!resultsBeansFromApi.get(0).getOriginal_price().equals(resultsBeansFromApi.get(0).getPrice())) {
                softAssert.assertEquals(containerDataApi.get(1), containerDataUI.get(1));
                softAssert.assertEquals(containerDataApi.get(3),containerDataUI.get(3));
            }
            //verify DeliveryTag
            if (containerDataApi.get(2) != null) {
                softAssert.assertEquals(containerDataApi.get(2), containerDataUI.get(2));
            }
            softAssert.assertAll();
            System.out.println("done");
        }
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

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifyTextInSearchInputBox(){
        WebElement searchEditTextElement = searchPageObjects.searchBarEditText();
        Assert.assertEquals(searchEditTextElement.getText(),searchInputBoxText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyEnteringTextInSearchInputBox(){
        searchPageObjects.enterProductName(productName);
        Assert.assertEquals(searchPageObjects.searchBarEditText().getText(),productName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifyFirstSuggestionClickable(){
        WebElement firstSuggestionElement = searchPageObjects.getSuggestionElementUI(0);
        Assert.assertEquals(firstSuggestionElement.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifyFirstSuggestionAutoSuggestButtonClickable(){
        WebElement firstSuggestionAutoSuggestButtonElement = searchPageObjects.getAutoSuggestButtonList().get(0);
        Assert.assertEquals(firstSuggestionAutoSuggestButtonElement.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
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
