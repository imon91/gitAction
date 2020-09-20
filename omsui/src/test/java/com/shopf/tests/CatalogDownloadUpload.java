package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import utils.*;
import java.io.*;

public class CatalogDownloadUpload extends OmsBaseClass {
    private WebDriver driver;
    private CatalogPageObjects catalogPageObjects;
    private CatalogPageObjects.ExcelSheetEditor excelSheetEditor;
    private CatalogPageObjects.ViewUploadHistory viewUploadHistory;
    private ImageURLGenerator imageURLGenerator;
    private Assertion assertion;

    @BeforeClass(alwaysRun = true)
    public void loginBeforeClass() throws Exception {
        System.out.println("Login Before Class is called");
        driver = getBaseDriver();
        catalogPageObjects = new CatalogPageObjects(driver);
        excelSheetEditor = catalogPageObjects.new ExcelSheetEditor(driver);
        viewUploadHistory = catalogPageObjects.new ViewUploadHistory(driver);
        imageURLGenerator = new ImageURLGenerator(driver);
        assertion = new Assertion();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Authentication with Valid Credentials"
    )
    public void verifyCatalogDownload() throws Exception {
        File folder  = new File("Downloads");
        folder.mkdir();
        String filePath = folder.getAbsolutePath();
        System.out.println(filePath);

        String imageURL = imageURLGenerator.generateURL();
        System.out.println(imageURL);

        driver.get("https://uatap.shopups2.xyz/cms/sellers/287000423");
        catalogPageObjects.downloadCatalog();

        sleep(5000);

        File list[] = folder.listFiles();
        assertion.assertNotEquals(list.length,0);

        for(File file : folder.listFiles()) {
            assertion.assertNotEquals(file.length(), 0);
            filePath = file.getAbsolutePath();
            System.out.println(filePath);
        }
        excelSheetEditor.excelSheetEditor(filePath, imageURL);

        assertion.assertTrue(catalogPageObjects.uploadCatalog(filePath));
        catalogPageObjects.clickUploadHistory();

        while(!viewUploadHistory.recentUploadStatus(1).equals("Processing Complete"))
            driver.navigate().refresh();

        viewUploadHistory.downloadErrorSheet(1);
        sleep(5000);


        for(File file : folder.listFiles())
            file.delete();
        folder.delete();
    }
}
