package hospProj.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospProj.model.Patient;
import hospProj.model.PatientOccupy;
import hospProj.model.Room;
import hospProj.repository.PatientOccupyRepository;
import hospProj.repository.PatientRepository;
import hospProj.repository.RoomRepository;

@Service
public class PatientOccupyService {
	private PatientOccupyRepository patientOccupyRepository;
	private PatientRepository patientRepository;
	private RoomRepository roomRepository;
	
	
	@Autowired
	public PatientOccupyService (PatientOccupyRepository patientOccupyRepository, PatientRepository patientRepository, RoomRepository roomRepository) {
		this.patientOccupyRepository = patientOccupyRepository;
		this.patientRepository = patientRepository;
		this.roomRepository = roomRepository;
	}
	
	public List<Room> findPatientRoom(int patientId){
		List<Room> rooms = new ArrayList<Room>();
		Patient patient =  patientRepository.findByPatientId(patientId);
		Iterator<PatientOccupy> i = patientOccupyRepository.findAll().iterator();
		
		while(i.hasNext()) {
			PatientOccupy occupy = i.next();
			if(occupy.getPatientId() == patient.getPatientId())
			{
				rooms.add(roomRepository.findRoomByRoomNumber(occupy.getRoomNumber()));
			}
		}
		return rooms;
	}
	
	public PatientOccupy saveOrUpdate(PatientOccupy patientOccupy) {
		return patientOccupyRepository.save(patientOccupy);
	}
}
