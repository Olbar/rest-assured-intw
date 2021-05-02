package rest.Tests;

import org.testng.annotations.Test;
import rest.Base.BaseTest;
import static org.hamcrest.Matchers.is;
import static rest.Base.Constants.*;


public class GetRestTest extends BaseTest {

    @Test(description = "Позитивный сценарий получения страницы posts")
    public void getRequestTest() {
        getRequestSpecification()
                .when()
                .get("/posts")
                .then().assertThat().statusCode( OK )
                .and().body("title[1]",is("qui est esse"));
    }

    @Test(description = "Страница не найдена")
    public void notFoundGetRequestTest(){
        getRequestSpecification()
                .when().get("/postssss")
                .then().assertThat().statusCode(NOT_FOUND);
    }



    @Test(description = "Поиск страницы с параметрами")
    public void getRequestWithQueryParam() {
        getRequestSpecification()
                .param("postId", "2")
                .when()
                .get("/comments")
                .then().assertThat().statusCode( OK )
                .and().body("email[3]",is("Meghan_Littel@rene.us"));

    }
}



