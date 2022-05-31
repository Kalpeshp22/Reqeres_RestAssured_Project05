package in.reqres.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBase {
    // set up the environment
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath="/api/users";

    }


}