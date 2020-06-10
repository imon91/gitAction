package smokeTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.*;
import pageObjects.*;
import utils.BaseClass;
import utils.CommonUtils;
import utils.DriverControls;
import java.util.Random;

public class SmokeTests extends BaseClass{

    private AndroidDriver<AndroidElement> androidDriver;
    private DriverControls driverControls;
    private LoginPageObjects loginPageObjects;
    private BottomNavigationObjects bottomNavigationObjects;
    private ActionBarObjects actionBarObjects;
    private RightNavigationDrawer rightNavigationDrawer;
    private MyShopPageObjects myShopPageObjects;
    private String host;


    @BeforeSuite
    public void smokeSetUp() throws Exception{
        host = System.getProperty("Host");
        if(host.equalsIgnoreCase("local")){
            // 1 : Start Appium Service
            startService();
            androidDriver = getDriver(null,null);
        }else {
            // Call a method to supply data to getDriver
            androidDriver = getDriver("Samsung Galaxy S10e","9.0");
        }
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
         // Verification Step Pending

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
        if(host.equalsIgnoreCase("local")){
            stopService();
        }
    }

}
