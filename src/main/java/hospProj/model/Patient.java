package hospProj.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
	@Id
	private int patientId;
	private String patientName;
	private Timestamp dob;
	private String sex;
	private double height;
	private double weight;
	private String address;
	
	public Patient() {};
	
	public Patient(int patientId, String patientName, Timestamp dob, String sex, double height, double weight,
			String address) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.dob = dob;
		this.sex = sex;
		this.height = height;
		this.weight = weight;
		this.address = address;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Timestamp getDob() {
		return dob;
	}
	public void setDob(Timestamp dob) {
		this.dob = dob;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
