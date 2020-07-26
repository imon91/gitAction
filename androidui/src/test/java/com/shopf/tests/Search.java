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
import java.util.*;




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
        searchPageObjects = new SearchPageObjects(androidDriver);
        myActions = new MyActions();
        softAssert = new SoftAssert();
    }


   @BeforeTest(alwaysRun = true)
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


    @BeforeMethod(groups = {CoreConstants.GROUP_REGRESSION,
    CoreConstants.GROUP_SANITY},
    description = "Before method for every test")
    public void searchBeforeMethod()
    {
        actionBarObjects.clickOnSearchImageButton();
    }



    @Test(  groups = {"Search.verifySearchFunctionalityWithoutSelectingSuggestions" ,
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyEditMobileNumber"},
            description = "Verifies Search Functionality Without Selecting Any Suggestions",
            priority = 4,
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
            dependsOnGroups = {"Authentication.verifyEditMobileNumber"},
            priority = 6,
            description = "Verifies click on recently viewed product")
    public void verifyRecentlyViewedProductClickable()
    {
        System.out.println("verification of recently viewed product was called");
        sleep(5000);

        WebElement product = androidDriver.findElement(By.id("com.shopup.reseller:id/item"));
        WebElement productName = androidDriver.findElement(By.id("com.shopup.reseller:id/tvName"));
        String productName1 = myActions.action_getText(productName);
        myActions.action_click(product);
        sleep(2000);
        WebElement popup = androidDriver.findElementById("com.shopup.reseller:id/btnOKTutorial");
        myActions.action_click(popup);
        WebElement productNameAtPdp = androidDriver.findElementById("com.shopup.reseller:id/product_name");
        String productNameAtPDP = myActions.action_getText(productNameAtPdp);

       if(productName1.equalsIgnoreCase(productNameAtPDP)){
           System.out.println("product was verified");
       }
    }


    @Test(  groups = {"Search.verifySearchFunctionalityWithCancellingIt" ,CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Search Functionality and Cancelling it",
            priority = 1,
            dataProvider = "getProductName"  )
    public void verifySearchFunctionalityAndCancelIt(String productName){
        System.out.println("Verify search Functionality and cancel it was called");
        searchPageObjects.enterTheProductNameAndCancel(productName);
        androidDriver.navigate().back();
    }


    @Test(  groups = {"Search.verifySearchFunctionalityWithSelectingSuggestions" ,CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Search Functionality With Selecting Any Suggestions",
            priority = 2,
            dataProvider = "getProductName"  )
    public void verifySearchFunctionalityWithSelectingSuggestions(String productName){
        System.out.println("Verification of Search Functionality with selecting suggestions was called");

        //just enter product name
        WebElement searchBarText = idSetter("com.shopup.reseller:id/etSearch");
        myActions.action_sendKeys(searchBarText,productName);
        sleep(1000);

        List<SearchSuggestionsModel.ResultsBean.SuggestionsBean> searchSuggestionDataFromApi = searchPageObjects.searchSuggestionListFromApi(productName);
        //verifying data :title
        for(int i=0;i<searchPageObjects.searchSuggestionTitleListUI().size();i++) {
            if (i == 0 || i ==(searchPageObjects.searchSuggestionTitleListUI().size()-1) || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION) ) {
                String uiSuggestion = searchPageObjects.getSearchSuggestionDataFromUI(i, "title");
                sleep(2000);
                String apiSuggestion = searchSuggestionDataFromApi.get(i).getValue().getTitle();
                sleep(2000);
                assertTrue(uiSuggestion.equalsIgnoreCase(apiSuggestion));
            }
            }

        //verifying data inlineLabel
            for (int j = 0; j < searchPageObjects.searchSuggestionInLineLabelListUI().size(); j++) {
                if (j == 0 || j == (searchPageObjects.searchSuggestionInLineLabelListUI().size()-1) || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION )) {
                    String uiSuggestion1 = searchPageObjects.getSearchSuggestionDataFromUI(j, "inLineLabel");
                    sleep(2000);
                    String apiSuggestion1 = searchSuggestionDataFromApi.get(j).getValue().getInline_label();
                    sleep(2000);
                    assertTrue(uiSuggestion1.equalsIgnoreCase(apiSuggestion1));
                }
            }
            System.out.println("The serchSuggestionDataWasVerified");
            //click on suggession
            sleep(1000);
            searchPageObjects.clickOnSearchSuggestion(1);
    }


   @Test(  groups = {"Search.verifySearchFunctionalityWithSelectingSuggestions" ,
           CoreConstants.GROUP_REGRESSION},
           enabled  =false,
           description = "Verifies Search Functionality With Selecting Any Suggestions")

   public void verifyRecentlyViewedProducts() {
        System.out.println("Verification of recently viewed products was called");
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

    @Test(  groups = {"Search.verifySearchToObjectAndClickBack" ,CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Search To object and go back",
            priority = 5,
            dataProvider = "getProductName" )
    public void searchToObjectAndClickBack(String productName)
    {
        System.out.println("Verification of search to object and click back called");
        searchPageObjects.enterTheProductNameGoBack(productName);
    }





    @AfterClass(alwaysRun = true)
    public void searchAfterClass(){
        System.out.println("SearchAfterClass is called");
    }


}
