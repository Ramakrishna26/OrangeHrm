package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class ExcelFileUtils 
{
	Workbook wb;
	CellStyle style;
	Font font;
	
	public ExcelFileUtils() throws Exception
	{
		FileInputStream fis = new FileInputStream("./TestInputsheet/InputSheet.xlsx");
		wb = WorkbookFactory.create(fis);
	}
	
	public int getRowCount(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum();
	}
	
	public int getColumnCount(String sheetname, int rowno)
	{
		return wb.getSheet(sheetname).getRow(rowno).getLastCellNum();
	}
	
	public String getData(String sheetname, int rowno, int colno)
	{
		String data = "";
		
		if(wb.getSheet(sheetname).getRow(rowno).getCell(colno).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int celldata=(int)wb.getSheet(sheetname).getRow(rowno).getCell(colno).getNumericCellValue();
			
			 data = String.valueOf(celldata);
		}
		else
		{
			wb.getSheet(sheetname).getRow(rowno).getCell(colno).getStringCellValue();
		}
		
		return data;
	}
	
	public void setCellData(String sheetname, int rowno, int colno, String data) throws Exception
	{
		Sheet sheet = wb.getSheet(sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.createCell(colno);
		cell.setCellValue(data);
		if (data.equalsIgnoreCase("PASS")) 
		{
			style = wb.createCellStyle();
			font = wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			row.getCell(colno).setCellStyle(style);
		}
		if (data.equalsIgnoreCase("FAIL")) 
		{
			style = wb.createCellStyle();
			font = wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			row.getCell(colno).setCellStyle(style);
		}
		if (data.equalsIgnoreCase("NOTEXECUTED")) 
		{
			style = wb.createCellStyle();
			font = wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			row.getCell(colno).setCellStyle(style);
		}
		
		FileOutputStream fos = new FileOutputStream("./TestOutputSheet/TestOutput.xlsx");
		wb.write(fos);
		wb.close();
		}
}



