package com.example.customerfeign.controller;

import com.example.customerfeign.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/eureka-client")
public class DefaultController {

    @Autowired
    private TestService testService;

    @GetMapping("eureka-client/{msg}")
    String defaultRequest(@PathVariable("msg") String msg) {
        return testService.defaultRequest(msg);
    }
}
