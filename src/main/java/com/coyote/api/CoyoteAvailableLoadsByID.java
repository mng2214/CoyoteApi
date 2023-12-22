package com.coyote.api;


import com.models.Endpoints;
import com.utils.Token;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;


public class CoyoteAvailableLoadsByID {

    String loadID = "30542292";

    @Test
    public void findById() {
        RestAssured.baseURI = Endpoints.prod;
        RestAssured.basePath = Endpoints.getAvailableLoadById + loadID;
        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).log().body()
                .header("Authorization", Token.getToken())
                .when().get()
                .then().statusCode(200)
                .log().body()
                .extract().response();
    }
}