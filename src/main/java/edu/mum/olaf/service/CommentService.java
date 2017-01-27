package edu.mum.olaf.service;

import java.util.List;

import edu.mum.olaf.domain.Comment;

public interface CommentService {
	public void save(Comment comment);
	public Comment update(Comment comment);
	public Comment findOne(long id);
	public List<Comment> findAll();	
	public List<Comment> findAllByItemId(Long itemId);
}
