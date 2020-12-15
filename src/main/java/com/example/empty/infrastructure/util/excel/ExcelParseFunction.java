package com.example.empty.infrastructure.util.excel;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

@FunctionalInterface
public interface ExcelParseFunction<T> {
    public List<T> dealData(Sheet sheet) throws Exception;
}
