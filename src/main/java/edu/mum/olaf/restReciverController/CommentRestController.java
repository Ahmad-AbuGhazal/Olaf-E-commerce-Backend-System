package edu.mum.olaf.restReciverController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.olaf.domain.Comment;
import edu.mum.olaf.domain.Item;
import edu.mum.olaf.domain.User;
import edu.mum.olaf.service.CommentService;
import edu.mum.olaf.service.ItemService;
import edu.mum.olaf.service.UserService;


@RestController
@RequestMapping("/comments")
public class CommentRestController {
	
	@Autowired 
	CommentService commentService;
	
	@Autowired 
	ItemService itemService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)//TODO: what should return?  //e.g. the commentId
	public void save(@RequestBody Comment commentToBeAdded){		
	 // TODO remove item and users
		Item item=itemService.findOne(1L);
		User user=userService.findOne(1L);
		commentToBeAdded.setItem(item);
		commentToBeAdded.setUser(user);
		commentService.save(commentToBeAdded);		
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody Comment update(@RequestBody Comment comment) {		
		return commentService.update(comment);
	}
	
	
	@RequestMapping(value = "/findAll/{itemId}", method = RequestMethod.GET) 
	public @ResponseBody List<Comment> findAllByItemId(@PathVariable("itemId") Long itemId) {
		return commentService.findAllByItemId(itemId);
	}	
	

}
