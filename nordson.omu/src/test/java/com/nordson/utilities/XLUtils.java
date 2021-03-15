package com.nordson.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}

	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
			throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static int getColumnindex(String xlfile, String xlsheet, int rownum) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int colnum = cell.getColumnIndex();

		return colnum;

	}

	public static int getColumnindex(String xlfile, String xlsheet, String Colnm) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(0);
		int colnum = cell.getColumnIndex();

		return colnum;

	}

	public static List<String> getCellDataColindx(String xlfile, String xlsheet, int rownum, int colnum)
			throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);

		List<String> UIlabl = new ArrayList<String>();

		if (colnum != 0) {
			for (Row row : ws) {
				Cell c = row.getCell(colnum);
				CellType ctype = c.getCellType();

				if (c != null && ctype != CellType.BLANK && ctype == CellType.STRING) {
					String cllvalue = c.getStringCellValue();
					System.out.println(cllvalue);
					UIlabl.add(cllvalue);

				}

				else if (c != null && ctype != CellType.BLANK && ctype == CellType.NUMERIC) {
					double cllvalue = c.getNumericCellValue();
					UIlabl.add(String.valueOf(cllvalue));
				}
			}

		}

		return UIlabl;

	}

	public static int getrowindex(String xlfile, String xlsheet, String UIfild) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rwindx = 0;
		for (Row row : ws) {
			for (Cell cell : row) {
				CellType ctype = cell.getCellType();

				if (ctype == CellType.STRING) {
					if (cell.getStringCellValue().equals(UIfild)) {

						rwindx = row.getRowNum();
						System.out.println(rwindx);
					}

				}
			}

		}
		return rwindx;

	}

}