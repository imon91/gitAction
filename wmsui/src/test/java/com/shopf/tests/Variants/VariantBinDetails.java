package com.shopf.tests.Variants;

import com.google.gson.Gson;
import com.google.gson.reflect.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.io.*;
import java.util.*;

public class VariantBinDetails extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private VariantsPageObjects variantsPageObjects;
    private VariantsPageObjects.BinsForSkuTab binsForSkuTab;
    private GetWMSApiResponse getWMSApiResponse;
    private VariantsBinDetailsModel variantsBinDetailsModel;
    private List<VariantsBinDetailsModel.BinDetailsBean> list;
    private String test;
    private Assertion assertion;
    private Random random;
    private Gson gson;
    private BufferedReader bufferedReader;
    private List<VariantDetailsModel> variantDetailsModels;


    @Parameters({"test"})
    @BeforeClass(alwaysRun = true)
    public void variantBinDetailsBeforeClass(String test) throws Exception {
        System.out.println("Variant Bin Details Before Class is called");
        this.test = test;
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        variantsPageObjects = new VariantsPageObjects(driver);
        binsForSkuTab = variantsPageObjects.new BinsForSkuTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        assertion = new Assertion();
        random = new Random();
    }


    @DataProvider(name = "skuCodeData")
    public Object[][] getSkuCodeData() throws FileNotFoundException {
        gson = new Gson();
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/sellerSkuCodes.json";

        bufferedReader = new BufferedReader(new FileReader(filePath));
        variantDetailsModels = gson.fromJson(bufferedReader,
                new TypeToken<List<VariantDetailsModel>>(){}.getType());

        int n = random.nextInt(20);
        return new Object[][]{
                {"Id",variantDetailsModels.get(n-1).getSku_code()}
        };
    }


    @Test(groups = {CoreConstants.GROUP_SANITY, CoreConstants.GROUP_REGRESSION},
            dataProvider = "skuCodeData",
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Variant Bin Details List")
    public void verifyVariantBinDetails(String name, String id) {
        System.out.println("Verify Variant Bin Details is called");
        System.out.println(name + " : " + id);
        int i;
        homePageObject.clickVariants();
        variantsPageObjects.clickBinsForSkuTab();
        sleep(1000);

        binsForSkuTab.checkVariantBins("DFW", id);
        variantsBinDetailsModel = getWMSApiResponse
                .getVariantBinDetails(id, "29");
        list = variantsBinDetailsModel.getBin_details();
        System.out.println("List Size: " + list.size());

        for (i = 0; i < list.size(); i++) {
            if (i == 0 || i == (list.size() - 1) || test
                    .equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)){

                System.out.println("-----------*-----*-----*------------");

                System.out.println(list.get(i).getBin_code());
                assertion.assertTrue(binsForSkuTab.getBinCode(i + 1)
                                .equalsIgnoreCase(list.get(i).getBin_code()),
                        "Bin_codes Do Not Match");

                System.out.println(list.get(i).getCount());
                assertion.assertTrue(binsForSkuTab.getQuantity(i + 1)
                                .equalsIgnoreCase(String.valueOf(list.get(i).getCount())),
                        "Counts Do Not Match");

                System.out.println(list.get(i).getPackage_ids());
                assertion.assertTrue(binsForSkuTab.getPackageIds(i + 1)
                                .equalsIgnoreCase(list.get(i).getPackage_ids()),
                        "Package_ids Do Not Match");
            }
        }
    }


    @AfterClass(alwaysRun = true)
    public void variantBinDetailsAfterClass() {
        System.out.println("Variant Bin Details After Class is called");
    }
}
