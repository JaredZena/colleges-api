package com.altimetrik.service;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ServiceColleges {
	
	
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
	
}
