package hospProj.repository;

import org.springframework.data.repository.CrudRepository;
import hospProj.model.Room;

public interface RoomRepository extends CrudRepository<Room, Long>{
	Room findRoomByRoomNumber(int roomNumber);
}
