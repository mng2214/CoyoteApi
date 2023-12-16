package brokers.weather;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SMS {

   public static void smsSender () {
       RestAssured.given()
               .baseUri("https://textflow-sms-api.p.rapidapi.com")
               .basePath("/send-sms")
               .accept(ContentType.JSON)
               .header("X-RapidAPI-Key","6de4381d8cmsh29207fcadea2ef2p17a7fcjsn929a54091c3d")
               .header("X-RapidAPI-Host","textflow-sms-api.p.rapidapi.com")
               .body(SMS.bodyForRequest())
               .when().post()
               .then().statusCode(200);
   }

   public static String bodyForRequest (){
return "{\n" +
        "    \"phone_number\": \"+17832736040\",\n" +
        "    \"text\": \"\"\n" +
        "}";
   }


    public static void main(String[] args) {
        SMS.smsSender();
    }
}

