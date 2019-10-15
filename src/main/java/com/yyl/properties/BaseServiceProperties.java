package com.yyl.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * author:yangyuanliang Date:2019-10-15 Time:13:34
 **/
@ConfigurationProperties(prefix = "spring.starter.password")
public class BaseServiceProperties {
    private String serviceName;
    private String serviceVersion;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }
}