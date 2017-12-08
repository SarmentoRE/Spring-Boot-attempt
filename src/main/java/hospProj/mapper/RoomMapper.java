package hospProj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hospProj.model.Room;

public class RoomMapper implements RowMapper<Room>{
	public static final String BASE_SQL = "SELECT * FROM room";
	
	@Override
	public Room mapRow(ResultSet rs, int row) throws SQLException {
		int roomNumber = rs.getInt("room_number");
		int occupancy = rs.getInt("occupancy");
		String ward = rs.getString("ward_name");
		int maxOccupancy = rs.getInt("max_occupancy");
		
		return new Room(roomNumber,occupancy,ward, maxOccupancy);
	}
}
