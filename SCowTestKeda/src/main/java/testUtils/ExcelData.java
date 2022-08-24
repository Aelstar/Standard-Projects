package testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData {
	
	
	
	public static Object[][] Excel(String Sheetname) throws IOException {
		
		
		
		File file=new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\SCowTestKeda\\TestData\\Extractor Data.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		Sheet sheet=workbook.getSheet(Sheetname);
		
		int rows=sheet.getLastRowNum();
		
		int cells=sheet.getRow(0).getLastCellNum();
		
		Object getData[][]=new Object[rows][cells];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cells; j++) {
				
				getData[i][j]=sheet.getRow(i).getCell(j).toString();
				
			}
		}
		return getData;
		
	}
	
	@DataProvider
	public Object[][] readFromExcel() throws IOException {
		
		Object ReadExcelData[][]=ExcelData.Excel("Sheet1");
		
		return ReadExcelData;
		
	}

}
