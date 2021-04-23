package services.redxMethods;

import com.google.gson.Gson;
import io.restassured.response.Response;
import services.responseModels.redxModels.*;
import services.serviceUtils.EndPoints;
import services.serviceUtils.ShopUpPostMan;

import java.util.*;


public class GetRedxApiResponse {
    private ShopUpPostMan shopUpPostMan;
    private String module;
    private Gson gson;
    private Random random;

    public GetRedxApiResponse(String module)
    {
        this.module = module;
        shopUpPostMan = new ShopUpPostMan(module);
        gson = new Gson();
        random = new Random();
    }

    public ShopListModel shopListGetCall()
    {
        String shopListGetCall = EndPoints.VERSION1 + EndPoints.SHOP + "?isRedX=true";
        Response getShopListResponse = shopUpPostMan.getCall(shopListGetCall);
        ShopListModel shopListModel = gson.fromJson(getShopListResponse.getBody().asString(),ShopListModel.class);
        return shopListModel;
    }

    public ShopInfoModel shopInfoGetCall(int shopId)
    {
        String shopInfoGetCall = EndPoints.VERSION1 + EndPoints.LOGISTICS + EndPoints.SHOP_STORES + shopId;
        Response getShopInfoResponse = shopUpPostMan.getCall(shopInfoGetCall);
        System.out.println(getShopInfoResponse.getBody().asString());
        ShopInfoModel shopInfoModel = gson.fromJson(getShopInfoResponse.getBody().asString(),ShopInfoModel.class);
        System.out.println("Locations : " + shopInfoModel.getBody().size());
        return shopInfoModel;
    }

    public AreaTreeModel areaTreeGetCall()
    {
        String areaTreeGetCall = EndPoints.VERSION1 + EndPoints.LOGISTICS + EndPoints.ADDRESS_MAPPING + EndPoints.AREA_TREE;
        Response getAreaListResponse = shopUpPostMan.getCall(areaTreeGetCall);
        AreaTreeModel areaTreeModel = gson.fromJson(getAreaListResponse.getBody().asString(),AreaTreeModel.class);
        return areaTreeModel;
    }

    /*--------------------Authentication--------------------*/

    public Response requestLoginCodePostCall(String phone)
    {
        String requestLoginCodeUrl = EndPoints.VERSION1 + EndPoints.USER + EndPoints.REQUEST_LOGIN_CODE;
        Map requestLoginCodeBody = new HashMap();
        requestLoginCodeBody.put("countryCode","BD");
        requestLoginCodeBody.put("callingCode","+880");
        requestLoginCodeBody.put("phoneNumber",phone);
        requestLoginCodeBody.put("service","redx");

        Response requestLoginCodeResponse = shopUpPostMan.postCall(requestLoginCodeUrl,requestLoginCodeBody);
        return requestLoginCodeResponse;
    }

    public Response loginWithCodePostCall(String phone,String otp)
    {
        String loginWithCodeUrl = EndPoints.VERSION1 + EndPoints.USER + EndPoints.LOGIN_WITH_CODE;
        Map loginWithCodeBody = new HashMap();
        loginWithCodeBody.put("loginCode",otp);
        loginWithCodeBody.put("phone",phone);

        Response loginWithCodeResponse = shopUpPostMan.postCall(loginWithCodeUrl,loginWithCodeBody);
        System.out.println("API cookies" + loginWithCodeResponse.getCookies().toString());

        return loginWithCodeResponse;
    }


    /*--------------------Dashboard Page--------------------*/

    public OverviewModel overviewGetCall(long since, long until)
    {
        String overviewGetCall = "v1/admin/shop/532439/logistics/dashboard/overview?since=" + since + "&until=" + until;
        Response getOverviewResponse = shopUpPostMan.getCall(overviewGetCall);
        OverviewModel overviewModel = gson.fromJson(getOverviewResponse.getBody().asString(),OverviewModel.class);
        return  overviewModel;
    }

    public OverviewModel overviewGetCall(long since,long until,long shopId,long storeId)
    {
        String overviewGetCall = EndPoints.VERSION1 + EndPoints.ADMIN + EndPoints.SHOP + shopId + EndPoints.LOGISTICS + EndPoints.DASHBOARD + EndPoints.OVERVIEW + "?since=" + since + "&until=" + until + "&shopStoreId=" + storeId;
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
        String deliveryChargeGetCall = EndPoints.VERSION1 + EndPoints.LOGISTICS + EndPoints.SHOP + shopId + "/charge-calculation?deliveryAreaId=" + areaId + "&weight=" + weight + "&cash=" + cash;
        Response deliveryChargeResponse = shopUpPostMan.getCall(deliveryChargeGetCall);
        DeliveryChargeModel deliveryChargeModel = gson.fromJson(deliveryChargeResponse.getBody().asString(),DeliveryChargeModel.class);
        return deliveryChargeModel;
    }

    public CreateParcelModel createParcelPostCall(String shopName,Map createParcelBody)
    {
        int shopId = getShopId(shopName);
        System.out.println("\nCreating Parcel\n");
        String createParcelPostCall = EndPoints.VERSION1 + EndPoints.ADMIN + EndPoints.SHOP + shopId + EndPoints.LOGISTICS + EndPoints.PARCELS;
        Response createParcelResponse = shopUpPostMan.postCall(createParcelPostCall,createParcelBody);
        CreateParcelModel createParcelModel = gson.fromJson(createParcelResponse.getBody().asString(),CreateParcelModel.class);
        return createParcelModel;
    }

    /*--------------------Coupons Page--------------------*/

    public CouponsModel couponsListGetCall(String shopName)
    {
        int merchantId = getShopId(shopName);
        String couponsListGetCall = EndPoints.VERSION1 + EndPoints.LOGISTICS + EndPoints.COUPONS + "/usage?merchantId=" + merchantId;
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
        String paymentDetailsListGetCall = EndPoints.VERSION2 + EndPoints.LOGISTICS + EndPoints.SHOP + shopId + "/payments/" + invoiceId + "/parcels";
        Response paymentDetailsListResponse = shopUpPostMan.getCall(paymentDetailsListGetCall);
        PaymentDetailsModel paymentDetailsModel = gson.fromJson(paymentDetailsListResponse.getBody().asString(),PaymentDetailsModel.class);
        return paymentDetailsModel;
    }

    /*--------------------Track Parcel Page--------------------*/

    public TrackParcelModel trackParcelGetCall(String trackingId)
    {
        String trackParcelGetCall = EndPoints.VERSION1 + EndPoints.LOGISTICS + EndPoints.TRACKING + trackingId;
        Response trackParcelResponse = shopUpPostMan.getCall(trackParcelGetCall);
        TrackParcelModel trackParcelModel = gson.fromJson(trackParcelResponse.getBody().asString(),TrackParcelModel.class);
        return trackParcelModel;
    }

    /*--------------------My Payment Details Page--------------------*/

    public MyPaymentDetailsModel paymentDetailsGetCall(int shopId)
    {
        String paymentDetailsGetCall = EndPoints.VERSION1 + EndPoints.ADMIN + EndPoints.SHOP + shopId + EndPoints.PAYMENT;
        Response myPaymentDetailsResponse = shopUpPostMan.getCall(paymentDetailsGetCall);
        MyPaymentDetailsModel myPaymentDetailsModel = gson.fromJson(myPaymentDetailsResponse.getBody().asString(),MyPaymentDetailsModel.class);
        return myPaymentDetailsModel;
    }

    public BanksModel bankListGetCall()
    {
        String bankListGetCall = EndPoints.VERSION1 + EndPoints.BANKS;
        Response bankListResponse = shopUpPostMan.getCall(bankListGetCall);
        BanksModel banksModel = gson.fromJson(bankListResponse.getBody().asString(),BanksModel.class);
        return banksModel;
    }

    public BranchesModel branchListGetCall(int bankId)
    {
        String branchListGetCall = EndPoints.VERSION1 + EndPoints.BANKS + bankId + EndPoints.BRANCHES;
        Response branchListResponse = shopUpPostMan.getCall(branchListGetCall);
        BranchesModel branchesModel = gson.fromJson(branchListResponse.getBody().asString(),BranchesModel.class);
        return branchesModel;
    }

    /*--------------------Coverage Area Page--------------------*/

    public PricingModel pricingListGetCall()
    {
        String pricingListGetCall = EndPoints.VERSION1 + EndPoints.LOGISTICS + EndPoints.PRICING + "?isAreas=true";
        Response pricingListResponse = shopUpPostMan.getCall(pricingListGetCall);
        PricingModel pricingModel = gson.fromJson(pricingListResponse.getBody().asString(),PricingModel.class);
        return pricingModel;
    }

    /*--------------------Credit History Page--------------------*/

    public CreditTransactionLogModel creditTransactionLogGetCall(int shopId)
    {
        String creditTransactionLogGetCall = EndPoints.VERSION1 + EndPoints.LOGISTICS + EndPoints.CREDITS + shopId + EndPoints.TRANSACTION_LOG;
        Response creditTransactionLogResponse = shopUpPostMan.getCall(creditTransactionLogGetCall);
        CreditTransactionLogModel creditTransactionLogModel = gson.fromJson(creditTransactionLogResponse.getBody().asString(),CreditTransactionLogModel.class);
        return creditTransactionLogModel;
    }

    public CreditTransactionLogModel creditTransactionLogGetCall(int shopId, long since, long until)
    {
        String creditTransactionLogGetCall = EndPoints.VERSION1 + EndPoints.LOGISTICS + EndPoints.CREDITS + shopId + EndPoints.TRANSACTION_LOG + "/?since=" + since + "&until=" + until;
        Response creditTransactionLogResponse = shopUpPostMan.getCall(creditTransactionLogGetCall);
        CreditTransactionLogModel creditTransactionLogModel = gson.fromJson(creditTransactionLogResponse.getBody().asString(),CreditTransactionLogModel.class);
        return creditTransactionLogModel;
    }

    /*--------------------Functions--------------------*/

    public String performAuthentication(String phone,String otp)
    {
        requestLoginCodePostCall(phone);
        Response loginResponse = loginWithCodePostCall(phone,otp);
        String ck = loginResponse.getCookie("__ti__");
        return ck;
    }

    public String allParcelsListGetCallUrl(long storeId,int ...params)
    {
        /* Parameters Order : (long storeId,int page,int limit,int offset,int sort) */
        /* Default Values : (532439,1,20,0,0) */
        String allParcelsListGetCallUrl = EndPoints.VERSION1 + EndPoints.ADMIN + EndPoints.SHOP + storeId + EndPoints.LOGISTICS + "/parcels?";
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
        if(statusValue.equalsIgnoreCase("hold"))
            statusValue = "on-hold";
        parcelsListGetCallUrl = parcelsListGetCallUrl.concat(statusValue);
        return parcelsListGetCallUrl;
    }

    public String getRandomParcelId(String shopName)
    {
        System.out.println("Getting Random Parcel Id");
        long storeId = getShopId(shopName);
        int page = 1,limit=20,offset=0,sort=0;
        ParcelsListModel parcelsListModel = parcelsListModel(allParcelsListGetCallUrl(storeId,page,limit,offset,sort));
        int size = parcelsListModel.getBody().getParcels().size();
        System.out.println("Size : " + size);
        int index = random.nextInt(size);
        System.out.println("Index : " + index);
        String parcelId = parcelsListModel.getBody().getParcels().get(index).getID();
        System.out.println("Parcel Id : " + parcelId);
        return parcelId;
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
        System.out.println("Getting Shop Id of : " + shopName);
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

    public String[] getRandomArea()
    {
        System.out.println("Getting Random Area");
        int size;
        int divisionIndex,districtIndex,areaIndex;
        String area[] = new String[3];
        AreaTreeModel areaTreeModel = areaTreeGetCall();

        size = areaTreeModel.getBody().getDivisions().size();
        divisionIndex = random.nextInt(size);
        area[0] = areaTreeModel.getBody().getDivisions().get(divisionIndex).getNAME();
        System.out.println("Division : " + area[0]);

        size = areaTreeModel.getBody().getDivisions().get(divisionIndex).getDistricts().size();
        districtIndex = random.nextInt(size);
        area[1] = areaTreeModel.getBody().getDivisions().get(divisionIndex).getDistricts().get(districtIndex).getNAME();
        System.out.println("District : " + area[1]);

        size = areaTreeModel.getBody().getDivisions().get(divisionIndex).getDistricts().get(districtIndex).getAreas().size();
        areaIndex = random.nextInt(size);
        area[2] = areaTreeModel.getBody().getDivisions().get(divisionIndex).getDistricts().get(districtIndex).getAreas().get(areaIndex).getNAME();
        System.out.println("Area : " + area[2]);
        return area;
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
        String alLPaymentsListGetCall = EndPoints.VERSION2 + EndPoints.LOGISTICS + EndPoints.SHOP + shopId + "/payments?limit=" + limit + "&offset=" + offset;
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

    public List<String > getTrackingDateValues(TrackParcelModel trackParcelModel)
    {
        int size = trackParcelModel.getTracking().size();
        List<String> dateValues = new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            dateValues.add(trackParcelModel.getTracking().get(i).getTime());
        }
        System.out.println(dateValues.toString());
        return dateValues;
    }

    public List<String> getMyPaymentDetails(int shopId,String method)
    {
        List<String> details = new ArrayList<>();
        MyPaymentDetailsModel myPaymentDetailsModel = paymentDetailsGetCall(shopId);
        switch (method)
        {
            case "Bank":
                details.add(myPaymentDetailsModel.getPayment().getBANK_NAME());
                details.add(myPaymentDetailsModel.getPayment().getACCOUNT_NAME());
                details.add(myPaymentDetailsModel.getPayment().getBRANCH_NAME());
                details.add(myPaymentDetailsModel.getPayment().getACCOUNT_NUMBER());
                break;
            case "Bkash":
                details.add(myPaymentDetailsModel.getPayment().getBKASH_NUMBER());
                break;
        }
        return details;
    }

    public int getBankId(String bankName)
    {
        BanksModel banksModel = bankListGetCall();
        int bankId = 0;
        for(int i=0;i<banksModel.getBanks().size();i++)
        {
            if(banksModel.getBanks().get(i).getBANK_NAME().equalsIgnoreCase(bankName))
                bankId = banksModel.getBanks().get(i).getID();
        }
        return bankId;
    }

    public String getRandomArea(String zone)
    {
        int zoneIndex = getZoneIndex(zone);
        PricingModel pricingModel = pricingListGetCall();
        int areas = pricingModel.getZones().get(zoneIndex).getAREAS().size();
        int areaIndex = random.nextInt(areas);
        String area = pricingModel.getZones().get(zoneIndex).getAREAS().get(areaIndex).getNAME();
        return area;
    }

    public int getZoneIndex(String zone)
    {
        PricingModel pricingModel = pricingListGetCall();
        int zones = pricingModel.getZones().size();
        int zoneIndex = 0;
        for(int i=0;i<zones;i++)
        {
            if(pricingModel.getZones().get(i).getNAME().equalsIgnoreCase(zone))
                zoneIndex = i;
        }
        return zoneIndex;
    }
}



