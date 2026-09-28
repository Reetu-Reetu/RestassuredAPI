package com.example.qa;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ObjectApiTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://api.restful-api.dev";
    }

    @Test
    public void getExistingObject() {
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/objects/7")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo("7"))
                .body("name", notNullValue());
    }

    @Test
    public void createObject() {
        String requestBody = """
            {
              "name": "QA Practice Laptop",
              "data": {
                "year": 2026,
                "department": "Testing"
              }
            }
            """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/objects")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", notNullValue())
                .body("name", equalTo("QA Practice Laptop"))
                .body("data.year", equalTo(2026))
                .body("data.department", equalTo("Testing"));
    }

    @Test
    public void postWithoutName() {
        String requestBody = """
        {
          "data": {
            "department": "Testing"
          }
        }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/objects")
                .then()
                .log().all();
    }
}