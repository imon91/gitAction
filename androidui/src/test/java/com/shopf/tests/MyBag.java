package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.commerceMethods.*;
import utils.*;
import java.util.*;


public class MyBag extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private MyBagPageObjects myBagPageObjects;
    private MyBagPageObjects.ItemContainer itemContainer;
    private ActionBarObjects actionBarObjects;
    private MyBagPageObjects.CreditsAndCoupons creditsAndCoupons;
    private CheckoutAddressPageObjects checkoutAddressPageObjects;
    private CheckoutAddressPageObjects.SelectAddress selectAddress;
    private CheckoutAddressPageObjects.SelectAddress.AddressField addressField;
    private PaymentModePageObjects paymentModePageObjects;
    private PaymentModePageObjects.ProductDetails productDetails;
    private CheckoutAddressPageObjects.EstimatedDeliveryDates estimatedDeliveryDates;
    private CheckoutAddressPageObjects.EstimatedDeliveryDates.EstimatedDeliveryDatesItems estimatedDeliveryDatesItems;
    private AddNewAddressPageObjects addNewAddressPageObjects;
    private GetCommerceApiResponse getCommerceApiResponse;
    private AndroidScriptRouter androidScriptRouter;
    private TouchAction touch;
    private MyActions myActions;
    private OrderSuccessFulPageObjects orderSuccessFulPageObjects;
    private GetMyBagApiResponse getMyBagApiResponse;
    private String suiteName;
    private SoftAssert softAssert;
    private String app;


    @BeforeClass(alwaysRun = true)
    public void myBagBeforeClass() throws Exception {
        System.out.println("MyBagBeforeClass is called");
        androidDriver = getBaseDriver();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
        softAssert = new SoftAssert();
        actionBarObjects = new ActionBarObjects(androidDriver);
        //actionBarObjects.clickOnBagImageButton();
        myBagPageObjects = new MyBagPageObjects(androidDriver);
        //itemContainer = myBagPageObjects.new ItemContainer(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        itemContainer = myBagPageObjects.new ItemContainer(androidDriver);
        creditsAndCoupons = myBagPageObjects.new CreditsAndCoupons(androidDriver);
        checkoutAddressPageObjects = new CheckoutAddressPageObjects(androidDriver);
        selectAddress = checkoutAddressPageObjects.new SelectAddress(androidDriver);
        addressField = selectAddress.new AddressField(androidDriver);
        paymentModePageObjects = new PaymentModePageObjects(androidDriver);
        productDetails = paymentModePageObjects.new ProductDetails(androidDriver);
        estimatedDeliveryDates = checkoutAddressPageObjects.new EstimatedDeliveryDates(androidDriver);
        estimatedDeliveryDatesItems = estimatedDeliveryDates.new EstimatedDeliveryDatesItems(androidDriver);
        addNewAddressPageObjects = new AddNewAddressPageObjects(androidDriver);
        getCommerceApiResponse = new GetCommerceApiResponse(CoreConstants.MODULE_ANDROID_UI);
        myActions = new MyActions();
        androidScriptRouter = new AndroidScriptRouter();
        suiteName = "sanity";
        //myBagPageObjects.createItemInMyBag(82513);
        // This Block is responsible to get the control from anywhere to MyBag
        //actionBarObjects.clickOnBagImageButton();
        sleep(5000);
        orderSuccessFulPageObjects = new OrderSuccessFulPageObjects(androidDriver);
        app = System.getProperty(BuildParameterKeys.KEY_APP);
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            switchFromNativeToWeb(CoreConstants.SHOP_UP_MOKAM_WEB_VIEW);
        }
        // This Block is responsible to get the control from anywhere to MyBag
        //androidScriptRouter.getTheControlHere(AndroidAppConstants.WEB_VIEW_CART_ACTIVITY,AndroidAppConstants.URL_MY_BAG);
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            switchFromNativeToWeb(CoreConstants.SHOP_UP_MOKAM_WEB_VIEW);
            //itemContainer.cancelInfoPopup();
        }
        sleep(5000);
    }


    @Test(groups = {"MyBag.verifyItemIncrementFunctionalityOnMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            enabled = false,
            description = "Verify ItemIncrement Functionality On MyBag",
            dependsOnGroups = "Authentication.verifyEditMobileNumber")
    public void verifyItemIncrementFunctionalityOnMyBag() {
        int containersSize = itemContainer.getItemContainersSize();
        System.out.println("List Of Item Containers is : " + containersSize);
        if (containersSize > 0) {
            Random random = new Random();
            int count = random.nextInt(containersSize) + 1;
            System.out.println("Count is : " + count);
            System.out.println("Container Selected is : " + count);
            System.out.println("List Of Add Qt Button is : " +
                    itemContainer.getListOfAddQuantityButton().size());
            itemContainer.clickOnAddQuantityButton(itemContainer.getListOfAddQuantityButton().get(count - 1));
        } else {
            // Function call to create an item : Handle this at Before Class Only
        }

    }


    @Test(groups = {"MyBag.verifyProductData",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true)
    public void verifyProductData() {
        Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
        int containersSize = itemContainer.getItemContainersSize();
        System.out.println(productDetailsMap.size()+" "+containersSize);
        Assert.assertEquals(containersSize, productDetailsMap.size());

        for (int a = 0; a < productDetailsMap.size(); a++) {
            System.out.println(productDetailsMap.get(a));
        }

        for (int i = 0; i < containersSize; i++) {
            System.out.println(itemContainer.getImageLink(i));
            System.out.println(itemContainer.getProductName(i));
            System.out.println(itemContainer.getProductVariantPrice(i));
            System.out.println(itemContainer.getEarningsPerItemAmountText(i));
            System.out.println(itemContainer.getOrderValuePerItemAmountText(i));
            System.out.println(itemContainer.getQuantity(i));
            System.out.println(itemContainer.getSize(i));
        }

        for (int i = 0; i < containersSize; i++) {
            for (int j = 0; j < productDetailsMap.size(); j++) {
                if (i == 0 || i == containersSize - 1 || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                    if (itemContainer.getProductName(i).equalsIgnoreCase(productDetailsMap.get(j).get(1)) &&
                            itemContainer.getSize(i).equalsIgnoreCase(productDetailsMap.get(j).get(9))) {
                        String productImage = itemContainer.getImageLink(i); //FrontEnd Image Link
                        String expectedProductImage = productDetailsMap.get(j).get(0); //BackEnd Image Link
                        softAssert.assertEquals(productImage, expectedProductImage);
                        System.out.println(productImage + " " + expectedProductImage);

                        String productName = itemContainer.getProductName(i); //FrontEnd ProductName
                        String expectedProductName = productDetailsMap.get(j).get(1); //Backend ProductName
                        softAssert.assertEquals(productName, expectedProductName);
                        System.out.println(productName + " " + expectedProductName);

                        String productVariantPrice = itemContainer.getProductVariantPrice(i); //FrontEnd VariantPrice
                        String expectedProductVariantPrice = productDetailsMap.get(j).get(2); //BackEnd VariantPrice
                        softAssert.assertEquals(productVariantPrice, expectedProductVariantPrice);
                        System.out.println(productVariantPrice + " " + expectedProductVariantPrice);

                        String earnings = itemContainer.getEarningsPerItemAmountText(i); //FrontEnd EarningsPerItem
                        String expectedEarnings = productDetailsMap.get(j).get(3); //BackEnd EarningsPerItem
                        softAssert.assertEquals(earnings, expectedEarnings);
                        System.out.println(earnings + " " + expectedEarnings);

                        String orderValue = itemContainer.getOrderValuePerItemAmountText(i); //FrontEnd OrderValuePerItem
                        String expectedOrderValue = productDetailsMap.get(j).get(4); //BackEnd OrderValuePerItem
                        softAssert.assertEquals(orderValue, expectedOrderValue);
                        System.out.println(orderValue + " " + expectedOrderValue);

                        String quantity = itemContainer.getQuantity(i); //FrontEnd Quantity
                        String expectedQuantity = productDetailsMap.get(j).get(8); //BackEnd Quantity
                        softAssert.assertEquals(quantity, expectedQuantity);
                        System.out.println(quantity + " " + expectedQuantity);

                        String size = itemContainer.getSize(i); //FrontEnd Size
                        String expectedSize = productDetailsMap.get(j).get(9); //BackEnd Size
                        softAssert.assertEquals(size, expectedSize);
                        System.out.println(size + " " + expectedSize);
                    }
                }
            }
        }
        softAssert.assertAll();
        System.out.println("Product Data is working properly");
    }


    @Test(groups = {"MyBag.verifyIncrementFunctionalityOnMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnGroups = "MyBag.verifyProductData")
    public void verifyIncrementFunctionalityOnMyBag() {
        int containersSize = itemContainer.getItemContainersSize();
        for (int i = 0; i < containersSize ; i++) {
            if (suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION) || i == 0 || i == containersSize - 1) {
                itemContainer.clickOnAddQuantityButton(itemContainer.getListOfAddQuantityButton().get(i));
                sleep(5000);
            }
        }
        System.out.println("Quantity got updated properly");
    }


    @Test(groups = {"MyBag.verifyDecrementFunctionalityOnMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnGroups = "MyBag.verifyIncrementFunctionalityOnMyBag")
    public void verifyDecrementFunctionalityOnMyBag() {
        int containersSize = itemContainer.getItemContainersSize();
        for (int i = 0; i < containersSize ; i++) {
            if (suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION) || i == 0 || i == containersSize - 1) {
                itemContainer.clickOnSubQuantityButton(itemContainer.getListOfSubQuantityButton().get(i));
                sleep(5000);
            }
        }
        System.out.println("Quantity got updated properly");
    }


    @Test(groups = {"MyBag.selectSizeInMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnGroups = "MyBag.verifyDecrementFunctionalityOnMyBag")
    public void selectSizeInMyBag() {
        int containersSize = itemContainer.getItemContainersSize();
        System.out.println("List Of Item Containers is : " + containersSize);
        for (int i = 0; i < containersSize; i++) {
            if (i == 0 || i == containersSize - 1 || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                myActions.action_click(itemContainer.getDropDownOfSizes().get(i));
                System.out.println("No.Of Sizes available : " + itemContainer.getListOfSizes().size());
                Random random = new Random();
                int sizeIndex = random.nextInt(itemContainer.getListOfSizes().size());
                System.out.println("Selected size is " + itemContainer.selectedSize(sizeIndex));
                myActions.action_click(itemContainer.getListOfSizes().get(sizeIndex));
                sleep(6000);
            }
        }
    }


    @Test(groups = {"MyBag.verifyTotalEarnings",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnGroups = "MyBag.verifyMinAndMaxShippingCharges")
    public void verifyTotalEarningsandOrderValue() {
        List<Integer> chargesList = myBagPageObjects.getChargeandTotalValue();

        int totalEarnings = Integer.parseInt(creditsAndCoupons.getYourTotalEarningsAmount().replaceAll(",", ""));
        int expectedTotalEarnings = chargesList.get(1);
        softAssert.assertEquals(totalEarnings, expectedTotalEarnings);
        System.out.println("Total Earnings is working properly");

        int orderValue = Integer.parseInt(creditsAndCoupons.getCartTotalValue().replaceAll(",", ""));
        int expectedOrderValue = chargesList.get(0);
        softAssert.assertEquals(orderValue, expectedOrderValue);
        System.out.println("Total order value is working properly");

        softAssert.assertAll();
    }


    @Test(groups = {"MyBag.verifyDeleteItemFromMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "Verify Delete Item From MyBag",
            dependsOnGroups = "MyBag.selectSizeInMyBag")
    public void verifyDeleteItemFromMyBag() {
        sleep(5000);
        int itemCounterSize = itemContainer.getItemContainersSize();
        System.out.println("itemContainer Size is : " + itemCounterSize);
        if (itemCounterSize > 1) {
            Random random = new Random();
            int index = random.nextInt(itemCounterSize);
                    System.out.println("List Of Cancel Icons Before Cancel: " +
                            itemContainer.getListOfCancelIcons().size());
                    System.out.println("Product selected to delete is: "+ (index+1));
                    itemContainer.clickOnCancelItem(itemContainer.getListOfCancelIcons().get(index));
                    sleep(5000);
        } else {
            // Function call to create an item : Handle this at Before Class Only
        }
    }


    @Test(groups = {"MyBag.verifyMinAndMaxSalePrice",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "verify Min and Max Sale Price",
            dependsOnGroups = "MyBag.verifyDeleteItemFromMyBag")
    public void verifyMinAndMaxSalePrice() {
        int containersSize = itemContainer.getItemContainersSize();
        Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
        for (int i = 0; i < containersSize; i++) {
            for (int j = 0; j < productDetailsMap.size(); j++) {
                if (i == 0 || i == containersSize - 1 || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                    if (itemContainer.getProductName(i).equalsIgnoreCase(productDetailsMap.get(j).get(1)) &&
                            itemContainer.getSize(i).equalsIgnoreCase(productDetailsMap.get(j).get(9))) {
                        int min = Integer.parseInt(productDetailsMap.get(j).get(6)), max = Integer.parseInt(productDetailsMap.get(j).get(7));
                        System.out.println(min + " " + max);

                        String maxSalePriceText = itemContainer.checkingMaxPrice(i, max);
                        sleep(4000);
                        //Assert.assertTrue(maxSalePriceText.equalsIgnoreCase("Price updated to "+max));

                        if (suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                            int boundaryValue1 = min - 1;
                            String lesserSalePriceText = itemContainer.checkingLessThanMinPrice(i, boundaryValue1);
                            sleep(4000);
                            //Assert.assertTrue(lesserSalePriceText.equalsIgnoreCase("Price should be in between "+min+" and "+max));

                            int boundaryValue2 = max + 1;
                            String greaterSalePriceText = itemContainer.checkingMoreThanMaxPrice(i, boundaryValue2);
                            sleep(4000);
                            //Assert.assertTrue(greaterSalePriceText.equalsIgnoreCase("Price should be in between "+min+" and "+max));
                        }

                        String minSalePriceText = itemContainer.checkingMinPrice(i, min);
                        sleep(4000);
                        //Assert.assertTrue(minSalePriceText.equalsIgnoreCase("Price updated to "+min));
                    }
                }
            }
        }
    }


    @Test(groups = {"MyBag.couponApply",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = false)
    public void couponApply() {
        String coupon = "";
        creditsAndCoupons.enterCoupon(coupon);
    }


    @Test(groups = {"MyBag.verifyApplyingShippingCharges",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = false,
            description = "Verify Applying Shipping Charges From MyBag",
            dependsOnMethods = "verifyMinAndMaxSalePrice")
    public void verifyApplyingShippingCharges() {
        sleep(5000);
        String shippingCharges = "70";
        int minShippingCharge = 49;
        creditsAndCoupons.applyShippingCharges(shippingCharges);
        sleep(5000);
    }


    @Test(groups = {"MyBag.verifyMinAndMaxShippingCharges",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnGroups = "MyBag.verifyMinAndMaxSalePrice")
    public void verifyMinAndMaxShippingCharges() {
        List<Integer> chargesList = myBagPageObjects.getChargeandTotalValue();
        int max = chargesList.get(3), min = chargesList.get(2);
        if (suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
            creditsAndCoupons.checkingMoreThanDeliveryCharges(max);
            sleep(5000);
            //Assert.assertTrue(greaterDeliveryChargeText.equalsIgnoreCase("Delivery Charge cannot be more than "+max));

            creditsAndCoupons.checkingLessThanDeliveryCharges(min);
            sleep(5000);
            //Assert.assertTrue(lesserDeliveryChargeText.equalsIgnoreCase("Delivery Charge cannot be less than "+min));

        }
        creditsAndCoupons.checkingMaxDeliveryCharge(max);
        sleep(5000);

        creditsAndCoupons.checkingMinDeliveryCharge(min);
        sleep(5000);
    }


    @Test(groups = {"MyBag.verifyPlaceOrderInMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},enabled = true,
            description = "Verify Place Order From MyBag",
            dependsOnGroups = "MyBag.verifyTotalEarnings")
    public void verifyPlaceOrderInMyBag() {
        myBagPageObjects.clickOnPlaceOrderButton();
    }


    @Test(groups = {"MyBag.verifySelectAddressInMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "Verify Select Address From MyBag",
            dependsOnGroups = "MyBag.verifyDeleteAddress")
    public void verifySelectAddressInMyBag() {
        System.out.println("Address List is : " + selectAddress.getListOfVisibleAddress().size());
        selectAddress.selectAnAddress(selectAddress.getListOfVisibleAddress().get(0));
//        if(selectAddress.getListOfVisibleAddress().size()>1){
//            selectAddress.clickOnShowMoreAddress();
//            selectAddress.selectAnAddress(selectAddress.getListOfVisibleAddress().get(1));
//        }else {
//            selectAddress.selectAnAddress(selectAddress.getListOfVisibleAddress().get(0));
//        }

    }


    @Test(groups = {"MyBag.verifyProceedToPaymentByCreatingNewAddress",
            CoreConstants.GROUP_SANITY}, enabled = false, dependsOnGroups = "MyBag.verifyPlaceOrderInMyBag")
    public void verifyProceedToPaymentByCreatingNewAddress() {
        selectAddress.clickOnAddNewAddress();
        addNewAddressPageObjects.createNewAddress("SmokeFlow Testing", "Shopf Street", "1877655690");
        sleep(4000);
    }


    @Test(groups = {"MyBag.verifyEditAddress",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnGroups = "MyBag.verifyPlaceOrderInMyBag")
    public void verifyEditAddress() {
        selectAddress.clickOnShowMoreAddress();
        int addressListSize = selectAddress.getListOfVisibleAddress().size();
        System.out.println("Address List is : " + addressListSize);
        for (int i = 0; i < addressListSize; i++) {
            if (i == 0 || i == addressListSize - 1 ) {
                System.out.println("List of Edit Address Button is :" + addressField.getListOfEditAddressButtons().size());
                addressField.clickOnEditAddressButton(addressField.getListOfEditAddressButtons().get(i));
                sleep(5000);
                addNewAddressPageObjects.editNameInAddress("Hari");
                addNewAddressPageObjects.editAddressInAddress("TCE Street");
                addNewAddressPageObjects.clickOnCancel();
                sleep(3000);
            }
        }
    }


    @Test(groups = {"MyBag.verifyDeleteAddress",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnGroups = "MyBag.verifyEditAddress")
    public void verifyDeleteAddress() {
        int addressListSize = selectAddress.getListOfVisibleAddress().size();
        System.out.println("Address List is : " + addressListSize);
        if (addressListSize > 0) {
            Random random = new Random();
            int index = random.nextInt(addressListSize);
            System.out.println("List of Delete Address Button is :" + addressField.getListOfDeleteButtons().size());
            addressField.clickOnDeleteAddressButton(addressField.getListOfDeleteButtons().get(index));
            sleep(3000);
        }
    }


    @Test(groups = {"MyBag.verifyAddressData",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = false, dependsOnGroups = "MyBag.verifyPlaceOrderInMyBag")
    public void verifyAddressData() {
        sleep(4000);
        selectAddress.clickOnShowMoreAddress();
        int addressListSize = selectAddress.getListOfVisibleAddress().size();
        System.out.println("Address List is : " + addressListSize);
        int expectedAddressListSize = checkoutAddressPageObjects.getAddressListSizeData();
        Assert.assertEquals(addressListSize, expectedAddressListSize);
        Map<Integer, List<String>> addressDataMap = checkoutAddressPageObjects.getAddressData();
        for (int i = 0; i < addressListSize; i++) {
            if (i == 0 || i == addressListSize - 1 || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                String firstName = addressField.getFirstName(i);
                String expectedFirstName = addressDataMap.get(i).get(0);
                System.out.println(firstName + "" + expectedFirstName);
                softAssert.assertEquals(firstName, expectedFirstName);

                String address = addressField.getAddress(i);
                String expectedAddress = addressDataMap.get(i).get(1);
                System.out.println(address + "" + expectedAddress);
                softAssert.assertEquals(address, expectedAddress);

                String landmark = addressField.getLandmark(i);
                if (!landmark.equalsIgnoreCase("Landmark: N/A")) {
                    String landmarkValue = landmark.replace("Landmark: ", "");
                    String expectedLandmark = addressDataMap.get(i).get(2);
                    System.out.println(landmarkValue + "" + expectedLandmark);
                    softAssert.assertEquals(landmarkValue, expectedLandmark);
                }

                String city = addressField.getArea(i);
                String expectedCity = addressDataMap.get(i).get(3);
                System.out.println(city + "" + expectedCity);
                softAssert.assertEquals(city, expectedCity);

                String phoneNumber = addressField.getPhoneNumber(i);
                String expectedPhoneNumber = addressDataMap.get(i).get(4);
                System.out.println(phoneNumber + "" + expectedPhoneNumber);
                softAssert.assertEquals(phoneNumber, expectedPhoneNumber);
            }
            softAssert.assertAll();
        }
    }


    @Test(groups = {"MyBag.deleteProductWithCODDisabled",
            CoreConstants.GROUP_SANITY}, enabled = true,
            dependsOnGroups = "MyBag.verifyDeleteProductInAddressPage")
    public void deleteProductWithCODDisabled() {
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            estimatedDeliveryDatesItems.deleteProductWithCODDisabled();
        }
    }


    @Test(groups = {"MyBag.verifyDeleteProductInAddressPage",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "verify Delete Product",
            dependsOnGroups = "MyBag.verifySelectAddressInMyBag")
    public void verifyDeleteProductInEstimatedDeliveryPage() {
        int itemsList = estimatedDeliveryDates.getListOfEstimatedDeliveryItems().size();
        sleep(5000);
        if (itemsList > 2) {
            Random random = new Random();
            int index = random.nextInt(itemsList);
            estimatedDeliveryDatesItems.clickOnEstimatedDeliveryItem(
                    estimatedDeliveryDatesItems.
                            getListOfEstimatedDeliveryItemDelete().get(index));
            sleep(3000);
        } else {
            System.out.println("Sufficient element is not present");
        }

    }


    @Test(groups = {"MyBag.verifyCheckoutProceedInMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true,
            description = "Verify Checkout Proceed From MyBag",
            dependsOnGroups = "MyBag.deleteProductWithCODDisabled")
    public void verifyCheckoutProceedInMyBag() {
        sleep(5000);
        checkoutAddressPageObjects.clickOnProceedToPaymentTopButton();
        sleep(3000);
    }


    @Test(groups = {"MyBag.verifyPaymentBreakup",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnGroups = "MyBag.verifyCheckoutProceedInMyBag")
    public void verifyPaymentBreakup() {
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


    @Test(groups = {"MyBag.verifyProductDataInPaymentsPage",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, dependsOnGroups = "MyBag.verifyPaymentBreakup")
    public void verifyProductDataInPaymentsPage() {
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


    @Test(groups = {"MyBag.verifySelectedAddressData",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, dependsOnGroups = "MyBag.verifyProductDataInPaymentsPage")
    public void verifySelectedAddressData() {
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
        }

    else {
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


    @Test(  groups = {"MyBag.verifyProceedPaymentWithoutChangeAddress",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},enabled = true,
            description = "Verify Proceed Payment Without Change Address",
            dependsOnGroups = "MyBag.verifyCheckoutProceedInMyBag"  )
    public void verifyProceedPaymentWithoutChangeAddress(){
        sleep(3000);
        paymentModePageObjects.proceedPaymentWithoutChangeAddressThroughTopButton();
        sleep(3000);
    }



    @Test(  groups = {"MyBag.verifyProceedPaymentWithChangeAddress",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},enabled = true,
            description = "Verify Proceed Payment With Change Address",
            dependsOnGroups = "MyBag.verifySelectedAddressData"  )
    public void verifyProceedPaymentWithChangeAddress(){
        sleep(8000);
        paymentModePageObjects.clickOnChangeAddress();
        sleep(3000);
        selectAddress.clickOnShowMoreAddress();
        selectAddress.selectAnAddress(selectAddress.getListOfVisibleAddress().get(4));
        sleep(3000);
        checkoutAddressPageObjects.clickOnProceedToPaymentBottomButton();
        sleep(3000);
        paymentModePageObjects.proceedPaymentWithoutChangeAddressThroughTopButton();
        sleep(3000);
    }



    @AfterClass(alwaysRun = true)
    public void myBagAfterClass(){
        System.out.println("MyBagAfterClass is called");
    }
}
