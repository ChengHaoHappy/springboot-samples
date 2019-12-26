package com.bupt.websocket_server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
 * @author ：HappyCheng
 * @date ：2019/9/30
 */
@Configuration
public class WebSocketConfig {

    /**
     * springboot内置tomcat的话，需要配一下这个。。如果没有这个对象，无法连接到websock
     * @return
     */
    @Bean  //注入ServerEndpointExporter，这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint。
    public ServerEndpointExporter serverEndpointExporter(){
        //这个对象说一下，貌似只有服务器是tomcat的时候才需要配置,具体我没有研究
        return new ServerEndpointExporter();
    }
}
