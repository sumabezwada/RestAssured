package org.qa.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasXPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasXPath;

public class BDD_Rest_Xml {


        /* @Test(priority=1)
         public void demo()
         {
             given()
              .when()
                  .get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
              .then()

                 .body("CUSTOMER.ID",equalTo("10"))

                     .log().all();
         }*/
        @Test(priority=2)
        public void demo1()
        {
       /* given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
               // .body("CUSTOMER.FIRSTNAME",equalTo("Sue"))
                .body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Sue")));*/
//                .body("CUSTOMER.STREET",equalTo("135 Upland Pl."))
//                .body("CUSTOMER.CITY",equalTo("Dallas"))
            //   .log().all();
        }



        @Test(priority=3)
        public void demo3()
        {
            given()
                    .when()
                    .get("http://thomas-bayer.com/sqlrest/INVOICE")
                    .then()
                    .body(hasXPath("/INVOICEList/INVOICE[text()='30']")).log().all();
        }


}
