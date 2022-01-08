package org.naic.APITest;


import io.restassured.path.json.JsonPath;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class GetRequestTest {

    @Before
    public  void setUp(){
  baseURI="https://petstore.swagger.io";
  basePath="/v2";
    }


    @Test
    public  void testFindByStatus(){
        String endPoint="/pet/findByStatus";
        JsonPath jsonPath = given().log().all()
                .queryParam("status","available")
                .when().get(endPoint)
                .then()
                .statusCode(200).extract().jsonPath();
         assertThat(jsonPath.getList("id").size(),greaterThan(1));

    }
}
