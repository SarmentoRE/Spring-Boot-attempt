package hospProj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import hospProj.model.Doctor;

public class DoctorMapper implements RowMapper<Doctor>{
	public static final String BASE_SQL = "SELECT * FROM employee join doctor on employee.employee_id = doctor.employee_id";

	@Override
	public Doctor mapRow(ResultSet rs, int row) throws SQLException {
		int employeeId = rs.getInt("employee_id");
		String employeeName = rs.getString("employee_name");
		Timestamp dob = rs.getTimestamp("dob");
		double salary = rs.getDouble("salary");
		String address = rs.getString("address");
		String username = rs.getString("username");
		String password = rs.getString("password");
		String role = rs.getString("emp_role");
		String type = rs.getString("type");
		String specialty = rs.getString("specialty");
		
		return new Doctor(employeeId,employeeName,dob,salary,address,username,password,role,type,specialty);
	}	
}
