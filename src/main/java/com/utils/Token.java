package com.utils;

import com.models.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Token {

    public static String getToken() {

        RestAssured.baseURI = Endpoints.prod;
        RestAssured.basePath = Endpoints.tokenPath;

        var clientId = ConfigReader.readProperty("clientId");
        var clientSecret = ConfigReader.readProperty("clientSecret");
        var grantType = ConfigReader.readProperty("grantType");

        var response = RestAssured.given()
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .formParam("grant_type", grantType)
                .when().log().all()
                .post().then().log().all().extract().response();

        return "Bearer " + response.jsonPath().getString("access_token");
    }

}
