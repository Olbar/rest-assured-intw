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

    @Test(description = "���������� �������� put �������")
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

    @Test(description = "�������� ��� ��� �������,������ �������������� id. ���, ��-��������, ������ ��� ���� ����� 404," +
            " �� ���-�� �� ��� �� ������ ������� � ��� ������������ 500, ������� �������� ������ �� 500-ERR")
    public void putBadRequestErrorTest() {
        getHeader()
                .and()
                .body(requestBody)
                .when()
                .put("/posts/1000")
                .then().assertThat().statusCode( ERR );
    }

    @Test(description = "�������� ��� ��� �������")
    public void putBadRequest() {
        getHeader()
                .and()
                .body(requestBody)
                .when()
                .put("/postss/100")
                .then().assertThat().statusCode( NOT_FOUND );
    }
}
