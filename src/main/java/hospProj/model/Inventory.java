package hospProj.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Inventory implements Serializable{
	private static final long serialVersionUID = -4010520830578381419L;
	@EmbeddedId
	private InventoryId inventoryId;
	private int quantity;
	private String item_name;
	
	public Inventory(String ward, int item_id, int quantity, String item_name)
	{
		inventoryId = new InventoryId(item_id,ward);
		this.quantity = quantity;
		this.item_name = item_name;
	}
	
	public InventoryId getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int item_id, String ward) {
		inventoryId = new InventoryId(item_id, ward);
	}
	public int getItemId() {
		return inventoryId.getItemId();
	}
	public void setItemId(int itemId)
	{
		inventoryId.setItemId(itemId);
	}
	public String getWardName() {
		return inventoryId.getWardName();
	}
	public void setWardName(String wardName) {
		inventoryId.setWardName(wardName);
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
}