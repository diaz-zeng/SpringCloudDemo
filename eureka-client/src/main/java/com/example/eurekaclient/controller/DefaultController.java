package com.example.eurekaclient.controller;

import com.example.eurekaclient.linener.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;

@RestController
public class DefaultController {

    @Autowired
    private ServerConfig serverConfig;

    @GetMapping("/{msg}")
    public String defaultRequest(@PathVariable(value = "msg") String msg) {
        return String.format("http://%s:%d got message: %s",serverConfig.getHostname(),serverConfig.getPort(),msg);
    }
}
