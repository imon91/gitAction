package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import static org.testng.Assert.*;
import pageObjects.*;
import services.responseModels.commerceModels.*;
import testData.*;
import utils.*;
import java.util.*;




public class Search extends AndroidBaseClass {

    private ActionBarObjects actionBarObjects;
    private SearchPageObjects searchPageObjects;
    MyActions myActions;
    private AndroidDriver<WebElement> androidDriver;
    private String suiteName;
    private SoftAssert softAssert;
    private Random random;
    private ServiceRequestLayer serviceRequestLayer;
    private Authentication authentication;
    private ReadJSONFile readJSONFile;
    private String app;
    private ProductListingPageObjects productListingPageObjects;

    @BeforeSuite(alwaysRun = true)
    public void smokeBeforeSuite(){
        try{
            PropertyReader.flushDynamicData();
        }catch (Exception e){
            System.out.println("Exception at SmokeBeforeSuite : flushDynamicData");
        }
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication()
                .performAuthentication();
    }

    @BeforeClass(alwaysRun = true)
    public void searchBeforeClass() {
        System.out.println("SearchBeforeClass is called");
        androidDriver = getBaseDriver();
        switchFromWebToNative();
        actionBarObjects = new ActionBarObjects(androidDriver);
        searchPageObjects = new SearchPageObjects(androidDriver);
        myActions = new MyActions();
        softAssert = new SoftAssert();
        random = new Random();
        authentication = new Authentication();
        serviceRequestLayer = new ServiceRequestLayer();
        readJSONFile = serviceRequestLayer.getControlOverReadJSONFile();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
        productListingPageObjects = new ProductListingPageObjects(androidDriver);
        setImplicitWait(15);
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
        sleep(2000);
        if(androidDriver.currentActivity().equalsIgnoreCase(AndroidActivities.resellerActivities.homeActivity)||androidDriver.currentActivity().equalsIgnoreCase(AndroidActivities.mokamActivities.homeActivity)){
            System.out.println("Current activity was home activity");
            actionBarObjects.clickOnSearchImageButton();}
        else if(androidDriver.currentActivity().equalsIgnoreCase(AndroidActivities.resellerActivities.searchActivity)||androidDriver.currentActivity().equalsIgnoreCase(AndroidActivities.mokamActivities.searchActivity)){
            System.out.println("Current activity was search activity");
            searchPageObjects.searchBarEditText().clear(); }
        else if(androidDriver.currentActivity().equalsIgnoreCase(AndroidActivities.resellerActivities.PLPActivity)) {
            System.out.println("The activity was PLP activity");
            productListingPageObjects.clickOnPLPBackButton();
            sleep(1500);
            actionBarObjects.clickOnSearchImageButton();}
        else {
            System.out.println("ExceptionAtSearchIconClick");
        }
    }



    @Test(groups = {"Search.Authentication with valid credential",
    CoreConstants.GROUP_REGRESSION},
    description = "Authentication for regression testCases in Search",
    priority = 1)
    public void authenticationWithValidCredential() throws Exception {
        authentication.authenticationSetUp();
        authentication.verifyAuthenticationWithValidCredentials("01877755590","666666");
    }


    @Test(  groups = {"Search.verifySearchFunctionalityWithoutSelectingSuggestions" ,
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyEditMobileNumber"},
            description = "Verifies Search Functionality Without Selecting Any Suggestions",
            priority = 4,
            enabled = false,
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
            enabled = false,
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
            priority = 2,
            dataProvider = "getProductName"  )
    public void verifySearchFunctionalityAndCancelIt(String productName){
        System.out.println("Verify search Functionality and cancel it was called");
        //Visibility of recently viewed container
        sleep(2000);
        assertTrue(searchPageObjects.recentlyViewedContainerVisibility());
        //entering search term
        searchPageObjects.enterProductName(productName);
        //visibility of searchSuggestion, not recentlyViewed container
        sleep(1500);
//        assertFalse(searchPageObjects.recentlyViewedContainerVisibility());
        //Visibility of search suggestions
        assertNotNull(searchPageObjects.searchSuggestionTitleListUI());

        //click on cancel button
        searchPageObjects.clickOnSearchCancelButton();
        softAssert.assertAll();
        sleep(500);
    }


    @Test(  groups = {"Search.verifySearchFunctionalityWithSelectingSuggestions" ,CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Search Functionality With Selecting Any Suggestions",
            priority = 6)
    public void verifySearchFunctionalityWithSelectingSuggestions() throws Exception {
        System.out.println("Verification of Search Functionality with selecting suggestions was called");

        //just enter product name
        int randomIndex = random.nextInt(readJSONFile.getJSONFileData(app).size());
        String productName = (String)readJSONFile.getJSONFileData(app).get(randomIndex);
         searchPageObjects.enterProductName(productName);
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
            System.out.println("The searchSuggestionDataWasVerified");
            //click on suggestion
           int index = random.nextInt(searchPageObjects.searchSuggestionTitleListUI().size());
            searchPageObjects.clickOnSearchSuggestion(index);
            sleep(3000);
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
            priority = 3)
    public void searchToObjectAndClickBack() throws Exception {
        System.out.println("Verification of search to object and click back called");
        //just enter product name
        int randomIndex = random.nextInt(readJSONFile.getJSONFileData(app).size());
        String productName = (String)readJSONFile.getJSONFileData(app).get(randomIndex);
        searchPageObjects.enterTheProductNameGoBack(productName);
    }

    @Test(  groups = {"Search.verifySearchTextBarPlaceHolderText" ,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Search bar place holder",
            priority = 4)
    public void searchPlaceHolder() {
        System.out.println("Verification of search place holder");
        String placeHolder = myActions.action_getText(searchPageObjects.searchBarEditText());
        System.out.print("the place holder was  "+placeHolder);
        assertNotNull(placeHolder);
        softAssert.assertAll();
    }


    @Test(  groups = {"Search.verifySearchBarPlaceHolderGone" ,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Search bar place holder vanish while entering text",
            priority = 5)
    public void searchPlaceHolderVanishWithSearchTerm() throws Exception {
        System.out.println("Verification of search place holder vanishing");
        int randomIndex = random.nextInt(readJSONFile.getJSONFileData(app).size());
        String productName = (String)readJSONFile.getJSONFileData(app).get(randomIndex);
        searchPageObjects.enterProductName(productName);
        String placeHolder = myActions.action_getText(searchPageObjects.searchBarEditText());
        assertEquals(productName,placeHolder);
        softAssert.assertAll();
        searchPageObjects.searchBarEditText().clear(); }

    @Test(  groups = {"Search.verifyCharacterInSearchBar" ,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies character in Search ",
            priority = 7)
    public void verifyCharactersAllowInSearchBox() {
        System.out.println("Verification of character in searchBar ");
        String productName = "shirt 1330 @!$";
        searchPageObjects.enterProductName(productName);
        String placeHolder = myActions.action_getText(searchPageObjects.searchBarEditText());
        assertEquals(placeHolder,(productName));
        softAssert.assertAll();
        searchPageObjects.searchBarEditText().clear();}


    @AfterClass(alwaysRun = true)
    public void searchAfterClass(){
        System.out.println("SearchAfterClass is called");
    }

    @AfterSuite(alwaysRun = true)
    public void resellerAndroidAfterSuite(){
        System.out.println("AfterSuite Is Called");
        quitBaseDriver();
    }


}
