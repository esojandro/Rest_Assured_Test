import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    @Test
    public void getUsers() {
        baseURI = "https://reqres.in/api";

        String requestBody = given() // Given para enviar un body
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200) //Cod respon
                .extract()
                .body()
                .asString();

        System.out.println(requestBody); // Para mostrar el get
    }

    @Test
    public void getUser() {
        baseURI = "https://reqres.in/api";

        given() // Given para enviar un body
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200) //Cod respon
                .body("data[1].first_name", equalTo("Lindsay"));
    }

    @Test
    public void postUser() {
        baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Toby");
        map.put("job", "perro guardian");

        given() // Given para enviar un body
                .log().all() // Log para la petición
                .body(map.toString())
                .when()
                .post("/users?page=2")
                .then()
                .log().all() // Log para la respuesta
                .statusCode(201); //Cod respose
    }

    /*@Test
    public void updateUser() { Revisar luego
        baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Toby");
        map.put("job", "perro guardian de galletas");

        given() // Given para enviar un body
                .log().all() // Log para la petición
                .when()
                .put("/users?page=2")
                .then()
                .statusCode(200); //Cod respose
    }*/
}
