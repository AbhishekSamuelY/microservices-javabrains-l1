package com.abhisheksamuely.movie.moviecatalog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.abhisheksamuely.movie.moviecatalog.beans.MovieCatalog;
import com.abhisheksamuely.movie.moviecatalog.beans.MovieInfo;
import com.abhisheksamuely.movie.moviecatalog.beans.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private WebClient.Builder builder;
	
	@Autowired
	private DiscoveryClient client;

	@GetMapping("/{userId}")
	public List<MovieCatalog> getCatalog(@PathVariable("userId") String userId){
		
		/*
		 * TODO:movie info microservice
		 * 1. get list of rated movies
		 * 2. for each movie id, call movie info service and get details
		 * 3. put them all together
		 * */
		
		client.getInstances(userId);
		
		//using webClient.Builder
		UserRating ratings = builder.build().get().uri("http://ratings-data-service/ratings/users/"+userId).retrieve().bodyToMono(UserRating.class).block();

		return ratings.getRating().stream().map(rating -> {
			
			MovieInfo movie = template.getForObject("http://movie-info-service/movies/"+rating.getMovieId() , MovieInfo.class);
			return new MovieCatalog(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
		
	}
}
