package com.geekz.pos.controller;

import com.geekz.orm.hibernate.HibernateOperator;
import com.geekz.pos.model.Client;
import com.geekz.pos.model.ClientOrder;
import com.geekz.pos.model.Teller;

public class ClientOrderController {

	public void addNewOrder(String orderDate, String returnDate, String status, Teller teller, Client client) {
		ClientOrder order = new ClientOrder(orderDate, returnDate, status, teller, client);
		HibernateOperator.getInstance().add(ClientOrder.class, order);
	}

	public ClientOrder readClientOrder(Integer i) {
		ClientOrder order = (ClientOrder) HibernateOperator.getInstance().read(ClientOrder.class, i);
		return order;
	}
	
	public void editOrder() {

	}

	public void removeOrder() {

	}
}
