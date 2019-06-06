package com.rodrigor.meat.domain;

import javax.persistence.Entity;

@Entity
public class Review extends BaseObject{
	private static final long serialVersionUID = 1L;
	
	private String name, date, comments;
	private Double rating;
	
	public Review() {
		
	}

	public Review(String name, String date, String comments, Double rating) {
		this.name = name;
		this.date = date;
		this.comments = comments;
		this.rating = rating;
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
