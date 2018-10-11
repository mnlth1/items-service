/**
 * 
 */
package com.service.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.Items;
import com.db.service.ItemsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Lalitha
 *
 */
@RestController
@Api(value = "items", description = "Service operation on items.")
public class ItemsController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ItemsRepository repository;
	
	@GetMapping("/items/{id}")
	@ApiOperation(value = "Get item details", notes = "Get details for specified item", nickname="getItemDetails")
	public Items findItemDetails(@PathVariable String itemId) {
		
		Long id = itemId.isEmpty() ? 0 : Long.parseLong(itemId);
		
		Items itemDetails = this.repository.findItem(id);
		itemDetails.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return itemDetails;
	}
	
	@GetMapping("/items")
	public List<Items> findAllItems() {
		List<Items> itemsList =  (List<Items>) this.repository.findAll();
		return itemsList;
		
	}
}
