package hospProj.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospProj.model.Patient;
import hospProj.repository.PatientRepository;

@Service
public class PatientService {
	private PatientRepository patientRepository;
	
	@Autowired
	public PatientService(PatientRepository patientRepository)
	{
		this.patientRepository = patientRepository;
	}
	
	public Patient saveOrUpdate(Patient patient) {
		patientRepository.save(patient);
		return patient;
	}
	
	public Patient searchById(int Id)
	{
		return patientRepository.findByPatientId(Id);
	}
	
	public List<Patient> listAll(){
		List<Patient> patients = new ArrayList<>();
		patientRepository.findAll().forEach(patients::add);
		return patients;
	}
}
