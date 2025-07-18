package com.xshxy.carsysdemo.controller;

import com.xshxy.carsysdemo.bean.DriverStatus;
import com.xshxy.carsysdemo.service.DriverStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driverstatus")
@Tag(name = "驾驶员面部数据接口", description = "上传面部数据，获取面部数据")
public class DriverStatusController {

    @Autowired
    private DriverStatusService driverStatusService;

    /**
     * 上传面部数据，单独使用，预留
     * @param driverStatus 驾驶员面部状态数据实体类
     * @return 操作结果
     */
    @Operation(summary = "上传面部数据接口", description = "上传面部数据(webSocket上传过的数据无需再次调用这个接口上传，websocket有自动上传逻辑)")
    @PostMapping
    public ResponseEntity uploadDriverStatus(@RequestBody DriverStatus driverStatus){
        int i = driverStatusService.uploadDriverStatus(driverStatus);
        return i>0?ResponseEntity.ok("面部数据上传成功"):ResponseEntity.badRequest().body("上传失败");
    }

    @GetMapping("/{vehicleId}")
    @Operation(summary = "获取面部数据接口", description = "获取面部数据")
    public ResponseEntity<List<DriverStatus>> getDriverStatusInfo(@PathVariable int vehicleId){
        List<DriverStatus> driverStatus = driverStatusService.getDriverStatus(vehicleId);
        if (driverStatus != null && !driverStatus.isEmpty()){
            return ResponseEntity.ok(driverStatus);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
