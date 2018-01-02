package testsuit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestRstAsrd5_Jsonpath {
	
	public class TestRstAsrd {
		
		private String domain = "http://services.groupkt.com/country/get/iso2code";
		private String countrycode = "/US";
		private String country;
		private String alphacode2;
		private String alphacode3;
		
		
		@Test
		public void test7()
		{
			System.out.println(" ============== Start of Test ==================");
			
			RestAssured.baseURI = domain+countrycode;			
			Response response = RestAssured.get(RestAssured.baseURI);
			
			String resp = response.getBody().asString();			
			System.out.println("Response is: "+resp);
			JsonPath jsoneval = response.jsonPath();
			
			country = jsoneval.get("RestResponse.result.name");			
			System.out.println("City is: "+country);
			
			alphacode2 = jsoneval.get("RestResponse.result.alpha2_code");			
			System.out.println("Alpha Code 2 is: "+alphacode2);
			
			alphacode3 = jsoneval.get("RestResponse.result.alpha3_code");			
			System.out.println("Alpha Code 3 is: "+alphacode3);
			
			
			Assert.assertEquals(country, "United States of America");
			Assert.assertEquals(alphacode2, "US");
			Assert.assertEquals(alphacode3, "USA");
			
			System.out.println(" ============== End of Test   ==================");
		}
		
	}

}
