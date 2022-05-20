package com.demo.main.kafka.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.demo.main.kafka.vo.Greeting;

public class MessageProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, Greeting> greetingKafkaTemplate;
	
	@Value(value = "${demo.kafka.topic.topic-1}")
	private String topic1;
	
	@Value(value = "${demo.kafka.topic.topic-2}")
	private String topic2;
	
	@Value(value = "${demo.kafka.topic.topic-3}")
	private String topic3;
	
	@Value(value = "${demo.kafka.topic.topic-4}")
	private String topic4;
	
	public void sendMessageToTopic1(String message) {
		
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("batch1", message);
		
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			
			@Override
			public void onSuccess(SendResult<String, String> result) {
				System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			}
			
			@Override
			public void onFailure(Throwable ex) {
				System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
			}

		});
	}
	
	public void sendMessageToTopic2(String message, int partition) {
		kafkaTemplate.send(topic2, partition, null, message);
	}
	
	public void sendMessageToTopic3(String message) {
		kafkaTemplate.send(topic3, message);
	}
	
	public void sendMessageToTopic4(Greeting greeting) {
		greetingKafkaTemplate.send(topic3, greeting);
	}
}
