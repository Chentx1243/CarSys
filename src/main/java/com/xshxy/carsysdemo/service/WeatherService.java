package com.xshxy.carsysdemo.service;

import com.xshxy.carsysdemo.bean.EnvironmentWeather;

import java.util.List;

/**
 * 定义天气相关信息的处理方式
 */
public interface WeatherService {
    /**
     * 更新车内温度等环境信息
     * @param environmentWeather 环境天气对象
     * @return 受影响的行数
     */
    int uploadWeather(EnvironmentWeather environmentWeather);

    /**
     * 查询车辆历史环境信息
     * @return 环境信息的集合
     */
    List<EnvironmentWeather> getWeatherInfo(int vehicleId);

    List getWindCount();
}
