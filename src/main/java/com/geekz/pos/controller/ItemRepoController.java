package com.geekz.pos.controller;

import com.geekz.orm.hibernate.HibernateOperator;
import com.geekz.pos.model.ItemRepo;

public class ItemRepoController {
	
	public void addNewItem(String name, String inItemUnit, String outItemUnit, String price, String date) {
		ItemRepo item = new ItemRepo(name, inItemUnit, outItemUnit, price, date);
		HibernateOperator.getInstance().add(ItemRepo.class, item);
	}

	public ItemRepo readRepoItem(Integer i) {
		ItemRepo item = (ItemRepo) HibernateOperator.getInstance().read(ItemRepo.class, i);
		return item;
	}
	
	public void editItem(Integer i, String name, String inItemUnit, String outItemUnit, String price, String date) {
		ItemRepo item = new ItemRepo(i, name, inItemUnit, outItemUnit, price, date);
		HibernateOperator.getInstance().edit(ItemRepo.class, item);
	}

	public void removeItem() {

	}
}
