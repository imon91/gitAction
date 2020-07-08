package services.serviceUtils;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ShopUpPostMan {

    // This Layer is basically to hit the get requests and send back the response

    private String baseURL;
    private final String cookie;

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
             cookie = "_ga=GA1.2.1936512597.1591177880; _warehouse_mgmt_service_session=WUNlWC9HOXlBSEJTb0FxUFNEOEhZTVJ6UHFuRE9wMU1RQWE2NDNWYTFZTG9GcmRDcGNPSlFxeWdHa09HdFk1VjY4ZXRQK1l1VXdKeXpHcXNzVHBoTVljTWpjVUNIdVBHOHEzcTdqdUo4aWtvQWNhVnRONnFLTWdlSnY4ejFrRkUwOU5YUDdIcWpFUFFRTjNmVndHNFpVR1FBWWJmQ0x0N2t0TTA0R1BxeEFQT1FueEdzYUJFQkJUeUdzNEVTUmdOMEY4aHdmWkloalJSTnBrTVNmeExHSHczVTdrUnZ1ZXB2SGtaTndvYTMxUk5Ha25WT2NGV3ZoRGdnbjJmTWRtc211UXkvRzhTQU9yb3N5dmRXQ285UDV3dzVJWmRlOCtNZkF6OGFEKzJFT1BsK1dRUEZhRld4V3FRdjFkNmlzTDhVQ3Nsc2E0VE1PdU5kLytGMmlZa1Azb1R0aWVsMjNLbFgzUGNodmNZeTAvMDcxQ3g5a25CSTZiL2ZnUHB6dkM2V1dIekpNMGI1ZlowcmJjKzZaYWNVdz09LS01dCs5TmxYM3FJUk1aZm9WcGdlWEJnPT0%3D--5ee1594ceac6ddb6e4e710e6067f1b0cd1b04146";
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
