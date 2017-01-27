package edu.mum.olaf.repository;

import edu.mum.olaf.domain.User;

public interface UserDao extends GenericDao<User> {
User findByUserName(String username);
}
