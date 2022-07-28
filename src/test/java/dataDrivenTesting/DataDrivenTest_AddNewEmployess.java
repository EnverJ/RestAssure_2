package dataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

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
    Object[][] getEmpData() throws IOException {
       // hard code
      // String empData[][]={{"abs","Enver","3"},{"sadf","Enver","6"},{"Eddd","Enver","4"}};
        //XL
        String path=System.getProperty(("user.dir"+"/drc/test/java/dataDrivenTesting/Users.xlsx"));
        int rowNum=XLUtilis.getRowCount(path,"Sheet1");
        int colCount=XLUtilis.getCellCount(path,"Sheet1",1);
        String users[][]=new String[rowNum][colCount];
        for(int i=1;i<=rowNum;i++){
            for(int j=0;j<colCount;j++){
                users[i-1][j]=XLUtilis.getCellData(path,"Sheet1",i,j);

            }
        }
        // String empData[][]={{"abs","Enver","3"},{"sadf","Enver","6"},{"Eddd","Enver","4"}};
      //  return (empData);
       return (users);

    }
}
