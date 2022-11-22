package restAssuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class basicValidationXML {

	
	@Test
	public void testSingleContent() {
		
		given()
		
		.when()
		 .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		 
		
		.then()
		 .body("CUSTOMER.ID", equalTo("15"))
		 .log().all();
	}
	
	@Test
	public void testMultiContent() {
		
		given()
		
		.when()
		 .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		 
		
		.then()
		 .body("CUSTOMER.ID", equalTo("15"))
		 .body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
		 .body("CUSTOMER.LASTNAME", equalTo("Clancy"))
		 .body("CUSTOMER.STREET", equalTo("319 Upland P1."))
		 .body("CUSTOMER.CITY", equalTo("Seattle"));
	}
	
	@Test
	public void testMultiContentInOneGo() {
		
		given()
		
		.when()
		 .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		 
		
		.then()
		 .body("CUSTOMER.text()", equalTo("15BillClancy319 Upland P1.Seattle"))
		 ;
	}
	
	@Test
	public void testUsingXpath() {
		
		given()
		
		.when()
		 .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		 
		
		.then()
		  .body(hasXPath("/CUSTOMER/ID", containsString("15")));
	}
	
	@Test
	public void testUsingXpath2() {
		
		given()
		
		.when()
		 .get("http://thomas-bayer.com/sqlrest/INVOICE/")
		 
		
		.then()
		  .body(hasXPath("/INVOICEList/INVOICE[text()='30']"));
	}
}
