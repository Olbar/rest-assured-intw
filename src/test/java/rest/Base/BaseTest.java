package rest.Base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.baseURI;

/**
 * Класс базового теста.
 */
public class BaseTest{

    @BeforeSuite
    public static void setup() {
        baseURI = "https://jsonplaceholder.typicode.com";
    }

    protected RequestSpecification getRequestSpecification() {
        return RestAssured.given()
                .contentType( ContentType.JSON);
    }

    protected RequestSpecification getHeader() {
        return RestAssured.given()
                .header( "Content-type", "application/json" );
    }
}
