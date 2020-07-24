package com.shopf.tests;

import coreUtils.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.*;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;
import java.util.*;


public class MyOrders extends AndroidBaseClass {




    private AndroidDriver<WebElement> androidDriver;
    private MyOrdersPageObjects myOrdersPageObjects;
    private MyOrdersPageObjects.OrderDetails orderDetails;
    private BottomNavigationObjects bottomNavigationObjects;
    private MyActions myActions;
    private Random random;
    private TouchAction touchAction;
    private ActionBarObjects actionBarObjects;
    private MyOrderDetailsPageObject myOrderDetailsPageObject;



    @BeforeClass(alwaysRun = true)
    public void myOrdersBeforeClass() throws Exception{
        System.out.println("MyOrdersBeforeClass is called");
        androidDriver = getBaseDriver();
        bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
        bottomNavigationObjects.clickOnBottomBarMyOrdersIcon();
        myOrdersPageObjects = new MyOrdersPageObjects(androidDriver);
        orderDetails = myOrdersPageObjects.new OrderDetails(androidDriver);
        myActions = new MyActions();
        touchAction = new TouchAction(androidDriver);
        sleep(5000);
        myOrdersPageObjects.clickOnCompleteTabItem();
        sleep(1000);
        myOrdersPageObjects.clickOnActiveTabItem();
        myOrderDetailsPageObject = new MyOrderDetailsPageObject(androidDriver);
        // This Block is responsible to get the control from anywhere to MyOrders
        //switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
    }


    @Test(  groups = {"MyOrders.verifySelectingAnOrderFromMyOrders",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            enabled = false,
            description = "Verify Selecting An Order From MyOrders"  )
    public void verifySelectingAnOrderFromMyOrders() throws Exception{
       ArrayList<WebElement> data =  (ArrayList) orderDetails.getListOfOrderItems();
        System.out.println(data.size());
        for(int i=0;i<data.size();i++){
            System.out.println(data.get(i).getText());
        }
        int randomValue = new Random().nextInt((data.size()));
        System.out.println("Item Clicked is : "+randomValue);
        data.get(randomValue).click();
        //orderDetails.clickOnOrderItemByIndex(new Random().nextInt((data.size())+1));
//        sleep(10000);
//        List<WebElement> dataList =
//                androidDriver.findElements(By.xpath("//button"));
//        System.out.println(dataList.size());
//        dataList.get(0).click();
//        sleep(10000);
//        System.out.println("List of delete buttons are : "+dataList.size());
        switchFromWebToNative();sleep(5000);
        androidDriver.findElement(By.xpath("//android.view.View[@index='23']/android.widget.Image")).click();
        //new MyActions().clickOnHardKeyBack();
        sleep(10000);
        androidDriver.findElement(By.xpath("//android.widget.Spinner[@index='0']")).click();
//        sleep(3000);
//        androidDriver.findElement(By.xpath("//android.widget.CheckedTextView[@index='1']")).click();
        sleep(3000);
        androidDriver.findElement(By.xpath("//android.widget.Button[@text='Cancel Order']")).click();
        //switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        //androidDriver.findElement(By.xpath("//div[@class='deleteActive___SWGaJ']//*[name()='svg']")).click();
        sleep(20000);
//        ArrayList<String> dataNew = new ArrayList();
//        Set<String> setData = androidDriver.getContextHandles();
//        for (String x : setData)
//            dataNew.add(x);
//        System.out.println(dataNew);
//        System.out.println(androidDriver.getCurrentUrl());
        //System.out.println(androidDriver.findElementByXPath("//div[@class='flex___1bJDE middle___1jEMZ']/p[1]").getText());
    }


    @Test(  groups = {"MyOrders.verifyCancellingAnOrderFromMyOrders",
            CoreConstants.GROUP_SANITY},
            description = "Verify Cancelling An Order From MyOrders"  )
    public void verifyCancellingAnOrderFromMyOrders(){
        switchFromNativeToWeb(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);
        sleep(2000);
       touchAction.press(PointOption.point(10,1500)).waitAction().moveTo(PointOption.point(10,500)).release().perform();
        sleep(5500);
        WebElement loadmore = androidDriver.findElement(By.xpath("//div[@class='loadMore___2udG1']/button"));
        myActions.action_click(loadmore);
        sleep(6000);
        //clicking of order id
        orderDetails.clickOnOrderItemByIndex(4);
        sleep(10000);

        //switch to native
        switchFromWebToNative();

        //del button
        androidDriver.findElement(By.xpath("//android.view.View[@index='23']/android.widget.Image")).click();
        sleep(20000);
        //cancel reason icon
        androidDriver.findElement(By.xpath("//android.widget.Spinner[@index='0']")).click();
        sleep(10000);
        //click reasons
        androidDriver.findElement(By.xpath("//android.widget.CheckedTextView[@index='1']")).click();
        sleep(1000);
        //click cancel button
        androidDriver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
        sleep(3000);
        //go to home page
        androidDriver.navigate().back();
        actionBarObjects.clickOnShopUpAppIcon();

    }


    @Test(groups ={ "MyOrder.VerifyFilterInMyorder",
            CoreConstants.GROUP_REGRESSION},
    description = "Verifying filter In MyOrderPage",
   dependsOnGroups = "Authentication.verifyAuthenticationWithValidCredentials")
    public void verifyFilterInMyOrder()
    {
        switchFromWebToNative();
        myOrderDetailsPageObject.applyFilterFunction(5);
    }


    @Test(groups ={ "MyOrder.VerifySortInMyorder",
            CoreConstants.GROUP_REGRESSION},
            description = "Verifying sort In MyOrderPage",
            dependsOnGroups = "Authentication.verifyAuthenticationWithValidCredentials")
    public void verifySortInMyOrder()
    {
        switchFromWebToNative();
        sleep(2000);
        myOrderDetailsPageObject.clickOnSortButton();
        System.out.println("clicked sort");
        sleep(3000);
        myOrderDetailsPageObject.applySortFunctionality(1);
    }


    @Test(groups ={ "MyOrder.VerifySearchInMyorder",
            CoreConstants.GROUP_REGRESSION},
            description = "Verifying search In MyOrderPage",
            dependsOnGroups = "Authentication.verifyAuthenticationWithValidCredentials")
    public void verifySearchInMyOrder()
    {
        switchFromWebToNative();
        sleep(2000);
        myOrderDetailsPageObject.searchToOrderId("R4088980146");
        orderDetails.getListOfOrderItems();
        sleep(1000);
        myOrderDetailsPageObject.clickOnOrderById("R4088980146");
        sleep(5000);

        //get id after clicking Orderid
        String orderid = myOrderDetailsPageObject.getOrderIdAfterClickingOnOrder();
        System.out.println(orderid);

        if(orderid.equalsIgnoreCase("R4088980146"))
        {
            System.out.println("MyOrder Sort Functionality was verified");
        }
    }


    @AfterClass(alwaysRun = true)
    public void myOrdersAfterClass(){
        System.out.println("MyOrdersAfterClass is called");
    }



}
