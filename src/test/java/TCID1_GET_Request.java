import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCID1_GET_Request {
@Test
void getUserInfo(){
    // 1. specify baseURI
    RestAssured.baseURI="https://reqres.in/api";
    // 2. Request specification-- Request Object
    RequestSpecification httpRequest=RestAssured.given();

    // 3.Response Object
    Response response=httpRequest.request(Method.GET,"/users?page=2");

    // print response in console window. Response body normally coming in Json format. So we need to use asString in order to print it. this step can be ignored in work
    String responseBody=response.getBody().asString();
    System.out.println("Response Body: "+responseBody);

    // Verify status code and Status line
    int statusCode=response.getStatusCode();
    System.out.println("Status Code: "+statusCode);
    Assert.assertEquals(statusCode,200);

    //status line verification
    String statusLine=response.statusLine();
    System.out.println("Status Line: "+ statusLine);
    Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");



}



}
