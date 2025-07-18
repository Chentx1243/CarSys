package com.xshxy.carsysdemo.mapper;

import com.xshxy.carsysdemo.bean.DrivingData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrivingDataMapper {
    int deleteByPrimaryKey(Integer dataId);

    int insert(DrivingData record);

    int insertSelective(DrivingData record);

    DrivingData selectByPrimaryKey(Integer dataId);

    int updateByPrimaryKeySelective(DrivingData record);

    int updateByPrimaryKey(DrivingData record);

    List<DrivingData> selectLimitByVehicleId(@Param("vehicleId") int vehicleId,@Param("offset") int offset, @Param("pageSize") int pageSize);
}