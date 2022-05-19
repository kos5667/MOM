package com.demo.main.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.main.sample.service.SampleService;

@RestController
public class SampleController {
	
	@Autowired
	private SampleService sampleService;

	@RequestMapping("/sample")
	public void SampleMethod() throws Exception {
		System.out.println("Run...");
		sampleService.sampleService();
	}
}
