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

public class CouponsPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private CouponPageObjects couponPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private CouponsModel couponsModel;
    private Random random;
    private int size;
    private int index;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void couponsPageTestsBeforeClass() throws Exception
    {
        System.out.println("Coupons Page Tests Before Class");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        couponPageObjects = new CouponPageObjects(driver);

        random = new Random();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        couponsModel = new CouponsModel();

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        actionBarObjects.clickCouponLink();
        setImplicitWait(10000);

        couponsModel = getRedxApiResponse.couponsListGetCall(actionBarObjects.getShopName());
        size = couponsModel.getBody().getCoupons().size();
        index = random.nextInt(size);
        System.out.println("Coupons : " + size);
        System.out.println("Index : " + index);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, CouponsPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "137")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Coupon Id Value",
            priority = 401 )
    public void verifyCouponIdValue()
    {
        System.out.println("Verifying Coupon Id Value");
        String uiValue = couponPageObjects.getCouponID(index+1);
        String apiValue = couponsModel.getBody().getCoupons().get(index).getCode();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "138")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Coupon Description Value",
            priority = 402 )
    public void verifyCouponDescriptionValue()
    {
        System.out.println("Verifying Coupon Description Value");
        String uiValue = couponPageObjects.getCouponDescriptionValue(index+1);
        String apiValue = couponsModel.getBody().getCoupons().get(index).getName();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "139")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Expire Date Value",
            priority = 403 )
    public void verifyExpireDateValue()
    {
        System.out.println("Verifying Expire Date Value");
        String uiValue = couponPageObjects.getCouponExpireDate(index+1);
        String apiValue = couponsModel.getBody().getCoupons().get(index).getEndDate();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Assert Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "140")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Coupon Status Value",
            priority = 404 )
    public void verifyCouponStatusValue()
    {
        System.out.println("Verifying Coupon Status Value");
        String uiValue = couponPageObjects.getCouponStatus(index+1);
        String apiValue = couponsModel.getBody().getCoupons().get(index).getStatus();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue.toLowerCase(),apiValue);
    }

    @TestRails(caseId = "141")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Apply Coupon Functionality",
            priority = 405 )
    public void verifyApplyCouponFunctionality()
    {
        String couponCode = couponsModel.getBody().getCoupons().get(0).getCode();
        String status = couponsModel.getBody().getCoupons().get(0).getStatus();

        System.out.println("Coupon Code : " + couponCode);
        System.out.println("Status : " + status);

        couponPageObjects.enterCouponCodeInput(couponCode);
        couponPageObjects.clickOnApplyButton();

        String toastMsg = couponPageObjects.getToastMsg();
        System.out.println("Toast Message : " + toastMsg);

        switch (status)
        {
            case "applied":
                Assert.assertEquals(toastMsg,"You already have applied this coupon");
                break;
            case "active":
                Assert.assertEquals(toastMsg,"Coupon code applied successfully");
                break;
        }
    }
}
