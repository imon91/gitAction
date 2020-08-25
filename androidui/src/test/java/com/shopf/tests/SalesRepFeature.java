package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.responseModels.commerceModels.*;
import utils.*;
import java.util.*;

public class SalesRepFeature extends AndroidBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private SalesRepFeaturePageObject salesRepFeaturePageObject;
    private ActionBarObjects actionBarObjects;
    private Random random;
    private String  mobileNo;
    private String ownerName;
    int indexOfLastElement;


    @BeforeClass(alwaysRun = true)
    public void salesRepPageBeforeClass(){
        System.out.println("PDPBeforeClass is called");
        androidDriver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(androidDriver);
        salesRepFeaturePageObject=new SalesRepFeaturePageObject(androidDriver);
        random = new Random();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 2)
    public void verifyAddingRetailer()
    {
        salesRepFeaturePageObject.clickOnAddNewShopIcon();
        List<Integer> listOfThreeDigitNumbers= new ArrayList<>();
        for(int i=100;i<1000;i++)
        {listOfThreeDigitNumbers.add(i);}
        int threeNumber = listOfThreeDigitNumbers.get(random.nextInt(899));
        mobileNo = "01877755"+threeNumber;
        salesRepFeaturePageObject.performAuthentication(mobileNo,"666666");
        salesRepFeaturePageObject.enterShopNameText("Testing ShopName");
        ownerName = "OwnerName"+threeNumber;
        salesRepFeaturePageObject.enterOwnerNameText(ownerName);
        salesRepFeaturePageObject.clickOnRetailerIcon();
        salesRepFeaturePageObject.clickOnNextButtonAtOnboardingScreen();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 3)
    public void verifyAddedRetailer()
    {
        actionBarObjects.ownerNameTextAtTop().click();
        MokamRetailerListModel mokamRetailerListModel = salesRepFeaturePageObject.salesRepResultsApi();
        System.out.println("size of Retailer list : "+mokamRetailerListModel.getUser_data().size());
        indexOfLastElement=((mokamRetailerListModel.getUser_data().size())-1);
        String ownerNameApi = mokamRetailerListModel.getUser_data().get(indexOfLastElement).getName();
        String ownerPhone = mokamRetailerListModel.getUser_data().get(indexOfLastElement).getPhone();
        Assert.assertEquals(ownerName,ownerNameApi);
        Assert.assertEquals("88"+mobileNo,ownerPhone);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 3)
    public void verifyRetailerSwitch()
    {
        ownerName=salesRepFeaturePageObject.ownerNameText(2).getText();
        salesRepFeaturePageObject.ownerNameText(2).click();
        salesRepFeaturePageObject.clickOnNextButtonAtShopList();
        sleep(4000);
        String ownerNameAtHomePage = actionBarObjects.ownerNameTextAtTop().getText();
        System.out.println("NameAtHomePage"+ownerNameAtHomePage);
        Assert.assertEquals(ownerName,ownerNameAtHomePage);
    }
}
