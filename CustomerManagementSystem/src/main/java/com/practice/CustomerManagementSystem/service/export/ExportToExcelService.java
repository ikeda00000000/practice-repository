package com.practice.CustomerManagementSystem.service.export;

import java.io.OutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.practice.CustomerManagementSystem.entity.Case;

@Service
public class ExportToExcelService {
	public void exportWorkbook(OutputStream outputStream,Case oneCase) {
		// xlsx形式のブックの生成
		XSSFWorkbook wb = new XSSFWorkbook();
		// sheetの作成
		XSSFSheet sheet = wb.createSheet();
		// 行・セルの生成
		Row row1 = sheet.createRow(1);
		Cell cell1_1 = row1.createCell(1);
		Cell cell1_2 = row1.createCell(2);
		cell1_1.setCellValue("印刷日時");
		cell1_2.setCellValue(new Date());
		// cell1_2の書式を日付型に設定
		formatCellStyle(wb,cell1_2);
		
		Row row2 = sheet.createRow(2);
		Cell cell2_1 = row2.createCell(1);
		cell2_1.setCellValue("顧客情報");
		
		Row row3 = sheet.createRow(3);
		Cell cell3_1 = row3.createCell(1);
		Cell cell3_2 = row3.createCell(2);
		cell3_1.setCellValue("顧客ID");
		cell3_2.setCellValue(oneCase.getCustomerId());
		
		Row row4 = sheet.createRow(4);
		Cell cell4_1 = row4.createCell(1);
		Cell cell4_2 = row4.createCell(2);
		cell4_1.setCellValue("顧客名");
		cell4_2.setCellValue(oneCase.getCustomer().getCustomerName());
		
		Row row5 = sheet.createRow(5);
		Cell cell5_1 = row5.createCell(1);
		cell5_1.setCellValue("ケース情報");
		
		Row row6 = sheet.createRow(6);
		Cell cell6_1 = row6.createCell(1);
		Cell cell6_2 = row6.createCell(2);
		cell6_1.setCellValue("ケース作成日");
		cell6_2.setCellValue(oneCase.getCaseDate());
		// cell6_2の書式を日付型に設定
		formatCellStyle(wb,cell6_2);
		
		Row row7 = sheet.createRow(7);
		Cell cell7_1 = row7.createCell(1);
		Cell cell7_2 = row7.createCell(2);
		cell7_1.setCellValue("ケース作成者");
		cell7_2.setCellValue(oneCase.getAccount().getUsername());
		
		Row row8 = sheet.createRow(8);
		Cell cell8_1 = row8.createCell(1);
		Cell cell8_2 = row8.createCell(2);
		cell8_1.setCellValue("タイトル");
		cell8_2.setCellValue(oneCase.getTitle());
		
		Row row9 = sheet.createRow(9);
		Cell cell9_1 = row9.createCell(1);
		Cell cell9_2 = row9.createCell(2);
		cell9_1.setCellValue("内容");
		cell9_2.setCellValue(oneCase.getContent());
		
		try {
			wb.write(outputStream);
		} catch (Exception e) {
			 e.printStackTrace();
		} finally {
			try {
				wb.close();
			} catch (Exception e) {
				 e.printStackTrace();
			}
		}
	}
	
	// cellを日付型の書式に設定する
	public void formatCellStyle(XSSFWorkbook wb, Cell cell) {
		XSSFCreationHelper createHelper = wb.getCreationHelper();
		XSSFCellStyle cellStyle = wb.createCellStyle();
		short style = createHelper.createDataFormat().getFormat("yyyy/mm/dd h:mm");
		cellStyle.setDataFormat(style);
		cell.setCellStyle(cellStyle);
	}
}