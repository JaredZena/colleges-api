package com.altimetrik.extapi.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PopularMovies {
	@NonNull
	private String page;
	
	@NonNull
	@JsonProperty("total_results")
	private String totalResults;
	
	@NonNull
	@JsonProperty("total_pages")
	private String totalPages;
	
	@NonNull
	@JsonProperty("results")
	private List<Movie> popularMoviesList;

}
