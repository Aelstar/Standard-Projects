package testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import basics.Configs;

public class ExcelData extends Configs{

	public ExcelData() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public static Object[][] Ex_Data(String sheetName) throws IOException {
		
		
		File file=new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ReviewCode\\TestData\\Extractor Data.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		
		int rows= sheet.getLastRowNum();
		
	int cells=sheet.getRow(0).getLastCellNum();
	
	Object data[][] =new Object[rows][cells];
	
	for(int i=0; i<=rows; i++) {
		
		for (int j=0; j<=cells; j++) {
			
			data[i][j]=sheet.getRow(i).getCell(j).toString();
			
		}
	}
	return data;
	
	
	}
}
