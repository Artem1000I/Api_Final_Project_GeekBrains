import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class LoggingTest extends AbstractTest{
    @BeforeAll
    static void setUp(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(); // статическая переменная включение логов при подении
        //если тесты прошли не успешно вызовится функционал и будут вызваны коды возврата
    }

    @Test//получилось авторизоваться
    public void getDataTest() {
        RequestSpecification httpRequest = RestAssured.given().auth().basic("filolog999333", "27791fb46b").headers("X-Auth-Token", "1f67a2d2f24019840fd1a1d14da73717");
        Response res = httpRequest.get("https://test-stand.gb.ru/api/posts");
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);


    }
    @Test //post
    void postCuisineTest(){
        given()
                .log().all()
                .auth().basic("filolog999333", "27791fb46b")
                .headers("X-Auth-Token", "1f67a2d2f24019840fd1a1d14da73717")

                .when()
                .contentType(ContentType.JSON)
                .post("https://test-stand.gb.ru/login")

                .then()
                .log().all()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }



}
