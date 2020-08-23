package com.shopf.tests.PickOrders;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.*;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class AllPickLists extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PickOrdersPageObjects pickOrdersPageObjects;
    private PickOrdersPageObjects.AllPickListsTab allPickListsTab;
    private GetWMSApiResponse getWMSApiResponse;
    private AllPickListModel allPickListModelList;
    private Assertion assertion;
    private String test;


    @Parameters({"test"})
    @BeforeClass(alwaysRun = true)
    public void allPickListBeforeClass(String test) throws Exception {
        System.out.println("Before Purchase Order List Class");
        this.test = test;
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        pickOrdersPageObjects = new PickOrdersPageObjects(driver);
        allPickListsTab = pickOrdersPageObjects.new AllPickListsTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        assertion = new Assertion();
    }


    @Test(groups = {CoreConstants.GROUP_REGRESSION, CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verifying All Pick List Tab")
    public void verifyAllPickList() {
        int i;
        System.out.println("Verifying All Pick List Class");
        homePageObject.clickPickOrders();
        pickOrdersPageObjects.clickAllPickListsTab();
        allPickListModelList = getWMSApiResponse.getAllPickLists(1,30);
        List<AllPickListModel.PickListsDataBean> list = allPickListModelList.getPick_lists_data();
        System.out.println("List Size: " + list.size());
        for (i = 0; i < list.size(); i++) {
            if (i == 0 || i == (list.size() - 1) || test
                    .equalsIgnoreCase(CoreConstants.GROUP_REGRESSION)) {

                System.out.println("-----------*-----*-----*------------");

                System.out.println(list.get(i).getId());
                assertion.assertTrue(allPickListsTab.getPickListID(i + 1)
                                .equalsIgnoreCase(String.valueOf(list.get(i).getId())),
                        "PickListIDs Do Not Match");

                System.out.println(list.get(i).getCreated_at()
                        + "-" + allPickListsTab.getCreatedDate(i + 1));

                System.out.println(list.get(i).getReason_code());
                assertion.assertTrue(allPickListsTab.getPickListReason(i + 1)
                                .equalsIgnoreCase(list.get(i).getReason_code()),
                        "Pick List Reasons Do Not Match");

                System.out.println(list.get(i).getStatus());
                assertion.assertTrue(allPickListsTab.getStatus(i + 1)
                                .equalsIgnoreCase(list.get(i).getStatus()),
                        "Status Do Not Match");

                if (list.get(i).getPick_list_items().size() == 0)
                    continue;

                List<AllPickListModel.PickListsDataBean.PickListItemsBean> variant =
                        list.get(i).getPick_list_items();
                List<String> sku_codesList = allPickListsTab.getSkuCode(i+1);
                List<String> warehouseBinCodeList = allPickListsTab.getWarehouseBinCode(i+1);
                List<String> quantityList = allPickListsTab.getQuantity(i+1);
                List<String> pickedQuantityList = allPickListsTab.getPickedQuantity(i+1);

                for (int j = 0; j < variant.size(); j++) {

                    System.out.println("----------------------------------");

                    String sku_codes = variant.get(j).getVariant().getSku_code();
                    String warehouseBinCode = variant.get(j).getWarehouse_bin().getBin_code();
                    String quantity = String.valueOf(variant.get(j).getQuantity());
                    String pickedQuantity = String.valueOf(variant.get(j).getPicked_quantity());

                    System.out.println(sku_codes);
                    assertion.assertTrue(sku_codes
                                    .equalsIgnoreCase(sku_codesList.get(j)),
                            "Sku_codes Do Not Match");

                    System.out.println(warehouseBinCode);
                    assertion.assertTrue( warehouseBinCode
                                    .equalsIgnoreCase(warehouseBinCodeList.get(j)),
                            "WarehouseBinCodes Do Not Match");

                    System.out.println(quantity);
                    assertion.assertTrue(quantity
                                    .equalsIgnoreCase(quantityList.get(j)),
                            "Quantities Do Not Match");

                    System.out.println(pickedQuantity);
                    assertion.assertTrue(pickedQuantity
                                    .equalsIgnoreCase(pickedQuantityList.get(j)),
                            "Picked Quantities Do Not Match");
                }
            }
        }
    }


    @AfterClass(alwaysRun = true)
    public void allPickListAfterClass() {
        System.out.println("Purchase Order List After Class is called");
    }


}
