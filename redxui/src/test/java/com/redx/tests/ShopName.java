package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.util.*;


public class ShopName extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private HomePageObjects.ChooseShopModule chooseShopModule;
    private Random random;

        public void pageInitializer()
        {
            homePageObjects = new HomePageObjects();
            chooseShopModule = homePageObjects.new ChooseShopModule();
            random = new Random();
        }

        @BeforeClass(alwaysRun = true)
        public void shopNameBeforeClass() throws Exception
        {
            System.out.println("Before Shop Name Class");
            androidDriver = getBaseDriver();
            pageInitializer();
        }

        @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
                description = "Verify Shop Name",
                dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
        public void verifyShopName()
        {
            System.out.println("Verifying Shop Name");
            homePageObjects.clickChooseShopModule();
            chooseShopModule.selectShopByText("SHOPUP_TEST");
            try {
                Assert.assertEquals(homePageObjects.getCurrentShopName(),PropertyReader.getValueOfKey(PropertyReader.Keys.SHOP_NAME));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @AfterClass(alwaysRun = true)
        public void afterChangeLanguageClass()
        {
            System.out.println("After Shop Name Class");
        }

}
