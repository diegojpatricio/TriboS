package login;

import common.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import users.domain.User;

import static io.restassured.RestAssured.given;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginWhenTypedCorrect(){
        User user = new User("fulano@qa.com","teste");
        given().log().all().
                contentType(ContentType.JSON).
                body(user).
                when().
                    post("login").
                then().
                    statusCode(HttpStatus.SC_OK);
    }
}
