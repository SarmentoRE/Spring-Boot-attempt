package hospProj.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hospProj.model.PatientOccupy;
import hospProj.mapper.PatientOccupyMapper;

@Repository
@Transactional
public class PatientOccupyDAO extends JdbcDaoSupport{
	@Autowired
	public PatientOccupyDAO (DataSource dataSource) {
		this.setDataSource(dataSource);
	}
}
