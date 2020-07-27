package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.AddNewAddressPageObjects;
import pageObjects.CheckoutAddressPageObjects;
import pageObjects.MyBagPageObjects;
import services.commerceMethods.GetMyBagApiResponse;
import utils.AndroidBaseClass;
import utils.MyActions;
import utils.ServiceRequestLayer;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Address extends AndroidBaseClass {



    private AndroidDriver<WebElement> androidDriver;
    private MyBagPageObjects myBagPageObjects;
    private CheckoutAddressPageObjects checkoutAddressPageObjects;
    private CheckoutAddressPageObjects.SelectAddress selectAddress;
    private CheckoutAddressPageObjects.SelectAddress.AddressField addressField;
    private CheckoutAddressPageObjects.EstimatedDeliveryDates estimatedDeliveryDates;
    private CheckoutAddressPageObjects.EstimatedDeliveryDates.EstimatedDeliveryDatesItems estimatedDeliveryDatesItems;
    private AddNewAddressPageObjects addNewAddressPageObjects;
    private GetMyBagApiResponse getMyBagApiResponse;
    private ServiceRequestLayer serviceRequestLayer;
    private MyActions myActions;
    private SoftAssert softAssert;
    private String suiteName;


    @BeforeClass(alwaysRun = true)
    public void addressBeforeClass(){
        System.out.println("AddressBeforeClass is called");
        androidDriver = getBaseDriver();
        myBagPageObjects = new MyBagPageObjects(androidDriver);
        checkoutAddressPageObjects = new CheckoutAddressPageObjects(androidDriver);
        selectAddress = checkoutAddressPageObjects.new SelectAddress(androidDriver);
        addressField = selectAddress.new AddressField(androidDriver);
        estimatedDeliveryDates = checkoutAddressPageObjects.new EstimatedDeliveryDates(androidDriver);
        estimatedDeliveryDatesItems = estimatedDeliveryDates.new EstimatedDeliveryDatesItems(androidDriver);
        addNewAddressPageObjects = new AddNewAddressPageObjects(androidDriver);
        myActions = new MyActions();
        softAssert = new SoftAssert();
        serviceRequestLayer = new ServiceRequestLayer();
        getMyBagApiResponse = serviceRequestLayer.getMyBagControl();
        suiteName = "sanity";
        sleep(5000);
    }


    @Test(groups = {"Address.cartValueData",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true,dependsOnGroups = "MyCart.verifyContinueShopping")
    public void cartValueData(){
        List<Integer> chargesList = myBagPageObjects.getChargeandTotalValue();
        int orderValue = Integer.parseInt(checkoutAddressPageObjects.getCartValue().replaceAll("Tk. ","").replaceAll(",",""));
        int expectedOrderValue = chargesList.get(0);
        Assert.assertEquals(orderValue, expectedOrderValue);
        System.out.println("Total order value is working properly");
    }


    @Test(groups = {"Address.verifyShowMoreAddressesButton",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},dependsOnGroups = "Address.cartValueData")
    public void verifyShowMoreAddressesButton(){
        int addressListSize = selectAddress.getListOfVisibleAddress().size();
        int expectedAddressListSize = checkoutAddressPageObjects.getAddressListSizeData();
        if (expectedAddressListSize>5) {
            selectAddress.clickOnShowMoreAddress();
            int addressListSize_new = selectAddress.getListOfVisibleAddress().size();
            Assert.assertTrue(addressListSize < addressListSize_new);
            System.out.println("Show More Addresses button is working properly");
        }
    }


    @Test(groups = {"Address.verifyListOfAddresses",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true,dependsOnGroups = "Address.verifyShowMoreAddressesButton")
    public void verifyListOfAddresses(){
        //selectAddress.clickOnShowMoreAddress();
        int addressListSize = selectAddress.getListOfVisibleAddress().size();
        System.out.println("Address List is : " + addressListSize);
        int expectedAddressListSize = checkoutAddressPageObjects.getAddressListSizeData();
        Assert.assertEquals(addressListSize, expectedAddressListSize);
    }


    @Test(groups = {"Address.verifyEditAddress",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnGroups = "Address.verifyListOfAddresses")
    public void verifyEditAddress() throws Exception {
        //selectAddress.clickOnShowMoreAddress();
        int addressListSize = selectAddress.getListOfVisibleAddress().size();
        System.out.println("Address List is : " + addressListSize);
        for (int i = 0; i < addressListSize; i++) {
            if (i == 0 || i == addressListSize - 1 ) {
                System.out.println("List of Edit Address Button is :" + addressField.getListOfEditAddressButtons().size());
                addressField.clickOnEditAddressButton(addressField.getListOfEditAddressButtons().get(i));
                sleep(5000);
                addNewAddressPageObjects.editNameInAddress("Hari");
                addNewAddressPageObjects.editAddressInAddress("TCE Street");
                addNewAddressPageObjects.clickOnSaveAddress();
                sleep(10000);
                myActions.clickOnHardKeyBack();
                sleep(5000);

                Map<Integer, List<String>> addressDataMap = checkoutAddressPageObjects.getAddressData();
                String name = addressField.getFirstName(i);
                String expectedName = addressDataMap.get(i).get(0);
                softAssert.assertEquals(name,expectedName);

                String address = addressField.getAddress(i);
                String expectedAddress = addressDataMap.get(i).get(1);
                softAssert.assertEquals(address,expectedAddress);
            }
        }
        softAssert.assertAll();
        System.out.println("Address is edited successfully");
    }


    @Test(groups = {"Address.verifyDeleteAddress",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnGroups = "Address.verifyEditAddress")
    public void verifyDeleteAddress() {
        int addressListSize = selectAddress.getListOfVisibleAddress().size();
        System.out.println("Address List is : " + addressListSize);
        if (addressListSize > 0) {
            Random random = new Random();
            int index = random.nextInt(addressListSize);
            System.out.println("List of Delete Address Button is :" + addressField.getListOfDeleteButtons().size());
            addressField.clickOnDeleteAddressButton(addressField.getListOfDeleteButtons().get(index));
            sleep(3000);
            addressListSize--;
        }

        int expectedAddressListSize = checkoutAddressPageObjects.getAddressListSizeData();
        Assert.assertEquals(addressListSize, expectedAddressListSize);
    }


    @Test(groups = {"Address.verifyDeleteProductInAddressPage",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "verify Delete Product",
            dependsOnGroups = "Address.verifyDeleteAddress")
    public void verifyDeleteProductInEstimatedDeliveryPage() {
        int itemsList = estimatedDeliveryDates.getListOfEstimatedDeliveryItems().size();
        sleep(5000);
        if (itemsList > 1) {
            Random random = new Random();
            int index = random.nextInt(itemsList);
            estimatedDeliveryDatesItems.clickOnEstimatedDeliveryItem(
                    estimatedDeliveryDatesItems.
                            getListOfEstimatedDeliveryItemDelete().get(index));
            sleep(3000);
            itemsList--;
        } else {
            System.out.println("Sufficient element is not present");
        }
        Assert.assertEquals(itemsList,myBagPageObjects.getListOfContainersData());
    }


    @Test(groups = {"Address.deleteProductWithCODDisabled",
            CoreConstants.GROUP_SANITY}, enabled = true,
            dependsOnGroups = "Address.verifyDeleteProductInAddressPage")
    public void deleteProductWithCODDisabled() {
        estimatedDeliveryDatesItems.deleteProductWithCODDisabled();
        sleep(3000);
        int expectedItemsList = myBagPageObjects.getListOfContainersData();
        int itemsList = estimatedDeliveryDates.getListOfEstimatedDeliveryItems().size();
        System.out.println(itemsList+" "+expectedItemsList);
        Assert.assertEquals(itemsList,expectedItemsList);
    }


    @Test(groups = {"Address.verifyDeliveryTimeMessageText",
            CoreConstants.GROUP_REGRESSION,
            CoreConstants.GROUP_SANITY},dependsOnGroups = "Address.deleteProductWithCODDisabled")
    public void verifyDeliveryTimeMessageText(){
        int itemsList = estimatedDeliveryDates.getListOfEstimatedDeliveryItems().size();
        Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
        System.out.println(itemsList+" "+productDetailsMap.size());
        for (int i = 0; i < itemsList; i++) {
            for (int j = 0; j < productDetailsMap.size(); j++) {
                if (i == 0 || i == itemsList - 1 || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                    System.out.println(estimatedDeliveryDatesItems.getListOfEstimatedDeliveryImages().get(i).getAttribute("src")+"  "+productDetailsMap.get(j).get(0));
                    if (estimatedDeliveryDatesItems.getListOfEstimatedDeliveryImages().get(i).getAttribute("src").equalsIgnoreCase(productDetailsMap.get(j).get(0))){
                        String deliveryMessage = estimatedDeliveryDatesItems.getDeliveryInWorkingDaysText(
                                estimatedDeliveryDatesItems.getListOfDeliveryInWorkingDays().get(i));
                        String expectedDeliveryMessage = productDetailsMap.get(j).get(10);
                        softAssert.assertEquals(deliveryMessage,expectedDeliveryMessage);
                        System.out.println(deliveryMessage+" "+expectedDeliveryMessage);
                    }
                }
            }
        }
        softAssert.assertAll();
        System.out.println("Message Data is working properly");
    }


    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION})
    public void verifySearchAddress(){

    }


    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION})
    public void verifyTextsInAddress(){
        //verifying the texts present in myCart
    }


    @AfterClass(alwaysRun = true)
    public void addressAfterClass(){
        System.out.println("Address after class is called");
        checkoutAddressPageObjects.clickOnProceedToPaymentBottomButton();
    }

}
