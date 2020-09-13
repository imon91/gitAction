package com.store.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObejcts.CustomerDetailsPageObjects;
import pageObejcts.CustomerListPageObjects;
import pageObejcts.DashBoardPageObjects;
import pageObejcts.FacebookPageObjects;
import utils.StoreWapBaseClass;



public class CustomerListTestCases extends StoreWapBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private CustomerListPageObjects customerListPageObjects;
    private CustomerDetailsPageObjects customerDetailsPageObjects;
    private FacebookPageObjects facebookPageObjects;
    private DashBoardPageObjects dashBoardPageObjects;


    public void pageInitializer(){
        customerListPageObjects = new CustomerListPageObjects(androidDriver);
        customerDetailsPageObjects = new CustomerDetailsPageObjects(androidDriver);
        dashBoardPageObjects = new DashBoardPageObjects(androidDriver);
        facebookPageObjects = new FacebookPageObjects(androidDriver);
    }

    @BeforeClass(alwaysRun = true)
    public void customerListTestCasesBeforeClass() throws Exception {
        System.out.println("customerListTestCasesBeforeClass is called");
        androidDriver = getBaseDriver();
        pageInitializer();
        /*String facebookPage = facebookPageObjects.connectRandomFacebookPage(3);
        System.out.println(facebookPage + " is selected");
        facebookPageObjects.clickContinueAfterConnectFacebookPage();
        sleep(3000);
         */
        dashBoardPageObjects.clickCustomersListButton();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void verifyCustomerListPageTitle(){
        System.out.println("verifyCustomerListPageTitle is called");
        sleep(5000);
        Assert.assertEquals(customerListPageObjects.getTitleName(),"Customer List");
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyCustomerListPageTitle")
    public void editCustomerDetailsOfAnExistingCustomer(){
        System.out.println("editCustomerDetailsOfAnExistingCustomer is called");
        customerListPageObjects.clickACustomerFromCustomerList(1);
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE} , dependsOnMethods = "editCustomerDetailsOfAnExistingCustomer")
    public void verifyCustomerDetailsPageTitle_ThroughCustomerList(){
        System.out.println("verifyCustomerDetailsPageTitle_ThroughCustomerList is called");
        Assert.assertEquals(customerDetailsPageObjects.getTitleName_IfThroughCustomerList(),"Customer Details");
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyCustomerDetailsPageTitle_ThroughCustomerList")
    public void editDetails_ThroughCustomerList(){
        System.out.println("editDetails_ThroughCustomerList is called");
        customerDetailsPageObjects.editCustomerNameWithValidName();
        customerDetailsPageObjects.editMobileNumberWithValidMobileNumber();
        customerDetailsPageObjects.editAddress();
        customerDetailsPageObjects.chooseAreaName(1);
        customerDetailsPageObjects.chooseRatingForCustomer(0);
        customerDetailsPageObjects.enterCustomerTags();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},dependsOnMethods = "editDetails_ThroughCustomerList")
    public void verifySaveButtonFunctionality(){
        System.out.println("verifySaveButtonFunctionality is called");
        customerDetailsPageObjects.clickOnSaveButton();
        Assert.assertEquals(customerDetailsPageObjects.getSuccessMessage(),"Profile update success");
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifySaveButtonFunctionality")
    public void verifyAddNewCustomerButtonFunctionality(){
        System.out.println("verifyAddNewCustomerButtonFunctionality is called");
        customerListPageObjects.clickOnAddNewCustomerButton();
        Assert.assertEquals(customerDetailsPageObjects.getTitleName_IfThroughCustomerList(),"Customer Details");
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyAddNewCustomerButtonFunctionality")
    public void verifyErrorMessageInCustomerDetailsPage(){
        System.out.println("verifyErrorMessageInCustomerDetailsPage is called");
        customerDetailsPageObjects.clickOnSaveButton();
        Assert.assertEquals(customerDetailsPageObjects.customerNameErrorMessage(),"This field is required");
        customerDetailsPageObjects.enterInvalidCustomerName();
        Assert.assertEquals(customerDetailsPageObjects.customerNameErrorMessage(),"Invalid customer name");
        customerDetailsPageObjects.editCustomerNameWithValidName();
        customerDetailsPageObjects.enterInvalidMobileNumber();
        Assert.assertEquals(customerDetailsPageObjects.customerMobileNumberErrorMessage(),"It is not a valid phone number");
        customerDetailsPageObjects.editMobileNumberWithValidMobileNumber();
        customerDetailsPageObjects.clickOnBackButton_IfThroughCustomerList();
        sleep(5000);
    }



    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "verifyErrorMessageInCustomerDetailsPage")
    public void enterValidCustomerDetailsOfNewCustomer(){
        System.out.println("enterValidCustomerDetailsOfNewCustomer is called");
        System.out.println("no. of customers before creation " +customerListPageObjects.getNumberOFCustomers());
        customerListPageObjects.clickOnAddNewCustomerButton();
        customerDetailsPageObjects.enterValidCustomerName();
        customerDetailsPageObjects.enterValidMobileNumber();
        customerDetailsPageObjects.enterAddress();
        customerDetailsPageObjects.chooseAreaName(0);
        customerDetailsPageObjects.chooseRatingForCustomer(0);
        customerDetailsPageObjects.enterCustomerTags();
        customerDetailsPageObjects.clickOnSaveButton();
        Assert.assertEquals(customerDetailsPageObjects.getSuccessMessage(),"User has been update successfully");
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dependsOnMethods = "enterValidCustomerDetailsOfNewCustomer")
    public void getCustomerDetailsFromCustomerListPage(){
        System.out.println("getCustomerDetailsFromCustomerListPage is called");
        sleep(3000);
        System.out.println("no. of customers after creation " + customerListPageObjects.getNumberOFCustomers());
        System.out.println("Customer Name         : " + customerListPageObjects.getCustomerName(1));
        System.out.println("Customer MobileNumber : " + customerListPageObjects.getCustomerMobileNumber(1));
        System.out.println("Customer Rating       : " + customerListPageObjects.getCustomerRating(1));
        System.out.println(customerListPageObjects.getCustomerName(1));
        customerListPageObjects.clickOnBackButton();
    }


    @AfterClass(alwaysRun = true)
    public void customerListTestCasesAfterClass(){
        System.out.println("customerListTestCasesAfterClass is called");
    }



}
