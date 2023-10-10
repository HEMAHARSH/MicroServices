package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.ContactUs;

@RestController
@RequestMapping("/contact")
public class ContactUsController {
	
	

	@Autowired
	private RestTemplate restTemplate;
	 @GetMapping("/getall")
	 public List<ContactUs> getAllFeedback() {
	        String url = "http://hotel-management/user/getfeedback"; 
	        List<ContactUs> feedbackList = restTemplate.getForObject(url, List.class);

	        return feedbackList;
	 }
	

	

      
}
