package com.czmec.spring.cloud.weather.service;

import com.czmec.spring.cloud.weather.vo.Weather;

public interface WeatherReportService {
    /**
     * 根据城市ID查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
