import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class restassuredgetpost {

    public static void main(String[] args) {

        //GET Request
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "/public/v2/users";

        Response response = given()
                .header("Accept","application/json")
                .header("Content","application/json")
                .header("Authorization", "Bearer ecef991e9a4d63ac7c9c4e901a97be8331dfa21256e9fbc69d8a5462295932bb")
                .contentType(ContentType.JSON).when().relaxedHTTPSValidation().get();
        System.out.println(response.prettyPrint());





        //POST request
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "/public/v2/users";

        String inputJson="{\"name\":\"savy\", \"gender\":\"male\", \"email\":\"savy321@gmail.com\", \"status\":\"active\"}";


       // curl -i -H "Accept:application/json" -H "Content-Type:application/json" -H "Authorization: Bearer ACCESS-TOKEN" -XPOST "https://gorest.co.in/public/v2/users" -d '{"name":"Tenali Ramakrishna", "gender":"male", "email":"tenali.ramakrishna@15ce.com", "status":"active"}'

       Response req = given()
                .header("Accept","application/json")
                .header("Content","application/json")
                .header("Authorization", "Bearer ecef991e9a4d63ac7c9c4e901a97be8331dfa21256e9fbc69d8a5462295932bb")
               .contentType("application/json").relaxedHTTPSValidation()
               .body(inputJson).log().all()
               .when().post("https://gorest.co.in/public/v2/users");

       System.out.println(req.prettyPrint());

       //UPDATE request
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "/public/v2/users/7050";
        String input1="{\"name\":\"sunny singh\", \"gender\":\"male\", \"email\":\"sunny321123@gmail.com\", \"status\":\"active\"}";
        Response req1 = given()
                .header("Accept","application/json")
                .header("Content","application/json")
                .header("Authorization", "Bearer ecef991e9a4d63ac7c9c4e901a97be8331dfa21256e9fbc69d8a5462295932bb")
                .contentType("application/json").relaxedHTTPSValidation()
                .body(input1).log().all()
                .when().put("https://gorest.co.in/public/v2/users/7050");
        System.out.println(req1.prettyPrint());


        //DELETE request
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "/public/v2/users/7050";
        Response req2 = given()
                .header("Accept","application/json")
                .header("Content","application/json")
                .header("Authorization", "Bearer ecef991e9a4d63ac7c9c4e901a97be8331dfa21256e9fbc69d8a5462295932bb")
                .contentType("application/json").relaxedHTTPSValidation()
                .body(input1).log().all()
                .when().delete("https://gorest.co.in/public/v2/users/7050");
        System.out.println(req2.prettyPrint());




    }
}
