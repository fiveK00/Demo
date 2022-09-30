package com.example.common;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dc.wang <dc.wang@idiaoyan.com>
 * @version V1.0
 * @date 2022/9/16 16:14
 */
public abstract class AbstractDynamicExcelHandler<T>{

    private Integer sheetNo = 0;

    private String sheetName = "sheet";

    private Integer singleProcessNum = 1000;


    abstract List<T> next(Integer size);

    public abstract class AbstractDynamicExcelReader extends AbstractDynamicExcelHandler<T> {
        /**
         * excel heads
         *
         * @return
         */
        abstract List<String> getHeads();

        /**
         * excel row
         *
         * @return
         */
        abstract List<String> getRow(T t);

        public void read(InputStream is){
            ExcelReader excelReader = null;
            try {
                excelReader = null;
                WriteSheet writeSheet = EasyExcelFactory.writerSheet(sheetNo, sheetName).build();

                List<T> data = next(singleProcessNum);
                while(data != null && !data.isEmpty()){
                    List<List<String>> rows = data.stream().map(this::getRow).collect(Collectors.toList());
                    excelReader.readAll();
                }
            } finally {
                if(excelReader != null){
                    excelReader.finish();
                }
            }
        }
    }

    public abstract class AbstractDynamicExcelWriter extends AbstractDynamicExcelHandler<T>{
        /**
         * excel heads
         *
         * @return
         */
        abstract List<String> getHeads();

        /**
         * excel row
         *
         * @return
         */
        abstract List<String> getRow(T t);

        public void write(OutputStream os){
            ExcelWriter excelWriter = null;
            try {
                excelWriter = EasyExcelFactory.write(os).head(getHeads().stream().map(Arrays::asList).collect(Collectors.toList())).build();
                WriteSheet writeSheet = EasyExcelFactory.writerSheet(sheetNo, sheetName).build();

                List<T> data = next(singleProcessNum);
                while(data != null && !data.isEmpty()){
                    List<List<String>> rows = data.stream().map(this::getRow).collect(Collectors.toList());
                    excelWriter.write(rows, writeSheet);
                }
            } finally {
                if(excelWriter != null){
                    excelWriter.finish();
                }
            }
        }
    }
}
