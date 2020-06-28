package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import services.commerceMethods.GetCommerceApiResponse;
import utils.*;

import java.util.List;


public class UserProfile extends AndroidBaseClass {


    @Test(groups = {CoreConstants.GROUP_SMOKE})
    public void userProfileSetUp() throws Exception{
        // In @BeforeClass of every TestClass
        // get the control to Current Page
        // getCookies
        AndroidDriver androidDriver = getBaseDriver();
//        new AndroidScriptRouter().getTheControlHere
//                        (AndroidAppConstants.HOME_ACTIVITY,AndroidAppConstants.URL_WISHLIST);
       List data =  new ServiceRequestLayer().
                getControlOverServices().getProductWithValidSize("Shirts");

       System.out.println(data.get(1));


        sleep(5000);
    }
}
