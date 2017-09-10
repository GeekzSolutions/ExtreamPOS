package com.geekz.pos.operation;

import com.geekz.pos.controller.TellerController;
import com.geekz.pos.model.Teller;

public class TellerOperation {

	public void addNewTeller() {

	}

	public void editTeller() {

	}

	public boolean login(String username, String password) {

		TellerController teller = new TellerController();
		Teller modelTeller = teller.getTeller(username);
		if (modelTeller != null && modelTeller.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

}
