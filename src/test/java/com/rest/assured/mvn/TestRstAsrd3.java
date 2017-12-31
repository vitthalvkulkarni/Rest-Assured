package com.rest.assured.mvn;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestRstAsrd3 {
	
	public String domain = "http://services.groupkt.com/country/get/iso2code";
	public String country = "/US";
	
	@Test
	public void test1()
	{
		System.out.println(" ============== Start of Test ==================");
		
		RestAssured.baseURI = domain+country;
		
		Response response = RestAssured.get(RestAssured.baseURI);
		
		String resp = response.getBody().asString();
		
		System.out.println("Response is: "+resp);
		
		System.out.println(" ============== End of Test   ==================");
	}

}
