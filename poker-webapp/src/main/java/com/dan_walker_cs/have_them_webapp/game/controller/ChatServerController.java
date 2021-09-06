package com.dan_walker_cs.have_them_webapp.game.controller;


import javax.annotation.PreDestroy;
import javax.inject.Singleton;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Singleton
@ServerEndpoint("/game")
public class ChatServerController {

    @OnOpen
    public void onOpen(Session s) throws IOException {
        s.getBasicRemote().sendText(String.valueOf(hashCode()));
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("Singleton bean " + hashCode() + " will be destroyed");
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Closed " + session.getId() + " due to " + closeReason.getCloseCode());
    }
}
