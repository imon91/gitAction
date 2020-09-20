package com.store.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObejcts.*;

import static utils.StoreWapBaseClass.getBaseDriver;
import static utils.StoreWapBaseClass.sleep;

public class InboxTestCases {


    private AndroidDriver<WebElement> androidDriver;
    private FacebookPageObjects facebookPageObjects;
    private DashBoardPageObjects dashBoardPageObjects;
    private InboxPageObjects inboxPageObjects;
    private ChatScreenPageObjects chatScreenPageObjects;
    private RecordPaymentsPageObjects recordPaymentsPageObjects;


    public void pageInitializer(){
        facebookPageObjects = new FacebookPageObjects(androidDriver);
        dashBoardPageObjects = new DashBoardPageObjects(androidDriver);
        inboxPageObjects = new InboxPageObjects(androidDriver);
        chatScreenPageObjects = new ChatScreenPageObjects(androidDriver);
        recordPaymentsPageObjects = new RecordPaymentsPageObjects(androidDriver);
    }


    @BeforeClass(alwaysRun = true)
    public void inboxTestCasesBeforeClass() throws Exception {
        System.out.println("inboxTestCasesBeforeClass is called");
        androidDriver = getBaseDriver();
        pageInitializer();
        String facebookPage = facebookPageObjects.connectRandomFacebookPage(2);
        System.out.println(facebookPage + " is selected");
        facebookPageObjects.clickContinueAfterConnectFacebookPage();
        sleep(3000);
        dashBoardPageObjects.clickInboxButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyClickingCustomer(){
        System.out.println("verifyClickingCustomer is called");
        String customerName = inboxPageObjects.clickOnCustomer(1);
        Assert.assertEquals(chatScreenPageObjects.getCustomerName(),customerName);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyClickingCustomer")
    public void verifyShareProductsImageFunctionality(){
        System.out.println("verifyShareProductsImageFunctionality is called");
        chatScreenPageObjects.shareImage(2,1);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyShareProductsImageFunctionality")
    public void recordPaymentsInInbox(){
        System.out.println("recordPaymentsInInbox is called");
        //chatScreenPageObjects.clickOnBottomPanelIcon();
        chatScreenPageObjects.clickOnRecordPaymentsIcon();
        sleep(4000);
        chatScreenPageObjects.selectOrderForPayments();
        int totalDue = Integer.parseInt(recordPaymentsPageObjects.getDueAmount().replaceAll(",",""));
        String partialAmount = String.valueOf((int)(0.3*totalDue));
        recordPaymentsPageObjects.editPayingAmount(partialAmount);
        System.out.println("Partial amount added :"+ partialAmount);
        recordPaymentsPageObjects.clickAddButton();
        recordPaymentsPageObjects.clickCashOption();
        recordPaymentsPageObjects.clickConfirmButton();
        sleep(3000);
        chatScreenPageObjects.clickOnCloseButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "recordPaymentsInInbox")
    public void trackOrderInInbox(){
        System.out.println("trackOrderInInbox is called");
        chatScreenPageObjects.clickOnTrackOrderIcon();
        sleep(4000);
        chatScreenPageObjects.selectOrderForTrackOrder();
        chatScreenPageObjects.clickOnShareTrackingLinkButton();
        chatScreenPageObjects.clickOnCloseButton();
    }

    @AfterClass(alwaysRun = true)
    public void inboxTestCasesAfterClass(){
        System.out.println("inboxTestCasesAfterClass is called");
    }


}
