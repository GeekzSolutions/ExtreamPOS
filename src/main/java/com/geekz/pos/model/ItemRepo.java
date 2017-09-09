package com.geekz.pos.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class ItemRepo {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer itemId;
	
	@Column(length = 15)
	private String inItemUnit;
	
	@Column(length = 15)
	private String outItemUnit;
	
	@Column(length = 15)
	private String price;
	
	@Column(length = 15)
	private String date;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private ItemRepo itemObj;
	

	public ItemRepo() {
	}
	
	public ItemRepo(String inItemUnit, String outItemUnit, String price, String date) {
		this.inItemUnit = inItemUnit;
		this.outItemUnit = outItemUnit;
		this.price = price;
		this.date = date;
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

	/**
	 * @return the itemObj
	 */
	public ItemRepo getItemObj() {
		return itemObj;
	}

	/**
	 * @param itemObj the itemObj to set
	 */
	public void setItemObj(ItemRepo itemObj) {
		this.itemObj = itemObj;
	}
	
	
	
}
