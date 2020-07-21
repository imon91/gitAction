package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.*;
import pageObjects.*;
import services.responseModels.commerceModels.*;
import utils.*;

import java.util.ArrayList;
import java.util.List;




public class Search extends AndroidBaseClass {

    private ActionBarObjects actionBarObjects;
    private SearchPageObjects searchPageObjects;
    MyActions myActions;
    private AndroidDriver<WebElement> androidDriver;
    private String suiteName;
    private SoftAssert softAssert;




    @BeforeClass(alwaysRun = true)
    public void searchBeforeClass(){
        System.out.println("SearchBeforeClass is called");
        androidDriver = getBaseDriver();
        switchFromWebToNative();
        actionBarObjects = new ActionBarObjects(androidDriver);
        actionBarObjects.clickOnSearchImageButton();
        searchPageObjects = new SearchPageObjects(androidDriver);
        myActions = new MyActions();
        softAssert = new SoftAssert();
    }


   @BeforeTest
   @Parameters("suite")
   public void searchModuleTests(String suiteNameFromXMLFile)
   {
       suiteName = suiteNameFromXMLFile;
   }

    @DataProvider(name = "getProductName")
    public Object[][] getProductName(){
        String searchTerm = null;
        if(System.getProperty(BuildParameterKeys.KEY_APP)
                .equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            searchTerm = "Biscuit";
        }else if(System.getProperty(BuildParameterKeys.KEY_APP)
                .equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            searchTerm = "Shirts";
        }
        return new Object[][]{
                {searchTerm}
        };
    }



    @Test(  groups = {"Search.verifySearchFunctionalityWithoutSelectingSuggestions" ,
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyEditMobileNumber"},
            description = "Verifies Search Functionality Without Selecting Any Suggestions",
            dataProvider = "getProductName"  )
    public void verifySearchFunctionalityWithoutSelectingSuggestions(String productName){
        System.setProperty("androidSearchTerm",productName);
        System.out.println("verifySearchFunctionalityWithoutSelectingSuggestions is called");
        System.out.println("Current Activity at Search is : "+androidDriver.currentActivity());
        searchPageObjects.searchForTheGivenProduct(productName);
        //sleep(5000);
        // Verification Step Pending
        // Call an Api that fetches all the data related to the search
    }


    @Test(  groups = {"Search.verifyRecentlyViewedProduct" ,
            CoreConstants.GROUP_SANITY},
            enabled = false,
            dependsOnGroups = {"Authentication.verifyEditMobileNumber"},
            description = "Verifies click on recently viewed product")
    public void verifyRecentlyViewedProductClickable()
    {
        System.out.println("verification of recently viewed product was called");
        sleep(5000);
//        AndroidElement recentviewed =  androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']"));
//         myActions.action_click(recentviewed);
//        new WebDriverWait(androidDriver, 5000).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@index='0']")));
//        androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")).click();

        WebElement product = androidDriver.findElement(By.id("com.shopup.reseller:id/item"));
        WebElement productname = androidDriver.findElement(By.id("com.shopup.reseller:id/tvName"));
        String productName = myActions.action_getText(productname);
        myActions.action_click(product);
        sleep(2000);
        WebElement popup = androidDriver.findElementById("com.shopup.reseller:id/btnOKTutorial");
        myActions.action_click(popup);
        WebElement productnameatpdp = androidDriver.findElementById("com.shopup.reseller:id/product_name");
        String productNameAtPDP = myActions.action_getText(productnameatpdp);

       if(productName.equalsIgnoreCase(productNameAtPDP)){
           System.out.println("product was verified");
       }
    }


    @Test(  groups = {"Search.verifySearchFunctionalityWithCancellingIt" ,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Search Functionality and Cancelling it",
            dataProvider = "getProductName"  )
    public void verifySearchFunctionalityAndCancelIt(String productName){
        searchPageObjects.enterTheProductNameAndCancel(productName);
    }


    @Test(  groups = {"Search.verifySearchFunctionalityWithSelectingSuggestions" ,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Search Functionality With Selecting Any Suggestions",
            dataProvider = "getProductName"  )
    public void verifySearchFunctionalityWithSelectingSuggestions(String productName){

        //just enter product name
        WebElement searchBarText = idSetter("com.shopup.reseller:id/etSearch");
        myActions.action_sendKeys(searchBarText,productName);
        sleep(15000);

        //verifying data :title
        for(int i=0;i<searchPageObjects.searchSuggestionTitleListUI().size();i++) {
            if (i == 0 || i == searchPageObjects.searchSuggestionTitleListUI().size() || suiteName.equalsIgnoreCase("regression")) {
                String uiSuggestion = searchPageObjects.getSearchSuggestionDataFromUI(i, "title");
                sleep(2000);
                String apiSuggestion = searchPageObjects.searchSuggestionDataFromApi("title").get(i);
                sleep(2000);
                assertTrue(uiSuggestion.equalsIgnoreCase(apiSuggestion));
            }
            }

        //verifying data inlineLabel
            for (int j = 0; j < searchPageObjects.searchSuggestionInLineLabelListUI().size(); j++) {
                if(j==0||j==searchPageObjects.searchSuggestionTitleListUI().size()||suiteName.equalsIgnoreCase("regression")){
                String uiSuggestion1 = searchPageObjects.getSearchSuggestionDataFromUI(j, "inLineLabel");
                sleep(2000);
                String apiSuggestion1 = searchPageObjects.searchSuggestionDataFromApi("inLineLabel").get(j);
                sleep(2000);
                assertTrue(uiSuggestion1.equalsIgnoreCase(apiSuggestion1));
            }
            System.out.println("The serchSuggestionDataWasVerified");
            //click on suggession
            sleep(1000);
            searchPageObjects.clickOnSearchSuggestion(1);
        }
    }


   @Test(  groups = {"Search.verifySearchFunctionalityWithSelectingSuggestions" ,
           CoreConstants.GROUP_REGRESSION},
           description = "Verifies Search Functionality With Selecting Any Suggestions")

   public void verifyRecentlyViewedProducts() {
       String productName;
       String productNameFromUI;

       List<SearchRecentProductsModel.ResultsBean> resultsBeansFromApi = searchPageObjects.getResultsOfRecentProductsFromApiList();

       for (int productIndex = 0; productIndex < resultsBeansFromApi.size(); productIndex++) {
           if (productIndex == 0 || productIndex == searchPageObjects.searchSuggestionTitleListUI().size() || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

               productName = resultsBeansFromApi.get(productIndex).getName();
//                searchPageObjects.scrollToElement(productName);
               assertTrue(searchPageObjects.verifyScroll());
               sleep(1000);

               for (int j = 0; j < searchPageObjects.searchRecentProductsNameListUI().size(); j++) {
                   productNameFromUI = myActions.action_getText(searchPageObjects.searchRecentProductsNameListUI().get(j));
                   if (productName.equals(productNameFromUI)) {
                       //ui data
                       List<String> containerDataUI = searchPageObjects.recentProductContainerDataFromUI(j);
                       System.out.println(j);
                       //api data
                       List<String> containerDataApi = new ArrayList<>();
                       containerDataApi.add(resultsBeansFromApi.get(productIndex).getPrice());
                       containerDataApi.add(resultsBeansFromApi.get(productIndex).getOriginal_price());
                       containerDataApi.add(resultsBeansFromApi.get(productIndex).getProduct_stamp());
                       String discount = String.valueOf(resultsBeansFromApi.get(productIndex).getDiscount());
                       containerDataApi.add(discount);
                       //verify price
                       assertEquals(containerDataApi.get(0), containerDataUI.get(0));
                       //verify original price and discount
                       if (!resultsBeansFromApi.get(productIndex).getOriginal_price().equals(resultsBeansFromApi.get(productIndex).getPrice())) {
                           assertEquals(containerDataApi.get(1), containerDataUI.get(1));
                           assertEquals(containerDataApi.get(3),containerDataUI.get(3));
                       }
                       //verify DeliveryTag
                       if (containerDataApi.get(2) != null) {
                           assertEquals(containerDataApi.get(2), containerDataUI.get(2));
                       }
                       softAssert.assertAll();
                       System.out.println("done");
                   }
               }
           }
//        }
           System.out.println("Recently Viewed Products Was Verified");

       }
   }



    @AfterClass(alwaysRun = true)
    public void searchAfterClass(){
        System.out.println("SearchAfterClass is called");
    }


}
