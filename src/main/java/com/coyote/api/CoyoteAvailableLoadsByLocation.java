package com.coyote.api;

import com.coyote.requests.AvailableLoadsRequest;
import com.models.Endpoints;
import com.utils.Token;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class CoyoteAvailableLoadsByLocation {

    @Test
    public void test() {

        RestAssured.baseURI = Endpoints.prod;
        RestAssured.basePath= Endpoints.getAvailableLoadByLocation;

        Response response = RestAssured.given()
                .queryParam("page", 1)
                .queryParam("pageSize", 50)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", Token.getToken())
                .body(AvailableLoadsRequest.reqBuilder()).log().all().when()
                .post().then().log().all().statusCode(200)
                .extract().response();

    }




}
