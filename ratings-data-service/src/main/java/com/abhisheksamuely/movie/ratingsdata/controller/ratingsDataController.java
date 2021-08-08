package com.abhisheksamuely.movie.ratingsdata.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksamuely.movie.ratingsdata.beans.Rating;
import com.abhisheksamuely.movie.ratingsdata.beans.UserRating;

@RestController
@RequestMapping("/ratings")
public class ratingsDataController {

	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating("1", 9.0);
	}

	@GetMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> rating = Arrays.asList(new Rating("1", 9.0));
		UserRating userRating = new UserRating(rating);
		return userRating;
	}
}
