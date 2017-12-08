package hospProj.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hospProj.mapper.DoctorMapper;
import hospProj.model.Doctor;

@Repository
@Transactional
public class DoctorDAO extends JdbcDaoSupport {
	@Autowired
	public DoctorDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public Doctor findDoctor(String username) {
		String sql = DoctorMapper.BASE_SQL+" where username=?";
		
		Object[] params = new Object[] { username };
		DoctorMapper DoctorMapper = new DoctorMapper();
		try {
				Doctor userInfo = this.getJdbcTemplate().queryForObject(sql, params, DoctorMapper);
				return userInfo;
	        } catch (EmptyResultDataAccessException e) {
	            return null;
	        }
	}
}
