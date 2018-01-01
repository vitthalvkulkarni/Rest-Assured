package com.rest.assured.test.mvn;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Vkpractice {

	
	private String country;
	private String alpha2;
	private String alpha3;
	private String url = "http://services.groupkt.com/country/get/iso2code/US";
	
	
	@Test
	public void test1()
	{
		Response response = 
		when()
		.get(url)
		.then()
		.extract()
		.response();
		
		JsonPath jpath = response.jsonPath();
		
		country = jpath.getString("RestResponse.result.name");
		alpha2 = jpath.getString("RestResponse.result.alpha2_code");
		alpha3 = jpath.getString("RestResponse.result.alpha3_code");	
		
		System.out.println("Test1 is passed");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Country is: "+country);
		System.out.println("alpha2 is: "+alpha2);
		System.out.println("alpha3 is: "+alpha3);
	}
	
	@Test
	public void test3()
	{
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("United States of America", country);
		sa.assertEquals("US", alpha2);
		sa.assertEquals("USA", alpha3);	
		sa.assertAll();
	}
	
	@Test
	public void test4()
	{
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(country, "United States of North America");
		sa.assertEquals(alpha2, "US");
		sa.assertEquals(alpha3, "USA");	
		sa.assertAll();
	}
	
	@Test
	public void test5()
	{
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(country, "United States of America");
		sa.assertEquals(alpha2, "IN");
		sa.assertEquals(alpha3, "USA");	
		sa.assertAll();
		
	}
	
	@Test
	public void test6()
	{
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(country, "United States of America");
		sa.assertEquals(alpha2, "US");
		sa.assertEquals(alpha3, "IND");	
		sa.assertAll();
	}
	
	@Test
	public void test7()
	{
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(country, "United States of N America");
		sa.assertEquals(alpha2, "CN");
		sa.assertEquals(alpha3, "AUS");	
		sa.assertAll();
	}
}
