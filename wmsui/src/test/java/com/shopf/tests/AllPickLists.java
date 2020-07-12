package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PickOrdersPageObjects;
import services.responseModels.wmsModels.AllPickListModel;
import services.wmsMethods.GetWMSApiResponse;
import utils.WmsBaseClass;

import java.util.List;

public class AllPickLists extends WmsBaseClass {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private PickOrdersPageObjects pickOrdersPageObjects;
    private PickOrdersPageObjects.AllPickListsTab allPickListsTab;
    private GetWMSApiResponse getWMSApiResponse;
    private AllPickListModel allPickListModelList;

    @BeforeClass(alwaysRun = true)
    public void allPickListBeforeClass() throws Exception {
        System.out.println("Before Purchase Order List Class");
        driver = getBaseDriver();
        homePageObject = new HomePageObject(driver);
        pickOrdersPageObjects = new PickOrdersPageObjects(driver);
        allPickListsTab = pickOrdersPageObjects.new AllPickListsTab(driver);
        getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
    }

    @Test(groups = {CoreConstants.GROUP_REGRESSION,CoreConstants.GROUP_SANITY},
            dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
            description = "Verifying All Pick List Tab")
    public void verifyAllPickList() {
        int i;
        System.out.println("Verifying All Pick List Class");
        homePageObject.clickPickOrders();
        pickOrdersPageObjects.clickAllPickListsTab();
        sleep(1000);
        allPickListModelList = getWMSApiResponse.getAllPickLists(1);
        List<AllPickListModel.PickListsDataBean> list = allPickListModelList.getPick_lists_data();
        System.out.println("List Size: " + list.size());
        for (i = 0; i < list.size(); i++)
        {
            String id = allPickListsTab.getPickListID(i+1);
            String created_time = allPickListsTab.getCreatedDate(i+1);
            String reason = allPickListsTab.getPickListReason(i+1);
            String status = allPickListsTab.getStatus(i+1);

            System.out.println(id.equalsIgnoreCase(String.valueOf(list.get(i).getId()))
                    +"-"+ id);
            System.out.println(list.get(i).getCreated_at()
                    +"-"+ created_time);
            System.out.println(reason.equalsIgnoreCase(list.get(i).getReason_code())
                    +"-"+ reason);
            System.out.println(status.equalsIgnoreCase(list.get(i).getStatus())
                    +"-"+ status);
            List<AllPickListModel.PickListsDataBean.PickListItemsBean> variant = list.get(i).getPick_list_items();
            for(int j =0;j<variant.size();j++)
            {
                String sku_codes = variant.get(j).getVariant().getSku_code();
                String warehouseBinCode = variant.get(j).getWarehouse_bin().getBin_code();
                String quantity = String.valueOf(variant.get(j).getQuantity());
                String pickedQuantity = String.valueOf(variant.get(j).getPicked_quantity());
                System.out.print(sku_codes + " - ");
                System.out.println(warehouseBinCode);
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void allPickListAfterClass()
    {
        System.out.println("After Purchase Order List Class");
    }


}
