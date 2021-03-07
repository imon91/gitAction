package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.*;
import utils.RedXWebBaseClass;

import java.io.File;
import java.util.Random;

public class PaymentsPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private PaymentsPageObjects paymentsPageObjects;
    private PaymentsPageObjects.PaymentDetailsPageObjects paymentDetailsPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private PaymentsModel paymentsModel;
    private PaymentDetailsModel paymentDetailsModel;
    private Random random;
    private String cookie;
    private String allPaymentsListGetCallUrl;
    private int invoiceId;
    private int paymentsSize;
    private int paymentsIndex;
    private int parcelsIndex;
    private int parcelsSize;

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
    public void paymentsPageTestsBeforeClass() throws Exception
    {
        System.out.println("Payments Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        paymentsPageObjects = new PaymentsPageObjects(driver);
        paymentDetailsPageObjects = paymentsPageObjects.new PaymentDetailsPageObjects();

        random = new Random();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        paymentsModel = new PaymentsModel();
        paymentDetailsModel = new PaymentDetailsModel();

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        actionBarObjects.clickPaymentsLink();
        sleep(2000);

        String shopName = actionBarObjects.getShopName();
        int limit =20, offset = 0;

        allPaymentsListGetCallUrl = getRedxApiResponse.allPaymentsListGetCallUrl(shopName,limit,offset);
        paymentsModel = getRedxApiResponse.paymentsListGetCall(allPaymentsListGetCallUrl);

        paymentsSize = paymentsModel.getBody().getTotalPayments();
        System.out.println("Payments Size : " + paymentsSize);
        paymentsIndex = paymentsPageObjects.getRandomParcelIndex();
        System.out.println("Index : " + paymentsIndex);

        invoiceId = paymentsModel.getBody().getPayments().get(paymentsIndex -1).getLOGISTICS_INVOICE_ID();
        System.out.println("Invoice Id : " + invoiceId);

        paymentDetailsModel = getRedxApiResponse.paymentDetailsListGetCall(shopName,invoiceId);
        parcelsSize = paymentDetailsModel.getParcels().size();
        System.out.println("Parcels Size : " + parcelsSize);
        parcelsIndex = paymentDetailsPageObjects.getRandomParcelIndex();
        System.out.println("Parcels Index : " + parcelsIndex);
    }

    @BeforeMethod(alwaysRun = true)
    public void paymentsPageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify All Pickup Location Filter Functionality",
            priority = 1 )
    public void verifyAllPickupLocationFilterFunctionality()
    {
        System.out.println("Verifying All Pickup Location Filter Functionality");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Date Range Filter Functionality",
            priority = 2 )
    public void verifyDateRangeFilterFunctionality()
    {
        System.out.println("Verifying Date Range Filter Functionality");
        int uiValue,apiValue,size = paymentsPageObjects.getPaymentsSize();
        long since,until;
        System.out.println("Payments : " + size);

        paymentsPageObjects.clickDateRangeInput();
        since = paymentsPageObjects.selectStartDate(01,"Mar",2021);
        System.out.println("Since : " + since);
        until = paymentsPageObjects.selectEndDate(03,"Mar",2021);
        System.out.println("Until : " + until);

        paymentsPageObjects.clickSearchButton();

        String paymentsListGetCallUrl = getRedxApiResponse.paymentsListGetCallUrl(allPaymentsListGetCallUrl,0,since,until);
        PaymentsModel paymentsModelDateFilter = getRedxApiResponse.paymentsListGetCall(paymentsListGetCallUrl);

        uiValue = paymentsPageObjects.getPaymentsSize();
        apiValue = paymentsModelDateFilter.getBody().getPayments().size();

        System.out.println("Payments After Filter : " + uiValue);
        System.out.println("Payments After Filter API : " + apiValue);
        driver.navigate().refresh();
        setImplicitWait(10000);

        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Id Value",
            priority = 3 )
    public void verifyInvoiceIdValue()
    {
        System.out.println("Verifying Invoice Id Value");
        String uiValue = paymentsPageObjects.getInvoiceIdValue(paymentsIndex);
        String apiValue = String.valueOf(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getLOGISTICS_INVOICE_ID());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Date Value",
            priority = 4 )
    public void verifyInvoiceDateValue()
    {
        System.out.println("Verifying Invoice Date Value");
        String uiValue = paymentsPageObjects.getInvoiceDateValue(paymentsIndex);
        String assertValue = paymentsModel.getBody().getPayments().get(paymentsIndex-1).getCREATED_AT();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Assert Value : " + assertValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Cash Collection Value",
            priority = 5 )
    public void verifyCashCollectionValue()
    {
        System.out.println("Verifying Cash Collection Value");
        String uiValue = paymentsPageObjects.getCashCollectionValue(paymentsIndex);
        String apiValue = String.format("%.2f",(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getTOTAL_SHOPUP_CHARGE() + paymentsModel.getBody().getPayments().get(paymentsIndex-1).getAMOUNT()));
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Delivery Charge Value",
                priority = 6 )
    public void verifyDeliveryChargeValue()
    {
        System.out.println("Verifying Delivery Charge Value");
        String uiValue = paymentsPageObjects.getDeliveryChargeValue(paymentsIndex);
        String apiValue = String.valueOf(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getTOTAL_SHOPUP_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify RedX Credits Value",
            priority = 7 )
    public void verifyRedxCreditsValue()
    {
        System.out.println("Verifying RedX Credits Value");
        String uiValue = paymentsPageObjects.getRedxCreditValue(paymentsIndex);
        String apiValue = String.valueOf(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getCREDITS_USED());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify COD Charge Value",
            priority = 8 )
    public void verifyCodChargeValue()
    {
        System.out.println("Verifying COD Charge Value");
        String uiValue = paymentsPageObjects.getCodChargeValue(paymentsIndex);
        String apiValue = String.valueOf(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getTOTAL_COD_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Return Charge Value",
            priority = 9 )
    public void verifyReturnChargeValue()
    {
        System.out.println("Verifying Return Charge Value");
        String uiValue = paymentsPageObjects.getReturnChargeValue(paymentsIndex);
        String apiValue = String.valueOf(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getTOTAL_RETURN_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Advance Payment Repayment Value",
            priority = 10 )
    public void verifyAdvancePaymentRepaymentValue()
    {
        System.out.println("Verifying Advance Payment Repayment Value");
        String uiValue = paymentsPageObjects.getAdvancePaymentRepayment(paymentsIndex);
        String apiValue = String.valueOf(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getTOTAL_CASH_COLLECTED());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Amount Paid Value",
            priority = 11 )
    public void verifyAmountPaidValue()
    {
        System.out.println("Verifying Amount Paid Value");
        String uiValue = paymentsPageObjects.getAmountPaidOut(paymentsIndex);
        String apiValue = String.format("%.2f",paymentsModel.getBody().getPayments().get(paymentsIndex-1).getAMOUNT());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Button Functionality",
            priority = 12 )
    public void verifyDownloadButtonFunctionality()
    {
        System.out.println("Verifying Download Button Functionality");
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/Downloads";
        File directory = new File(filePath);
        File[] dirContains = directory.listFiles();
        int files1 = dirContains.length;
        System.out.println("Current Files : " + files1);

        paymentsPageObjects.clickDownloadButton(paymentsIndex);

        sleep(3000);
        File[] dirContain = directory.listFiles();
        int files2 = dirContain.length;
        System.out.println("Files After Download : " + files2);
        Assert.assertEquals(files2,files1+1);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Id Functionality",
            priority = 13 )
    public void verifyInvoiceIdFunctionality()
    {
        System.out.println("Verifying Invoice Id Functionality");
        paymentsPageObjects.clickInvoiceId(paymentsIndex);
        String title = paymentDetailsPageObjects.getTitleCaptionValue();
        System.out.println("Title : " + title);
        Assert.assertEquals(title,"Payment Details");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Id Value In Details Page",
            priority = 14 )
    public void verifyInvoiceIdValueInDetailsPage()
    {
        System.out.println("Verifying Invoice Id Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getInvoiceInfo(1).substring(12);
        System.out.println("Invoice ID : " + invoiceId);
        System.out.println("Value in UI : " + uiValue);
        Assert.assertEquals(uiValue,String.valueOf(invoiceId));
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Date Value In Details Page",
            priority = 15 )
    public void verifyInvoiceDateValueInDetailsPage()
    {
        System.out.println("Verifying Invoice Date Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getInvoiceInfo(2);
        String date = paymentsModel.getBody().getPayments().get(paymentsIndex-1).getCREATED_AT();
        System.out.println("Invoice Date : " + date);
        System.out.println("Value in UI : " + uiValue);
        Assert.assertEquals(uiValue,date);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Button Functionality In Details Page",
            priority = 16 )
    public void verifyDownloadButtonFunctionalityInDetailsPage()
    {
        System.out.println("Verifying Download Button Functionality In Details Page");
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/Downloads";
        File directory = new File(filePath);
        File[] dirContains = directory.listFiles();
        int files1 = dirContains.length;
        System.out.println("Current Files : " + files1);

        paymentDetailsPageObjects.clickDownloadButton();

        sleep(3000);
        File[] dirContain = directory.listFiles();
        int files2 = dirContain.length;
        System.out.println("Files After Download : " + files2);
        Assert.assertEquals(files2,files1+1);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Id Value",
            priority = 17 )
    public void verifyParcelIdValue()
    {
        System.out.println("Verifying Parcel Id Value");
        String uiValue = paymentDetailsPageObjects.getParcelIdValue(parcelsIndex);
        String apiValue = paymentDetailsModel.getParcels().get(parcelsIndex-1).getTRACKING_ID();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Date Value",
            priority = 18 )
    public void verifyDateValue()
    {
        System.out.println("Verifying Date Value");
        String uiValue = paymentDetailsPageObjects.getDateValue(parcelsIndex);
        String assertValue = paymentDetailsModel.getParcels().get(parcelsIndex-1).getCREATED_AT();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Assert Value : " + assertValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Name Value",
            priority = 19 )
    public void verifyCustomerNameValue()
    {
        System.out.println("Verifying Customer Name Value");
        String uiValue = paymentDetailsPageObjects.getCustomerName(parcelsIndex);
        String apiValue = paymentDetailsModel.getParcels().get(parcelsIndex-1).getCUSTOMER_NAME();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Value",
            priority = 20 )
    public void verifyPhoneValue()
    {
        System.out.println("Verifying Phone Value");
        String uiValue = paymentDetailsPageObjects.getPhoneValue(parcelsIndex);
        String apiValue = paymentDetailsModel.getParcels().get(parcelsIndex-1).getCUSTOMER_PHONE();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Value",
            priority = 21 )
    public void verifyStatusValue()
    {
        System.out.println("Verifying Status Value");
        String uiValue = paymentDetailsPageObjects.getStatusValue(parcelsIndex);
        String apiValue = paymentDetailsModel.getParcels().get(parcelsIndex-1).getSELLER_STATUS();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue.toLowerCase(),apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Value",
            priority = 22 )
    public void verifyCashCollectionValueInDetailsPage()
    {
        System.out.println("Verifying Cash Collection Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getCashCollectionValue(parcelsIndex);
        String apiValue = String.valueOf(paymentDetailsModel.getParcels().get(parcelsIndex-1).getCASH());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Value",
            priority = 23 )
    public void verifyDeliveryChargeValueInDetailsPage()
    {
        System.out.println("Verifying Delivery Charge Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getDeliveryChargeValue(parcelsIndex);
        String apiValue = String.valueOf(paymentDetailsModel.getParcels().get(parcelsIndex-1).getSHOPUP_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Value",
            priority = 24 )
    public void verifyCodChargeValueInDetailsPage()
    {
        System.out.println("Verifying COD Charge Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getCodChargeValue(parcelsIndex);
        String apiValue = String.valueOf(paymentDetailsModel.getParcels().get(parcelsIndex-1).getSHOPUP_COD_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Value",
            priority = 25 )
    public void verifyReturnChargeValueInDetailsPage()
    {
        System.out.println("Verifying Return Charge Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getReturnChargeValue(parcelsIndex);
        String apiValue = String.valueOf(paymentDetailsModel.getParcels().get(parcelsIndex-1).getSHOPUP_RETURN_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Value",
            priority = 26 )
    public void verifyAmountPaidValueInDetailsPage()
    {
        System.out.println("Verifying Amount Paid Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getAmountPaidValue(parcelsIndex);
        String apiValue = String.valueOf(paymentDetailsModel.getParcels().get(parcelsIndex-1).getPAYABLE_AMOUNT());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Value",
            priority = 27 )
    public void verifyTotalPaidValueInDetailsPage()
    {
        System.out.println("Verifying Total Paid Value In Details Page");
        float uiValue = Float.parseFloat(paymentDetailsPageObjects.getTotalPaidOutValue());
        float apiValue = paymentDetailsModel.getTotalPaidValue();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Back Button Functionality",
            priority = 28 )
    public void verifyBackButtonFunctionality()
    {
        System.out.println("Verifying Back Button Functionality");
        paymentDetailsPageObjects.clickBackButton();
        String url = driver.getCurrentUrl();
        System.out.println("URL : " + url);
        Assert.assertEquals(url,"https://redx.shopups1.xyz/payments/");
    }


    @AfterSuite(alwaysRun = true)
    public void paymentsPageTestsAfterSuite()
    {
        System.out.println("Payments Page Tests After Suite");
        driver.quit();
    }
}
