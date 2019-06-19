package com.rodrigor.meat.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MenuItem extends BaseObject {
	private static final long serialVersionUID = 1L;

	private String imagePath, name, description;
	private BigDecimal price;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "restaurantId")
	private Restaurant restaurant;

	@JsonIgnore
	@OneToMany(mappedBy = "id.menuItem")
	private Set<OrderItem> items = new HashSet<>();

	public MenuItem() {

	}

	public MenuItem(String imagePath, String name, String description, BigDecimal price, Restaurant restaurant) {
		this.imagePath = imagePath;
		this.name = name;
		this.description = description;
		this.price = price;
		this.restaurant = restaurant;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "MenuItem [imagePath=" + imagePath + ", name=" + name + ", description=" + description + ", price="
				+ price + "]";
	}
}
