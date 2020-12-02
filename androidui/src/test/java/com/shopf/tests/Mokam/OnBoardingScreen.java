package com.shopf.tests.Mokam;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import utils.*;

import java.util.*;

public class OnBoardingScreen extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private SalesRepFeaturePageObject salesRepFeaturePageObject;
    private WebElement shopNameText;
    private WebElement ownerNameText;
    private WebElement retailerIcon;
    private WebElement wholeSaleIcon;
    private WebElement bothIcon;
    private WebElement nextButtonAtOnboardingScreen;
    private WebElement skipButton;
    private Random random;
    private SoftAssert softAssert;
    String almostThereText_English = "Almost there!";
    String subText_English = "We'd like to get to know you better";
    String businessTypeTitleText_English = "Business Type";
    List<String> businessTypeOptions = new ArrayList<>();
    String nextButtonText_English = "Next";
    String skipButtonText_English = "Skip";

    @BeforeSuite(alwaysRun = true)
    public void onBoardingScreenBeforeSuite(){
        System.out.println("onBoardingScreenBeforeSuite is called");
        androidDriver = getBaseDriver();
        random = new Random();
        softAssert = new SoftAssert();
        pageInitializer();
        businessTypeOptions.add(0,"Retailer");
        businessTypeOptions.add(1,"Wholesaler");
        businessTypeOptions.add(2,"Both");
        loginPageObjects.performAuthentication("1877755590","666666");
        sleep(4000);
        xpathSetter("//androidx.cardview.widget.CardView[@index='0']/android.view.ViewGroup[@index='0']").click();
        sleep(2000);
        switchFromWebToNative();
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(5000);
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemLogout();
        String mobileNumber = newRandomMobileNumberGeneration();
        loginPageObjects.performAuthentication(mobileNumber,"666666");
        sleep(3000);
    }

    public void pageInitializer(){
        loginPageObjects = new LoginPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        salesRepFeaturePageObject = new SalesRepFeaturePageObject(androidDriver);
    }

    public String newRandomMobileNumberGeneration(){
//        List<Integer> listOfThreeDigitNumbers= new ArrayList<>();
//        for(int i=100;i<1000;i++)
//        {listOfThreeDigitNumbers.add(i);}
//        int threeNumber = listOfThreeDigitNumbers.get(random.nextInt(899));
//        return "01877755"+threeNumber;
        return "018"+RandomStringUtils.randomAlphanumeric(8);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 0)
    public void verifyCurrentActivity(){
        System.out.println("verifyCurrentActivity is called");
        String activity = androidDriver.currentActivity();
        Assert.assertEquals(activity,CoreConstants.ANDROID_PROFILE_ACTIVITY);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifyAlmostThereText(){
        System.out.println("verifyAlmostThereText is called");
        String almostThereText = salesRepFeaturePageObject.getAlmostThereText();
        Assert.assertEquals(almostThereText,almostThereText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifySubText(){
        System.out.println("verifySubText is called");
        String subText = salesRepFeaturePageObject.getSubText();
        Assert.assertEquals(subText,subText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyEnteringValueInShopNameEditText(){
        System.out.println("verifyEnteringValueInShopNameEditText is called");
        String shopName = "Shop Name : "+random.nextInt(1000);
        salesRepFeaturePageObject.enterShopNameText(shopName);
        shopNameText = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/add_retailer_edit_shop_name']");
        String shopNameInUI = shopNameText.getText();
        Assert.assertEquals(shopNameInUI,shopName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void verifyEnteringValueInOwnerNameEditText(){
        System.out.println("verifyEnteringValueInOwnerNameEditText is called");
        String ownerName = "Owner Name : "+random.nextInt(1000);
        salesRepFeaturePageObject.enterOwnerNameText(ownerName);
        ownerNameText = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/add_retailer_owner_name']");
        String ownerNameInUI = ownerNameText.getText();
        Assert.assertEquals(ownerNameInUI,ownerName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifyBusinessTypeTitleText(){
        System.out.println("verifyBusinessTypeTitleText is called");
        String businessTypeTitleText = salesRepFeaturePageObject.getBusinessTypeTitleText();
        Assert.assertEquals(businessTypeTitleText,businessTypeTitleText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifyBusinessTypeOptionText(){
        System.out.println("verifyBusinessTypeOptionText is called");
        for (int i=1;i<3;i++){
            String businessTypeOptionText = salesRepFeaturePageObject.getTextInBusinessTypeOption(i);
            softAssert.assertEquals(businessTypeOptionText,businessTypeOptions.get(i-1));
        }
        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public int verifyRandomSelectionOfBusinessType(){
        System.out.println("verifyRandomSelectionOfBusinessType is called");
        int option = random.nextInt(2);
        option++;
        switch (option){
            case 1 :
                salesRepFeaturePageObject.clickOnRetailerIcon();
                break;
            case 2 :
                salesRepFeaturePageObject.clickOnWholeSaleIcon();
                break;
            case 3 :
                salesRepFeaturePageObject.clickOnBothIconInBusinessType();
                break;
        }
        return option;
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyOtherTwoOptionsAreUnSelected(){
        System.out.println("verifyOtherTwoOptionsAreUnSelected is called");
        retailerIcon = idSetter("com.mokam.app:id/chip_retailer");
        wholeSaleIcon = idSetter("com.mokam.app:id/chip_wholesaler");
        bothIcon = idSetter("com.mokam.app:id/chip_both");
        int selectedOption = verifyRandomSelectionOfBusinessType();
        if (selectedOption==1){
            softAssert.assertEquals(wholeSaleIcon.getAttribute("checked"),"false");
            softAssert.assertEquals(bothIcon.getAttribute("checked"),"false");
            softAssert.assertAll();
        } else if (selectedOption==2){
            softAssert.assertEquals(retailerIcon.getAttribute("checked"),"false");
            softAssert.assertEquals(bothIcon.getAttribute("checked"),"false");
            softAssert.assertAll();
        } else if (selectedOption==3){
            softAssert.assertEquals(retailerIcon.getAttribute("checked"),"false");
            softAssert.assertEquals(wholeSaleIcon.getAttribute("checked"),"false");
            softAssert.assertAll();
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyNextButtonText(){
        System.out.println("verifyNextButtonText is called");
        String nextButtonText = salesRepFeaturePageObject.getNextButtonText();
        Assert.assertEquals(nextButtonText,nextButtonText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifyNextButtonIsClickable(){
        System.out.println("verifyNextButtonIsClickable is called");
        nextButtonAtOnboardingScreen = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/action_next_on_boarding']");
        Assert.assertEquals(nextButtonAtOnboardingScreen.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifySkipButtonText(){
        System.out.println("verifySkipButtonText is called");
        String skipButtonText = salesRepFeaturePageObject.getSkipButtonText();
        Assert.assertEquals(skipButtonText,skipButtonText_English);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 12)
    public void verifySkipButtonIsClickable(){
        System.out.println("verifySkipButtonIsClickable is called");
        skipButton = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/add_retailer_action_skip']");
        Assert.assertEquals(skipButton.getAttribute("clickable"),"true");
    }

    @AfterSuite(alwaysRun = true)
    public void onBoardingScreenAfterSuite(){
        System.out.println("onBoardingScreenAfterSuite is called");
        quitBaseDriver();
    }

}
