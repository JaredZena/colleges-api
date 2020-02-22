package com.altimetrik.extapi.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MovieSummary {
	@NonNull
	private String title;
	
	@NonNull
	private String overview;
	
	@NonNull
	@JsonProperty("production_companies")
	private List<ProductionCompany> productionCompaniesList;

}
