package hospProj.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hospProj.mapper.NurseMapper;
import hospProj.model.Nurse;

@Repository
@Transactional
public class NurseDAO extends JdbcDaoSupport {
	@Autowired
	public NurseDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public Nurse findNurse(String username) {
		String sql = NurseMapper.BASE_SQL+" where username=?";
		
		Object[] params = new Object[] { username };
		NurseMapper NurseMapper = new NurseMapper();
		try {
				Nurse userInfo = this.getJdbcTemplate().queryForObject(sql, params, NurseMapper);
				return userInfo;
	        } catch (EmptyResultDataAccessException e) {
	            return null;
	        }
	}
}
