package com.shopf.tests.authentication;

import coreUtils.CoreConstants;
import ioServices.FileServices;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.SAPPanelPageObject;
import services.commerceMethods.GetAuthenticationApiResponse;
import utils.SapBaseClass;
import utils.SapFileUtils;

public class LoginTests extends SapBaseClass {

    private WebDriver driver;
    private SAPPanelPageObject sapPanelPageObject;
    private FileServices fileServices;

    @BeforeClass(alwaysRun = true)
    public void loginBeforeClass() throws Exception
    {
        driver = getBaseDriver();
        System.out.println("Login Before Class is called");
        sapPanelPageObject = new SAPPanelPageObject(driver);
        fileServices = new FileServices();
    }


    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData() {
        JSONObject jsonObject = fileServices.readJsonFile(SapFileUtils.authenticationData);
        return new Object[][]{
                {jsonObject.get("phoneNumber"), jsonObject.get("otp")}};
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY, CoreConstants.GROUP_SLACK_BUG,
            "Login.verifyAuthenticationWithValidCredentials"},
            description = "Verify Authentication with Valid Credentials",
            dataProvider = "getUserAuthenticationData", priority = 2)
    public void verifyAuthenticationWithValidCredentials(String phone, String otp)
    {
        System.out.println("verifyAuthentication is called");
        sapPanelPageObject.performAuthentication(phone,otp);
    }
}
