package user;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class User {

    @Test
    public void buscarTodosUsuarios(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Users")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void buscarUmUsuarioExistente(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Users/2")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void adcionarUmUsuario() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"userName\": \"string\",\n" +
                        "  \"password\": \"string\"\n" +
                        "}")
        .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Users")
        .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void alterarUsuarioEspecifico() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 5,\n" +
                        "  \"userName\": \"string\",\n" +
                        "  \"password\": \"string\"\n" +
                        "}")
        .when()
                .put("https://fakerestapi.azurewebsites.net//api/v1/Users/5")
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
                .delete("https://fakerestapi.azurewebsites.net/api/v1/Users/2")
        .then()
                .log().all()
                .statusCode(200);
    }
}

