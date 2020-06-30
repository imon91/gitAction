package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.util.Random;


public class MyBag extends AndroidBaseClass {


    private AndroidDriver<AndroidElement> androidDriver;
    private  MyBagPageObjects myBagPageObjects;
    private MyBagPageObjects.ItemContainer itemContainer;
    private ActionBarObjects actionBarObjects;
    private MyBagPageObjects.CreditsAndCoupons creditsAndCoupons;
    private CheckoutAddressPageObjects checkoutAddressPageObjects;
    private CheckoutAddressPageObjects.SelectAddress selectAddress;
    private PaymentModePageObjects paymentModePageObjects;





    @BeforeClass(alwaysRun = true)
    public void myBagBeforeClass() throws Exception{
        System.out.println("MyBagBeforeClass is called");
        androidDriver = getBaseDriver();
        setImplicitWait(30);
        myBagPageObjects = new MyBagPageObjects(androidDriver);
        itemContainer = myBagPageObjects.new ItemContainer(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        creditsAndCoupons = myBagPageObjects.new CreditsAndCoupons(androidDriver);
        checkoutAddressPageObjects = new CheckoutAddressPageObjects(androidDriver);
        selectAddress = checkoutAddressPageObjects.new SelectAddress(androidDriver);
        paymentModePageObjects = new PaymentModePageObjects(androidDriver);
        // This Block is responsible to get the control from anywhere to MyBag
        //actionBarObjects.clickOnBagImageButton();
        switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        setImplicitWait(30);
        sleep(5000);
    }



    @Test(  groups = {"MyBag.verifyItemIncrementFunctionalityOnMyBag",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "Verify ItemIncrement Functionality On MyBag",
            dependsOnGroups = "PDP.verifyPlaceOrderThroughPDP"  )
    public void verifyItemIncrementFunctionalityOnMyBag(){
        int containersSize = itemContainer.getListOfItemContainers();
        System.out.println("List Of Item Containers is : "+containersSize);
        if(containersSize>0){
            Random random = new Random();
            int count = random.nextInt(containersSize)+1;
            System.out.println("Count is : "+count);
            System.out.println("Container Selected is : "+count);
            System.out.println("List Of Add Qt Button is : "+
                    itemContainer.getListOfAddQuantityButton().size());
            itemContainer.clickOnAddQuantityButton(itemContainer.getListOfAddQuantityButton().get(count-1));
        }else {
            // Function call to create an item : Handle this at Before Class Only
        }

    }


    @Test(  groups = {"MyBag.verifyDeleteItemFromMyBag",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            enabled = true,
            description = "Verify Delete Item From MyBag",
            dependsOnMethods = "verifyItemIncrementFunctionalityOnMyBag"  )
    public void verifyDeleteItemFromMyBag(){
        sleep(5000);
        int itemCounterSize = itemContainer.getListOfItemContainers();
        System.out.println("itemContainer Size is : "+itemCounterSize);
        if(itemCounterSize>1){
            Random random = new Random();
            int count = random.nextInt(itemCounterSize);
            System.out.println("Container Selected is : "+count);
            System.out.println("List Of Cancel Icons Before Cancel: "+
                    itemContainer.getListOfCancelIcons().size());
            itemContainer.clickOnCancelItem(itemContainer.getListOfCancelIcons().get(count));
        }else {
            // Function call to create an item : Handle this at Before Class Only
        }
    }


    @Test(  groups = {"MyBag.verifyApplyingShippingCharges",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify Applying Shipping Charges From MyBag",
            dependsOnMethods = "verifyDeleteItemFromMyBag"  )
    public void verifyApplyingShippingCharges() {
        sleep(5000);
        String shippingCharges = "70";
        int minShippingCharge = 49;
        creditsAndCoupons.applyShippingCharges(shippingCharges);
//        int ItemTotal = Integer.parseInt(creditsAndCoupons.getItemTotalAmountText());
//        int cartValueCountBeforeShippingCharges = Integer.parseInt(creditsAndCoupons.getCartValueCount());
//        //String totalEarningsBeforeShippingCharges = creditsAndCoupons.getYourTotalEarningsAmount();
//        if (ItemTotal == (cartValueCountBeforeShippingCharges - minShippingCharge)) {
//            // Shipping charges is applied minimum
//            creditsAndCoupons.applyShippingCharges(shippingCharges);
//            sleep(5000);
//            Assert.assertTrue((Integer.parseInt(creditsAndCoupons.getCartValueCount()) ==
//                    (cartValueCountBeforeShippingCharges +
//                            (Integer.parseInt(shippingCharges) - minShippingCharge))));
//        } else {
//            // Shipping charges is already applied more than minimum
//            creditsAndCoupons.applyShippingCharges(shippingCharges);
//            int intShippingCharges = Integer.parseInt(shippingCharges);
//            sleep(5000);
//            int initialShippingCharges = cartValueCountBeforeShippingCharges - ItemTotal;
//            if (intShippingCharges > initialShippingCharges) {
//                int newShippingCharge = intShippingCharges - initialShippingCharges;
//                Assert.assertTrue((Integer.parseInt(creditsAndCoupons.getCartValueCount()) ==
//                        (cartValueCountBeforeShippingCharges + newShippingCharge)));
//            } else {
//                // if the intShippingCharges is less than initialShippingCharges
//                int newShippingCharge = initialShippingCharges - intShippingCharges;
//                System.out.println("New Shipping Charges is : "+newShippingCharge);
//                System.out.println("New Cart Value : "+(Integer.parseInt(creditsAndCoupons.getCartValueCount())));
//                System.out.println("cartValueCountBeforeShippingCharges : "+cartValueCountBeforeShippingCharges);
//                Assert.assertTrue((Integer.parseInt(creditsAndCoupons.getCartValueCount()) ==
//                        (cartValueCountBeforeShippingCharges - newShippingCharge)));
//            }
////        Assert.assertEquals(Integer.parseInt(creditsAndCoupons.getYourTotalEarningsAmount())
////                ,((Integer.parseInt(totalEarningsBeforeShippingCharges)+
////                        (Integer.parseInt(shippingCharges)))));
            sleep(5000);
    }



    @Test(  groups = {"MyBag.verifyPlaceOrderInMyBag",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify Place Order From MyBag",
            dependsOnMethods = "verifyApplyingShippingCharges"  )
    public void verifyPlaceOrderInMyBag(){
        myBagPageObjects.clickOnPlaceOrderButton();
    }


    @Test(  groups = {"MyBag.verifySelectAddressInMyBag",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify Select Address From MyBag",
            dependsOnMethods = "verifyPlaceOrderInMyBag"  )
    public void verifySelectAddressInMyBag(){
        System.out.println("Address List is : "+selectAddress.getListOfVisibleAddress().size());
        if(selectAddress.getListOfVisibleAddress().size()>1){
            selectAddress.clickOnShowMoreAddress();
            selectAddress.selectAnAddress(selectAddress.getListOfVisibleAddress().get(1));
        }else {
            selectAddress.selectAnAddress(selectAddress.getListOfVisibleAddress().get(0));
        }

    }


    @Test(  groups = {"MyBag.verifyCheckoutProceedInMyBag",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify Checkout Proceed From MyBag",
            dependsOnMethods = "verifySelectAddressInMyBag"  )
    public void verifyCheckoutProceedInMyBag(){
        sleep(5000);
        checkoutAddressPageObjects.clickOnProceedToPaymentBottomButton();
    }


    @Test(  groups = {"MyBag.verifyProceedPaymentWithoutChangeAddress",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify Proceed Payment Without Change Address",
            dependsOnMethods = "verifyCheckoutProceedInMyBag"  )
    public void verifyProceedPaymentWithoutChangeAddress(){
        paymentModePageObjects.proceedPaymentWithoutChangeAddressThroughTopButton();
        sleep(3000);
    }



    @AfterClass(alwaysRun = true,groups = {"MyBag.AfterClass"})
    public void myBagAfterClass(){
        System.out.println("MyBagAfterClass is called");
    }
}
