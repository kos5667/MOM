package com.demo.main.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

//@Service
public class KafkaSampleProducerService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		System.out.println("send message : " + message);
		this.kafkaTemplate.send("oingdaddy", message);
	}
}
