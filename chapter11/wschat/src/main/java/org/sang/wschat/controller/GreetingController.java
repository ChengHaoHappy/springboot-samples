package org.sang.wschat.controller;

import org.sang.wschat.model.Chat;
import org.sang.wschat.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class GreetingController {
    @Autowired
    SimpMessagingTemplate messagingTemplate;

//    @MessageMapping("/hello")  //处理浏览器的消息
//    @SendTo("/topic/greetings") //处理后的消息发送到这里，由服务器代理广播
//    public Message greeting(Message message) throws Exception { //处理浏览器消息函数
//        return message;
//    }

    //等价于上面
    @MessageMapping("/hello")
    public void greeting(Message message) throws Exception {
        messagingTemplate.convertAndSend("/topic/greetings",message);
    }

    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat) {
        String from = principal.getName();
        chat.setFrom(from);
        messagingTemplate.convertAndSendToUser(chat.getTo(),
                "/queue/chat", chat);
    }
}