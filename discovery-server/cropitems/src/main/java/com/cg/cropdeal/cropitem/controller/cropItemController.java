package com.cg.cropdeal.cropitem.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cropdeal.cropitem.model.cropItem;
import com.cg.cropdeal.cropitem.service.cropItemService;

@RestController
@RequestMapping("/api/cropitem")
public class cropItemController {

	private cropItemService cropitemService;

	public cropItemController(cropItemService cropitemService) {
		super();
		this.cropitemService = cropitemService;
	}
	
	// build create cropitem REST API
	@PostMapping
	public ResponseEntity<cropItem> savecropItem(@RequestBody cropItem cropitem){
	return new ResponseEntity<cropItem>(cropitemService.savecropItem(cropitem),HttpStatus.CREATED);	
	}
	
	// build get all cropitems REST API
	@GetMapping
	public List<cropItem> getAllcropItems(){
		return cropitemService.getAllcropItems();
	}
	
	// build get cropitem by id REST API
		// http://localhost:8085/api/cropitems/1
	@GetMapping("{cropid}")
	public ResponseEntity<cropItem> getcropItemById(@PathVariable("cropid")long cropitemId){
		return new ResponseEntity<cropItem>(cropitemService.getcropItemById(cropitemId),HttpStatus.OK);
	}
	
	// build update cropitem REST API
		// http://localhost:8085/api/cropitems/1
	@PutMapping("{cropid}")
	public ResponseEntity<cropItem> updatecropItem(@PathVariable("cropid") long cropid
			             ,@RequestBody cropItem cropitem){
		return new ResponseEntity<cropItem>(cropitemService.updatecropItem(cropitem,cropid),HttpStatus.OK);
		
	}
	
	// build delete cropitem REST API
		// http://localhost:8085/api/cropitems/1
	@DeleteMapping("{cropid}")
	public ResponseEntity<String>deletecropItem(@PathVariable("cropid")long cropid){
		// delete cropitem from DB
		cropitemService.deletecropItem(cropid);
		return new ResponseEntity<String>("crop deleted successfully!",HttpStatus.OK);
	}
}

