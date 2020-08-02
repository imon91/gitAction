package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.RedXBaseClass;

import java.util.*;

public class ParcelDetails extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private CommonPageObjects commonPageObjects;
    private HomePageObjects homePageObjects;
    private ParcelsPageObjects.ActionBarPageObjects actionBarPageObjects;
    private ParcelsPageObjects.OrderStatusPageObjects orderStatusPageObjects;
    private ParcelsPageObjects.ParcelsManifestList parcelsManifestList;
    private ManifestParcelDetails manifestParcelDetails;
    private ManifestParcelDetails.PackageDetailsModule packageDetailsModule;
    private Random random;


    public void pageInitializer()
    {
        commonPageObjects = new CommonPageObjects();
        homePageObjects = new HomePageObjects();
        actionBarPageObjects = new ParcelsPageObjects().new ActionBarPageObjects();
        orderStatusPageObjects = new ParcelsPageObjects().new OrderStatusPageObjects();
        parcelsManifestList = new ParcelsPageObjects().new ParcelsManifestList();
        manifestParcelDetails = new ManifestParcelDetails();
        packageDetailsModule = manifestParcelDetails.new PackageDetailsModule();
        random = new Random();
    }


    @BeforeClass(alwaysRun = true)
    public void parcelDetailsBeforeClass()
    {
        System.out.println("Before Parcel Details Class");
        androidDriver = getBaseDriver();
        pageInitializer();
    }


    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_REGRESSION},
      dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            description = "Verifies Parcel Details Functionality")
    public void verifyParcelDetailsModule()
    {
        int index;
        List<WebElement> parcelsList;
        System.out.println("Verify Parcel Details");
        homePageObjects.clickViewParcelUpdatesModule();
        Assert.assertEquals(commonPageObjects.getPageTitle(),"Parcels");
        sleep(1000);
        orderStatusPageObjects.clickFailedParcelsTab();
        parcelsList = parcelsManifestList.setParcelsList();
        sleep(1000);
        index = random.nextInt(parcelsList.size());
        parcelsManifestList.clickParcelByIndex(index);
        sleep(2000);
        parcelsList = manifestParcelDetails.setPackagesList();
        sleep(1000);
        index = random.nextInt(parcelsList.size());
        manifestParcelDetails.clickDetailsByIndex(index);
        packageDetailsModule.getDetails(null);
        manifestParcelDetails.clickBackButton();
        sleep(1000);
        actionBarPageObjects.clickBackButton();
    }



    @AfterClass(alwaysRun = true)
    public void editParcelAfterClass()
    {
        System.out.println("After Parcel Details Class");
        //closeApp();
    }
}
