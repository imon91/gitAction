package com.shopf.tests.Mokam;

import coreUtils.*;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import testData.ReadJSONFile;
import utils.*;

import java.util.Random;

public class EditAddressPage extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private HomePageObjects homePageObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private YourAccountPageObjects yourAccountPageObjects;
    private ServiceRequestLayer serviceRequestLayer;
    private SoftAssert softAssert;
    private Random random;
    private String app;
    private ReadJSONFile readJSONFile;
    private WebElement backButtonElement;
    private WebElement pageTitleElement;
    private WebElement shopNameEditText;
    private WebElement addressEditText;
    private WebElement areaEditText;
    private WebElement localityEditText;
    private WebElement mobileNumberEditText;
    private WebElement alternateMobileNumberEditText;

    @BeforeSuite(alwaysRun = true)
    public void editAddressPageBeforeSuite() throws Exception {
        androidDriver = getBaseDriver();
        pageInitializer();
        softAssert = new SoftAssert();
        random = new Random();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication().performAuthentication();
        readJSONFile = serviceRequestLayer.getControlOverReadJSONFile();
        loginPageObjects.performAuthentication("1877755590","666666");
        sleep(4000);
//        xpathSetter("//androidx.cardview.widget.CardView[@index='0']/android.view.ViewGroup[@index='0']").click();
        homePageObjects.createNewAddress();
        sleep(2000);
        switchFromWebToNative();
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemChangeLanguage();
        rightNavigationDrawer.selectEnglish();
        rightNavigationDrawer.saveLanguage();
        sleep(5000);
        actionBarObjects.clickOnUserProfileImageButton();
        rightNavigationDrawer.clickOnItemLogout();
        loginPageObjects.performAuthentication("1877755530","666666");
        sleep(4000);
        yourAccountPageObjects.clickAddressEditButton(0);
        backButtonElement = xpathSetter("//android.widget.ImageView[@resource-id='com.mokam.app:id/back_button_profile']");
        pageTitleElement = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/title_profile_activity']");
        shopNameEditText = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/add_address_name']");
        addressEditText = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/add_address_address']");
        areaEditText = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/add_address_area']");
        localityEditText = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/add_address_locality']");
        mobileNumberEditText = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/add_address_phone']");
        alternateMobileNumberEditText = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/add_address_alternate_phone']");
    }

    public void pageInitializer(){
        loginPageObjects = new LoginPageObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        yourAccountPageObjects = new YourAccountPageObjects(androidDriver);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 0)
    public void verifyCurrentActivity(){
        String currentActivity = androidDriver.currentActivity();
        Assert.assertEquals(currentActivity,CoreConstants.ANDROID_PROFILE_ACTIVITY);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 1)
    public void verifyBackButtonClickable(){
        Assert.assertEquals(backButtonElement.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 2)
    public void verifyEditAddressPageTitle(){
        Assert.assertEquals(pageTitleElement.getText(),"Edit Address");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 3)
    public void verifyHeadingTexts(){
        shopNameEditText.clear();
        softAssert.assertEquals(shopNameEditText.getText(),"Shop Name");

        addressEditText.clear();
        softAssert.assertEquals(addressEditText.getText(),"Address");

        areaEditText.clear();
        softAssert.assertEquals(areaEditText.getText(),"Area");

        localityEditText.clear();
        softAssert.assertEquals(localityEditText.getText(),"Locality (Optional)");

        mobileNumberEditText.clear();
        softAssert.assertEquals(mobileNumberEditText.getText(),"Mobile Number");

        alternateMobileNumberEditText.clear();
        softAssert.assertEquals(alternateMobileNumberEditText.getText(),"Alternate Mobile (Optional)");

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 4)
    public void enteringValuesInEditTexts(){
        String shopName = RandomStringUtils.randomAlphabetic(8);
        shopNameEditText.sendKeys(shopName);
        softAssert.assertEquals(shopNameEditText.getText(),shopName);

        String address = RandomStringUtils.randomAlphabetic(10);
        addressEditText.sendKeys(address);
        softAssert.assertEquals(addressEditText.getText(),address);

        String area = homePageObjects.enterArea();
        softAssert.assertEquals(areaEditText.getText(),area);

        String locality = RandomStringUtils.randomAlphabetic(8);
        localityEditText.sendKeys(locality);
        softAssert.assertEquals(localityEditText.getText(),locality);

        String mobileNumber = "018" + RandomStringUtils.randomNumeric(8);
        mobileNumberEditText.sendKeys(mobileNumber);
        softAssert.assertEquals(mobileNumberEditText.getText(),mobileNumber);

        String alternateMobileNumber = "018" + RandomStringUtils.randomNumeric(8);
        alternateMobileNumberEditText.sendKeys(alternateMobileNumber);
        softAssert.assertEquals(alternateMobileNumberEditText.getText(),alternateMobileNumber);

        softAssert.assertAll();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 5)
    public void verifySaveButtonText(){
        WebElement saveButtonElement = xpathSetter("//android.widget.TextView[@resource-id='com.mokam.app:id/action_add_address']");
        Assert.assertEquals(saveButtonElement.getText(),"SAVE");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 6)
    public void verifySaveButtonClickable(){
        WebElement element = xpathSetter("//android.widget.FrameLayout[@resource-id='com.mokam.app:id/action_next_container']");
        Assert.assertEquals(element.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 7)
    public void verifyBackButtonClickableInLocationPage(){
        backButtonElement.click();
        try {
            homePageObjects.scrollToAddNewAddressButton();
        } catch (Exception e){
            System.out.println("No addresses found");
        }
        homePageObjects.clickOnAddNewAddressButton();
        sleep(1000);
        homePageObjects.clickAllowButton();
        sleep(1000);
        WebElement element = xpathSetter("//android.widget.ImageView[@resource-id='com.mokam.app:id/action_back_gmaps']");
        Assert.assertEquals(element.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 12)
    public void verifyTextInLocationInputBox(){
        WebElement element = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/location_input']");
        element.clear();
        Assert.assertEquals(element.getText(),"Enter Shop Location");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 13)
    public void verifyEnteringTextInLocationInputBox() throws Exception {
        int randomIndex = random.nextInt(readJSONFile.getLocationData(app, "locationTerm").size());
        String locationName = String.valueOf(readJSONFile.getLocationData(app, "locationTerm").get(randomIndex));
        homePageObjects.enterLocation(locationName);
        sleep(2000);
        WebElement element = xpathSetter("//android.widget.EditText[@resource-id='com.mokam.app:id/location_input']");
        Assert.assertEquals(element.getText(),locationName);
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 8)
    public void verifyLocateMeText(){
        WebElement element = idSetter("com.mokam.app:id/action_locate_me");
        Assert.assertEquals(element.getText(),"Locate Me");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 9)
    public void verifyLocateMeButtonClickable(){
        WebElement element = idSetter("com.mokam.app:id/action_locate_me");
        Assert.assertEquals(element.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 10)
    public void verifyTextOfNextButtonInLocationPage(){
        WebElement element = idSetter("com.mokam.app:id/action_next");
        Assert.assertEquals(element.getText(),"NEXT");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 11)
    public void verifyNextButtonInLocationPageClickable(){
        WebElement element = idSetter("com.mokam.app:id/action_next");
        Assert.assertEquals(element.getAttribute("clickable"),"true");
    }

    @Test(groups = {CoreConstants.GROUP_SANITY,CoreConstants.GROUP_REGRESSION},priority = 14)
    public void verifyAddNewAddressPageTitle(){
        homePageObjects.clickOnLocationNextButton();
        sleep(1000);
        Assert.assertEquals(pageTitleElement.getText(),"Add New Address");
    }

    @AfterSuite(alwaysRun = true)
    public void editAddressPageAfterSuite(){
        quitBaseDriver();
    }

}
