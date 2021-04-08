package com.shopf.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.*;

import java.util.*;

public class RegistrationFlowTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private TermsAndConditionsPageObjects termsAndConditionsPageObjects;
    private CreateShopPageObjects createShopPageObjects;

    private String cookie;
    private String phoneNumber;
    private String otp = "6666";

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
    public void registrationFlowTestsBeforeClass() throws Exception
    {
        System.out.println("Registration Flow Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        termsAndConditionsPageObjects = new TermsAndConditionsPageObjects(driver);
        createShopPageObjects = new CreateShopPageObjects(driver);

        phoneNumber = PropertyReader.getValueOfKey(PropertyReader.Keys.PHONE_NUMBER);
        phoneNumber = String.valueOf(Long.valueOf(phoneNumber)+1);

        cookie = loginPageObjects.signUpMerchant(phoneNumber,otp);

//        PropertyReader.setValue(PropertyReader.Keys.PHONE_NUMBER,phoneNumber);

        termsAndConditionsPageObjects.clickAcceptTermsButton();
    }

    @BeforeMethod(alwaysRun = true)
    public void registrationFlowTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  description = "Verify Phone Number Validation",
            priority = 1 )
    public void verifyPhoneNumberValidation() throws Exception
    {
        System.out.println("Verifying Phone Number Validation");
        List<String> data = createShopPageObjects.getDataFromCsv("Phone Number Validation","RFI1","RFE1");
        System.out.println("Data From Csv : " + data.toString());
        createShopPageObjects.enterPickupPhoneInput(data.get(0));
        System.out.println("Pickup Phone Error Message : " + data.get(1));
        Assert.assertEquals(data.get(1),"Invalid phone number format");
    }

    @Test(  description = "Verify Required Or Optional Field Validation",
            priority = 2 )
    public void verifyRequiredOrOptionalFieldValidation() throws Exception
    {
        System.out.println("Verifying Required Or Optional Field Validation");
        List<String> data = createShopPageObjects.getDataFromCsv("Required/Optional","RFI2","RFE2");
        List<String> errorMsg;
        System.out.println("Data From Csv : " + data.toString());
        createShopPageObjects.createShop(data);
        errorMsg = data.subList(13,data.size());
        System.out.println("Error Messages : " + errorMsg.toString());
        Assert.assertEquals(errorMsg.get(0),createShopPageObjects.getFullNameErrorMessage());
        Assert.assertEquals(errorMsg.get(1),createShopPageObjects.getShopNameErrorMessage());
        Assert.assertEquals(errorMsg.get(2),createShopPageObjects.getShopEmailErrorMessage());
        Assert.assertEquals(errorMsg.get(3),createShopPageObjects.getShopAddressErrorMessage());
        Assert.assertEquals(errorMsg.get(4),createShopPageObjects.getPickupAddressErrorMessage());
        Assert.assertEquals(errorMsg.get(5),createShopPageObjects.getPickupPhoneErrorMessage());
        Assert.assertEquals(errorMsg.get(6),createShopPageObjects.getPasswordErrorMessage());
        Assert.assertEquals(errorMsg.get(7),createShopPageObjects.getConfirmPasswordErrorMessage());
    }

    @Test(  description = "Verify Invalid String Validation",
            priority = 3 )
    public void verifyInvalidStringValidation() throws Exception
    {
        System.out.println("Verifying Invalid String Validation");
        List<String> data = createShopPageObjects.getDataFromCsv("Invalid String Validation","RFI3","RFE3");
        List<String> errorMsg;
        System.out.println("Data From Csv : " + data.toString());
        createShopPageObjects.createShop(data);
        errorMsg = data.subList(13,data.size());
        System.out.println("Error Messages : " + errorMsg.toString());
        Assert.assertEquals(errorMsg.get(0),createShopPageObjects.getFullNameErrorMessage());
        Assert.assertEquals(errorMsg.get(1),createShopPageObjects.getShopEmailErrorMessage());
        Assert.assertEquals(errorMsg.get(2),createShopPageObjects.getPickupPhoneErrorMessage());
        Assert.assertEquals(errorMsg.get(3),createShopPageObjects.getPasswordErrorMessage());
        Assert.assertEquals(errorMsg.get(4),createShopPageObjects.getConfirmPasswordErrorMessage());
        Assert.assertEquals(errorMsg.get(5),createShopPageObjects.getReferredByErrorMessage());
        Assert.assertEquals(errorMsg.get(6),createShopPageObjects.getReferrerCodeErrorMessage());
    }

//    @Test(  description = "Verify Invalid Input Validation",
//            priority = 4 )
    public void verifyInvalidInputValidation() throws Exception
    {
        System.out.println("Verifying Invalid Input Validation");
        List<String> data = createShopPageObjects.getDataFromCsv("Invalid Input Validation","RFI4","RFE4");
        List<String> errorMsg;
        System.out.println("Data From Csv : " + data.toString());
        createShopPageObjects.createShop(data);
        errorMsg = data.subList(13,data.size());
        System.out.println("Error Messages : " + errorMsg.toString());
        Assert.assertEquals(errorMsg.get(0),createShopPageObjects.getFullNameErrorMessage());
        Assert.assertEquals(errorMsg.get(1),createShopPageObjects.getShopNameErrorMessage());
        Assert.assertEquals(errorMsg.get(2),createShopPageObjects.getShopAddressErrorMessage());
        Assert.assertEquals(errorMsg.get(3),createShopPageObjects.getPickupAddressErrorMessage());
    }

    @Test(  description = "Verify Valid String Validation",
            priority = 5 )
    public void verifyValidStringValidation() throws Exception
    {
        System.out.println("Verifying Valid String Validation");
        List<String> data = createShopPageObjects.getDataFromCsv("Valid String Validation","RFI5","RFE5");
        List<String> errorMsg;
        System.out.println("Data From Csv : " + data.toString());
        createShopPageObjects.createShop(data);
        errorMsg = data.subList(13,data.size());
        System.out.println("Error Messages : " + errorMsg.toString());
    }

    @AfterSuite(alwaysRun = true)
    public void registrationFlowAfterSuite()
    {
        driver.quit();
    }
}
