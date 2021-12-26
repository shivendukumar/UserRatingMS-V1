package com.shivendu.userratings.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivendu.userratings.entity.UserRating;

public interface UserRatingDAO extends JpaRepository<UserRating, Integer>{

	public List<UserRating> getUserRatingByBookId(Integer bookId);
	public List<UserRating> getUserRatingByUserId(String userId);
	
}
