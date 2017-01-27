package edu.mum.olaf.service;

import java.util.List;
import edu.mum.olaf.domain.User;

public interface UserService {

	public User save(User user);
	public User update(User user);
	public User findOne(long id);
	User findByUserName(String username);
	public List<User> findAll();
}
