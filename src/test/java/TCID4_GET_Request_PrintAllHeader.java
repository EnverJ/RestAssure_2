import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TCID4_GET_Request_PrintAllHeader {
    @Test
    public void getWeatherDetails(){


            // 1. specify baseURI
            RestAssured.baseURI = "https://maps.googleapis.com";
            // 2. Request specification-- Request Object
            RequestSpecification httpRequest = RestAssured.given();

            // 3.Response Object. in this reponse I AM GOING TO VALIDATE THE HEADER
            Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s\n");

            // print response in console window. Response body normally coming  in Json format. So we need to use asString in order to print it. this step can be ignored in work
            String responseBody = response.getBody().asString();
            System.out.println("Response Body: " + responseBody);

            Headers allHeaders=response.headers(); // will capture all the headers from response
            for(Header header:allHeaders){
                System.out.println(header.getName()+"  "+header.getValue()); // print header name
               // System.out.println(header.getValue());  // print header value
            }

    }
}
