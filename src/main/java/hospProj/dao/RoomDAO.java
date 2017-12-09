package hospProj.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hospProj.mapper.RoomMapper;
import hospProj.model.Room;

@Repository
@Transactional
public class RoomDAO extends JdbcDaoSupport{
	@Autowired
	public RoomDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public Room findRoomByNumber(int roomNumber) {
		String sql = RoomMapper.BASE_SQL+" where room_number = ?";
		Object[] params = new Object[] {roomNumber};
		
		RoomMapper roomMapper = new RoomMapper();
		
		try {
			Room userInfo = this.getJdbcTemplate().queryForObject(sql, params, roomMapper);
			return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
}
