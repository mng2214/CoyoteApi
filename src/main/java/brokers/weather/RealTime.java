package brokers.weather;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

public class RealTime {

//    public static String RealtimeWeather(String city, String state) {
//        String latlon = LatLon.getLatLng(city, state);
//        Response response = RestAssured.given().accept(ContentType.JSON)
//                .baseUri("https://weatherapi-com.p.rapidapi.com")
//                .basePath("current.json")
//                .header("X-RapidAPI-Key", "6de4381d8cmsh29207fcadea2ef2p17a7fcjsn929a54091c3d")
//                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
//                .queryParam("q", latlon)
//                .when()
//                .get()
//                .then().statusCode(200)
//               // .log().all()
//                .extract().response();
//
//        JsonPath parsedResponse = response.jsonPath();
//        Float tempF = parsedResponse.get("current.temp_f");
//        Float tempC = parsedResponse.get("current.temp_c");
//        String cond = parsedResponse.get("current.condition.text");
//
//
//        return tempF+"\n"+tempC+"\n"+cond;

//    }

//    public static void main(String[] args) {
//        System.out.println(RealTime.RealtimeWeather("Key West","FL"));
//
//    }
}
