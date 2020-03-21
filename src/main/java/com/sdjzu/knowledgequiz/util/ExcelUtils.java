package com.sdjzu.knowledgequiz.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.logging.LoggerFactory;

import javax.validation.constraints.Size;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * excel工具类
 */
@Slf4j
public class ExcelUtils {



    /**
     * 课程excel
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    public static List getCourseListByExcel(InputStream in, String fileName) throws Exception {

        List list = new ArrayList<>();

        // 创建excel工作簿
        Workbook work = getWorkbook(in, fileName);
        if (null == work) {
            log.error("创建Excel工作薄为空！");
        }

        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {

            sheet = work.getSheetAt(i);
            if(sheet == null) {
                continue;
            }

            // 滤过第一行标题
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<Object> li = new ArrayList<>();

                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }

    /**
     * 判断文件格式
     * @param in
     * @param fileName
     * @return
     */
    private static Workbook getWorkbook(InputStream in, String fileName) throws Exception {

        Workbook book = null;
        String filetype = fileName.substring(fileName.lastIndexOf("."));

        if(".xls".equals(filetype)) {
            book = new HSSFWorkbook(in);
        } else if (".xlsx".equals(filetype)) {
            book = new XSSFWorkbook(in);
        } else {
            log.error("请上传excel文件！");
        }

        return book;
    }
}


