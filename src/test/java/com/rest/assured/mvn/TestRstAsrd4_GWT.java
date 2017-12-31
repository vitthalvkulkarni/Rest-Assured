package com.rest.assured.mvn;

import static io.restassured.RestAssured.*;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestRstAsrd4_GWT {
	
	public String domain = "http://services.groupkt.com/country/get/iso2code";
	public String country = "/IN";
	
	@Test
	public void test1()
	{		
		System.out.println(" ============== Start of Test ==================");
		
		RestAssured.baseURI = domain + country;
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get(RestAssured.baseURI).
		then()			
			.assertThat()
			.statusCode(HttpStatus.SC_OK);
		
		System.out.println(" ============== End of Test   ==================");
	}

}
