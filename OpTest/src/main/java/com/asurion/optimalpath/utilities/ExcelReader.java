package com.asurion.optimalpath.utilities;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelReader {

	static ReadPropertiesFile prop = new ReadPropertiesFile();
	Logger log = Logger.getLogger(ExcelReader.class);

	static FileInputStream fis = null;

	public FileInputStream getFileInputStream() throws FileNotFoundException {

		String filepath = prop.ReadPropertiesFileByKey("filepath");
		File srcfile = new File(filepath);
		try {
			fis = new FileInputStream(srcfile);
		} catch (FileNotFoundException e) {

			log.fatal("TestData File is not found. terminating process !!! Check Configuration file for file path of TestData file");
			System.exit(0);
		}
		return fis;
	}

	public Object[][] getExceData() throws Exception {
		fis = getFileInputStream();

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		int TotalNumberOfRows = (sheet.getLastRowNum() + 1);
		int TotalNumberOfCols = 2;

		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];

		for (int i = 0; i < TotalNumberOfRows; i++) {
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);

				// String cellData = row.getCell(j).toString();
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;

	}

}