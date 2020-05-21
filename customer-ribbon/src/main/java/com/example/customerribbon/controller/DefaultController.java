package com.example.customerribbon.controller;

import com.example.customerribbon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customer-ribbon")
public class DefaultController {

    @Autowired
    TestService testService;

    @GetMapping("customer-ribbon/{msg}")
    String defaultRequest(@PathVariable("msg") String msg) {
        return testService.defaultRequest(msg);
    }

}
