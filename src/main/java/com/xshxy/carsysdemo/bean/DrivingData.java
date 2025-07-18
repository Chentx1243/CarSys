package com.xshxy.carsysdemo.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * driving_data
 */
@Data
@AllArgsConstructor
public class DrivingData implements Serializable {
    private Integer dataId;

    private Integer vehicleId;

    private Integer currentSpeed;

    private Integer currentEle;

    private Double brakeDeep;

    private Double directionAngle;

    private Integer blockCount;

    private Integer power;

    private Date timestamp;

    private static final long serialVersionUID = 1L;
}