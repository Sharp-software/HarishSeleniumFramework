package com.qa.ExcelManager;

import java.util.Hashtable;

import com.qa.utils.Constants;
import com.qa.utils.ReadProperty;

public class TestDataLoader {
	
	public static synchronized Hashtable<String, String> getLocalizedData(String excelFileName, String sheetName, String language) {
		ExcelReader excel = new ExcelReader(excelFileName);
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Hashtable<String,String> table = new Hashtable<String,String>();
		
		for(int cNum=1; cNum<cols; cNum++){
			String langName = excel.getCellData(sheetName, cNum, 1);

			if(langName.equalsIgnoreCase(language)){
				for(int rNum=2; rNum<=rows;rNum++){
					String cellData  = excel.getCellData(sheetName, cNum, rNum).replace("â€™", "'");
					String stringID = excel.getCellData(sheetName, 0, rNum);
					table.put(stringID, cellData);
				}
				break;
			}
		}
		return table;
	}
	
	/*public static String getLocString(String Key){
		String excelFileName = Constants.TESTDATA_DIR;
		String sheetName = ReadProperty.getProperty("Sheetname");
		String language = ReadProperty.getProperty("Languagename");
		Hashtable<String, String> ht =getLocalizedData(excelFileName, sheetName, language);
		String retvalue = ht.get(Key);
		return retvalue;
	}
	
	public static void main(String[] args) {
		System.out.println(getLocString("UserName"));
		System.out.println(getLocString("Pwd"));
	}
	*/

}
