package com.shivendu.userratings.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivendu.userratings.entity.BookRating;

public interface BookRatingDAO extends JpaRepository<BookRating, Integer>{

}
