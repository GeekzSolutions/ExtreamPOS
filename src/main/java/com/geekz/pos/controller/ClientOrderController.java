package com.geekz.pos.controller;

import org.apache.log4j.Logger;

import com.geekz.orm.hibernate.HibernateOperator;
import com.geekz.pos.model.Client;
import com.geekz.pos.model.ClientOrder;
import com.geekz.pos.model.Teller;

public class ClientOrderController {

	final static Logger logger = Logger.getLogger(ClientOrderController.class);

	public void addNewOrder(String orderDate, String returnDate, String status, Teller teller, Client client) {
		ClientOrder order = new ClientOrder(orderDate, returnDate, status, teller, client);
		logger.info("add New Client Order -" + orderDate + "," + returnDate + "," + status + "," + teller.getIdTeller()
				+ "," + client.getClientId());
		HibernateOperator.getInstance().add(ClientOrder.class, order);
	}

	public ClientOrder readClientOrder(Integer i) {
		logger.info("Read Client Order id-" + i);
		ClientOrder order = (ClientOrder) HibernateOperator.getInstance().read(ClientOrder.class, i);
		return order;
	}

	public void editOrder(Integer i, String orderDate, String returnDate, String status, Teller teller, Client client) {
		ClientOrder order = new ClientOrder(i, orderDate, returnDate, status, teller, client);
		logger.info("Edit Client Order id-" + i + "," + orderDate + "," + returnDate + "," + status + ","
				+ teller.getIdTeller() + "," + client.getClientId());
		HibernateOperator.getInstance().edit(ClientOrder.class, order);

	}

	public void removeOrder() {

	}
}
