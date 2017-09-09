package com.geekz.pos.controller;

import com.geekz.orm.hibernate.HibernateOperator;
import com.geekz.pos.model.*;

public class TellerController {

	// add a new teller to the system
	public void addNewTeller(String name, String tele) {
		Teller teller = new Teller(name, tele);
		HibernateOperator.getInstance().add(Teller.class, teller);
	}

	public Teller readTeller(Integer i) {
		Teller teller = (Teller) HibernateOperator.getInstance().read(Teller.class, i);
		return teller;
	}
	
	public void editTellerInfo(Integer i, String name, String tele) {
		Teller teller = new Teller(i, name, tele);
		HibernateOperator.getInstance().edit(Teller.class, teller);
	}

	public void removeTeller() {

	}
}
