package in.reqres.reqersinfo;

import in.reqres.model.ReqersPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReqersPostTest extends TestBase {
    @Test
    public void createUserTest() {
        ReqersPojo reqersPojo = new ReqersPojo();
        reqersPojo.setName("Harish");
        reqersPojo.setJob("Tester");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(reqersPojo)
                .when()
                .post("/api/users");
        response.then().statusCode(201);
        response.prettyPrint();
        System.out.println(response.statusCode());

    }


    @Test
    public void createLoginSuccessfullyTest() {
        ReqersPojo reqersPojo = new ReqersPojo();
        reqersPojo.setEmail("primetesting321@gmail.com");
        reqersPojo.setPassword("Java123");



        Response response = given()
                .header("Content-Type", "application/json")
                .body(reqersPojo)
                .when()
                .post("/login");
        response.then().statusCode(201);
        response.prettyPrint();
        System.out.println(response.statusCode());

    }

}
