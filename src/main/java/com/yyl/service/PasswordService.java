package com.yyl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * author:yangyuanliang Date:2019-10-15 Time:13:32
 **/
public class PasswordService {
    private String key;
    @Autowired
    //模拟的第三方系统service
    private ThirdPartyService thirdPartyService;
    public String getSystemPassword(String objectKey,String originalPassord){

        if(StringUtils.isEmpty(objectKey)){
            return  originalPassord;
        }
        //从第三方系统获取密码
        String password= thirdPartyService.getPassword(objectKey);
        //返回密码
        return password!=null?password:originalPassord;

    }
}
