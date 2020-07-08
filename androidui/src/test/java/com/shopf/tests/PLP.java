package com.shopf.tests;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.*;
import utils.AndroidBaseClass;

import java.util.Random;


public class PLP extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private ProductListingPageObjects productListingPageObjects;
    private SortPageObjects sortPageObjects;
    private ProductFilterPageObjects productFilterPageObjects;




    @BeforeClass(alwaysRun = true)
    public void productListingPageBeforeClass() throws Exception{
        System.out.println("PLPBeforeClass is called");
        androidDriver = getBaseDriver();
        productListingPageObjects = new ProductListingPageObjects(androidDriver);
        sortPageObjects = new SortPageObjects(androidDriver);
        productFilterPageObjects = new ProductFilterPageObjects(androidDriver);
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
        sortPageObjects.clickOnSortElement("By Relevance");
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
    public void verifyApplyingFilterOnPLP(String filterCategory,String filterItem){
        productListingPageObjects.clickOnFilterButton();
        // Get the value from filter_new key

        // For Shirts Filter is always based on "Category", "Price" and "Discount"
                // Select On Category of the filter
//                        productFilterPageObjects.
//                                clickOnFilterName(productFilterPageObjects.
//                                        getListOfFilterNames().get(0));
        productFilterPageObjects.clickOnFilterNameByValue(filterCategory);

        System.out.println("Current Activity at PLP on Filter is : "+androidDriver.currentActivity());

                        // select Random Item
                    Random random = new Random();
                    int index = random.nextInt(productFilterPageObjects.getListOfFilterItems().size());
                                productFilterPageObjects.
                                        clickOnFilterItemByValue(filterItem);

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
    public void verifySelectingValidSizeItemOnPLP(){
        String searchTerm = System.getProperty("androidSearchTerm");
        productListingPageObjects.selectValidSizeProduct(searchTerm);
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

        if(totalItem.equalsIgnoreCase(totalitem)){System.out.println(totalItem);System.out.println("Remove Filter Function was verified");
        }
    }



    @AfterClass(alwaysRun = true)
    public void productListingPageAfterClass(){
        System.out.println("ProductListingPageAfterClass is called");
    }

}
