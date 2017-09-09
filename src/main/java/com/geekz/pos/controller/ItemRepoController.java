package com.geekz.pos.controller;

import com.geekz.orm.hibernate.HibernateOperator;
import com.geekz.pos.model.ItemRepo;

public class ItemRepoController {
	
	public void addNewItem(String inItemUnit, String outItemUnit, String price, String date) {
		ItemRepo teller = new ItemRepo(inItemUnit, outItemUnit, price, date);
		HibernateOperator.getInstance().add(ItemRepo.class, teller);
	}

	public ItemRepo readRepoItem(Integer i) {
		ItemRepo item = (ItemRepo) HibernateOperator.getInstance().read(ItemRepo.class, i);
		return item;
	}
	
	public void editItem() {

	}

	public void removeItem() {

	}
}
