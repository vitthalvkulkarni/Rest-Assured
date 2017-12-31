package com.rest.assured.mvn;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestRstAsrd1 {
	
	@Test
	public void test1()
	{
		System.out.println(" ============== Start of Test ==================");
		
		RestAssured.baseURI = "http://services.groupkt.com/country/get/iso2code";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/IN");
		
		String responsebody = response.getBody().asString();
		
		System.out.println("Response body is: "+ responsebody);
		
		System.out.println(" ============== End of Test   ==================");
		
	}

}
