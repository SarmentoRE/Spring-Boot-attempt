package hospProj.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Inventory {
	@Id
	@NotNull
	String ward;
	@Id
	String item_id;
	int quantity;
	
	public Inventory(String ward, String item_id, int quantity)
	{
		this.ward = ward;
		this.item_id = item_id;
		this.quantity = quantity;
	}
	
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
