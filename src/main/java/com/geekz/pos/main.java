package com.geekz.pos;

import com.geekz.orm.GeekzORM;
import com.geekz.orm.ORMFactory;
import com.geekz.pos.controller.ClientController;
import com.geekz.pos.controller.ClientOrderController;
import com.geekz.pos.controller.ItemOrderController;
import com.geekz.pos.controller.ItemRepoController;
import com.geekz.pos.controller.TellerController;
import com.geekz.pos.model.Client;
import com.geekz.pos.model.ClientOrder;
import com.geekz.pos.model.ItemOrder;
import com.geekz.pos.model.ItemRepo;
import com.geekz.pos.model.Teller;

public class main {

	public static void main(String[] args) {
		GeekzORM orm = ORMFactory.getORM("hibernate");
		
		TellerController teller = new TellerController();
		teller.addNewTeller("Milinda", "0713264601");
		Teller dbTeller = teller.readTeller(1);
		
		ClientController client = new ClientController();
		client.addNewClient("Ama", "13/B 3rd lane", "21212", "2013/12/31");
		Client dbclient = client.readTeller(1);
		
		ClientOrderController order = new ClientOrderController();
		order.addNewOrder("2014/1/11", "", "pending", dbTeller, dbclient);
		ClientOrder orderdb = order.readClientOrder(1);
		
		ItemRepoController item =  new ItemRepoController();
		item.addNewItem("Chili", "kg", "kg", "23.50", "2014/12/12");
		ItemRepo itemDb = item.readRepoItem(1);
				
		ItemOrderController itemOrder = new ItemOrderController();
		itemOrder.addNewItemOrder(10.00, 7.00, orderdb, itemDb);
 		System.out.println();
	}

}
