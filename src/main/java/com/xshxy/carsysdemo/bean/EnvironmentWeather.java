package com.xshxy.carsysdemo.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * environment_weather
 */
@Data
@Getter
@Setter
public class EnvironmentWeather implements Serializable {
    private Integer dataId;

    private Integer vehicleId;

    private Double currentTemperature;

    private Double currentHumidity;

    private Integer windDirection;

    private Integer windPower;

    private Date timestamp;

    private static final long serialVersionUID = 1L;
}