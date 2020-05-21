package com.altimetrik.extapi.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class College {
	
	private String schoolName;
	
    @JsonProperty("school.name")
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @JsonProperty("schoolName")
    public String getSchoolName() {
        return schoolName;
    }
    
	@JsonAlias({"2013.student.size","2017.student.size","2015.student.size","2016.student.size"})
	private String studentSize;
}
