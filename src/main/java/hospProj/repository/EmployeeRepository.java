package hospProj.repository;

import org.springframework.data.repository.CrudRepository;
import hospProj.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{

	Employee findByUsername(String username);
	
}
