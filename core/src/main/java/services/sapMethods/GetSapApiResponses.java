package services.sapMethods;

import com.google.gson.Gson;
import dataParcer.CSVParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import services.responseModels.sapModels.ParcelReasonsModel;
import services.responseModels.sapModels.ReceiveParcelsListModel;
import services.responseModels.sapModels.ReconciliationParcelListModel;
import services.serviceUtils.ShopUpPostMan;

import java.util.*;

public class GetSapApiResponses {

    private ShopUpPostMan shopUpPostMan;
    private final String module;
    private Random random;
    private Gson gson;

    public GetSapApiResponses(String module)
    {
        this.module=module;
        shopUpPostMan = new ShopUpPostMan(module);
        random = new Random();
        gson = new Gson();
    }

    /*----------Authentication----------*/

    public Response requestLoginCodePostCall()
    {
        String requestLoginCode = "https://shopups1.xyz/v1/user/request-login-code";
        Map requestLoginCodeBody = new HashMap();
        requestLoginCodeBody.put("countryCode","BD");
        requestLoginCodeBody.put("callingCode","+880");
        requestLoginCodeBody.put("phoneNumber","1401122188");

//        System.out.println("Request Login Code Body : " + requestLoginCodeBody.toString() + "\n);

        JSONObject request = new JSONObject(requestLoginCodeBody);
        Response response = RestAssured.given().header("Content-Type","application/json")
                .body(request.toJSONString()).when().post(requestLoginCode);
        return response;
    }

    public Response loginWithCodePostCall()
    {
        String loginWithCode ="https://shopups1.xyz/v1/user/login-with-code";
        Map loginWithCodeBody = new HashMap();
        loginWithCodeBody.put("loginCode","6666");
        loginWithCodeBody.put("phone","01401122188");

//        System.out.println("Login with Code Body : " + loginWithCodeBody.toString() + "\n);

        JSONObject request = new JSONObject(loginWithCodeBody);
        Response response = RestAssured.given().header("Content-Type","application/json")
                .body(request.toJSONString()).when().post(loginWithCode);
        return response;
    }

    /*----------Import Parcel----------*/

    public List<String> uploadFilePostCall(int shopId, String path)
    {
        System.out.println("\nUploading File");

        String uploadParcels ="https://shopups1.xyz/v2/admin/shop/" + shopId + "/logistics/parcels";

        Map uploadFileBody = new HashMap();
        List<HashMap<String, Object>> list = CSVParser.getHashListForDataPath(path);
        System.out.println("Number of Parcels Uploaded = " + list.size() + "\n");
        uploadFileBody.put("parcels",list);

//        System.out.println("Upload File Body : " + uploadFileBody.toString() + "\n);

        List<String> invoiceNumber = new ArrayList<String>();
        for(int i=0;i<list.size();i++)
        {
            invoiceNumber.add(list.get(i).get("INVOICE_NUMBER").toString());
        }

//        System.out.println("Invoice Number Size : " + invoiceNumber.size());
//        System.out.println(invoiceNumber.toString());

        Response response = shopUpPostMan.postCall(uploadParcels,uploadFileBody);
//        System.out.println("Upload File Response : "+ response.getBody().asString() + "\n");
        return invoiceNumber;
    }

    /*----------Receive Hub Parcel----------*/

    public ReceiveParcelsListModel getParcelsReceiveHub(int shopId)
    {
        System.out.println("Getting Parcels List of shop " + shopId + " in Receive Module");
        String receiveParcelsPostCall = "https://sap.shopups1.xyz/api/logistics/parcels?filterOutProblematic=true&limit=5000&offset=0&page=1&parcelType=regular&shop=" + shopId + "&status=pickup-pending&status=pickup-in-progress&status=picked-up";
        Response receiveParcelsResponse = shopUpPostMan.getCall(receiveParcelsPostCall);
        System.out.println(receiveParcelsResponse.getBody().asString());
        ReceiveParcelsListModel receiveParcelsModel = gson.fromJson(receiveParcelsResponse.getBody().asString(),ReceiveParcelsListModel.class);
        return receiveParcelsModel;
    }

    public void receiveParcels(List<String> parcelIds)
    {
        System.out.println("\nReceiving Parcels\n");
        String action = "received-from-seller";
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/receiveParcelsData.csv";
//        List<HashMap<String, Object>> parcels = CSVParser.getHashListForDataPath(filePath);
        List<HashMap<String, Object>> parcels = new ArrayList<>();

        for(int i =0; i<parcelIds.size();i++)
        {
            HashMap<String, Object> parcel = new HashMap<>();
            parcel.put("id",parcelIds.get(i));
            parcel.put("currentStatus","ready-for-delivery");
            parcel.put("oldStatus","pickup-pending");
            parcel.put("sourceHubId",1);
            parcel.put("currentPartnerId",3);
            parcels.add(parcel);
//            parcels.get(i).put("id",parcelIds.get(i));
        }
        bulkStatusPutCall(parcels,action);
    }

    /*----------Dispatch To Agent----------*/

    public void assignAgent(List<String> parcelIds)
    {
        System.out.println("\nAssigning Agent to Parcels\n");
        String assignAgentPostCall = "https://shopups1.xyz/v1/logistics/auto-rider-assignment/common/assign-agents/1";
        Map data = new HashMap();
        data.put("id",2638);
        data.put("name","Abdul Alim - kalabagan");
        data.put("parcels",parcelIds);
        Map assignAgentBody = new HashMap();
        assignAgentBody.put("type","assign");
        assignAgentBody.put("data",data);
        Response response = shopUpPostMan.postCall(assignAgentPostCall,assignAgentBody);
    }

    public void dispatchParcelsToAgent(List<String> parcelIds)
    {
        System.out.println("\nDispatching Parcels To Agent\n");
        String action = "dispatched-to-agent";
        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/test/resources/testData/dispatchAgentData.csv";
//        List<HashMap<String, Object>> parcels = CSVParser.getHashListForDataPath(filePath);
        List<HashMap<String, Object>> parcels = new ArrayList<>();

        for(int i =0; i<parcelIds.size();i++)
        {
            HashMap<String, Object> parcel = new HashMap<>();
            parcel.put("id",parcelIds.get(i));
            parcel.put("currentStatus","delivery-in-progress");
            parcel.put("oldStatus","ready-for-delivery");
            parcel.put("deliveryAgentId",2638);
            parcel.put("sourceHubId",1);
            parcels.add(parcel);
//            parcels.get(i).put("id",parcelIds.get(i));
        }
        bulkStatusPutCall(parcels,action);
    }

    /*----------Bulk Status----------*/

    public void bulkStatusPutCall(List<HashMap<String, Object>> parcels, String action)
    {
        String bulkStatusUrl = "https://sap.shopups1.xyz/api/logistics/parcel/status/bulk";
        Map bulkStatusBody = new HashMap();
        bulkStatusBody.put("parcels",parcels);
        bulkStatusBody.put("action",action);
        bulkStatusBody.put("lineHaulId",null);
        bulkStatusBody.put("forceNewBulkTransferId",null);
        Response response = shopUpPostMan.putCall(bulkStatusUrl,bulkStatusBody);
//        System.out.println(response.getBody().asString());
    }

    /*----------Receive Problematic Parcels From Agents----------*/

    public Response reasonsListGetCall(String category)
    {
        String reasonsListGetCall = "https://shopups1.xyz/v2/logistics/reasons?category=" + category + "&module=delivery";
        Response reasonsListResponse = shopUpPostMan.getCall(reasonsListGetCall);
        return reasonsListResponse;
    }

    public void parcelActionPutCall(String action,String trackingId, Map reasons)
    {
        Map parcelActionBody = new HashMap();
        String currentStatus = new String();
        String actionValue = new String();

        switch (action)
        {
            case "hold":
                currentStatus = "agent-hold-returning";
                actionValue = "user-hold-returning";
                Date currentDate = new Date();
                long dateTime = currentDate.getTime();
                long deliveryDate = dateTime + (24*60*60*1000);
                parcelActionBody.put("deliveryDate",deliveryDate);
                parcelActionBody.put("remarks",reasons.get("Remarks"));
                parcelActionBody.put("holdReason",reasons.get("Reason"));
                parcelActionBody.put("reasonId",reasons.get("Id"));
                break;
            case "return":
                currentStatus = "agent-returning";
                actionValue = "user-parcel-returning";
                parcelActionBody.put("remarks",reasons.get("Remarks"));
                parcelActionBody.put("returnReason",reasons.get("Reason"));
                parcelActionBody.put("reasonId",reasons.get("Id"));
                break;
            case "areaChange":
                currentStatus = "agent-area-change";
                actionValue = "user-area-change";
                parcelActionBody.put("deliveryAddress","Address, Area, Code");
                parcelActionBody.put("holdComment","Area changed to Kalabagan");
                break;
            case "delivered":
                currentStatus = "delivered";
                actionValue = "user-delivered";
                break;
        }

        parcelActionBody.put("currentStatus",currentStatus);
        parcelActionBody.put("oldStatus","delivery-in-progress");
        parcelActionBody.put("action",actionValue);
        statusWithRemarkPutCall(trackingId,parcelActionBody);
    }

    public void statusWithRemarkPutCall(String trackingId,Map body)
    {
        String statusWithRemarkPutCall = "https://sap.shopups1.xyz/api/logistics/parcel/status-with-remarks/" + trackingId;
        Response statusWithRemarksResponse = shopUpPostMan.putCall(statusWithRemarkPutCall,body);
    }

    public ReconciliationParcelListModel reconciliationParcelListGetCall(List<String> trackingIds)
    {
        String trackingId = trackingIds.toString().replace(", ",",");
        String reconciliationParcelListGetCall = "https://shopups1.xyz/v3/logistics/reconciliation/cash/parcels?trackingIds=" + trackingId.substring(1,trackingId.length()-1);
        Response reconciliationParcelListResponse = shopUpPostMan.getCall(reconciliationParcelListGetCall);
        System.out.println(reconciliationParcelListResponse.getBody().asString());
        ReconciliationParcelListModel reconciliationParcelListModel = gson.fromJson(reconciliationParcelListResponse.getBody().asString(),ReconciliationParcelListModel.class);
        return reconciliationParcelListModel;
    }

    /*----------Functions----------*/

    public String performAuthentication()
    {
        String cookie;
        Response loginCodePostCall = requestLoginCodePostCall();
        //        System.out.println("Request Code Response : " + loginCodePostCall.getBody().asString()  + "\n);
        Response loginWithCodePostCall = loginWithCodePostCall();
        //        System.out.println("Login Response : " + loginWithCodePostCall.getBody().asString() + "\n);
        cookie = loginWithCodePostCall.header("Set-Cookie");
        //        System.out.println(cookie + "\n);
        int index = cookie.indexOf(";");
        return cookie.substring(0,index);
    }

    public List<String> getTrackingIds(ReceiveParcelsListModel receiveParcelsModel, List<String> invoiceNumbers)
    {
        List<String> trackingIds = new ArrayList<>();
        int parcelSize;
        int i,j;

        parcelSize = receiveParcelsModel.getParcels().size();
        System.out.println("Parcels : " + parcelSize);

        for(i=0;i<invoiceNumbers.size();i++)
        {
            for(j=0;j<parcelSize;j++)
            {
                if(receiveParcelsModel.getParcels().get(j).getInvoiceNumber().equalsIgnoreCase(invoiceNumbers.get(i)))
                {
                    trackingIds.add(receiveParcelsModel.getParcels().get(j).getId());
                }
            }
//            System.out.println("Invoice Number : " + invoiceNumbers.get(i) + " has Tracking Id " + trackingIds.get(i));
        }

        return trackingIds;
    }

    public List<Integer> getParcelIds(ReceiveParcelsListModel receiveParcelsModel, List<String> invoiceNumbers)
    {
        List<Integer> parcelIds = new ArrayList<>();
        int parcelSize;
        int i,j;

        parcelSize = receiveParcelsModel.getParcels().size();
//        System.out.println("Parcels : " + parcelSize);

        for(i=0;i<invoiceNumbers.size();i++)
        {
            for(j=0;j<parcelSize;j++)
            {
                if(receiveParcelsModel.getParcels().get(j).getInvoiceNumber().equalsIgnoreCase(invoiceNumbers.get(i)))
                {
                    parcelIds.add(receiveParcelsModel.getParcels().get(j).getParcel_id());
                }
            }
//            System.out.println("Invoice Number : " + invoiceNumbers.get(i) + " has Parcel Id " + parcelIds.get(i));
        }

        return parcelIds;
    }

    public Map getRandomReason(String action)
    {
        Map reasonMap = new HashMap();
        int reasonCategoriesSize,reasonCategoryIndex,reasonsSize,reasonIndex;
        ParcelReasonsModel parcelReasonsModel;

        Response reasonsListResponse = reasonsListGetCall(action);
        parcelReasonsModel = gson.fromJson(reasonsListResponse.getBody().asString(), ParcelReasonsModel.class);

        reasonCategoriesSize = parcelReasonsModel.getReasons().size();
        reasonCategoryIndex = random.nextInt(reasonCategoriesSize);
        reasonsSize = parcelReasonsModel.getReasons().get(reasonCategoryIndex).getREASONS().size();
        reasonIndex = random.nextInt(reasonsSize);

        reasonMap.put("Group", parcelReasonsModel.getReasons().get(reasonCategoryIndex).getGROUP());
        reasonMap.put("Remarks", parcelReasonsModel.getReasons().get(reasonCategoryIndex).getREASONS().get(reasonIndex).getREASON_BN());
        reasonMap.put("Reason", parcelReasonsModel.getReasons().get(reasonCategoryIndex).getREASONS().get(reasonIndex).getREASON_EN());
        reasonMap.put("Id",String.valueOf(parcelReasonsModel.getReasons().get(reasonCategoryIndex).getREASONS().get(reasonIndex).getREASON_ID()));

        return reasonMap;
    }

    public List<Map> getReconciliationStatuses(List<String> trackingIds)
    {
        List<Map> parcelActions = new ArrayList<>();
        ReconciliationParcelListModel reconciliationParcelListModel = reconciliationParcelListGetCall(trackingIds);
        int parcelSize;
        int i,j;

        parcelSize = reconciliationParcelListModel.getData().size();
        System.out.println("Parcels : " + parcelSize);

        for(i=0;i<trackingIds.size();i++)
        {
            for(j=0;j<parcelSize;j++)
            {
                if(reconciliationParcelListModel.getData().get(j).getTrackingId().equalsIgnoreCase(trackingIds.get(i)))
                {
                    Map parcels = new HashMap();
                    parcels.put("TRACKING_ID",reconciliationParcelListModel.getData().get(j).getTrackingId());
                    parcels.put("PARCEL_ID",reconciliationParcelListModel.getData().get(j).getParcelId());
                    parcels.put("CLOSING_STATUS",reconciliationParcelListModel.getData().get(j).getClosingStatus());
                    parcels.put("CLOSING_TIME",reconciliationParcelListModel.getData().get(j).getClosingTime());
                    parcelActions.add(parcels);
                }
            }
        }

        return parcelActions;
    }
}