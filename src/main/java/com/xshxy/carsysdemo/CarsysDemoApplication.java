package com.xshxy.carsysdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = "com.xshxy.carsysdemo.mapper")
@SpringBootApplication
//事务管理
@EnableTransactionManagement
public class CarsysDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarsysDemoApplication.class, args);
    }

}
