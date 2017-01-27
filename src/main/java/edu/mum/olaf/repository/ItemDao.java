package edu.mum.olaf.repository;

import java.util.List;

import edu.mum.olaf.domain.Item;

public interface ItemDao extends GenericDao<Item>{
	List<Item> findAllBySellerId(Long sellerId);//returns the list of items for that seller (the items that the seller sold)
}
