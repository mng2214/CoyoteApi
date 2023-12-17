package com.coyote.api;


import com.models.Endpoints;
import com.utils.Token;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;


public class CoyoteAvailableLoadsByID {

    String loadID = "30516444";

    @Test
    public void findById() {
        RestAssured.baseURI = Endpoints.prod;
        RestAssured.basePath = Endpoints.getAvailableLoadById + loadID;
        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", Token.getToken())
                .when().log().body().get()
                .then().statusCode(200)
                .log().body()
                .extract().response();
    }
}