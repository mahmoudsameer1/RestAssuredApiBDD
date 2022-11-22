package restAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicValidations {

	@Test(priority=1)
	public void testStatusCode() {
		
		given()
		
		.when()
		  .get("http://jsonplaceholder.typicode.com/posts/5")
		
		.then()
		  .statusCode(200)
		  .log().all();
	}
	
	@Test (priority=2)
	public void testLogging() {
		
		given()
		
		.when()
		  .get("http://services.groupkt.com/country/get/iso2code/IN")
		
		.then()
		  .statusCode(200)
		  .log().all();
	}
	
	@Test (priority=3)
	public void testsingleContent() {
		
		given()
		
		.when()
		  .get("http://services.groupkt.com/country/get/iso2code/IN")
		
		.then()
		  .statusCode(200)
		  .body("RestResponse.result.name", equalTo("India"));
	}
	
	@Test (priority=4)
	public void testMultiContent() {
		
		given()
		
		.when()
		  .get("http://services.groupkt.com/country/get/all")
		
		.then()
		  .body("RestResponse.result.name", hasItems("India","Australia"));
	}
	
	@Test (priority=5)
	public void testParamsAndHeaders() {
		
		given()
		  .param("", "")
		  .header("","")
		.when()
		  .get("http://services.groupkt.com/country/get/iso2code/IN")
		
		.then()
		  .body("RestResponse.result.name", hasItems("India","Australia"));
	}
	
}
