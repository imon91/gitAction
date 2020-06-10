package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ResellerPostMan {

    // This Layer is basically to hit the get requests and send back the response

    public void getCall(String path){
        RestAssured.baseURI = ServiceConstants.STAGE_BASE_URL;
        Response  response = given().header("Content-Type","application/json")
                .when()
                .post(path);
        response.then().log().all();
        //return response;
    }

    public static void main(String[] args) {
        new ResellerPostMan().getCall(ServiceConstants.CATEGORY_MEN_CLOTHING+ ServiceConstants.SUB_CATEGORY_MEN_SHIRTS_JSON);
    }

}
