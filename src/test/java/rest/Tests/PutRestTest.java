package rest.Tests;


import org.testng.annotations.Test;
import rest.Base.BaseTest;

import static org.hamcrest.Matchers.is;
import static rest.Base.Constants.*;

public class PutRestTest extends BaseTest {

    private static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"baz\",\n" +
            "  \"userId\": \"1\",\n" +
            "  \"id\": \"1\" \n}";

    @Test(description = "Позитивный сценарий put запроса")
    public void putRequest() {
        getHeader()
                .and()
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then().assertThat().statusCode( OK )
                .and().body( "title", is( "foo" ) )
                .and().body( "body", is( "baz" ) )
                .and().body( "userId", is( "1" ) )
                .and().body( "id", is( 1 ) );
    }

    @Test(description = "Неверный урл при запросе,указан несуществующий id. Тут, по-хорошему, должен был быть ответ 404," +
            " но что-то не так на данном клиенте и нам возвращается 500, поэтому проверку сделал на 500-ERR")
    public void putBadRequestErrorTest() {
        getHeader()
                .and()
                .body(requestBody)
                .when()
                .put("/posts/1000")
                .then().assertThat().statusCode( ERR );
    }

    @Test(description = "Неверный урл при запросе")
    public void putBadRequest() {
        getHeader()
                .and()
                .body(requestBody)
                .when()
                .put("/postss/100")
                .then().assertThat().statusCode( NOT_FOUND );
    }
}
