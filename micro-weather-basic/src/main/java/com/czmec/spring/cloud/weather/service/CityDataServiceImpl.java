package com.czmec.spring.cloud.weather.service;

import com.czmec.spring.cloud.weather.util.XmlBuilder;
import com.czmec.spring.cloud.weather.vo.City;
import com.czmec.spring.cloud.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;


@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        //读取xml文件
        Resource resource=new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = br.readLine()) !=null) {
            buffer.append(line);
        }

        br.close();

        //xml转化为list对象
        CityList cityList= (CityList) XmlBuilder.xmlStrToOject(CityList.class,buffer.toString());
        return cityList.getCityList();
    }
}
