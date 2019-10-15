package com.yyl.autoconf;

import com.yyl.condition.MacCondition;
import com.yyl.properties.BaseServiceProperties;
import com.yyl.service.BaseStarterService;
import com.yyl.service.PasswordService;
import com.yyl.service.ThirdPartyService;
import org.hibernate.validator.internal.metadata.raw.BeanConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * author:yangyuanliang Date:2019-10-15 Time:13:38
 **/
@Configuration
//自动加载配置文件属性值
@EnableConfigurationProperties(BaseServiceProperties.class)
@Import(BeanConfiguration.class)
//判断当前环境是否为windows
@Conditional(MacCondition.class)
//判断属性spring.project.ThirdPartySystemService.isPassword是否等于true
@ConditionalOnProperty(prefix = "spring.project.ThirdPartyService",value = "enablePassword", havingValue = "true",matchIfMissing = true)
public class AutoConfigurationPassoword {
    @Autowired
    private BaseServiceProperties baseServiceProperties;
    @Autowired
    private BaseStarterService baseWindowsService;

    //加载第三方系统service
    @Bean("thirdPartySystemService")
    public ThirdPartyService thirdPartySystemService(){
        baseWindowsService.addServiceName(baseServiceProperties);
        return new ThirdPartyService();
    }
    @Bean
    //判断IOC容器中是否存在ThirdPartySystemService类，存在则创建PasswordService bean
    @ConditionalOnClass(ThirdPartyService.class)
    public PasswordService passwordService(){
        baseWindowsService.addServiceName(baseServiceProperties);
        return new PasswordService();
    }
}
