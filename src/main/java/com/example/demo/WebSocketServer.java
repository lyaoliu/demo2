package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/03 上午 9:26
 */
@ServerEndpoint(value = "/webSocketServer/{userName}")
@Component
public class WebSocketServer {
    private static Set<WebSocketServer> connections = new CopyOnWriteArraySet<>();

    private String nickname;
    private Session session;
    private static String getDatetime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
    @OnOpen
    public void start(@PathParam("userName") String userName, Session session) {
        this.nickname = userName;
        this.session = session;
        connections.add(this);
        String message = String.format("* %s %s", nickname, "加入聊天！");
        broadcast(message);
        List list=new ArrayList();
        for (WebSocketServer socketServer:connections ){
            list.add(socketServer.nickname);
        }
        Map map=new HashMap(16);
        map.put("result",list);
        broadcast(JSON.toJSONString(map));
    }
    @OnClose
    public void end() {
        connections.remove(this);
        String message = String.format("* %s %s", nickname, "退出聊天！");
        broadcast(message);
    }

    @OnMessage
    public void pushMsg(String message) {
        broadcast("【" + this.nickname + "】" + getDatetime(new Date()) + " : " + message);
    }

    @OnError
    public void onError(Throwable t) throws Throwable {

    }

    private static void broadcast(String msg) {
        // 广播形式发送消息
        for (WebSocketServer client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    e.printStackTrace();
                }
                String message = String.format("* %s %s", client.nickname, "断开连接");
                broadcast(message);
            }
        }
    }
}
