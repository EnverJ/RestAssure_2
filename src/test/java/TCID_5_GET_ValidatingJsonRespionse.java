import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCID_5_GET_ValidatingJsonRespionse {

    @Test
    public void getWeatherDetails() {


        // 1. specify baseURI
        RestAssured.baseURI = "https://reqres.in/api/users";
        // 2. Request specification-- Request Object
        RequestSpecification httpRequest = RestAssured.given();

        // 3.Response Object. in this reponse I AM GOING TO VALIDATE THE HEADER
        Response response = httpRequest.request(Method.GET, "/2");

        // print response in console window. Response body normally coming  in Json format. So we need to use asString in order to print it. this step can be ignored in work
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Verify response content in body
        Assert.assertEquals(responseBody.contains("first_name"),true);




    }

}
