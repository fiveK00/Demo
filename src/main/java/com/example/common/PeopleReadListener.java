package com.example.common;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.util.ConverterUtils;

import java.util.Map;

/**
 * @author dc.wang <dc.wang@idiaoyan.com>
 * @version V1.0
 * @date 2022/9/26 14:18
 */
public class PeopleReadListener<T> extends AnalysisEventListener<T> {
    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        //  转换成 Map<Integer,String>
        Map<Integer, String> map = ConverterUtils.convertToStringMap(headMap, context);
        System.out.println("invokeHead");
    }

    @Override
    public void invoke(T data, AnalysisContext context) {
        System.out.println("invoke");
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("doAfterAllAnalysed");
    }
}
