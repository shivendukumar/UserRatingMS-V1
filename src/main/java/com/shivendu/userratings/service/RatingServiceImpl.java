package com.shivendu.userratings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shivendu.userratings.dao.BookRatingDAO;
import com.shivendu.userratings.dao.UserRatingDAO;
import com.shivendu.userratings.entity.BookRating;
import com.shivendu.userratings.entity.UserRating;


@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	UserRatingDAO userRatingDAO;

	@Autowired
	BookRatingDAO bookRatingDAO;

	@Override
	public void addUserRating(UserRating userRating) {
		// 1. add the user rating
		userRatingDAO.save(userRating);

		// 2. Calculate the average rating for BookId
		int bookId = userRating.getBookId();
		List<UserRating> ratingList = userRatingDAO.getUserRatingByBookId(bookId);

		double sumRating = 0.0;
		for (UserRating ur : ratingList) {
			sumRating = sumRating + ur.getRating();
		}

		double avgRating = sumRating / ratingList.size();

		// 3.Update BookRating in UserRatingMS (Local)

		BookRating bookRating = bookRatingDAO.findById(bookId).get();
		bookRating.setAvgRating(avgRating);
		bookRatingDAO.save(bookRating);

		// 4.Update BookRating in BookSearchMS
		// Invoking BookRating-MS
		RestTemplate bookSearchRest = new RestTemplate();
		String endpoint = "http://localhost:8000/updateBookRating";
		bookSearchRest.put(endpoint, bookRating);

	}

	@Override
	public List<UserRating> getUserRatingByUserId(String userId) {
		return userRatingDAO.getUserRatingByUserId(userId);
	}

	@Override
	public void updateBookRating(BookRating bookRating) {
		bookRatingDAO.save(bookRating);
	}

	@Override
	public BookRating getBookRatingByBookId(Integer bookId) {
		BookRating bookRating = bookRatingDAO.findById(bookId).get();
		return bookRating;
	}
}
