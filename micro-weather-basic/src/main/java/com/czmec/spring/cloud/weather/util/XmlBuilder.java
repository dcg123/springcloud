package com.czmec.spring.cloud.weather.util;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;
import java.rmi.UnmarshalException;

/**
 * 解析xml
 */
public class XmlBuilder {
    public static Object xmlStrToOject(Class<?> clazz,String xmlStr) throws Exception{
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        // XML 转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();
        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        if (null != reader) {
            reader.close();
        }

        return xmlObject;
    }
}
