package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import testData.*;
import utils.*;
import java.util.*;

public class Address extends AndroidBaseClass {



    private AndroidDriver<WebElement> androidDriver;
    private MyBagPageObjects myBagPageObjects;
    private CheckoutAddressPageObjects checkoutAddressPageObjects;
    private CheckoutAddressPageObjects.SelectAddress selectAddress;
    private CheckoutAddressPageObjects.SelectAddress.AddressField addressField;
    private CheckoutAddressPageObjects.EstimatedDeliveryDates estimatedDeliveryDates;
    private CheckoutAddressPageObjects.EstimatedDeliveryDates.EstimatedDeliveryDatesItems estimatedDeliveryDatesItems;
    private AddNewAddressPageObjects addNewAddressPageObjects;
    private MyActions myActions;
    private SoftAssert softAssert;
    private String suiteName;
    private String app;
    private HomePageObjects homePageObjects;
    private Random random;
    private ReadJSONFile readJSONFile;
    private ServiceRequestLayer serviceRequestLayer;


    @BeforeClass(alwaysRun = true)
    @Parameters("suite")
    public void addressBeforeClass(){
        System.out.println("AddressBeforeClass is called");
        androidDriver = getBaseDriver();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
        myBagPageObjects = new MyBagPageObjects(androidDriver);
        checkoutAddressPageObjects = new CheckoutAddressPageObjects(androidDriver);
        selectAddress = checkoutAddressPageObjects.new SelectAddress(androidDriver);
        addressField = selectAddress.new AddressField(androidDriver);
        estimatedDeliveryDates = checkoutAddressPageObjects.new EstimatedDeliveryDates(androidDriver);
        estimatedDeliveryDatesItems = estimatedDeliveryDates.new EstimatedDeliveryDatesItems(androidDriver);
        addNewAddressPageObjects = new AddNewAddressPageObjects(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
        random = new Random();
        serviceRequestLayer = new ServiceRequestLayer();
        readJSONFile = serviceRequestLayer.getControlOverReadJSONFile();
        homePageObjects = new HomePageObjects(androidDriver);
        myActions = new MyActions();
        softAssert = new SoftAssert();
        suiteName = "regression";
        sleep(5000);
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            switchFromNativeToWeb(CoreConstants.SHOP_UP_MOKAM_WEB_VIEW);
        }
        sleep(3000);
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
            CoreConstants.GROUP_REGRESSION},dependsOnMethods = "Address.cartValueData")
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
            CoreConstants.GROUP_REGRESSION}, enabled = true,dependsOnMethods = "Address.verifyShowMoreAddressesButton")
    public void verifyListOfAddresses(){
        //selectAddress.clickOnShowMoreAddress();
        int addressListSize = selectAddress.getListOfVisibleAddress().size();
        System.out.println("Address List is : " + addressListSize);
        int expectedAddressListSize = checkoutAddressPageObjects.getAddressListSizeData();
        Assert.assertEquals(addressListSize, expectedAddressListSize);
    }


    @Test(groups = {"Address.verifyEditAddress",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = false, dependsOnMethods = "Address.verifyListOfAddresses")
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
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnMethods = "Address.verifyListOfAddresses")
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

        selectAddress.selectAnAddress(selectAddress.getListOfVisibleAddress().get(0));
    }


    @Test(groups = {"Address.verifyDeleteProductInAddressPage",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "verify Delete Product",
            dependsOnMethods = "Address.deleteProductWithCODDisabled")
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
            dependsOnMethods = "Address.verifyDeleteAddress")
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
            CoreConstants.GROUP_SANITY},dependsOnMethods = "deleteProductWithCODDisabled")
    public void verifyDeliveryTimeMessageText(){
//        int itemsList = estimatedDeliveryDates.getListOfEstimatedDeliveryItems().size();
//        Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
//        System.out.println(itemsList+" "+productDetailsMap.size());
//        for (int i = 0; i < itemsList; i++) {
//            for (int j = 0; j < productDetailsMap.size(); j++) {
//                if (i == 0 || i == itemsList - 1 || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
//                    System.out.println(estimatedDeliveryDatesItems.getListOfEstimatedDeliveryImages().get(i).getAttribute("src")+"  "+productDetailsMap.get(j).get(0));
//                    if (estimatedDeliveryDatesItems.getListOfEstimatedDeliveryImages().get(i).getAttribute("src").equalsIgnoreCase(productDetailsMap.get(j).get(0))){
//                        String deliveryMessage = estimatedDeliveryDatesItems.getDeliveryInWorkingDaysText(
//                                estimatedDeliveryDatesItems.getListOfDeliveryInWorkingDays().get(i));
//                        String expectedDeliveryMessage = productDetailsMap.get(j).get(10);
//                        softAssert.assertEquals(deliveryMessage,expectedDeliveryMessage);
//                        System.out.println(deliveryMessage+" "+expectedDeliveryMessage);
//                    }
//                }
//            }
//        }
//        softAssert.assertAll();
//        System.out.println("Message Data is working properly");
    }


    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},enabled = false)
    public void verifySearchAddress(){

    }


    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},enabled = false)
    public void verifyTextsInAddress(){
        //verifying the texts present in myCart
    }

    @Test(groups = {"Address.createAddressUsingGeoLocation",
            CoreConstants.GROUP_SANITY})
    public void createAddressUsingGeoLocation() throws Exception {
        WebElement addNewAddressButton = homePageObjects.scrollOnAddressList("Add New Address");
        myActions.action_click(addNewAddressButton);
        sleep(1000);
        homePageObjects.clickAllowButton();
        sleep(1000);
        try {
            homePageObjects.clickOnOkButton();
        } catch (Exception e) {
            sleep(500);
        }
        int randomIndex = random.nextInt(readJSONFile.getLocationData(app, "locationTerm").size());
        String locationName = (String) readJSONFile.getJSONFileData(app, "locationTerm").get(randomIndex);
        homePageObjects.enterLocation(locationName);
        sleep(2000);
        homePageObjects.clickOnLocationNextButton();
        homePageObjects.enterShopName(locationName);
        homePageObjects.enterArea(locationName);
        sleep(2000);
        homePageObjects.clickOnMobileNumber();
        homePageObjects.clickOnAddAddressButton();
        WebElement addressName = homePageObjects.scrollOnAddressList("Smoke Flow shop " + locationName);
        myActions.action_click(addressName);
        sleep(3500);
    }


    @AfterClass(alwaysRun = true)
    public void addressAfterClass(){
        System.out.println("Address after class is called");
        checkoutAddressPageObjects.clickOnProceedToPaymentBottomButton();
        sleep(5000);
        String windowHandle = androidDriver.getWindowHandle();
        androidDriver.switchTo().window(windowHandle);
//        String currentPage = androidDriver.getCurrentUrl();
//        Assert.assertTrue(currentPage.equalsIgnoreCase(AndroidAppConstants.URL_CHECKOUT_PAYMENT));
        System.out.println("Control navigates to payments page");
    }

}
