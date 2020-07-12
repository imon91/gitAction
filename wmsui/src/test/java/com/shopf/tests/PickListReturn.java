package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PickOrdersPageObjects;
import pageObjects.ReturnsPageObjects;
import utils.WmsBaseClass;

import java.util.Random;

public class PickListReturn extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private ReturnsPageObjects returnsPageObjects;
    private ReturnsPageObjects.ReturnInScanTab returnInScanTab;
    private PickOrdersPageObjects pickOrdersPageObjects;
    private PickOrdersPageObjects.AllPickListsTab allPickListsTab;

    @BeforeClass(alwaysRun = true)
    public void pickListReturnBeforeClass() throws Exception{
        System.out.println("Pick List Return Before Class is called");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        returnsPageObjects = new ReturnsPageObjects(driver);
        returnInScanTab = returnsPageObjects.new ReturnInScanTab(driver);
        pickOrdersPageObjects = new PickOrdersPageObjects(driver);
        allPickListsTab = pickOrdersPageObjects.new AllPickListsTab(driver);
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials")
    public void pickListReturnVerification(){
        System.out.println("Pick List Return Verification is called");


        /*--------------Get Random Pick List Id And Status-------------------*/
        homePageObject.clickPickOrders();
        pickOrdersPageObjects.clickAllPickListsTab();
        sleep(1000);
        int i = 0, total = allPickListsTab.getTotalPickLists();
        Random random = new Random(); int n = random.nextInt(total);
        String pickListId = allPickListsTab.getPickListID(n);
        String status = allPickListsTab.getStatus(n);
        String reason = allPickListsTab.getPickListReason(n);
        if(status.equalsIgnoreCase("out_for_pickup")
                || status.equalsIgnoreCase("created")
                || reason.equalsIgnoreCase("SINGLE_ORDER")
                || reason.equalsIgnoreCase("MULTIPLE_ORDERS"))
          i = 1;
        System.out.println(pickListId+" "+status);


        /*--------------Input PickList / Return PickList-------------------*/
        homePageObject.clickReturns();
        returnsPageObjects.clickReturnInScanTab();
        returnInScanTab.enterPickListId(pickListId);
        sleep(3000);
        if(i == 1){
            setImplicitWait(4);
            String message = homePageObject.getPopUpMessage();
            System.out.println(message);
        }
        else{
            int s, j, t = returnInScanTab.getTotalProducts();
            for (j = 1;j <= t;j++){
                int q = returnInScanTab.getOrderedQuantity(j);
                int rq = returnInScanTab.getReturnedQuantity(j);
                s = q-rq;
                System.out.println(s);
                if(s!=0) {
                    System.out.println(s);
                    returnInScanTab.returnQuantityInput(j, Integer.toString(s));
                }
            }
            returnInScanTab.clickPickListReturnSubmitButton();
            setImplicitWait(3);
            String message = homePageObject.getPopUpMessage();
            System.out.println(message);
            sleep(2000);
        }
    }
    @AfterClass(alwaysRun = true)
    public void pickListReturnAfterClass(){
        System.out.println("Pick List Return After Class is called");
    }
}
