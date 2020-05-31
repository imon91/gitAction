package com.shopup.resellerAndroid.integrationTests;

import com.shopup.resellerAndroid.pageObjects.BottomNavigationObjects;
import com.shopup.resellerAndroid.pageObjects.CreateCollectionBottomSheetObjects;
import com.shopup.resellerAndroid.pageObjects.LoginPageObjects;
import com.shopup.resellerAndroid.pageObjects.MyShopPageObjects;
import com.shopup.utils.BaseClass;
import com.shopup.utils.CommonUtils;
import com.shopup.utils.Constants;
import com.shopup.utils.DriverControls;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.windows.PressesKeyCode;
import javafx.scene.input.KeyCode;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class VerifyAddNewCollectionToMyShop extends BaseClass {

    private AndroidDriver<AndroidElement> androidDriver;
    private DriverControls driverControls;
    private LoginPageObjects loginPageObjects;
    private BottomNavigationObjects bottomNavigationObjects;
    private MyShopPageObjects myShopPageObjects;

    @Test
    public void verifyAddCollection() throws Exception{

        // 1 : Start Appium Service
        //startService();

        // 2 : Get Driver
        androidDriver = getDriver();

        // 3 : Set DriverControls
        driverControls = new DriverControls(androidDriver);

        driverControls.setImplicitWait(10);

        new LoginPageObjects(androidDriver).performAuthentication("1877755590","666666");


        new BottomNavigationObjects(androidDriver).clickOnBottomBarMyShopIcon();

        CommonUtils.threadSleep(1000);
        // Context Switching
        Set<String> contextNames = androidDriver.getContextHandles();
        for(String contextName : contextNames ){
            System.out.println(contextName);
        }

        androidDriver.context(Constants.SHOP_UP_RESELLER_WEB_VIEW);

        new MyShopPageObjects(androidDriver).clickOnCreateNewCollectionButton();

        new CreateCollectionBottomSheetObjects(androidDriver).
                performAddCollection("TestingCollection"+new Random().nextInt(5));

        androidDriver.quit();
        //new CreateCollectionBottomSheetObjects(androidDriver).getTheErrorMessage();


    }


}
