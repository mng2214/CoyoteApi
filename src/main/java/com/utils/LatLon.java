package com.utils;

import com.models.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LatLon {

    public static Map<String, String> getLatLng(String city, String state) {
        Map<String, String> latLonMap = new HashMap<>();
        RestAssured.baseURI = Endpoints.geoUrl;
        RestAssured.basePath = Endpoints.geoUrlSearch;
        Response response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("city", city)
                .queryParam("state", state)
                .queryParam("country", "USA")
                .queryParam("format", "json")
                .when()
                .get()
                .then().statusCode(200)
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String lat = jsonPath.get("lat").toString().replace("[","").replace("]","");
        String lon = jsonPath.get("lon").toString().replace("[","").replace("]","");
        latLonMap.put("lat",lat);
        latLonMap.put("lon",lon);
        return latLonMap;
    }


    public static void main(String[] args) {
        System.out.println("getLatLng(\"chicago\",\"il\") = " + getLatLng("nashville", "tn" ));
    }
}
