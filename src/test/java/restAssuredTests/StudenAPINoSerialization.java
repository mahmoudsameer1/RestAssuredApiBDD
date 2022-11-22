package restAssuredTests;

import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class StudenAPINoSerialization {

	
	public HashMap map=new HashMap();
	
	@Test
	public void CreateNewStudent() {
		
		map.put("id", 101);
		map.put("firstName", 101);
		map.put("lastName", 101);
		map.put("email", 101);
		map.put("programme", 101);
		
		ArrayList<String> courserList = new ArrayList<String> ();
		courserList.add("Java");
		courserList.add("Selenium");
		
		map.put("courses", courserList);
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		.when()
		 .post("http://localhost:8085/student")
		 
		 .then()
		 .statusCode(200)
		 .assertThat()
		 .body("msg", equalTo("Studen added"));
		
	}
	
	@Test
	public void getStudenRecored(){
		
		given()
		
		.when()
		 .get("http://localhost:8085/student/101")
		 
		 .then()
		  .statusCode(200)
		  .assertThat()
		  .body("id", equalTo(101));
	}
}
