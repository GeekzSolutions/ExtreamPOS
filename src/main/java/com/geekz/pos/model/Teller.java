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
public class Teller {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer idTeller;

	@Column(length = 100)
	private String name;

	@Column(length = 15)
	private String teleNo;

	@OneToMany(mappedBy = "teller")
	private List<ClientOrder> orderList;

	public Teller() {
	}

	public Teller(String name, String tele) {
		this.name = name;
		this.teleNo = tele;
	}

	public Teller(Integer i, String name, String tele) {
		this.idTeller = i;
		this.name = name;
		this.teleNo = tele;
	}

	public Integer getIdTeller() {
		return idTeller;
	}

	public void setIdTeller(Integer idTeller) {
		this.idTeller = idTeller;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
