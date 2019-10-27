package api;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class AuthenticationHandle {
    @Test
    public void handleAuthentication(){
        int code = RestAssured.given().auth().preemptive()
                .basic("ToolsQA","TestPassword").when()
                .get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
                .getStatusCode();
        System.out.println("Response code; "+code);
    }
}
