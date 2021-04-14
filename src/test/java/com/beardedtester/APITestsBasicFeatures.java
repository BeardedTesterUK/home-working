package com.beardedtester;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITestsBasicFeatures {

    @Test
    public void requestUsZipCode(){
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().assertThat().body("places[0].'place name'",
            equalTo("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode200(){
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().statusCode(200);
    }
    @Test
    public void requestUsZipCodeContentType(){
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            contentType(ContentType.JSON);
    }

    @Test
    public void requestUsZipCodeContentTypeString(){
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            contentType("application/json");
    }

    @Test
    public void requestUsZipCodeResponseDetails(){
        given().
            log().all().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            log().body();
    }

    @Test
    public void requestUsZipCodeState(){
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places[0].'state'",equalTo("California"));
    }

    @Test
    public void requestUsZipCodeHasItem(){
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places.'place name'",hasItem("Beverly Hills"));
    }

    @Test
    public void requestUsZipCodeNotHasItem(){
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'",not(hasItem("Beverly Hills")));
    }

    @Test
    public void requestUsZipCodeSize(){
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places.'place name'",hasSize(1));
    }



}
