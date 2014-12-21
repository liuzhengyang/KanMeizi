package com.kanmeizi.controller.websocket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * WebSocket 处理类
 * Created by liuzhengyang on 2014/12/19.
 */
public class MyHandler extends TextWebSocketHandler {

    private static final Log log = LogFactory.getLog(MyHandler.class);

    // 连接后
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info(session.getId() + " : " + session.getRemoteAddress() + " has connected");
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
    }

    @Override
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }

    // 处理textmessage
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("handle message " + message.getPayload());
        session.sendMessage(new TextMessage("you say " + message.getPayload()));
    }
}
