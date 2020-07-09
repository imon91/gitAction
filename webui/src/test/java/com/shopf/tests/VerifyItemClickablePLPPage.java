package com.shopf.tests;


import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.ActionBarObjects;
import pageObjects.LatestPageObjects;
import pageObjects.PDPPageObject;
import pageObjects.PLPPageObject;
import utils.WebBaseClass;

public class VerifyItemClickablePLPPage extends WebBaseClass {


    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private LatestPageObjects latestPageObjects;
    private PLPPageObject plpPageObject;
    private PDPPageObject pdpPageObject;



    @BeforeClass(alwaysRun = true)
    public void VerifyPLP_PageBeforeClass() throws Exception {
        System.out.println("VerifyPLP_PageBeforeClass is called");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        latestPageObjects = new LatestPageObjects(driver);
        plpPageObject = new PLPPageObject(driver);
        pdpPageObject=new PDPPageObject(driver);
    }


    @Test(groups = {"PLP.VerifySelectiongValidSizeProduct",
            CoreConstants.GROUP_SMOKE},
            description = "Verifies Selecting Item On PLP",
            dependsOnGroups = "PLP.VerifySortFunctionality")
    public void verifySelectingValidSizeItemOnPLP(){
        System.out.println("Verify selecting valid size product");
        String searchTerm = System.getProperty("webSearchTerm");
        //save product name to key(productNameInPLP)
        String productNameInPLP = plpPageObject.getProductNameInPLP(searchTerm);
        System.setProperty("productNameInPLP",productNameInPLP);
        //click on valid product
        int index = plpPageObject.selectValidProduct(searchTerm);
        System.setProperty("index",""+ index + "");
        System.out.println("the available size index:"+System.getProperty("index"));
    }

//    @Test(groups = (CoreConstants.GROUP_SMOKE),
//            dependsOnGroups = ("Authentication.verifyAuthenticationWithValidCredentials"),
//            enabled = false)
//    public void VerifyPLP_Page() {
//        System.out.println("VerifyPLP_Page is called");
//        // plpPageObject.verifyAllProductsAreClickable();
//    }



    @AfterClass(alwaysRun = true)
    public void VerifyPLP_PageAfterClass() {
        System.out.println("VerifyPLP_PageAfterclass is called");
    }

}

