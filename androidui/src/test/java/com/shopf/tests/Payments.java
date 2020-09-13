package com.shopf.tests;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.CheckoutAddressPageObjects;
import pageObjects.MyBagPageObjects;
import pageObjects.PaymentModePageObjects;
import utils.AndroidAppConstants;
import utils.AndroidBaseClass;
import utils.MyActions;

import java.util.List;
import java.util.Map;

public class Payments extends AndroidBaseClass {



    private AndroidDriver<WebElement> androidDriver;
    private MyBagPageObjects myBagPageObjects;
    private CheckoutAddressPageObjects checkoutAddressPageObjects;
    private CheckoutAddressPageObjects.SelectAddress selectAddress;
    private PaymentModePageObjects paymentModePageObjects;
    private PaymentModePageObjects.ProductDetails productDetails;
    private MyActions myActions;
    private SoftAssert softAssert;
    private String suiteName;
    private String app;


    @BeforeClass(alwaysRun = true)
    public void paymentsBeforeClass(){
        System.out.println("Payments Before Class is called");
        androidDriver = getBaseDriver();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
        myActions = new MyActions();
        softAssert = new SoftAssert();
        suiteName = "regression";
        myBagPageObjects = new MyBagPageObjects(androidDriver);
        checkoutAddressPageObjects = new CheckoutAddressPageObjects(androidDriver);
        selectAddress = checkoutAddressPageObjects.new SelectAddress(androidDriver);
        paymentModePageObjects = new PaymentModePageObjects(androidDriver);
        productDetails = paymentModePageObjects.new ProductDetails(androidDriver);
        switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        sleep(3000);
    }


    @Test(groups = {"Payments.verifyPaymentBreakup",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnGroups = "Address.verifyDeliveryTimeMessageText")
    public void verifyPaymentBreakup() {
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            List<Integer> chargesList = myBagPageObjects.getChargeandTotalValue();
            sleep(3000);
            paymentModePageObjects.clickOnPaymentBreakup();

            int earnings = paymentModePageObjects.getEarningsAmount();
            int expectedEarnings = chargesList.get(1);
            softAssert.assertEquals(earnings, expectedEarnings);
            System.out.println("Earnings Data is working properly");

            int orderValue = paymentModePageObjects.getCartValueAmount();
            int expectedOrderValue = chargesList.get(0);
            softAssert.assertEquals(orderValue, expectedOrderValue);
            System.out.println("Cart Value Data is working properly");

            int shippingCharges = paymentModePageObjects.getShippingCharges();
            int expectedShippingCharges = chargesList.get(4);
            softAssert.assertEquals(shippingCharges, expectedShippingCharges);
            System.out.println("Shipping Charges Data is working properly");

            softAssert.assertAll();
            paymentModePageObjects.clickOnCloseButton();
        }
    }


    @Test(groups = {"Payments.verifyProductDataInPaymentsPage",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, dependsOnMethods = "Payments.verifyPaymentBreakup")
    public void verifyProductDataInPaymentsPage() {
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
            int containersSize = productDetails.getProductContainerSize();
            Assert.assertEquals(containersSize, productDetailsMap.size());

            for (int i = 0; i < containersSize; i++) {
                System.out.println(productDetails.getProductImage(i));
                System.out.println(productDetailsMap.get(i).get(0));
                System.out.println(productDetails.getProductName(i));
                System.out.println(productDetailsMap.get(i).get(1));
                System.out.println(productDetails.getProductOrderValue(i));
                System.out.println(productDetailsMap.get(i).get(4));
            }

            for (int i = 0; i < containersSize; i++) {
                for (int j = 0; j < productDetailsMap.size(); j++) {
                    if (i == 0 || i == containersSize - 1 || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                        if (productDetails.getProductName(i).equalsIgnoreCase(productDetailsMap.get(j).get(1)) &&
                                productDetails.getProductOrderValue(i).equalsIgnoreCase(productDetailsMap.get(j).get(4)) &&
                                productDetails.getProductImage(i).equalsIgnoreCase(productDetailsMap.get(j).get(0))) {
                            System.out.println("Product Data is working properly");
                        }
                    }
                }
            }
        }
    }


    @Test(groups = {"Payments.verifySelectedAddressData",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, dependsOnMethods = "Payments.verifyChangeAddress")
    public void verifySelectedAddressData() {
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            List<String> addressDataList = paymentModePageObjects.getSelectedAddressDetails();

            String firstName = paymentModePageObjects.getNamefromAddress();
            String expectedFirstName = addressDataList.get(0);
            System.out.println(firstName + " " + expectedFirstName);
            softAssert.assertEquals(firstName, expectedFirstName);

            String address = paymentModePageObjects.getAddressfromAddress();
            String expectedAddress = addressDataList.get(1);
            System.out.println(address + " " + expectedAddress);
            softAssert.assertEquals(address, expectedAddress);

            String expectedLandmark = addressDataList.get(2);
            System.out.println(expectedLandmark);
            if (expectedLandmark.isEmpty()) {

                String city = paymentModePageObjects.getCityfromAddress();
                String expectedCity = addressDataList.get(3);
                System.out.println(city + " " + expectedCity);
                softAssert.assertEquals(city, expectedCity);

                String phoneNumber = paymentModePageObjects.getPhoneNumberFromAddress();
                String expectedPhoneNumber = addressDataList.get(4);
                System.out.println(phoneNumber + " " + expectedPhoneNumber);
                softAssert.assertEquals(phoneNumber, expectedPhoneNumber);
            } else {
                String landmark = paymentModePageObjects.getLandmarkfromAddress();
                String landmarkValue = landmark.replace("Landmark: ", "");
                System.out.println(landmark + "" + expectedLandmark);
                softAssert.assertEquals(landmarkValue, expectedLandmark);

                String city = paymentModePageObjects.getCity();
                String expectedCity = addressDataList.get(3);
                System.out.println(city + " " + expectedCity);
                softAssert.assertEquals(city, expectedCity);

                String phoneNumber = paymentModePageObjects.getPhoneNumber();
                String expectedPhoneNumber = addressDataList.get(4);
                System.out.println(phoneNumber + " " + expectedPhoneNumber);
                softAssert.assertEquals(phoneNumber, expectedPhoneNumber);
            }


            softAssert.assertAll();
            System.out.println("Address selected properly");
        }
    }


    @Test(groups = {"Payments.verifyCODPaymentOption",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},dependsOnMethods = "Payments.verifySelectedAddressData")
    public void verifyCODPaymentOption(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            paymentModePageObjects.selectPaymentOptionCOD();
            sleep(3000);
            String message = paymentModePageObjects.getTextFromCODConatainer();
            Assert.assertTrue(message.equalsIgnoreCase("Keep cash at the time of delivery"));
            System.out.println("COD payment option is selected");
        }
    }


    @Test(  groups = {"Payments.verifyProceedPayment",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify Proceed Payment Without Change Address",
            dependsOnMethods = "Payments.verifyCODPaymentOption"  )
    public void verifyProceedPayment(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            sleep(3000);
            paymentModePageObjects.clickOnPayTopButton();
            sleep(5000);
            String windowHandle = androidDriver.getWindowHandle();
            androidDriver.switchTo().window(windowHandle);
            String currentPage = androidDriver.getCurrentUrl();
            Assert.assertTrue(currentPage.equalsIgnoreCase(AndroidAppConstants.URL_CHECKOUT_THANKYOU));
            System.out.println("Page successfully navigated to OrderSuccessful Page");
        }
    }



    @Test(  groups = {"Payments.verifyChangeAddress",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},enabled = true,
            description = "Verify Proceed Payment With Change Address",
            dependsOnMethods = "Payments.verifyProductDataInPaymentsPage"  )
    public void verifyChangeAddress(){
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            sleep(8000);
            paymentModePageObjects.clickOnChangeAddress();
            sleep(3000);
            String windowHandle = androidDriver.getWindowHandle();
            androidDriver.switchTo().window(windowHandle);
            String currentPage = androidDriver.getCurrentUrl();
            Assert.assertTrue(currentPage.equalsIgnoreCase(AndroidAppConstants.URL_CHECKOUT_ADDRESS));
            selectAddress.clickOnShowMoreAddress();
            selectAddress.selectAnAddress(selectAddress.getListOfVisibleAddress().get(4));
            sleep(3000);
            checkoutAddressPageObjects.clickOnProceedToPaymentBottomButton();
            sleep(3000);
        }
    }


}
