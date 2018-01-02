package testsuit;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;

public class Common {
	
	@BeforeClass
	public static void base()
	{
		baseURI = "http://services.groupkt.com";
		basePath = "/country/get/iso2code";
	}

}
