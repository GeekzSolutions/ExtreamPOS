package com.geekz.pos.controller;

import com.geekz.orm.hibernate.HibernateOperator;
import com.geekz.pos.model.Client;
import com.geekz.pos.model.ClientOrder;
import com.geekz.pos.model.ItemOrder;
import com.geekz.pos.model.ItemRepo;
import com.geekz.pos.model.Teller;

public class ItemOrderController {
	
	public void addNewItemOrder(Double inAmount, Double outAmount, ClientOrder clientOrder, ItemRepo itemRepo) {
		ItemOrder order = new ItemOrder(inAmount, outAmount, clientOrder, itemRepo);
		HibernateOperator.getInstance().add(ItemOrder.class, order);
	}

	public ItemOrder readItemOrder(Integer i) {
		ItemOrder order = (ItemOrder) HibernateOperator.getInstance().read(ItemOrder.class, i);
		return order;
	}
	
	public void editItemOrder(Integer i, Double inAmount, Double outAmount, ClientOrder clientOrder, ItemRepo itemRepo) {
		ItemOrder order = new ItemOrder(i, inAmount, outAmount, clientOrder, itemRepo);
		HibernateOperator.getInstance().edit(ItemOrder.class, order);
	}

	public void removeItemOrder() {

	}
}
