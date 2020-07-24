package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.*;
import utils.RedXBaseClass;

import java.util.*;


public class EditParcel extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private ParcelsPageObjects.ActionBarPageObjects actionBarPageObjects;
    private ParcelsPageObjects.OrderStatusPageObjects orderStatusPageObjects;
    private ParcelsPageObjects.ParcelsManifestList parcelsManifestList;
    private ManifestParcelDetails manifestParcelDetails;
    private ManifestParcelDetails.EditPackageModule editPackageModule;
    private Random random;


    public void pageInitializer()
    {
        homePageObjects = new HomePageObjects();
        actionBarPageObjects = new ParcelsPageObjects().new ActionBarPageObjects();
        orderStatusPageObjects = new ParcelsPageObjects().new OrderStatusPageObjects();
        parcelsManifestList = new ParcelsPageObjects().new ParcelsManifestList();
        manifestParcelDetails = new ManifestParcelDetails();
        editPackageModule = manifestParcelDetails.new EditPackageModule();
        random = new Random();
    }


    @BeforeClass(alwaysRun = true)
    public void editParcelBeforeClass()
    {
        System.out.println("Before Edit Parcel Class");
        androidDriver = getBaseDriver();
        pageInitializer();
    }



    @DataProvider(name = "getEditParcelData")
    public Object[][] getEditParcelData(){
        return new Object[][]{
                {"Name","01401122188","300","500","Address","Gulshan","Invoice","Instruction"}
        };
    }



    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_REGRESSION},
            description = "Verifies Edit Parcel Module",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            dataProvider = "getEditParcelData")
    public void verifyEditParcelModule(String name, String phone, String cash, String sellingPrice, String address, String area,
                                       String invoiceNumber, String instruction)
    {
        int index;
        List<WebElement> parcelsList;
        System.out.println("Edit Parcel Details");
        homePageObjects.clickViewParcelUpdatesModule();
        //sleep(2000);
        orderStatusPageObjects.clickInProgressParcelsTab();
        parcelsList = parcelsManifestList.setParcelsList();
        //sleep(1000);
        index = random.nextInt(parcelsList.size());
        parcelsManifestList.clickParcelByIndex(index);
        //sleep(1000);
        parcelsList = manifestParcelDetails.setPackagesList();
        //sleep(1000);
        index = random.nextInt(parcelsList.size());
        manifestParcelDetails.clickEditPackageByIndex(index);
        //sleep(2000);
        editPackageModule.editParcel(name,phone,cash,sellingPrice,address,area,invoiceNumber,instruction);
        manifestParcelDetails.clickBackButton();
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
