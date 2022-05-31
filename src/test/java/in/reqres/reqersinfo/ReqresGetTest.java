package in.reqres.reqersinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReqresGetTest extends TestBase {
    @Test
    public void getListUserInfo() {
        Response response = given()
                .when()
                .get("?page=2");
        response.then().statusCode(200);
        response.prettyPrint();
        System.out.println(response.statusCode());
    }

    @Test
    public void getSingleProductInfo() {
        Response response = given()
                .basePath("/api/users")
                .pathParam("id", 10)
                .when()
                .get("{id}");
        response.then().statusCode(200);
        response.prettyPrint();
        System.out.println(response.statusCode());
    }

}









