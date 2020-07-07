package services.serviceUtils;



import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class WmsPostMan {
    private String baseURL;

    public Response getCall(String path){
        System.out.println("Control in GetCall");
        baseURL = "https://uatwms.vnksrvc.com/";
        System.out.println("Base-URL is : " + baseURL);
        RestAssured.baseURI = baseURL;
        System.out.println("Final URL is : "+baseURL+path);
        Response response = given().header("Content-Type","application/json")
                .header("cookie","_ga=GA1.2.1936512597.1591177880; _warehouse_mgmt_service_session=MXBnVW5VSTJmOE5BTFFuWnFqWThvbjVsNktBQlAyb2dibExMNllaZEU2ZnZUSE9nemNYblo2WGhQWnBxaXBzOWU2dldWTlNLWDJQbWt0VlRRMXMrMTRyczdhMjdxK2JGYmFqTC9nVEpFeUFmL1dQck5XL2NiODJ2WHp3b0JkY3hxL0t0cVlsMjhmbkMyOHFkL2hiK2VrSVc5VXJQc2dwNHpmWmdPNDl1NTRvbnVQRGdybWtTUi9RRHNMRzhQWjkrNmdpTVZITUc3ajVuUmpVRk9TL1UvTlBTZ2RUZmIyaUtqd3I3Wlp2UXVyVU5hVHJQL0ZqUkg5RlB3NGVYQmN2dW9vUU02TVU1UFl0WEJ1QU5INUlSWWo2R29yUW1TY1FlK2Y3ZFFWMno3TWlpakJZOG5DeFRraFEzVlRGK1JxRUhnZy9UU2lncTlyRHd5dWVIV2tYS3hMSFZkKzY4T0cwdERZNzZjbmEyei9QeTZsOEZKSWpLam0yTnJuR3cxUmFZa2IyaGp2akJVQTVYUmJJV1JZNVAyZz09LS1rbjM3b0VZSi9NTDdpVVdMNE83UDh3PT0%3D--57272074d07d714fa8414bf9626f6a0476730326")
                .when()
                .get(path).thenReturn();
        return response;
    }
}
