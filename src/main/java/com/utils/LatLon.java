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

    public static Map<String, Double> getLatLng(String city, String state) {
        Map<String, Double> latLonMap = new HashMap<>();

        // Set base URL and path
        RestAssured.baseURI = Endpoints.geoUrl;
        RestAssured.basePath = Endpoints.geoUrlSearch;

        // Define query parameters
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("city", city);
        queryParams.put("state", state);
        queryParams.put("country", "USA");
        queryParams.put("format", "json");

        // Send GET request
        var response = RestAssured.given()
                .accept(ContentType.JSON)
                .queryParams(queryParams)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Extract latitude and longitude as strings with square brackets
        var jsonPath = response.jsonPath();
        String latStr = jsonPath.getString("lat");
        String lonStr = jsonPath.getString("lon");

        // Remove square brackets and convert to double
        double lat = Double.parseDouble(latStr.substring(1, latStr.length() - 1));
        double lon = Double.parseDouble(lonStr.substring(1, lonStr.length() - 1));

        // Put values in the map
        latLonMap.put("lat", lat);
        latLonMap.put("lon", lon);

        return latLonMap;
    }


    public static void main(String[] args) {
        System.out.println( getLatLng("des plaines", "il"));
    }
}
