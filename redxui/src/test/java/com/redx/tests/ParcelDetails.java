package com.redx.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;
import java.util.*;

public class ParcelDetails extends RedXBaseClass {
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private ParcelsPageObjects.ActionBarPageObjects actionBarPageObjects;
    private ParcelsPageObjects.OrderStatusPageObjects orderStatusPageObjects;
    private ParcelsPageObjects.ParcelsManifestList parcelsManifestList;
    private ParcelsPageObjects.DateFilterPageObjects dateFilterPageObjects;
    private ManifestParcelDetails manifestParcelDetails;
    private ManifestParcelDetails.PackageDetailsModule packageDetailsModule;
    private Random random;
    private LoginPageObjects loginPageObjects;
    private Authentication authentication;
    private ChangeLanguage changeLanguage;


    public void pageInitializer() {
        homePageObjects = new HomePageObjects();
        actionBarPageObjects = new ParcelsPageObjects().new ActionBarPageObjects();
        orderStatusPageObjects = new ParcelsPageObjects().new OrderStatusPageObjects();
        parcelsManifestList = new ParcelsPageObjects().new ParcelsManifestList();
        dateFilterPageObjects = new ParcelsPageObjects().new DateFilterPageObjects();
        manifestParcelDetails = new ManifestParcelDetails();
        packageDetailsModule = manifestParcelDetails.new PackageDetailsModule();
        random = new Random();
        authentication = new Authentication();
        changeLanguage = new ChangeLanguage();
    }

    @BeforeSuite(alwaysRun = true)
    public void redXAndroidBeforeSuite() {
        System.out.println("redXAndroidBeforeSuite is called");
    }


        @BeforeClass(alwaysRun = true)
    public void parcelDetailsBeforeClass() {
        System.out.println("Before Parcel Details Class");
        androidDriver = getBaseDriver();
        pageInitializer();
        refreshPage();
    }

    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        return new Object[][]{
                {"01401122188","6666"}
        };
    }

    @Test(  groups = {"Authentication.verifyAuthenticationWithWrongOTP",
            CoreConstants.GROUP_SANITY},
            description = "Verifies Authentication With Wrong OTP",
            priority = 1,
            dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationWithWrongOTP(String mobileNumber,String otp) throws Exception {
        System.out.println("Verify authentication with Wrong OTP was called");
        authentication.authenticationSetUp();
        authentication.verifyAuthenticationWithValidCredentials(mobileNumber,otp);}

    @Test(  groups = {"Settings.verifyChangeLanguageToENGLISH",
            CoreConstants.GROUP_SANITY},
            description = "Change Language To English",
            priority = 2)
    public void changeToEnglishLanguage() throws Exception {
        System.out.println("Changing to English Language");
        changeLanguage.beforeChangeLanguageClass();
        changeLanguage.changeToEnglishLanguage();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            description = "Verifies Parcel Details Functionality In Failed Tab")
    public void verifyParcelDetailsModule() {
        int index;
        String assertVariable = null;
        String parcelStatus = null;
        List<WebElement> parcelsList;

        System.out.println("Verify Parcel Details");
        homePageObjects.clickViewParcelUpdatesModule();
        Assert.assertEquals(actionBarPageObjects.getPageTitle(), "Parcels");
        dateFilterPageObjects.chooseMonthByText("Jul, 2020");

        orderStatusPageObjects.clickDeliveredParcelsTab();
        parcelsList = parcelsManifestList.setParcelsList();
        if (parcelsList.size() != 0) {
            index = random.nextInt(parcelsList.size());
            parcelsManifestList.clickParcelByIndex(index);
            try
            {
                assertVariable = PropertyReader.getValueOfKey("PARCEL_DATE");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Parcel Date cannot be read from Properties");
            }
            Assert.assertEquals(actionBarPageObjects.getPageTitle(), assertVariable);

            parcelsList = manifestParcelDetails.setPackagesList();
            if (parcelsList.size() != 0) {
                index = random.nextInt(parcelsList.size());
                manifestParcelDetails.clickDetailsByIndex(index);
                try
                {
                    assertVariable = PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_ID);
                    parcelStatus = PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_STATUS);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Parcel Details cannot be read from Properties");
                }
                if ((!parcelStatus.equals("PICKUP PENDING"))&&(!parcelStatus.equals("DAMAGED")))
                {
                    Assert.assertEquals(actionBarPageObjects.getParcelDetailsTitle(), assertVariable);
                    packageDetailsModule.getDetails(null);
                    actionBarPageObjects.clickBackButton();
                }
                actionBarPageObjects.clickBackButton();
            } else {
                System.out.println("No Parcels Found");
                actionBarPageObjects.clickBackButton();
            }
            actionBarPageObjects.clickBackButton();
        } else {
            System.out.println("No Parcels Found");
            actionBarPageObjects.clickBackButton();
        }
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},
            priority = 3,
            description = "Verifies search functionality in view parcel module")
    public void verifyCallRedXOptionOnDetailsPage() {
        System.out.println("Verify 'Call RedX'Option on Details page");
        int index;
        String assertVariable = null;
        String parcelStatus = null;
        List<WebElement> parcelsList;

        homePageObjects.clickViewParcelUpdatesModule();
        System.out.println("the view parcel update activity  "+androidDriver.currentActivity());
        dateFilterPageObjects.chooseMonthByText("Oct, 2020");
        orderStatusPageObjects.clickDeliveredParcelsTab();
        parcelsList = parcelsManifestList.setParcelsList();
        if (parcelsList.size() != 0) {
            index = random.nextInt(parcelsList.size());
            parcelsManifestList.clickParcelByIndex(index);
            System.out.println("The activity at the parcel list "+androidDriver.currentActivity());
            try
            {
                assertVariable = PropertyReader.getValueOfKey("PARCEL_DATE");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Parcel Date cannot be read from Properties");
            }

            parcelsList = manifestParcelDetails.setPackagesList();
            if (parcelsList.size() != 0) {
                index = random.nextInt(parcelsList.size());
                manifestParcelDetails.clickDetailsByIndex(index);
                try
                {
                    assertVariable = PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_ID);
                    parcelStatus = PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_STATUS);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Parcel Details cannot be read from Properties");
                }
                if ((!parcelStatus.equals("PICKUP PENDING"))&&(!parcelStatus.equals("DAMAGED")))
                {
                    String activity =  androidDriver.currentActivity();
                    packageDetailsModule.clickOnCallRedXOption();
                    try{
                        WebElement popUp = xpathSetter("");
                    Assert.assertTrue(popUp.isDisplayed());
                    sleep(2000);}
                    catch (AssertionError e){
                        Assert.assertNotEquals(activity,androidDriver.currentActivity());
                    }
                    sleep(1000);
                    androidDriver.navigate().back();
                    sleep(1000);
                    actionBarPageObjects.clickBackButton();
                }
                actionBarPageObjects.clickBackButton();
            } else {
                System.out.println("No Parcels Found");
                actionBarPageObjects.clickBackButton();
            }
            actionBarPageObjects.clickBackButton();
        } else {
            System.out.println("No Parcels Found");
            actionBarPageObjects.clickBackButton();
        }
    }



    @AfterClass(alwaysRun = true)
    public void editParcelAfterClass() {
        System.out.println("After Parcel Details Class");
        //closeApp();
    }

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){

        System.out.println("redXAndroidAfterSuite Is Called");
        quitBaseDriver();

    }
}
