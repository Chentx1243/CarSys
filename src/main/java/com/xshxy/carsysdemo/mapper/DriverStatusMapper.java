package com.xshxy.carsysdemo.mapper;

import com.xshxy.carsysdemo.bean.DriverStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverStatusMapper {
    int deleteByPrimaryKey(Integer dataId);

    int insert(DriverStatus record);

    int insertSelective(DriverStatus record);

    DriverStatus selectByPrimaryKey(Integer dataId);

    int updateByPrimaryKeySelective(DriverStatus record);

    int updateByPrimaryKey(DriverStatus record);

    List<DriverStatus> selectLimitByVehicleId(@Param("vehicleId") int vehicleId,@Param("offset") int offset, @Param("pageSize") int pageSize);
}