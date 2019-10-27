package api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssureApi {
    /*
    There are following public apis
#	Route	        Method  Type	                    Full route	                                Description	Details
1	/employee	    GET	    JSON	http://dummy.restapiexample.com/api/v1/employees	    Get all employee data Details
2	/employee/{id}	GET	    JSON	http://dummy.restapiexample.com/api/v1/employee/{id}	Get a single employee data Details
3	/create	        POST	JSON	http://dummy.restapiexample.com/api/v1/create	        Create new record in database Details
4	/update/{id}	PUT	    JSON	http://dummy.restapiexample.com/api/v1/update/{id}	    Update an employee record Details
5	/delete/{id}	DELETE	JSON	http://dummy.restapiexample.com/api/v1/delete/{id}	    Delete an employee record Details
*/
    @Test
    public void employeesTable(){
        //base URI
        RestAssured .baseURI = "http://dummy.restapiexample.com/api/v1/";
        //Request object
        RequestSpecification requestSpecification =RestAssured.given();
        //response object
        Response response = requestSpecification.request(Method.GET,"employees");
        //print response on Console
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is; "+responseBody);
        //if the request is successful, you will get 200 as status code
        int statusCode= response.getStatusCode();
        System.out.println("status sode is: "+statusCode);
        Assert.assertEquals(statusCode,200);
        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }

    @Test
    public void postTweets(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        JSONObject json = new JSONObject();
        json.put("id","27");
        json.put("title","java ");
        json.put("author","john");

        request.body(json.toString());

        Response response = request.post("http://localhost:3000/posts");
        int code = response.getStatusCode();
        Assert.assertEquals(code,201);


    }

    @Test
    public void putTweet(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");

        JSONObject json = new JSONObject();
        json.put("id","100");
        json.put("title","java book");
        json.put("author","md mehedi");

        request.body(json.toString());

        Response response = request.put("http://localhost:3000/posts/100");
        int code = response.getStatusCode();

        Assert.assertEquals(code,200);


    }
    @Test
    public void deleteTweet(){
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/posts/27");
        int code = response.getStatusCode();
        Assert.assertEquals(code,200);
    }


}

