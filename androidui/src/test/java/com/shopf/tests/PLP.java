package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.assertTrue;
import pageObjects.*;
import services.responseModels.commerceModels.*;
import utils.*;
import java.util.*;



public class PLP extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private ProductListingPageObjects productListingPageObjects;
    private SortPageObjects sortPageObjects;
    private ProductFilterPageObjects productFilterPageObjects;
    private SoftAssert softAssert;
    private String suiteName;
    private AndroidScriptRouter androidScriptRouter;




    @BeforeClass(alwaysRun = true)
    public void productListingPageBeforeClass() throws Exception{
        System.out.println("PLPBeforeClass is called");
        androidDriver = getBaseDriver();
        productListingPageObjects = new ProductListingPageObjects(androidDriver);
        sortPageObjects = new SortPageObjects(androidDriver);
        softAssert = new SoftAssert();
        androidScriptRouter = new AndroidScriptRouter();
//        String activityName = androidDriver.currentActivity();
//        androidScriptRouter.getMeTheCurrentPage();
//        androidScriptRouter.getTheControlHere(activityName,null);
        productFilterPageObjects = new ProductFilterPageObjects(androidDriver);
    }


    @Parameters("suite")
    @BeforeTest(alwaysRun = true)
    public void beforeTest(String testName)
    {
        suiteName=testName;
    }


    @Test(  groups = {"PLP.verifyApplyingSortOnPLP",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "Verifies Applying Sort On The Product List",
            dependsOnGroups = "Search.verifySearchFunctionalityWithoutSelectingSuggestions"  )
    public void verifyApplyingSortOnPLP(){
        productListingPageObjects.clickOnSortButton();
        // Get the value from sort key
        System.out.println("Current Activity at PLP on Sort is : "+androidDriver.currentActivity());
        Random random1 = new Random();
        int randomSortIndex = random1.nextInt(sortPageObjects.getSortTexts().size());
        if(sortPageObjects.getSortTexts()
                .get(randomSortIndex).getText().equalsIgnoreCase("What's New") ||
                sortPageObjects.getSortTexts()
                        .get(randomSortIndex).getText().equalsIgnoreCase("SORT") ){
            randomSortIndex = randomSortIndex+1;
        }
        sortPageObjects.clickOnSortElement(sortPageObjects.getSortTexts()
                .get(randomSortIndex).getText());
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
            dependsOnGroups = "Search.verifySearchFunctionalityWithoutSelectingSuggestions"   )
    public void verifyApplyingFilterOnPLP(String filterCategory,String filterItem) {
        productListingPageObjects.clickOnFilterButton();
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


    @Test(groups = {"PLP.verifySelectingItemOnPLP",
            CoreConstants.GROUP_SMOKE},
            enabled = true,
            description = "Verifies Selecting Item On PLP",
            dependsOnGroups = "Search.verifySearchFunctionalityWithoutSelectingSuggestions" )
    public void verifySelectingItemOnPLP(){
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
            dependsOnGroups = "Search.verifySearchFunctionalityWithoutSelectingSuggestions"  )
    public void verifySelectingValidSizeItemOnPlpToPDP(){
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
            enabled = false,
            description = "Verifies Applying / Removing Filter On The PLP Page",
            dependsOnGroups = "Search.verifySearchFunctionalityWithoutSelectingSuggestions"  )
    public void verifyApplyingAndRemovingFilterOnPLP(){

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




    @Test(groups = {"PLP.Verify all data of products",
            CoreConstants.GROUP_REGRESSION},
            description = "Verify product dates in PLP page")
    public void verifyProductsDataInPLPWithoutFilter(String searchTerm) throws Exception {
        int totalNumberOfPages = productListingPageObjects.totalNumberOfPages(searchTerm);
        System.out.println("The total pages :" + totalNumberOfPages);
        String productNameFromApi;

            for (int page = 1; page <= totalNumberOfPages; page++) {

                if (page == 1 || page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                    List<ProductListingResultsModel.ResultsBean> productResultsPLPApi = productListingPageObjects.productResultsPLPApi(searchTerm, page).getResults();

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

    @Test(groups = {"PLP.Verify all data of products after filter",
            CoreConstants.GROUP_REGRESSION},
            description = "Verify product dates in PLP page after filter")
    public void verifyProductsDataInPLPWithFilterApplied(String searchTerm) throws Exception {
        int totalNumberOfPages = productListingPageObjects.totalNumberOfPages(searchTerm);
        System.out.println("The total pages :" + totalNumberOfPages);
        String productNameFromApi;
        for (int page = 1; page <= totalNumberOfPages; page++) {
            if (page == 1 || page == totalNumberOfPages || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                List<ProductListingResultsModel.ResultsBean> productResultsPLPApi = productListingPageObjects.productResultsPLPApi(searchTerm, page).getResults();

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




        @AfterClass(alwaysRun = true)
    public void productListingPageAfterClass(){
        System.out.println("ProductListingPageAfterClass is called");
    }



}
