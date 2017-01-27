package edu.mum.olaf.repository.repositoryImpl;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.olaf.domain.User;
import edu.mum.olaf.repository.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(User.class );
		}

	@Override
	public User findByUserName(String username) {
	Query query=entityManager.createQuery("Select user u from User where username=:username");
	return  (User)query.setParameter("username", username).getSingleResult();
	}
	
}
