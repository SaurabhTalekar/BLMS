package com.comcast.crm.generic.fileuility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheet, int row, int cell) throws Throwable {

		FileInputStream fis = new FileInputStream("./TestData/BLMSTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		wb.close();
		return data;
	}

	public int getRowCount(String sheet) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/BLMSTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int data = wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return data;
	}

	public void setDataToExcel(String sheet, int row, int cell) throws Throwable {

		FileInputStream fis = new FileInputStream("./TestData/BLMSTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell);

		FileOutputStream fos = new FileOutputStream("./TestData/BLMSTestData.xlsx");
		wb.write(fos);
		wb.close();
	}
}