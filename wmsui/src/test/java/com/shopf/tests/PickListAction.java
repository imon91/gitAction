package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import pageObjects.*;
import services.responseModels.wmsModels.*;
import services.wmsMethods.GetWMSApiResponse;
import utils.*;

import java.util.*;

public class PickListAction extends WmsBaseClass {
    private WebDriver driver;
    private HomePageObject homePageObject;
    private PickOrdersPageObjects pickOrdersPageObjects;
    private PickOrdersPageObjects.AllPickListsTab allPickListsTab;
    private PickOrdersPageObjects.PickListActionTab pickListActionTab;
    private GetWMSApiResponse getWMSApiResponse;
    private PickListActionListModel pickListAction;
    private Assertion assertion;


    @BeforeClass(alwaysRun = true)
    public void pickListActionBeforeClass() throws Exception {
        System.out.println("Pick List Action Before Class");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        pickOrdersPageObjects = new PickOrdersPageObjects(driver);
        allPickListsTab = pickOrdersPageObjects.new AllPickListsTab(driver);
        pickListActionTab = pickOrdersPageObjects.new PickListActionTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        assertion = new Assertion();
    }


    @Test(groups = {CoreConstants.GROUP_SANITY, CoreConstants.GROUP_REGRESSION},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verify Pick List Action")
    public void verifyPickListAction() {
        System.out.println("Verify Pick List Action is called");
        int i, total;
        String poId = "";
        homePageObject.clickPickOrders();
        pickOrdersPageObjects.clickAllPickListsTab();
        sleep(1000);
        total = allPickListsTab.getTotalPickLists();
        for (i = 0; i < total; i++)
            if (allPickListsTab.getStatus(i + 1).equalsIgnoreCase("closed")) {
                poId = allPickListsTab.getPickListID(i + 1);
                break;
            }
        pickOrdersPageObjects.clickPickListActionTab();
        pickListActionTab.pickListIdEntry(poId);
        pickListAction = getWMSApiResponse.getPickListAction(poId);
        total = pickListActionTab.getTotalProducts();
        PickListActionListModel.PickListBean basic = pickListAction.getPick_list();
        List<PickListActionListModel.PickListItemsBean> items = pickListAction.getPick_list_items();
        System.out.println(items.size() + " - " + (total));

        for (i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getPick_list_id());
            assertion.assertTrue(pickListActionTab.getPickListID(i + 1)
                            .equalsIgnoreCase(String.valueOf(items.get(i).getPick_list_id())),
                    "Pick_list_ids Do Not Match");

            System.out.println(items.get(i).getVariant().getSku_code());
            assertion.assertTrue(pickListActionTab.getSkuCode(i + 1)
                            .equalsIgnoreCase(items.get(i).getVariant().getSku_code()),
                    "Sku_codes Do Not Match");

            System.out.println(items.get(i).getVariant().getNotes());
            assertion.assertTrue(pickListActionTab.getDescription(i + 1)
                            .equalsIgnoreCase(items.get(i).getVariant().getNotes()),
                    "Notes Do Not Match");

            System.out.println(items.get(i).getQuantity());
            assertion.assertTrue(pickListActionTab.getQuantity(i + 1)
                            .equalsIgnoreCase(String.valueOf(items.get(i).getQuantity())),
                    "Quantities Do Not Match");

            System.out.println(items.get(i).getQuantity() - items.get(i).getPicked_quantity());
            assertion.assertTrue(pickListActionTab.getUnpickedQuantity(i + 1)
                            .equalsIgnoreCase(String
                                    .valueOf(items.get(i).getQuantity() - items.get(i).getPicked_quantity())),
                    "Unpicked Quantities Do Not Match");

            System.out.println(items.get(i).getWarehouse_bin().getBin_code());
            assertion.assertTrue(pickListActionTab.getBinCode(i + 1)
                            .equalsIgnoreCase(items.get(i).getWarehouse_bin().getBin_code()),
                    "BinCodes Do Not Match");

            System.out.println(items.get(i).getStatus());
            assertion.assertTrue(pickListActionTab.getStatus(i + 1)
                            .equalsIgnoreCase(items.get(i).getStatus()),
                    "Do Not Match");
        }
    }


    @AfterClass(alwaysRun = true)
    public void pickListActionAfterClass() {
        System.out.println("Pick List Action After Class");
    }
}
