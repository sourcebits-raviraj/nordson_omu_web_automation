package com.nordson.MDS;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.nordson.utilities.ReadConfig;
import com.nordson.utilities.XLUtils;

public class RetriveMDSdata_Temperature {

	int rwindx = 0;
	String UIfildtobefetched = "";

	// Variables declaration to store the values Temperature MDS file 

	String default1 = "";
	String min1 = "";
	String max1 = "";
	
	String default2 = "";
	String min2 = "";
	String max2 = "";

	// Variables declaration to store the required parameters cell index in Temperature MDS file
	int prmryuntindx = 0;
	int dfault1indx = 0;
	int min1indx = 0;
	int max1indx = 0;

	int secondryuntindx = 0;
	int dfault2indx = 0;
	int min2indx = 0;
	int max2indx = 0;
	

	// Hashmap declaration to store the row headings
	HashMap<Integer, String> MDSrowhding = new HashMap<Integer, String>();
	// object creation of the class to set the MDS file values retrieved
	MDSGetterandSetters_Temperature mgs = new MDSGetterandSetters_Temperature();
	ReadConfig rcf = new ReadConfig();

	// Method to store the column indexes for required MDS field for temperature
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

	// Method to retrieve the values from MDS file
	public void getMDSDataVal(String UIfieldTobefetched) throws IOException {

		String path = System.getProperty("user.dir") + rcf.getExcelMDSpathTemperature();
		getColindx(path);
		int colcount = XLUtils.getCellCount(path, "ProBlue Flex", 1);
		for (int i = 0; i < colcount; i++) {
			// storing the heading row values in hasmap
			MDSrowhding.put(0, XLUtils.getCellData(path, "ProBlue Flex", 0, i));

			for (String lbls : MDSrowhding.values()) {
				//checking whether heading row contains UI Label
				if (lbls.contains("UI Label")) {
					int columnindxUIlbl = XLUtils.getColumnindexnum(path, "ProBlue Flex", 0);
					List<String> UIlblcol = XLUtils.getCellDataColindx(path, "ProBlue Flex", 0, columnindxUIlbl);
					for (String colnms : UIlblcol) {
						// Verifying the UI field to be fetched is present or not and storing the row index of that label
						if (colnms.trim().equalsIgnoreCase(UIfieldTobefetched)) {
							if(UIfieldTobefetched.equalsIgnoreCase("Zone #"))
								rwindx=5;
							else
							rwindx = XLUtils.getrowindex(path, "ProBlue Flex", colnms);
							// Getting the cell data from MDS file and setting to setters methods
							mgs.setPrmryunt(XLUtils.getCellData(path, "ProBlue Flex", rwindx, prmryuntindx));
							default1 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, dfault1indx); 
							mgs.setDefault1(default1.replaceAll("[-+]*", ""));
							min1 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, min1indx);
							mgs.setMin1(min1.replaceAll("[-+]*", ""));
							max1 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, max1indx);
							mgs.setMax1(max1.replaceAll("[-+]*", ""));
							
							mgs.setScndryunt(XLUtils.getCellData(path, "ProBlue Flex", rwindx, secondryuntindx));
							default2 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, dfault2indx);
							mgs.setDefault2(default2.replaceAll("[-+]*", ""));
							min2 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, min2indx);
							mgs.setMin2(min2.replaceAll("[-+]*", ""));
							max2 = XLUtils.getCellData(path, "ProBlue Flex", rwindx, max2indx);
							mgs.setMax2(max2.replaceAll("[-+]*", ""));

						}

					}

				}
			}
		}

	}
	//Method to assign the UIfieldtobe fetched to a variable
	public void setUIfieldTobefetched(String UIfieldTobefetched) {

		this.UIfildtobefetched = UIfieldTobefetched;

	}

}
