package com.shopf.tests.Authentication;

import com.gurock.testrail.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.*;
import services.responseModels.redxModels.*;
import utils.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class CreditHistoryPageTests extends RedXWebBaseClass {
    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private CreditHistoryPageObjects creditHistoryPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private CreditTransactionLogModel creditTransactionLogModel;
    private Random random;
    private String shopName = "RedX Web Sanity Test Shop";
    private int shopId;
    private int size;
    private int index;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void creditHistoryPageObjectsBeforeClass() throws Exception
    {
        System.out.println("Credit History Page Tests Before Class");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        creditHistoryPageObjects = new CreditHistoryPageObjects(driver);

        random = new Random();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");

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
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, CreditHistoryPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "361")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Transaction Id Value",
            priority = 1501 )
    public void verifyTransactionIdValue()
    {
        System.out.println("Verifying Transaction Id Value");
        String uiValue = creditHistoryPageObjects.getTransactionIdValue(index+1);
        String apiValue = String.valueOf(creditTransactionLogModel.getBody().getTransactionLog().get(index).getId());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "362")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Transaction Date Value",
            priority = 1502 )
    public void verifyTransactionDateValue()
    {
        System.out.println("Verifying Transaction Date Value");
        String uiValue = creditHistoryPageObjects.getTransactionDateValue(index+1);
        String apiValue = String.valueOf(creditTransactionLogModel.getBody().getTransactionLog().get(index).getCreatedAt());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "363")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Amount Type Value",
            priority = 1503 )
    public void verifyAmountTypeValue()
    {
        System.out.println("Verifying Amount Type Value");
        String uiValue = creditHistoryPageObjects.getAmountTypeValue(index+1);
        String apiValue = String.valueOf(creditTransactionLogModel.getBody().getTransactionLog().get(index).getTransactionType());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "364")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Amount Paid Out Value",
            priority = 1504 )
    public void verifyAmountPaidOutValue()
    {
        System.out.println("Verifying Amount Paid Out Value");
        String uiValue = creditHistoryPageObjects.getAmountPaidOutValue(index+1);
        String apiValue = String.valueOf(creditTransactionLogModel.getBody().getTransactionLog().get(index).getAmount());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "365")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Date Range Filter Functionality",
            priority = 1505 )
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
}
