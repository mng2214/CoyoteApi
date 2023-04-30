package brokers.coyote;

import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

        RestAssured.baseURI = "https://api.coyote.com/connect/token";
        Response response = RestAssured.given().accept(ContentType.JSON).contentType("application/x-www-form-urlencoded")
                .formParam("client_id", "ROAFALINC")
                .formParam("client_secret", "PDAWKLFaTtekCPNd")
                .formParam("grant_type", "client_credentials")
                .formParam("scope", "ExternalApi")
                .when()
                .post()
                .then().statusCode(200)
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        String token_type = jsonPath.get("token_type");
        String tokenOnly = jsonPath.get("access_token");
        return token_type + " " + tokenOnly;

    }

    public static void main(String[] args) {
        System.out.println(CoyoteBase.getToken());
    }


}
