package kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;

public class Consumers {

    @KafkaListener(topics = "test-topic")
    public void listenGroupFoo(String message) {
        System.out.println("received message test-topic : " + message);
    }
    
}