package com.geekz.pos.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ClientOrder {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer orderId;

	@Column(length = 15)
	private String orderDate;

	@Column(length = 15)
	private String returnDate;

	@Column(length = 10)
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tellerId", nullable = false)
	private Teller teller;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientID", nullable = false)
	private Client client;

	@OneToMany(mappedBy = "clientOrder")
	private List<ItemOrder> itemList;

	public ClientOrder() {
	}

	public ClientOrder(String orderDate, String returnDate, String status, Teller teller, Client client) {
		this.orderDate = orderDate;
		this.returnDate = returnDate;
		this.status = status;
		this.teller = teller;
		this.client = client;
	}

	public ClientOrder(Integer i, String orderDate, String returnDate, String status, Teller teller, Client client) {
		this.orderId = i;
		this.orderDate = orderDate;
		this.returnDate = returnDate;
		this.status = status;
		this.teller = teller;
		this.client = client;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Teller getTeller() {
		return teller;
	}

	public void setTeller(Teller teller) {
		this.teller = teller;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ItemOrder> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemOrder> itemList) {
		this.itemList = itemList;
	}

}
