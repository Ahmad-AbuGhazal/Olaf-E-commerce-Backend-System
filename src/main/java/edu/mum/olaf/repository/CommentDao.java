package edu.mum.olaf.repository;

import java.util.List;

import edu.mum.olaf.domain.Comment;

public interface CommentDao extends GenericDao<Comment> {
	
	public List<Comment> findAllByItemId(Long itemId);//return a list of Comments for that item
}
