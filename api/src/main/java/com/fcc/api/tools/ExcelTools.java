package com.fcc.api.tools;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description: excel工具类
 * @Author: CC.F
 * @Date: 11:56 2018/8/10
 */
public class ExcelTools {

    /**
     * 获取单元格值
     * @param cell
     * @return
     */
    public static String getExcelCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }


    /**
     * 导出excel文件
     * @param request
     * @param response
     * @param fileName 文件名
     * @param colNum 列数
     * @param list 数据集合
     * @param fieldNameStrs 对应字段
     * @param titles 字段对应的中文
     * @param <T>
     * @throws Exception
     */
    public static <T> void exportExcel(HttpServletRequest request, HttpServletResponse response, String fileName, int colNum, List<T> list, List<String> fieldNameStrs, String[] titles) throws Exception {
        //创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(fileName);
        //在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        //设置默认列宽
        sheet.setDefaultColumnWidth(20);

        for (int j = 0; j < list.size(); j++) {
            HSSFRow row3 = sheet.createRow(j);
            for (int k = 0; k < fieldNameStrs.size(); k++) {
                String fieldName = fieldNameStrs.get(k);
                HSSFCell cell1 = row3.createCell(k);
                Field field = null;
                Class<?> clazz = list.get(j).getClass();
                try {
                    field = clazz.getDeclaredField(fieldName);
                } catch (Exception e) {
                }
                if (field == null) {
                    Method m = list.get(j).getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
                    String value = "";
                    try {
                        value = m.invoke(list.get(j)).toString();
                    } catch (Exception e) {
                    }
                    cell1.setCellValue(value);
                } else {
                    field.setAccessible(true);
                    Object obj = field.get(list.get(j));
                    cell1.setCellValue(obj == null ? "" : obj.toString());
                }
            }
        }

        //输出Excel文件
        OutputStream output = response.getOutputStream();
        response.reset();
        String agent = request.getHeader("USER-AGENT").toLowerCase();
        String encodeFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        if (agent.contains("firefox")) {
            //firefox
            response.setCharacterEncoding("utf-8");
            response.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
        } else {
            response.setHeader("content-disposition", "attachment;filename=" + encodeFileName + ".xls");
        }
        response.setContentType("application/ms-excel");
        wb.write(output);
        output.close();
    }


}
