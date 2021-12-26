package com.shivendu.userratings.entity;

import javax.persistence.*;

@Entity
@Table(name = "myuserratings", schema = "ratingsdb")
public class UserRating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rating_id")
	private Integer ratingId;
	
	@Column(name = "book_id")
	private Integer bookId;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "rating")
	private double rating;
	
	@Column(name = "review")
	private String review;

	public UserRating() {}
	
	public UserRating(Integer bookId, String userId, double rating, String review) {
		this.bookId = bookId;
		this.userId = userId;
		this.rating = rating;
		this.review = review;
	}
	
	public UserRating(Integer ratingId, Integer bookId, String userId, double rating, String review) {
		super();
		this.ratingId = ratingId;
		this.bookId = bookId;
		this.userId = userId;
		this.rating = rating;
		this.review = review;
	}

	public Integer getRatingId() {
		return ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return ratingId + " " + bookId + " " + userId + " " + rating + " " + review;
	}
}
