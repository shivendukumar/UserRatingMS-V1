package com.shivendu.userratings.service;

import java.util.List;

import com.shivendu.userratings.entity.BookRating;
import com.shivendu.userratings.entity.UserRating;

public interface RatingService {

	public void addUserRating(UserRating userRating);
	public List<UserRating> getUserRatingByUserId(String userId);
	public void updateBookRating(BookRating bookRating);
	public BookRating getBookRatingByBookId(Integer bookId);
	
}
