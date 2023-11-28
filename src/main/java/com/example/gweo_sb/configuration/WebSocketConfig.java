package com.example.gweo_sb.configuration;

import com.example.gweo_sb.controller.WebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
//WebSocketConfigurer是一个接口，该接口定义了WebSocket配置的方法
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//引入Spring框架的WebSocketHandlerRegistry类，用于注册WebSocket处理程序的方法。
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration//标明这是spring的配置类
@EnableWebSocket//注解启用了WebSocket的支持
//实现了WebSocketConfigurer接口，该接口定义了WebSocket配置的方法。
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    //定义一个不需要返回值的方法，名为注册处理器，括号里是传入的参数，意味着该方法用来进行WebSocketHandlerRegistry registry
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //注册了一个WebSocketHandler实例，并指定了WebSocket的端点为/ws
        registry.addHandler(new WebSocketHandler(), "/ws")
                .setAllowedOrigins("*"); // 允许所有来源访问，注意生产环境需要设置为特定域名
    }
}
