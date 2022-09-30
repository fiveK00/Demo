package com.example.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.common.PeopleDynamicEasyExcelReader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dc.wang <dc.wang@idiaoyan.com>
 * @version V1.0
 * @date 2022/9/16 13:59
 */
@RestController
@RequestMapping("/export")
public class ExportController {
    @PostMapping("/people")
    public void importPeople(@RequestParam("import_file") MultipartFile multipartFile, HttpServletRequest request) {
        PeopleDynamicEasyExcelReader reader = new PeopleDynamicEasyExcelReader();
        try (InputStream is = multipartFile.getInputStream()) {
            reader.read(is);
        } catch (IOException e) {

        }
    }

    @GetMapping("/people")
    public void people(HttpServletResponse response) {
        List<PeopleVo> peopleVoList = this.getPeoples();
        try (OutputStream os = response.getOutputStream()) {
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = "test";
            response.setHeader("Content-disposition", String.format("attachment;filename=%s.xlsx", fileName));

            List<List<String>> heads = Stream.of("head").map(Arrays::asList).collect(Collectors.toList());


            ExcelWriter excelWriter = EasyExcelFactory.write(os).useDefaultStyle(false).head(heads).build();
            WriteSheet writeSheet = EasyExcelFactory.writerSheet("sheet").build();

            List<List<String>> rows = Stream.of("row1", "row2").map(Arrays::asList).collect(Collectors.toList());
            excelWriter.write(rows, writeSheet);
            excelWriter.finish();

//            EasyExcelFactory.write(response.getOutputStream(), PeopleVo.class).sheet("sheet").doWrite(peopleVoList);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private List<PeopleVo> getPeoples() {
        List<PeopleVo> peopleVoList = new ArrayList<>();
        PeopleVo peopleVo = new PeopleVo("123");
        peopleVoList.add(peopleVo);
        return peopleVoList;
    }

}
