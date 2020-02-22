package com.altimetrik.extapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class ProductionCompany {
	
	@NonNull
	private String id;
	
	@JsonProperty("logo_path")
	private String logoPath;
	
	@NonNull
	private String name;
	
	@NonNull
	@JsonProperty("origin_country")
	private String originCountry;
}
