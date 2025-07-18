package com.xshxy.carsysdemo.bean;

import lombok.Data;

import java.util.Date;

/**
 * 用于同一管理socket消息的实体类
 * 驾驶舱直接发送SocketMassage类的对象json串
 * 驾驶数据：
 * 方向盘角度 direction_angle
 * 刹车踏板深度 brake_deep
 * 障碍物数量 block_count
 * 面部数据统计：
 * 眨眼 blink
 * 张嘴 yawning
 * 点头 face_data
 * 摇头 face_details
 */
@Data
public class SocketMessage {
    private int vehicleId;
    private double directionAngle;
    private double brakeDeep;
    private int blockCount;
    private int blink;
    private int yawning;
    private double faceData;
    private double faceDetails;
    private Date timestamp;
}
