package regressionTest;

import com.shopf.tests.*;
import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.BottomNavigationObjects;
import pageObjects.HomePageObjects;
import pageObjects.MyBagPageObjects;
import testData.ReadJSONFile;
import utils.MyActions;
import utils.PropertyReader;
import utils.ServiceRequestLayer;
import utils.WebAppBaseClass;

import java.util.Random;

public class MyBag extends WebAppBaseClass {


    MyActions myActions;
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private BottomNavigationObjects bottomNavigationObjects;
    private MyBagPageObjects myBagPageObjects;
    private MyBagPageObjects.ItemContainer itemContainer;
    private String suiteName;
    private SoftAssert softAssert;
    private Random random;
    private ServiceRequestLayer serviceRequestLayer;
    private Authentication authentication;
    private ReadJSONFile readJSONFile;
    private String app;

    @BeforeSuite(alwaysRun = true)
    public void resellerAndroidBeforeSuite() throws Exception{
        System.out.println("resellerAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
        androidDriver.get(getWAPBaseUrl()+"r");
        try{
            PropertyReader.flushDynamicData();
        }catch (Exception e){
            System.out.println("Exception at SmokeBeforeSuite : flushDynamicData");
        }
        serviceRequestLayer = new ServiceRequestLayer();
//        serviceRequestLayer.getControlOverAuthentication()
//                .performAuthentication();
    }



    @BeforeClass(alwaysRun = true)
    public void BeforeClass() throws Exception {
        System.out.println("beforeClass is called");
        bottomNavigationObjects = new BottomNavigationObjects(androidDriver);
        myBagPageObjects = new MyBagPageObjects(androidDriver);
        itemContainer = myBagPageObjects.new ItemContainer(androidDriver);
        homePageObjects = new HomePageObjects(androidDriver);
        myActions = new MyActions();
        softAssert = new SoftAssert();
        random = new Random();
        authentication= new Authentication();
        serviceRequestLayer = new ServiceRequestLayer();
        readJSONFile = serviceRequestLayer.getControlOverReadJSONFile();
        app = System.getProperty(BuildParameterKeys.KEY_APP);
        setImplicitWait(30);
    }



    @BeforeTest(alwaysRun = true)
    @Parameters("suite")
    public void searchModuleTests(String suiteNameFromXMLFile)
    {
        suiteName = suiteNameFromXMLFile;
    }


    @Test(groups = {"Search.Authentication with valid credential",
            CoreConstants.GROUP_REGRESSION},
            description = "Authentication for regression testCases in Search",
            priority = 1)
    public void authenticationWithValidCredential() throws Exception {
        homePageObjects.clickOnShopUpLogo();
        bottomNavigationObjects.clickOnBottomBarMyShopIcon();
        sleep(4000);
        homePageObjects.login("01877755590","666666");
        myBagPageObjects.createItemInMyBag(63382);
    }


    @AfterClass(alwaysRun = true)
    public void myBagAfterClass(){
        System.out.println("AfterClass Is Called");
        closeApp();
    }



    @AfterSuite(alwaysRun = true)
    public void AfterSuite(){
        System.out.println("AfterSuite Is Called");
        quitBaseDriver();
    }

}
