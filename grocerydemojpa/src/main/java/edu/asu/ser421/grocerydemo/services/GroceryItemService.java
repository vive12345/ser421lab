package edu.asu.ser421.grocerydemo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import edu.asu.ser421.grocerydemo.model.GroceryItem;
import edu.asu.ser421.grocerydemo.repository.GroceryItemRepository;

@Service
public class GroceryItemService {
	
	//Field Injection
	//@Autowired
	//private GroceryItemRepository groceryItemRepository;
	
	//Constructor Injection
	//generally recommended  
	private final GroceryItemRepository groceryItemRepository;
	
	public GroceryItemService(GroceryItemRepository groceryItemRepository) {
		this.groceryItemRepository = groceryItemRepository;
	}
	
	public List<GroceryItem> getGroceryList(){
		return groceryItemRepository.findAll();
	}
	
	public void saveGroceryItem(GroceryItem gItem) {
		groceryItemRepository.save(new GroceryItem(gItem.getId(),
					gItem.getName(),
					gItem.getGroceryType(),
					gItem.getPrice(),
					false));
	}
}
