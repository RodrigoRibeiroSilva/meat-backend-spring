package com.rodrigor.meat.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Menu extends BaseObject {
	private static final long serialVersionUID = 1L;
	
	private String imagePath, name, description;
	private BigDecimal price;
	
	public Menu() {
		
	}

	public Menu(String imagePath, String name, String description, BigDecimal price) {
		this.imagePath = imagePath;
		this.name = name;
		this.description = description;
		this.price = price;
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

	@Override
	public String toString() {
		return "Menu [imagePath=" + imagePath + ", name=" + name + ", description=" + description + ", price=" + price
				+ "]";
	}
}
