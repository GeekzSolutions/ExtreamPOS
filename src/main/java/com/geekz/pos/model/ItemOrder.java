package com.geekz.pos.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ItemOrder {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer itemOrderId;

	@Column(length = 20)
	private Double inAmount;
	
	@Column(length = 20)
	private Double outAmount;
	
	@ManyToOne
	@JoinColumn(name = "clientOrderId", nullable = false)
	private ClientOrder clientOrder;
		
	@OneToOne
	@JoinColumn(name = "itemFKId")
	private ItemRepo itemRepo;

	public ItemOrder() {
	}
	
	public ItemOrder(Double inAmount, Double outAmount, ClientOrder clientOrder,
			ItemRepo itemRepo) {
		this.inAmount = inAmount;
		this.outAmount = outAmount;
		this.clientOrder = clientOrder;
		this.itemRepo = itemRepo;
	}

	public ItemOrder(Integer i, Double inAmount, Double outAmount, ClientOrder clientOrder, ItemRepo itemRepo) {
		this.inAmount = inAmount;
		this.outAmount = outAmount;
		this.clientOrder = clientOrder;
		this.itemRepo = itemRepo;
	}

	public Integer getItemOrderId() {
		return itemOrderId;
	}

	public void setItemOrderId(Integer itemOrderId) {
		this.itemOrderId = itemOrderId;
	}

	public Double getInAmount() {
		return inAmount;
	}

	public void setInAmount(Double inAmount) {
		this.inAmount = inAmount;
	}

	public Double getOutAmount() {
		return outAmount;
	}

	public void setOutAmount(Double outAmount) {
		this.outAmount = outAmount;
	}

	public ClientOrder getClientOrder() {
		return clientOrder;
	}

	public void setClientOrder(ClientOrder clientOrder) {
		this.clientOrder = clientOrder;
	}

	public ItemRepo getItemRepo() {
		return itemRepo;
	}

	public void setItemRepo(ItemRepo itemRepo) {
		this.itemRepo = itemRepo;
	}
	
	
	
}
