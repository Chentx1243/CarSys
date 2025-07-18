package com.xshxy.carsysdemo.service.impl;

import com.xshxy.carsysdemo.bean.DriverStatus;
import com.xshxy.carsysdemo.mapper.DriverStatusMapper;
import com.xshxy.carsysdemo.service.DriverStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverStatusServiceImpl implements DriverStatusService {
    @Autowired
    private DriverStatusMapper driverStatusMapper;
    @Override
    public int uploadDriverStatus(DriverStatus driverStatus) {
        int count = driverStatusMapper.insert(driverStatus);
        return count;
    }

    @Override
    public List<DriverStatus> getDriverStatus(int vehicleID) {
        List<DriverStatus> driverStatuses = driverStatusMapper.selectLimitByVehicleId(vehicleID, 0, 9);
        return driverStatuses;
    }
}
