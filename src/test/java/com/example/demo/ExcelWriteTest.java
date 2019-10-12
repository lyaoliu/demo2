package com.example.demo;

import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Test;
import com.alibaba.excel.ExcelWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ExcelWriteTest class
 *
 * @author lyliu
 * @date 2019/07/08 14:23
 */
public class ExcelWriteTest {

    @Test
    public void writeWithoutHead() throws IOException {
        try (OutputStream out = new FileOutputStream("F://withHead.xlsx");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet=new Sheet(1);
            sheet.setSheetName("sheet1");
            List<List<String>> data = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                List<String> item = new ArrayList<>();
                item.add("item0" + i);
                item.add("item1" + i);
                item.add("item2" + i);
                data.add(item);
            }
            List<List<String>> head = new ArrayList<List<String>>();
            List<String> headCoulumn1 = new ArrayList<String>();
            List<String> headCoulumn2 = new ArrayList<String>();
            List<String> headCoulumn3 = new ArrayList<String>();
            headCoulumn1.add("第一列");
            headCoulumn2.add("第二列");
            headCoulumn3.add("第三列");
            head.add(headCoulumn1);
            head.add(headCoulumn2);
            head.add(headCoulumn3);
            Table table = new Table(1);
            TableStyle style=new TableStyle();
            style.setTableContentBackGroundColor(IndexedColors.WHITE);

            //定义Excel正文字体大小
            Font font=new Font();
            font.setFontHeightInPoints((short) 10);
            font.setFontName("华文隶书");
            style.setTableContentFont(font);
            table.setHead(head);
            table.setTableStyle(style);
            writer.write0(data, sheet, table);
            writer.finish();
        }
    }
}
