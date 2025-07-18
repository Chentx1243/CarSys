package com.xshxy.carsysdemo.service.impl;

import com.xshxy.carsysdemo.bean.DrivingData;
import com.xshxy.carsysdemo.mapper.DrivingDataMapper;
import com.xshxy.carsysdemo.service.DrivingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivingDataServiceImpl implements DrivingDataService {

    @Autowired
    private DrivingDataMapper drivingDataMapper;

    @Override
    public int uploadDrivingData(DrivingData drivingData) {
        int count  = drivingDataMapper.insert(drivingData);
        return count;
    }

    @Override
    public List<DrivingData> selectDrivingDataById(int id) {
        List<DrivingData> results = drivingDataMapper.selectLimitByVehicleId(id, 0, 7);
        return results;
    }
}
