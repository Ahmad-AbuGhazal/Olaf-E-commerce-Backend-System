package edu.mum.olaf.restReciverController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.olaf.domain.Category;
import edu.mum.olaf.service.CategoryService;

@RestController
public class CategoryRestController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public void addCategory(@RequestBody Category category) {
		 categoryService.save(category);
	}
	
	@RequestMapping("/categories")
	public @ResponseBody List<Category>  getCategories() {
		return categoryService.findAll();
	}
	
	@RequestMapping("/categories/{id}")
	public @ResponseBody Category  getCategory(@PathVariable("id") long id) {
		return categoryService.findOne(id);
	}
}
