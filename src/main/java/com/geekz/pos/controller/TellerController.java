package com.geekz.pos.controller;

import org.apache.log4j.Logger;

import com.geekz.orm.hibernate.HibernateOperator;
import com.geekz.pos.model.*;

public class TellerController {

	final static Logger logger = Logger.getLogger(TellerController.class);

	public void addNewTeller(String name, String tele) {
		Teller teller = new Teller(name, tele);
		logger.info("add New Teller -" + name + "," + tele);
		HibernateOperator.getInstance().add(Teller.class, teller);
	}

	public Teller readTeller(Integer i) {
		logger.info("add New Teller id -" + i );
		Teller teller = (Teller) HibernateOperator.getInstance().read(Teller.class, i);
		return teller;
	}

	public void editTellerInfo(Integer i, String name, String tele) {
		Teller teller = new Teller(i, name, tele);
		logger.info("add New Teller id -" + i + "," + name + "," + tele);
		HibernateOperator.getInstance().edit(Teller.class, teller);
	}

	public void removeTeller() {

	}
}
