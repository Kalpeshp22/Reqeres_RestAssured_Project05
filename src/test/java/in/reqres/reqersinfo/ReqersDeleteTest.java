package in.reqres.reqersinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReqersDeleteTest extends TestBase {
    @Test
    public void deleteAllProductInfo() {
        Response response = given()
                .pathParam("id",841)
                .when()
                .delete("/api/users/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
        System.out.println(response.statusCode());
    }

}
