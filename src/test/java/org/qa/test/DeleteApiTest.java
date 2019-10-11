package org.qa.test;

import com.qa.base.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteApiTest  {

    @Test
    public void deletetest()
    {

        RestAssured.baseURI = "https://reqres.in/api";
        RequestSpecification request = RestAssured.given();

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Delete the request and check the response
        Response response = request.delete("/users/2/");

        int statusCode = response.getStatusCode();
        System.out.println("Record deleted  "+response.asString());
        Assert.assertEquals(statusCode, 204);

    }
}
