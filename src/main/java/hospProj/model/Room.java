package hospProj.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
	@Id
	private int roomNumber;
	private int occupancy;
	private String wardName;
	private int maxOccupancy;
	
	public Room() {}
	
	public Room(int roomNumber, int occupancy, String wardName, int maxOccupancy) {
		this.roomNumber = roomNumber;
		this.occupancy = occupancy;
		this.wardName = wardName;
		this.maxOccupancy = maxOccupancy;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}
	public String getWardName() {
		return wardName;
	}
	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public int getMaxOccupancy() {
		return maxOccupancy;
	}

	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}
	
}
