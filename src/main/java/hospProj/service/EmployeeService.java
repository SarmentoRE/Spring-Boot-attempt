package hospProj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospProj.model.Employee;
import hospProj.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}
	
	public Employee saveOrUpdate(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
}
