package hospProj.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hospProj.mapper.InventoryMapper;
import hospProj.model.Inventory;

@Repository
@Transactional
public class InventoryDAO extends JdbcDaoSupport {
	@Autowired
	public InventoryDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public Inventory findInventory(String ward, String item_id) {
		String sql = InventoryMapper.BASE_SQL+" where ward=?" + " and item_id=?";
		
		Object[] params = new Object[] { ward , item_id};
		InventoryMapper InventoryMapper = new InventoryMapper();
		try {
				Inventory inv = this.getJdbcTemplate().queryForObject(sql, params, InventoryMapper);
				return inv;
	        } catch (EmptyResultDataAccessException e) {
	            return null;
	        }
	}
}
