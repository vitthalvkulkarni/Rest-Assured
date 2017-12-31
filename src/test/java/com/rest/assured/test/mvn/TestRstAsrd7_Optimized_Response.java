package com.rest.assured.test.mvn;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestRstAsrd7_Optimized_Response {

	@Test
	public void test1()
	{
		
		System.out.println(" ============== Start of Test ==================");
		
		RestAssured.baseURI = "http://services.groupkt.com/country/get/iso2code/US";
		SoftAssert sa = new SoftAssert();
		
		Response response =
			when()
				.get(RestAssured.baseURI)
			.then()
				.extract()
				.response();
		
		JsonPath jpath = response.jsonPath();
		String country = jpath.get("RestResponse.result.name");
		String alpha2 = jpath.get("RestResponse.result.alpha2_code");
		String alpha3 = jpath.get("RestResponse.result.alpha3_code");
			
		sa.assertEquals("United States of Americ", country);
		sa.assertEquals("US", alpha2);
		sa.assertEquals("USA", alpha3);
		
		System.out.println("Country Name is: "+country);
		System.out.println("Alpha Code 1 is: "+alpha2);
		System.out.println("Alpha Code 2 is: "+alpha3);
		
		sa.assertAll();
		
		System.out.println(" ============== End of Test   =================");
	}
}
