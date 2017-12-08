package hospProj.repository;

import org.springframework.data.repository.CrudRepository;
import hospProj.model.Nurse;

public interface NurseRepository extends CrudRepository<Nurse,Long>{
	Nurse findByUsername(String username);
}
