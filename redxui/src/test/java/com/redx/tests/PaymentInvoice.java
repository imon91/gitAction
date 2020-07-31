package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.RedXBaseClass;

import java.util.*;

public class PaymentInvoice extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private CommonPageObjects commonPageObjects;
    private HomePageObjects homePageObjects;
    private PaymentUpdatesPageObjects paymentUpdatesPageObjects;
    private PaymentUpdatesPageObjects.ViewInvoice viewInvoice;
    private Random random;


    public void pageInitializer()
    {
        commonPageObjects = new CommonPageObjects();
        homePageObjects = new HomePageObjects();
        paymentUpdatesPageObjects = new PaymentUpdatesPageObjects();
        viewInvoice = paymentUpdatesPageObjects.new ViewInvoice();
        random = new Random();
    }


    @BeforeClass(alwaysRun = true)
    public void paymentInvoiceBeforeClass()
    {
        System.out.println("Before Payment Invoice Class");
        androidDriver = getBaseDriver();
        pageInitializer();
    }


    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            description = "Verifies Payment Invoice Functionality")
    public void verifyParcelInvoiceModule()
    {
        int index;
        List<WebElement> parcelsList;
        System.out.println("Verify Parcel Invoice");
        homePageObjects.clickViewPaymentUpdatesModule();
        Assert.assertEquals(commonPageObjects.getPageTitle(),"Payment updates");
        sleep(1000);
        paymentUpdatesPageObjects.clickPaidAmountTab();
        parcelsList = paymentUpdatesPageObjects.setParcelsList();
        sleep(1000);
        index = random.nextInt(parcelsList.size());
        paymentUpdatesPageObjects.clickViewInvoiceByIndex(index);
        sleep(2000);
        //viewInvoice.clickDeliveredTab();
        viewInvoice.getParcelDetails();
        parcelsList = viewInvoice.setPackagesList();
        sleep(1000);
        index = random.nextInt(parcelsList.size());
        viewInvoice.clickDetailsByIndex(index);
        viewInvoice.getInvoiceDetails();
        viewInvoice.clickBackButton();
        sleep(1000);
        paymentUpdatesPageObjects.clickBackButton();
    }



    @AfterClass(alwaysRun = true)
    public void parcelInvoiceAfterClass()
    {
        System.out.println("After Parcel Invoice Class");
        //closeApp();
    }
}
