package com.altimetrik.extapi.controller;

import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.altimetrik.extapi.models.College;
import com.altimetrik.extapi.models.CollegeSelection;

@RestController
public class ControllerExtapi {

	@Value("${api.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/colleges")
	public CollegeSelection getColleges(@RequestParam(required = false) String zip,
			@RequestParam(required = false) String year,
			@RequestParam(required = false) String distance,
			@RequestParam(required = false) String awards,
			@RequestParam(required = false, value= "per_page") String perPage,
			@RequestParam(required = false) String page) {
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("api_key", apiKey);
		params.add("zip", zip);
		params.add("distance", distance);	
		params.add("school.degrees_awarded.predominant", awards);
		params.add("fields", "school.name," + year+ ".student.size");
		params.add("per_page", perPage);
		params.add("page", page);
		params.add("sort", year+".student.size");
	UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl("https://api.data.gov/ed/collegescorecard/v1/schools.json").queryParams(params).build();
		System.out.println(uriComponents);
	return restTemplate.getForObject(uriComponents.toString()
	, CollegeSelection.class);
	
//	List<College> listOfColleges = selection.getCollegesList();
//	
//	
//	
//	return selection;
	}
	
//	@GetMapping("/movie/popular")
//	public PopularMovies getMovieStr(@RequestParam(required = false) String page) {
//		return restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + "popular" +
//	"?api_key=" + apiKey + "&page="+ page, PopularMovies.class);
//	}
}
