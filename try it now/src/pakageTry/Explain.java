package pakageTry;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Explain {

	public static Object[][] main(String[] args) throws Exception   {
		
		
		
		File file=new File("C:\\Users\\ahmed.abdelstar\\Desktop\\Extractor Data.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheetAt(0);
		
		String dataget= sheet.getRow(0).getCell(2).toString();
System.out.println(dataget);



int rows=sheet.getLastRowNum();
int columns=sheet.getRow(0).getLastCellNum();

Object data[][]=new Object[rows][columns];
for(int i=0; i<rows; i++) {
	for(int j=0; j<columns;j++) {
		data[i][j]=sheet.getRow(i).getCell(j).toString();
		
	}
}

System.out.println(data[2][2]);
return data;



	}

}
