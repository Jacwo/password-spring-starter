package com.yyl.service;

import java.util.UUID;

/**
 * author:yangyuanliang Date:2019-10-15 Time:13:32
 **/
public class ThirdPartyService {
    public String getPassword(String objectKey){
        //返回一个32位随机数
        return UUID.randomUUID().toString();
    }
}
