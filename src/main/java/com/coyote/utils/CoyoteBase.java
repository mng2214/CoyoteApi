package com.coyote;

import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

public class CoyoteBase {
    //String city, String state
    @Test
    public void getLatLng() {

        RestAssured.baseURI = "https://nominatim.openstreetmap.org/";
        RestAssured.basePath = "search";
        Response response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("city", "Atlanta")
                .queryParam("state", "GA")
                .queryParam("country", "USA")
                .queryParam("format", "json")
                // .queryParam("addressdetails", 1)
                // .queryParam("limit", 1)
                .when()
                .get()
                .then().statusCode(200)
                // .log().all()
                .extract().response();

        // CoyotePojo parsedResponse = response.as(CoyotePojo.class);
        JsonPath jsonPath = response.jsonPath();
        List<String> lat = jsonPath.get("lat");
        List<String> lon = jsonPath.get("lon");
//        String lat1 = String.valueOf(lat);
        System.out.println(lat + "\n" + lon);
    }

    @Test
    public void getCityState() {

        RestAssured.baseURI = "https://nominatim.openstreetmap.org/";
        RestAssured.basePath = "reverse";
        Response response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("format", "geojson")
                .queryParam("lat", "44.50155")
                .queryParam("lon", "11.33989")
                .when()
                .get()
                .then().statusCode(200)
                //.log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String city = jsonPath.get("features.properties.address.city").toString();
        String state = jsonPath.get("features.properties.address.state").toString();
        System.out.println(city);


    }


    public static String getToken() {

        RestAssured.baseURI = "https://api.coyote.com/";
        RestAssured.basePath = "connect/token";

        String clientId = "ANIINCIL";
        String clientSecret = "uvvpEXjLtdz7QVph";
        String grantType = "client_credentials";

        Response response = RestAssured.given()
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .formParam("grant_type", grantType)
                .when().log().all()
                .post().then().log().all().extract().response();

        return "Bearer " +  response.jsonPath().getString("access_token");
    }


}
