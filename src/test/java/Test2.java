import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;

public class Test2 {
    @Test
    public void loginTest(){ //WIP

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("email", "elchobylobi@mail.com");
        map.put("password", "guardiandegalletas");

        String requestBody = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(map.toString())
                .post("https://reqres.in/api/login")
                .then()
                //.statusCode(200)
                .log().all()
                .extract()
                .asString();

        //System.out.println(requestBody);
    }
}
