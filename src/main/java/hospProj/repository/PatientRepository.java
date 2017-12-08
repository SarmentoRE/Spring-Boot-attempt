package hospProj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import hospProj.model.Patient;

public interface PatientRepository extends CrudRepository<Patient,Long>{
	Patient findByPatientId(int Id);
}
