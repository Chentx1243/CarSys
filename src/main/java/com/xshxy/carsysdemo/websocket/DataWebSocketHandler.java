package com.xshxy.carsysdemo.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xshxy.carsysdemo.bean.SocketMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class DataWebSocketHandler extends TextWebSocketHandler {
    // 存储所有连接的 WebSocket 会话
    private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 当 WebSocket 连接建立时，添加会话到集合
        sessions.add(session);
        System.out.println("[afterConnection]完成连接；连接对象为："+session+"连接状态为："+session.isOpen());
        System.out.println("[afterConnection]当前维护的连接数量："+sessions.size());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 当 WebSocket 连接关闭时，从集合中移除会话
        System.out.println("[afterConnection]移除；移除对象为："+session);
        sessions.remove(session);
        System.out.println("[afterConnection]当前维护的连接数量："+sessions.size());
    }
    public void sendToClients(SocketMessage socketMessage) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(socketMessage);
        for(WebSocketSession session : sessions){
            try {
                if (session.isOpen()){
                    session.sendMessage(new TextMessage(jsonData));
                }else {
                    System.out.println("客户端已关闭");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

//    public void sendToClients(Object data) throws IOException {
//        // 将数据转换为 JSON 格式
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonData = objectMapper.writeValueAsString(data);
//        for (WebSocketSession session : sessions) {
//            try {
//                if (session.isOpen()) {
//                    System.out.println("测试：发送数据到客户端：" + session.getId());
//                    session.sendMessage(new TextMessage(jsonData));
//                } else {
//                    System.out.println("测试：会话已关闭，客户端：" + session.getId());
//                }
//            } catch (IOException e) {
//                System.out.println("测试：发送失败，客户端：" + session.getId());
//                e.printStackTrace();
//            }
//        }
//    }

//    public void sendToClients(StatusShowMesagge data ) throws IOException {
//        // 将数据转换为 JSON 格式
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonData = objectMapper.writeValueAsString(data);
//        for (WebSocketSession session : sessions) {
//            try {
//                if (session.isOpen()) {
//                    System.out.println("测试：发送数据到客户端：" + session.getId());
//                    session.sendMessage(new TextMessage(jsonData));
//                } else {
//                    System.out.println("测试：会话已关闭，客户端：" + session.getId());
//                }
//            } catch (IOException e) {
//                System.out.println("测试：发送失败，客户端：" + session.getId());
//                e.printStackTrace();
//            }
//        }
//    }




}
