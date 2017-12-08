package hospProj.model;

import java.sql.Timestamp;

import javax.persistence.Entity;

@Entity
public class Doctor extends Employee {
	private String specialty;
	private String type;
	
	public Doctor(int employeeId, String employeeName, Timestamp dob, double salary, String address, String username,String password, String role, String type, String specialty) 
	{
		super(employeeId, employeeName, dob, salary, address, username, password, role);
		this.specialty = specialty;
		this.type = type;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
