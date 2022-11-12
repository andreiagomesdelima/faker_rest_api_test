package books;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Books {
    @Test
    public void buscarTodosOsLivros(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Books")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void buscarUmLivro(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Books/2")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void adicionarUmLivro(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"idBook\": 2,\n" +
                        "  \"url\": \"string\"\n" +
                        "}")
        .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void alterarUmLivro(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"idBook\": 2,\n" +
                        "  \"url\": \"string\"\n" +
                        "}")
        .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/2")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void deletarUmLivro(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/Books/2")
                .then()
                .log().all()
                .statusCode(200);
    }
}
