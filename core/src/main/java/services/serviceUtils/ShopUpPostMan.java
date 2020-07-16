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
//        String app = CoreConstants.APP_MOKAM;
//        String env = CoreConstants.ENV_STAGE;

        if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            // SET RESELLER COOKIE
            cookie = "_voonik_session=eyJ0ZXN0NCI6IkIiLCJjb3VudHJ5X2NvZGUiOjEsInRlc3QyIjoiQiIsInRlc3QzIjoiQSIsImdpZCI6IjQ5NjIyMSIsIndhcmRlbi51c2VyLnVzZXIua2V5IjpbIlVzZXIiLFsxMjI2OTRdLCIkMmEkMTAkbTk2VzJoZ0E3c3QuL2x6em1PTDJkLiJdLCJzZXNzaW9uX2lkIjoiYmI3YTdiOWJkNGU2NmMyN2NhYWM2NDg5ODAzODQyZjUiLCJ0ZXN0MSI6IkEiLCJjdXJyZW5jeV9jb2RlIjoiSU5SIn0_--d407c5368285e326358d9d76a678c8984cd596f2;";
        }else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            // SET MOKAM COOKIE
            cookie = "_voonik_session=eyJ0ZXN0NCI6IkIiLCJjb3VudHJ5X2NvZGUiOjEsInRlc3QyIjoiQiIsInRlc3QzIjoiQSIsImdpZCI6IjQ5NjIyMSIsIndhcmRlbi51c2VyLnVzZXIua2V5IjpbIlVzZXIiLFsxMjI2OTRdLCIkMmEkMTAkbTk2VzJoZ0E3c3QuL2x6em1PTDJkLiJdLCJzZXNzaW9uX2lkIjoiYmI3YTdiOWJkNGU2NmMyN2NhYWM2NDg5ODAzODQyZjUiLCJ0ZXN0MSI6IkEiLCJjdXJyZW5jeV9jb2RlIjoiSU5SIn0_--d407c5368285e326358d9d76a678c8984cd596f2;";
        }else {
            // SET WMS COOKIE
             cookie = "_ga=GA1.2.1936512597.1591177880; _warehouse_mgmt_service_session=Z1RzSTQrLzNHSXd6aGdHS3BqdlNyNlhzZnF4Nk9ldnJoVkl0bDIyY0RFbE84cWpwZDBJeE1hZDgyeGJsb3F0WG9idVFwZG9IQ0pUM1ZjdGcrYm5IbCtHb05uc21ZSkVyZHFKNTM5bXZUejVnbzBBTmFBUUJDeTlYeWxGcFE3c25rajBYdUlUREJkbmx4VXErZ3VWQ21rcFEzbHFOdytNMm8ybHV2bEhMdk83RXRrbjJod1lEUHhqaTM0d0lDUVJuTFNSSm5ocEROTWdoRWNYQ2lLR3NoY2liNHgxb2YwQllXaVpmRXpzZHIwOTJhT1RidjJCM29Cb3d5QkVDcVZsWVU0QXZZMWNFNDR0QjIzMjJ1dXdNL1ZrY2FQeEoycitmVGdXcXM0MlJSTW04MXlwVGVXS0JRekFBS0dxcklmeDNOREhiN25YdEZ0R2tuMDVQSVdvRjcyUFVHMnYwQTlqdFpEaVI1cmdHOHB2UllScmg1cEMwdG5rRTV5TEg5N1hRQURqQmFnZG1VNHFrb2NVS2VJMkZJQT09LS1VdkZESjVBamc4aVJRZHcxbjN3WG13PT0%3D--4ad6ad060b58dcdf0b1aeaec57198ea58ac03173";
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
