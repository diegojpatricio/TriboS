package common;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class BaseTest {

    @BeforeAll
    public static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI= "https://serverest.dev/";
    }
}
