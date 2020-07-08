package services.wmsMethods;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import coreUtils.CoreConstants;
import io.restassured.response.Response;
import services.responseModels.wmsModels.*;
import services.serviceUtils.ShopUpPostMan;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetWMSApiResponse {

    private String module;
    private Gson gson;
    private Response response;
    private ShopUpPostMan shopUpPostMan;

    public GetWMSApiResponse(String module){
        this.module = module;
        gson = new Gson();
        shopUpPostMan = new ShopUpPostMan(module);
    }

    public List<WareHouseListModel.WareHousesBean> getListOfWarehouses(){
        gson = new Gson();
        response = shopUpPostMan.getCall("warehouses.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            System.out.println(r);
            Type warehouses = new TypeToken<ArrayList<WareHouseListModel.WareHousesBean>>(){}.getType();
            List<WareHouseListModel.WareHousesBean> wareHousesBean =
                    gson.fromJson(r,warehouses);
            return wareHousesBean;
        }
        else return null;
    }

    public WarehouseBinDetails getWarehouseBinDetails(){
        gson = new Gson();
        response = shopUpPostMan.getCall("warehouse_bins/get_bin_package_details?bin_code=W100F2R1C1RA1B41");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {

            WarehouseBinDetails warehouseBinDetails =
                    gson.fromJson(response.getBody().asString(), WarehouseBinDetails.class);
            return warehouseBinDetails;
        }
        else return null;
    }

    public VariantsBinDetailsModel getVariantBinDetails(){
        gson = new Gson();
        response = shopUpPostMan.getCall("variants/get_in_bin_details?sku_code=139743&seller_id=29");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            VariantsBinDetailsModel variantsBinDetailsModel =
                    gson.fromJson(response.getBody().asString(), VariantsBinDetailsModel.class);
            return variantsBinDetailsModel;
        }
        else return null;
    }

    public VariantDetailsModel getVariantDetails(){
        gson = new Gson();
        response = shopUpPostMan.getCall("suppliers/variant_details.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            VariantDetailsModel variantDetailsModel =
                    gson.fromJson(response.getBody().asString(), VariantDetailsModel.class);
            return variantDetailsModel;
        }
        else return null;
    }

    public List<SuppliersListModel> getSuppliersDetails(){
        gson = new Gson();
        response = shopUpPostMan.getCall("suppliers.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            Type supplierList = new TypeToken<List<SuppliersListModel>>(){}.getType();
            List<SuppliersListModel> suppliersListModel =
                    gson.fromJson(r,supplierList);
            return suppliersListModel;
        }
        else return null;
    }

    public SellersListModel getSellerDetails(){
        gson = new Gson();
        response = shopUpPostMan.getCall("sellers/sellers_list.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            SellersListModel sellersListModel =
                    gson.fromJson(response.getBody().asString(), SellersListModel.class);
            return sellersListModel;
        }
        else return null;
    }

    public List<PurchaseOrderListModel> getPurchaseOrderList(){
        gson = new Gson();
        response = shopUpPostMan.getCall("purchase_orders.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            System.out.println(r);
            Type purchaseOrders = new TypeToken<ArrayList<PurchaseOrderListModel>>(){}.getType();
            List<PurchaseOrderListModel> purchaseOrderListModels =
                    gson.fromJson(r,purchaseOrders);
            return purchaseOrderListModels;
        }
        else return null;
    }

    public List<PackagesListModel> getPackagesList(){
        gson = new Gson();
        response = shopUpPostMan.getCall("packages/get_packages_for_allocation.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            System.out.println(r);
            Type packages = new TypeToken<List<PackagesListModel>>(){}.getType();
            List<PackagesListModel> packagesLists =
                    gson.fromJson(r,packages);
            return packagesLists;
        }
        else return null;
    }




}
