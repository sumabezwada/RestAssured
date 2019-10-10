package org.qa.test;

import com.qa.base.Base;
import com.qa.client.RestClient;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateHeaders
{

@Test
    public void headers()
    {
    //Specify base URI
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();

        //Response object
        Response response=httpRequest.request(Method.GET,"/Hyderabad");

        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //validating headers
        String contentType=response.header("Content-Type");// capture details of Content-Type header
        System.out.println("Content Type is:"+contentType);
        Assert.assertEquals(contentType, "application/json");

        String contentEncoding=response.header("Content-Encoding");// capture details of Content-Encoding  header
        System.out.println("Content Encoding is:"+contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");

    }

}





