package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import static org.testng.Assert.*;
import pageObjects.*;
import services.responseModels.commerceModels.*;
import utils.*;
import java.util.*;



public class PLP extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private ProductListingPageObjects productListingPageObjects;
    private SortPageObjects sortPageObjects;
    private ProductFilterPageObjects productFilterPageObjects;
    private SearchPageObjects searchPageObjects;
    private ActionBarObjects actionBarObjects;
    private SoftAssert softAssert;
    private String suiteName;
    private AndroidScriptRouter androidScriptRouter;
    private String app;




    @BeforeClass(alwaysRun = true)
    public void productListingPageBeforeClass() throws Exception{
        System.out.println("PLPBeforeClass is called");
        androidDriver = getBaseDriver();
        productListingPageObjects = new ProductListingPageObjects(androidDriver);
        sortPageObjects = new SortPageObjects(androidDriver);
        searchPageObjects = new SearchPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        softAssert = new SoftAssert();
        androidScriptRouter = new AndroidScriptRouter();
//        String activityName = androidDriver.currentActivity();
//        androidScriptRouter.getMeTheCurrentPage();
//        androidScriptRouter.getTheControlHere(activityName,null);
        productFilterPageObjects = new ProductFilterPageObjects(androidDriver);
        app=System.getProperty(BuildParameterKeys.KEY_APP);

    }


    @Parameters("suite")


    @BeforeMethod(groups = {CoreConstants.GROUP_REGRESSION,CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_SANITY},
            description = "Before method for every test")
    public void beforeMethod()
    {
        String productName="shirts";
        actionBarObjects.clickOnSearchImageButton();
        searchPageObjects.searchForTheGivenProduct(productName);
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




    @Test(  groups = {"PLP.verifyApplyingSortOnPLP",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "Verifies Applying Sort On The Product List",
            priority = 2,
            dependsOnGroups = "Search.verifySearchFunctionalityWithoutSelectingSuggestions"  )
    public void verifyApplyingSortOnPLP(){ System.out.println("Verify applying sort was called");
        productListingPageObjects.clickOnSortButton();
        // Get the value from sort key
        System.out.println("Current Activity at PLP on Sort is : "+androidDriver.currentActivity());
        Random random1 = new Random();
        int randomSortIndex = random1.nextInt(sortPageObjects.getSortTexts().size());
        if (System.getProperty(BuildParameterKeys.KEY_APP).equalsIgnoreCase(CoreConstants.APP_RESELLER))
        {
        if(sortPageObjects.getSortTexts()
                .get(randomSortIndex).getText().equalsIgnoreCase("What's New") ||
                sortPageObjects.getSortTexts()
                        .get(randomSortIndex).getText().equalsIgnoreCase("SORT") ){
            randomSortIndex = randomSortIndex+1;
        }sortPageObjects.clickOnSortElement(sortPageObjects.getSortTexts()
                .get(randomSortIndex).getText());
        }
        else if (System.getProperty(BuildParameterKeys.KEY_APP).equalsIgnoreCase(CoreConstants.APP_MOKAM))
        { sortPageObjects.clickOnSortElement(sortPageObjects.getSortTexts()
                    .get(2).getText());
        }
        // Verify sorted products from their sort orders
    }

    @DataProvider(name = "dataForApplyFilter")
    private Object[][] dataForApplyFilter(){
        String filterCategory = null;
        String filterItem = null;
        if(System.getProperty(BuildParameterKeys.KEY_APP)
                .equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            filterCategory = "Category";
            filterItem = "Men Shirts";
        }else if(System.getProperty(BuildParameterKeys.KEY_APP)
                .equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            filterCategory = "Category";
            filterItem = "Men Shirts";
        }

        return new Object[][]{
                {filterCategory,filterItem}
        };
    }


    @Test(  groups = {"PLP.verifyApplyingFilterOnPLP",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            dataProvider = "dataForApplyFilter",
            description = "Verifies Applying Filter On The PLP Page",
            priority = 1)

    public void verifyApplyingFilterOnPLP(String filterCategory,String filterItem) {
        System.out.println("Verify applying filter on plp was called");
        productListingPageObjects.clickOnFilterButton();
        if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)) {
            productFilterPageObjects.clickOnFilterName(productFilterPageObjects.getListOfFilterNames().get(0));
            productFilterPageObjects.clickOnFilterItemByIndex(productFilterPageObjects.getListOfFilterItemCheckBoxes().get(0));
            productFilterPageObjects.clickOnApplyFilter();
        } else if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            Random random1 = new Random();
            int randomCategory = random1.nextInt(productFilterPageObjects.getListOfFilterNames().size());
            // Select Some Random Filter Parent
            productFilterPageObjects.
                    clickOnFilterName(productFilterPageObjects.
                            getListOfFilterNames().get(randomCategory));
            //productFilterPageObjects.clickOnFilterNameByValue(filterCategory);

            // select Random Item
            Random random2 = new Random();
            int randomValue = random2.nextInt(productFilterPageObjects.getListOfFilterItemCheckBoxes().size());
//            productFilterPageObjects.
//                    clickOnFilterItemByValue(filterItem);
            productFilterPageObjects
                    .clickOnFilterItemByIndex(productFilterPageObjects.
                            getListOfFilterItemCheckBoxes().get(randomValue));
            // Click on Apply Filter button
            productFilterPageObjects.clickOnApplyFilter();
        }
    }


    @Test(groups = {"PLP.verifySelectingItemOnPLP",
            CoreConstants.GROUP_SMOKE},
            enabled = true,
            description = "Verifies Selecting Item On PLP",
            priority = 9)
    public void verifySelectingItemOnPLP(){
        System.out.println("Verify selecting item on PLP");
        int productsCount = productListingPageObjects.getItemImages().size();
        System.out.println("Total Products are : "+productsCount);
        System.out.println("Current Activity at PLP on Listing is : "+androidDriver.currentActivity());
        Random random = new Random();
        int index = random.nextInt(productsCount);
        System.out.println("Random Product Index is : "+(index));
        productListingPageObjects.clickOnProductItem(productListingPageObjects.getItemImages().get(index));
    }


    @Test(groups = {"PLP.verifySelectingValidSizeItemOnPLP",
            CoreConstants.GROUP_SANITY},
            enabled = true,
            description = "Verifies Selecting Item On PLP",
            priority = 10)
            public void verifySelectingValidSizeItemOnPlpToPDP(){
        System.out.println("Verify selecting valid size item on PLP to PDP");
        try {
            String searchTerm = PropertyReader.getValueOfKey(PropertyReader.Keys.SEARCH_TERM);
            productListingPageObjects.selectValidProductToPDP(searchTerm);
        }catch (Exception e){
            System.out.println("Exception At VerifySelectingValidSizeItemOnPlpToPDP : While Reading SEARCH_TERM");
        }

    }


    public void verifyValidItemAddToCartThroughPLPMain(int qty){

    }


    @Test(  groups = {"PLP.verifyApplying/RemovingFilterOnPLP",
            CoreConstants.GROUP_SANITY},
            description = "Verifies Applying / Removing Filter On The PLP Page",
            priority = 3)

    public void verifyApplyingAndRemovingFilterOnPLP(){
        System.out.println("Verify Applying and removing Filter on PLP");

       String totalItem= productListingPageObjects.getTextOnTitleHeader();
        //adding filter
        productListingPageObjects.clickOnFilterButton();

        productFilterPageObjects.
                clickOnFilterName(productFilterPageObjects.
                        getListOfFilterNames().get(0));

        System.out.println("Current Activity at PLP on Filter is : "+androidDriver.currentActivity());

        productFilterPageObjects.
                clickOnFilterItemByValue("Men Shirts");
        productFilterPageObjects.
                clickOnFilterName(productFilterPageObjects.
                        getListOfFilterNames().get(1));
        productFilterPageObjects.
                clickOnFilterItemByValue("500 - 1000 Tk");
        productFilterPageObjects.clickOnApplyFilter();

        //removing filter
        productListingPageObjects.clickOnFilterButton();
        productFilterPageObjects.clickOnClearFilter();
        productFilterPageObjects.clickOnApplyFilter();
        String totalitem = productListingPageObjects.getTextOnTitleHeader();

        if(totalItem.equalsIgnoreCase(totalitem)){
            System.out.println(totalItem);
        System.out.println("Remove Filter Function was verified");
        }
    }




    @Test(groups = {"PLP.Verify all data of products",CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify product dates in PLP page",
            priority = 4,
             dataProvider = "getProductName")
    public void verifyProductsDataInPLPWithoutFilter(String searchTerm) throws Exception {
        System.out.println("Verify products Data in PLP without Filter");
        int totalNumberOfPages = productListingPageObjects.totalNumberOfPages(searchTerm,"null");
        System.out.println("The total pages :" + totalNumberOfPages);
        String productNameFromApi;

            for (int page = 1; page <= totalNumberOfPages; page++) {

                if (page == 1 || page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                    List<ProductListingResultsModel.ResultsBean> productResultsPLPApi = productListingPageObjects.productResultsPLPApi(searchTerm, page,"null").getResults();

                for (int productIndex = 0; productIndex < productResultsPLPApi.size(); productIndex++) {
                    if (productIndex == 0 && page == 1 || productIndex == productResultsPLPApi.size() - 1 && page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                        productNameFromApi = productResultsPLPApi.get(productIndex).getName();
                        //scroll to last product if "test=sanity"
                        if (suiteName.equalsIgnoreCase(CoreConstants.GROUP_SANITY) && (productIndex == productResultsPLPApi.size() - 1)) {
                            System.out.println("The test was sanity");
                            String totalNumberOfProduct = productListingPageObjects.getTextOnTitleHeader();
                            String numerical = totalNumberOfProduct.replaceAll("[^0-9]", "");
                            int number = Integer.parseInt(numerical);
                            int numberOfSwipe = (number - 1) / 2;
                            for (int w = 1; w <= numberOfSwipe; w++) {
                                productListingPageObjects.verifyScroll();
                            }
                        }
                        for (int j = 0; j < productListingPageObjects.productPropertiesListUI("name").size(); j++) {
                            String names = productListingPageObjects.namesListOfProduct(j);
                            if (productNameFromApi.equalsIgnoreCase(names)) {
                                List<String> productPropertiesUI = productListingPageObjects.getDetailsOfProductContainerUI(j);
                                //Storing all values from Api in array
                                List<String> productPropertiesApi = new ArrayList<>();
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getPrice());
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getOriginal_price());
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getProduct_stamp());
                                productPropertiesApi.add(String.valueOf(productResultsPLPApi.get(productIndex).getDiscount()));
                                System.out.println(productPropertiesApi);

                                //verification of price
                                assertTrue(productPropertiesApi.get(0).equalsIgnoreCase(productPropertiesUI.get(0)));
                                //Verification of Discount and original price
                                if (!productResultsPLPApi.get(productIndex).getOriginal_price().equals(productResultsPLPApi.get(productIndex).getPrice())) {
                                    assertTrue(productPropertiesApi.get(1).equalsIgnoreCase(productPropertiesUI.get(1)));
                                    assertTrue(productPropertiesApi.get(3).equalsIgnoreCase(productPropertiesUI.get(3)));
                                }
                                //verification of DeliveryTag
                                if (productResultsPLPApi.get(productIndex).getProduct_stamp() != null) {
                                    assertTrue(productPropertiesApi.get(2).equalsIgnoreCase(productPropertiesUI.get(2)));
                                }
                                softAssert.assertAll();
                                System.out.println("All data of product were verified successfully");
                            }
                        }
                        if ((productIndex % 2 != 0) && !suiteName.equalsIgnoreCase(CoreConstants.GROUP_SANITY)) {
                            productListingPageObjects.verifyScroll();
                        }
                    }

                }

            }
        }
    }

    @Test(groups = {"PLP.Verify all data of products after filter",CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify product dates in PLP page after filter",
            priority = 5,
             dataProvider = "getProductName")
    public void verifyProductsDataInPLPWithFilterOnly(String searchTerm) throws Exception {
        System.out.println("Verify products Data in PLP with Filter Only");
        //applying Filter
        verifyApplyingFilterOnPLP(null,null);

        int totalNumberOfPages = productListingPageObjects.totalNumberOfPages(searchTerm,"filter");
        System.out.println("The total pages :" + totalNumberOfPages);
        String productNameFromApi;
        for (int page = 1; page <= totalNumberOfPages; page++) {
            if (page == 1 || page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                List<ProductListingResultsModel.ResultsBean> productResultsPLPApi = productListingPageObjects.productResultsPLPApi(searchTerm, page,"filter").getResults();

                for (int productIndex = 0; productIndex < productResultsPLPApi.size(); productIndex++) {
                    if (productIndex == 0 && page == 1 || productIndex == productResultsPLPApi.size() - 1 && page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                        productNameFromApi = productResultsPLPApi.get(productIndex).getName();
                        //scroll to last product if "test=sanity"
                        if (suiteName.equalsIgnoreCase(CoreConstants.GROUP_SANITY) && (productIndex == productResultsPLPApi.size() - 1)) {
                            System.out.println("The test was sanity");
                            String totalNumberOfProduct = productListingPageObjects.getTextOnTitleHeader();
                            String numerical = totalNumberOfProduct.replaceAll("[^0-9]", "");
                            int number = Integer.parseInt(numerical);
                            int numberOfSwipe = (number - 1) / 2;
                            for (int w = 1; w <= numberOfSwipe; w++) {
                                productListingPageObjects.verifyScroll();
                            }
                        }
                        for (int j = 0; j < productListingPageObjects.productPropertiesListUI("name").size(); j++) {
                            String names = productListingPageObjects.namesListOfProduct(j);
                            if (productNameFromApi.equalsIgnoreCase(names)) {
                                List<String> productPropertiesUI = productListingPageObjects.getDetailsOfProductContainerUI(j);
                                //Storing all values from Api in array
                                List<String> productPropertiesApi = new ArrayList<>();
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getPrice());
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getOriginal_price());
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getProduct_stamp());
                                productPropertiesApi.add(String.valueOf(productResultsPLPApi.get(productIndex).getDiscount()));
                                System.out.println(productPropertiesApi);

                                //verification of price
                                assertTrue(productPropertiesApi.get(0).equalsIgnoreCase(productPropertiesUI.get(0)));
                                //Verification of Discount and original price
                                if (!productResultsPLPApi.get(productIndex).getOriginal_price().equals(productResultsPLPApi.get(productIndex).getPrice())) {
                                    assertTrue(productPropertiesApi.get(1).equalsIgnoreCase(productPropertiesUI.get(1)));
                                    assertTrue(productPropertiesApi.get(3).equalsIgnoreCase(productPropertiesUI.get(3)));
                                }
                                //verification of DeliveryTag
                                if (productResultsPLPApi.get(productIndex).getProduct_stamp() != null) {
                                    assertTrue(productPropertiesApi.get(2).equalsIgnoreCase(productPropertiesUI.get(2)));
                                }
                                softAssert.assertAll();
                                System.out.println("All data of product were verified successfully");
                            }
                        }
                        if ((productIndex % 2 != 0) && !suiteName.equalsIgnoreCase(CoreConstants.GROUP_SANITY)) {
                            productListingPageObjects.verifyScroll();
                        }
                    }

                }

            }
        }
    }

    @Test(groups = {"PLP.Verify all data of products",CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify product dates in PLP page",
            priority = 6,
             dataProvider = "getProductName")
    public void verifyProductsDataInPLPWithSortOnly(String searchTerm) throws Exception {
        System.out.println("Verify products Data in PLP with Sort Only");
        //applying sort
        verifyApplyingSortOnPLP();

        int totalNumberOfPages = productListingPageObjects.totalNumberOfPages(searchTerm,"sort");
        System.out.println("The total pages :" + totalNumberOfPages);
        String productNameFromApi;

        for (int page = 1; page <= totalNumberOfPages; page++) {

            if (page == 1 || page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                List<ProductListingResultsModel.ResultsBean> productResultsPLPApi = productListingPageObjects.productResultsPLPApi(searchTerm, page,"sort").getResults();

                for (int productIndex = 0; productIndex < productResultsPLPApi.size(); productIndex++) {
                    if (productIndex == 0 && page == 1 || productIndex == productResultsPLPApi.size() - 1 && page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                        productNameFromApi = productResultsPLPApi.get(productIndex).getName();
                        //scroll to last product if "test=sanity"
                        if (suiteName.equalsIgnoreCase(CoreConstants.GROUP_SANITY) && (productIndex == productResultsPLPApi.size() - 1)) {
                            System.out.println("The test was sanity");
                            String totalNumberOfProduct = productListingPageObjects.getTextOnTitleHeader();
                            String numerical = totalNumberOfProduct.replaceAll("[^0-9]", "");
                            int number = Integer.parseInt(numerical);
                            int numberOfSwipe = (number - 1) / 2;
                            for (int w = 1; w <= numberOfSwipe; w++) {
                                productListingPageObjects.verifyScroll();
                            }
                        }
                        for (int j = 0; j < productListingPageObjects.productPropertiesListUI("name").size(); j++) {
                            String names = productListingPageObjects.namesListOfProduct(j);
                            if (productNameFromApi.equalsIgnoreCase(names)) {
                                List<String> productPropertiesUI = productListingPageObjects.getDetailsOfProductContainerUI(j);
                                //Storing all values from Api in array
                                List<String> productPropertiesApi = new ArrayList<>();
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getPrice());
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getOriginal_price());
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getProduct_stamp());
                                productPropertiesApi.add(String.valueOf(productResultsPLPApi.get(productIndex).getDiscount()));
                                System.out.println(productPropertiesApi);

                                //verification of price
                                assertTrue(productPropertiesApi.get(0).equalsIgnoreCase(productPropertiesUI.get(0)));
                                //Verification of Discount and original price
                                if (!productResultsPLPApi.get(productIndex).getOriginal_price().equals(productResultsPLPApi.get(productIndex).getPrice())) {
                                    assertTrue(productPropertiesApi.get(1).equalsIgnoreCase(productPropertiesUI.get(1)));
                                    assertTrue(productPropertiesApi.get(3).equalsIgnoreCase(productPropertiesUI.get(3)));
                                }
                                //verification of DeliveryTag
                                if (productResultsPLPApi.get(productIndex).getProduct_stamp() != null) {
                                    assertTrue(productPropertiesApi.get(2).equalsIgnoreCase(productPropertiesUI.get(2)));
                                }
                                softAssert.assertAll();
                                System.out.println("All data of product were verified successfully");
                            }
                        }
                        if ((productIndex % 2 != 0) && !suiteName.equalsIgnoreCase(CoreConstants.GROUP_SANITY)) {
                            productListingPageObjects.verifyScroll();
                        }
                    }

                }

            }
        }
    }

    @Test(groups = {"PLP.Verify all data of products",CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify product dates in PLP page",
            priority = 7,
            dataProvider = "getProductName")
    public void verifyProductsDataInPLPWithFilterAndSort(String searchTerm) throws Exception {
        System.out.println("Verify products Data in PLP with FilterAndSort");
        //applying filter and sort
        verifyApplyingFilterOnPLP(null,null);
        verifyApplyingSortOnPLP();

        int totalNumberOfPages = productListingPageObjects.totalNumberOfPages(searchTerm,"filterSort");
        System.out.println("The total pages :" + totalNumberOfPages);
        String productNameFromApi;

        for (int page = 1; page <= totalNumberOfPages; page++) {

            if (page == 1 || page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                List<ProductListingResultsModel.ResultsBean> productResultsPLPApi = productListingPageObjects.productResultsPLPApi(searchTerm, page,"filterSort").getResults();

                for (int productIndex = 0; productIndex < productResultsPLPApi.size(); productIndex++) {
                    if (productIndex == 0 && page == 1 || productIndex == productResultsPLPApi.size() - 1 && page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                        productNameFromApi = productResultsPLPApi.get(productIndex).getName();
                        //scroll to last product if "test=sanity"
                        if (suiteName.equalsIgnoreCase(CoreConstants.GROUP_SANITY) && (productIndex == productResultsPLPApi.size() - 1)) {
                            System.out.println("The test was sanity");
                            String totalNumberOfProduct = productListingPageObjects.getTextOnTitleHeader();
                            String numerical = totalNumberOfProduct.replaceAll("[^0-9]", "");
                            int number = Integer.parseInt(numerical);
                            int numberOfSwipe = (number - 1) / 2;
                            for (int w = 1; w <= numberOfSwipe; w++) {
                                productListingPageObjects.verifyScroll();
                            }
                        }
                        for (int j = 0; j < productListingPageObjects.productPropertiesListUI("name").size(); j++) {
                            String names = productListingPageObjects.namesListOfProduct(j);
                            if (productNameFromApi.equalsIgnoreCase(names)) {
                                List<String> productPropertiesUI = productListingPageObjects.getDetailsOfProductContainerUI(j);
                                //Storing all values from Api in array
                                List<String> productPropertiesApi = new ArrayList<>();
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getPrice());
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getOriginal_price());
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getProduct_stamp());
                                productPropertiesApi.add(String.valueOf(productResultsPLPApi.get(productIndex).getDiscount()));
                                System.out.println(productPropertiesApi);

                                //verification of price
                                assertTrue(productPropertiesApi.get(0).equalsIgnoreCase(productPropertiesUI.get(0)));
                                //Verification of Discount and original price
                                if (!productResultsPLPApi.get(productIndex).getOriginal_price().equals(productResultsPLPApi.get(productIndex).getPrice())) {
                                    assertTrue(productPropertiesApi.get(1).equalsIgnoreCase(productPropertiesUI.get(1)));
                                    assertTrue(productPropertiesApi.get(3).equalsIgnoreCase(productPropertiesUI.get(3)));
                                }
                                //verification of DeliveryTag
                                if (productResultsPLPApi.get(productIndex).getProduct_stamp() != null) {
                                    assertTrue(productPropertiesApi.get(2).equalsIgnoreCase(productPropertiesUI.get(2)));
                                }
                                softAssert.assertAll();
                                System.out.println("All data of product were verified successfully");
                            }
                        }
                        if ((productIndex % 2 != 0) && !suiteName.equalsIgnoreCase(CoreConstants.GROUP_SANITY)) {
                            productListingPageObjects.verifyScroll();
                        }
                    }

                }

            }
        }
    }

    @Test(groups = {"PLP.Verify all data of products",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify product dates in PLP page",
            priority = 8,
            dataProvider = "getProductName")
    public void verifyProductsDataInPLPWithSortAndFilter(String searchTerm) throws Exception {
        System.out.println("Verify products Data in PLP with SortAndFilter");
        //applying sort and filter
        verifyApplyingSortOnPLP();
        verifyApplyingFilterOnPLP(null,null);

        int totalNumberOfPages = productListingPageObjects.totalNumberOfPages(searchTerm,"filterSort");
        System.out.println("The total pages :" + totalNumberOfPages);
        String productNameFromApi;

        for (int page = 1; page <= totalNumberOfPages; page++) {

            if (page == 1 || page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                List<ProductListingResultsModel.ResultsBean> productResultsPLPApi = productListingPageObjects.productResultsPLPApi(searchTerm, page,"filterSort").getResults();

                for (int productIndex = 0; productIndex < productResultsPLPApi.size(); productIndex++) {
                    if (productIndex == 0 && page == 1 || productIndex == productResultsPLPApi.size() - 1 && page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                        productNameFromApi = productResultsPLPApi.get(productIndex).getName();
                        //scroll to last product if "test=sanity"
                        if (suiteName.equalsIgnoreCase(CoreConstants.GROUP_SANITY) && (productIndex == productResultsPLPApi.size() - 1)) {
                            System.out.println("The test was sanity");
                            String totalNumberOfProduct = productListingPageObjects.getTextOnTitleHeader();
                            String numerical = totalNumberOfProduct.replaceAll("[^0-9]", "");
                            int number = Integer.parseInt(numerical);
                            int numberOfSwipe = (number - 1) / 2;
                            for (int w = 1; w <= numberOfSwipe; w++) {
                                productListingPageObjects.verifyScroll();
                            }
                        }
                        for (int j = 0; j < productListingPageObjects.productPropertiesListUI("name").size(); j++) {
                            String names = productListingPageObjects.namesListOfProduct(j);
                            if (productNameFromApi.equalsIgnoreCase(names)) {
                                List<String> productPropertiesUI = productListingPageObjects.getDetailsOfProductContainerUI(j);
                                //Storing all values from Api in array
                                List<String> productPropertiesApi = new ArrayList<>();
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getPrice());
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getOriginal_price());
                                productPropertiesApi.add(productResultsPLPApi.get(productIndex).getProduct_stamp());
                                productPropertiesApi.add(String.valueOf(productResultsPLPApi.get(productIndex).getDiscount()));
                                System.out.println(productPropertiesApi);

                                //verification of price
                                assertTrue(productPropertiesApi.get(0).equalsIgnoreCase(productPropertiesUI.get(0)));
                                //Verification of Discount and original price
                                if (!productResultsPLPApi.get(productIndex).getOriginal_price().equals(productResultsPLPApi.get(productIndex).getPrice())) {
                                    assertTrue(productPropertiesApi.get(1).equalsIgnoreCase(productPropertiesUI.get(1)));
                                    assertTrue(productPropertiesApi.get(3).equalsIgnoreCase(productPropertiesUI.get(2)));
                                }
                                //verification of DeliveryTag
                                if (productResultsPLPApi.get(productIndex).getProduct_stamp() != null) {
                                    assertTrue(productPropertiesApi.get(2).equalsIgnoreCase(productPropertiesUI.get(3)));
                                }
                                softAssert.assertAll();
                                System.out.println("All data of product were verified successfully");
                            }
                        }
                        if ((productIndex % 2 != 0) && !suiteName.equalsIgnoreCase(CoreConstants.GROUP_SANITY)) {
                            productListingPageObjects.verifyScroll();
                        }
                    }

                }

            }
        }
    }




        @AfterClass(alwaysRun = true)
    public void productListingPageAfterClass(){
        System.out.println("ProductListingPageAfterClass is called");
    }



}
