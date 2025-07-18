package com.xshxy.carsysdemo.service;

import com.xshxy.carsysdemo.bean.DrivingData;

import java.util.List;

/**
 * 定义驾驶数据处理
 */
public interface DrivingDataService {
    /**
     * 单独更新驾驶数据的接口
     * @param drivingData 驾驶数据实体
     * @return 修改行数
     */
    int uploadDrivingData(DrivingData drivingData);

    List<DrivingData> selectDrivingDataById(int id);
}
