package integrationTests;
import coreUtils.CoreConstants;
import pageObjects.BottomNavigationObjects;
import pageObjects.CreateCollectionBottomSheetObjects;
import pageObjects.LoginPageObjects;
import pageObjects.MyShopPageObjects;
import utils.BaseClass;
import utils.CommonUtils;
import utils.DriverControls;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.Set;

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
        androidDriver = getDriver(null,null);

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

        androidDriver.context(CoreConstants.SHOP_UP_RESELLER_WEB_VIEW);

        new MyShopPageObjects(androidDriver).clickOnCreateNewCollectionButton();

        new CreateCollectionBottomSheetObjects(androidDriver).
                performAddCollection("TestingCollection"+new Random().nextInt(5));

        androidDriver.quit();
        //new CreateCollectionBottomSheetObjects(androidDriver).getTheErrorMessage();


    }


}
