package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import utils.*;
import java.io.*;

public class CatalogDownload extends OmsBaseClass {
    private WebDriver driver;
    private CatalogPageObjects catalogPageObjects;
    private Assertion assertion;

    @BeforeClass(alwaysRun = true)
    public void loginBeforeClass() throws Exception {
        System.out.println("Login Before Class is called");
        driver = getBaseDriver();
        catalogPageObjects = new CatalogPageObjects(driver);
        assertion = new Assertion();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Authentication with Valid Credentials"
    )
    public void verifyCatalogDownload(){
        File folder  = new File("Downloads");
        folder.mkdir();
        String filePath = folder.getAbsolutePath();
        System.out.println(filePath);

        driver.get("https://uatap.shopups2.xyz/cms/sellers/287000423");
        catalogPageObjects.downloadCatalog();

        sleep(5000);

        File list[] = folder.listFiles();
        assertion.assertNotEquals(list.length,0);

        for(File file : folder.listFiles())
            assertion.assertNotEquals(file.length(),0);


        for(File file : folder.listFiles())
            file.delete();
        folder.delete();
    }
}
