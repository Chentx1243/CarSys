package com.xshxy.carsysdemo.controller;

import com.xshxy.carsysdemo.bean.DriverStatus;
import com.xshxy.carsysdemo.bean.DrivingData;
import com.xshxy.carsysdemo.bean.SocketMessage;
import com.xshxy.carsysdemo.service.DriverStatusService;
import com.xshxy.carsysdemo.service.DrivingDataService;
import com.xshxy.carsysdemo.service.impl.DrivingDataServiceImpl;
import com.xshxy.carsysdemo.websocket.DataWebSocketHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 用于处理驾驶舱请求的controller
 */
@RestController
@RequestMapping("/api/socket")
@Tag(name = "WebSocket消息处理", description = "处理驾驶舱传入的实时驾驶数据，注意这些驾驶数据会自动存储到数据库中，无需再调用独立存储接口额外存储")
public class CarSocketMessageController {
    @Autowired
    private DataWebSocketHandler dataWebSocketHandler;
    @Autowired
    private DrivingDataService drivingDataService;
    @Autowired
    private DriverStatusService driverStatusService;

    private DrivingData drivingData;
    private DriverStatus driverStatus;
    @Operation(summary = "上传驾驶实时数据接口", description = "这些数据会实时同步到web前端，并在数据库中存储")
    @PostMapping("/upload")
    public ResponseEntity upload(@RequestBody SocketMessage socketMessage) throws IOException {
//        调用socket服务发送到前端
        dataWebSocketHandler.sendToClients(socketMessage);
//        存储驾驶数据
        drivingData = new DrivingData(null,socketMessage.getVehicleId(),0,0,socketMessage.getBrakeDeep(),socketMessage.getDirectionAngle(),socketMessage.getBlockCount(),0,socketMessage.getTimestamp());
        int i = drivingDataService.uploadDrivingData(drivingData);
//        面部数据存储
        driverStatus = new DriverStatus(null, socketMessage.getVehicleId(), socketMessage.getBlink(), socketMessage.getYawning(), socketMessage.getFaceData(),socketMessage.getFaceDetails(),socketMessage.getTimestamp());
        int j = driverStatusService.uploadDriverStatus(driverStatus);
        return ResponseEntity.ok("数据已同步");
    }
}
