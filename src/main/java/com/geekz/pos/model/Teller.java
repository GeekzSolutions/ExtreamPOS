package com.geekz.pos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teller {

	@Id
	@Column(length = 25)
	private String userName;

	@Column(length = 100)
	private String name;

	@Column(length = 25)
	private String password;
	
	@Column(length = 15)
	private String teleNo;

	@OneToMany(mappedBy = "teller")
	private List<ClientOrder> orderList;

	public Teller() {
	}
	
	public Teller(String username, String name, String password, String tele) {
		this.userName = username;
		this.name = name;
		this.password =password;
		this.teleNo = tele;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTeleNo() {
		return teleNo;
	}

	public void setTeleNo(String teleNo) {
		this.teleNo = teleNo;
	}

	public List<ClientOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ClientOrder> orderList) {
		this.orderList = orderList;
	}

}
