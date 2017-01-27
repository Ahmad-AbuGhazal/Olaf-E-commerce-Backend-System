package edu.mum.olaf.repository.repositoryImpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.olaf.domain.Comment;
import edu.mum.olaf.repository.CommentDao;


@Repository
public class CommentDaoImpl extends GenericDaoImpl<Comment> implements CommentDao  {
	
	public CommentDaoImpl(){
		super.setDaoType(Comment.class);
	}

	@Override
	public List<Comment> findAllByItemId(Long itemId) {
		Query query = entityManager.createQuery("select c from Comment c  where c.item.id =:itemId");
		return (List<Comment>) query.setParameter("itemId", itemId).getResultList();		 
	}

}
