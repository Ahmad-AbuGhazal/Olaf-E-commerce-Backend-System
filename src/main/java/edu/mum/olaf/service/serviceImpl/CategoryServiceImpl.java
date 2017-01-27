package edu.mum.olaf.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.olaf.domain.Category;
import edu.mum.olaf.repository.CategoryDao;
import edu.mum.olaf.service.CategoryService;
import edu.mum.olaf.validation.ServiceValidation;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
  
	@Autowired
    CategoryDao categoryDao;
	
	@Override
	@ServiceValidation
	public void save(Category category) {
	    categoryDao.save(category);
	}

	@Override
	@ServiceValidation
	public Category update(Category category) {
		return categoryDao.update(category);
	}

	@Override
	public Category findOne(long id) {
	
		return categoryDao.findOne(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	
	}
