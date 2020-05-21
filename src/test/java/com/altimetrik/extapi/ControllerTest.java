package com.altimetrik.extapi;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.altimetrik.extapi.controller.ControllerExtapi;
import com.altimetrik.extapi.models.CollegeSelection;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
public class ControllerTest {
	
	private MockMvc mockMvc;

	@InjectMocks
	ControllerExtapi controller;

	ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.build();
	}
	
	@Test
	public void listOrderTest() throws Exception {
		// create object which will be the expected value
		String strResponse = "{\r\n" + 
				"    \"metadata\": {\r\n" + 
				"        \"total\": 7,\r\n" + 
				"        \"page\": 0,\r\n" + 
				"        \"per_page\": 100\r\n" + 
				"    },\r\n" + 
				"    \"results\": [\r\n" + 
				"        {\r\n" + 
				"            \"school.name\": \"University of Michigan-Dearborn\",\r\n" + 
				"            \"2013.student.size\": 6793,\r\n" + 
				"            \"id\": 171137\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"school.name\": \"Marygrove College\",\r\n" + 
				"            \"2013.student.size\": 1041,\r\n" + 
				"            \"id\": 170842\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"school.name\": \"Lawrence Technological University\",\r\n" + 
				"            \"2013.student.size\": 3033,\r\n" + 
				"            \"id\": 170675\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"school.name\": \"Henry Ford College\",\r\n" + 
				"            \"2013.student.size\": 12421,\r\n" + 
				"            \"id\": 170240\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"school.name\": \"Schoolcraft College\",\r\n" + 
				"            \"2013.student.size\": 9535,\r\n" + 
				"            \"id\": 172200\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"school.name\": \"University of Detroit Mercy\",\r\n" + 
				"            \"2013.student.size\": 2871,\r\n" + 
				"            \"id\": 169716\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"school.name\": \"Madonna University\",\r\n" + 
				"            \"2013.student.size\": 3080,\r\n" + 
				"            \"id\": 170806\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}";
		
		CollegeSelection response = objectMapper.readValue(strResponse, CollegeSelection.class);

		// calling method
		mockMvc.perform(post("/colleges"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.results.[0].id", is("171137")));
//		.andExpect(jsonPath("$.data.[0].2013.student.size", is("82333564")))	
//		.andExpect(jsonPath("$.data.[2].creation_date", is("2019-08-08")))
//		.andExpect(jsonPath("$.data.[3].status", is("VALID")))
//		.andExpect(jsonPath("$.data.[0].amount.currency_code", is("MXN")))
//		.andExpect(jsonPath("$.notifications.[0].message", is("OK.")))
//		.andExpect(jsonPath("$.paging.next_cursor_key", is("")));
	}


}
