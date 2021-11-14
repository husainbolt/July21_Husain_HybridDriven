package com.technocredits.orangehrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	static final public Object[][] getData(String filePath, String sheetName) throws IOException {

		File file = new File(filePath);
		FileInputStream input = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(input);
		Sheet sheet = wb.getSheet(sheetName);

		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[totalRows][totalColumns];

		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			for (int columnIndex = 0; columnIndex < totalColumns; columnIndex++) {
				Cell cell = sheet.getRow(rowIndex).getCell(columnIndex);
				if (CellType.NUMERIC == cell.getCellType())
					data[rowIndex - 1][columnIndex] = String.valueOf(cell.getNumericCellValue());
				else if(CellType.STRING==cell.getCellType())
					data[rowIndex - 1][columnIndex] = cell.getStringCellValue();
				else if(CellType.BOOLEAN==cell.getCellType())
					data[rowIndex - 1][columnIndex] = String.valueOf(cell.getBooleanCellValue());
			}
		}

		return data;

	}

}
