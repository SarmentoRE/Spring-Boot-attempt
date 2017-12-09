package hospProj.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hospProj.model.Room;
import hospProj.repository.RoomRepository;

@Service
public class RoomService {
	private RoomRepository roomRepository;
	
	@Autowired
	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	public List<Room> findOpenRooms(String ward){
		List<Room> rooms = new ArrayList<Room>();
		Iterator<Room> i = roomRepository.findAll().iterator();
		
		while(i.hasNext()) {
			Room room = i.next();
			if(room.getWardName().equals(ward) && room.getOccupancy() < room.getMaxOccupancy()) {
				rooms.add(room);
			}
		}
		return rooms;
	}

	public List<Room> listAll() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		roomRepository.findAll().forEach(rooms::add);
		return rooms;
	}
	
	public Room saveOrUpdate(Room room) {
		return roomRepository.save(room);
	}
}
