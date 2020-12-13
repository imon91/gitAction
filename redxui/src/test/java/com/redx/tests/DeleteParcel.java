package com.redx.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;
import java.util.*;


public class DeleteParcel extends RedXBaseClass {
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private ParcelsPageObjects.ActionBarPageObjects actionBarPageObjects;
    private ParcelsPageObjects.OrderStatusPageObjects orderStatusPageObjects;
    private ParcelsPageObjects.ParcelsManifestList parcelsManifestList;
    private ParcelsPageObjects.DateFilterPageObjects dateFilterPageObjects;
    private ManifestParcelDetails manifestParcelDetails;
    private Random random;
    private SettingsPageObjects settingsPageObjects;
    private Authentication authentication;
    private ChangeLanguage changeLanguage;


    public void pageInitializer() {
        homePageObjects = new HomePageObjects();
        actionBarPageObjects = new ParcelsPageObjects().new ActionBarPageObjects();
        orderStatusPageObjects = new ParcelsPageObjects().new OrderStatusPageObjects();
        parcelsManifestList = new ParcelsPageObjects().new ParcelsManifestList();
        dateFilterPageObjects = new ParcelsPageObjects().new DateFilterPageObjects();
        manifestParcelDetails = new ManifestParcelDetails();
        random = new Random();
        settingsPageObjects = new SettingsPageObjects();
        authentication = new Authentication();
        changeLanguage = new ChangeLanguage();
    }

    @BeforeSuite(alwaysRun = true)
    public void redXAndroidBeforeSuite()
    {
        System.out.println("redXAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
    }


    @BeforeClass(alwaysRun = true)
    public void deleteParcelBeforeClass() {
        System.out.println("Delete Parcel Class");
        androidDriver = getBaseDriver();
        pageInitializer();
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
        changeLanguage.beforeChangeLanguageClass();
        changeLanguage.changeToEnglishLanguage();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            description = "Verifies Delete Parcel Functionality")
    public void verifyDeleteParcelModule()
    {
        refreshPage();
        int index;
        String assertVariable = null;
        List<WebElement> parcelsList;

        System.out.println("Delete a Parcel");
        homePageObjects.clickViewParcelUpdatesModule();
        Assert.assertEquals(actionBarPageObjects.getPageTitle(), "Parcels");
        dateFilterPageObjects.chooseMonthByText("Aug, 2020");

        orderStatusPageObjects.clickInProgressParcelsTab();
        parcelsList = parcelsManifestList.setParcelsList();
        if (parcelsList.size() != 0) {
            index = random.nextInt(parcelsList.size());
            sleep(1000);
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
                manifestParcelDetails.clickDeletePackageByIndex(index);
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
            description = "Verifies Delete Parcel Functionality",
    priority = 3)
    public void verifyDeletedParcel()
    {
        refreshPage();
        String assertVariable = null;
        List<WebElement> parcelsList;

        System.out.println("Delete a Parcel");
        homePageObjects.clickViewParcelUpdatesModule();
        Assert.assertEquals(actionBarPageObjects.getPageTitle(), "Parcels");
        dateFilterPageObjects.chooseMonthByText("Aug, 2020");

        orderStatusPageObjects.clickInProgressParcelsTab();
        parcelsList = parcelsManifestList.setParcelsList();
        if (parcelsList.size() != 0) {
            parcelsManifestList.clickParcelByIndex(0);
            try {
                assertVariable = PropertyReader.getValueOfKey("PARCEL_DATE");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Parcel Date cannot be read from Properties");
            }
            Assert.assertEquals(actionBarPageObjects.getPageTitle(), assertVariable);

            parcelsList = manifestParcelDetails.setPackagesList();
            if (parcelsList.size() != 0) {
                String parcelId = manifestParcelDetails.getParcelId(0);
                manifestParcelDetails.clickDeletePackageByIndex(0);
                sleep(1000);
                try {
                    String parcelIdAfterDeletion = manifestParcelDetails.getParcelId(1);
                    Assert.assertNotEquals(parcelId, parcelIdAfterDeletion);
                } catch (Exception e) {
                    System.out.println("The parcel was deleted");
                }
                actionBarPageObjects.clickBackButton();

            }
        }
    }


    @AfterClass(alwaysRun = true)
    public void EditParcelAfterClass() {
        System.out.println("After Delete Parcel Class");
        //closeApp();
    }

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){

        System.out.println("redXAndroidAfterSuite Is Called");
        quitBaseDriver();

    }
}
