package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.CouponsModel;
import utils.RedXWebBaseClass;

import java.util.Random;

public class CouponsPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private CouponPageObjects couponPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private CouponsModel couponsModel;
    private Random random;
    private String cookie;
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
    public void couponsPageTestsBeforeClass() throws Exception
    {
        System.out.println("Coupons Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        couponPageObjects = new CouponPageObjects(driver);

        random = new Random();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        couponsModel = new CouponsModel();

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        actionBarObjects.clickCouponLink();
        couponsModel = getRedxApiResponse.couponsListGetCall(actionBarObjects.getShopName());
        size = couponsModel.getBody().getCoupons().size();
        index = random.nextInt(size);
        System.out.println("Coupons : " + size);
        System.out.println("Index : " + index);
    }

    @BeforeMethod(alwaysRun = true)
    public void homePageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Coupon Id Value",
            priority = 1 )
    public void verifyCouponIdValue()
    {
        System.out.println("Verifying Coupon Id Value");
        String uiValue = couponPageObjects.getCouponID(index+1);
        String apiValue = couponsModel.getBody().getCoupons().get(index).getCode();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Coupon Description Value",
            priority = 2 )
    public void verifyCouponDescriptionValue()
    {
        System.out.println("Verifying Coupon Description Value");
        String uiValue = couponPageObjects.getCouponDescriptionValue(index+1);
        String apiValue = couponsModel.getBody().getCoupons().get(index).getName();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Expire Date Value",
            priority = 3 )
    public void verifyExpireDateValue()
    {
        System.out.println("Verifying Expire Date Value");
        String uiValue = couponPageObjects.getCouponExpireDate(index+1);
        String apiValue = couponsModel.getBody().getCoupons().get(index).getEndDate();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Assert Value : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Coupon Status Value",
            priority = 4 )
    public void verifyCouponStatusValue()
    {
        System.out.println("Verifying Coupon Status Value");
        String uiValue = couponPageObjects.getCouponStatus(index+1);
        String apiValue = couponsModel.getBody().getCoupons().get(index).getStatus();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue.toLowerCase(),apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Apply Coupon Functionality",
            priority = 5 )
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

    @AfterClass(alwaysRun = true)
    public void couponsPageTestsAfterClass()
    {
        System.out.println("Coupons Page Tests After Class");
    }

    @AfterSuite(alwaysRun = true)
    public void couponsPageTestsAfterSuite()
    {
        System.out.println("Coupons Page Tests After Suite");
        driver.quit();
    }
}
