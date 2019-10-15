package com.yyl.service;

import com.yyl.properties.BaseServiceProperties;

/**
 * author:yangyuanliang Date:2019-10-15 Time:13:36
 **/
public class BaseStarterService {
    public void addServiceName(BaseServiceProperties baseServiceProperties){
        System.out.println("serviceName:"+baseServiceProperties.getServiceName()+"----"+"serviceVersion"+baseServiceProperties.getServiceVersion());
    }
}
