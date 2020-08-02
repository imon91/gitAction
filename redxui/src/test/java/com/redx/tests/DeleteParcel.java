package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.RedXBaseClass;

import java.util.*;


public class DeleteParcel extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private CommonPageObjects commonPageObjects;
    private HomePageObjects homePageObjects;
    private ParcelsPageObjects.ActionBarPageObjects actionBarPageObjects;
    private ParcelsPageObjects.OrderStatusPageObjects orderStatusPageObjects;
    private ParcelsPageObjects.ParcelsManifestList parcelsManifestList;
    private ManifestParcelDetails manifestParcelDetails;
    private Random random;


    public void pageInitializer()
    {
        commonPageObjects = new CommonPageObjects();
        homePageObjects = new HomePageObjects();
        actionBarPageObjects = new ParcelsPageObjects().new ActionBarPageObjects();
        orderStatusPageObjects = new ParcelsPageObjects().new OrderStatusPageObjects();
        parcelsManifestList = new ParcelsPageObjects().new ParcelsManifestList();
        manifestParcelDetails = new ManifestParcelDetails();
        random = new Random();
    }


    @BeforeClass(alwaysRun = true)
    public void deleteParcelBeforeClass()
    {
        System.out.println("Delete Parcel Class");
        androidDriver = getBaseDriver();
        pageInitializer();
    }


    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            description = "Verifies Delete Parcel Functionality")
    public void verifyDeleteParcelModule()
    {
        int index;
        List<WebElement> parcelsList;
        System.out.println("Delete a Parcel");
        homePageObjects.clickViewParcelUpdatesModule();
        Assert.assertEquals(commonPageObjects.getPageTitle(),"Parcels");
        //sleep(1000);
        orderStatusPageObjects.clickInProgressParcelsTab();
        parcelsList = parcelsManifestList.setParcelsList();
        //sleep(1000);
        index = random.nextInt(parcelsList.size());
        parcelsManifestList.clickParcelByIndex(index);
        //sleep(2000);
        parcelsList = manifestParcelDetails.setPackagesList();
        //sleep(1000);
        index = random.nextInt(parcelsList.size());
        manifestParcelDetails.clickDeletePackageByIndex(index);
        //sleep(1000);
        actionBarPageObjects.clickBackButton();
    }



    @AfterClass(alwaysRun = true)
    public void EditParcelAfterClass()
    {
        System.out.println("After Edit Parcel Class");
        //closeApp();
    }
}
