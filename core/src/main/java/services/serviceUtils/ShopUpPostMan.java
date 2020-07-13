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
             cookie = "_ga=GA1.2.1936512597.1591177880; _warehouse_mgmt_service_session=MXBnVW5VSTJmOE5BTFFuWnFqWThvbjVsNktBQlAyb2dibExMNllaZEU2ZnZUSE9nemNYblo2WGhQWnBxaXBzOWU2dldWTlNLWDJQbWt0VlRRMXMrMTRyczdhMjdxK2JGYmFqTC9nVEpFeUFmL1dQck5XL2NiODJ2WHp3b0JkY3hxL0t0cVlsMjhmbkMyOHFkL2hiK2VrSVc5VXJQc2dwNHpmWmdPNDl1NTRvbnVQRGdybWtTUi9RRHNMRzhQWjkrNmdpTVZITUc3ajVuUmpVRk9TL1UvTlBTZ2RUZmIyaUtqd3I3Wlp2UXVyVU5hVHJQL0ZqUkg5RlB3NGVYQmN2dW9vUU02TVU1UFl0WEJ1QU5INUlSWWo2R29yUW1TY1FlK2Y3ZFFWMno3TWlpakJZOG5DeFRraFEzVlRGK1JxRUhnZy9UU2lncTlyRHd5dWVIV2tYS3hMSFZkKzY4T0cwdERZNzZjbmEyei9QeTZsOEZKSWpLam0yTnJuR3cxUmFZa2IyaGp2akJVQTVYUmJJV1JZNVAyZz09LS1rbjM3b0VZSi9NTDdpVVdMNE83UDh3PT0%3D--57272074d07d714fa8414bf9626f6a0476730326";
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
