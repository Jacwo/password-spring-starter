package com.yyl.condition;

import com.yyl.service.BaseStarterService;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * author:yangyuanliang Date:2019-10-15 Time:13:37
 **/
public class MacCondition implements Condition {
    private final static String WINDOWS="Windows";
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取当前环境变量
        Environment environment=conditionContext.getEnvironment();
        //获取bean注册器
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        //能获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //获取环境变量中操作系统
        String property = environment.getProperty("os.name");
        //判断操作系统是否为windows
        if(!property.contains(WINDOWS)){
            //判断是否存在baseWindowsSevice类，不存在则进行bean注册
            boolean isWindowsSevice = registry.containsBeanDefinition("baseStarterService");
            if(!isWindowsSevice){
                //指定Bean定义信息；（Bean的类型，Bean的一系列信息）
                RootBeanDefinition beanDefinition = new RootBeanDefinition(BaseStarterService.class);
                //注册一个Bean，指定bean名
                registry.registerBeanDefinition("baseStarterService", beanDefinition);
                BaseStarterService windowsSevice = (BaseStarterService)beanFactory.getBean("baseStarterService");
            }
            return true;
        }
        return false;
    }
}
