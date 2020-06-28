package services.serviceUtils;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ShopUpPostMan {

    // This Layer is basically to hit the get requests and send back the response

    private String baseURL;

    public ShopUpPostMan(String module){
        String app = System.getProperty(BuildParameterKeys.KEY_APP);
        String env = System.getProperty(BuildParameterKeys.KEY_ENV);

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
                .header("cookie","_voonik_session=eyJnaWQiOiI0OTYyMjEiLCJndWVzdF91c2VyIjoiMTIyNjk0Iiwic2Vzc2lvbl9pZCI6ImMwNTdhZjFmMTUxYTRhMTg2NTZlMTc2YjUxODg5ZTRmIiwidGVzdDEiOiJCIiwiY3VycmVuY3lfY29kZSI6IklOUiIsInRlc3Q0IjoiQiIsImNvdW50cnlfY29kZSI6MSwidGVzdDIiOiJBIiwidGVzdDMiOiJBIiwiYWJfdGVzdF9ncm91cF9hc3NpZ25fdGltZSI6NDQyNTUwLCJ3YXJkZW4udXNlci51c2VyLmtleSI6WyJVc2VyIixbMTIyNjk0XSwiJDJhJDEwJG05NlcyaGdBN3N0Li9senptT0wyZC4iXSwiYWJfdGVzdF9ncm91cF9pZCI6bnVsbCwib3JkZXJfaWQiOjE0MTAyNH0_--f75285317d600cd275dca9b0146ea4e40af30652")
                .when()
                .get(path);
        //response.then().log().all();
        return response;
    }

}
