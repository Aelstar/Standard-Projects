package adminConfig;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	
	
	public static Object[][] getExcel(String sheetName) throws IOException {
		
		
	File file=new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\GAEB.AdminPanel\\TestData\\Extractor Data.xlsx");
	FileInputStream fis=new FileInputStream(file);
	
	
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		
		String checkexcel=sheet.getRow(2).getCell(2).toString();
		System.out.println(checkexcel);
		
		int rows= sheet.getLastRowNum();
		int columns=sheet.getRow(0).getLastCellNum();
		
		
		Object [][]data =new Object[rows][columns];
		for (int i=0; i<rows; i++) {
			for(int j=0;j<columns;j++) {
				
				data[i][j]=sheet.getRow(i).getCell(j).toString();
				
				
			}
			
		}
		
		return data;
		
	}
	
	
	
}
