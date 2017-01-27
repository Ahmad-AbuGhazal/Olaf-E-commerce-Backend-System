package edu.mum.olaf.service;

import java.util.List;

import edu.mum.olaf.domain.Item;

public interface ItemService {
	void save(Item item);
	Item update(Item item);
	Item findOne(long id);
	List<Item> findAll();
	List<Item> findAllBySellerId(Long sellerId);
}
