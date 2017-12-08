package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.Employee;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{
	public static final String BASE_SQL = "SELECT * FROM employee";

	@Override
	public Employee mapRow(ResultSet rs, int row) throws SQLException {
		int employeeId = rs.getInt("employee_id");
		String employeeName = rs.getString("employee_name");
		Timestamp dob = rs.getTimestamp("dob");
		double salary = rs.getDouble("salary");
		String address = rs.getString("address");
		String username = rs.getString("username");
		String password = rs.getString("password");
		String role = rs.getString("role");
		
		return new Employee(employeeId,employeeName,dob,salary,address,username,password,role);
	}	
}
