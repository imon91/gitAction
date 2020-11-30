package com.shopf.tests.IssuesAutomation;

import coreUtils.*;
import org.json.simple.parser.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import testData.*;
import utils.*;
import java.io.*;
import java.util.*;
import static utils.RedXWebBaseClass.*;

public class SAPPanelAutomation {

    private WebDriver driver;
    private SAPPanelPageObject sapPanelPageObject;
    private ReadJSONFileRedX readJSONFileRedX;
    private RedXServiceRequestLayer redXServiceRequestLayer;

    @BeforeSuite(alwaysRun = true)
    public void BeforeSuite() throws Exception{
        System.out.println("SAP panel automation BeforeSuite is called");
        driver = getBaseDriver();
        browserMaximize();
        setImplicitWait(10);
        driver.get(getWebBaseUrl());
    }

    private void setImplicitWait(int i) {
    }

    @BeforeClass(alwaysRun = true)
    public void authenticationTestsBeforeClass(){
        System.out.println("SAP PanelAutomation before class was called");
        sapPanelPageObject = new SAPPanelPageObject(driver);
        redXServiceRequestLayer = new RedXServiceRequestLayer();
        readJSONFileRedX = redXServiceRequestLayer.getControlOverReadJSONFileRedX();
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies Authentication With Valid Credentials",
            priority = 1)
    public void verifyAuthenticationWithValidCredentials() throws InterruptedException {
        System.out.println("Verify Authentication with valid credentials was called");
        sapPanelPageObject.enterAndClickMobileNoText("01401122188");
        sapPanelPageObject.enterAndClickOTPText("6666");
    }

    @Test(groups = CoreConstants.GROUP_SMOKE,
            description = "Verifies receving parcels",
            priority = 2)
    public void verifyReceiving501ThParcel() throws InterruptedException, IOException, ParseException {
        System.out.println("Verify receiving parcels");
        sapPanelPageObject.clickOnLogisticsModule();
        sapPanelPageObject.clickOnReceiveIcon();
        sleep(1000);
        sapPanelPageObject.clickOnReconcileLaterButton();
        sapPanelPageObject.clickHubDropDown();
        sapPanelPageObject.clickOnTejgaonHub();
        sapPanelPageObject.clickOnViewResellerTab();

        for(int i=0 ; i<2000 ; i++)
        {
            List<String> parcelIDs = readJSONFileRedX.getParcelID();
            String parcelID = parcelIDs.get(i);
            sapPanelPageObject.enterAndApplyParcelID(parcelID);
        }

    }

    @AfterClass(alwaysRun = true)
    public void sapPanelTestsAfterClass(){
        System.out.println(" afterClass was called");
        sleep(1200000);
    }

    @AfterSuite(alwaysRun = true)
    public void AfterSuite(){
        System.out.println("SAP AfterSuite is called");
        quitBaseDriver();
    }

}
