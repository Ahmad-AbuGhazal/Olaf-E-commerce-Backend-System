package edu.mum.olaf.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

List<Item> items=new ArrayList<Item>();
}
