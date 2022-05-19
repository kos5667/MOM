package com.demo.main.sample.service.impl;

import org.springframework.stereotype.Service;

import com.demo.main.sample.service.SampleService;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	@Override
	public void sampleService() throws Exception {
		System.out.println("In Sample Service...");
	}

}
