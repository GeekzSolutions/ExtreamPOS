package com.geekz.pos.controller;

import com.geekz.orm.hibernate.HibernateOperator;
import com.geekz.pos.model.Client;
import com.geekz.pos.model.Teller;

public class ClientController {

	public void addNewClient(String name, String address, String tele, String regDate) {
		Client client = new Client(name, address, tele, regDate);
		HibernateOperator.getInstance().add(Client.class, client);
	}

	public void editClientInfo(Integer i, String name, String address, String tele, String regDate) {
		Client client = new Client(i, name, address, tele, regDate);
		HibernateOperator.getInstance().edit(Client.class, client);
	}
	
	public Client readTeller(Integer i) {
		Client client = (Client) HibernateOperator.getInstance().read(Client.class, i);
		return client;
	}
	
	public void editClientInfo() {

	}

	public void removeClient() {

	}
}
