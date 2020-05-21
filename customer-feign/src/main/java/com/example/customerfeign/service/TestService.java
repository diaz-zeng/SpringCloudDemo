package com.example.customerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "eureka-client")
public interface TestService {
    @GetMapping("/{msg}")
    String defaultRequest(@PathVariable("msg") String msg);
}
