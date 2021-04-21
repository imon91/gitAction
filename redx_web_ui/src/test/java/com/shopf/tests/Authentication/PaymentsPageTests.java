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

public class PaymentsPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private PaymentsPageObjects paymentsPageObjects;
    private PaymentsPageObjects.PaymentDetailsPageObjects paymentDetailsPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private PaymentsModel paymentsModel;
    private PaymentDetailsModel paymentDetailsModel;
    private String allPaymentsListGetCallUrl;
    private int invoiceId;
    private int paymentsSize;
    private int paymentsIndex;
    private int parcelsIndex;
    private int parcelsSize;
    private String host;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void paymentsPageTestsBeforeClass() throws Exception
    {
        System.out.println("Payments Page Tests Before Class");
        driver = getBaseDriver();
        host = System.getProperty(BuildParameterKeys.KEY_HOST);
        actionBarObjects = new ActionBarObjects(driver);
        paymentsPageObjects = new PaymentsPageObjects(driver);
        paymentDetailsPageObjects = paymentsPageObjects.new PaymentDetailsPageObjects();

        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        paymentsModel = new PaymentsModel();
        paymentDetailsModel = new PaymentDetailsModel();

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        actionBarObjects.clickPaymentsLink();

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
        parcelsIndex = paymentDetailsPageObjects.getRandomParcelIndex(parcelsSize);
        System.out.println("Parcels Index : " + parcelsIndex);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, PaymentsPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "142")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify All Pickup Location Filter Functionality",
            priority = 301 )
    public void verifyAllPickupLocationFilterFunctionality()
    {
        System.out.println("Verifying All Pickup Location Filter Functionality");
    }

    @TestRails(caseId = "143")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Date Range Filter Functionality",
            priority = 302 )
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

        paymentsPageObjects.clickClearDateFilterIcon();
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "144")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Id Value",
            priority = 303 )
    public void verifyInvoiceIdValue()
    {
        System.out.println("Verifying Invoice Id Value");
        String uiValue = paymentsPageObjects.getInvoiceIdValue(paymentsIndex);
        String apiValue = String.valueOf(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getLOGISTICS_INVOICE_ID());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);

    }

    @TestRails(caseId = "145")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Date Value",
            priority = 304 )
    public void verifyInvoiceDateValue()
    {
        System.out.println("Verifying Invoice Date Value");
        String uiValue = paymentsPageObjects.getInvoiceDateValue(paymentsIndex);
        String assertValue = paymentsModel.getBody().getPayments().get(paymentsIndex-1).getCREATED_AT();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Assert Value : " + assertValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @TestRails(caseId = "146")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Cash Collection Value",
            priority = 305 )
    public void verifyCashCollectionValue()
    {
        System.out.println("Verifying Cash Collection Value");
        String uiValue = paymentsPageObjects.getCashCollectionValue(paymentsIndex);
        String apiValue = String.format("%.2f",(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getTOTAL_SHOPUP_CHARGE() + paymentsModel.getBody().getPayments().get(paymentsIndex-1).getAMOUNT()));
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "147")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Delivery Charge Value",
                priority = 306 )
    public void verifyDeliveryChargeValue()
    {
        System.out.println("Verifying Delivery Charge Value");
        String uiValue = paymentsPageObjects.getDeliveryChargeValue(paymentsIndex);
        String apiValue = String.valueOf(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getTOTAL_SHOPUP_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "148")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify RedX Credits Value",
            priority = 307 )
    public void verifyRedxCreditsValue()
    {
        System.out.println("Verifying RedX Credits Value");
        String uiValue = paymentsPageObjects.getRedxCreditValue(paymentsIndex);
        String apiValue = String.valueOf(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getCREDITS_USED());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "149")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify COD Charge Value",
            priority = 308 )
    public void verifyCodChargeValue()
    {
        System.out.println("Verifying COD Charge Value");
        String uiValue = paymentsPageObjects.getCodChargeValue(paymentsIndex);
        String apiValue = String.valueOf(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getTOTAL_COD_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "150")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Return Charge Value",
            priority = 309 )
    public void verifyReturnChargeValue()
    {
        System.out.println("Verifying Return Charge Value");
        String uiValue = paymentsPageObjects.getReturnChargeValue(paymentsIndex);
        String apiValue = String.valueOf(paymentsModel.getBody().getPayments().get(paymentsIndex-1).getTOTAL_RETURN_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "151")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Advance Payment Repayment Value",
            priority = 310 )
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

    @TestRails(caseId = "152")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Amount Paid Value",
            priority = 311 )
    public void verifyAmountPaidValue()
    {
        System.out.println("Verifying Amount Paid Value");
        String uiValue = paymentsPageObjects.getAmountPaidOut(paymentsIndex);
        String apiValue = String.format("%.2f",paymentsModel.getBody().getPayments().get(paymentsIndex-1).getAMOUNT());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "153")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Button Functionality",
            priority = 312 )
    public void verifyDownloadButtonFunctionality()
    {
        System.out.println("Verifying Download Button Functionality");
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/Downloads";
        File directory = new File(filePath);
        File[] dirContains = directory.listFiles();
        int files1 = dirContains.length;
        System.out.println("Current Files : " + files1);

        paymentsPageObjects.clickDownloadInvoiceButton(paymentsIndex);

        if(host.equalsIgnoreCase("local"))
        {
            sleep(3000);
            File[] dirContain = directory.listFiles();
            int files2 = dirContain.length;
            System.out.println("Files After Download : " + files2);
            Assert.assertEquals(files2,files1+1);
        }
    }

    @TestRails(caseId = "154")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Id Functionality",
            priority = 313 )
    public void verifyInvoiceIdFunctionality()
    {
        System.out.println("Verifying Invoice Id Functionality");
        paymentsPageObjects.clickInvoiceId(paymentsIndex);
        String title = paymentDetailsPageObjects.getTitleCaptionValue();
        System.out.println("Title : " + title);
        Assert.assertEquals(title,"Payment Details");
    }

    @TestRails(caseId = "155")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Id Value In Details Page",
            priority = 314 )
    public void verifyInvoiceIdValueInDetailsPage()
    {
        System.out.println("Verifying Invoice Id Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getInvoiceInfo(1).substring(12);
        System.out.println("Invoice ID : " + invoiceId);
        System.out.println("Value in UI : " + uiValue);
        Assert.assertEquals(uiValue,String.valueOf(invoiceId));
    }

    @TestRails(caseId = "156")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Invoice Date Value In Details Page",
            priority = 315 )
    public void verifyInvoiceDateValueInDetailsPage()
    {
        System.out.println("Verifying Invoice Date Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getInvoiceInfo(2);
        String date = paymentsModel.getBody().getPayments().get(paymentsIndex-1).getCREATED_AT();
        System.out.println("Invoice Date : " + date);
        System.out.println("Value in UI : " + uiValue);
        Assert.assertEquals(uiValue,date);
    }

    @TestRails(caseId = "157")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Button Functionality In Details Page",
            priority = 316 )
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

        if(host.equalsIgnoreCase("local"))
        {
            sleep(3000);
            File[] dirContain = directory.listFiles();
            int files2 = dirContain.length;
            System.out.println("Files After Download : " + files2);
            Assert.assertEquals(files2,files1+1);
        }
    }

    @TestRails(caseId = "158")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Parcel Id Value",
            priority = 317 )
    public void verifyParcelIdValue()
    {
        System.out.println("Verifying Parcel Id Value");
        String uiValue = paymentDetailsPageObjects.getParcelIdValue(parcelsIndex);
        String apiValue = paymentDetailsModel.getParcels().get(parcelsIndex-1).getTRACKING_ID();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "159")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Date Value",
            priority = 318 )
    public void verifyDateValue()
    {
        System.out.println("Verifying Date Value");
        String uiValue = paymentDetailsPageObjects.getDateValue(parcelsIndex);
        String assertValue = paymentDetailsModel.getParcels().get(parcelsIndex-1).getCREATED_AT();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Assert Value : " + assertValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @TestRails(caseId = "160")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Customer Name Value",
            priority = 319 )
    public void verifyCustomerNameValue()
    {
        System.out.println("Verifying Customer Name Value");
        String uiValue = paymentDetailsPageObjects.getCustomerName(parcelsIndex);
        String apiValue = paymentDetailsModel.getParcels().get(parcelsIndex-1).getCUSTOMER_NAME();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "161")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Value",
            priority = 320 )
    public void verifyPhoneValue()
    {
        System.out.println("Verifying Phone Value");
        String uiValue = paymentDetailsPageObjects.getPhoneValue(parcelsIndex);
        String apiValue = paymentDetailsModel.getParcels().get(parcelsIndex-1).getCUSTOMER_PHONE();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "162")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Status Value",
            priority = 321 )
    public void verifyStatusValue()
    {
        System.out.println("Verifying Status Value");
        String uiValue = paymentDetailsPageObjects.getStatusValue(parcelsIndex);
        String apiValue = paymentDetailsModel.getParcels().get(parcelsIndex-1).getSELLER_STATUS();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue.toLowerCase(),apiValue);
    }

    @TestRails(caseId = "163")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Cash Collection Value In Details Page",
            priority = 322 )
    public void verifyCashCollectionValueInDetailsPage()
    {
        System.out.println("Verifying Cash Collection Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getCashCollectionValue(parcelsIndex);
        String apiValue = String.valueOf(paymentDetailsModel.getParcels().get(parcelsIndex-1).getCASH());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "164")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Delivery Charge Value In Details Page",
            priority = 323 )
    public void verifyDeliveryChargeValueInDetailsPage()
    {
        System.out.println("Verifying Delivery Charge Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getDeliveryChargeValue(parcelsIndex);
        String apiValue = String.valueOf(paymentDetailsModel.getParcels().get(parcelsIndex-1).getSHOPUP_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "165")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Cod Charge Value In Details Page",
            priority = 324 )
    public void verifyCodChargeValueInDetailsPage()
    {
        System.out.println("Verifying COD Charge Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getCodChargeValue(parcelsIndex);
        String apiValue = String.valueOf(paymentDetailsModel.getParcels().get(parcelsIndex-1).getSHOPUP_COD_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "166")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Return Charge Value In Details Page",
            priority = 325 )
    public void verifyReturnChargeValueInDetailsPage()
    {
        System.out.println("Verifying Return Charge Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getReturnChargeValue(parcelsIndex);
        String apiValue = String.valueOf(paymentDetailsModel.getParcels().get(parcelsIndex-1).getSHOPUP_RETURN_CHARGE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "167")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Amount Paid Value In Details Page",
            priority = 326 )
    public void verifyAmountPaidValueInDetailsPage()
    {
        System.out.println("Verifying Amount Paid Value In Details Page");
        String uiValue = paymentDetailsPageObjects.getAmountPaidValue(parcelsIndex);
        String apiValue = String.valueOf(paymentDetailsModel.getParcels().get(parcelsIndex-1).getPAYABLE_AMOUNT());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

//    @TestRails(caseId = "168")
//    @Test(  groups = {CoreConstants.GROUP_SANITY},
//            description = "Verify Total Paid Value In Details Page",
//            priority = 327 )
    public void verifyTotalPaidValueInDetailsPage()
    {
        System.out.println("Verifying Total Paid Value In Details Page");
        float uiValue = Float.parseFloat(paymentDetailsPageObjects.getTotalPaidOutValue());
        float apiValue = paymentDetailsModel.getTotalPaidValue();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @TestRails(caseId = "169")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Back Button Functionality",
            priority = 328 )
    public void verifyBackButtonFunctionality()
    {
        System.out.println("Verifying Back Button Functionality");
        paymentDetailsPageObjects.clickBackButton();
        String url = driver.getCurrentUrl();
        System.out.println("URL : " + url);
        Assert.assertEquals(url,"https://redx.shopups1.xyz/payments/");
    }
}
