package IssuesAutomation;

import coreUtils.CoreConstants;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.GetSapApiResponse;
import utils.SapBaseClass;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class sameBulkIdIssueFix extends SapBaseClass {

    private WebDriver driver;
    private WebDriver driver1;
    private WebDriver driver2;
    SAPPanelPageObject sapPanelPageObject;
    DashboardPageObjects dashboardPageObjects;
    ImportParcelPageObjects importParcelPageObjects;
    ReceiveModulePageObjects recieveModulePageObjects;
    DispatchModulePageObjects dispatchModulePageObjects;
    DownloadModulePageObjects downloadModulePageObjects;
    GetSapApiResponse getSapApiResponse;


//    @BeforeSuite(alwaysRun = true)
//    public void sapBeforeSuite() throws Exception {
//        System.out.println("Sap Before Suite is called");
//        driver = getBaseDriver();
//        setImplicitWait(10000);
//        driver.get(getSapBaseUrl());
//        setImplicitWait(10000);
//        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().accept();
//        driver.switchTo().alert().accept();
//        driver.manage().window().maximize();
//        ScreenRecorder.startRecording("");
//    }
//
//
//    @BeforeClass(alwaysRun = true)
//    public void bulkIssueBeforeClass() {
//        System.out.println("Bulk Issue Before Class is called");
//
//        sapPanelPageObject = new SAPPanelPageObject(driver);
//        dashboardPageObjects = new DashboardPageObjects(driver);
//        importParcelPageObjects = new ImportParcelPageObjects(driver);
//        recieveModulePageObjects = new RecieveModulePageObjects(driver);
//        dispatchModulePageObjects = new DispatchModulePageObjects(driver);
//        downloadModulePageObjects = new DownloadModulePageObjects(driver);
//        getSapApiResponse = new GetSapApiResponse(CoreConstants.MODULE_SAP_UI);
//
//        System.out.println("verifyAuthentication is called");
//
//        sapPanelPageObject.performAuthentication("01401122188","6666");
//    }


    @Test
    public void test() throws Exception{
        String nodeUrl = "http://172.168.1.14:4445/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.MAC);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);

        capabilities.merge(chromeOptions);
        driver1 = new RemoteWebDriver(new URL(nodeUrl),capabilities);
        Thread.sleep(3000);
        driver1.quit();
    }

    @Test (groups = {CoreConstants.GROUP_REGRESSION},enabled = false)
    public void verifyBulkIssueFix1() throws Exception
    {
        System.out.println("Sap Before Suite is called in Thread Id : " + Thread.currentThread().getId());
        String nodeUrl = "http://172.168.1.14:4445/wd/hub";

        //System.setProperty("webdriver.chrome.driver","/Users/ramaditya/IdeaProjects/reseller_android_ui_automation/sap/src/main/resources/chromeDrivers/drivers/chromedriver87");
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setPlatform(Platform.MAC);
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("window-size=1200x600");
//        options.merge(capabilities);

        driver1 = new RemoteWebDriver(new URL(nodeUrl),capabilities);
        System.out.println("Control came to Remote Web Driver in Thread Id :" + Thread.currentThread().getId());
//        setImplicitWait(10000);
//        driver1.get(getSapBaseUrl());
        driver1.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        driver1.get("https://sap.shopups1.xyz/");
        System.out.println("Control Came To Sap Pannel in Thread Id :" + Thread.currentThread().getId());
//        setImplicitWait(10000);
        driver1.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        System.out.println(driver1.switchTo().alert().getText());
        driver1.switchTo().alert().accept();
        driver1.switchTo().alert().accept();
        System.out.println("Alert Window Closed in Thread Id :" + Thread.currentThread().getId());
//        ScreenRecorder.startRecording("");

        System.out.println("Bulk Issue Before Class is called in Thread Id : " + Thread.currentThread().getId());

        sapPanelPageObject = new SAPPanelPageObject(driver1);
        dashboardPageObjects = new DashboardPageObjects(driver1);
        importParcelPageObjects = new ImportParcelPageObjects(driver1);
        recieveModulePageObjects = new ReceiveModulePageObjects(driver1);
        dispatchModulePageObjects = new DispatchModulePageObjects(driver1);
        downloadModulePageObjects = new DownloadModulePageObjects(driver1);
        getSapApiResponse = new GetSapApiResponse(CoreConstants.MODULE_SAP_UI);

        System.out.println("verifyAuthentication is called in Thread Id : " + Thread.currentThread().getId());

        sapPanelPageObject.performAuthentication("01401122188","6666");

        String filePath = "/Users/ramaditya/Downloads/shopup-sample.xlsx";
        String shopName = "Bulk Issue Test Shop";
        String shopHubName = "Tejgaon Hub";
        List<String> invoiceNumbers = new ArrayList<String>();
        List<String> parcelIds = new ArrayList<String>();
        String bulkId = new String();
        Boolean[] assertValues = new Boolean[5];
        Boolean trueValue = true;

        System.out.println("Verifying Bulk Issue Fix in Thread Id : " + Thread.currentThread().getId());

        invoiceNumbers = importParcelPageObjects.performImportBulkParcels(filePath,shopName);

        parcelIds = recieveModulePageObjects.performReceiveParcels(invoiceNumbers,shopName,shopHubName);

        bulkId = dispatchModulePageObjects.performDispatchParcels(parcelIds,shopHubName);

        assertValues = downloadModulePageObjects.performVerifyBulkIssue(bulkId, parcelIds.size());

        Assert.assertEquals(assertValues[0],trueValue);
        Assert.assertEquals(assertValues[1],trueValue);
        Assert.assertEquals(assertValues[2],trueValue);
        driver1.quit();
    }

//    @Test(groups = {CoreConstants.GROUP_REGRESSION})
    public void verifyGrid() throws Exception {

        System.out.println("Sap Before Suite is called in Thread Id : " + Thread.currentThread().getId());
        String nodeUrl = "http://172.168.1.14:5556/wd/hub";

        System.setProperty("webdriver.chrome.driver","/Users/ramaditya/IdeaProjects/reseller_android_ui_automation/sap/src/main/resources/chromeDrivers/drivers/chromedriver87");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.MAC);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        options.merge(capabilities);

        driver2 = new RemoteWebDriver(new URL(nodeUrl),capabilities);
        System.out.println("Control came to Remote Web Driver in Thread Id :" + Thread.currentThread().getId());
//        setImplicitWait(10000);
//        driver2.get(getSapBaseUrl());
        driver2.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        driver2.get("https://sap.shopups1.xyz/");
        System.out.println("Control Came To Sap Pannel in Thread Id :" + Thread.currentThread().getId());
//        setImplicitWait(10000);
        driver2.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        System.out.println(driver2.switchTo().alert().getText());
        driver2.switchTo().alert().accept();
        driver2.switchTo().alert().accept();
        System.out.println("Alert Window Closed in Thread Id :" + Thread.currentThread().getId());
//        ScreenRecorder.startRecording("");

        System.out.println("Bulk Issue Before Class is called in Thread Id : " + Thread.currentThread().getId());

        sapPanelPageObject = new SAPPanelPageObject(driver2);
        dashboardPageObjects = new DashboardPageObjects(driver2);
        importParcelPageObjects = new ImportParcelPageObjects(driver2);
        recieveModulePageObjects = new ReceiveModulePageObjects(driver2);
        dispatchModulePageObjects = new DispatchModulePageObjects(driver2);
        downloadModulePageObjects = new DownloadModulePageObjects(driver2);
        getSapApiResponse = new GetSapApiResponse(CoreConstants.MODULE_SAP_UI);

        System.out.println("verifyAuthentication is called in Thread Id : " + Thread.currentThread().getId());

        sapPanelPageObject.performAuthentication("01401122188","6666");

        String filePath = "/Users/ramaditya/Downloads/shopup-sample.xlsx";
        String shopName = "Bulk Issue Test Shop";
        String shopHubName = "Tejgaon Hub";
        List<String> invoiceNumbers = new ArrayList<String>();
        List<String> parcelIds = new ArrayList<String>();
        String bulkId = new String();
        Boolean[] assertValues = new Boolean[5];
        Boolean trueValue = true;

        System.out.println("Verifying Bulk Issue Fix in Thread Id : " + Thread.currentThread().getId());

        invoiceNumbers = importParcelPageObjects.performImportBulkParcels(filePath,shopName);

        parcelIds = recieveModulePageObjects.performReceiveParcels(invoiceNumbers,shopName,shopHubName);

        bulkId = dispatchModulePageObjects.performDispatchParcels(parcelIds,shopHubName);

        assertValues = downloadModulePageObjects.performVerifyBulkIssue(bulkId, parcelIds.size());

        Assert.assertEquals(assertValues[0],trueValue);
        Assert.assertEquals(assertValues[1],trueValue);
        Assert.assertEquals(assertValues[2],trueValue);
        driver2.quit();
    }



//    @AfterClass(alwaysRun = true)
//    public void bulkIssueAfterClass() {
//        System.out.println("Bulk Issue After Class Is Called");
//    }
//
//
//    @AfterSuite(alwaysRun = true)
//    public void sapAfterSuite() throws Exception {
//        System.out.println("SapAfterSuite Is Called");
//        ScreenRecorder.stopRecording();
//        quitBaseDriver();
//    }

}
