package com.demo.main.kafka.consumer;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class KafkaSampleConsumerService {

	@KafkaListener(topics = "oingdaddy", groupId = "group-id-oing")
	public void consume(String message) throws IOException {
		System.out.println("receive message : " + message);
	}
}
