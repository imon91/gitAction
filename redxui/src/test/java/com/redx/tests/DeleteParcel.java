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


public class DeleteParcel extends RedXBaseClass {
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private ParcelsPageObjects.ActionBarPageObjects actionBarPageObjects;
    private ParcelsPageObjects.OrderStatusPageObjects orderStatusPageObjects;
    private ParcelsPageObjects.ParcelsManifestList parcelsManifestList;
    private ParcelsPageObjects.DateFilterPageObjects dateFilterPageObjects;
    private ManifestParcelDetails manifestParcelDetails;
    private Random random;


    public void pageInitializer() {
        homePageObjects = new HomePageObjects();
        actionBarPageObjects = new ParcelsPageObjects().new ActionBarPageObjects();
        orderStatusPageObjects = new ParcelsPageObjects().new OrderStatusPageObjects();
        parcelsManifestList = new ParcelsPageObjects().new ParcelsManifestList();
        dateFilterPageObjects = new ParcelsPageObjects().new DateFilterPageObjects();
        manifestParcelDetails = new ManifestParcelDetails();
        random = new Random();
    }


    @BeforeClass(alwaysRun = true)
    public void deleteParcelBeforeClass() {
        System.out.println("Delete Parcel Class");
        androidDriver = getBaseDriver();
        pageInitializer();
        refreshPage();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            description = "Verifies Delete Parcel Functionality")
    public void verifyDeleteParcelModule()
    {
        int index;
        List<WebElement> parcelsList;

        System.out.println("Delete a Parcel");
        homePageObjects.clickViewParcelUpdatesModule();
        Assert.assertEquals(actionBarPageObjects.getPageTitle(), "Parcels");
        dateFilterPageObjects.chooseMonthByText("Aug, 2020");

        orderStatusPageObjects.clickInProgressParcelsTab();
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


    @AfterClass(alwaysRun = true)
    public void EditParcelAfterClass() {
        System.out.println("After Delete Parcel Class");
        //closeApp();
    }
}
