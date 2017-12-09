package hospProj.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospProj.model.Inventory;
import hospProj.repository.InventoryRepository;

@Service
public class InventoryService {
	private InventoryRepository inventoryRepository;
	
	@Autowired
	public InventoryService(InventoryRepository inventoryRepository)
	{
		this.inventoryRepository = inventoryRepository;
	}
	
	public Inventory saveOrUpdate(Inventory inventory) {
		inventoryRepository.save(inventory);
		return inventory;
	}
	
	public List<Inventory> searchByWard(String ward)
	{
		List<Inventory> inventorys = new ArrayList<>();
		Iterator<Inventory> i= inventoryRepository.findAll().iterator();
		while(i.hasNext())
		{
			Inventory inv = i.next();
			if(inv.getWardName().equals(ward))
			{
				inventorys.add(inv);
			}
		}
		return inventorys;
	}
	
	public List<Inventory> listAll(){
		List<Inventory> Inventorys = new ArrayList<>();
		inventoryRepository.findAll().forEach(Inventorys::add);
		return Inventorys;
	}
}
