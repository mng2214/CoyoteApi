package brokers.coyote;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoyoteBooking {
    String loadID = "29100292";

    @Test
    public void findById() {
        RestAssured.baseURI = "https://api.coyote.com/api/v1/AvailableLoads/".concat(loadID);
        //RestAssured.basePath = "" ;
        // RestAssured.basePath = "api/v1/AvailableLoads/search"+ loadID;
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Authorization", CoyoteBase.getToken())
                .when().get()
                .then().statusCode(200)
               // .log().body()
                .extract().response();

//        CoyotePojo parsedResponse = response.as(CoyotePojo.class);
//        List<CoyoteLoadDetailsPojo> a = parsedResponse.getLoadDetailsList();


        JsonPath jsonPath = response.jsonPath();

        String equipmentType = jsonPath.get("loadDetails.equipment.equipmentType").toString();
        Object rate = jsonPath.get("loadDetails.rate.value");
        String loadDistance = jsonPath.get("loadDetails.loadDistance.value").toString();
       String weight = jsonPath.get("loadDetails.weight.value").toString();
        String stops = jsonPath.get("loadDetails.stops[0].facility.address.cityName");

        System.out.println(equipmentType);
        System.out.println(rate);
        System.out.println(loadDistance);
        System.out.println(weight);
        System.out.println(stops);



    }
}