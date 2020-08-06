package services.wmsMethods;

import com.google.gson.Gson;
import com.google.gson.reflect.*;
import coreUtils.*;
import io.restassured.response.*;
import services.responseModels.wmsModels.*;
import services.serviceUtils.*;

import java.util.*;

public class GetWMSApiResponse {

    private final String module;
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
            List<WareHouseListModel.WareHousesBean> wareHousesBean =
                    gson.fromJson(r,new TypeToken<ArrayList<WareHouseListModel.WareHousesBean>>(){}.getType());
            return wareHousesBean;
        }
        else return null;
    }

    public WarehouseBinDetails getWarehouseBinDetails(String id){
        gson = new Gson();
        response = shopUpPostMan.getCall("warehouse_bins/get_bin_package_details?bin_code=" + id);
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            WarehouseBinDetails warehouseBinDetails =
                    gson.fromJson(r,WarehouseBinDetails.class);
            return warehouseBinDetails;
        }
        else return null;
    }

    public VariantsBinDetailsModel getVariantBinDetails(String skuCode,String id){
        gson = new Gson();
        response = shopUpPostMan.getCall("variants/get_in_bin_details?sku_code="+skuCode+"&seller_id="+id);
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            VariantsBinDetailsModel variantsBinDetailsModel =
                    gson.fromJson(r, VariantsBinDetailsModel.class);
            return variantsBinDetailsModel;
        }
        else return null;
    }

    public List<VariantDetailsModel> getVariantDetails(){
        gson = new Gson();
        response = shopUpPostMan.getCall("suppliers/variant_details.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            List<VariantDetailsModel> variantDetailsModel =
                    gson.fromJson(r, new TypeToken<List<VariantDetailsModel>>(){}.getType());
            return variantDetailsModel;
        }
        else return null;
    }

    public List<SuppliersListModel> getSuppliersDetails(){
        gson = new Gson();
        response = shopUpPostMan.getCall("suppliers.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            List<SuppliersListModel> suppliersListModel =
                    gson.fromJson(r,new TypeToken<List<SuppliersListModel>>(){}.getType());
            return suppliersListModel;
        }
        else return null;
    }

    public List<SellersListModel> getSellerDetails(){
        gson = new Gson();
        response = shopUpPostMan.getCall("sellers.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            List<SellersListModel> sellersListModel =
                    gson.fromJson(r, new TypeToken<List<SellersListModel>>(){}.getType());
            return sellersListModel;
        }
        else return null;
    }

    public List<PurchaseOrderListModel> getPurchaseOrderList(int page,int per_page){
        gson = new Gson();
        response = shopUpPostMan.getCall("purchase_orders.json?page="+page+"&per_page="+per_page+"&");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            List<PurchaseOrderListModel> purchaseOrderListModels =
                    gson.fromJson(r,new TypeToken<ArrayList<PurchaseOrderListModel>>(){}.getType());
            return purchaseOrderListModels;
        }
        else return null;
    }

    public List<PackagesListModel> getPackagesList(){
        gson = new Gson();
        response = shopUpPostMan.getCall("packages/get_packages_for_allocation.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            List<PackagesListModel> packagesLists =
                    gson.fromJson(r,new TypeToken<List<PackagesListModel>>(){}.getType());
            return packagesLists;
        }
        else return null;
    }

    public List<VariantDetailsModel> getVariantsDFW(){
        gson = new Gson();
        response = shopUpPostMan.getCall("suppliers/variant_details.json?seller_id=29");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            List<VariantDetailsModel> variantDetailsModels =
                    gson.fromJson(r,new TypeToken<List<VariantDetailsModel>>(){}.getType());
            return variantDetailsModels;
        }
        else return null;
    }

    public AllPickListModel getAllPickLists(int page,int per_page){
        gson = new Gson();
        response = shopUpPostMan
                .getCall("pick_lists.json?page="+page+"&per_page="+per_page+"&status=all");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            AllPickListModel pickListModel =
                    gson.fromJson(r,AllPickListModel.class);
            return pickListModel;
        }
        else return null;
    }

    public PickListActionListModel getPickListAction(String poId){
        gson = new Gson();
        response = shopUpPostMan
                .getCall("pick_lists/"+poId+"/pending_items.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            PickListActionListModel pickListActionModel =
                    gson.fromJson(r,PickListActionListModel.class);
            return pickListActionModel;
        }
        else return null;
    }

    public List<OrderListModel> getOrderList(){
        gson = new Gson();
        response = shopUpPostMan
                .getCall("orders.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            List<OrderListModel> orderListModel =
                    gson.fromJson(r,new TypeToken<List<OrderListModel>>(){}.getType());
            return orderListModel;
        }
        else return null;
    }

    public PurchaseOrderDetailsModel getPurchaseOrderDetails(String poId){
        gson = new Gson();
        response = shopUpPostMan
                .getCall("purchase_orders/"+poId);
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            PurchaseOrderDetailsModel purchaseOrderModel =
                    gson.fromJson(r,new TypeToken<PurchaseOrderDetailsModel>(){}.getType());
            return purchaseOrderModel;
        }
        else return null;
    }

    public OrderDetailsModel getOrderDetails(String orderNo){
        gson = new Gson();
        response = shopUpPostMan
                .getCall("orders/"+orderNo+".json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            OrderDetailsModel orderDetailsModel =
                    gson.fromJson(r,new TypeToken<OrderDetailsModel>(){}.getType());
            return orderDetailsModel;
        }
        else return null;
    }
}
