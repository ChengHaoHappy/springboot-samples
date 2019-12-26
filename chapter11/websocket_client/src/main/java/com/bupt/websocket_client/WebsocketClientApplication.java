package com.bupt.websocket_client;

import org.java_websocket.client.WebSocketClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class WebsocketClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketClientApplication.class, args);
    }

    @Bean
    public WebSocketClient webSocketClient() {
        try {
            MyWebSocketClient webSocketClient = new MyWebSocketClient(new URI("wss://smart.gantch.cn/api/v1/deviceaccess/websocket"));
            webSocketClient.connect();
            return webSocketClient;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }


}
