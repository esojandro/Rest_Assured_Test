import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Test2 {
    @Test
    public void loginTest(){ //WIP

        String requestBody = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "       \"email\": \"elchobylobi@mail.com\",\n" +
                        "       \"password\": \"lomitotoby\"\n" +
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
