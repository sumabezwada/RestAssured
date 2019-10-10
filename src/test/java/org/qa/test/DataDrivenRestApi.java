package org.qa.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenRestApi {

  //
    @Test(dataProvider="usersdata")
    public void postrestapi(String name,String job)
    {
      RestAssured.baseURI="https://reqres.in/api";
      RequestSpecification httprequest=RestAssured.given();

      JSONObject reqparams= new JSONObject();
      reqparams.put("name",name);
      reqparams.put("job",job);

      httprequest.header("Content-Type","application/json");
      httprequest.body(reqparams.toJSONString());
      Response response= httprequest.request(Method.POST,"/users");
      String body=response.body().toString();

     String responseBody=response.getBody().asString();
      System.out.println("Response Body is:" +responseBody);

      //status code validation
      int statusCode=response.getStatusCode();
      System.out.println("Status code is: "+statusCode);
      Assert.assertEquals(statusCode, 201);

    }

    @DataProvider(name="usersdata")
    Object[] test(){
        String usersdata[][]={{"suma","qe"},{"latha","qe"},{"popuri","qe"}};
        return (usersdata);
    }
}
