package hospProj.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import hospProj.model.Inventory;

public class InventoryMapper implements RowMapper<Inventory>{

	public static final String BASE_SQL = "SELECT * FROM inventory";

	@Override
	public Inventory mapRow(ResultSet rs, int row) throws SQLException {
		// TODO Auto-generated method stub
		String ward = rs.getString("ward");
		int item_id = rs.getInt("item_id");
		int quantity = rs.getInt("quantity");
		String item_name = rs.getString("item_name");
		return new Inventory(ward, item_id, quantity, item_name);
	}

}
