package com.nordson.MDS;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nordson.pageObjects.TemperatureSystemSettings;
import com.nordson.testCases.TC_LoginTest_DDT_001;
import com.nordson.utilities.ActionMethods;
import com.nordson.utilities.Constants;
import com.nordson.utilities.ReadConfig;
import com.nordson.utilities.XLUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

public class TC_SystemSettins_MDSVal extends TC_LoginTest_DDT_001 {

	TemperatureSystemSettings Tss;
	ActionMethods Am;
	TC_LoginTest_DDT_001 lg;
	private SoftAssert softAssert = new SoftAssert();
	MDSGetterandSetters mds = new MDSGetterandSetters();
	RetriveMDSdata rmds = new RetriveMDSdata();
	ReadConfig rcf = new ReadConfig();

	@Test(priority = 1)
	@Feature("Temperature System settings MDS Default values validations")
	@Description("Verify the MDS Default Values for Celsius system settings Temperature Unit")
	public void Test_Celsius_SysDefaultSettings() throws InterruptedException, IOException {

		Tss = new TemperatureSystemSettings(driver);
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_OTT());
		String defaultOTTClsius = mds.getDefault1();
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_UTT());
		String defaultUTTClsius = mds.getDefault1();
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_Tmpstbck());
		String defaultTmpstbckClsius = mds.getDefault1();

		Tss.clickSetUpToolBtn();
		log.info("Clicked on SetUp Tool button");
		Thread.sleep(1000);

		Tss.clickCreateNewBtn();
		log.info("Clicked on CreateNew button");
		Thread.sleep(1000);

		Tss.clickSubmitBtn();
		log.info("Clicked on Submit button");
		
		Tss.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");
		Thread.sleep(1000);


		Tss.clickTemperatureBtn();
		log.info("Clicked on Temperature in System settings button");

		// check for default values

		softAssert.assertEquals(Tss.getOTTemperature(), defaultOTTClsius,
				"Over Temperature threshold global temp is not set to Default value : " + defaultOTTClsius);
		log.info("Over Temperature threshold global temp is set to Default value  :" + defaultOTTClsius);

		softAssert.assertEquals(Tss.getUTTemperature(), defaultUTTClsius,
				"Under Temperature threshold global temp is not set to Default value : " + defaultUTTClsius);
		log.info("Over Temperature threshold global temp is set to Default value  :" + defaultUTTClsius);

		softAssert.assertEquals(Tss.getTemperatureSetback(), defaultTmpstbckClsius,
				"Temperature set back for global temp is not set to Default value : " + defaultTmpstbckClsius);
		log.info("Temperature set back for global temp is set to Default value  :" + defaultTmpstbckClsius);
		
		String tempunt = Tss.getOTTTemperatureunt();
		if(tempunt.contains(mds.getPrmryunt()))
			log.info("OTT set point is set to Default  celsius unit");
		else
			log.info("OTT set point is not set to Default  celsius unit");
			

		softAssert.assertAll();

	}

	@Test(priority = 2)
	@Description("Verify the Default Values for Farnheit system settings Temperature Unit")
	public void Test_Farnheit_SysDefaultSettings() throws InterruptedException, IOException {

		// Farhenit Validations For default Values

		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_OTT());
		String defaultOTTFrnhit = mds.getDefault2();
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_UTT());
		String defaultUTTFrnhit = mds.getDefault2();
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_Tmpstbck());
		String defaulttmpstbckFrnhit = mds.getDefault2();

		Tss.clickPreferencesBtn();

		Tss.clickFarhenitUnit();
		log.info("Temperature Unit Farhenit is selected by clicking");

		Tss.clickSave();
		log.info("Saved Farhenit OPtion");

		if (Tss.getToastmsgststus() == true)
			log.info("Prefrences updated sucessfully");
		else
			log.info("Prefrences not updated sucessfully");

		Tss.clickTemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate farhenit default options");

		Thread.sleep(2000);

		softAssert.assertEquals(Tss.getOTTemperature(), defaultOTTFrnhit,
				"Over Temperature threshold global temp is not set to Default Farhenit value : " + defaultOTTFrnhit);
		log.info("Over Temperature threshold global temp is set to Default Farhenit value  :" + defaultOTTFrnhit);

		softAssert.assertEquals(Tss.getUTTemperature(), defaultUTTFrnhit,
				"Under Temperature threshold global temp is not set to Default Farhenit value : " + defaultUTTFrnhit);
		log.info("Over Temperature threshold global temp is set to Default Farhenit value  :" + defaultUTTFrnhit);

		softAssert.assertEquals(Tss.getTemperatureSetback(), defaulttmpstbckFrnhit,
				"Temperature set back for global temp is not set to Default Farhenit value : " + defaulttmpstbckFrnhit);
		log.info("Temperature set back for global temp is set to Default Farhenit value  :" + defaulttmpstbckFrnhit);
		
		
		String tempunt = Tss.getOTTTemperatureunt();
		if(tempunt.contains(mds.getScndryunt()))
			log.info("OTT set point is set to Farnhit  celsius unit");
		else
			log.info("OTT set point is not set to Farnhit celsius unit");
		
		
		softAssert.assertAll();
		
		

	}

	@Test(priority = 3)
	@Feature("Temperature System settings MDS Minmax values validations")
	@Description("Verify the Over Temperature Threshold MDS Minmax Values for system settings Temperature")
	public void Test_SysMinmaxSettings_OTT() throws InterruptedException, IOException {

		
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_OTT());
		String OTTMin1 = mds.getMin1();
		String OTTMax1 = mds.getMax1();
		String OTTMin2 = mds.getMin2();
		String OTTMax2 = mds.getMax2();

		System.out.println(OTTMax2);
		Tss.clickPreferencesBtn();

		Tss.clickCelsiusTempUnit();
		log.info("Temperature Unit celsius is selected by clicking");

		Tss.clickSave();
		log.info("Saved Celsius OPtion");

		if (Tss.getToastmsgststus() == false)
			log.info("Prefrences updated sucessfully");
		else
			log.info("Prefrences not updated sucessfully");

		Tss.clickTemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate celsius default options");
		Thread.sleep(1200);

		// check for MinMax values for OTT Celsius

		Tss.clearOTTemperature();
		Tss.setOTTemperature(OTTMin1);

		Tss.clickSavebtn();

		String OTTtstmsgstustmin1 = Tss.getToastmsg();
		softAssert.assertEquals(OTTtstmsgstustmin1, Constants.Sucssmsg,
				"Toast msg for min val not saved for Celsius unit");
		log.info("Toast msg for min val saved successfully for Celsius unit");

		boolean OTTSavebtnstutsmin1 = Tss.getbtnstatus();
		softAssert.assertEquals(false, OTTSavebtnstutsmin1, "Save button is not disabled for OTTemp min val for celsius unit");
		log.info("Save button is disabled for OTTemp min val for celsius unit");

		Tss.clearOTTemperature();
		Tss.setOTTemperature(OTTMax1);

		Tss.clickSavebtn();

		String OTTtstmsgstustmax1 = Tss.getToastmsg();
		softAssert.assertEquals(OTTtstmsgstustmax1, Constants.Sucssmsg,
				"Toast msg for max val not saved for Celsius unit");
		log.info("Toast msg for max val saved successfully for Celsius unit");

		boolean OTTSavebtnstutsmax1 = Tss.getbtnstatus();
		softAssert.assertEquals(false, OTTSavebtnstutsmax1, "Save button is not disabled for OTTemp max val for celsius unit");
		log.info("Save button is disabled for OTTemp max val for celsius unit");


		// check for MinMax values for OTT Farnheit

		Tss.clickPreferencesBtn();

		Tss.clickFarhenitUnit();
		log.info("Temperature Unit Farhenit is selected by clicking");

		Tss.clickSave();
		log.info("Saved Farhenit OPtion");

		if (Tss.getToastmsgststus() == false)
			log.info("Prefrences updated sucessfully");
		else
			log.info("Prefrences not updated sucessfully");

		Tss.clickTemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate farhenit default options");

		Thread.sleep(2000);

		Tss.clearOTTemperature();
		Tss.setOTTemperature(OTTMin2);

		Tss.clickSavebtn();

		String OTTtstmsgstustmin2 = Tss.getToastmsg();
		softAssert.assertEquals(OTTtstmsgstustmin2, Constants.Sucssmsg,
				"Toast msg for min val not saved for farnhit unit");
		log.info("Toast msg for min val saved successfully for farnhit unit");

		boolean OTTSavebtnstutsmin2 = Tss.getbtnstatus();
		softAssert.assertEquals(false, OTTSavebtnstutsmin2, "Save button is not disabled for OTTemp min val for farnhit unit");
		log.info("Save button is disabled for OTTemp min val for farnhit unit");


		Tss.clearOTTemperature();
		Tss.setOTTemperature(OTTMax2);

		Tss.clickSavebtn();

		String OTTtstmsgstustmax2 = Tss.getToastmsg();
		softAssert.assertEquals(OTTtstmsgstustmax2, Constants.Sucssmsg,
				"Toast error message is shown up for Farnheit unit");
		log.info("Toast error message is shown up for OTTemp min val for farhenit unit");

		boolean OTTSavebtnstutsmax2 = Tss.getbtnstatus();
		softAssert.assertEquals(false, OTTSavebtnstutsmax2, "Save button is not disabled for OTTemp max val for farnhit unit");
		log.info("Save button is disabled for OTTemp max val for farnhit unit");


		softAssert.assertAll();

	}

	@Test(priority = 4)
	@Feature("Temperature System settings MDS Minmax values validations")
	@Description("Verify the Under Temperature Threshold MDS Minmax Values for System settings")
	public void Test_SysMinmaxSettings_UTT() throws InterruptedException, IOException {

		
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_UTT());
		String UTTMin1 = mds.getMin1();
		String UTTMax1 = mds.getMax1();
		String UTTMin2 = mds.getMin2();
		String UTTMax2 = mds.getMax2();


		Tss.clickPreferencesBtn();
		Thread.sleep(1200);

		Tss.clickCelsiusTempUnit();
		log.info("Temperature Unit celsius is selected by clicking");

		Tss.clickSave();
		
		if (Tss.getToastmsgststus() == false)
			log.info("Prefrences updated sucessfully");
		else
			log.info("Prefrences not updated sucessfully");

		Tss.clickTemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate celsius default options");
		Thread.sleep(1200);

		// check for MinMax values for UTT Celsius

		Tss.clearUTTemperature();
		Tss.setUTTemperature(UTTMin1);

		Tss.clickSavebtn();

		String UTTtstmsgstustmin1 = Tss.getToastmsg();
		softAssert.assertEquals(UTTtstmsgstustmin1, Constants.Sucssmsg,
				"Toast msg for min val not saved for Celsius unit");
		log.info("Toast msg for min val saved successfully for Celsius unit");
		
		boolean UTTsavebtnstusmin1 = Tss.getbtnstatus();
		softAssert.assertEquals(false, UTTsavebtnstusmin1, "Save button is not disabled for UTTemp min val for celsius unit");
		log.info("Save button is disabled for UTTemp min val for celsius unit");


		Tss.clearUTTemperature();
		Tss.setUTTemperature(UTTMax1);

		Tss.clickSavebtn();

		String UTTtstmsgstustmax1 = Tss.getToastmsg();
		softAssert.assertEquals(UTTtstmsgstustmax1, Constants.Sucssmsg,
				"Toast msg for max val not saved for Celsius unit");
		log.info("Toast msg for max val saved successfully for Celsius unit");

		boolean UTTsavebtnstusmax1 = Tss.getbtnstatus();
		softAssert.assertEquals(false, UTTsavebtnstusmax1, "Save button is not disabled for UTTemp min val for celsius unit");
		log.info("Save button is disabled for UTTemp max val for celsius unit");

		// check for MinMax values for UTT Farnheit

		Tss.clickPreferencesBtn();

		Tss.clickFarhenitUnit();
		log.info("Temperature Unit Farhenit is selected by clicking");

		Tss.clickSave();
		log.info("Saved Farhenit OPtion");

		if (Tss.getToastmsgststus() == false)
			log.info("Prefrences updated sucessfully");
		else
			log.info("Prefrences not updated sucessfully");

		Tss.clickTemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate farhenit default options");

		Thread.sleep(2000);

		Tss.clearUTTemperature();
		Tss.setUTTemperature(UTTMin2);

		Tss.clickSavebtn();

		String UTTtstmsgstustmin2 = Tss.getToastmsg();
		softAssert.assertEquals(UTTtstmsgstustmin2, Constants.Sucssmsg,
				"Toast msg for min val not saved for farnhit unit");
		log.info("Toast msg for min val saved successfully for farnhit unit");
		
		boolean UTTsavebtnstusmin2 = Tss.getbtnstatus();
		softAssert.assertEquals(false, UTTsavebtnstusmin2, "Save button is not disabled for UTTemp min val for farnhit unit");
		log.info("Save button is disabled for UTTemp min val for farnhiy unit");


		Tss.clearUTTemperature();
		Tss.setUTTemperature(UTTMax2);

		Tss.clickSavebtn();

		String UTTtstmsgstustmax2 = Tss.getToastmsg();
		softAssert.assertEquals(UTTtstmsgstustmax2, Constants.Sucssmsg,
				"Toast msg for max val not saved for farnhit unit");
		log.info("Toast msg for max val saved successfully for farnhit unit");
		
		boolean UTTsavebtnstusmax2 = Tss.getbtnstatus();
		softAssert.assertEquals(false, UTTsavebtnstusmax2, "Save button is not disabled for UTTemp min val for farnhit unit");
		log.info("Save button is disabled for UTTemp min val for farnhit unit");

		softAssert.assertAll();

	}
	
	@Test(priority = 5)
	@Feature("Temperature System settings MDS Minmax values validations")
	@Description("Verify the Temperature Set back MDS Minmax Values for System settings")
	public void Test_SysMinmaxSettings_Tempsetback() throws InterruptedException, IOException {

		
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_Tmpstbck());
		String tmpstbckMin1 = mds.getMin1();
		String tmpstbckMax1 = mds.getMax1();
		String tmpstbckMin2 = mds.getMin2();
		String tmpstbckMax2 = mds.getMax2();


		Tss.clickPreferencesBtn();
		Thread.sleep(1000);

		Tss.clickCelsiusTempUnit();
		log.info("Temperature Unit celsius is selected by clicking");

		Tss.clickSave();
		log.info("Saved Celsius OPtion");

		if (Tss.getToastmsgststus() == false)
			log.info("Prefrences updated sucessfully");
		else
			log.info("Prefrences not updated sucessfully");

		Tss.clickTemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate celsius default options");
		Thread.sleep(1200);

		// check for MinMax values for UTT Celsius

		Tss.clearTemperaturesetbck();
		Tss.setSetbckTemperature(tmpstbckMin1);

		Tss.clickSavebtn();

		String tmpstbcktstmsgstustmin1 = Tss.getToastmsg();
		softAssert.assertEquals(tmpstbcktstmsgstustmin1, Constants.Sucssmsg,
				"Toast msg for min tmpstbck val not saved for Celsius unit");
		log.info("Toast msg for min tmpstbck val saved successfully for Celsius unit");
		
		boolean UTTsavebtnstusmin1 = Tss.getbtnstatus();
		softAssert.assertEquals(false, UTTsavebtnstusmin1, "Save button is not disabled for tmpstbck min val for celsius unit");
		log.info("Save button is disabled for tmpstbck min val for celsius unit");


		Tss.clearTemperaturesetbck();
		Tss.setSetbckTemperature(tmpstbckMax1);

		Tss.clickSavebtn();

		String tmpstbcktstmsgstustmax1 = Tss.getToastmsg();
		softAssert.assertEquals(tmpstbcktstmsgstustmax1, Constants.Sucssmsg,
				"Toast msg for max tmpstbck val not saved for Celsius unit");
		log.info("Toast msg for max tmpstbck val saved successfully for Celsius unit");

		boolean tmpstbcksavebtnstusmax1 = Tss.getbtnstatus();
		softAssert.assertEquals(false, tmpstbcksavebtnstusmax1, "Save button is not disabled for tmpstbck min val for celsius unit");
		log.info("Save button is disabled for tmpstbck max val for celsius unit");

		// check for MinMax values for UTT Farnheit

		Tss.clickPreferencesBtn();

		Tss.clickFarhenitUnit();
		log.info("Temperature Unit Farhenit is selected by clicking");

		Tss.clickSave();
		log.info("Saved Farhenit OPtion");

		if (Tss.getToastmsgststus() == false)
			log.info("Prefrences updated sucessfully");
		else
			log.info("Prefrences not updated sucessfully");

		Tss.clickTemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate farhenit default options");

		Thread.sleep(2000);

		Tss.clearTemperaturesetbck();
		Tss.setSetbckTemperature(tmpstbckMin2);

		Tss.clickSavebtn();

		String tmpstbcktstmsgstustmin2 = Tss.getToastmsg();
		softAssert.assertEquals(tmpstbcktstmsgstustmin2, Constants.Sucssmsg,
				"Toast msg for tmpstbck min val not saved for farnhit unit");
		log.info("Toast msg for tmpstbck min val saved successfully for farnhit unit");
		
		boolean tmpstbcksavebtnstusmin2 = Tss.getbtnstatus();
		softAssert.assertEquals(false, tmpstbcksavebtnstusmin2, "Save button is not disabled for tmpstbck min val for farnhit unit");
		log.info("Save button is disabled for tmpstbck min val for farnhiy unit");


		Tss.clearTemperaturesetbck();
		Tss.setSetbckTemperature(tmpstbckMax2);

		Tss.clickSavebtn();

		String tmpstbcktstmsgstustmax2 = Tss.getToastmsg();
		softAssert.assertEquals(tmpstbcktstmsgstustmax2, Constants.Sucssmsg,
				"Toast msg for max val not saved for farnhit unit");
		log.info("Toast msg for max val saved successfully for farnhit unit");
		
		boolean tmpstbcksavebtnstusmax2 = Tss.getbtnstatus();
		softAssert.assertEquals(false, tmpstbcksavebtnstusmax2, "Save button is not disabled for tmpstbck min val for farnhit unit");
		log.info("Save button is disabled for tmpstbck min val for farnhit unit");

		softAssert.assertAll();

	}

}
