package com.xshxy.carsysdemo.service.impl;

import com.xshxy.carsysdemo.bean.EnvironmentWeather;
import com.xshxy.carsysdemo.mapper.EnvironmentWeatherMapper;
import com.xshxy.carsysdemo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private EnvironmentWeatherMapper environmentWeatherMapper;
    @Override
    public int uploadWeather(EnvironmentWeather e) {
        int count = environmentWeatherMapper.insert(e);
        return count;
    }

    @Override
    public List<EnvironmentWeather> getWeatherInfo(int vehicleId) {
        List<EnvironmentWeather> weatherList = environmentWeatherMapper.selectAllByPage(vehicleId,0,7);
        return weatherList;
    }

    @Override
    public List getWindCount() {
        List list = environmentWeatherMapper.selectWindDirectionCount();
        return list;
    }
}
