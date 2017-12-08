package hospProj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import hospProj.model.Nurse;

public class NurseMapper implements RowMapper<Nurse>{
	public static final String BASE_SQL = "SELECT * FROM employee join nurse on employee.employee_id = nurse.employee_id";

	@Override
	public Nurse mapRow(ResultSet rs, int row) throws SQLException {
		int NurseId = rs.getInt("Nurse_id");
		String NurseName = rs.getString("Nurse_name");
		Timestamp dob = rs.getTimestamp("dob");
		double salary = rs.getDouble("salary");
		String address = rs.getString("address");
		String username = rs.getString("username");
		String password = rs.getString("password");
		String role = rs.getString("emp_role");
		String ward = rs.getString("ward");
		
		return new Nurse(NurseId,NurseName,dob,salary,address,username,password,role, ward);
	}	
}
