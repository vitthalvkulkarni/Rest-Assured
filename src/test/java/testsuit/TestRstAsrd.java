package testsuit;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class TestRstAsrd {
		
	@Test
	public void test1()
	{
		System.out.println(" ============== Start of Test ==================");
		
		given().
			get("http://services.groupkt.com/country/get/iso2code/IN").
		then().	
			statusCode(200);
		
	}
	
	@Test
	public void test2()
	{
		given().
			get("http://services.groupkt.com/country/get/iso2code/IN").
		then().	
			statusCode(200).log().all();

	}	
	
	@Test
		public void test3()
		{
			given().
				get("http://services.groupkt.com/country/get/iso2code/IN").
			then().
				statusCode(200).
				assertThat().
				body("RestResponse.result.name", equalTo("India"));
			
			System.out.println(" ============== End of Test   ==================");
		}
	

			
}
