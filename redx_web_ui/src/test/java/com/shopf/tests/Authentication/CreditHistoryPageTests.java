package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.CreditTransactionLogModel;
import utils.RedXWebBaseClass;

import java.util.*;

public class CreditHistoryPageTests extends RedXWebBaseClass {
    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private CreditHistoryPageObjects creditHistoryPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private CreditTransactionLogModel creditTransactionLogModel;
    private Random random;
    private String cookie;
    private String shopName = "RedX Web Sanity Test Shop";
    private int shopId;
    private int size;
    private int index;

    @BeforeSuite(alwaysRun = true)
    public void redXWebBeforeSuite() throws  Exception
    {
        System.out.println("RedX Web Before Suite");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getWebBaseUrl());
        driver.manage().window().maximize();
    }

    @BeforeClass(alwaysRun = true)
    public void creditHistoryPageObjectsBeforeClass()
    {
        System.out.println("Credit History Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        creditHistoryPageObjects = new CreditHistoryPageObjects(driver);

        random = new Random();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");

        System.out.println("Performing Authentication");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

        actionBarObjects.changeShop(shopName);
        setImplicitWait(10000);

        actionBarObjects.clickOnCreditHistoryDropDown();

        shopId = getRedxApiResponse.getShopId(shopName);
        creditTransactionLogModel = getRedxApiResponse.creditTransactionLogGetCall(shopId);
        size = creditTransactionLogModel.getBody().getTransactionLog().size();
        System.out.println("Size : " + size);
        index = random.nextInt(size);
        System.out.println("Index : " + index);
    }

    @BeforeMethod(alwaysRun = true)
    public void creditHistoryPageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Transaction Id Value",
            priority = 1 )
    public void verifyTransactionIdValue()
    {
        System.out.println("Verifying Transaction Id Value");
        String uiValue = creditHistoryPageObjects.getTransactionIdValue(index+1);
        String apiValue = String.valueOf(creditTransactionLogModel.getBody().getTransactionLog().get(index).getId());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Transaction Date Value",
            priority = 2 )
    public void verifyTransactionDateValue()
    {
        System.out.println("Verifying Transaction Date Value");
        String uiValue = creditHistoryPageObjects.getTransactionDateValue(index+1);
        String apiValue = String.valueOf(creditTransactionLogModel.getBody().getTransactionLog().get(index).getCreatedAt());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Amount Type Value",
            priority = 3 )
    public void verifyAmountTypeValue()
    {
        System.out.println("Verifying Amount Type Value");
        String uiValue = creditHistoryPageObjects.getAmountTypeValue(index+1);
        String apiValue = String.valueOf(creditTransactionLogModel.getBody().getTransactionLog().get(index).getTransactionType());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Amount Paid Out Value",
            priority = 4 )
    public void verifyAmountPaidOutValue()
    {
        System.out.println("Verifying Amount Paid Out Value");
        String uiValue = creditHistoryPageObjects.getAmountPaidOutValue(index+1);
        String apiValue = String.valueOf(creditTransactionLogModel.getBody().getTransactionLog().get(index).getAmount());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Date Range Filter Functionality",
            priority = 5 )
    public void verifyDateRangeFilterFunctionality()
    {
        System.out.println("Verifying Date Range Filter Functionality");
        long since = creditHistoryPageObjects.chooseStartDate(01,"Mar",2021);
        long until = creditHistoryPageObjects.chooseEndDate(20,"Mar",2021);
        creditHistoryPageObjects.clickSearchButton();
        creditTransactionLogModel = getRedxApiResponse.creditTransactionLogGetCall(shopId,since,until);
        int uiValue = 0;
        int apiValue = creditTransactionLogModel.getBody().getTransactionLog().size();
        Assert.assertEquals(apiValue,uiValue);
    }

    @AfterSuite(alwaysRun = true)
    public void creditHistoryPageTestsAfterSuite()
    {
        System.out.println("Credit History Page Tests After Suite");
        driver.quit();
    }
}
