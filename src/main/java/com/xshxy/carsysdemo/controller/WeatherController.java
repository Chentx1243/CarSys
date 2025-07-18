package com.xshxy.carsysdemo.controller;


import com.xshxy.carsysdemo.bean.EnvironmentWeather;
import com.xshxy.carsysdemo.service.impl.WeatherServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/weather")
@Tag(name = "环境信息处理接口" ,description = "上传环境信息，获取环境信息")
public class WeatherController {

    @Autowired
    private WeatherServiceImpl weatherService;


    /**
     * 上传环境天气信息接口
     * @param e 包含环境天气数据的实体类
     * @return ResponseEntity<String> 返回操作结果的响应实体
     */
    @PostMapping
    @Operation(summary = "上传环境天气信息接口", description = "上传环境天气信息")
    public ResponseEntity<String> uploadWeather(@RequestBody EnvironmentWeather e){
        int i = weatherService.uploadWeather(e);
        // 根据插入结果返回相应的响应
        return i>0?ResponseEntity.ok("环境信息上传成功"):ResponseEntity.badRequest().body("环境信息上传失败");
    }

    /**
     * 获取特定车辆的天气信息
     * @param vehicleId 车辆id
     * @return 返回天气信息的集合
     */

    @GetMapping("/{vehicleId}")
    @Operation(summary = "获取特定车辆的天气信息", description = "获取特定车辆的天气信息")
    public ResponseEntity<List<EnvironmentWeather>> getWeatherInfo(@PathVariable int vehicleId){
        List<EnvironmentWeather> weatherInfo = weatherService.getWeatherInfo(vehicleId);
        if (weatherInfo != null && !weatherInfo.isEmpty()){
            return ResponseEntity.ok(weatherInfo);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getWindCount")
    @Operation(summary = "获取特定车辆的风向统计")
    public ResponseEntity<List> getWindCount(){
        List windCount = weatherService.getWindCount();
        return ResponseEntity.ok(windCount);
    }

}
