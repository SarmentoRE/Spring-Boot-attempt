package hospProj.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hospProj.mapper.PatientMapper;
import hospProj.model.Patient;

@Repository
@Transactional
public class PatientDAO extends JdbcDaoSupport{
	@Autowired
	public PatientDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public Patient findPatient(int id) {
		String sql = PatientMapper.BASE_SQL+" where patient_id = ?";
		Object[] params = new Object[] {id};
		
		PatientMapper patientMapper = new PatientMapper();
		try {
			Patient userInfo = this.getJdbcTemplate().queryForObject(sql, params, patientMapper);
			return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
}
