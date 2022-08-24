package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import configrations.BaseTest;

public class Excel extends BaseTest{

	public Excel() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public static Object[][] ExelReader(String SheetName) throws IOException {
		
		File Excelfile=new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\CCOwPayTe\\TestsIn\\Extractor Data.xlsx");
		FileInputStream fis=new FileInputStream(Excelfile);
		
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		
		Sheet sheet=workbook.getSheet( SheetName);
		
		int Rows= sheet.getLastRowNum();
		
				int Columns=sheet.getRow(0).getLastCellNum();
				
				Object excel[][]=new Object[Rows][Columns];
				
				for(int i=0; i<Rows; i++) {
					for (int j=0; j<Columns; j++) {
						excel[i][j]=sheet.getRow(i).getCell(j).toString();
						
					}
				}
				
				return excel;
	}
	
}
