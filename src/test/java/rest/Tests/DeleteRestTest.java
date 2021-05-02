package rest.Tests;

import org.testng.annotations.Test;
import rest.Base.BaseTest;
import static rest.Base.Constants.OK;

public class DeleteRestTest extends BaseTest {

    @Test(description = "Положительный тест на delete")

    public void deleteRequest() {
        getHeader()
                .when()
                .delete( "/posts/1" )
                .then().assertThat().statusCode( OK );
    }
}
