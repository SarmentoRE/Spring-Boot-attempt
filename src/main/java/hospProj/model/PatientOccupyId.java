package hospProj.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PatientOccupyId implements Serializable{
	private static final long serialVersionUID = 13L;
	private int patientId;
	private int roomNumber;
	
	public PatientOccupyId() {}
	
	public PatientOccupyId(int patientId, int roomNumber) {
		this.patientId = patientId;
		this.roomNumber = roomNumber;
	}
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
}
