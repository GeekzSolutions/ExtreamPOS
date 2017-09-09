package com.geekz.pos.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer clientId;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 255)
	private String address;
	
	@Column(length = 15)
	private String tele;
	
	@Column(length = 15)
	private String regDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private List<ClientOrder> orderList;
	
	public Client() {
	}
	
	public Client(String name, String address, String tele, String regDate) {
		this.name = name;
		this.address = address;
		this.tele = tele;
		this.regDate = regDate;
	}

	public Client(Integer i, String name, String address, String tele, String regDate) {
		this.clientId = i;
		this.name = name;
		this.address = address;
		this.tele = tele;
		this.regDate = regDate;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public List<ClientOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ClientOrder> orderList) {
		this.orderList = orderList;
	}

}
