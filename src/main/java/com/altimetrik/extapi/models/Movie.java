package com.altimetrik.extapi.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {
	@NonNull
	@JsonProperty("id")
	private String movieId;
	
	@NonNull
	private String title;
	
	@NonNull
	private String overview;
	
	private List<ProductionCompany> productionCompaniesList;
	
	@NonNull
	@JsonProperty("vote_average")
	private String voteAverage;

}
