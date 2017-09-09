package com.geekz.pos.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemRepo {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer itemId;

	@Column(length = 50)
	private String itemName;

	@Column(length = 15)
	private String inItemUnit;

	@Column(length = 15)
	private String outItemUnit;

	@Column(length = 15)
	private String price;

	@Column(length = 15)
	private String date;

	@OneToOne(mappedBy = "itemRepo", cascade = CascadeType.ALL)
	private ItemOrder itemRepoObj;

	public ItemRepo() {
	}

	public ItemRepo(String itemName, String inItemUnit, String outItemUnit, String price, String date) {
		this.itemName = itemName;
		this.inItemUnit = inItemUnit;
		this.outItemUnit = outItemUnit;
		this.price = price;
		this.date = date;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ItemOrder getItemRepoObj() {
		return itemRepoObj;
	}

	public void setItemRepoObj(ItemOrder itemRepoObj) {
		this.itemRepoObj = itemRepoObj;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getInItemUnit() {
		return inItemUnit;
	}

	public void setInItemUnit(String inItemUnit) {
		this.inItemUnit = inItemUnit;
	}

	public String getOutItemUnit() {
		return outItemUnit;
	}

	public void setOutItemUnit(String outItemUnit) {
		this.outItemUnit = outItemUnit;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
