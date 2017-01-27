package edu.mum.olaf.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.olaf.domain.Comment;
import edu.mum.olaf.repository.CommentDao;
import edu.mum.olaf.service.CommentService;
import edu.mum.olaf.validation.ServiceValidation;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	 @Autowired
	 CommentDao commentDao;
	
	
	@Override
	@ServiceValidation
	public void save(Comment comment) {
		commentDao.save(comment);
	}

	@Override
	@ServiceValidation
	public Comment update(Comment comment) {		
		return commentDao.update(comment);
	}

	@Override
	public Comment findOne(long id) {		
		return commentDao.findOne(id);
	}

	@Override
	public List<Comment> findAll() {		
		return commentDao.findAll();
	}

	@Override
	public List<Comment> findAllByItemId(Long itemId) {
		return commentDao.findAllByItemId(itemId);
	}

}
