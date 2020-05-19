package com.qa.ExcelManager;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.utils.Constants;

public class TestDataProvider {
	static org.apache.poi.ss.usermodel.Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	static  FileInputStream fis = null;
	
	public static Object[][] getTestData(String sheetname) throws Exception{
		try {
			fis = new FileInputStream(Constants.TESTDATA_DIR);
		} catch (Exception e) {
			throw new Exception("Please specify the correct Excel path!!");
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++){
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;	
		}
		
	}
	
