package com.altimetrik.extapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.altimetrik.extapi.models.MovieSummary;
import com.altimetrik.extapi.models.PopularMovies;

@RestController
public class ControllerExtapi {

	@Value("${api.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/movie/{movieId}")
	public MovieSummary getMovieInfo(@PathVariable("movieId") String movieId) {
		return restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);
	}
	
	@GetMapping("/movie/popular")
	public PopularMovies getMovieStr(@RequestParam(required = false) String page) {
		return restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + "popular" +
	"?api_key=" + apiKey + "&page="+ page, PopularMovies.class);
	}
}
