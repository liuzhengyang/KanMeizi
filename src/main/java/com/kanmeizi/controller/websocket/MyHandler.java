package com.kanmeizi.controller.websocket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by liuzhengyang on 2014/12/19.
 */
public class MyHandler extends TextWebSocketHandler {

    private static final Log log = LogFactory.getLog(MyHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("handle message " + message.getPayload());
        session.sendMessage(new TextMessage("you say " + message.getPayload()));
    }
}
