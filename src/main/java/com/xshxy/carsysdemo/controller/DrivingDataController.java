package com.xshxy.carsysdemo.controller;

import com.xshxy.carsysdemo.bean.DrivingData;
import com.xshxy.carsysdemo.service.impl.DrivingDataServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivingdata")
@Tag(name = "驾驶数据接口", description = "上传驾驶数据，获取驾驶数据")
public class DrivingDataController {
    @Autowired
    private DrivingDataServiceImpl drivingDataService;
    /**
     * 上传驾驶数据接口，用于单独上传一条驾驶数据
     * @param drivingData 驾驶数据实体类
     * @return 数据上传的结果
     */
    @PostMapping
    @Operation(summary = "上传驾驶数据接口", description = "上传驾驶数据(websocket已经上传过的数据无需再次调用该方法上传)")
    public ResponseEntity uploadDrivingData(@RequestBody DrivingData drivingData){
        int i = drivingDataService.uploadDrivingData(drivingData);
        return i>0?ResponseEntity.ok("驾驶数据成功上传"):ResponseEntity.badRequest().body("上传失败");
    }

    /**
     * 根据id获取车辆驾驶数据接口（LIMIT0，7）
     * @param vehicleId 车辆id
     * @return 驾驶聚聚的集合
     */
    @Operation(summary = "获取驾驶数据接口", description = "获取驾驶数据")
    @GetMapping("/{vehicleId}")
    public ResponseEntity<List<DrivingData>> getDrivingInfo(@PathVariable int vehicleId){
        List<DrivingData> drivingData = drivingDataService.selectDrivingDataById(vehicleId);
        if (drivingData !=null && !(drivingData.isEmpty())){
            return ResponseEntity.ok(drivingData);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
