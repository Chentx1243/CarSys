package com.xshxy.carsysdemo.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * driver_status
 */
@Data
@AllArgsConstructor
public class DriverStatus implements Serializable {
    private Integer dataId;

    private Integer vehicleId;

    private Integer blink;

    private Integer yawning;

    private Double faceData;

    private Double faceDetails;

    private Date timestamp;

    private static final long serialVersionUID = 1L;
}