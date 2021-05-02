package rest.Tests;

import org.testng.annotations.Test;
import rest.Base.BaseTest;

import static org.hamcrest.Matchers.is;
import static rest.Base.Constants.OK;

public class PatchRestTest extends BaseTest {

    private static String requestBody = "{\n" +
            "  \"title\": \"bax\" \n}";

    @Test(description = "Положительный тест на patch")
    public void patchRequest() {
        getHeader()
                .and()
                .body( requestBody )
                .when()
                .patch( "/posts/1" )
                .then().assertThat().statusCode( OK )
                .and().body( "title", is( "foo" ) )
                .and().body( "body", is( "bax" ) )
                .and().body( "userId", is( "1" ) )
                .and().body( "id", is( 1 ) );
    }
}
