package dao;

import javax.sql.DataSource;

import mapper.EmployeeMapper;
import model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeDAO extends JdbcDaoSupport {
	@Autowired
	public EmployeeDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public Employee findEmployee(String username) {
		String sql = EmployeeMapper.BASE_SQL+"where username=?";
		
		Object[] params = new Object[] { username };
		EmployeeMapper employeeMapper = new EmployeeMapper();
		try {
				Employee userInfo = this.getJdbcTemplate().queryForObject(sql, params, employeeMapper);
				return userInfo;
	        } catch (EmptyResultDataAccessException e) {
	            return null;
	        }
	}
}
