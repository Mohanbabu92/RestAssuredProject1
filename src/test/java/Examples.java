import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import javax.annotation.meta.When;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Examples {
    @Test
    public void test_get()
    {
        baseURI = "http://localhost:3000";
        given().param("name","Automation").
                get("/subjects").
                then().statusCode(200).
                log().all();
    }
    @Test
    public void test_post() {

        JSONObject request = new JSONObject();


        request.put("firstname", "Tom");
        request.put("lastname", "coope");
        request.put("subjectId", "1");

        baseURI = "http://localhost:3000";

        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();



    }
   @Test
    public void test_patch() {

        JSONObject request = new JSONObject();


        request.put("firstname", "Tom");
        request.put("lastname", "shepread");
        request.put("subjectId", "1");

        baseURI = "http://localhost:3000";

        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).when().patch("/users/4").then().statusCode(200).log().all();
    }
    @Test
    public void test_put() {


        JSONObject request = new JSONObject();

        request.put("firstname", "Mary");
        request.put("lastname", "Jane");
        request.put("subjectId", "1");


        baseURI = "http://localhost:3000";

        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).when().put("/users/4").then().statusCode(200).log().all();

    }
    @Test
    public void test_delete() {


        baseURI = "http://localhost:3000";

        when().delete("/users/4").then().statusCode(200);


    }
}
