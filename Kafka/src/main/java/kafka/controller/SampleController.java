package kafka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SampleController
 */
@RestController
@RequestMapping(value = "/sample")
public class SampleController {

    @Value("${docker-kafka.ip}")
    private String ip;


    @GetMapping(value = "/request")
    public void index() {
        System.out.println("Sample in.. request ip : " + ip);
    }
}