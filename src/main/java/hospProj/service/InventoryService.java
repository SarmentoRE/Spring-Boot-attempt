package hospProj.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospProj.model.Inventory;
import hospProj.repository.InventoryRepository;

@Service
public class InventoryService {
	private InventoryRepository InventoryRepository;
	
	@Autowired
	public InventoryService(InventoryRepository InventoryRepository)
	{
		this.InventoryRepository = InventoryRepository;
	}
	
	public Inventory saveOrUpdate(Inventory Inventory) {
		InventoryRepository.save(Inventory);
		return Inventory;
	}
	
	public List<Inventory> searchByWard(String ward)
	{
		List<Inventory> Inventorys = new ArrayList<>();
		InventoryRepository.findByWard(ward);
		return Inventorys;
	}
	
	public List<Inventory> listAll(){
		List<Inventory> Inventorys = new ArrayList<>();
		InventoryRepository.findAll().forEach(Inventorys::add);
		return Inventorys;
	}
}
