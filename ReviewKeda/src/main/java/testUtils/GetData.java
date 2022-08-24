package testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import basics.Configs;

public class GetData extends Configs{

	public GetData() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public static Object[][] read_Data(String sheetname) throws IOException {
		
		File file=new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ReviewKeda\\testData\\Extractor Data.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	Sheet sheet=workbook.getSheet(sheetname);
	
	int rows=sheet.getLastRowNum();
	int columns=sheet.getRow(0).getLastCellNum();
	
	//System.out.println(sheet.getRow(1).getCell(2).toString());
	
	Object Edata[][] =new Object[rows][columns];
	
	for(int i=0; i<rows; i++) {
		
		for (int j=0; j<columns; j++) {
			
			Edata[i][j]=sheet.getRow(i).getCell(j).toString();
			
		}
		
	}
	
	return Edata;
	
	
		
	}
}
