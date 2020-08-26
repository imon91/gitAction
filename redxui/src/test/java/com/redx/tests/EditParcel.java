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


public class EditParcel extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private ParcelsPageObjects.ActionBarPageObjects actionBarPageObjects;
    private ParcelsPageObjects.OrderStatusPageObjects orderStatusPageObjects;
    private ParcelsPageObjects.ParcelsManifestList parcelsManifestList;
    private ParcelsPageObjects.DateFilterPageObjects dateFilterPageObjects;
    private ManifestParcelDetails manifestParcelDetails;
    private ManifestParcelDetails.EditPackageModule editPackageModule;
    private Random random;


    public void pageInitializer()
    {
        homePageObjects = new HomePageObjects();
        actionBarPageObjects = new ParcelsPageObjects().new ActionBarPageObjects();
        orderStatusPageObjects = new ParcelsPageObjects().new OrderStatusPageObjects();
        parcelsManifestList = new ParcelsPageObjects().new ParcelsManifestList();
        dateFilterPageObjects = new ParcelsPageObjects().new DateFilterPageObjects();
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
        refreshPage();
    }



    @DataProvider(name = "getEditParcelData")
    public Object[][] getEditParcelData(){
        return new Object[][]{
                {"Name","01401122188","300","500","Address","Kalabagan","Invoice","Instruction"}
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
        String assertVariable = null;
        String parcelStatus = null;
        List<WebElement> parcelsList;

        System.out.println("Edit Parcel Details");
        homePageObjects.clickViewParcelUpdatesModule();
        Assert.assertEquals(actionBarPageObjects.getPageTitle(),"Parcels");

        dateFilterPageObjects.chooseMonthByText("Aug, 2020");
        orderStatusPageObjects.clickInProgressParcelsTab();

        parcelsList = parcelsManifestList.setParcelsList();
        if(parcelsList.size()!=0)
        {
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
            if(parcelsList.size()!=0)
            {
                index = random.nextInt(parcelsList.size());
                manifestParcelDetails.clickEditPackageByIndex(index);
                try
                {
                    assertVariable = PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_ID);
                    parcelStatus = PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_STATUS);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Parcel Details cannot be read from Properties");
                }
                if (parcelStatus.equals("PICKUP PENDING"))
                {
                    Assert.assertEquals(actionBarPageObjects.getPageTitle(), assertVariable);
                    editPackageModule.editParcel(name, phone, cash, sellingPrice, address, area, invoiceNumber, instruction);
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
    public void EditParcelAfterClass()
    {
        System.out.println("After Edit Parcel Class");
        //closeApp();
    }
}
