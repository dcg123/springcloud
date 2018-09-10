package com.waylau.spring.cloud.weather.service;


import com.waylau.spring.cloud.weather.vo.City;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="msa-weather-eureka-client-zuul", fallback=DataClientFallback.class)
public interface DataClient {
    /**
     * 获取城市列表
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws  Exception;


    /**
     *根据城市id获取天气信息
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
