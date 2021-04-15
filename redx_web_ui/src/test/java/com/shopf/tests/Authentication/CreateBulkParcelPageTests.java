package com.shopf.tests.Authentication;

import com.gurock.testrail.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class CreateBulkParcelPageTests extends RedXWebBaseClass {

    private WebDriver driver;
    private ActionBarObjects actionBarObjects;
    private CreateParcelPageObjects createParcelPageObjects;
    private CreateBulkParcelPageObjects createBulkParcelPageObjects;
    private CreateBulkParcelPageObjects.BulkUploadPageObjects bulkUploadPageObjects;
    private CreateBulkParcelPageObjects.BulkUploadImportStatus bulkUploadImportStatus;

    private Actions actions;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void createBulkParcelPageTestsBeforeClass() throws Exception
    {
        System.out.println("Create Bulk Parcel Page Tests Before Class");
        driver = getBaseDriver();
        actionBarObjects = new ActionBarObjects(driver);
        createParcelPageObjects = new CreateParcelPageObjects(driver);
        createBulkParcelPageObjects = new CreateBulkParcelPageObjects(driver);
        bulkUploadPageObjects = createBulkParcelPageObjects.new BulkUploadPageObjects();
        bulkUploadImportStatus = createBulkParcelPageObjects.new BulkUploadImportStatus();

        actions = new Actions(driver);

        actionBarObjects.changeShop("RedX Web Sanity Test Shop");
        setImplicitWait(10000);

        actionBarObjects.clickOnCreateParcelButton();
        createParcelPageObjects.clickCreateBulkParcelButton();
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("\n /****************************************************************************************************/ \n");
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, CreateBulkParcelPageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "128")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Download Sample File Button Functionality",
            priority = 601 )
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

    @TestRails(caseId = "129")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify All Pickup Location Drop Down Functionality",
            priority = 602 )
    public void verifyAllPickupLocationDropDownFunctionality()
    {
        System.out.println("Verifying All Pickup Location Drop Down Functionality");
        String pickupLocation = createBulkParcelPageObjects.choosePickupLocation();
    }

    @TestRails(caseId = "130")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Upload File Button Functionality",
            priority = 603 )
    public void verifyUploadFileButtonFunctionality() throws Exception
    {
        System.out.println("Verifying Upload File Button Functionality");
        createBulkParcelPageObjects.uploadParcelViaRobotClassMac(RedXWebFileUtils.createBulkParcelDataCsvFilePath);
        Assert.assertEquals(bulkUploadPageObjects.getTitleWrapper(),"Bulk Upload");
    }

    @TestRails(caseId = "131")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Remove Button Functionality",
            priority = 604 )
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

    @TestRails(caseId = "132")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Confirmation Error Message Value",
            priority = 605 )
    public void verifyConfirmationErrorMessageValue()
    {
        System.out.println("Verifying Confirmation Error Message Value");
        String errorMsg = bulkUploadPageObjects.getConfirmationErrorMsg();
        System.out.println("Error Message : " + errorMsg);
        Assert.assertEquals(errorMsg,"Parcel value confirmation is required");
    }

    @TestRails(caseId = "133")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Reset Button Functionality",
            priority = 606 )
    public void verifyResetButtonFunctionality()
    {
        System.out.println("Verifying Reset Button Functionality");
        bulkUploadPageObjects.clickResetButton();
        bulkUploadPageObjects.clickYesButton();
        String toastMsg = createBulkParcelPageObjects.getToastMsg();
        System.out.println("Toast Message : " + toastMsg);
        Assert.assertEquals(toastMsg,"Discarded.");
    }

    @TestRails(caseId = "134")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Upload File Functionality",
            priority = 607 )
    public void verifyUploadFileFunctionality() throws Exception
    {
        System.out.println("Verifying Upload File Functionality");
        createBulkParcelPageObjects.performUploadFile(RedXWebFileUtils.createBulkParcelDataCsvFilePath);
        String toastMsg = bulkUploadImportStatus.getToastMsg();
        System.out.println("Toast Message : " + toastMsg);
        Assert.assertEquals(toastMsg,"Parcels created sucessfully");
    }

    @TestRails(caseId = "135")
    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},
            description = "Verify Bulk Upload Status Functionality",
            priority = 608 )
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

    @TestRails(caseId = "136")
    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify Filter By Status Functionality",
            priority = 609 )
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
}
