package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
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

    @BeforeClass(alwaysRun = true)
    public void pickListActionBeforeClass() throws Exception {
        System.out.println("Pick List Action Before Class");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        pickOrdersPageObjects = new PickOrdersPageObjects(driver);
        allPickListsTab = pickOrdersPageObjects.new AllPickListsTab(driver);
        pickListActionTab = pickOrdersPageObjects.new PickListActionTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
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
            System.out.println(items.get(i).getPick_list_id() + " - " +
                    pickListActionTab.getPickListID(i + 1)
                            .equalsIgnoreCase(String.valueOf(items.get(i).getPick_list_id())));

            System.out.println(items.get(i).getVariant().getSku_code() + " - " +
                    pickListActionTab.getSkuCode(i + 1)
                            .equalsIgnoreCase(items.get(i).getVariant().getSku_code()));

            System.out.println(items.get(i).getVariant().getNotes() + " - " +
                    pickListActionTab.getDescription(i + 1)
                            .equalsIgnoreCase(items.get(i).getVariant().getNotes()));

            System.out.println(items.get(i).getQuantity() + " - " +
                    pickListActionTab.getQuantity(i + 1)
                            .equalsIgnoreCase(String.valueOf(items.get(i).getQuantity())));

            System.out.println(items.get(i).getQuantity() - items.get(i).getPicked_quantity() + " - " +
                    pickListActionTab.getUnpickedQuantity(i + 1)
                            .equalsIgnoreCase(String
                                    .valueOf(items.get(i).getQuantity() - items.get(i).getPicked_quantity())));

            System.out.println(items.get(i).getWarehouse_bin().getBin_code() + " - " +
                    pickListActionTab.getBinCode(i + 1)
                            .equalsIgnoreCase(items.get(i).getWarehouse_bin().getBin_code()));

            System.out.println(items.get(i).getStatus() + " - " +
                    pickListActionTab.getStatus(i + 1)
                            .equalsIgnoreCase(items.get(i).getStatus()));
        }
    }

    @AfterClass(alwaysRun = true)
    public void pickListActionAfterClass() {
        System.out.println("Pick List Action After Class");
    }
}
