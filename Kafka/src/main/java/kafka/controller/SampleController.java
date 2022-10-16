package kafka.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SampleController
 */
@RestController
@RequestMapping(value = "/sample")
public class SampleController {

    @GetMapping(value = "/request")
    public void index() {
        System.out.println("Sample in.. request");
    }
}