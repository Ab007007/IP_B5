
package com.learning.basics.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReaderDemo {
	static String fileLocation ="data/actitimetestdata.xls";
	static File file = null;
	static FileInputStream fis  = null;
	static Workbook wb = null;
	static Sheet sh = null;
	static Row row =null;
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		printExcelCellValue();
	}
	
	public static void printExcelCellValue() throws EncryptedDocumentException, IOException
	{
		File file = new File(fileLocation);
		FileInputStream fis = new FileInputStream(file);
		
		wb =  WorkbookFactory.create(fis);
		
		int totalSheets = wb.getNumberOfSheets();
		System.out.println("total sheets in excel : " + totalSheets);
		
		for (int i = 0; i < totalSheets; i++) 
		{
			System.out.println(wb.getSheetName(i));
		}
		
		
		sh = wb.getSheet("junksheet");
		
		int rowCount = sh.getLastRowNum()+1;
		System.out.println(rowCount);
		
		for (int i = 0; i < rowCount; i++) 
		{
			row  =  sh.getRow(i);
			
			Cell cell1 = row.getCell(0);
			
		//	System.out.println(" | " + cell1 + " | "  + cell1.getCellType());
			
		//System.out.println(getMyCellValue(cell1));
		Cell cell2 = row.createCell(1);
		cell2.setCellValue("PASS");
		}
		fis.close();
		
		FileOutputStream fos =  new FileOutputStream(fileLocation);
		wb.write(fos);
		
		fos.close();
		
		
	}

}
