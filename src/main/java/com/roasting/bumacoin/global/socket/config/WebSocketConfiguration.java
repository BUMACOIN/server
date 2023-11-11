package com.roasting.bumacoin.global.socket.config;

import com.roasting.bumacoin.global.socket.handler.WebSocketCustomHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(signalingSocketHandler(), "/trade")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Bean
    public WebSocketHandler signalingSocketHandler() {
        return new WebSocketCustomHandler();
    }
}
