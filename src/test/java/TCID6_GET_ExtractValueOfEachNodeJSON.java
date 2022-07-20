import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCID6_GET_ExtractValueOfEachNodeJSON {


    @Test
    public void validateAllJsonValue() {
        // 1. specify baseURI
        RestAssured.baseURI = "https://reqres.in/api/users";
        // 2. Request specification-- Request Object
        RequestSpecification httpRequest = RestAssured.given();
        // 3.Response Object. in this response I AM GOING TO VALIDATE THE HEADER
        Response response = httpRequest.request(Method.GET, "/2");
        // capture complete json path  using JsonPath
        JsonPath jsonPath=response.jsonPath();
        String id=jsonPath.get("id");
        String email=jsonPath.get("email");
        String firstName=jsonPath.get("first_name");
        String lastName=jsonPath.get("last_name");
        String avatar=jsonPath.get("avatar");
        System.out.println(id);
        System.out.println(email);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(avatar);
        Assert.assertEquals(id,"2");



        // Verify all response content in body






    }


}
