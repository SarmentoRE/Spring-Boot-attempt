package hospProj.model;

import java.sql.Timestamp;

import javax.persistence.Entity;

@Entity
public class Nurse extends Employee{
	String ward;

	public Nurse(int employeeId, String employeeName, Timestamp dob, double salary, String address, String username,String password, String role, String ward) 
	{
		super(employeeId,employeeName, dob,salary, address, username, password, role);
		this.ward = ward;

	}
	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

}
