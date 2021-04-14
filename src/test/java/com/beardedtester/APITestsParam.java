package com.beardedtester;
//Path Parameters http://zippopotam.us/us/90210 Path = (us/90210)
// Query Parameters http://md5.jsontest.com/?text=apple Query = (text & apple)

import com.tngtech.java.junit.dataprovider.*;
import org.junit.runner.RunWith;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)

public class APITestsParam {

    @DataProvider
    public static Object[][] zipCodesAndPlaces() {
        return new Object[][] {
                { "us", "90210", "Beverly Hills" },
                { "us", "12345", "Schenectady" },
                { "ca", "B2R", "Waverley"},
                { "nl", "1001", "Amsterdam"}
        };
    }

    @Test
    @UseDataProvider("zipCodesAndPlaces")
    public void requestUsZipCodeData(String countryCode, String zipCode, String expectedPlaceName) {
        given().
            pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
        when().
            get("http://zippopotam.us/{countryCode}/{zipCode}").
        then().
            assertThat()
            .body("places[0].'place name'",equalTo(expectedPlaceName));
    }
}



