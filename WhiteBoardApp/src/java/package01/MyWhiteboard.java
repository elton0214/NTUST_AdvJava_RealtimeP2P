/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package01;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author 4 弦
 */

//Tomcat 會掃描帶有@ServerEndpoint的註解 成為websocket
@ServerEndpoint(value ="/whiteboardendpoint", encoders={FigureEncoder.class}, decoders={FigureDecoder.class})//connect to websocket.js
public class MyWhiteboard {
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());//peers代表 sessions的集合
    
    @OnMessage
    public void broadcastFigure(JsonHandler input_Figure, Session input_Session) throws IOException, EncodeException{
        System.out.println("broadcastFigure: " +input_Figure);
        for (Session peer: peers){
            if (!peer.equals(input_Session)){
                peer.getBasicRemote().sendObject(input_Figure);
            }
        }
    }
    
    @OnOpen
    public void onOpen(Session input_peer){
        peers.add(input_peer);
    }
    
    @OnClose
    public void onClosed(Session input_peer){
        peers.remove(input_peer);
    }
    
}
