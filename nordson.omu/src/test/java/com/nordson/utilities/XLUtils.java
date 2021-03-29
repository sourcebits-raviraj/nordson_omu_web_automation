package com.nordson.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String sheetNm;
<<<<<<< HEAD

=======
	
	
public static void setExcelSheetNm(String SheetName) {
		
		XLUtils.sheetNm=SheetName;
		
	}
	
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7
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

<<<<<<< HEAD
	@DataProvider(name = "PressureValuesMinMax0_0")
	public static String[][] getData_0_0() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";
=======
	
	@DataProvider(name = "GlobalPointValues_Celsius")
	public static String[][] getDataGP_Celsius() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
<<<<<<< HEAD
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
=======
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

			}

		}
<<<<<<< HEAD
		return pressuredata;
	}

	@DataProvider(name = "PressureValuesMinMax_0_691")
	public static String[][] getDataZero_Max_Value_691() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";
=======
		return tempdata;
	}
	
	
	@DataProvider(name = "GlobalPointValues_Farnhenit")
	public static String[][] getDataGP_Farnheit() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
<<<<<<< HEAD
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
=======
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

			}

		}
<<<<<<< HEAD
		return pressuredata;
	}

	@DataProvider(name = "PressureValuesMinMax_0_690")
	public static String[][] getDataZero_Max_Value_690() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";
=======
		return tempdata;
	}
	
	@DataProvider(name = "TankPointValues_Celsius")
	public static String[][] getDataTP_Celsius() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
<<<<<<< HEAD
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
=======
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

			}

		}
<<<<<<< HEAD
		return pressuredata;
	}

	@DataProvider(name = "PressureValues_BAR_MinMax_7_7")
	public static String[][] getData_BAR_Max_Value_7_7() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";
=======
		return tempdata;
	}
	
	
	@DataProvider(name = "TankPointValues_Farnhenit")
	public static String[][] getDataTP_Farnheit() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
<<<<<<< HEAD
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
=======
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

			}

		}
<<<<<<< HEAD
		return pressuredata;

	}

	@DataProvider(name = "PressureValuesMinMax_1.9_2")
	public static String[][] getData_BAR_Max_Value_19_2() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";
=======
		return tempdata;
	}
	
	
	@DataProvider(name = "HoseAppPointValues_Celsius")
	public static String[][] getDataHAP_Celsius() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
<<<<<<< HEAD
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
=======
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

			}

		}
<<<<<<< HEAD
		return pressuredata;
	}

	@DataProvider(name = "PressureValues_MinMax_0_6.9")
	public static String[][] getData_BAR_Max_Value_0_69() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";
=======
		return tempdata;
	}
	
	
	@DataProvider(name = "HoseAppPointValues_Farnhenit")
	public static String[][] getDataHAP_Farnheit() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
<<<<<<< HEAD
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
=======
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

			}

		}
<<<<<<< HEAD
		return pressuredata;
	}

	@DataProvider(name = "PressureValues_PSI_MinMax_50_51")
	public static String[][] getData_PSI_Max_Value_50_51() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";
=======
		return tempdata;
	}
	
	@DataProvider(name = "OTTValues_Celsius")
	public static String[][] getDataOTT_Celsius() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return tempdata;
	}
	
	@DataProvider(name = "OTTValues_Farnheit")
	public static String[][] getDataOTT_Farnheit() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
<<<<<<< HEAD
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
=======
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

			}

		}
<<<<<<< HEAD
		return pressuredata;
	}

	@DataProvider(name = "PressureValues_PSI_MinMax_0_101")
	public static String[][] getData_PSI_Max_Value_0_101() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";
=======
		return tempdata;
	}
	
	
	@DataProvider(name = "UTTValues_Celsius")
	public static String[][] getDataUTT_Celsius() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return tempdata;
	}
	
	@DataProvider(name = "UTTValues_Farnheit")
	public static String[][] getDataTT_Farnheit() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
<<<<<<< HEAD
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
=======
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

			}

		}
<<<<<<< HEAD
		return pressuredata;
	}

	@DataProvider(name = "PressureValues_PSI_MinMax_0_100")
	public static String[][] getData_PSI_Max_Value_0_100() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";
=======
		return tempdata;
	}
	
	

	@DataProvider(name = "TempstbckValues_Celsius")
	public static String[][] getDataTempstbck_Celsius() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
<<<<<<< HEAD
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
=======
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7

			}

		}
<<<<<<< HEAD
		return pressuredata;
	}

	// @DataProvider(name = "CellValues")
	public static String getDataMinCellValues() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/MDS.xlsx";

		// int rownum = XLUtils.getRowCount(path, sheetNm);
		// int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		// int colcnt = colcount - 1;

		String cellmin = XLUtils.getCellData(path, sheetNm, 21, 14);
		System.out.println("CellMin data is" + cellmin);
		// System.out.println("No of Rows= " + rownum);
		// System.out.println("No of Columns= " + colcnt);
		// String pressuredata[][] = new String[rownum][colcnt];
		/*
		 * for (int i = 1; i <= rownum; i++) { for (int j = 1; j <= colcnt; j++) {
		 * pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
		 * 
		 * }
		 * 
		 * } return pressuredata;
		 */
		return cellmin;
	}

	public static String getDataMaxCellValues() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/MDS.xlsx";

		// int rownum = XLUtils.getRowCount(path, sheetNm);
		// int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		// int colcnt = colcount - 1;

		String cellmax = XLUtils.getCellData(path, sheetNm, 21, 15);
		System.out.println("CellMax data is" + cellmax);
		// System.out.println("No of Rows= " + rownum);
		// System.out.println("No of Columns= " + colcnt);
		// String pressuredata[][] = new String[rownum][colcnt];
		/*
		 * for (int i = 1; i <= rownum; i++) { for (int j = 1; j <= colcnt; j++) {
		 * pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1
		 * 
		 * }
		 * 
		 * } return pressuredata;
		 */
		return cellmax;
	}

	public static void setExcelSheetNm(String SheetName) {

		XLUtils.sheetNm = SheetName;

	}

	@DataProvider(name = "MDS FILEs")
	public static XSSFCell getDatamds1() throws IOException

	{

		File file = new File("C:\\Users\\Ravi Raj\\Documents\\MDS.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(1);
		Row row = sheet.getRow(6);
		Cell cell = row.getCell(13);
		XSSFCell amds = sheet.getRow(6).getCell(16);
		System.out.println(sheet.getRow(6).getCell(16));
		return amds;
	}

=======
		return tempdata;
	}
	
	

	@DataProvider(name = "TempstbckValues_Farnheit")
	public static String[][] getDataTempstbck_Farnheit() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return tempdata;
	}
>>>>>>> e9ac0448e900171654437682e656fb2495cf03f7
}