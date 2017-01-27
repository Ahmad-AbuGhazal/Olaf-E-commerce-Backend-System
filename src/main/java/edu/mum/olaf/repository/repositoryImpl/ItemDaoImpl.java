package edu.mum.olaf.repository.repositoryImpl;


import org.springframework.stereotype.Repository;

import edu.mum.olaf.domain.Item;
import edu.mum.olaf.repository.ItemDao;
import java.util.List;

import javax.persistence.Query;

@Repository
public class ItemDaoImpl extends GenericDaoImpl<Item> implements ItemDao {
	
	public ItemDaoImpl(){
		super.setDaoType(Item.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findAllBySellerId(Long sellerId) {
		Query query = entityManager.createQuery("select i from Item i  where i.seller.id =:sellerId");
		return (List<Item>) query.setParameter("sellerId", sellerId).getResultList();
		
	}
	
}
