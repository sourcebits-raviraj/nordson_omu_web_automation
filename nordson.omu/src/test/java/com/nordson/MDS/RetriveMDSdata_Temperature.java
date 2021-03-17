package com.nordson.MDS;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.nordson.utilities.ReadConfig;
import com.nordson.utilities.XLUtils;

public class RetriveMDSdata_Temperature {

	int rwindx = 0;
	String UIfildtobefetched = "";

	String prmryunt = "";
	String default1 = "";
	String min1 = "";
	String max1 = "";

	String scndryunt = "";
	String default2 = "";
	String min2 = "";
	String max2 = "";

	int prmryuntindx = 0;
	int dfault1indx = 0;
	int min1indx = 0;
	int max1indx = 0;

	int secondryuntindx = 0;
	int dfault2indx = 0;
	int min2indx = 0;
	int max2indx = 0;
	String dflt1 = "";
	String dflt2 = "";

	HashMap<Integer, String> MDSrowhding = new HashMap<Integer, String>();
	MDSGetterandSetters_Temperature mgs = new MDSGetterandSetters_Temperature();
	ReadConfig rcf = new ReadConfig();

	public void getColindx(String path) throws IOException

	{
		int colcount = XLUtils.getCellCount(path, "ProBlue Flex", 1);
		for (int i = 0; i < colcount; i++) {
			MDSrowhding.put(0, XLUtils.getCellData(path, "ProBlue Flex", 0, i));

			for (String lbls : MDSrowhding.values()) {

				if (lbls.contains("Primary Units"))
					prmryuntindx = XLUtils.getColumnindex(path, "ProBlue Flex", "Primary Units");
				if (lbls.contains("Default1"))
					dfault1indx = XLUtils.getColumnindex(path, "ProBlue Flex", "Default1");
				if (lbls.contains("Min1"))
					min1indx = XLUtils.getColumnindex(path, "ProBlue Flex", "Min1");
				if (lbls.contains("Max1"))
					max1indx = XLUtils.getColumnindex(path, "ProBlue Flex", "Max1");

				if (lbls.contains("Secondary Units"))
					secondryuntindx = XLUtils.getColumnindex(path, "ProBlue Flex", "Secondary Units");
				if (lbls.contains("Default2"))
					dfault2indx = XLUtils.getColumnindex(path, "ProBlue Flex", "Default2");
				if (lbls.contains("Min2"))
					min2indx = XLUtils.getColumnindex(path, "ProBlue Flex", "Min2");
				if (lbls.contains("Max2"))
					max2indx = XLUtils.getColumnindex(path, "ProBlue Flex", "Max2");

			}

		}

	}

	public void getMDSDataVal(String UIfieldTobefetched) throws IOException {

		String path = System.getProperty("user.dir") + rcf.getExcelMDSpath();
		getColindx(path);
		int colcount = XLUtils.getCellCount(path, "ProBlue Flex", 1);

		for (int i = 0; i < colcount; i++) {
			MDSrowhding.put(0, XLUtils.getCellData(path, "ProBlue Flex", 0, i));

			for (String lbls : MDSrowhding.values()) {

				if (lbls.contains("UI Label")) {

					int columnindxUIlbl = XLUtils.getColumnindex(path, "ProBlue Flex", 0);
					List<String> UIlblcol = XLUtils.getCellDataColindx(path, "ProBlue Flex", 0, columnindxUIlbl);

					for (String colnms : UIlblcol) {

						if (colnms.trim().equalsIgnoreCase(UIfieldTobefetched)) {
							if(UIfieldTobefetched.equalsIgnoreCase("Zone #"))
								rwindx=5;
							else
							rwindx = XLUtils.getrowindex(path, "ProBlue Flex", colnms);

							prmryunt = XLUtils.getCellData(path, "ProBlue Flex", rwindx, prmryuntindx);
							mgs.setPrmryunt(prmryunt);
							default1 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, dfault1indx);
							dflt1 = default1.replaceAll("[-+]*", "");
							mgs.setDefault1(dflt1);
							min1 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, min1indx);
							String mn1 = min1.replaceAll("[-+]*", "");
							mgs.setMin1(mn1);
							max1 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, max1indx);
							String mx1 = max1.replaceAll("[-+]*", "");
							mgs.setMax1(mx1);
							scndryunt = XLUtils.getCellData(path, "ProBlue Flex", rwindx, secondryuntindx);
							mgs.setScndryunt(scndryunt);
							default2 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, dfault2indx);
							dflt2 = default2.replaceAll("[-+]*", "");
							mgs.setDefault2(dflt2);
							min2 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, min2indx);
							String mn2 = min2.replaceAll("[-+]*", "");
							mgs.setMin2(mn2);
							max2 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, max2indx);
							String mx2 = max2.replaceAll("[-+]*", "");
							mgs.setMax2(mx2);

						}

					}

				}
			}
		}

	}

	public void setUIfieldTobefetched(String UIfieldTobefetched) {

		this.UIfildtobefetched = UIfieldTobefetched;

	}

}
