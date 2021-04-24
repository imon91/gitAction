package com;

import coreUtils.CoreConstants;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class AuthenticationTests extends DeliveryAgentsBaseClass {

    private LoginPageObjects loginPageObjects;
    private ProfilePageObjects profilePageObjects;

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        loginPageObjects = new LoginPageObjects();
        profilePageObjects = new ProfilePageObjects();
    }

    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        return new Object[][]{
                {"8801935019282","6666"}
        };
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE}, dataProvider = "getUserAuthenticationData")
    public void performAuthentication(String mobileNumber,String otp)
    {
        System.out.println("Verifying Authentication");
        System.out.println("Mobile Number : " + mobileNumber);
        System.out.println("Otp : " + otp);
        loginPageObjects.performAuthentication(mobileNumber,otp);
        String title = profilePageObjects.getTitleValue();
        Assert.assertEquals(title,"Profile");
    }
}