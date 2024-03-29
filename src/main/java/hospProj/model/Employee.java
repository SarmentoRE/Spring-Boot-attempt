package hospProj.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Employee {
	@Id
	private int employeeId;
	@Column(name="employee_name")
	private String employeeName;
	@Column(name="dob")
	private Timestamp dob;
	@Column(name="salary")
	private double salary;
	@Column(name="address")
	private String address;
	@NotNull
	@Column(name="username")
	private String username;
	@NotNull
	@Column(name="password")
	private String password;
	@NotNull
	@Column(name="empRole")
	private String empRole;
	
	public Employee() {}
	
	public Employee(int employeeId, String employeeName, Timestamp dob, double salary, String address, String username,String password, String role) 
	{
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dob = dob;
		this.salary = salary;
		this.address = address;
		this.username = username;
		this.password = password;
		this.empRole = role;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public Timestamp getDob() {
		return dob;
	}
	public void setDob(Timestamp dob) {
		this.dob = dob;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return empRole;
	}
	public void setRole(String role) {
		this.empRole = role;
	}
}
