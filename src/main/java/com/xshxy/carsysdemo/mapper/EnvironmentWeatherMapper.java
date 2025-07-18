package com.xshxy.carsysdemo.mapper;

import com.xshxy.carsysdemo.bean.EnvironmentWeather;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvironmentWeatherMapper {
    int deleteByPrimaryKey(Integer dataId);

    int insert(EnvironmentWeather record);

    int insertSelective(EnvironmentWeather record);

    EnvironmentWeather selectByPrimaryKey(Integer dataId);

    int updateByPrimaryKeySelective(EnvironmentWeather record);

    int updateByPrimaryKey(EnvironmentWeather record);

    /**
     * 带分页条件的查询，查询特定数量的天气信息
     * @param offset 查询结果中结果集起始位置
     * @param pageSize 查询条数
     * @return 对象结果集
     */
    List<EnvironmentWeather> selectAllByPage(@Param("id") int id,@Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询风向累计历史
     * @return 返回风向与累计的集合
     */
    List selectWindDirectionCount();

}