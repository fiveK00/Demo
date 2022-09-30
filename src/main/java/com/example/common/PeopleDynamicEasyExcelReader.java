package com.example.common;

import com.alibaba.excel.read.listener.ReadListener;

import java.util.Map;

/**
 * @author dc.wang <dc.wang@idiaoyan.com>
 * @version V1.0
 * @date 2022/9/26 11:05
 */
public class PeopleDynamicEasyExcelReader implements AbstractEasyExcelReader<Map<String, Object>>{
    @Override
    public ReadListener<Map<String, Object>> instanceListener() {
        return new PeopleReadListener<>();
    }


}
