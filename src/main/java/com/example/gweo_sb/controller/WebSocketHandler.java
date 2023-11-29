package com.example.gweo_sb.controller;

import org.springframework.web.socket.TextMessage;
//引入Spring框架中的WebSocketSession类，表示WebSocket的会话（连接）。
import org.springframework.web.socket.WebSocketSession;
//引入Spring框架中的TextWebSocketHandler类，这是一个处理文本消息的WebSocket处理程序。
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    //protected：可以被包内其他类或者该类的子类访问

    //throws Exception 表示这个方法可能会抛出异常，并且在这里声明了一种比较通用的异常类型，即 Exception。
    // 这种声明告诉调用者这个方法可能会出现异常，并且调用者需要考虑如何处理这些异常
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 处理收到的消息
        String payload = message.getPayload();
        //控制台打印
        System.out.println("Received message from client: " + payload);

        // 发送消息给客户端（发送了一个字符串）
        session.sendMessage(new TextMessage(message.getPayload()));
        // 可以根据需要重写其他方法来处理连接的打开、关闭等事件。
    }
}

