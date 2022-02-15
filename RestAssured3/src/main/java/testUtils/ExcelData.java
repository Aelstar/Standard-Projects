package testUtils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	
	public static Object[][] get_Data(String sheetName ) throws IOException {
		
		
		
		File file=new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\RestAssured3\\TestData\\Extractor Data.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		
				int rows=sheet.getLastRowNum();
				int columns=sheet.getRow(1).getLastCellNum();
		Object ExcelData[][]=new Object[rows][columns]	;	
				for (int i=0; i<rows;i++) {
					
					for (int j=0; j<columns;j++) {
						
						ExcelData[i][j]=sheet.getRow(i).getCell(j).toString();
						
					}
				}
				return ExcelData;
				
	}
}
