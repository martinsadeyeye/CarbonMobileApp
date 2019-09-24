package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFWorkbook excelWBook;
	private static XSSFSheet excelWSheet;
	private static XSSFCell cell;
	private static XSSFRow row;
	
	//This method is to get the row count in a sheet
	public int getRowCount(String sheetName){
		int index = excelWBook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else {
			excelWSheet = excelWBook.getSheetAt(index);
			int number = excelWSheet.getLastRowNum() + 1;
			return number;
		}
		
	}
	
	public static void setExcelFile(String path) throws Exception {
		// Open the Excel file
		try {
			FileInputStream excelFile = new FileInputStream(path);
			excelWBook = new XSSFWorkbook(excelFile);
		} catch (Exception e) {
			throw (e);
		}
	}
	
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	public static void setExcelSheet(String path, String sheetName) throws Exception {
		try {
			setExcelFile(path);
			// Access the required test data sheet
			excelWSheet = excelWBook.getSheet(sheetName);
		} catch (Exception e){
			throw (e);
		}
	}
	
	
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
    public static String getCellData(int rowNum, int colNum) throws Exception{
		try {
			cell = excelWSheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			return"";
		}

    }
    
    
    //This method is to write in the Excel cell, Row num and Col num are the parameters
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception	{
		try{
			row  = excelWSheet.getRow(RowNum);
			cell = row.getCell(ColNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			
			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellValue(Result);
			} else {
				cell.setCellValue(Result);
			}
	
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Constant.path_TestData + Constant.file_TestData);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}
	
	//Run as standalone
	public static void main(String arg[]) throws Exception{
		//System.out.println(filename);
		setExcelFile(Constant.path_TestData + Constant.file_TestData);
	}
}
