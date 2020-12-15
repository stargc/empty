package com.example.empty.infrastructure.util.excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author created by guanchen on 2020/11/21 16:12
 */
public class ExcelTool {
    private static final Logger logger = LoggerFactory.getLogger(ExcelTool.class);

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * 读取Excel文件内容
     * @param fileName 要读取的Excel文件所在路径
     * @return 读取结果列表，读取失败时返回null
     */
    public static<T> List readExcel(InputStream inputStream, String fileName, ExcelParseFunction<T> function) {

        Workbook workbook = null;

        try {
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            workbook = getWorkbook(inputStream, fileType);

            // 读取excel中的数据
            return function.dealData(workbook.getSheetAt(0));
        } catch (Exception e) {
            logger.error("解析Excel失败，文件名：" + fileName + ExceptionUtils.getStackTrace(e));
            return Collections.emptyList();
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                logger.error("关闭数据流出错！错误信息：" + e.getMessage());
                return Collections.emptyList();
            }
        }
    }
    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     * @param inputStream 读取文件的输入流
     * @param fileType 文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    private static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        //设置延迟解析比例
        ZipSecureFile.setMinInflateRatio(-1.0d);
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }


    public static void addHeader(HSSFSheet sheet, String[] headers){
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
    }

    public static void setCellValue(Cell cell, Object value){
        if (value instanceof Date){
            cell.setCellValue(DateFormatUtils.format((Date)value,"YYYY-MM-dd"));
        } else if (value instanceof String){
            if (StringUtils.isBlank((String)value)){
                cell.setCellValue("");
            } else {
                cell.setCellValue((String)value);
            }
        } else if (value instanceof Integer){
            cell.setCellValue(((Integer)value).intValue());
        } else if (value instanceof Float){
            cell.setCellValue(((Float)value).floatValue());
        } else if (value instanceof Double){
            cell.setCellValue(((Double)value).doubleValue());
        }
    }

    public static String getStringFromCell(Row row, int index){
        if (row.getCell(index) == null) return "";
        Cell cell = row.getCell(index);
        switch(cell.getCellType()) {
            case NUMERIC:
                BigDecimal type = new BigDecimal(cell.getNumericCellValue());
                return type.toString().trim();
            default:
                cell.setCellType(CellType.STRING);
                return AsciiUtil.sbc2dbcCase(cell.getStringCellValue().trim());
        }
    }

    public static Date getDateFromCell(Row row, int index){
        if (row.getCell(index) == null)
            return null;
        return row.getCell(index).getDateCellValue();
    }

    public static BigDecimal getNumberFromCell(Row row, int index){
        if (row.getCell(index) == null) return BigDecimal.ZERO;
        Cell cell = row.getCell(index);
        return new BigDecimal(cell.getNumericCellValue());
    }
}
