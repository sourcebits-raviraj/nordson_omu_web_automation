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
		}

		catch (Exception e) {
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
	
	public String sheetname() {

		String sheetname = pro.getProperty("sheetname");
		return sheetname;

	}


}
