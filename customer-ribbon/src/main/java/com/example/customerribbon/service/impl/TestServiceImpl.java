package com.example.customerribbon.service.impl;

import com.example.customerribbon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String defaultRequest(String msg) {
        return restTemplate.getForObject(String.format("http://eureka-client/%s", msg), String.class);
    }
}
