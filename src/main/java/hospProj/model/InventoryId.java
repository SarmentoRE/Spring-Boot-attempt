package hospProj.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InventoryId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int itemId;
	private String wardName;
	
	public InventoryId() {}
	public InventoryId(int itemId, String wardName) {
		this.itemId = itemId;
		this.wardName = wardName;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int inventoryId) {
		this.itemId = inventoryId;
	}
	public String getWardName() {
		return wardName;
	}
	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
}
