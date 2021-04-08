package com.shopf.tests.authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.SAPPanelPageObject;
import services.commerceMethods.GetAuthenticationApiResponse;
import utils.SapBaseClass;

public class LoginTests extends SapBaseClass {

    private WebDriver driver;
    private GetAuthenticationApiResponse getAuthenticationApiResponse;
    private SAPPanelPageObject sapPanelPageObject;


    @BeforeSuite(alwaysRun = true)
    public void wmsBeforeSuite() throws Exception {
        getAuthenticationApiResponse = new GetAuthenticationApiResponse(CoreConstants.MODULE_SAP_UI);
        getAuthenticationApiResponse.performAuthentication();
        System.out.println("SapBeforeSuite is called");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getSapBaseUrl());
        setImplicitWait(10000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        driver.manage().window().maximize();
        //ScreenRecorder.startRecording("");
    }


    @BeforeClass(alwaysRun = true)
    public void loginBeforeClass() {
        System.out.println("Login Before Class is called");
        sapPanelPageObject = new SAPPanelPageObject(driver);
    }


    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData() {
        return new Object[][]{
                {"enter_email", "enter_password"}
        };
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION,
            CoreConstants.GROUP_FUNCTIONAL,
            "Login.verifyAuthenticationWithValidCredentials"},
            description = "Verify Authentication with Valid Credentials",
            dataProvider = "getUserAuthenticationData"
    )
    public void verifyAuthenticationWithValidCredentials(String email, String password) throws Exception {
        System.out.println("verifyAuthentication is called");
        sleep(10000);
        sapPanelPageObject.enterPhoneNumberInput("01401122188");
        sapPanelPageObject.enterOtpInput("6666");
        sapPanelPageObject.clickLoginButton();
    }

    @AfterClass(alwaysRun = true)
    public void loginAfterClass() {
        System.out.println("LoginAfterClass Is Called");
    }


    @AfterSuite(alwaysRun = true)
    public void wmsAfterSuite() throws Exception {
        System.out.println("SapAfterSuite Is Called");
//        ScreenRecorder.stopRecording();
        quitBaseDriver();
    }
}
