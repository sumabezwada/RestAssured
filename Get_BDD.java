package com.bdd.rest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get_BDD {

@Test
    public void test_numeber()
{
    given().
    when().get("http://jsonplaceholder.typicode.com/posts/1")
    .then()
    .statusCode(200);

}
    @Test
    public void test_log_all()
    {
        given().
                when().get("http://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void test_verify_singlecontent()
    {
        given().
                when().get("http://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .body("RestResponse.result.name,",equalTo(""));
    }

}
