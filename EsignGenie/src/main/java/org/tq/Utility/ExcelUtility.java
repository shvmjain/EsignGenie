package org.tq.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility
{
	public String excelpath; //=".\\test-data\\Sample_Project-Data.xlsx";
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	public Workbook wb;
	Row row;
	
	public ExcelUtility(String excelpath){
		this.excelpath = excelpath;
		try {
			file = new File(excelpath);
			fis = new FileInputStream(file);
			wb = WorkbookFactory.create(fis);
			wb.getSheetAt(0);
			fis.close();
		} 
		catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	
	// returns the row count in a sheet
	
	public int getRowCount(String name) {
		
		int index = wb.getSheetIndex(name);
		if(index==-1) {
			return 0;
		}else {
			Sheet sheet = wb.getSheet(name);
			int rownum = sheet.getLastRowNum()+1;
			return rownum;
		}
	}
	
	
	public int getColCount(String sheetName) {
		Sheet sheet = wb.getSheet(sheetName);
		if(!isSheetExist(sheetName))
			return -1;
		
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
		return -1;
		
		return row.getLastCellNum();
	}
	
	
	// returns true if sheet is created successfully else false
	
	public boolean addSheet(String sheetname) {
		try {
			fos = new FileOutputStream(file);
			wb.createSheet(sheetname);
			wb.write(fos);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// returns true if sheet is removed successfully else false if sheet does not exist
	
	public boolean removeSheet(String sheetName) {
		
		int index = wb.getSheetIndex(sheetName);
		if(index==-1)
		return false;
		
		try {
			wb.removeSheetAt(index);
			fos = new FileOutputStream(file);
			wb.write(fos);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// find whether sheets exists
	
	public boolean isSheetExist(String sheetName) {
		int index = wb.getSheetIndex(sheetName);
		if(index == -1) {
			index = wb.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		}
		else {
			return true;	
		}
	}


//	public String getCellData(String sheetName, int colNum, int rowNum) {
//		try {
//			if (rowNum <= 0)
//				return "";
//
//			int index = workbook.getSheetIndex(sheetName);
//
//			if (index == -1)
//				return "";
//
//			sheet = workbook.getSheetAt(index);
//			row = sheet.getRow(rowNum - 1);
//			if (row == null)
//				return "";
//			cell = row.getCell(colNum);
//			if (cell == null)
//				return "";
//
//			//
//			if (cell.getCellType().name().equals("STRING"))
//				return cell.getStringCellValue();
//
//			//
//			// if (cell.getCellType().STRING != null)
//			// return cell.getStringCellValue();
//			else if ((cell.getCellType().name().equals("NUMERIC")) || (cell.getCellType().name().equals("FORMULA"))) {
//
//				String cellText = String.valueOf(cell.getNumericCellValue());
//				if (HSSFDateUtil.isCellDateFormatted(cell)) {
//					// format in form of M/D/YY
//					double d = cell.getNumericCellValue();
//
//					Calendar cal = Calendar.getInstance();
//					cal.setTime(HSSFDateUtil.getJavaDate(d));
//					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
//					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
//
//					// System.out.println(cellText);
//
//				}
//
//				return cellText;
//			} else if (cell.getCellType().BLANK != null)
//				return "";
//			else
//				return String.valueOf(cell.getBooleanCellValue());
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
//		}
//	}

}
