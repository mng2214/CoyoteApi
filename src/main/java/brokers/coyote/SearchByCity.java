package brokers.coyote;

import brokers.coyote.CoyoteBase;
import brokers.coyote.availibleLoads.AvailableLoadsRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class SearchByCity {

    String cityOrigin = "chicago";
    String stateOrigin = "il";

    String cityDest = "";
    String stateDest = "";

    @Test
    public void test() {
        RestAssured.baseURI = "https://api.coyote.com/api/v1/AvailableLoads/search";

        RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", CoyoteBase.getToken())
                .body("""
                        {
                        "origin": {
                        "location": {
                        "latitude": -87.6244212,
                        "longitude": 41.8755616
                        },
                        "deadheadRadius": {
                        "value": 200,
                        "unit": "Miles"
                        },
                        "appointment": {
                        "appointmentStartDateTime": "2023-12-16T14:00:00-06:00",
                        "appointmentEndDateTime": "2023-12-20T12:00:00-06:00"
                        }
                        },
                        "equipmentType": "V",
                        "mode": "TL_LTL"
                        }
                        """).log().all().when().post().then().log().all().statusCode(200);
    }

}
