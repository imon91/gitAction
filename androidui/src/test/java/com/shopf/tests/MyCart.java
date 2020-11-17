package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import services.commerceMethods.GetMyBagApiResponse;
import utils.*;
import java.util.*;

public class MyCart extends AndroidBaseClass {



    private AndroidDriver<WebElement> androidDriver;
    private MyBagPageObjects myBagPageObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private MyBagPageObjects.ItemContainer itemContainer;
    private MyBagPageObjects.CreditsAndCoupons creditsAndCoupons;
    private ActionBarObjects actionBarObjects;
    private LoginPageObjects loginPageObjects;
    private MyActions myActions;
    private SoftAssert softAssert;
    private String suiteName;
    private ServiceRequestLayer serviceRequestLayer;
    private GetMyBagApiResponse getMyBagApiResponse;
    private String app;


    @BeforeClass(alwaysRun = true)
    public void myCartBeforeClass(){
        System.out.println("MyCartBeforeClass is called");
        androidDriver = getBaseDriver();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
        softAssert = new SoftAssert();
        myBagPageObjects = new MyBagPageObjects(androidDriver);
        itemContainer = myBagPageObjects.new ItemContainer(androidDriver);
        creditsAndCoupons = myBagPageObjects.new CreditsAndCoupons(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        loginPageObjects = new LoginPageObjects(androidDriver);
        myActions = new MyActions();
        serviceRequestLayer = new ServiceRequestLayer();
        getMyBagApiResponse = serviceRequestLayer.getMyBagControl();
        myBagPageObjects.createRandomItemInMyBag();
        suiteName = "regression";

        //Change Language
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        switchFromWebToNative();
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(3000);
        loginPageObjects.closePopup();

        actionBarObjects.clickOnBagImageButton();
        sleep(5000);
        //androidScriptRouter.getTheControlHere(AndroidAppConstants.WEB_VIEW_CART_ACTIVITY,AndroidAppConstants.URL_MY_BAG);
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            switchFromNativeToWeb(CoreConstants.SHOP_UP_MOKAM_WEB_VIEW);
            //itemContainer.cancelInfoPopup();
        }
        sleep(3000);
        System.setProperty("order_id",getMyBagApiResponse.getOrderIDfromMyCart());
    }


    @Test(groups = {"Address.verifyMyCartPageURL",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},dependsOnGroups = "Authentication.verifyAuthenticationWithValidCredentials")
    public void verifyMyCartPageURL(){
        String currentPage = androidDriver.getCurrentUrl();
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            Assert.assertTrue(currentPage.equalsIgnoreCase(AndroidAppConstants.URL_MY_BAG));
        }
        System.out.println("MyBag page loaded successfully");
    }


    @Test
    public void verifyThatDuplicateVariantAreNotDisplayed(){

    }


    @Test(groups = {"MyCart.verifyItemCountOnMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true,dependsOnMethods = "Address.verifyMyCartPageURL")
    public void verifyItemCountOnMyBag(){
        sleep(5000);
        System.out.println(androidDriver.getCurrentUrl());
        Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
        int containersSize = itemContainer.getItemContainersSize();
        System.out.println(productDetailsMap.size()+" "+containersSize);
        Assert.assertEquals(containersSize, productDetailsMap.size());
    }


    @Test(groups = {"MyCart.verifyProductData",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true,dependsOnMethods = "MyCart.verifyItemCountOnMyBag")
    public void verifyProductData() {
        Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
        int containersSize = itemContainer.getItemContainersSize();

        for (int a = 0; a < productDetailsMap.size(); a++) {
            System.out.println(productDetailsMap.get(a));
        }

        for (int i = 0; i < containersSize; i++) {
            System.out.println(itemContainer.getImageLink(i));
            System.out.println(itemContainer.getProductName(i));
            System.out.println(itemContainer.getProductVariantPrice(i));
            if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
                System.out.println(itemContainer.getEarningsPerItemAmountText(i));
            }
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
                        //softAssert.assertEquals(productImage, expectedProductImage);
                        System.out.println(productImage + " " + expectedProductImage);

                        String productName = itemContainer.getProductName(i); //FrontEnd ProductName
                        String expectedProductName = productDetailsMap.get(j).get(1); //Backend ProductName
                        softAssert.assertEquals(productName, expectedProductName);
                        System.out.println(productName + " " + expectedProductName);

                        String productVariantPrice = itemContainer.getProductVariantPrice(i); //FrontEnd VariantPrice
                        String expectedProductVariantPrice = productDetailsMap.get(j).get(2); //BackEnd VariantPrice
                        softAssert.assertEquals(productVariantPrice, expectedProductVariantPrice);
                        System.out.println(productVariantPrice + " " + expectedProductVariantPrice);

                        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
                            String earnings = itemContainer.getEarningsPerItemAmountText(i); //FrontEnd EarningsPerItem
                            String expectedEarnings = productDetailsMap.get(j).get(3); //BackEnd EarningsPerItem
                            softAssert.assertEquals(earnings, expectedEarnings);
                            System.out.println(earnings + " " + expectedEarnings);
                        }

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


    @Test(groups = {"MyCart.verifyQuantityDataAfterIncrementFunctionalityOnMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnMethods = "MyCart.verifyProductData")
    public void verifyQuantityDataAfterIncrementFunctionalityOnMyBag() {
        int containersSize = itemContainer.getItemContainersSize();
        for (int i = 0; i < containersSize ; i++) {
            if (suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION) || i == 0 || i == containersSize - 1) {
                itemContainer.clickOnAddQuantityButton(itemContainer.getListOfAddQuantityButton().get(i));
                sleep(5000);

                String quantity = itemContainer.getQuantity(i); //FrontEnd Quantity
                Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
                for (int j = 0; j < productDetailsMap.size(); j++) {
                    if (itemContainer.getProductName(i).equalsIgnoreCase(productDetailsMap.get(j).get(1)) &&
                            itemContainer.getSize(i).equalsIgnoreCase(productDetailsMap.get(j).get(9))) {
                        String expectedQuantity = productDetailsMap.get(j).get(8); //BackEnd Quantity
                        softAssert.assertEquals(quantity, expectedQuantity);
                        System.out.println(quantity + " " + expectedQuantity);
                    }
                }
            }
        }
        softAssert.assertAll();
        System.out.println("Quantity got updated properly");
    }


    @Test(groups = {"MyCart.verifyQuantityDataAfterDecrementFunctionalityOnMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnMethods = "MyCart.verifyQuantityDataAfterIncrementFunctionalityOnMyBag")
    public void verifyQuantityDataAfterDecrementFunctionalityOnMyBag() {
        int containersSize = itemContainer.getItemContainersSize();
        for (int i = 0; i < containersSize ; i++) {
            if (suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION) || i == 0 || i == containersSize - 1) {
                itemContainer.clickOnSubQuantityButton(itemContainer.getListOfSubQuantityButton().get(i));
                sleep(5000);

                String quantity = itemContainer.getQuantity(i); //FrontEnd Quantity
                Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
                for (int j = 0; j < productDetailsMap.size(); j++) {
                    if (itemContainer.getProductName(i).equalsIgnoreCase(productDetailsMap.get(j).get(1)) &&
                            itemContainer.getSize(i).equalsIgnoreCase(productDetailsMap.get(j).get(9))) {
                        String expectedQuantity = productDetailsMap.get(j).get(8); //BackEnd Quantity
                        softAssert.assertEquals(quantity, expectedQuantity);
                        System.out.println(quantity + " " + expectedQuantity);
                    }
                }
            }
        }
        softAssert.assertAll();
        System.out.println("Quantity got updated properly");
    }


    @Test(groups = {"MyCart.verifySizeDataInMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true, dependsOnMethods = "MyCart.verifyQuantityDataAfterDecrementFunctionalityOnMyBag")
    public void verifySizeDataInMyBag() {
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

                String size = itemContainer.getSize(i); //FrontEnd Size
                Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
                for (int j = 0; j < productDetailsMap.size(); j++) {
                    if (itemContainer.getProductName(i).equalsIgnoreCase(productDetailsMap.get(j).get(1)) &&
                            itemContainer.getSize(i).equalsIgnoreCase(productDetailsMap.get(j).get(9))) {
                        String expectedSize = productDetailsMap.get(j).get(9); //BackEnd Size
                        softAssert.assertEquals(size, expectedSize);
                        System.out.println(size + " " + expectedSize);
                    }
                }
            }
        }
        softAssert.assertAll();
        System.out.println("Size Data is updated properly");
    }


    @Test(groups = {"MyCart.verifyDeleteItemFromMyBag",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "Verify Delete Item From MyBag",
            dependsOnMethods = "MyCart.verifySizeDataInMyBag")
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
            itemCounterSize--;
        } else {
            // Function call to create an item : Handle this at Before Class Only
        }

        Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
        System.out.println(productDetailsMap.size()+" "+itemCounterSize);
        Assert.assertEquals(itemCounterSize, productDetailsMap.size());
    }


    @Test(groups = {"MyCart.verifySalePriceData",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "verify Sale Price",
            dependsOnMethods = "MyCart.verifyDeleteItemFromMyBag")
    public void verifySalePriceData() {
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            int containersSize = itemContainer.getItemContainersSize();
            Map<Integer, List<String>> productDetailsMap = myBagPageObjects.getContainerData();
            for (int i = 0; i < containersSize; i++) {
                for (int j = 0; j < productDetailsMap.size(); j++) {
                    if (i == 0 || i == containersSize - 1 || suiteName.equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {
                        if (itemContainer.getProductName(i).equalsIgnoreCase(productDetailsMap.get(j).get(1)) &&
                                itemContainer.getSize(i).equalsIgnoreCase(productDetailsMap.get(j).get(9))) {
                            int price, min = Integer.parseInt(productDetailsMap.get(j).get(6)), max = Integer.parseInt(productDetailsMap.get(j).get(7));
                            System.out.println(min + " " + max);

                            if (min==max){
                                price = itemContainer.enterSalePriceOnContainer(i,min);
                            } else {
                                price = itemContainer.givingRandomSalePrice(i, min, max);
                            }
                            sleep(4000);
                            Map<Integer, List<String>> productDetailsMap_new = myBagPageObjects.getContainerData();
                            for (int k = 0; k < productDetailsMap.size(); k++) {
                                if (itemContainer.getProductName(i).equalsIgnoreCase(productDetailsMap_new.get(k).get(1)) &&
                                        itemContainer.getSize(i).equalsIgnoreCase(productDetailsMap_new.get(k).get(9))) {
                                    int expectedPrice = (int) Float.parseFloat(productDetailsMap_new.get(k).get(5));
                                    System.out.println(price + " " + expectedPrice);
                                    softAssert.assertEquals(price, expectedPrice);
                                }
                            }
                        }
                    }
                }
            }
            softAssert.assertAll();
            System.out.println("SalePriceData is updated properly");
        }
    }


    @Test(groups = {"MyCart.verifyApplyingShippingChargesData",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true,
            description = "Verify Applying Shipping Charges From MyBag",
            dependsOnMethods = "MyCart.verifySalePriceData")
    public void verifyApplyingShippingChargesData() {
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            sleep(5000);
            int shippingCharges = 100;
            creditsAndCoupons.applyShippingCharges("" + shippingCharges);
            sleep(5000);

            List<Integer> chargesList = myBagPageObjects.getChargeandTotalValue();
            int expectedDeliveryCharges = chargesList.get(4);
            System.out.println(shippingCharges + "" + expectedDeliveryCharges);
            Assert.assertEquals(shippingCharges, expectedDeliveryCharges);
        }
    }


    @Test(groups = {"MyCart.verifyTotalEarningsandOrderValueData",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION}, enabled = true,dependsOnMethods = "MyCart.verifyApplyingShippingChargesData")
    public void verifyTotalEarningsAndOrderValueData() {
        List<Integer> chargesList = myBagPageObjects.getChargeandTotalValue();

        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            int totalEarnings = Integer.parseInt(creditsAndCoupons.getYourTotalEarningsAmount().replaceAll(",", ""));
            int expectedTotalEarnings = chargesList.get(1);
            softAssert.assertEquals(totalEarnings, expectedTotalEarnings);
            System.out.println("Total Earnings is working properly");
        }

        int orderValue = Integer.parseInt(creditsAndCoupons.getCartTotalValue().replaceAll(",", ""));
        int expectedOrderValue = chargesList.get(0);
        softAssert.assertEquals(orderValue, expectedOrderValue);
        System.out.println("Total order value is working properly");

        softAssert.assertAll();
    }



    @Test(groups = {"MyCart.verifyContinueShopping",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},dependsOnMethods = "MyCart.verifyTotalEarningsAndOrderValueData")
    public void verifyContinueShopping(){
//        myBagPageObjects.clickOnContinueShoppingButton();
//        String activity = androidDriver.currentActivity();
//        Assert.assertTrue(activity.equalsIgnoreCase(AndroidAppConstants.HOME_ACTIVITY));
//        System.out.println("Continue Shopping Button is working properly");
//        switchFromWebToNative();
//        actionBarObjects.clickOnBagImageButton();
//        sleep(5000);
    }


    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},enabled = false)
    public void verifyTextsInMyCart(){
        //verifying the texts present in myCart
    }


    @AfterClass(alwaysRun = true)
    public void myBagAfterClass(){
        System.out.println("MyBagAfterClass is called");
        sleep(5000);
        //switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        sleep(3000);
        String windowHandle = androidDriver.getWindowHandle();
        androidDriver.switchTo().window(windowHandle);
        myBagPageObjects.clickOnPlaceOrderButton();
        sleep(3000);
        String currentPage = androidDriver.getCurrentUrl();
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)) {
            Assert.assertTrue(currentPage.equalsIgnoreCase(AndroidAppConstants.URL_CHECKOUT_ADDRESS));
        }
        System.out.println("Control navigates to Address page");
    }


}
