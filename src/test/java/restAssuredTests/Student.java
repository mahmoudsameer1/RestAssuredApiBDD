package restAssuredTests;

import java.util.List;

public class Student {

	
	public Integer id;
	public String firstName;
	public String lastName;
	public String email;
	public String programme;
	
	List<String> courses;
	
	public int getSID() {
		return id;
	}
	
	public void setSID(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getStudentRecored() {
		
		return(this.id+""+this.firstName);
	}
}
