package hospProj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hospProj.model.PatientOccupy;

public class PatientOccupyMapper implements RowMapper<PatientOccupy>{
	public static final String BASE_SQL = "SELECT * FROM patient_occupy";
	
	@Override
	public PatientOccupy mapRow(ResultSet rs, int row) throws SQLException {
		int roomNumber = rs.getInt("room_number");
		int patientId = rs.getInt("patient_id");
		return new PatientOccupy(roomNumber, patientId);
	}
}
