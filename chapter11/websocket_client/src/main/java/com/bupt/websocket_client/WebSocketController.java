package com.bupt.websocket_client;

import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：HappyCheng
 * @date ：2019/10/6
 */
@RestController
public class WebSocketController {

    @Autowired
    private WebSocketClient webSocketClient;

    @RequestMapping("subscribe")
    public String subscribe() {
        // webSocketClient.connect();
        webSocketClient.send("hello sever，i want subscribe data A");
        return "发送订阅成功！！！";
    }
}

