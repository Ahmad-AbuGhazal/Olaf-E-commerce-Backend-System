package edu.mum.olaf.service;

import java.util.List;

import edu.mum.olaf.domain.Category;

public interface CategoryService {
	public void save(Category category);
	public Category update(Category category);
	public Category findOne(long id);
	public List<Category> findAll();
}
