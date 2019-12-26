package org.sang.wschat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker  //开启 WebSocket 代理
public class WebSocketConfig
        implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/queue");//设置消息代理的前缀,topic群聊，queue单聊
        config.setApplicationDestinationPrefixes("/app"); //配置一个或多个前缀，通过这些前缀过滤出需要被注解方法处理的消息。
        //例如前缀为/app 的 destination 可以通过@MessageMapping注解的方法处理
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").withSockJS();
    }
}