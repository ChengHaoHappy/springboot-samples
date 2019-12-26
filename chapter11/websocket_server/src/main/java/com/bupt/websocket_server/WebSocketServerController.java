package com.bupt.websocket_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author ：HappyCheng
 * @date ：2019/10/7
 */
@RestController
public class WebSocketServerController {

    @Autowired
    MyWebsocketServer myWebsocketServer;

    @RequestMapping("/publish")
    public String publish(){
        try {
            myWebsocketServer.sendAllMessage("hello client");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "发布成功！";
    }
}
