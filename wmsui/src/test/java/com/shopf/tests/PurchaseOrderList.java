package com.shopf.tests;
import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import services.responseModels.wmsModels.PurchaseOrderListModel;
import services.wmsMethods.GetWMSApiResponse;
import utils.WmsBaseClass;
import java.util.List;

    public class PurchaseOrderList extends WmsBaseClass
    {
        private WebDriver driver;
        private HomePageObject homePageObject;
        private PurchaseOrdersPageObjects purchaseOrdersPageObjects;
        private PurchaseOrdersPageObjects.PurchaseOrderList purchaseOrderList;
        private List<PurchaseOrderListModel> purchaseOrderListModels;
        private GetWMSApiResponse getWMSApiResponse;

        @BeforeClass(alwaysRun = true)
        public void purchaseOrderListBeforeClass() throws Exception
        {
            System.out.println("Before Purchase Order List Class");
            driver = getBaseDriver();
            homePageObject = new HomePageObject(driver);
            purchaseOrdersPageObjects = new PurchaseOrdersPageObjects(driver);
            purchaseOrderList = purchaseOrdersPageObjects.new PurchaseOrderList(driver);
            getWMSApiResponse = new GetWMSApiResponse(CoreConstants.MODULE_WMS_UI);
        }

        @Test(groups = {CoreConstants.GROUP_REGRESSION,CoreConstants.GROUP_SANITY},
                dependsOnGroups = "Login.verifyAuthenticationWithValidCredentials",
                description = "Verifying Purchase Orders List" )
        public void verifyPurchaseOrdersList()
        {
            System.out.println("Verifying Purchase Order Class");
            int i;
            homePageObject.clickPurchaseOrders();
            purchaseOrdersPageObjects.clickPurchaseOrderListTab();
            sleep(1000);
            purchaseOrderListModels = getWMSApiResponse.getPurchaseOrderList();
            System.out.println("List Size: " + purchaseOrderListModels.size());
            for(i=0; i<purchaseOrderListModels.size();i++)
            {
                String PO_ID = String.valueOf(purchaseOrderListModels.get(i).getId());
                String created_at = purchaseOrderListModels.get(i).getCreated_at();
                String PO_Type = purchaseOrderListModels.get(i).getPo_type();
                String status = purchaseOrderListModels.get(i).getStatus();
                String warehouse_code = purchaseOrderListModels.get(i).getWarehouse().getCode();
                String supplierName = purchaseOrderListModels.get(i).getSupplier_address().getSupplier().getName();

                System.out.print(PO_ID + " - " + purchaseOrderList.getPOID(i+1).equalsIgnoreCase(PO_ID) + "  ");
                System.out.print(created_at + " - " + purchaseOrderList.getCreatedDate(i+1).equalsIgnoreCase(created_at) + "  ");
                System.out.print(PO_Type + " - " + purchaseOrderList.getPOType(i+1).equalsIgnoreCase(PO_Type) + "  ");
                System.out.print(status + " - " + purchaseOrderList.getStatus(i+1).equalsIgnoreCase(status) + "  ");
                System.out.print(warehouse_code + " - " + purchaseOrderList.getWarehouseName(i+1).equalsIgnoreCase(warehouse_code) + "  ");
                System.out.println(supplierName + " - " + purchaseOrderList.getSupplierName(i+1).equalsIgnoreCase(supplierName));
                for(int j=0; j<purchaseOrderListModels.get(i).getPurchase_order_line_items().size();j++)
                {
                    int ordered_quantity = purchaseOrderListModels.get(i).getPurchase_order_line_items().get(j).
                            getOrdered_quantity();
                    String skuCode = purchaseOrderListModels.get(i).getPurchase_order_line_items().get(j).getVariant().
                            getSku_code();
                    System.out.println(skuCode + " - " + purchaseOrderList.getSkuCode(i+1).get(j).equalsIgnoreCase(skuCode) + "  ");
                }
            }
        }

        @AfterClass(alwaysRun = true)
        public void purchaseOrderListAfterClass()
        {
            System.out.println("After Purchase Order List Class");
        }
    }
