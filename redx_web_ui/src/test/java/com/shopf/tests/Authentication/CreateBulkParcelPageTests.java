package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import services.redxMethods.GetRedxApiResponse;
import utils.RedXWebBaseClass;
import utils.RedXWebFileUtils;

import java.io.File;
import java.util.Random;

public class CreateBulkParcelPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;
    private ActionBarObjects actionBarObjects;
    private CreateParcelPageObjects createParcelPageObjects;
    private CreateBulkParcelPageObjects createBulkParcelPageObjects;
    private CreateBulkParcelPageObjects.BulkUploadPageObjects bulkUploadPageObjects;
    private CreateBulkParcelPageObjects.BulkUploadImportStatus bulkUploadImportStatus;

    private GetRedxApiResponse getRedxApiResponse;
    private Actions actions;
    private Random random;
    private String cookie;

    @BeforeSuite(alwaysRun = true)
    public void redXWebBeforeSuite() throws  Exception
    {
        System.out.println("RedX Web Before Suite");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getWebBaseUrl());
        driver.manage().window().maximize();
    }

    @BeforeClass(alwaysRun = true)
    public void createBulkParcelPageTestsBeforeClass() throws Exception
    {
        System.out.println("Create Bulk Parcel Page Tests Before Class");
        loginPageObjects = new LoginPageObjects(driver);
        actionBarObjects = new ActionBarObjects(driver);
        createParcelPageObjects = new CreateParcelPageObjects(driver);
        createBulkParcelPageObjects = new CreateBulkParcelPageObjects(driver);
        bulkUploadPageObjects = createBulkParcelPageObjects.new BulkUploadPageObjects();
        bulkUploadImportStatus = createBulkParcelPageObjects.new BulkUploadImportStatus();

        actions = new Actions(driver);
        random = new Random();
        getRedxApiResponse = new GetRedxApiResponse("redxweb");

        System.out.println("Performing Authentication");
        cookie = loginPageObjects.performAuthentication("0140112218","6666","8");
        setImplicitWait(10000);

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        actionBarObjects.clickOnCreateParcelButton();
        createParcelPageObjects.clickCreateBulkParcelButton();
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    @BeforeMethod(alwaysRun = true)
    public void createBulkParcelPageTestsBeforeMethod()
    {
        System.out.println("\n /****************************************************************************************************/ \n");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Sample File Button Functionality",
            priority = 1 )
    public void verifyDownloadSampleFileButtonFunctionality()
    {
        System.out.println("Verifying Download Sample File Button Functionality");
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/Downloads";
        File directory = new File(filePath);
        File[] dirContains = directory.listFiles();
        int files1 = dirContains.length;
        System.out.println("Current Files : " + files1);

        createBulkParcelPageObjects.clickDownloadSampleButton();
        sleep(3000);
        File[] dirContain = directory.listFiles();
        int files2 = dirContain.length;
        System.out.println("Files After Download : " + files2);
        Assert.assertEquals(files2,files1+1);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify All Pickup Location Drop Down Functionality",
            priority = 2 )
    public void verifyAllPickupLocationDropDownFunctionality()
    {
        System.out.println("Verifying All Pickup Location Drop Down Functionality");
        String pickupLocation = createBulkParcelPageObjects.choosePickupLocation();
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Upload File Button Functionality",
            priority = 3 )
    public void verifyUploadFileButtonFunctionality() throws Exception
    {
        System.out.println("Verifying Upload File Button Functionality");
        createBulkParcelPageObjects.uploadParcelViaRobotClassMac(RedXWebFileUtils.createBulkParcelDataCsvFilePath);
        Assert.assertEquals(bulkUploadPageObjects.getTitleWrapper(),"Bulk Upload");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Remove Button Functionality",
            priority = 4 )
    public void verifyRemoveButtonFunctionality()
    {
        System.out.println("Verifying Remove Button Functionality");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        int p1 = bulkUploadPageObjects.getParcelsSize();
        System.out.println("Parcels Before Removing: " + p1);
        bulkUploadPageObjects.removeParcel();
        int p2 = bulkUploadPageObjects.getParcelsSize();
        System.out.println("Parcels After Removing : " + p2);
        Assert.assertEquals(p2,p1-1);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Confirmation Error Message Value",
            priority = 5 )
    public void verifyConfirmationErrorMessageValue()
    {
        System.out.println("Verifying Confirmation Error Message Value");
        String errorMsg = bulkUploadPageObjects.getConfirmationErrorMsg();
        System.out.println("Error Message : " + errorMsg);
        Assert.assertEquals(errorMsg,"Parcel value confirmation is required");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Reset Button Functionality",
            priority = 6 )
    public void verifyResetButtonFunctionality()
    {
        System.out.println("Verifying Reset Button Functionality");
        bulkUploadPageObjects.clickResetButton();
        bulkUploadPageObjects.clickYesButton();
        String toastMsg = createBulkParcelPageObjects.getToastMsg();
        System.out.println("Toast Message : " + toastMsg);
        Assert.assertEquals(toastMsg,"Discarded.");
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Upload File Functionality",
            priority = 7 )
    public void verifyUploadFileFunctionality() throws Exception
    {
        System.out.println("Verifying Upload File Functionality");
        createBulkParcelPageObjects.performUploadFile(RedXWebFileUtils.createBulkParcelDataCsvFilePath);
        String toastMsg = bulkUploadImportStatus.getToastMsg();
        System.out.println("Toast Message : " + toastMsg);
        Assert.assertEquals(toastMsg,"Parcels created sucessfully");
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Bulk Upload Status Functionality",
            priority = 8 )
    public void verifyBulkUploadStatusFunctionality()
    {
        System.out.println("Verifying Bulk Upload Status Functionality");
        bulkUploadImportStatus.clickRefreshTillStatus();
        int parcels = bulkUploadImportStatus.getParcelsSize();
        int success = Integer.parseInt(bulkUploadImportStatus.getSuccessInfo());
        int failed = Integer.parseInt(bulkUploadImportStatus.getFailedInfo());
        System.out.println("Parcels : " + parcels);
        System.out.println("Success Parcels : " + success);
        System.out.println("Failed Parcels : " + failed);
        Assert.assertEquals((success+failed),parcels);
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Filter By Status Functionality",
            priority = 9 )
    public void verifyFilterByStatusFunctionality()
    {
        System.out.println("Verifying Filter By Status Functionality");
        String status;
        int success = Integer.parseInt(bulkUploadImportStatus.getSuccessInfo());
        int failed = Integer.parseInt(bulkUploadImportStatus.getFailedInfo());
        System.out.println("Success Parcels : " + success);
        System.out.println("Failed Parcels : " + failed);
        if(failed==0)
        {
            status = "Success";
            bulkUploadImportStatus.clickStatusFilterDropDownOption(status);
            System.out.println("Status : " + status);
            Assert.assertEquals(success,Integer.parseInt(bulkUploadImportStatus.getSuccessInfo()));
        }
        else{
            status = bulkUploadImportStatus.clickStatusFilterDropDownOption();
            System.out.println("Status : " + status);
        }
    }

    @AfterClass(alwaysRun = true)
    public void createBulkParcelPageTestsAfterClass() {
        System.out.println("Create Bulk Parcel Page Tests After Class Is Called");
        driver.quit();
    }
}
