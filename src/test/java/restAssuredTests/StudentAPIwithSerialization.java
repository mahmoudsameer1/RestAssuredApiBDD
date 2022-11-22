package restAssuredTests;

import java.util.ArrayList;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class StudentAPIwithSerialization {

	@Test
	public void createNewStudenSerialization() {
		
		ArrayList<String> coursesList = new ArrayList<String>();
		
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		Student stu = new Student();
		
		stu.setSID(101);
		stu.setFirstName("mahmoud");
		
		given()
		 .contentType(ContentType.JSON)
		 .body(stu)
		
		.when()
		 .post("http://localhost:8085/student")
		
		.then()
		 .statusCode(201)
		 .assertThat()
		 .body("msg", equalTo("Studen added"));
	}
	
	@Test
	public void getStudenRecordDeserilization() {
		
		Student stu= get("http://localhost:8085/student/101").as(Student.class);
		
		System.out.println(stu.getStudentRecored());
		Assert.assertEquals(stu.getSID(), 101);
	}
}
