package services.redxMethods;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import services.responseModels.redxModels.OverviewModel;
import services.responseModels.redxModels.ParcelsListModel;
import services.serviceUtils.ShopUpPostMan;

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

    public OverviewModel overviewGetCall(long since, long until)
    {
        String overviewGetCall = "admin/shop/532439/logistics/dashboard/overview?since=" + since + "&until=" + until;
        Response getOverviewResponse = shopUpPostMan.getCall(overviewGetCall);
        OverviewModel overviewModel = gson.fromJson(getOverviewResponse.getBody().asString(),OverviewModel.class);
        return  overviewModel;
    }

    public OverviewModel overviewGetCall(long since,long until,long storeId)
    {
        String overviewGetCall = "admin/shop/532439/logistics/dashboard/overview?since=" + since + "&until=" + until + "&shopStoreId=" + storeId;
        Response getOverviewResponse = shopUpPostMan.getCall(overviewGetCall);
        OverviewModel overviewModel = gson.fromJson(getOverviewResponse.getBody().asString(),OverviewModel.class);
        return  overviewModel;
    }

    public ParcelsListModel parcelsListModel(String url)
    {

        Response getParcelsListResponse = shopUpPostMan.getCall(url);
//        System.out.println(getParcelsListResponse.getBody().asString());
        ParcelsListModel parcelsListModel = gson.fromJson(getParcelsListResponse.getBody().asString(),ParcelsListModel.class);
        return parcelsListModel;
    }


    /*-----------Functions----------*/

    public String allParcelsListGetCallUrl(long storeId,int ...params)
    {
        /* Parameters Order : (long storeId,int page,int limit,int offset,int sort) */
        /* Default Values : (532439,1,20,0,0) */
        String allParcelsListGetCallUrl = "admin/shop/" + storeId + "/logistics/parcels?";
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
        /* Parameters Order : (String allParcelsListGetCall,String trackingId, String InvoiceId, String numberOrName, String dateFilterType, long since, long until) */
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
            }
        }
        System.out.println("Parcels List Get Call URL : " + parcelsListGetCallUrl);
        return parcelsListGetCallUrl;
    }
}

