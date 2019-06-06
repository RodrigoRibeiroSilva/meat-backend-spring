package com.rodrigor.meat.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review extends BaseObject{
	private static final long serialVersionUID = 1L;
	
	private String name, date, comments;
	private Double rating;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="restaurantId")
	private Restaurant restaurant;
	
	public Review() {
		
	}

	public Review(String name, String date, String comments, Double rating, Restaurant restaurant) {
		this.name = name;
		this.date = date;
		this.comments = comments;
		this.rating = rating;
		this.restaurant = restaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [name=" + name + ", date=" + date + ", comments=" + comments + ", rating=" + rating + "]";
	}
}
