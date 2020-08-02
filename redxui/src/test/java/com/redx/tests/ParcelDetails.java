package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.PropertyReader;
import utils.RedXBaseClass;

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


    public void pageInitializer() {
        homePageObjects = new HomePageObjects();
        actionBarPageObjects = new ParcelsPageObjects().new ActionBarPageObjects();
        orderStatusPageObjects = new ParcelsPageObjects().new OrderStatusPageObjects();
        parcelsManifestList = new ParcelsPageObjects().new ParcelsManifestList();
        dateFilterPageObjects = new ParcelsPageObjects().new DateFilterPageObjects();
        manifestParcelDetails = new ManifestParcelDetails();
        packageDetailsModule = manifestParcelDetails.new PackageDetailsModule();
        random = new Random();
    }


    @BeforeClass(alwaysRun = true)
    public void parcelDetailsBeforeClass() {
        System.out.println("Before Parcel Details Class");
        androidDriver = getBaseDriver();
        pageInitializer();
        refreshPage();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            description = "Verifies Parcel Details Functionality In Failed Tab")
    public void verifyParcelDetailsModule() {
        int index;
        List<WebElement> parcelsList;

        System.out.println("Verify Parcel Details");
        homePageObjects.clickViewParcelUpdatesModule();
        Assert.assertEquals(actionBarPageObjects.getPageTitle(), "Parcels");
        dateFilterPageObjects.chooseMonthByText("Jul, 2020");

        orderStatusPageObjects.clickFailedParcelsTab();
        parcelsList = parcelsManifestList.setParcelsList();
        if (parcelsList.size() != 0) {
            index = random.nextInt(parcelsList.size());
            parcelsManifestList.clickParcelByIndex(index);
            try {
                Assert.assertEquals(actionBarPageObjects.getPageTitle(), PropertyReader.getValueOfKey("PARCEL_DATE"));
            } catch (Exception e) {
                e.printStackTrace();
            }

            parcelsList = manifestParcelDetails.setPackagesList();
            if (parcelsList.size() != 0) {
                index = random.nextInt(parcelsList.size());
                manifestParcelDetails.clickDetailsByIndex(index);
                try {
                    if ((!PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_STATUS).equals("PICKUP PENDING"))||(!PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_STATUS).equals("PICKUP PENDING")))
                    {
                        Assert.assertEquals(actionBarPageObjects.getParcelDetailsTitle(), PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_ID));
                        packageDetailsModule.getDetails(null);
                        actionBarPageObjects.clickBackButton();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
}
