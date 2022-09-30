package com.example.common;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.read.listener.ReadListener;

import java.io.InputStream;
import java.util.Optional;

/**
 * @author dc.wang <dc.wang@idiaoyan.com>
 * @version V1.0
 * @date 2022/9/23 16:18
 */
public interface AbstractEasyExcelReader<T> {

    default ReadListener<T> instanceListener(){
        return null;
    }

    default ExcelReaderSheetBuilder sheetBuilder(){
        return EasyExcelFactory.readSheet();
    }

    default ExcelReaderBuilder readBuilder(){
        return EasyExcelFactory.read();
    }

    default void read(InputStream is){
        ExcelReader excelReader = null;
        try{
            ExcelReaderBuilder readerBuilder = this.readBuilder();
            readerBuilder.file(is);
            Optional<ReadListener<T>> listenerOptional = Optional.ofNullable(this.instanceListener());
            if(listenerOptional.isPresent()){
                readerBuilder.useDefaultListener(true);
                readerBuilder.registerReadListener(listenerOptional.get());
            }
            readerBuilder.autoCloseStream(true);

            excelReader = EasyExcelFactory.read(is).registerReadListener(this.instanceListener()).build();
            excelReader.read(this.sheetBuilder().build());
        }catch (Exception e){
            throw e;
        }finally {
            if(excelReader != null){
                excelReader.finish();
            }
        }
    }
}
