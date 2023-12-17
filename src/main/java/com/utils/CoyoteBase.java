package com.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

public class CoyoteBase {
    @Test
    public void getLatLng() {

        RestAssured.baseURI = "https://nominatim.openstreetmap.org/";
        RestAssured.basePath = "search";
        Response response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("city", "Atlanta")
                .queryParam("state", "GA")
                .queryParam("country", "USA")
                .queryParam("format", "json")
                .when()
                .get()
                .then().statusCode(200)
                .log().all()
                .extract().response();

        // CoyotePojo parsedResponse = response.as(CoyotePojo.class);
        JsonPath jsonPath = response.jsonPath();
        List<String> lat = jsonPath.get("lat");
        List<String> lon = jsonPath.get("lon");
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
                .log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String city = jsonPath.get("features.properties.address.city").toString();
        String state = jsonPath.get("features.properties.address.state").toString();
        System.out.println(city);


    }


}
