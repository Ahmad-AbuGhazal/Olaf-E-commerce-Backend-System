package edu.mum.olaf.repository.repositoryImpl;

import org.springframework.stereotype.Repository;

import edu.mum.olaf.domain.Category;
import edu.mum.olaf.repository.CategoryDao;
@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {
	
 public CategoryDaoImpl(){
	 super.setDaoType(Category.class);
 }
	
}
