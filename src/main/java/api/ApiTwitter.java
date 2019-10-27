package api;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ApiTwitter {

    @Test
    public void postTweet(){
        Response response = RestAssured.given().auth().oauth("vpV6NVcszP0n8XkxrQGIMq4yP",
                "zMQEM3kxlXOdXUU1dSJLi06vTKoUxJeapH6tuAE1PGmVtJLs1O",
                "1188045665471025155-eP1iDWPYnIoLEXpXeYYy1B4p8t8lEx",
                "Qdyl8sY5REtkZSog7A6wEUvE8JpH9bor1VOpwgCTbEbbK")
                .post("https://api.twitter.com/1.1/statuses/update.json?status= Developer ");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
        System.out.println(response.jsonPath().prettify());
        JsonPath jsonPath = response.jsonPath();
        String tweetID = jsonPath.get("id_str");
        System.out.println("The Tweet ID is: "+tweetID);

    }
    @Test
    public void deleteTweet(){
        Response response = RestAssured.given().auth().oauth("vpV6NVcszP0n8XkxrQGIMq4yP",
                "zMQEM3kxlXOdXUU1dSJLi06vTKoUxJeapH6tuAE1PGmVtJLs1O",
                "1188045665471025155-eP1iDWPYnIoLEXpXeYYy1B4p8t8lEx",
                "Qdyl8sY5REtkZSog7A6wEUvE8JpH9bor1VOpwgCTbEbbK")
                .post("https://api.twitter.com/1.1/statuses/destroy/1188249292911382528.json");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
        System.out.println(response.jsonPath().prettify());

    }
}
