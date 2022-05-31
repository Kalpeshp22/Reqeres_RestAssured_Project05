package in.reqres.extraingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "https://reqres.in/api/users";
        response = given().
                when().
                get("?page=2").
                then().
                statusCode(200);
    }

    @Test
    public void verifyPageIsTwo() {
        int page = response.extract().path("page");
        System.out.println(page);
        Assert.assertEquals(2, page);
    }

    @Test
    public void verifyPerPageIsSix(){
        int page = response.extract().path("per_page");
        System.out.println(page);
        Assert.assertEquals(6, page);
    }

    @Test
    public void verifyData1IdIsEight(){
        int per_page = response.extract().path("data[1].id");
        System.out.println(per_page);
        Assert.assertEquals(8, per_page);
    }

    @Test
    public void verifyData3FirstNameIsByron(){
        String name = response.extract().path("data[3].first_name");
        System.out.println(name);
        Assert.assertEquals("Byron", name);
    }

    @Test
    public void verifyListOfDataIsSix(){
        List<Response> data = response.extract().path("data");
        System.out.println(data);
        Assert.assertEquals(6, data.size());
    }

    @Test
    public void verifyData5AvatarIsValid(){
        String avatar = response.extract().path("data[4].avatar");
        System.out.println(avatar);
        Assert.assertEquals("https://reqres.in/img/faces/11-image.jpg", avatar);
    }

    @Test
    public void verifySupportURLisValid(){
        String URL = response.extract().path("support.url");
        System.out.println(URL);
        Assert.assertEquals("https://reqres.in/#support-heading", URL);
    }

    @Test
    public void verifySupportTextisValid(){
        String text = response.extract().path("support.text");
        System.out.println(text);
        Assert.assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!", text);
    }
}
