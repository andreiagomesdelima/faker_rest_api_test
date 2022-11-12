package activities;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Activities {

    @Test
    public void buscarTodasAsAtividade(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
        .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void buscarUmaAtividade(){
        baseURI = "https://fakerestapi.azurewebsites.net";
        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .get(baseURI + "/api/v1/Activities" + "/4")
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
                        "  \"idBook\": 0,\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\"\n" +
                        "}")
        .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Authors")
        .then()

                .log().all()
                .statusCode(200);
    }
    @Test
    public void alterarUmaAtividade(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 4,\n" +
                        "  \"title\": \"string\",\n" +
                        "  \"dueDate\": \"2022-11-11T01:54:48.857Z\",\n" +
                        "  \"completed\": true\n" +
                        "}")
        .when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/Activities/4")
        .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    public void deletarTodasAsAtividade(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
        .when()
                .delete("https://fakerestapi.azurewebsites.net/api/v1/Activities/4")
        .then()
                .log().all()
                .statusCode(200);
    }

}
