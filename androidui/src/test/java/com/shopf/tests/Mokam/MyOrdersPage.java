package com.shopf.tests.Mokam;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import services.responseModels.commerceModels.MyOrderDetailsModel;
import services.responseModels.commerceModels.MyOrderDetailsNewModel;
import utils.*;

import java.util.*;

public class MyOrdersPage extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private ActionBarObjects actionBarObjects;
    private HomePageObjects homePageObjects;
    private BottomNavigationObjects bottomNavigationObjects;
    private MyOrdersPageObjects myOrdersPageObjects;
    private MyOrderDetailsPageObject myOrderDetailsPageObject;
    private MyOrdersPageObjects.MyOrderSearch myOrderSearch;
    private MyOrdersPageObjects.OrderDetails orderDetails;
    private ServiceRequestLayer serviceRequestLayer;
    private SoftAssert softAssert;
    private Random random;

    @BeforeSuite(alwaysRun = true)
    public void myOrdersPageBeforeSuite() throws Exception {
        androidDriver = getBaseDriver();
        pageInitializer();
        softAssert = new SoftAssert();
        random = new Random();
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        loginPageObjects.performAuthentication("1877755590","666666");
        sleep(4000);
//        homePageObjects.selectAddress(0);
        homePageObjects.createNewAddress();
        sleep(4000);
        switchFromWebToNative();
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(5000);
        bottomNavigationObjects.clickOnBottomBarMyOrdersIcon();
    }

    public void pageInitializer(){
        loginPageObjects = new LoginPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
        bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
        myOrdersPageObjects = new MyOrdersPageObjects(androidDriver);
        myOrderDetailsPageObject = new MyOrderDetailsPageObject(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        myOrderSearch = myOrdersPageObjects.new MyOrderSearch(androidDriver);
        orderDetails = myOrdersPageObjects.new OrderDetails(androidDriver);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 0)
    public void verifyCurrentActivity(){
        String currentActivity = androidDriver.currentActivity();
        Assert.assertEquals(currentActivity,CoreConstants.ANDROID_HOME_ACTIVITY);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifySelectedAddress(){
        List<String> selectedAddressNameAndAddressList = new ArrayList<>();
        int cart_Item_Count = homePageObjects.getCartItemCount();
        selectedAddressNameAndAddressList = homePageObjects.getNameAndAddress_Backend(0,cart_Item_Count);
        WebElement nameOfSelectedAddress = actionBarObjects.getAddressNameAndAddressElement().get(0);
        softAssert.assertEquals(nameOfSelectedAddress.getText(),selectedAddressNameAndAddressList.get(0));

        WebElement addressOfSelectedAddress = actionBarObjects.getAddressNameAndAddressElement().get(1);
        softAssert.assertEquals(addressOfSelectedAddress.getText(),selectedAddressNameAndAddressList.get(1));

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyButtonsInActionBarAreClickable(){
        WebElement sideMenuButtonElement = actionBarObjects.getActionBarButtonElements().get(0);
        softAssert.assertEquals(sideMenuButtonElement.getAttribute("clickable"),"true");

        WebElement searchButtonElement = actionBarObjects.getActionBarButtonElements().get(1);
        softAssert.assertEquals(searchButtonElement.getAttribute("clickable"),"true");

        WebElement profileButtonElement = actionBarObjects.getActionBarButtonElements().get(2);
        softAssert.assertEquals(profileButtonElement.getAttribute("clickable"),"true");

        WebElement cartButtonElement = actionBarObjects.getActionBarButtonElements().get(3);
        softAssert.assertEquals(cartButtonElement.getAttribute("clickable"),"true");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyButtonsInBottomNavigationBarAreClickable(){
        WebElement homeButtonElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(0);
        softAssert.assertEquals(homeButtonElement.getAttribute("clickable"),"true");

        WebElement myOrdersButtonElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(1);
        softAssert.assertEquals(myOrdersButtonElement.getAttribute("clickable"),"false");

        WebElement khataButtonElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(2);
        softAssert.assertEquals(khataButtonElement.getAttribute("clickable"),"true");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyTextsInBottomNavigationBarButtons(){
        WebElement homeButtonTextElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(0);
        softAssert.assertEquals(homeButtonTextElement.getAttribute("content-desc"),"Home");

        WebElement myOrdersButtonTextElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(1);
        softAssert.assertEquals(myOrdersButtonTextElement.getAttribute("content-desc"),"My Orders");

        WebElement khataButtonTextElement = bottomNavigationObjects.getMokamBottomBarButtonElements().get(2);
        softAssert.assertEquals(khataButtonTextElement.getAttribute("content-desc"),"Khata");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyEnteringValueInSearchInputBox(){
        int randomNumber = random.nextInt(100);
        myOrderDetailsPageObject.enterValueToSearch(""+randomNumber);
        WebElement searchInputBoxElement = myOrderDetailsPageObject.getSearchInputBoxElement();
        Assert.assertEquals(searchInputBoxElement.getText(),""+randomNumber);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void VerifySearchButtonClickableInSearchBox(){
        WebElement searchButtonElement = myOrderDetailsPageObject.getSearchIconElement();
        WebDriverWait wait = new WebDriverWait(androidDriver,30);
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifySortButtonText(){
        WebElement sortButtonElement = myOrderDetailsPageObject.getSortButtonElement();
        Assert.assertEquals(sortButtonElement.getText(),"Sort");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 12)
    public void verifySortButtonClickable(){
        WebElement sortButtonElement = myOrderDetailsPageObject.getSortButtonElement();
        WebDriverWait wait = new WebDriverWait(androidDriver,30);
        wait.until(ExpectedConditions.elementToBeClickable(sortButtonElement));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 13)
    public void verifyFilterButtonText(){
        WebElement filterButtonElement = myOrderDetailsPageObject.getFilterButtonElement();
        Assert.assertEquals(filterButtonElement.getText(),"Filter");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 14)
    public void verifyFilterButtonClickable(){
        WebElement filterButtonElement = myOrderDetailsPageObject.getFilterButtonElement();
        WebDriverWait wait = new WebDriverWait(androidDriver,30);
        wait.until(ExpectedConditions.elementToBeClickable(filterButtonElement));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 15)
    public void verifyOrderIDHeadingText(){
        WebElement orderIDHeadingElement = myOrderDetailsPageObject.getOrderIDTextElement();
        Assert.assertEquals(orderIDHeadingElement.getText(),"Order ID / Date");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 16)
    public void verifyNameHeadingText(){
        WebElement nameAndAddressHeadingElement = myOrderDetailsPageObject.getNameTextElement();
        Assert.assertEquals(nameAndAddressHeadingElement.getText(),"Name / Address");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifyActiveTabText(){
        WebElement activeTabElement = myOrdersPageObjects.getTabElementsList().get(0);
        Assert.assertEquals(activeTabElement.getAttribute("content-desc"),"Active ");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 17)
    public void verifyFirstOrderInActiveTab(){
        String firstOrderId = myOrderDetailsPageObject.getFirstOrderID().replaceAll(" ","");
        String firstOrderCustomerName = myOrderDetailsPageObject.getFirstOrderCustomerName().replaceAll(" ","");
        MyOrderDetailsNewModel myOrderDetailsModel = myOrderDetailsPageObject.getMyOrderDetails(firstOrderId);
        String firstOrderID_Backend = myOrderDetailsModel.getCustomer_order().getNumber().replaceAll(" ","");
        String firstOrderCustomerName_Backend = myOrderDetailsModel.getCustomer_order().getShip_address().getFirstname().replaceAll(" ","");
        softAssert.assertEquals(firstOrderId,firstOrderID_Backend);
        softAssert.assertEquals(firstOrderCustomerName,firstOrderCustomerName_Backend);
        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 20)
    public void verifyFirstOrderInCompletedTab(){
        myOrdersPageObjects.selectATab(1);
        sleep(4000);
        String firstOrderId = myOrderDetailsPageObject.getFirstOrderID().replaceAll(" ","");
        String firstOrderCustomerName = myOrderDetailsPageObject.getFirstOrderCustomerName().replaceAll(" ","");
        MyOrderDetailsNewModel myOrderDetailsModel = myOrderDetailsPageObject.getMyOrderDetails(firstOrderId);
        String firstOrderID_Backend = myOrderDetailsModel.getCustomer_order().getNumber().replaceAll(" ","");
        String firstOrderCustomerName_Backend = myOrderDetailsModel.getCustomer_order().getShip_address().getFirstname().replaceAll(" ","");
        softAssert.assertEquals(firstOrderId,firstOrderID_Backend);
        softAssert.assertEquals(firstOrderCustomerName,firstOrderCustomerName_Backend);
        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 23)
    public void verifyFirstOrderInCancelledTab(){
        myOrdersPageObjects.selectATab(2);
        sleep(4000);
        String firstOrderId = myOrderDetailsPageObject.getFirstOrderID().replaceAll(" ","");
        String firstOrderCustomerName = myOrderDetailsPageObject.getFirstOrderCustomerName().replaceAll(" ","");
        MyOrderDetailsNewModel myOrderDetailsModel = myOrderDetailsPageObject.getMyOrderDetails(firstOrderId);
        String firstOrderID_Backend = myOrderDetailsModel.getCustomer_order().getNumber().replaceAll(" ","");
        String firstOrderCustomerName_Backend = myOrderDetailsModel.getCustomer_order().getShip_address().getFirstname().replaceAll(" ","");
        softAssert.assertEquals(firstOrderId,firstOrderID_Backend);
        softAssert.assertEquals(firstOrderCustomerName,firstOrderCustomerName_Backend);
        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifyCompletedTabText(){
        WebElement completedTabElement = myOrdersPageObjects.getTabElementsList().get(1);
        Assert.assertEquals(completedTabElement.getAttribute("content-desc"),"Completed ");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifyCancelledTabText(){
        WebElement cancelledTabElement = myOrdersPageObjects.getTabElementsList().get(2);
        Assert.assertEquals(cancelledTabElement.getAttribute("content-desc"),"Cancelled ");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyOtherTwoTabsAreClickableWhenOneTabIsSelected() {
        int totalTabs = myOrdersPageObjects.getTabElementsList().size();System.out.println(totalTabs);
        int selectedTab = random.nextInt(totalTabs);System.out.println(selectedTab);
        if (selectedTab!=0){
            myOrdersPageObjects.selectATab(selectedTab);
        }
        if (selectedTab == 0){
            WebElement completedTabElement = myOrdersPageObjects.getCompletedTabTextElement();
            softAssert.assertEquals(completedTabElement.getAttribute("clickable"),"true");

            WebElement cancelledTabElement = myOrdersPageObjects.getCancelledTabTextElement();
            softAssert.assertEquals(cancelledTabElement.getAttribute("clickable"),"true");
        } else if(selectedTab == 1){
            WebElement activeTabElement = myOrdersPageObjects.getActiveTabTextElement();
            softAssert.assertEquals(activeTabElement.getAttribute("clickable"),"true");

            WebElement cancelledTabElement = myOrdersPageObjects.getCancelledTabTextElement();
            softAssert.assertEquals(cancelledTabElement.getAttribute("clickable"),"true");
        } else if(selectedTab == 2){
            WebElement activeTabElement = myOrdersPageObjects.getActiveTabTextElement();
            softAssert.assertEquals(activeTabElement.getAttribute("clickable"),"true");

            WebElement completedTabElement = myOrdersPageObjects.getCompletedTabTextElement();
            softAssert.assertEquals(completedTabElement.getAttribute("clickable"),"true");
        }if (selectedTab!=0){
            myOrdersPageObjects.selectATab(0);
        }
        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 18)
    public void verifyLoadMoreButtonTextInActiveTab(){
        myOrderDetailsPageObject.scrollToOrderID("Load More");
        WebElement loadMoreButtonElement = myOrderDetailsPageObject.getLoadMoreButtonElement();
        Assert.assertEquals(loadMoreButtonElement.getText(),"Load More");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 19)
    public void verifyLoadMoreButtonClickableInActiveTab(){
        WebElement loadMoreButtonElement = myOrderDetailsPageObject.getLoadMoreButtonElement();
        WebDriverWait wait = new WebDriverWait(androidDriver,30);
        wait.until(ExpectedConditions.elementToBeClickable(loadMoreButtonElement));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 21)
    public void verifyLoadMoreButtonTextInCompletedTab(){
        myOrderDetailsPageObject.scrollToOrderID("Load More");
        WebElement loadMoreButtonElement = myOrderDetailsPageObject.getLoadMoreButtonElement();
        Assert.assertEquals(loadMoreButtonElement.getText(),"Load More");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 22)
    public void verifyLoadMoreButtonClickableInCompletedTab(){
        WebElement loadMoreButtonElement = myOrderDetailsPageObject.getLoadMoreButtonElement();
        WebDriverWait wait = new WebDriverWait(androidDriver,30);
        wait.until(ExpectedConditions.elementToBeClickable(loadMoreButtonElement));
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 24)
    public void verifyLoadMoreButtonTextInCancelledTab(){
        myOrderDetailsPageObject.scrollToOrderID("Load More");
        WebElement loadMoreButtonElement = myOrderDetailsPageObject.getLoadMoreButtonElement();
        Assert.assertEquals(loadMoreButtonElement.getText(),"Load More");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 25)
    public void verifyLoadMoreButtonClickableInCancelledTab(){
        WebElement loadMoreButtonElement = myOrderDetailsPageObject.getLoadMoreButtonElement();
        WebDriverWait wait = new WebDriverWait(androidDriver,30);
        wait.until(ExpectedConditions.elementToBeClickable(loadMoreButtonElement));
    }

    @AfterSuite(alwaysRun = true)
    public void myOrdersPageAfterSuite(){
        quitBaseDriver();
    }

}
