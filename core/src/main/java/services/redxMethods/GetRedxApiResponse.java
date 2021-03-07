package services.redxMethods;

import com.google.gson.Gson;
import io.restassured.response.Response;
import services.responseModels.redxModels.*;
import services.serviceUtils.ShopUpPostMan;

import java.util.ArrayList;
import java.util.List;


public class GetRedxApiResponse {
    private ShopUpPostMan shopUpPostMan;
    private String module;
    private Gson gson;

    public GetRedxApiResponse(String module)
    {
        this.module = module;
        shopUpPostMan = new ShopUpPostMan(module);
        gson = new Gson();
    }

    public ShopListModel shopListGetCall()
    {
        String shopListGetCall = "v1/shop?isRedX=true";
        Response getShopListResponse = shopUpPostMan.getCall(shopListGetCall);
        ShopListModel shopListModel = gson.fromJson(getShopListResponse.getBody().asString(),ShopListModel.class);
        return shopListModel;
    }

    public ShopInfoModel shopInfoGetCall(int shopId)
    {
        String shopInfoGetCall = "v1/logistics/shop-stores/" + shopId + "?status=active";
        Response getShopInfoResponse = shopUpPostMan.getCall(shopInfoGetCall);
        ShopInfoModel shopInfoModel = gson.fromJson(getShopInfoResponse.getBody().asString(),ShopInfoModel.class);
        return shopInfoModel;
    }

    public AreaTreeModel areaTreeGetCall()
    {
        String areaTreeGetCall = "v1/logistics/address-mapping/area-tree";
        Response getAreaListResponse = shopUpPostMan.getCall(areaTreeGetCall);
        AreaTreeModel areaTreeModel = gson.fromJson(getAreaListResponse.getBody().asString(),AreaTreeModel.class);
        return areaTreeModel;
    }

    /*--------------------Dashboard Page--------------------*/

    public OverviewModel overviewGetCall(long since, long until)
    {
        String overviewGetCall = "v1/admin/shop/532439/logistics/dashboard/overview?since=" + since + "&until=" + until;
        Response getOverviewResponse = shopUpPostMan.getCall(overviewGetCall);
        OverviewModel overviewModel = gson.fromJson(getOverviewResponse.getBody().asString(),OverviewModel.class);
        return  overviewModel;
    }

    public OverviewModel overviewGetCall(long since,long until,long storeId)
    {
        String overviewGetCall = "v1/admin/shop/532439/logistics/dashboard/overview?since=" + since + "&until=" + until + "&shopStoreId=" + storeId;
        Response getOverviewResponse = shopUpPostMan.getCall(overviewGetCall);
        OverviewModel overviewModel = gson.fromJson(getOverviewResponse.getBody().asString(),OverviewModel.class);
        return  overviewModel;
    }

    /*--------------------Parcels Page--------------------*/

    public ParcelsListModel parcelsListModel(String url)
    {

        Response getParcelsListResponse = shopUpPostMan.getCall(url);
//        System.out.println(getParcelsListResponse.getBody().asString());
        ParcelsListModel parcelsListModel = gson.fromJson(getParcelsListResponse.getBody().asString(),ParcelsListModel.class);
        return parcelsListModel;
    }

    /*--------------------Create Parcel Page--------------------*/

    public DeliveryChargeModel deliveryChargeGetCall(int shopId, int areaId, int weight, int cash)
    {
        String deliveryChargeGetCall = "v1/logistics/shop/" + shopId + "/charge-calculation?deliveryAreaId=" + areaId + "&weight=" + weight + "&cash=" + cash;
        Response deliveryChargeResponse = shopUpPostMan.getCall(deliveryChargeGetCall);
        DeliveryChargeModel deliveryChargeModel = gson.fromJson(deliveryChargeResponse.getBody().asString(),DeliveryChargeModel.class);
        return deliveryChargeModel;
    }

    /*--------------------Coupons Page--------------------*/

    public CouponsModel couponsListGetCall(String shopName)
    {
        int merchantId = getShopId(shopName);
        String couponsListGetCall = "v1/logistics/coupons/usage?merchantId=" + merchantId;
        Response couponsListResponse = shopUpPostMan.getCall(couponsListGetCall);
        CouponsModel couponsModel = gson.fromJson(couponsListResponse.getBody().asString(),CouponsModel.class);
        return couponsModel;
    }

    /*--------------------Payments Page--------------------*/

    public PaymentsModel paymentsListGetCall(String paymentsListGetCall)
    {
        Response paymentsListResponse = shopUpPostMan.getCall(paymentsListGetCall);
        PaymentsModel paymentsModel = gson.fromJson(paymentsListResponse.getBody().asString(),PaymentsModel.class);
        return paymentsModel;
    }

    public PaymentDetailsModel paymentDetailsListGetCall(String shopName,int invoiceId)
    {
        int shopId = getShopId(shopName);
        String paymentDetailsListGetCall = "v2/logistics/shop/" + shopId + "/payments/" + invoiceId + "/parcels";
        Response paymentDetailsListResponse = shopUpPostMan.getCall(paymentDetailsListGetCall);
        PaymentDetailsModel paymentDetailsModel = gson.fromJson(paymentDetailsListResponse.getBody().asString(),PaymentDetailsModel.class);
        return paymentDetailsModel;
    }

    /*--------------------Functions--------------------*/

    public String allParcelsListGetCallUrl(long storeId,int ...params)
    {
        /* Parameters Order : (long storeId,int page,int limit,int offset,int sort) */
        /* Default Values : (532439,1,20,0,0) */
        String allParcelsListGetCallUrl = "v1/admin/shop/" + storeId + "/logistics/parcels?";
        int i;
        for(i=0;i<params.length;i++)
        {
            switch (i)
            {
                case 0:
                    allParcelsListGetCallUrl = allParcelsListGetCallUrl.concat("page=" + params[i]);
                    break;
                case 1:
                    allParcelsListGetCallUrl = allParcelsListGetCallUrl.concat("&limit=" + params[i]);
                    break;
                case 2:
                    allParcelsListGetCallUrl = allParcelsListGetCallUrl.concat("&offset=" + params[i]);
                    break;
                case 3:
                    allParcelsListGetCallUrl = allParcelsListGetCallUrl.concat("&sort=" + params[i]);
                    break;
            }
        }
        System.out.println("All Parcels List Get Call URL : " + allParcelsListGetCallUrl);
        return allParcelsListGetCallUrl;
    }

    public String parcelsListGetCallUrl(String ...params)
    {
        /* Parameters Order : (String allParcelsListGetCall,String trackingId, String InvoiceId, String numberOrName, String dateFilterType, long since, long until,long storeId) */
        int i;
        String parcelsListGetCallUrl = params[0];
        for(i=0;i<params.length;i++)
        {
            switch (i)
            {
                case 1:
                    parcelsListGetCallUrl = parcelsListGetCallUrl.concat("&trackingId=" + params[i]);
                    break;
                case 2:
                    parcelsListGetCallUrl = parcelsListGetCallUrl.concat("&merchantInvoiceNumber=" + params[i]);
                    break;
                case 3:
                    parcelsListGetCallUrl = parcelsListGetCallUrl.concat("&q=" + params[i]);
                    break;
                case 4:
                    parcelsListGetCallUrl = parcelsListGetCallUrl.concat("&dateFilterType=" + params[i]);
                    break;
                case 5:
                    if(params[4].equalsIgnoreCase("CREATED_AT"))
                        parcelsListGetCallUrl = parcelsListGetCallUrl.concat("&since=" + params[i]);
                    else
                        parcelsListGetCallUrl = parcelsListGetCallUrl.concat("&updatedSince=" + params[i]);
                    break;
                case 6:
                    if(params[4].equalsIgnoreCase("CREATED_AT"))
                        parcelsListGetCallUrl = parcelsListGetCallUrl.concat("&until=" + params[i]);
                    else
                        parcelsListGetCallUrl = parcelsListGetCallUrl.concat("&updatedUntil=" + params[i]);
                    break;
                case 7:
                    parcelsListGetCallUrl = parcelsListGetCallUrl.concat("&shopStoreId=" + params[i]);
            }
        }
        System.out.println("Parcels List Get Call URL : " + parcelsListGetCallUrl);
        return parcelsListGetCallUrl;
    }

    public String parcelsListStatusFilterGetCallUrl(String url,String status)
    {
        String parcelsListGetCallUrl = url.concat("&status=");
        String statusValue = status.toLowerCase();
        statusValue = statusValue.replaceAll(" ","-");
        parcelsListGetCallUrl = parcelsListGetCallUrl.concat(statusValue);
        return parcelsListGetCallUrl;
    }

    public String parcelsListPaymentStatusFilterGetCallUrl(String url,String status)
    {
        String parcelsListGetCallUrl = url.concat("&paymentStatus=");
        String statusValue = status.toLowerCase();
        statusValue = statusValue.replaceAll(" ","-");
        parcelsListGetCallUrl = parcelsListGetCallUrl.concat(statusValue);
        return parcelsListGetCallUrl;
    }

    public int getShopId(String shopName)
    {
        ShopListModel shopListModel = shopListGetCall();
        int shopSize = shopListModel.getBody().getShops().size();
        System.out.println("Shop Size : " + shopSize);
        int shopId = 0;
        for(int i=0;i<shopSize;i++)
        {
            if(shopListModel.getBody().getShops().get(i).getSHOP_NAME().equalsIgnoreCase(shopName))
            {
                shopId = shopListModel.getBody().getShops().get(i).getID();
                System.out.println("Shop Id : " + shopId);
                break;
            }
        }
        return shopId;
    }

    public int getStoreId(String shopName,String storeName)
    {
        ShopInfoModel shopInfoModel = shopInfoGetCall(getShopId(shopName));
        int storeSize = shopInfoModel.getBody().size();
        int storeId = 0;
        for(int i=0;i<storeSize;i++)
        {
            if(shopInfoModel.getBody().get(i).getNAME().equalsIgnoreCase(storeName))
            {
                storeId = shopInfoModel.getBody().get(i).getID();
                break;
            }
        }
        return storeId;
    }

    public String getStoreAddress(String shopName,String storeName)
    {
        ShopInfoModel shopInfoModel = shopInfoGetCall(getShopId(shopName));
        int storeSize = shopInfoModel.getBody().size();
        System.out.println("Store Size : " + storeSize);
        String storeAddress = new String();
        for(int i=0;i<storeSize;i++)
        {
            if(shopInfoModel.getBody().get(i).getNAME().equalsIgnoreCase(storeName))
            {
                storeAddress = shopInfoModel.getBody().get(i).getADDRESS();
                System.out.println("Store Address : " + storeAddress);
                break;
            }
        }
        return storeAddress;
    }

    public int getAreaId(String division, String district, String area)
    {
        AreaTreeModel areaTreeModel = areaTreeGetCall();
        int divisionSize = areaTreeModel.getBody().getDivisions().size();
        int i,j,k,areaId = 0;
        for(i=0;i<divisionSize;i++)
        {
            if(areaTreeModel.getBody().getDivisions().get(i).getNAME().equalsIgnoreCase(division))
            {
                int districtSize = areaTreeModel.getBody().getDivisions().get(i).getDistricts().size();
                for(j=0;j<districtSize;j++)
                {
                    if(areaTreeModel.getBody().getDivisions().get(i).getDistricts().get(j).getNAME().equalsIgnoreCase(district))
                    {
                        int areaSize = areaTreeModel.getBody().getDivisions().get(i).getDistricts().get(j).getAreas().size();
                        for(k=0;k<areaSize;k++)
                        {
                            if(areaTreeModel.getBody().getDivisions().get(i).getDistricts().get(j).getAreas().get(k).getNAME().equalsIgnoreCase(area))
                                areaId = areaTreeModel.getBody().getDivisions().get(i).getDistricts().get(j).getAreas().get(k).getID();
                        }
                    }
                }
            }
        }
        return areaId;
    }

    public List<String> getDeliveryChargesInfo(int shopId, int areaId, int weight, int cash)
    {
        List<String> deliveryCharges = new ArrayList<>();
        DeliveryChargeModel deliveryChargeModel = deliveryChargeGetCall(shopId,areaId,weight,cash);
        deliveryCharges.add(deliveryChargeModel.getBody().getPricing().getSHOPUP_CHARGE());
        deliveryCharges.add(String.valueOf(deliveryChargeModel.getBody().getPricing().getDISCOUNT_AMOUNT()));
        deliveryCharges.add(String.valueOf(deliveryChargeModel.getBody().getPricing().getSHOPUP_COD_CHARGE()));
        deliveryCharges.add(String.valueOf(deliveryChargeModel.getBody().getPricing().getPAYABLE_AMOUNT()));
        return deliveryCharges;
    }

    public String allPaymentsListGetCallUrl(String shopName,int limit,int offset)
    {
        int shopId = getShopId(shopName);
        String alLPaymentsListGetCall = "v2/logistics/shop/" + shopId + "/payments?limit=" + limit + "&offset=" + offset;
        return alLPaymentsListGetCall;
    }

    public String paymentsListGetCallUrl(String url,long ...params)
    {
        /* Parameters Order : (long storeId,long since,long until) */
        String paymentsListGetCall = url;
        for(int i=0;i<params.length;i++)
        {
            if(params[i]!=0)
            {
                switch (i)
                {
                    case 0:
                        paymentsListGetCall = paymentsListGetCall.concat("" + params[i]);
                        break;
                    case 1:
                        paymentsListGetCall = paymentsListGetCall.concat("&since=" + params[i]);
                        break;
                    case 2:
                        paymentsListGetCall = paymentsListGetCall.concat("&until=" + params[i]);
                        break;
                }
            }
        }
        System.out.println("Payments List Get Call URL : " + paymentsListGetCall);
        return paymentsListGetCall;
    }
}



