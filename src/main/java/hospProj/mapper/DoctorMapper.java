package hospProj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import hospProj.model.Doctor;

public class DoctorMapper implements RowMapper<Doctor>{
	public static final String BASE_SQL = "SELECT * FROM doctor";

	@Override
	public Doctor mapRow(ResultSet rs, int row) throws SQLException {
		String type = rs.getString("type");
		String specialty = rs.getString("specialty");
		
		return new Doctor(/*employeeId,employeeName,dob,salary,address,username,password,role,type,specialty*/);
	}	
}
