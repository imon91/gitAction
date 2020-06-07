package smokeTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import utils.BaseClass;
import utils.CommonUtils;
import utils.DriverControls;
import java.util.Random;

public class SmokeTests extends BaseClass {

    private AndroidDriver<AndroidElement> androidDriver;
    private WebDriver webDriver;
    private DriverControls driverControls;
    private LoginPageObjects loginPageObjects;
    private BottomNavigationObjects bottomNavigationObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private MyShopPageObjects myShopPageObjects;


    @BeforeSuite
    public void smokeSetUp() throws Exception{

        // 1 : Start Appium Service
        startService();
        // 2 : Get Driver
        androidDriver = getDriver();
        //String data = androidDriver.startRecordingScreen();
//        if(data!=null){
//            System.out.println("Recording Started Successfully");
//            System.out.println(data);
//        }else {
//            System.out.println("Recording : Error");
//        }
        // 3 : Set DriverControls
        driverControls = new DriverControls(androidDriver);
        driverControls.setImplicitWait(10);

        loginPageObjects = new LoginPageObjects(androidDriver);
        bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
        actionBarObjects = new ActionBarObjects(androidDriver);
        rightNavigationDrawer = new RightNavigationDrawer(androidDriver);
        myShopPageObjects = new MyShopPageObjects(androidDriver);
    }

    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        return new Object[][]{
                {"01877755590","666666"}
        };
    }


    @Test(priority = 1,dataProvider = "getUserAuthenticationData")
    public void verifyAuthentication(String mobileNumber,String otp){
         loginPageObjects.performAuthentication(mobileNumber,otp);
         // Verification Step Pending : Go to My

    }


    @Test(priority = 2,dependsOnMethods = {"verifyAuthentication"})
    public void verifyAddingNewCollection(){
        Random random = new Random();
        //int decider = random.nextInt(4);
        int decider = 3;
        System.out.println("Decider is : "+decider);
        if(decider!=4){
            bottomNavigationObjects.clickOnBottomBarMyShopIcon();
        }else {
            actionBarObjects.clickOnUserProfileImageButton();
            rightNavigationDrawer.clickOnItemMyShop();
        }
        // Switch To WebView
       androidDriver =  CommonUtils.getControlOnWeb(androidDriver);
        if(androidDriver!=null){
            String collectionName = myShopPageObjects.createNewCollection();
            System.out.println("New collection created is : "+collectionName);
            /* Verify the Added Collection Part By Calling
            / the Api that gives List of collections for this user*/

        }else {
            System.out.println("AndroidDriver at WebContext is Null");
        }
    }


    @Test
    public void verifyAddingItemsToCollectionThoughPLP(){
        // Yet to build.
    }



    @AfterSuite
    public void smokeTearDown(){
        androidDriver.quit();
        stopService();
    }

}