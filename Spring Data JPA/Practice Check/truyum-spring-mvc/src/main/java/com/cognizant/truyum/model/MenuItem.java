package com.cognizant.truyum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_item")
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "me_id")
	private long id;

	@Column(name = "me_name")
	private String name;

	@Column(name = "me_price")
	private float price;

	@Column(name = "me_category")
	private String category;

	@Column(name = "me_active")
	private boolean active;

	@Column(name = "me_free_delivery")
	private boolean freeDelivery;

	@Column(name = "me_date_of_launch")
	private Date dateOfLaunch;

	public MenuItem() {
		// TODO Auto-generated constructor stub
	}

	public MenuItem(long id, String name, String category, float price, boolean active, boolean freeDelivery,
			Date dateOfLaunch) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.active = active;
		this.freeDelivery = freeDelivery;
		this.dateOfLaunch = dateOfLaunch;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public boolean equals(MenuItem obj) {
		if (obj instanceof MenuItem) {
			MenuItem p3 = (MenuItem) obj;

			return (this.id == p3.id);
		}
		return false;
	}

}
