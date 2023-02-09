import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class MainMuPosts extends AbstractTest  {
    @Test//получилось авторизоваться
    public void getDataTest() {
        RequestSpecification httpRequest = RestAssured.given().auth().basic("filolog999333", "27791fb46b").headers("X-Auth-Token", "1f67a2d2f24019840fd1a1d14da73717");
        Response res = httpRequest.get("https://test-stand.gb.ru/api/posts");
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);

    }
    @Test //вроде получилось
    void getOneTest(){
        given()
                .log().all()
                .auth().basic("filolog999333", "27791fb46b")
                .headers("X-Auth-Token", "1f67a2d2f24019840fd1a1d14da73717")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts?sort=createdAt&order=ASC&page=1")

                .then()
                .log().all()
                .assertThat()
                //.cookie("cookieName", "cookieValue")

                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

    }
    @Test //вроде получилось
    void getTwoTest(){
        given()
                .log().all()
                .auth().basic("filolog999333", "27791fb46b")
                .headers("X-Auth-Token", "1f67a2d2f24019840fd1a1d14da73717")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts?order=DESC&page=2")

                .then()
                .log().all()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }
    @Test //вроде получилось
    void getThreeTest(){
        given()
                .log().all()
                .auth().basic("filolog999333", "27791fb46b")
                .headers("X-Auth-Token", "1f67a2d2f24019840fd1a1d14da73717")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts")

                .then()
                .log().all()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }
    @Test //get
    void getFoTest(){
        given()
                .log().all()
                .auth().basic("filolog999333", "27791fb46b")
                .headers("X-Auth-Token", "1f67a2d2f24019840fd1a1d14da73717")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts")

                .then()
                .log().all()
                .assertThat()
                //.cookie("cookieName", "cookieValue")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

    }

}
