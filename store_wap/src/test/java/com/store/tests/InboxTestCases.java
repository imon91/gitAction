package com.store.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObejcts.*;
import utils.StoreWapBaseClass;

import java.util.ArrayList;

public class InboxTestCases extends StoreWapBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private FacebookPageObjects facebookPageObjects;
    private DashBoardPageObjects dashBoardPageObjects;
    private InboxPageObjects inboxPageObjects;
    private ChatScreenPageObjects chatScreenPageObjects;
    private RecordPaymentsPageObjects recordPaymentsPageObjects;
    private OnlinePaymentPageObjects onlinePaymentPageObjects;


    public void pageInitializer(){
        facebookPageObjects = new FacebookPageObjects(androidDriver);
        dashBoardPageObjects = new DashBoardPageObjects(androidDriver);
        inboxPageObjects = new InboxPageObjects(androidDriver);
        chatScreenPageObjects = new ChatScreenPageObjects(androidDriver);
        recordPaymentsPageObjects = new RecordPaymentsPageObjects(androidDriver);
        onlinePaymentPageObjects = new OnlinePaymentPageObjects(androidDriver);
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
//        System.out.println("verifyShareProductsImageFunctionality is called");
//        chatScreenPageObjects.shareImage(2,1);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyShareProductsImageFunctionality")
    public void createPaymentLinkInInbox(){
        System.out.println("createPaymentLinkInInbox is called");
        chatScreenPageObjects.clickOnBottomPanelIcon();
        chatScreenPageObjects.clickOnRecordPaymentsIcon();
        sleep(4000);
        chatScreenPageObjects.selectOrderForPayments();
        int totalDue = Integer.parseInt(recordPaymentsPageObjects.getDueAmount().replaceAll(",",""));
        String partialAmount = String.valueOf((int)(0.3*totalDue));
        recordPaymentsPageObjects.editPayingAmount(partialAmount);
        System.out.println("Partial amount added :"+ partialAmount);
        recordPaymentsPageObjects.clickAddButton();
        recordPaymentsPageObjects.clickDebitCardOption();
        recordPaymentsPageObjects.clickConfirmButton();
        sleep(3000);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "createPaymentLinkInInbox")
    public void onlineCashPayment(){
        System.out.println("onlineCashPayment is called");
        String paymentLink = recordPaymentsPageObjects.copyPaymentLink(1);
        ((JavascriptExecutor)androidDriver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(androidDriver.getWindowHandles());
        androidDriver.switchTo().window(tabs.get(1));
        androidDriver.get(paymentLink);
        sleep(6000);
        onlinePaymentPageObjects.clickPayNowButton();
        sleep(4000);
        ArrayList<String> tabs1 = new ArrayList<String>(androidDriver.getWindowHandles());
        androidDriver.switchTo().window(tabs1.get(2));
        onlinePaymentPageObjects.payWithVisaCard();
        ArrayList<String> tabs2 = new ArrayList<String>(androidDriver.getWindowHandles());
        androidDriver.switchTo().window(tabs2.get(0));
        chatScreenPageObjects.clickOnCloseButton();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "onlineCashPayment")
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
