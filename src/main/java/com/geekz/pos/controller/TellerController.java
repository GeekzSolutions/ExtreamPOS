package com.geekz.pos.controller;

import org.apache.log4j.Logger;

import com.geekz.orm.hibernate.HibernateOperator;
import com.geekz.pos.model.*;

public class TellerController {

	final static Logger logger = Logger.getLogger(TellerController.class);

	public void addNewTeller(String username, String name, String password, String tele) {
		Teller teller = new Teller(username, name, password, tele);
		logger.info("add New Teller -" + username + "," + name + password + "," + tele);
		HibernateOperator.getInstance().add(Teller.class, teller);
	}

	public Teller getTeller(String i) {
		logger.info("add New Teller id -" + i );
		Teller teller = (Teller) HibernateOperator.getInstance().read(Teller.class, i);
		return teller;
	}

	public void editTellerInfo(String username, String name, String password, String tele) {
		Teller teller = new Teller(username, name, password, tele);
		logger.info("add New Teller id -"+ username + "," + name + password + "," + tele);
		HibernateOperator.getInstance().edit(Teller.class, teller);
	}

	public void removeTeller() {

	}
}
