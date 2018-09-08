package com.czmec.spring.cloud.weather.service;

import com.czmec.spring.cloud.weather.vo.City;

import java.util.List;



public interface CityDataService {
    /**
     * 获取city列表
     */

    List<City> listCity() throws Exception;
}
