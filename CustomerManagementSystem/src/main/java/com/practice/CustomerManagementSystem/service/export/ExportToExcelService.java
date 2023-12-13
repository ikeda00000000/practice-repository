package com.practice.CustomerManagementSystem.service.export;

import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExportToExcelService {
	public void exportWorkbook(OutputStream outputStream) {
		// xlsx形式のブックの生成
		XSSFWorkbook wb = new XSSFWorkbook();
		// sheetの作成
		XSSFSheet sheet = wb.createSheet();
		// 行・セルの生成
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);

		try {
			cell.setCellValue("テスト出力");
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
}