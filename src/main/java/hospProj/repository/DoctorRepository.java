package hospProj.repository;

import org.springframework.data.repository.CrudRepository;
import hospProj.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor,Long>{
	Doctor findByUsername(String username);
}
