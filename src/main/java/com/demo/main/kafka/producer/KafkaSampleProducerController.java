package com.demo.main.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class KafkaSampleProducerController {

	@Autowired
	private KafkaSampleProducerService kafkaSampleProducerService;
	
	@GetMapping(value = "/sendMessage")
	public void sendMessage(String message) {
		kafkaSampleProducerService.sendMessage(message);
	}
}
