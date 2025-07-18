package com.xshxy.carsysdemo.controller;

import com.xshxy.carsysdemo.bean.AutoAnalysis;
import com.xshxy.carsysdemo.bean.DriverStatus;
import com.xshxy.carsysdemo.bean.DrivingData;
import com.xshxy.carsysdemo.bean.EnvironmentWeather;
import com.xshxy.carsysdemo.service.DriverStatusService;
import com.xshxy.carsysdemo.service.DrivingDataService;
import com.xshxy.carsysdemo.service.SuperFunction;
import com.xshxy.carsysdemo.service.WeatherService;
import dev.langchain4j.model.chat.ChatLanguageModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@Tag(name = "DeepSeek调用接口", description = "调用Deepseek")
public class DeepSeekController {
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private DrivingDataService drivingDataService;
    @Autowired
    private DriverStatusService driverStatusService;

//    private final ChatLanguageModel chatLanguageModel;
//    ChatLanguageModel deepSeekv3;
//    public DeepSeekController(ChatLanguageModel deepSeekv3, ChatLanguageModel chatLanguageModel){
//        this.chatLanguageModel = chatLanguageModel;
//        this.deepSeekv3 = chatLanguageModel;
//    }
    @Autowired
    private  SuperFunction deepSeekv3;//置顶调用V3模型
    @Operation(summary = "环境感知决策建议接口", description = "处理车辆环境数据，辅助决策")
    @GetMapping("/advice")
    public String advice(){
        List<EnvironmentWeather> weatherInfo = weatherService.getWeatherInfo(1);
        String message = weatherInfo.toString();
        System.out.println(message);
        return deepSeekv3.getAdviceByEve(message);
    }

    @Operation(summary = "全局感知决策建议接口", description = "模型感知全局参数，辅助决策")
    @GetMapping("/anylises")
    public ResponseEntity<AutoAnalysis> analysis(){
//        获取驾驶人信息
        String driver = "这是驾驶人信息：";
        List<DriverStatus> driverStatus = driverStatusService.getDriverStatus(1);
        driver += driverStatus.toString();
//        获取驾驶数据
        String driving = "这是驾驶数据：";
        List<DrivingData> drivingData = drivingDataService.selectDrivingDataById(1);
        driving += drivingData.toString();
//        获取气象数据
        String weather = "这是气象数据：";
        List<EnvironmentWeather> weatherInfo = weatherService.getWeatherInfo(1);
        weather += weatherInfo.toString();
//         数据推送给模型
        String message = driver + driving + weather;
        System.out.println("数据如下："+message);
        AutoAnalysis autoAnalysis = deepSeekv3.getAutoAnalysis(message);
        return ResponseEntity.ok(autoAnalysis);
    }
}
