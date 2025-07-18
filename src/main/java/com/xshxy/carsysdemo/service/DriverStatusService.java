package com.xshxy.carsysdemo.service;

import com.xshxy.carsysdemo.bean.DriverStatus;

import java.util.List;

public interface DriverStatusService {

    int uploadDriverStatus(DriverStatus driverStatus);


    List<DriverStatus> getDriverStatus(int vehicleID);
}
