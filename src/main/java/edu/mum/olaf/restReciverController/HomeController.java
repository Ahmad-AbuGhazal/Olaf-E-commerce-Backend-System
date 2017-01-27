package edu.mum.olaf.restReciverController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.olaf.domain.Category;
import edu.mum.olaf.service.CategoryService;

@RestController
public class HomeController {


@Autowired
CategoryService categoryService;
@RequestMapping("/")
public @ResponseBody String welcome(){
	return "hello";
	
}
}
