package com.springboot.javawebsocket;

/**
 * @author ：HappyCheng
 * @date ：2019/9/30
 */

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/websocket/{from}")
@Component
public class WebSocketTest {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，
    // 可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArrayList<WebSocketTest> webSocketSet = new CopyOnWriteArrayList<WebSocketTest>();

    //通过sessionId绑定WebSocketTest
    private static ConcurrentHashMap<String, WebSocketTest> webSocketMap = new ConcurrentHashMap<>();

    //通过userno绑定
    private static ConcurrentHashMap<String, WebSocketTest> webSocketMap2 = new ConcurrentHashMap<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //当前发消息的人员编号
    private String from = "";

    /**
     * 连接建立成功时调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "from") String from) {
        System.out.println("from = " + from);
        this.session = session;
        this.from = from;
        System.out.println(session.getId());
        webSocketSet.add(this); //加入set中
        webSocketMap.put(session.getId(), this);//加入map
        webSocketMap2.put(from, this);
        addOnlineCount();  //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        webSocketSet.remove(this);//
        webSocketMap.remove(session.getId());
        webSocketMap2.remove(from);
        subOnlineCount();  //在线人数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息: " + message);
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(message);
        String content = jsonObject.get("message").getAsString();
        String to = jsonObject.get("to").getAsString();
        System.out.println(jsonObject.get("to").getAsString());
        if(to.equals("")){
            //群发消息
            for (WebSocketTest item : webSocketSet) {
                try {
                    item.sendMessage(content);
                } catch (IOException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }else if(webSocketMap2.get(to)!=null){
            try {
                webSocketMap2.get(to).sendMessage(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("用户不在线");
        }


        //发回当前客户端
//        try {
//            webSocketMap.get(session.getId()).sendMessage(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    /**
     * 发生错误时调用的地方
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    public static synchronized void addOnlineCount() {
        WebSocketTest.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketTest.onlineCount--;
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
//        System.out.println("this.session.getBasicRemote() = " + this.session.getBasicRemote());
//        this.session.getAsyncRemote().sendText(message);
    }

}
