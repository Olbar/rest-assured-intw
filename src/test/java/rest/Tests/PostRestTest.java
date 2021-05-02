package rest.Tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import rest.Base.BaseTest;

import static org.hamcrest.Matchers.is;
import static rest.Base.Constants.*;

public class PostRestTest extends BaseTest {

    private static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"userId\": \"1\" \n}";


    @Test(description = "���������� �������� post �������")
    public void postRequestTest() {
        getHeader()
                .and()
                .body( requestBody )
                .when()
                .post( "/posts" )
                .then().assertThat().statusCode( CREATED )
                .and().body( "title", is( "foo" ) )
                .and().body( "body", is( "bar" ) )
                .and().body( "userId", is( "1" ) )
                .and().body( "id", is( 101 ) );
    }

    @Test(description = "�������� ��� ��� �������")
    public void postBadRequestTest() {
        getHeader()
                .and()
                .body( requestBody )
                .when()
                .post( "/postsss" )
                .then().assertThat().statusCode( NOT_FOUND );
    }

    @Test(description = "����������� body � headers ��� �������")
    public void postBadRequestErrorTest() {
        RestAssured.given()
                .when()
                .post( "/posts" )
                .then().assertThat().statusCode( ERR );
    }

}
