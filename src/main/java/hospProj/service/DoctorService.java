package hospProj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospProj.model.Doctor;
import hospProj.repository.DoctorRepository;

@Service
public class DoctorService {
	
	private DoctorRepository DoctorRepository;
	
	@Autowired
	public DoctorService(DoctorRepository DoctorRepository)
	{
		this.DoctorRepository = DoctorRepository;
	}
	
	public Doctor saveOrUpdate(Doctor Doctor) {
		DoctorRepository.save(Doctor);
		return Doctor;
	}
	
	public Doctor searchByUsername(String username)
	{
		return DoctorRepository.findByUsername(username);
	}
	
}
