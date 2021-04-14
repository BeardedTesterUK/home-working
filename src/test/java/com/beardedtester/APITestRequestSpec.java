package com.beardedtester;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITestRequestSpec {

    private static RequestSpecification requestSpec;

    private static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createRequestSpec(){

        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://api.zippopotam.us").
                build();
    }

    @BeforeClass
    public static void createResponseSpec(){

        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }

    @Test
    public void requestSpecTest(){
        given().spec(requestSpec).when().get("us/90210").then().assertThat().statusCode(200);
    }

    @Test
    public void responseSpecTest(){
        given().spec(requestSpec).when().get("us/90210").then().spec(responseSpec).and().assertThat().body("places[0]. 'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void extractTest(){

        String placeName = given().spec(requestSpec).when().get("us/90210").then().extract().path("places[0]. 'place name'");
        Assert.assertEquals(placeName, "Beverly Hills");
    }

}
