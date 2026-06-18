package data_driven_testing_DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

		public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception {
			
			FileInputStream fis=new FileInputStream("./testdata/testScript5.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
			wb.close();
			return data;
		}
		
		//2nd method here we returning ROW Count
		public int getRowCount (String SheetName) throws Throwable {//its returns int type so i changed rt from void to (rowcount)"INT "
			
			FileInputStream fis=new FileInputStream("./testdata/testScript5.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			 int rowNum = wb.getSheet(SheetName).getLastRowNum();
			 wb.close();
			 return rowNum;
		}
		
		 //3rd Method write data back to excel
		public void setDataIntoExcel (String sheetName , int rowNum , int cellNum , String data) throws Throwable {
			FileInputStream fis=new FileInputStream("./testdata/testScript5.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
			
			//open excel in write mode
			FileOutputStream fos=new FileOutputStream("./testdata/testScript5.xlsx");
			wb.write(fos);//save o/p
			wb.close();
		}
	}
