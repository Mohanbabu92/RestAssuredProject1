
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Test01_Get {
    @Test
    void test_01()
    {
       Response response = get("https://reqres.in/api/users?page=2");
       response.getStatusCode();
       response.getBody();
       response.asString();
       System.out.println(response.getBody());
       System.out.println(response.statusCode());
       System.out.println(response.asString());
       System.out.println(response.getTime());

       int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);
    }
}
