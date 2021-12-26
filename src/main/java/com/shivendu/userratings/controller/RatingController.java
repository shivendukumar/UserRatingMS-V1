package com.shivendu.userratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivendu.userratings.entity.BookRating;
import com.shivendu.userratings.entity.UserRating;
import com.shivendu.userratings.service.RatingService;

@CrossOrigin
@RestController
public class RatingController {

	static {
		System.out.println("We are inside RatingController class");
	}
	
	@Autowired
	RatingService ratingService;

	@PutMapping("/addUserRating")
	public void addUserRating(@RequestBody UserRating userRating) {
		ratingService.addUserRating(userRating);
	}

	@GetMapping("/userRatings/{userId}")
	public List<UserRating> getUserRatingByUserId(@PathVariable String userId) {
		return ratingService.getUserRatingByUserId(userId);
	}

	@GetMapping("/bookRatings/{bookId}")
	public BookRating getBookRatingByBookId(@PathVariable String bookId) {
		return ratingService.getBookRatingByBookId(new Integer(bookId));
	}
}
