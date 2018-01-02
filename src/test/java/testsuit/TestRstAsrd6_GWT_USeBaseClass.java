package testsuit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.net.URI;
import java.net.URISyntaxException;

public class TestRstAsrd6_GWT_USeBaseClass extends Common{
	
	private String country;
	private String alpha2;
	private String alpha3;
	
	

	//@Test
	public void test8() throws URISyntaxException
	{
		System.out.println(baseURI+basePath);
		Response response = given()
		.get(new URI("/US"));
		
		
		System.out.println(response);
		JsonPath jsoneval = response.jsonPath();
		
		country = jsoneval.get("Response.result.name");
		alpha2 = jsoneval.get("Response.result.alpha2_code");
		alpha3 = jsoneval.get("Response.result.alpha3_code");
		
		Assert.assertEquals(country, "United States of America");
		Assert.assertEquals(alpha2, "US");
		Assert.assertEquals(alpha3, "USA");
		
		
	//	System.out.println("Response is: "+response);
	}
}
