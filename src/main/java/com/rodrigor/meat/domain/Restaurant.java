package com.rodrigor.meat.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Restaurant extends BaseObject {
	private static final long serialVersionUID = 1L;
	
	private String name, category, deliveryEstimate, imagePath, about, hours;
	private Double rating;
	
	@OneToMany(mappedBy="restaurant", cascade=CascadeType.ALL)
	private List<Review> reviews = new LinkedList<Review>();
	
	@OneToMany(mappedBy="restaurant", cascade=CascadeType.ALL)
	private Collection<MenuItem> menu = new HashSet<MenuItem>();
	
	public Restaurant() {
		
	}

	public Restaurant(String name, String category, String deliveryEstimate, String imagePath, String about,String hours, Double rating) {
		this.name = name;
		this.category = category;
		this.deliveryEstimate = deliveryEstimate;
		this.imagePath = imagePath;
		this.about = about;
		this.hours = hours;
		this.rating = rating;
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

	public String getDeliveryEstimate() {
		return deliveryEstimate;
	}

	public void setDeliveryEstimate(String deliveryEstimate) {
		this.deliveryEstimate = deliveryEstimate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public List<Review> getReviews() {
		return Collections.unmodifiableList(reviews);
	}

	public Collection<MenuItem> getMenuList() {
		return Collections.unmodifiableCollection(menu);
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}
	
	public void addMenuItem(MenuItem menuItem) {
		menu.add(menuItem);
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", category=" + category + ", deliveryEstimate=" + deliveryEstimate
				+ ", imagePath=" + imagePath + ", about=" + about + ", hours=" + hours + ", rating=" + rating + "]";
	}
}
