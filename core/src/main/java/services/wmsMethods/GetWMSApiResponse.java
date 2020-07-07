package services.wmsMethods;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import coreUtils.CoreConstants;
import io.restassured.response.Response;
import services.responseModels.wmsModels.*;
import services.serviceUtils.ShopUpPostMan;
import services.serviceUtils.WmsPostMan;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetWMSApiResponse {

    private ShopUpPostMan shopUpPostMan;
    private String module;
    private Gson gson;
    private Response response;
    private WmsPostMan wmsPostMan;

    public GetWMSApiResponse(String module){
        this.module = module;
        shopUpPostMan = new ShopUpPostMan(module);
        gson = new Gson();
        wmsPostMan = new WmsPostMan();
    }

    public List<WareHouseListModel.WareHousesBean> getListOfWarehouses(){
        gson = new Gson();
        response = wmsPostMan.getCall("warehouses.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            String r = response.getBody().asString();
            System.out.println(r);
            Type warehousesList = new TypeToken< ArrayList<WareHouseListModel.WareHousesBean>>(){}.getType();
            List<WareHouseListModel.WareHousesBean> wareHousesBean =
                    gson.fromJson(r,warehousesList);
            return wareHousesBean;
        }
        else return null;
    }

    public WarehouseBinDetails getWarehouseBinDetails(){
        gson = new Gson();
        response = wmsPostMan.getCall("warehouse_bins/get_bin_package_details?bin_code=W100F2R1C1RA1B41");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {

            WarehouseBinDetails warehouseBinDetails =
                    gson.fromJson(response.getBody().asString(), WarehouseBinDetails.class);
            return warehouseBinDetails;
        }
        else return null;
    }

    public VariantsBinDetailsModel getVariantBinDetails(){
        gson = new Gson();
        response = wmsPostMan.getCall("variants/get_in_bin_details?sku_code=139743&seller_id=29");
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

    public SuppliersListModel getSuppliersDetails(){
        gson = new Gson();
        response = shopUpPostMan.getCall("suppliers.json");
        if (module.equalsIgnoreCase(CoreConstants.MODULE_WMS_UI)) {
            SuppliersListModel suppliersListModel =
                    gson.fromJson(response.getBody().asString(), SuppliersListModel.class);
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




}
