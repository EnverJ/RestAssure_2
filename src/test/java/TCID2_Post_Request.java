import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCID2_Post_Request {

    @Test
    void createNewUser(){
        // 1. specify baseURI
        RestAssured.baseURI="https://reqres.in";
        // 2. Request specification-- Request Object
        RequestSpecification httpRequest=RestAssured.given();

        // 3.Response Object
        JSONObject requestParams=new JSONObject();
        //request payload sending along with post request
        requestParams.put("name","Ezmet");
        requestParams.put("job","IT");
        // add header
        httpRequest.header("Conten-Type","application/json");
        httpRequest.body(requestParams.toJSONString());  // attach above data to the param
        // response object
        Response response=httpRequest.request(Method.POST,"api/users");

        // print response in console window. Response body normally coming in Json format. So we need to use asString in order to print it. this step can be ignored in work
        String responseBody=response.getBody().asString();
        System.out.println("Response Body: "+responseBody);

        // Verify status code and Status line
        int statusCode=response.getStatusCode();
        System.out.println("Status Code: "+statusCode);
        Assert.assertEquals(statusCode,201);


        // verify success conde
        String successCode=response.jsonPath().get("SuccessCode");
        System.out.println("Success Code: "+successCode);


    }



}
