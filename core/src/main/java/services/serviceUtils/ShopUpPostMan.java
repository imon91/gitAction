package services.serviceUtils;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ShopUpPostMan {

    // This Layer is basically to hit the get requests and send back the response

    private String baseURL;
    private String cookie;

    public ShopUpPostMan(String module){
        String app = System.getProperty(BuildParameterKeys.KEY_APP);
        String env = System.getProperty(BuildParameterKeys.KEY_ENV);
        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            // SET RESELLER COOKIE
            cookie = "_voonik_session=eyJ0ZXN0NCI6IkIiLCJjb3VudHJ5X2NvZGUiOjEsInRlc3QyIjoiQiIsInRlc3QzIjoiQSIsImdpZCI6IjQ5NjIyMSIsIndhcmRlbi51c2VyLnVzZXIua2V5IjpbIlVzZXIiLFsxMjI2OTRdLCIkMmEkMTAkbTk2VzJoZ0E3c3QuL2x6em1PTDJkLiJdLCJzZXNzaW9uX2lkIjoiYmI3YTdiOWJkNGU2NmMyN2NhYWM2NDg5ODAzODQyZjUiLCJ0ZXN0MSI6IkEiLCJjdXJyZW5jeV9jb2RlIjoiSU5SIn0_--d407c5368285e326358d9d76a678c8984cd596f2;";
        }else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            // SET MOKAM COOKIE
            cookie = "_voonik_session=eyJ0ZXN0NCI6IkIiLCJjb3VudHJ5X2NvZGUiOjEsInRlc3QyIjoiQiIsInRlc3QzIjoiQSIsImdpZCI6IjQ5NjIyMSIsIndhcmRlbi51c2VyLnVzZXIua2V5IjpbIlVzZXIiLFsxMjI2OTRdLCIkMmEkMTAkbTk2VzJoZ0E3c3QuL2x6em1PTDJkLiJdLCJzZXNzaW9uX2lkIjoiYmI3YTdiOWJkNGU2NmMyN2NhYWM2NDg5ODAzODQyZjUiLCJ0ZXN0MSI6IkEiLCJjdXJyZW5jeV9jb2RlIjoiSU5SIn0_--d407c5368285e326358d9d76a678c8984cd596f2;";
        }else {
            // SET WMS COOKIE
             cookie = "_ga=GA1.2.1936512597.1591177880; _warehouse_mgmt_service_session=ck5FZ2p0ODlFOHBTNW5FWXY0cFovM0hId1NIV0JyQVZGRG5TbTNZdjNVSFcvcUhGU0xiM3ZEZm9hUmFCd08wMzNPVHdnNWVGSCtxTzVJVUFkZTEwZGNTYXlTcmZ0aXNKckpaWTBzemtSZDI1em11SDgzTjB0L3R3VHFQTUhVNWovejVjK2JDYzV3SGlhbzBqN3c5SmN6am9LWERGQ2pJQmxsWHdwOStsd0EycCtZYUY0YjlpUTB1UFZqcUx4N1gzTDI0b3BPUmZ0T2RlMWRPcDdOTDZLamtRQk13aFVNR29vSWJlbXg2LzI2TEFIYzlXcmhBNkNJVWhEZWZleTZ2N0dUUVpNZElMS2M0ekxBRHQxYUNQQVQ1UmpJdUN5ZmlHRVRSR0lKaGo1bFJSbjBCY3hYVzltNktWT0VTNlBNK1NUaDk0Zzd6YXI3UVQzMzVNSjFkMU1HSVVlWUh2cGszUjh3MytUSkswdzc3eURzbnBhc05PVHBwK0dGbmVLZHlaalBnUjlMcy94YWx2dXp0dU9EcUs2QT09LS1iK3NaTmE3K3BhS3B3RUh2NHVFZmJBPT0%3D--1dbe1fec8774fc4be7ee8a07d394cdca6871cd41";
        }

        switch (module.toLowerCase()){
            case CoreConstants.MODULE_ANDROID_UI :
                switch (env){
                    case CoreConstants.ENV_STAGE :
                        switch (app){
                            case CoreConstants.APP_RESELLER : this.baseURL =
                                    CoreConstants.RESELLER_APP_STAGE_BASE_URL; break;
                            case CoreConstants.APP_MOKAM : this.baseURL =
                                    CoreConstants.MOKAM_APP_STAGE_BASE_URL; break;
                        }
                        break;
                    case CoreConstants.ENV_PROD :
                        switch (app){
                            case CoreConstants.APP_RESELLER : this.baseURL =
                                    CoreConstants.RESELLER_APP_PROD_BASE_URL; break;
                            case CoreConstants.APP_MOKAM : this.baseURL =
                                    CoreConstants.MOKAM_APP_PROD_BASE_URL; break;
                        }
                        break;
                }
                break;

            case CoreConstants.MODULE_MOBILE_WEB_UI :
                switch (env){
                    case CoreConstants.ENV_STAGE :
                        switch (app){
                            case CoreConstants.APP_RESELLER : this.baseURL =
                                    CoreConstants.RESELLER_WAP_STAGE_BASE_URL; break;
                            case CoreConstants.APP_MOKAM : this.baseURL =
                                    CoreConstants.MOKAM_WAP_STAGE_BASE_URL; break;
                        }
                        break;
                    case CoreConstants.ENV_PROD :
                        switch (app){
                            case CoreConstants.APP_RESELLER : this.baseURL =
                                    CoreConstants.RESELLER_WAP_PROD_BASE_URL; break;
                            case CoreConstants.APP_MOKAM : this.baseURL =
                                    CoreConstants.MOKAM_WAP_PROD_BASE_URL; break;
                        }
                        break;
                }
                break;

            case CoreConstants.MODULE_WEB_UI :
                switch (env){
                    case CoreConstants.ENV_STAGE :
                        switch (app){
                            case CoreConstants.APP_RESELLER : this.baseURL =
                                    CoreConstants.RESELLER_WEB_STAGE_BASE_URL; break;
                            case CoreConstants.APP_MOKAM : this.baseURL =
                                    CoreConstants.MOKAM_WEB_STAGE_BASE_URL; break;
                        }
                        break;
                    case CoreConstants.ENV_PROD :
                        switch (app){
                            case CoreConstants.APP_RESELLER : this.baseURL =
                                    CoreConstants.RESELLER_WEB_PROD_BASE_URL; break;
                            case CoreConstants.APP_MOKAM : this.baseURL =
                                    CoreConstants.MOKAM_WEB_PROD_BASE_URL; break;
                        }
                        break;
                }
                break;

            case CoreConstants.MODULE_WMS_UI :

                switch (env){
                    case CoreConstants.ENV_STAGE : baseURL = CoreConstants.WMS_WEB_STAGE_BASE_URL;break;
                    case CoreConstants.ENV_PROD : baseURL = CoreConstants.WMS_WEB_PROD_BASE_URL;break;
                }
                break;
        }

    }


    public Response getCall(String path){
        System.out.println("Control in GetCall");
        System.out.println("Base-URL is : "+baseURL);
        RestAssured.baseURI = baseURL;
        System.out.println("Final URL is : "+baseURL+path);
        Response  response = given().header("Content-Type","application/json")
                .header("cookie",cookie)
                .when()
                .get(path);
        //response.then().log().all();
        return response;
    }

}
