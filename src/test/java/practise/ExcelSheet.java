
package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
	XSSFWorkbook workbook ;
	XSSFSheet sheet ;
	public ExcelSheet(String filePath ) throws IOException {
		File f = new File(filePath);
		System.out.println(f.exists());
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
	}
	public int getDataFromSheet(int indexNumber , int row ,int cell) {
		return workbook.getSheetAt(0).getLastRowNum();
		
	
	}

//	public static void main(String[] args) throws IOException {
//
//		// path of the excel sheet
//		File f = new File("C:\\Users\\Dell\\OneDrive\\Desktop\\TestData.xlsx");
//		// this line used to , to find this file present in the device or not ?
//		System.out.println(f.exists());
//		// access for reading the current excel sheet
//		FileInputStream fis = new FileInputStream(f);
//		// load the workbook sheets in class
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		// focus on specific worksheet in workbook bye index position or by name
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		int rows = sheet.getLastRowNum();
//		System.out.println(rows);
//
//		
//		for(int i=1 ; i<rows ;i++)
//		{
//			String uname = sheet.getRow(i).getCell(0).getStringCellValue();
//			
//			String pass = sheet.getRow(i).getCell(1).getStringCellValue();
//			System.out.println(uname + "  " + pass);
//		}
//	}

}
