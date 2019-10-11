package org.qa.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutApiTest {
    @Test
    public void puttest()
    {

        RestAssured.baseURI="https://reqres.in/api";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();


        //Request paylaod sending along with post request
        JSONObject requestParams=new JSONObject();

        requestParams.put("name","jkl");
        requestParams.put("job","XYfJohn2");


        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

        //Response object
        Response response=httpRequest.request(Method.PUT,"/users/2");


        //print response in console window

        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

    }
}
