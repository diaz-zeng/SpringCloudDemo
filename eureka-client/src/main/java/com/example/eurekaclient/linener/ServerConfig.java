package com.example.eurekaclient.linener;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;

@Component
public class ServerConfig implements ApplicationListener<WebServerInitializedEvent> {

    private int port;
    private String hostname;

    private static ServerConfig instance;

    public static ServerConfig getInstance() {
        synchronized (instance) {
            if (instance == null) {
                return instance = new ServerConfig();
            } else {
                return instance;
            }
        }
    }

    private ServerConfig() {
    }

    public int getPort() {
        return port;
    }

    public String getHostname() {
        return hostname;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        this.port = webServerInitializedEvent.getWebServer().getPort();
        try {
            this.hostname = Inet4Address.getLocalHost().getHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
