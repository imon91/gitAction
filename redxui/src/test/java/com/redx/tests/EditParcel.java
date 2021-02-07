package com.redx.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;
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
    private SettingsPageObjects settingsPageObjects;
    private Authentication authentication;
    private ChangeLanguage changeLanguage;
    private HomePageObjects.ChooseShopModule chooseShopModule;


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
        settingsPageObjects = new SettingsPageObjects();
        authentication = new Authentication();
        changeLanguage= new ChangeLanguage();
        chooseShopModule = homePageObjects. new ChooseShopModule();
    }

    @BeforeSuite(alwaysRun = true)
    public void redXAndroidBeforeSuite()
    {
        System.out.println("redXAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
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
                {"Name","01401122188","300","500","Address","Kalabagan","Invoice","Instruction"}
        };
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
        sleep(1000);
        homePageObjects.clickChooseShopModule();
        chooseShopModule.selectShopByText("ashok shops");
        sleep(2000);
    }



    @Test(  groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_REGRESSION},
            description = "Verifies Edit Parcel Module",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"},
            dataProvider = "getEditParcelData")
    public void verifyEditParcelModule(String name, String phone, String cash, String sellingPrice, String address, String area,
                                       String invoiceNumber, String instruction)
    {
        refreshPage();
        int index;
        String assertVariable = null;
        String parcelStatus = null;
        List<WebElement> parcelsList;

        System.out.println("Edit Parcel Details");
        homePageObjects.clickViewParcelUpdatesModule();
        Assert.assertEquals(actionBarPageObjects.getPageTitle(),"Parcels");

        dateFilterPageObjects.chooseMonthByText("Oct, 2020");
        orderStatusPageObjects.clickInProgressParcelsTab();

        parcelsList = parcelsManifestList.setParcelsList();
        if(parcelsList.size()!=0)
        {
            index = random.nextInt(parcelsList.size());
            parcelsManifestList.clickParcelByIndex(index);
            sleep(1000);
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
                sleep(1000);
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
            sleep(500);
            actionBarPageObjects.clickBackButton();
        } else {
            System.out.println("No Parcels Found");
            actionBarPageObjects.clickBackButton();
        }
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verifies Edit Parcel Module",
            dataProvider = "getEditParcelData",
    priority = 3)
    public void verifyEditedParcelUpdating(String name, String phone, String cash, String sellingPrice, String address, String area,
                                           String invoiceNumber, String instruction) {
        System.out.println("Edited Parcel Updating was called");
        refreshPage();
        String assertVariable = null;
        String parcelStatus = null;
        List<String> editingData = new ArrayList<>();
        List<String> dataFromUI = new ArrayList<>();

        sleep(3000);
        homePageObjects.clickViewParcelUpdatesModule();
        orderStatusPageObjects.clickInProgressParcelsTab();
        List<WebElement> parcelsList;
        parcelsList = parcelsManifestList.setParcelsList();
        if (parcelsList.size() != 0) {
            parcelsManifestList.clickParcelByIndex(0);
            sleep(1000);
            try {
                assertVariable = PropertyReader.getValueOfKey("PARCEL_DATE");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Parcel Date cannot be read from Properties");
            }
            Assert.assertEquals(actionBarPageObjects.getPageTitle(), assertVariable);

            parcelsList = manifestParcelDetails.setPackagesList();
            if (parcelsList.size() != 0) {
                manifestParcelDetails.clickEditPackageByIndex(0);
                sleep(1000);
                try {
                    assertVariable = PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_ID);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Parcel Details cannot be read from Properties");
                }
                Assert.assertEquals(actionBarPageObjects.getPageTitle(), assertVariable);
                editingData.add(name);
                editingData.add(phone);
                editingData.add(cash);
                editingData.add(sellingPrice);
                editingData.add(address);
                editingData.add(invoiceNumber);
                editingData.add(instruction);
                editPackageModule.editParcel(name, phone, cash, sellingPrice, address, area, invoiceNumber, instruction);
                sleep(1000);
                manifestParcelDetails.clickEditPackageByIndex(0);
                sleep(2000);
                dataFromUI = editPackageModule.editedParcelData();
                System.out.println(dataFromUI+","+editingData);
                Assert.assertEquals(dataFromUI, editingData);
            }actionBarPageObjects.clickBackButton();
        }actionBarPageObjects.clickBackButton();
    }

    @Test(groups = {CoreConstants.GROUP_SANITY},
            priority = 4,
            description = "Verifies search functionality in view parcel module")
    public void verifyParcelSearchByMobileNo() {
        System.out.println("Verify search by mobileNo in view parcel module");
        List<WebElement> parcelsList;
        int index;
        String parcelStatus = null;
        homePageObjects.clickViewParcelUpdatesModule();
        orderStatusPageObjects.clickInProgressParcelsTab();
        actionBarPageObjects.clickSearchButton();
        actionBarPageObjects.enterSearchTerm("1401122188");
        actionBarPageObjects.clickSearchButton();
        parcelsList = parcelsManifestList.setParcelsList();
        if (parcelsList.size() != 0) {
            index = random.nextInt(parcelsList.size());
            parcelsManifestList.clickParcelByIndex(index);
        }
        sleep(1000);
        parcelsList = manifestParcelDetails.setPackagesList();
        if (parcelsList.size() != 0) {
            index = random.nextInt(parcelsList.size());
            manifestParcelDetails.clickEditPackageByIndex(index);
            sleep(1000);
            try {
                parcelStatus = PropertyReader.getValueOfKey(PropertyReader.Keys.PARCEL_STATUS);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Parcel Details cannot be read from Properties");
            }
            if (parcelStatus.equals("PICKUP PENDING")) {
                Assert.assertEquals(editPackageModule.editedParcelData().get(1), "01401122188");
            }
        }
    }



    @AfterClass(alwaysRun = true)
    public void EditParcelAfterClass()
    {
        System.out.println("After Edit Parcel Class");
        //closeApp();
    }

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){

        System.out.println("redXAndroidAfterSuite Is Called");
        quitBaseDriver();

    }
}
