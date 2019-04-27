package com.learning.basics.utils;

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

public class ExcelUtils {

	static String fileLocation ="data/actitimetestdata.xls";
	static File file = null;
	static FileInputStream fis  = null;
	static Workbook wb = null;
	static Sheet sh = null;
	static Row row =null;
		
	public static String getMyCellValue(String sheetName, int rowNumber, int columnNumber) throws EncryptedDocumentException, IOException
	{
		wb = getMyWorkBookObj();
		sh = wb.getSheet(sheetName);
		Cell cell = sh.getRow(rowNumber).getCell(columnNumber);
		
		return getMyCellValue(cell);
	}
	
	public static int getMyRowCount(String sheetName)
	{
		int rowCount=0;
		try
		{
			getMyWorkBookObj();
			rowCount = wb.getSheet(sheetName).getLastRowNum()+1;
			
		}
		catch(Exception ex )
		{
			System.out.println("error while reading excel file");
		}
		finally
		{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowCount;
		
	
	}
	
	public static Workbook getMyWorkBookObj() throws EncryptedDocumentException, IOException
	{
		System.out.println("Creating a workbook object....");
		file = new File("data/actitimetestdata.xls");
		fis = new FileInputStream(file);
		
		wb =  WorkbookFactory.create(fis);
		
		return wb;
		
	}
	
	public static String getMyCellValue(Cell cell)
	{
		String str = null;
		switch (cell.getCellType().toString()) {
		case "NUMERIC":
			str = String.valueOf(cell.getNumericCellValue());
			break;
		case "STRING":
			str = cell.getStringCellValue();
			break;
		case "FORMULA":
			str = String.valueOf(cell.getCellFormula());
			break;
		case "BOOLEAN":
			str = String.valueOf(cell.getBooleanCellValue());
			break;

		default:
			str = null;
			System.out.println("Please contact Framework developers for a new data type in excel");
			break;
		}
		System.out.println("Cell Value in Excel is " + str);
		return str;
	}
	
	
	}
