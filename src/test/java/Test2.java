import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Test2 {
    @Test
    public void loginTest(){

        String requestBody = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"email\": \"eve.holt@reqres.in\",\n" +
                        "\"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .asString();

        System.out.println(requestBody);
    }
}
