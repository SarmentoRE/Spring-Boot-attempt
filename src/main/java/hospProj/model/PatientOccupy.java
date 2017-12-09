package hospProj.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PatientOccupy implements Serializable{
	private static final long serialVersionUID = -401052083381419L;
	@EmbeddedId 
	PatientOccupyId patientOccupyId;
	
	public PatientOccupy() {}
	public PatientOccupy(int patientId, int roomNumber) {
		this.patientOccupyId = new PatientOccupyId(patientId,roomNumber);
	}
	
	public int getPatientId() {
		return patientOccupyId.getPatientId();
	}
	public void setPatientId(int patientId) {
		patientOccupyId.setPatientId(patientId);
	}
	public int getRoomNumber() {
		return patientOccupyId.getRoomNumber();
	}
	public void setRoomNumber(int roomNumber) {
		patientOccupyId.setRoomNumber(roomNumber);
	}
}