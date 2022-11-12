package authors;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Authors {
    @Test
    public void buscarTodosAutores(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void buscarUmAutorEspecifico(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors/3")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void buscarUmLivroDeUmAutorEspecifico(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/3")
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
                        "  \"id\": 55,\n" +
                        "  \"idBook\": 12,\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\"\n" +
                        "}")
        .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Authors/")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void auterarUmLivroEspecifico(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 3,\n" +
                        "  \"idBook\": 3,\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\"\n" +
                        "}")
        .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/Authors/3")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void deletarUmUsuarioEspecifico() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/Authors/2")
                .then()
                .log().all()
                .statusCode(200);
    }
}
