package edu.mum.olaf.restReciverController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import edu.mum.olaf.domain.Item;
import edu.mum.olaf.service.CategoryService;
import edu.mum.olaf.service.ItemService;
import edu.mum.olaf.service.UserService;

@RestController
public class ItemRestController {
@Autowired
ItemService itemService;
@Autowired
CategoryService categoryService;
@Autowired
UserService userService;
@RequestMapping(value="/addItem",method=RequestMethod.POST)
public void addItem(Item item){
	itemService.save(item);
}

@RequestMapping(value="/items",method=RequestMethod.GET)
	
	public @ResponseBody List<Item> items(){
		return itemService.findAll();
	}
	
	
	@RequestMapping(value="/items/{id}",method=RequestMethod.GET)
	public @ResponseBody Item getitem(@PathVariable("id") long id){
		return itemService.findOne(id);
	}
	
	@RequestMapping(value="/itemsBySellerId/{id}",method=RequestMethod.GET)
	public @ResponseBody List<Item> getItemsBySellerId(@PathVariable("id") long id){
		return itemService.findAllBySellerId(id);
	}
}
