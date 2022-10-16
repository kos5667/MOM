package kafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kafka.producer.Producers;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final Producers producers;

    @GetMapping("/message")
    public String test(@RequestParam("message") String message) {
        producers.sendMessage("test-topic", message);
        return "success";
    }
}
