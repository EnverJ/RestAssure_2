import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCID7_GET_Request_Authorization {

    @Test
    public  void  AuthorizationTests(){
        // 1. specify baseURI
        RestAssured.baseURI="https://the-internet.herokuapp.com/basic_auth";  // username: admin password: admin
        // Basic Authentication
        PreemptiveBasicAuthScheme authScheme=new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("admin");
        RestAssured.authentication=authScheme;

        // 2. Request specification-- Request Object
        RequestSpecification httpRequest=RestAssured.given();

        // 3.Response Object
        Response response=httpRequest.request(Method.GET,"/");


        // print the response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is "+responseBody);

        // Verify status code
        int statusCode=response.getStatusCode();
        System.out.println("Status Code: "+statusCode);
        Assert.assertEquals(statusCode,200);

    }
}
