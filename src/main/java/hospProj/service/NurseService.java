package hospProj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospProj.model.Nurse;
import hospProj.repository.NurseRepository;

@Service
public class NurseService {
	
	private NurseRepository NurseRepository;
	
	@Autowired
	public NurseService(NurseRepository NurseRepository)
	{
		this.NurseRepository = NurseRepository;
	}
	
	public Nurse saveOrUpdate(Nurse Nurse) {
		NurseRepository.save(Nurse);
		return Nurse;
	}
	
	public Nurse searchByUsername(String username)
	{
		return NurseRepository.findByUsername(username);
	}
	
}
