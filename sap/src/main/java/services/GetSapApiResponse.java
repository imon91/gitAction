package services;

import com.google.gson.Gson;
import dataParcer.CSVParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import services.serviceUtils.ShopUpPostMan;

import java.io.File;
import java.util.*;

public class GetSapApiResponse {

//    private ShopUpPostMan shopUpPostMan;
    private final String module;
    private Gson gson;

    public GetSapApiResponse(String module)
    {
        this.module=module;
//        shopUpPostMan = new ShopUpPostMan(module);
        gson = new Gson();
    }

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

    public Response uploadFile(String cookie, String path)
    {
        String uploadFile = "https://shopups1.xyz/v2/logistics/parcel/import/excel";
        File file = new File(path);
        Response response = RestAssured.given().header("Content-Type","multipart/form-data")
                .header("cookie",cookie).multiPart(file).when().post(uploadFile);
        ImportParcelModel importParcelModel = gson.fromJson(response.toString(),ImportParcelModel.class);
        System.out.println("Import Parcel is Error : " + importParcelModel.isError() + "\n");
        return response;
    }

    public List<String> uploadFilePostCall(String cookie,String path)
    {
        String uploadParcels ="https://shopups1.xyz/v2/admin/shop/648106/logistics/parcels";

        Map uploadFileBody = new HashMap();
        List<HashMap<String, Object>> list = CSVParser.getHashListForDataPath(path);
        System.out.println("Number of Parcels Uploaded in Thread " + Thread.currentThread().getId() + " = " + list.size() + "\n");
        uploadFileBody.put("parcels",list);
        JSONObject request = new JSONObject(uploadFileBody);

//        System.out.println("Upload File Body : " + uploadFileBody.toString() + "\n);

        List<String> invoiceNumber = new ArrayList<String>();
        for(int i=0;i<list.size();i++)
        {
            invoiceNumber.add(list.get(i).get("INVOICE_NUMBER").toString());
        }

        System.out.println("Invoice Numbers of Thread " + Thread.currentThread().getId() + " is " + invoiceNumber + "\n");
//        System.out.println("Invoice Number Size : " + invoiceNumber.size());

        Response response = RestAssured.given().header("Content-Type","application/json")
                .header("cookie",cookie)
                .body(request.toJSONString()).when().post(uploadParcels);
//        System.out.println("Upload File Response : "+ response.getBody().asString() + "\n);
        return invoiceNumber;
    }

    public Response getParcelCreateLog(String cookie)
    {
        String bulkParcelGetCall = "https://shopups1.xyz/v2/admin/shop/648106/logistics/bulk-parcel-create-log";
        Response response = RestAssured.given().header("Content-Type", "application/json")
                .header("cookie",cookie).when().get(bulkParcelGetCall);
        System.out.println("Parcel Create Log Response in Thread id " + Thread.currentThread().getId() + " : " + response.asString() + "\n");
        return response;
    }

    public Response getParcelsReceiveHub(String cookie)
    {
        String receiveParcelsPostCall = "https://sap.shopups1.xyz/api/logistics/get-parcels?filterOutProblematic=true&limit=5000&offset=0&page=1&parcelType=regular&phone=&shop=648106&status=pickup-pending&status=pickup-in-progress&status=picked-up";
        Map body = new HashMap();
        Response response = RestAssured.given().header("Content-Type","application/json")
                .header("cookie",cookie).body(body).when().post(receiveParcelsPostCall);
        return response;
    }

    public Response sendToSortingPostCall(String cookie, List<String> parcelIds)
    {
        String bulkParcelReceivePostCall = "https://sap.shopups1.xyz/api/logistics/parcel/status/bulk";

        Map body = new HashMap();
        List<HashMap<String, Object>> hashList = getBodyForSorting(parcelIds);
        body.put("parcels",hashList);
        body.put("action","received-from-seller");
        body.put("lineHaulId",null);
        body.put("forceNewBulkTransferId",null);

        JSONObject request = new JSONObject(body);
        Response response = RestAssured.given().header("Content-Type","application/json")
            .header("cookie",cookie).body(request.toJSONString()).when().put(bulkParcelReceivePostCall);
        return response;
    }

    public Response getDispatchParcelsHub(String cookie)
    {
        String dipatchParcelsGetCall = "https://sap.shopups1.xyz/api/logistics/parcels?filterOutProblematic=true&hubId=2&limit=50000&offset=0&page=1&parcelType=regular&partnerId=3&sourceHubId=8&status=ready-for-delivery&type=dispatch";
        Response response = RestAssured.given().header("Content-Type", "application/json")
                .header("cookie",cookie).when().get(dipatchParcelsGetCall);
        return response;
    }

    public Response downloadModule(String cookie, String Id)
    {
        String parcelsSearchGetCall = "https://sap.shopups1.xyz/api/logistics/run-sheets?" + Id;
        Response response = RestAssured.given().header("Content-Type", "application/json")
                .header("cookie",cookie).when().get(parcelsSearchGetCall);
        return  response;
    }



    public List<HashMap<String, Object>> getBodyForSorting(List<String> parcelIds)
    {
        List<HashMap<String, Object>> parcelsList = new ArrayList<>();
        int i;
        for(i=0;i<parcelIds.size();i++)
        {
            HashMap<String,Object> parcel = new HashMap<>();
            parcel.put("id",parcelIds.get(i));
            parcel.put("currentStatus","ready-for-delivery");
            parcel.put("oldStatus","pickup-pending");
            parcel.put("sourceHubId","8");
            parcel.put("currentPartnerId",3);
            parcelsList.add(parcel);
        }
        return parcelsList;
    }

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

    public List<String> receiveParcels(String cookie,List<String> invoiceNumbers)
    {
        List<String> parcelIds = new ArrayList<>();
        int parcelSize;
        int i,j;

        Response receiveParcelsResponse = getParcelsReceiveHub(cookie);
//        System.out.println("Receive Parcel Response : " + receiveParcelsResponse + "\n);
        ReceiveParcelsModel receiveParcelsModel = gson.fromJson(receiveParcelsResponse.getBody().asString(),ReceiveParcelsModel.class);

        parcelSize = receiveParcelsModel.getParcels().size();

//        System.out.println("Invoice Number Size in Thread " + Thread.currentThread().getId() + " is : " + invoiceNumbers.size() + "\n");
        System.out.println("Total Parcels of Receive Module in Thread " + Thread.currentThread().getId() + " is : " + parcelSize + "\n");

        for(i=0;i<invoiceNumbers.size();i++)
        {
            for(j=0;j<parcelSize;j++)
            {
                if(receiveParcelsModel.getParcels().get(j).getInvoiceNumber().equalsIgnoreCase(invoiceNumbers.get(i)))
                {
                    parcelIds.add(receiveParcelsModel.getParcels().get(j).getId());
                }
            }
//            System.out.println("Invoice Number : " + invoiceNumbers.get(i) + " has Parcel Id " + parcelIds.get(i) + " in Thread : " + Thread.currentThread().getId() + "\n");
        }
//        System.out.println("Parcel Ids of Thread " + Thread.currentThread().getId() + " is " + parcelIds);
//        System.out.println("ParcelId Size = " + parcelIds.size() + "\n");
        return parcelIds;
    }

    public void sendToSorting(String cookie, List<String> parcelIds)
    {
        String bulkId;
        Response sendToSortingResponse = sendToSortingPostCall(cookie,parcelIds);
//        System.out.println("Send To Sorting Response : " + sendToSortingResponse + "\n);
        ReceiveSendToSortingModel model = gson.fromJson(sendToSortingResponse.getBody().asString(),ReceiveSendToSortingModel.class);
        bulkId = model.getBulkId();
    }

    public String getBulkTransferId(String cookie,List<String > parcelIds)
    {
        int i,j;
        List<String> bulkIds = new ArrayList<>();
        String  bulkTransferId = new String();
        Response dispatchParcelsResponse = getDispatchParcelsHub(cookie);
//        System.out.println("Dispatch Load Parcel Response : " + dispatchParcelsResponse + "\n);
        DipatchParcelsModel dipatchParcelsModel = gson.fromJson(dispatchParcelsResponse.getBody().asString(),DipatchParcelsModel.class);

        if(dipatchParcelsModel.isError())
            System.out.println("Error in Dispatch Load Parcel : " + dipatchParcelsModel.isError());
        else
            for(i=0;i<parcelIds.size();i++)
            {
                for(j=0;j<dipatchParcelsModel.getParcels().size();j++)
                {
                    if(dipatchParcelsModel.getParcels().get(j).getId().equalsIgnoreCase(parcelIds.get(i)))
                    {
                        bulkIds.add(dipatchParcelsModel.getParcels().get(j).getBulkTransferId());
                    }
                }
                bulkTransferId = bulkIds.get(i);
//            System.out.println("Bulk Transfer Id of Parcel Id " + parcelIds.get(i) + " is " + bulkIds.get(i) + " in Thread : " + Thread.currentThread().getId() + "\n);
            }
        System.out.println("Bulk Transfer Id in Thread : " + Thread.currentThread().getId() + " is " + bulkIds.get(0) + "\n");
        return  bulkTransferId;
    }

    public Boolean[] verifyInDownloadModule(String cookie, String bulkTransferId,List<String> parcelIds)
    {
        Boolean[] assertValue = new Boolean[5];
        Response searchDownloadResponse1 = downloadModule(cookie,"bulkTransferId="+bulkTransferId);
        DownloadModel downloadModel1 = gson.fromJson(searchDownloadResponse1.getBody().asString(),DownloadModel.class);
        System.out.println("Sheet Size for Bulk Transfer Id in Thread " + Thread.currentThread().getId() + " is : " + downloadModel1.getSheets().size() + "\n");
        String runsheetId1 = downloadModel1.getSheets().get(0).getBulkId();
        int parcels1 = downloadModel1.getSheets().get(0).getTotalParcels();
        String bulkTransferId1 = downloadModel1.getSheets().get(0).getBulkTransferId();

        Response searchDownloadResponse2 = downloadModule(cookie,"bulkId="+runsheetId1);
        DownloadModel downloadModel2 = gson.fromJson(searchDownloadResponse1.getBody().asString(),DownloadModel.class);
        System.out.println("Sheet Size for RunSheet Id in Thread " + Thread.currentThread().getId() + " is : " + downloadModel2.getSheets().size());
        String runsheetId2 = downloadModel2.getSheets().get(0).getBulkId();
        String bulkTransferId2 = downloadModel2.getSheets().get(0).getBulkTransferId();
        int parcels2 = downloadModel2.getSheets().get(0).getTotalParcels();

        System.out.println("Total Parcels = " + parcels1 + " : " + parcels2 +" in Thread : " + Thread.currentThread().getId() + "\n");
        System.out.println("Bulk Transfer Id = " + bulkTransferId1 + " : " + bulkTransferId2 +" in Thread : " + Thread.currentThread().getId() + "\n");
        System.out.println("Runsheet Id = " + runsheetId1 + " : " + runsheetId2 +" in Thread : " + Thread.currentThread().getId() + "\n");


        assertValue[0]=runsheetId1.equalsIgnoreCase(runsheetId2);
        assertValue[1]=bulkTransferId1.equalsIgnoreCase(bulkTransferId2);
        assertValue[2]=(parcels1==parcels2);
        assertValue[3]=(parcels1==parcelIds.size());

        return assertValue;
    }

    public Boolean[] getBulkId(String cookie, String csvFilePath, String xlsxFilePath)
    {
        int i,j,count=0;
        Boolean[] assertValue = new Boolean[5];
        String bulkTransferId;
        List<String> invoiceNumbers = new ArrayList<String>();
        List<String> parcelIds = new ArrayList<String>();
        List<String> bulkIds = new ArrayList<String>();

        invoiceNumbers = uploadFilePostCall(cookie,csvFilePath);

//        Response bulkParcelLogResponse = getParcelCreateLog(cookie);
//        BulkCreateParcelLogModel bulkCreateParcelLogModel = gson.fromJson(bulkParcelLogResponse.getBody().asString(),BulkCreateParcelLogModel.class);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parcelIds = receiveParcels(cookie,invoiceNumbers);
        while(parcelIds.size()!=invoiceNumbers.size())
        {
            count++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Loading Parcels in Receive Module \n");
            parcelIds = receiveParcels(cookie,invoiceNumbers);
            if(count>100)
            {
                System.out.println("Loop OverRun");
                break;
            }
        }

        System.out.println("Parcel Ids of Thread " + Thread.currentThread().getId() + " is " + parcelIds);

        sendToSorting(cookie,parcelIds);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bulkTransferId = getBulkTransferId(cookie,parcelIds);

        assertValue = verifyInDownloadModule(cookie,bulkTransferId,parcelIds);

        for(i=0;i<4;i++)
        {
            if(assertValue[i].equals(Boolean.TRUE))
                assertValue[4]=Boolean.TRUE;
            else assertValue[4]=Boolean.FALSE;
        }

        System.out.println("Assert Value in Thread " + Thread.currentThread().getId() + " is " + Arrays.toString(assertValue) +"\n");

        return assertValue;
    }

}
