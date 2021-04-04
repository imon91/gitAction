package com.shopf.tests.Authentication;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import services.responseModels.redxModels.PricingModel;
import utils.*;

import java.io.File;
import java.util.Random;

public class CoverageAreaPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private CoverageAreaPageObjects coverageAreaPageObjects;

    private GetRedxApiResponse getRedxApiResponse;
    private PricingModel pricingModel;
    private Random random;
    private String cookie;
    private String zone;
    private int zoneIndex;
    private int areaIndex;
    private String host;

    @BeforeSuite(alwaysRun = true)
    public void redXWebBeforeSuite() throws  Exception
    {
        System.out.println("RedX Web Before Suite");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getWebBaseUrl());
        driver.manage().window().maximize();
    }

    @BeforeClass(alwaysRun = true)
    public void coverageAreaPageTestsBeforeClass() throws Exception
    {
        System.out.println("Coverage Area Page Tests Before Class");
        host = System.getProperty(BuildParameterKeys.KEY_HOST);
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        coverageAreaPageObjects = new CoverageAreaPageObjects(driver);

        random = new Random();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");
        pricingModel = getRedxApiResponse.pricingListGetCall();

        System.out.println("Verify Authentication with valid credentials was called");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        actionBarObjects.clickOnCoverageAreaDropDown();

        areaIndex = random.nextInt(20);
        System.out.println("Index : " + areaIndex);
    }

    @BeforeMethod(alwaysRun = true)
    public void homePageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Zone DropDown Functionality",
            priority = 1 )
    public void verifyZoneDropDownFunctionality()
    {
        System.out.println("Verifying Zone DropDown Functionality");
        zone = coverageAreaPageObjects.chooseDropDownOption();
        zoneIndex = getRedxApiResponse.getZoneIndex(zone);
        String zoneTitle = coverageAreaPageObjects.getZoneTitle();
        System.out.println("Selected Zone : " + zone);
        System.out.println("Title : " + zoneTitle);
        Assert.assertEquals(zoneTitle,zone);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Search Bar Functionality",
            priority = 2 )
    public void verifySearchBarFunctionality()
    {
        System.out.println("Verifying Search Bar Functionality");
        String area = getRedxApiResponse.getRandomArea(zone);
        coverageAreaPageObjects.enterAreaInput(area);
        String areaValue = coverageAreaPageObjects.getAreaValue(1);
        driver.navigate().refresh();
        System.out.println("Area Search Term : " + area);
        System.out.println("Area Result : " + areaValue);
        Assert.assertTrue(areaValue.contains(area));
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Button Functionality",
            priority = 3 )
    public void verifyDownloadButtonFunctionality()
    {
        System.out.println("Verifying Download Button Functionality");
        zone = coverageAreaPageObjects.chooseDropDownOption();
        zoneIndex = getRedxApiResponse.getZoneIndex(zone);

        File directory = new File(RedXWebFileRouters.downloadsPath);
        File[] dirContains = directory.listFiles();
        int files1 = dirContains.length;
        System.out.println("Current Files : " + files1);

        coverageAreaPageObjects.clickDownloadButton();

        if(host.equalsIgnoreCase("local"))
        {
            sleep(3000);
            File[] dirContain = directory.listFiles();
            int files2 = dirContain.length;
            System.out.println("Files After Download : " + files2);
            Assert.assertEquals(files2,files1+1);
        }
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify District Value Functionality",
            priority = 4 )
    public void verifyDistrictValue()
    {
        System.out.println("Verifying District Value Functionality");
        String uiValue = coverageAreaPageObjects.getDistrictValue(areaIndex);
        String apiValue = pricingModel.getZones().get(zoneIndex).getAREAS().get(areaIndex-1).getDistrict().getNAME();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Area Value Functionality",
            priority = 5 )
    public void verifyAreaValue()
    {
        System.out.println("Verifying Area Value Functionality");
        String uiValue = coverageAreaPageObjects.getAreaValue(areaIndex);
        String apiValue = pricingModel.getZones().get(zoneIndex).getAREAS().get(areaIndex-1).getNAME();
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Post Code Value Functionality",
            priority = 6 )
    public void verifyPostCodeValue()
    {
        System.out.println("Verifying Post Code Value Functionality");
        String uiValue = coverageAreaPageObjects.getPostCodeValue(areaIndex);
        String apiValue = String.valueOf(pricingModel.getZones().get(zoneIndex).getAREAS().get(areaIndex-1).getPOST_CODE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Home Delivery Value Functionality",
            priority = 7 )
    public void verifyHomeDeliveryValue()
    {
        System.out.println("Verifying Home Delivery Value Functionality");
        String uiValue = coverageAreaPageObjects.getHomeDeliveryValue(areaIndex);
        Boolean apiValue = pricingModel.getZones().get(zoneIndex).getAREAS().get(areaIndex-1).isIS_HOME_DELIVERY();
        String assertValue;
        if(apiValue.equals(Boolean.TRUE))
            assertValue = "Yes";
        else assertValue = "No";
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Lockdown Value Functionality",
            priority = 8 )
    public void verifyLockdownValue()
    {
        System.out.println("Verifying Lockdown Value Functionality");
        String uiValue = coverageAreaPageObjects.getLockdownValue(areaIndex);
        Boolean apiValue = pricingModel.getZones().get(zoneIndex).getAREAS().get(areaIndex-1).isIS_LOCKED_DOWN();
        String assertValue;
        if(apiValue.equals(Boolean.TRUE))
            assertValue = "Yes";
        else assertValue = "No";
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,assertValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Charge One Kg Value Functionality",
            priority = 9 )
    public void verifyChargeOneKgValue()
    {
        System.out.println("Verifying Charge One Kg Value Functionality");
        String uiValue = coverageAreaPageObjects.getChargeOneKgValue(areaIndex);
        String apiValue = String.valueOf(pricingModel.getZones().get(zoneIndex).getPRICING().getSHOPUP_KG1_PRICE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Charge Two Kg Value Functionality",
            priority = 10 )
    public void verifyChargeTwoKgValue()
    {
        System.out.println("Verifying Charge Two Kg Value Functionality");
        String uiValue = coverageAreaPageObjects.getChargeTwoKgValue(areaIndex);
        String apiValue = String.valueOf(pricingModel.getZones().get(zoneIndex).getPRICING().getSHOPUP_KG2_PRICE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Charge Three Kg Value Functionality",
            priority = 11 )
    public void verifyChargeThreeKgValue()
    {
        System.out.println("Verifying Charge Three Kg Value Functionality");
        String uiValue = coverageAreaPageObjects.getChargeThreeKgValue(areaIndex);
        String apiValue = String.valueOf(pricingModel.getZones().get(zoneIndex).getPRICING().getSHOPUP_KG3_PRICE());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Cod Charge Value Functionality",
            priority = 12 )
    public void verifyCodChargeValue()
    {
        System.out.println("Verifying Cod Charge Value Functionality");
        String uiValue = coverageAreaPageObjects.getCodChargeValue(areaIndex);
        String apiValue = String.valueOf(pricingModel.getZones().get(zoneIndex).getPRICING().getSHOPUP_COD());
        System.out.println("Value in UI : " + uiValue);
        System.out.println("Value in API : " + apiValue);
        Assert.assertEquals(uiValue,apiValue);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pagination Pages Functionality",
            priority = 13)
    public void verifyPaginationPagesFunctionality()
    {
        System.out.println("Verifying Pagination Pages Functionality");
        int page[] = coverageAreaPageObjects.clickPageIcon();
        Assert.assertEquals(page[1],page[0]);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pagination Next Page Functionality",
            priority = 14)
    public void verifyPaginationNextPageFunctionality()
    {
        System.out.println("Verifying Pagination Next Page Functionality");
        System.out.println("Active Page : " + coverageAreaPageObjects.getActivePage());
        coverageAreaPageObjects.clickNextPageIcon();
        System.out.println("Current Active Page : " + coverageAreaPageObjects.getActivePage());
        Assert.assertEquals(coverageAreaPageObjects.getActivePage(), 2);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Pagination Functionality",
            priority = 15)
    public void verifyPaginationPreviousPageFunctionality()
    {
        System.out.println("Verifying Pagination Previous Page Functionality");
        System.out.println("Active Page : " + coverageAreaPageObjects.getActivePage());
        coverageAreaPageObjects.clickPreviousPageIcon();
        System.out.println("Current Active Page : " + coverageAreaPageObjects.getActivePage());
        Assert.assertEquals(coverageAreaPageObjects.getActivePage(),1);
    }

    @AfterSuite(alwaysRun = true)
    public void coverageAreaPageTestsAfterSuite()
    {
        System.out.println("Coverage Area Page Tests After Suite");
        driver.quit();
    }
}
