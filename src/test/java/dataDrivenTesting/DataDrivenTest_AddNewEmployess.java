package dataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest_AddNewEmployess {
   @Test(dataProvider = "empDataProvide")
    void addNewEmployees(String firstName,String lastName,String subjectId){
       // hard coded data driven. single set of data

        RestAssured.baseURI="http://localhost:3000";
        RequestSpecification httpRequest=RestAssured.given();
        // here we created data which we can send along with post request
        JSONObject requestParams=new JSONObject();
        requestParams.put("firstName",firstName);
        requestParams.put("lastName",lastName);
        requestParams.put("subjectId",subjectId);

        // Add a header stating the body Request body in a JSON
        httpRequest.header("Content-Type","application/json");
        // Add the json to the body of the request
        httpRequest.body(requestParams.toJSONString());

        // POst request
        Response response=httpRequest.request(Method.POST,"/user");
        //capture the response and perform validation
        String responseBody=response.getBody().asString();
       System.out.println("responseBody: "+responseBody);
        // verify
    /*    Assert.assertEquals(responseBody.contains("fslkg"),true);
        Assert.assertEquals(responseBody.contains("Enver"),true);
        Assert.assertEquals(responseBody.contains("2"),true);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,201);  */

    }
    //2 postReqt---multiple set of data
    @DataProvider(name="empDataProvide")
    Object[][] getEmpData(){
       String empData[][]={{"abs","Enver","3"},{"sadf","Enver","6"},{"Eddd","Enver","4"}};
       return (empData);

    }
}
