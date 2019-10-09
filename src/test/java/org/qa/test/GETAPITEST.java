package org.qa.test;

import com.qa.base.Base;
import com.qa.client.RestClient;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static sun.plugin.javascript.navig.JSType.URL;

public class GETAPITEST extends Base
{

    Base testbase;
    String serviceurl;
    String apiurl;
    String url;

@BeforeMethod
    public void setup() {
        testbase= new Base();
       serviceurl= prop.getProperty("URL");
        apiurl=prop.getProperty("serviceURL");
        url=serviceurl+apiurl;
  }

    @Test
    public void getTest()throws ClientProtocolException, IOException, JSONException
    {
        RestClient restClient= new RestClient();
        restClient.get(url);
    }
}
