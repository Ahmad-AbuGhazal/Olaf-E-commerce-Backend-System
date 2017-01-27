package edu.mum.olaf.restReciverController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.olaf.domain.User;
import edu.mum.olaf.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	@ResponseBody
	public User registerUser(@RequestBody User user){
		return userService.save(user);
	}
	@ResponseBody
	@RequestMapping(value="/secure/users",method=RequestMethod.GET)
	public List<User> findAllUsers(){
		return userService.findAll();
	}
	@ResponseBody
	@RequestMapping(value="/secure/users/user/{username}",method=RequestMethod.GET)
	public User findUserByName(@PathVariable("username") String username){
		return userService.findByUserName(username);
	}
	
	@ResponseBody
	@RequestMapping(value="/secure/users/{id}",method=RequestMethod.GET)
	public User findUser(@PathVariable("id") Long id){
		return userService.findOne(id);
	}
	
}
