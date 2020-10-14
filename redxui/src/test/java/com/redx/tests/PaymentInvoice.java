package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.PropertyReader;
import utils.RedXBaseClass;

import java.util.*;

public class PaymentInvoice extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private PaymentUpdatesPageObjects paymentUpdatesPageObjects;
    private PaymentUpdatesPageObjects.ActionBarPageObjects actionBarPageObjects;
    private PaymentUpdatesPageObjects.ViewInvoice viewInvoice;
    private Random random;


    public void pageInitializer()
    {
        homePageObjects = new HomePageObjects();
        paymentUpdatesPageObjects = new PaymentUpdatesPageObjects();
        actionBarPageObjects = paymentUpdatesPageObjects.new ActionBarPageObjects();
        viewInvoice = paymentUpdatesPageObjects.new ViewInvoice();
        random = new Random();
    }


    @BeforeClass(alwaysRun = true)
    public void paymentInvoiceBeforeClass()
    {
        System.out.println("Before Payment Invoice Class");
        androidDriver = getBaseDriver();
        pageInitializer();
        refreshPage();
    }


    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            description = "Verifies Payment Invoice Functionality in Delivered Tab")
    public void verifyParcelInvoiceModule()
    {
        int index;
        String assertVariable = null;
        List<WebElement> parcelsList;

        System.out.println("Verify Parcel Invoice");
        homePageObjects.clickViewPaymentUpdatesModule();
        sleep(1000);
        Assert.assertEquals(actionBarPageObjects.getPageTitle(),"Payment updates");

        paymentUpdatesPageObjects.clickPaidAmountTab();
        sleep(1000);
        parcelsList = paymentUpdatesPageObjects.setParcelsList();
        if(parcelsList.size()!=0) {
            index = random.nextInt(parcelsList.size());
            paymentUpdatesPageObjects.clickViewInvoiceByIndex(index);
            try
            {
                assertVariable = PropertyReader.getValueOfKey("PARCEL_DATE");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Parcel Date cannot be read from Properties");
            }
            Assert.assertEquals(actionBarPageObjects.getPageTitle(), "Parcels");

            viewInvoice.clickDeliveredTab();
            parcelsList = viewInvoice.setPackagesList();
            if (parcelsList.size() != 0)
            {
                viewInvoice.getParcelDetails();
                index = random.nextInt(parcelsList.size());
                viewInvoice.clickDetailsByIndex(index);
                sleep(1000);
                try
                {
                    assertVariable = PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_ID);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Parcel ID cannot be read from Properties");
                }
                Assert.assertEquals(actionBarPageObjects.getParcelDetailsTitle(), assertVariable);
                viewInvoice.getInvoiceDetails();
                actionBarPageObjects.clickBackButton();
                sleep(500);
                actionBarPageObjects.clickBackButton();
            } else {
                System.out.println("No Parcels Found");
                actionBarPageObjects.clickBackButton();
            }
            actionBarPageObjects.clickBackButton();
        }
        else {
            System.out.println("No Parcels Found");
            actionBarPageObjects.clickBackButton();
        }
    }



    @AfterClass(alwaysRun = true)
    public void parcelInvoiceAfterClass()
    {
        System.out.println("After Parcel Invoice Class");
        //closeApp();
    }
}
