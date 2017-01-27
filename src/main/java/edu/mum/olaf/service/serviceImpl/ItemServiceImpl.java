package edu.mum.olaf.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.olaf.domain.Item;
import edu.mum.olaf.repository.ItemDao;
import edu.mum.olaf.service.ItemService;
import edu.mum.olaf.validation.ServiceValidation;
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemDao itemDao;
	
	@Override
	@ServiceValidation
	public void save(Item item) {
		itemDao.save(item);
	}

	@Override
	@ServiceValidation
	public Item update(Item item) {
		return itemDao.update(item);
	}

	@Override
	public Item findOne(long id) {
		return itemDao.findOne(id);
	}

	@Override
	public List<Item> findAll() {
		return itemDao.findAll();
	}

	@Override
	public List<Item> findAllBySellerId(Long sellerId) {
		return itemDao.findAllBySellerId(sellerId);
	}

}
