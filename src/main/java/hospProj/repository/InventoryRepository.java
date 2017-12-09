package hospProj.repository;

import org.springframework.data.repository.CrudRepository;
import hospProj.model.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory,Long>{
}
