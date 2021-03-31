package com.nordson.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./configs/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Expecption is " + e.getMessage());
		}
	}

	public String getAppURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getSuperAdminUsername() {
		String uname = pro.getProperty("superadminusername");
		return uname;
	}

	public String getSuperAdminPassword() {
		String pwd = pro.getProperty("superadminpassword");
		return pwd;
	}

	public String getChromepath() {
		String chropath = pro.getProperty("chromepath");
		return chropath;
	}

	public String getFirepath() {
		String chropath = pro.getProperty("firepath");
		return chropath;
	}

	public String getIEpath() {

		String chropath = pro.getProperty("IEpath");
		return chropath;

	}

	public String getExcelMDSpathPressure() {
		String MDSpath = pro.getProperty("MDSpathPressure");
		return MDSpath;

	}
// Pressure Properties to be fetched from config file
	public String getUIfieldTobefetched_MinimumPressureAlrt() {
		return pro.getProperty("UIfildTobefetched_MinPA");
	}

	public String getUIfieldTobefetched_MaximumPressureAlrt() {
		return pro.getProperty("UIfildTobefetched_MaxPA");
	}

	public String getUIfieldTobefetched_PressureSetPoint() {
		return pro.getProperty("UIfildTobefetched_PressureSetPoint");
	}

	public String getUIfieldTobefetched_LowPressureAlertThreshold() {
		return pro.getProperty("UIfildTobefetched_LowPressureAlertThreshold");
	}

	public String getUIfieldTobefetched_HighPressureAlertThreshold() {
		return pro.getProperty("UIfildTobefetched_HighPressureAlertThreshold");
	}

	public String getUIfieldTobefetched_MinimumPressureSetPointRange() {
		return pro.getProperty("UIfildTobefetched_MinimumPressureSetPointRange");
	}

	public String getUIfieldTobefetched_MaximumPressureSetPointRange() {
		return pro.getProperty("UIfildTobefetched_MaximumPressureSetPointRange");
	}

	public String getUIfieldTobefetched_LowSpeedPressureSetting() {
		return pro.getProperty("UIfildTobefetched_LowSpeedPressureSetting");
	}

	public String getUIfieldTobefetched_LowLineSpeedSetting() {
		return pro.getProperty("UIfildTobefetched_LowLineSpeedSetting");
	}

	public String getUIfieldTobefetched_HighSpeedPressureSetting() {
		return pro.getProperty("UIfildTobefetched_HighSpeedPressureSetting");
	}

	public String getUIfieldTobefetched_HighLineSpeedSetting() {
		return pro.getProperty("UIfildTobefetched_HighLineSpeedSetting");
	}

	public String getUIfieldTobefetched_SetMaximumPressureLimit() {
		return pro.getProperty("UIfildTobefetched_SetMaximumPressureLimit");
	}

	public String getUIfieldTobefetched_SetMinimumPressureLimit() {
		return pro.getProperty("UIfildTobefetched_SetMinimumPressureLimit");
	}

	public String getUIfieldTobefetched_FullScaleLineSpeed() {
		return pro.getProperty("UIfildTobefetched_FullScaleLineSpeed");

	}

}
