package com.nordson.utilities;

import java.io.File;
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
import org.testng.annotations.DataProvider;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String sheetNm;

	public static void setExcelSheetNm(String SheetName) {

		XLUtils.sheetNm = SheetName;

	}

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

	public static int getColumnindexnum(String xlfile, String xlsheet, int rownum) throws IOException {
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
		int colindx = 0;
		for (Cell cell : row) {
			if (cell.getStringCellValue().equalsIgnoreCase(Colnm))
				colindx = cell.getColumnIndex();
		}
		return colindx;
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

					}

				}
			}

		}
		return rwindx;

	}

	@DataProvider(name = "GlobalPointValues_Celsius")
	public static String[][] getDataGP_Celsius() throws IOException {
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

	@DataProvider(name = "GlobalPointValues_Farnhenit")
	public static String[][] getDataGP_Farnheit() throws IOException {
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

	@DataProvider(name = "TankPointValues_Celsius")
	public static String[][] getDataTP_Celsius() throws IOException {
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

	@DataProvider(name = "TankPointValues_Farnhenit")
	public static String[][] getDataTP_Farnheit() throws IOException {
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

	@DataProvider(name = "HoseAppPointValues_Celsius")
	public static String[][] getDataHAP_Celsius() throws IOException {
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

	@DataProvider(name = "HoseAppPointValues_Farnhenit")
	public static String[][] getDataHAP_Farnheit() throws IOException {
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

	@DataProvider(name = "TempstbckValues_Celsius")
	public static String[][] getDataTempstbck_Celsius() throws IOException {
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

	@DataProvider(name = "PressureValuesMinMax0_0")
	public static String[][] getData_0_0() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return pressuredata;
	}

	@DataProvider(name = "PressureValuesMinMax_0_691")
	public static String[][] getDataZero_Max_Value_691() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return pressuredata;
	}

	@DataProvider(name = "PressureValuesMinMax_0_690")
	public static String[][] getDataZero_Max_Value_690() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return pressuredata;
	}

	@DataProvider(name = "PressureValues_BAR_MinMax_7_7")
	public static String[][] getData_BAR_Max_Value_7_7() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return pressuredata;

	}

	@DataProvider(name = "PressureValuesMinMax_1.9_2")
	public static String[][] getData_BAR_Max_Value_19_2() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return pressuredata;
	}

	@DataProvider(name = "PressureValues_MinMax_0_6.9")
	public static String[][] getData_BAR_Max_Value_0_69() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return pressuredata;
	}

	@DataProvider(name = "PressureValues_PSI_MinMax_50_51")
	public static String[][] getData_PSI_Max_Value_50_51() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return pressuredata;
	}

	@DataProvider(name = "PressureValues_PSI_MinMax_0_101")
	public static String[][] getData_PSI_Max_Value_0_101() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return pressuredata;
	}

	@DataProvider(name = "PressureValues_PSI_MinMax_0_100")
	public static String[][] getData_PSI_Max_Value_0_100() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValues.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String pressuredata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				pressuredata[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return pressuredata;
	}

	@DataProvider(name = "RegistrationTestData")
	public static String[][] getDataregistration() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/RegistrationTestData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Registration");
		int colcount = XLUtils.getCellCount(path, "Registration", 1);

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcount);
		String regdata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				regdata[i - 1][j] = XLUtils.getCellData(path, "Registration", i, j);// 1 0
			}

		}
		return regdata;
	}

	@DataProvider(name = "LoginLinksTestData")
	public static String[][] getDataLogin() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Login");
		int colcount = XLUtils.getCellCount(path, "Login", 1);

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcount);
		String logindata[][] = new String[rownum][colcount];

		// For Loop to get the array values in Logindata
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Login", i, j);// 1 0
			}

		}
		return logindata;
	}

	@DataProvider(name = "SubRegistrationContine")
	public static String[][] getSubRegistrationContinue() throws IOException {

		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/nordson/testData/SubRegistrationContinue.xlsx";

		int rownum = XLUtils.getRowCount(path, "SubRegistration");
		int colcount = XLUtils.getCellCount(path, "SubRegistration", 1);

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcount);
		String subregdata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				subregdata[i - 1][j] = XLUtils.getCellData(path, "SubRegistration", i, j);// 1 0
			}

		}
		return subregdata;
	}

	@DataProvider(name = "RegistrationContine")
	public static String[][] getRegistrationContinue() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/RegistrationContinue.xlsx";

		int rownum = XLUtils.getRowCount(path, "Registration");
		int colcount = XLUtils.getCellCount(path, "Registration", 1);

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcount);
		String regdata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				regdata[i - 1][j] = XLUtils.getCellData(path, "Registration", i, j);// 1 0
			}

		}
		return regdata;
	}

	@DataProvider(name = "AddSubUser")
	public static String[][] getAddSubUSer() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/AddSubUser.xlsx";

		int rownum = XLUtils.getRowCount(path, "AddSubUser");
		int colcount = XLUtils.getCellCount(path, "AddSubUser", 1);

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcount);
		String subuser[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				subuser[i - 1][j] = XLUtils.getCellData(path, "AddSubUser", i, j);// 1 0
			}

		}
		return subuser;
	}

	@DataProvider(name = "AddSubUserRegistration")
	public static String[][] getAddSubUSerReg() throws IOException {

		String path = System.getProperty("user.dir")
				+ "/src/test/java/com/nordson/testData/AddSubUserRegistration.xlsx";

		int rownum = XLUtils.getRowCount(path, "AddSubUserReg");
		int colcount = XLUtils.getCellCount(path, "AddSubUserReg", 1);

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcount);
		String subuser[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				subuser[i - 1][j] = XLUtils.getCellData(path, "AddSubUserReg", i, j);// 1 0
			}

		}
		return subuser;
	}

	@DataProvider(name = "SubUserData")
	public static String[][] getAddSubUSerLoginData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "UserData");
		int colcount = XLUtils.getCellCount(path, "UserData", 1);

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcount);
		String subuser[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				subuser[i - 1][j] = XLUtils.getCellData(path, "UserData", i, j);// 1 0
			}

		}
		return subuser;
	}


	
	@DataProvider(name = "ElectronicPressureAdjust")
	public static String[][] electronicPressureAdjust() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/ElectronicPressureValue.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String ePressValue[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				ePressValue[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return ePressValue;
	}
	

	@DataProvider(name = "min_max_Presure_for_norfile_PSI_manualadjust")
	public static String[][] setminmaxPressureForNorFilePSI() throws IOException {
		String path = System.getProperty("user.dir") + "./src/test/java/com/nordson/testData/NorfilePressure.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		String minpressueDataforNor[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				minpressueDataforNor[i - 1][j] = XLUtils.getCellData(path, sheetNm, i, j);
			}
		}
		return minpressueDataforNor;
	}
	@DataProvider(name = "Pressure boundry value data")
	public static String[][] PressureBoundryValueData() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/PressureValue1.xlsx";

		int rownum = XLUtils.getRowCount(path, sheetNm);
		int colcount = XLUtils.getCellCount(path, sheetNm, 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String boundryValue[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				boundryValue[i - 1][j - 1] = XLUtils.getCellData(path, sheetNm, i, j);// 1 1

			}

		}
		return boundryValue;
	}

	

	public static void setNorXMLValues_Pressure_Min_and_Max(String sheetnm, String mintag, String maxtag,
			String mindata, String maxdata) throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/NorfilePressure.xlsx";
		wb = new XSSFWorkbook(new FileInputStream(path));
		System.out.println(wb.getNumberOfSheets());
		if (wb.getNumberOfSheets() != 0) {
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				if (wb.getSheetName(i).equals(sheetnm)) {
					wb.removeSheetAt(wb.getSheetIndex(sheetnm));
				}
			}
			ws = wb.createSheet(sheetnm);
		}
		System.out.println(ws.getFirstRowNum());
		System.out.println(ws.getLastRowNum());
		ws.createRow(0);
		ws.getRow(0).createCell(0).setCellValue(mintag);
		ws.getRow(0).createCell(1).setCellValue(maxtag);

		ws.createRow(1);
		ws.getRow(1).createCell(0).setCellValue(mindata);
		ws.getRow(1).createCell(1).setCellValue(maxdata);

		fo = new FileOutputStream(new File(path));
		wb.write(fo);
		wb.close();

		fo.close();
	}

}
