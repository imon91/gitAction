package com;

import com.gurock.testrail.*;
import coreUtils.CoreConstants;
import ioServices.FileServices;
import org.json.simple.JSONObject;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class AuthenticationTests extends DeliveryAgentsBaseClass {

    private LoginPageObjects loginPageObjects;
    private ProfilePageObjects profilePageObjects;
    private FileServices fileServices;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        loginPageObjects = new LoginPageObjects();
        profilePageObjects = new ProfilePageObjects();
        fileServices = new FileServices();
    }

    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        JSONObject jsonObject = fileServices.readJsonFile(DeliveryAgentsAppFileUtils.authenticationDataJsonFilePath);
        return new Object[][]{
                {jsonObject.get("phoneNumber"), jsonObject.get("otp")}};
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, AuthenticationTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "881")
    @Test(groups = {CoreConstants.GROUP_SMOKE}, priority = 2)
    public void verifyAuthentication()
    {
        System.out.println("Verifying Authentication");
        Object[][] testData = getUserAuthenticationData();
        String mobileNumber = (String) testData[0][0];
        String otp = (String) testData[0][1];
        System.out.println("Mobile Number : " + mobileNumber);
        System.out.println("Otp : " + otp);
        loginPageObjects.performAuthentication(mobileNumber,otp);
        String title = profilePageObjects.getTitleValue();
        Assert.assertEquals(title,"Profile");
    }
}