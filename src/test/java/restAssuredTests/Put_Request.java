package restAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class Put_Request {

	public static HashMap map = new HashMap();
	
	String empName = RestUtils.empName();
	String empSal = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	int emp_id=11254;
	
	@BeforeClass
	public void putData() {
		
		map.put("name", empName);
		map.put("salary", empSal);
		map.put("age", empAge);
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
	}
	
	@Test
	public void testPut() {
		
		given()
		  .contentType("application/json")
		  .body(map)
		.when()
		  .put()
		.then()
		  .statusCode(200);
	}
	
}
