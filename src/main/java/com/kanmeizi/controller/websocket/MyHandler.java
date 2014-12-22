package com.kanmeizi.controller.websocket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * WebSocket 处理类
 * Created by liuzhengyang on 2014/12/19.
 */
public class MyHandler extends TextWebSocketHandler {

    private static final Log log = LogFactory.getLog(MyHandler.class);
    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    private static final Set<WebSocketSession> connections = new CopyOnWriteArraySet<WebSocketSession>();

    public MyHandler(){

    }

    // 连接后
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info(session.getId() + " : " + session.getRemoteAddress() + " has connected");
        connections.add(session);
        broadcast(session.getId() + " connected!");
        log.info(connections);
    }

    // 处理Pong
    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        super.handlePongMessage(session, message);
    }

    // 处理错误信息
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    // 连接关闭
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session.getId() + " : " + session.getRemoteAddress() + " has disconnected");
        connections.remove(session);
        broadcast(session.getId() + " disconnected!");
    }

    @Override
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }

    // 处理textmessage
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("handle message " + message.getPayload());
        broadcast(session.getId() + " : " + message.getPayload());
    }

    // 广播消息
    private void broadcast(String msg){
        for(WebSocketSession client : connections){
            synchronized (client){
                try {
                    client.sendMessage(new TextMessage(msg));
                } catch (IOException e) {
                    e.printStackTrace();
                    log.debug("Chat Error: Failed to send message to client", e);
                    connections.remove(client);
                    broadcast(client.getId() + " has disconnected");
                }
            }
        }
    }
}
