package hospProj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import hospProj.model.Patient;

public class PatientMapper implements RowMapper<Patient>{
	public static final String BASE_SQL = "SELECT * FROM patient";

	@Override
	public Patient mapRow(ResultSet rs, int row) throws SQLException {
		int patientId = rs.getInt("patient_id");
		String patientName = rs.getString("patient_name");
		Timestamp dob = rs.getTimestamp("dob");
		String sex = rs.getString("sex");
		double height = rs.getDouble("height");
		double weight = rs.getDouble("weight");
		String address = rs.getString("address");
		
		return new Patient(patientId,patientName,dob,sex,height,weight,address);
	}
}
