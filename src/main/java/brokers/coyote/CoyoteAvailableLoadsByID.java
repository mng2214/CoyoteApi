package brokers.coyote;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class CoyoteAvailableLoadsByID {

    public static class CoyoteBooking {
        String loadID = "30495651";

        @Test
        public void findById() {
            RestAssured.baseURI = "https://api.coyote.com/api/v1/AvailableLoads/".concat(loadID);
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization", CoyoteBase.getToken())
                    .when().log().body().get()
                    .then().statusCode(200)
                    .log().body()
                    .extract().response();
        }
    }
}