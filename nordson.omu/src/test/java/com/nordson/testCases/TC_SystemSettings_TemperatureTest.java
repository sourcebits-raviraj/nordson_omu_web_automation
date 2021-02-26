package com.nordson.testCases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nordson.pageObjects.TemperatureRuntimeSettings;
import com.nordson.utilities.ActionMethods;
import com.nordson.utilities.Constants;
import com.nordson.utilities.XLUtils;

public class TC_SystemSettings_TemperatureTest extends TC_LoginTest_DDT_001 {

	TemperatureRuntimeSettings Trs;
	ActionMethods Am;
	TC_LoginTest_DDT_001 lg;
	
	public static String OTTtempcsl="";
	public static String OTTtempfarnh="";
	
	public static String UTTtempcsl="";
	public static String UTTtempfarnh="";
	
	public static String tmpstbckcsl="";
	public static String tmpstbckfarnh="";
	
	
	private SoftAssert softAssert = new SoftAssert();

	@Test(priority = 1)
	public void Test_Celsius_SysDefaultSettings() throws InterruptedException, IOException {

		Trs = new TemperatureRuntimeSettings(driver);
		Trs.SetUpToolBtnISEnabled();
		Trs.clickSetUpToolBtn();
		log.info("Clicked on SetUp Tool button");
		Thread.sleep(1000);

		Trs.CreateNewBtnISEnabled();
		Trs.clickCreateNewBtn();
		log.info("Clicked on CreateNew button");
		Thread.sleep(1000);

		Trs.clickSubmitBtn();
		log.info("Clicked on Submit button");
		Thread.sleep(1200);

		Trs.SystemSettingsBtnISEnabled();
		Thread.sleep(2000);
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");
		Thread.sleep(3000);

		Trs.TemperatureBtnISEnabled();
		Trs.TemperatureBtn();
		log.info("Clicked on Temperature in System settings button");

		// check for default values

		String OTtemp = Trs.getOTTemperature();
		softAssert.assertEquals(Constants.OTTemp, OTtemp,
				"Over Temperature threshold global temp is not set to Default value : " + Constants.OTTemp);
		log.info("Over Temperature threshold global temp is set to Default value  :" + Constants.OTTemp);

		String UTtemp = Trs.getUTTemperature();
		softAssert.assertEquals(Constants.UTTemp, UTtemp,
				"Under Temperature threshold global temp is not set to Default value : " + Constants.UTTemp);
		log.info("Over Temperature threshold global temp is set to Default value  :" + Constants.UTTemp);

		String tempsb = Trs.getTemperatureSetback();
		softAssert.assertEquals(Constants.Tempsetback, tempsb,
				"Temperature set back for global temp is not set to Default value : " + Constants.Tempsetback);
		log.info("Temperature set back for global temp is set to Default value  :" + Constants.Tempsetback);

		Thread.sleep(2200);

	}

	@Test(priority = 2)
	public void Test_Farnheit_SysDefaultSettings() throws InterruptedException, IOException {

		// Farhenit Validations For default Values
		
		

		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		Thread.sleep(1500);

		Trs.clickFarhenitUnit();
		log.info("Temperature Unit Farhenit is selected by clicking");
		Thread.sleep(3200);

		Trs.clickSave();
		Thread.sleep(2000);
		log.info("Saved Farhenit OPtion");
		Thread.sleep(3000);

		Trs.TemperatureBtnISEnabled();
		Thread.sleep(1200);
		Trs.TemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate farhenit default options");

		String OTTfhtemp = ActionMethods.getConversionToFahrenheitSys(Constants.OTTemp);
		String OTtempfh = Trs.getOTTemperature();
		softAssert.assertEquals(OTTfhtemp, OTtempfh,
				"Over Temperature threshold global temp is not set to Default Farhenit value : " + OTTfhtemp);
		log.info("Over Temperature threshold global temp is set to Default Farhenit value  :" + OTTfhtemp);

		String UTTfhtemp = ActionMethods.getConversionToFahrenheitSys(Constants.UTTemp);
		String UTtempfh = Trs.getUTTemperature();
		softAssert.assertEquals(UTTfhtemp, UTtempfh,
				"Under Temperature threshold global temp is not set to Default Farhenit value : " + UTTfhtemp);
		log.info("Over Temperature threshold global temp is set to Default Farhenit value  :" + UTTfhtemp);

		String tempstbck = ActionMethods.getConversionToFahrenheitSys(Constants.UTTemp);
		String tempsbfh = Trs.getTemperatureSetback();
		softAssert.assertEquals(tempstbck, tempsbfh,
				"Temperature set back for global temp is not set to Default Farhenit value : " + tempstbck);
		log.info("Temperature set back for global temp is set to Default Farhenit value  :" + tempstbck);

		Thread.sleep(2200);

		XLUtils.setExcelSheetNm("OTTCelsius");

	}

	@Test(priority = 3, dataProvider = "ReadDP", dataProviderClass = com.nordson.utilities.XLUtils.class)
	public void Test_Celsius_OTT_Syssettings(String minlssval, String maxplusval, String Inrngval)
			throws InterruptedException, IOException {

		
		Trs.PreferencesBtnISEnabled();
		Thread.sleep(1200);
		Trs.clickPreferencesBtn();
		Thread.sleep(1500);

		Trs.clickCelsiusUnit();
		Thread.sleep(1200);
		log.info("Temperature Unit Celsius is selected by clicking");
		Thread.sleep(3200);

		Trs.clickSave();
		Thread.sleep(2000);
		log.info("Saved Celsius Option");
		Thread.sleep(3000);

		Trs.TemperatureBtnISEnabled();
		Thread.sleep(1000);
		Trs.TemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate Celsius OTT Min and max values");
		Thread.sleep(3000);

		// null value validations

		Trs.clearOTTemperature();
		Thread.sleep(2000);
		Trs.clickSavebtn();
		Thread.sleep(2000);

		boolean tststusclrerrmsg = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusclrerrmsg, "Toast error message is shown up for max OTTemp Celsius val");
		log.info("Toast error message is shown up for null OTTemp val save for celsius unit");
		Thread.sleep(3000);

		boolean stusclrerrmsg = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusclrerrmsg, " Error message is shown up for max OTTemp Celsius val");
		log.info("Error message is shown up for null OTTemp val save for celsius unit");
		Thread.sleep(3000);

		// min-1 val

		Thread.sleep(1200);
		Trs.setOTTemperature(minlssval);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1500);

		boolean tststusminerr = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusminerr, "Toast error message is shown up for for celsius unit");
		log.info("Toast error message is shown up for OTTemp min val for celsius unit");
		Thread.sleep(2000);

		boolean stusminerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusminerr, "Error message is shown up for for celsius unit");
		log.info("Error message is shown up for OTTemp min val for celsius unit");
		Thread.sleep(2000);

		// max+1 val

		Trs.clearOTTemperature();
		Thread.sleep(1200);
		Trs.setOTTemperature(maxplusval);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1000);

		boolean tststusmaxerr = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusmaxerr,
				"Toast error message is shown up for OTTemp max val for celsius unit");
		log.info("Toast error message is shown up for max val for celsius unit");
		Thread.sleep(2000);

		boolean stusmaxerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusmaxerr, "Error message is shown up for OTTemp max val for celsius unit");
		log.info("Error message is shown up for max val for celsius unit");
		Thread.sleep(2000);

		// In Range value testing

		Trs.clearOTTemperature();
		Thread.sleep(1200);
		Trs.setOTTemperature(Inrngval);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(2000);

		boolean tststus = Trs.getToastmsg();
		softAssert.assertEquals(true, tststus,
				"Toast msg for In range values are saved successfully for OTTemp for celsius unit");
		log.info("Toast msg for In range values are saved successfully for celsius unit");
		Thread.sleep(2000);

	    OTTtempcsl = Trs.getOTTemperature();
		

	}
	
	@Test(priority = 4)
	public void Test_Celsius_Tofarnhit_Conversion_OTTfield() throws InterruptedException {
		
		
		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		Thread.sleep(1500);

		Trs.clickFarhenitUnit();
		log.info("Temperature Unit Farhenit is selected by clicking to verfiy conversion");
		Thread.sleep(3200);

		Trs.clickSave();
		Thread.sleep(2000);
		log.info("Saved Farhenit Option to verfiy conversion");
		Thread.sleep(3000);

		Trs.TemperatureBtnISEnabled();
		Thread.sleep(1200);
		Trs.TemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate OTT Celsius to farhenit conversion");
		Thread.sleep(2000);

		String cvtfh = ActionMethods.getConversionToFahrenheitSys(OTTtempcsl);
		String OTTtemp = Trs.getOTTemperature();
		softAssert.assertEquals(cvtfh, OTTtemp, "Celsius to Farnhit unit conversion not correct");
		log.info("Celsius to Farnhit unit conversion for OTT is correct");
		XLUtils.setExcelSheetNm("OTTFarnhit");

	}

	@Test(priority = 5, dataProvider = "ReadDP", dataProviderClass = com.nordson.utilities.XLUtils.class)
	public void Test_Farnhit_OTT_Syssettings(String minlssvalfh, String maxplusvalfh, String Inrngvalfh)
			throws InterruptedException, IOException {

		// Farhenit Validations For null,min-1,max+1,Inrange Values

		// Null Value Validations for farnhit
        
		
		Trs.clearOTTemperature();
		Thread.sleep(2000);

		Trs.clickSavebtn();
		Thread.sleep(2000);

		boolean tststusclrerrmsgfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusclrerrmsgfh,
				"Toast error message is shown up for max OTTemp val for Farhnit unit");
		log.info("Toast error message is shown up for null OTTemp val save for Farhnit");
		Thread.sleep(3000);

		boolean stusclrerrmsgfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusclrerrmsgfh, "Error message is shown up for max OTTemp val for Farhnit unit");
		log.info("Error message is shown up for null OTTemp val save for Farhnit");
		Thread.sleep(3000);

		// min-1 val

		Thread.sleep(1200);
		Trs.setOTTemperature(minlssvalfh);
		Thread.sleep(2200);
		Trs.clickSavebtn();
		Thread.sleep(2000);

		boolean tststusminerrfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusminerrfh, "Toast error message is shown up for Farhnit unit");
		log.info("Toast error message is shown up for OTTemp min val Farhnit unit");
		Thread.sleep(2000);

		boolean stusminerrfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusminerrfh, "Error message is shown up for Farhnit unit");
		log.info("Error message is shown up for OTTemp min val Farhnit unit");
		Thread.sleep(2000);

		// max+1 val

		Trs.clearOTTemperature();
		Thread.sleep(1200);
		Trs.setOTTemperature(maxplusvalfh);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(2000);

		boolean tststusmaxerrfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusmaxerrfh,
				"Toast error message is shown up for OTTemp max val Farhnit unit");
		log.info("Toast error message is shown up for max val Farhnit unit");
		Thread.sleep(2000);

		boolean stusmaxerrfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusmaxerrfh, "Error message is shown up for OTTemp max val Farhnit unit");
		log.info("Error message is shown up for max val Farhnit unit");
		Thread.sleep(2000);

		// In Range value testing

		Trs.clearOTTemperature();
		Thread.sleep(1200);
		Trs.setOTTemperature(Inrngvalfh);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(2000);

		boolean tststusfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusfh,
				"Toastmsg for In range values are saved successfully for OTTemp Farhnit unit");
		log.info("Toast msg for In range values are saved successfully for Farhnit unit");
		Thread.sleep(2000);

		boolean stusfh = Trs.getbtnstatus();
		softAssert.assertEquals(false, stusfh, "In range values are saved successfully for OTTemp Farhnit unit");
		log.info("In range values are saved successfully for Farhnit unit");
		
		OTTtempfarnh = Trs.getOTTemperature();
		Thread.sleep(2000);
	

	}
    
	
	@Test(priority = 6)
	public void Test_Farnhit_ToCelsius_Conversion_OTTfield() throws InterruptedException {
		
		
		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		Thread.sleep(1500);

		Trs.clickCelsiusUnit();
		log.info("Temperature Unit Celsius is selected by clicking to verfiy conversion");
		Thread.sleep(3200);

		Trs.clickSave();
		Thread.sleep(2000);
		log.info("Saved Celsius Option to verfiy conversion");
		Thread.sleep(3000);

		Trs.TemperatureBtnISEnabled();
		Thread.sleep(1200);
		Trs.TemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate OTT farhenit to celsius conversion");
		Thread.sleep(2000);

		String fhtocelsius = ActionMethods.getConversionToCelsiusSys(OTTtempfarnh);
		String OTTtemp = Trs.getOTTemperature();
		softAssert.assertEquals(OTTtemp, fhtocelsius, "Farnhit to Celsius unit conversion not correct");
		log.info("Farnhit to Celsius unit conversion for OTT is correct");
		Thread.sleep(2000);
		XLUtils.setExcelSheetNm("UTTCelsius");

	}

	@Test(priority = 7, dataProvider = "ReadDP", dataProviderClass = com.nordson.utilities.XLUtils.class)
	public void Test_Celsius_SysMinmaxForUTT(String minlssval, String maxplusval, String Inrngval)
			throws InterruptedException, IOException {
	

		// Null Values Error msg Test
		Thread.sleep(1000);
		Trs.clearUTTemperature();
		Thread.sleep(2000);
		Trs.clickSavebtn();
		Thread.sleep(2000);

		boolean tststusclrerrmsg = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusclrerrmsg,
				"Toast error message is not shown up for max UTTemp Celsius val");
		log.info("Toast error message is shown up for null UTTemp val for Celsius unit after save");
		Thread.sleep(3000);

		boolean stusclrerrmsg = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusclrerrmsg, "Error message is not shown up for max UTTemp Celsius val");
		log.info("Error message is shown up for null UTTemp val for Celsius unit after save");
		Thread.sleep(3000);

		// min-1 val

		Trs.clearUTTemperature();
		Thread.sleep(1200);
		Trs.setUTTemperature(minlssval);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1500);

		boolean tststusminerr = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusminerr, "Toast error message is not shown up for UTTemp Celsius unit");
		log.info("Toast error message is shown up for min UTTemp val for Celsius unit");
		Thread.sleep(2000);

		boolean stusminerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusminerr, "Error message is not shown up for UTTemp Celsius unit");
		log.info("Error message is shown up for min UTTemp val for Celsius unit");
		Thread.sleep(2000);

		// max+1 val

		Trs.clearUTTemperature();
		Thread.sleep(1200);
		Trs.setUTTemperature(maxplusval);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1000);

		boolean tststusmaxerr = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusmaxerr, "Toast error message is not shown up for Celsius unit max val");
		log.info("Toast error message is shown up for max UTTemp Celsius unit val");
		Thread.sleep(2000);

		boolean stusmaxerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusmaxerr, "Error message is not shown up for Celsius unit max val");
		log.info("Error message is shown up for max UTTemp Celsius unit val");
		Thread.sleep(2000);

		// In Range value testing

		Trs.clearUTTemperature();
		Thread.sleep(1200);
		Trs.setUTTemperature(Inrngval);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(2000);

		boolean tstmsgstus = Trs.getToastmsg();
		softAssert.assertEquals(true, tstmsgstus,
				"Toast msg for In range values are not saved successfully for UTTemp Celsius unit");
		log.info("Toast msg for In range values are saved successfully for UTTemp Celsius unit");
		Thread.sleep(2000);

		boolean stus = Trs.getbtnstatus();
		softAssert.assertEquals(false, stus, "In range values are not saved successfully for UTTemp Celsius unit");
		log.info("In range values are saved successfully for UTTemp Celsius unit");
		Thread.sleep(2000);

		UTTtempcsl = Trs.getUTTemperature();
		Thread.sleep(2000);
		
	}

	
	@Test(priority = 8)
	public void Test_Celsius_Tofarnhit_Conversion_UTTfield() throws InterruptedException {

		
		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		Thread.sleep(1500);

		Trs.clickFarhenitUnit();
		log.info("Temperature Unit Farhenit is selected by clicking to verfiy conversion");
		Thread.sleep(3200);

		Trs.clickSave();
		Thread.sleep(2000);
		log.info("Saved Farhenit Option to verfiy conversion");
		Thread.sleep(3000);

		Trs.TemperatureBtnISEnabled();
		Thread.sleep(1200);
		Trs.TemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate OTT Celsius to farhenit conversion");
		Thread.sleep(2000);

		String cvtfh = ActionMethods.getConversionToFahrenheitSys(UTTtempcsl);
		String OTTtemp = Trs.getOTTemperature();
		softAssert.assertEquals(OTTtemp, cvtfh, "Celsius to Farnhit unit conversion not correct");
		log.info("Celsius to Farnhit unit conversion for OTT is correct");
		Thread.sleep(2000);
		XLUtils.setExcelSheetNm("UTTFarnhit");

	}

	@Test(priority = 9, dataProvider = "ReadDP", dataProviderClass = com.nordson.utilities.XLUtils.class)
	public void Test_Farnhit_SysMinmaxForUTT(String minlssvalfh, String maxplusvalfh, String Inrngvalfh)
			throws InterruptedException, IOException {

		
	
		// Farhenit Minmax Val testing for Under Threshold Field

		// Null Values Error msg Test

		Trs.clearUTTemperature();
		Thread.sleep(2000);
		Trs.clickSavebtn();
		Thread.sleep(1200);

		boolean tststusclrerrmsgfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusclrerrmsgfh,
				"Toast error message is not shown up for max UTTemp Farhenit val");
		log.info("Toast error message is shown up for null UTTemp val for Farhenit unit after save");
		Thread.sleep(3000);

		boolean stusclrerrmsgfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusclrerrmsgfh, "Error message is not shown up for max UTTemp Farhenit val");
		log.info("Error message is shown up for null UTTemp val for Farhenit unit after save");
		Thread.sleep(3000);

		// min-1 val

		Trs.clearUTTemperature();
		Thread.sleep(1200);
		Trs.setUTTemperature(minlssvalfh);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1500);

		boolean tststusminerrfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusminerrfh, "Toast error message is not shown up for UTTemp Farhenit unit");
		log.info("Toast error message is shown up for min UTTemp val for Farhenit unit");
		Thread.sleep(2000);

		boolean stusminerrfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusminerrfh, "Error message is not shown up for UTTemp Farhenit unit");
		log.info("Error message is shown up for min UTTemp val for Farhenit unit");
		Thread.sleep(2000);

		// max+1 val

		Trs.clearUTTemperature();
		Thread.sleep(1200);
		Trs.setUTTemperature(maxplusvalfh);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1000);

		boolean tststusmaxerrfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusmaxerrfh, "Toast error message is not shown up for Farhenit unit max val");
		log.info("Toast error message is shown up for max UTTemp Farhenit unit val");
		Thread.sleep(2000);

		boolean stusmaxerrfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusmaxerrfh, "Error message is not shown up for Farhenit unit max val");
		log.info("Error message is shown up for max UTTemp Farhenit unit val");
		Thread.sleep(2000);

		// In Range value testing

		Trs.clearUTTemperature();
		Thread.sleep(1200);
		Trs.setUTTemperature(Inrngvalfh);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1800);

		boolean tststusfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusfh,
				"Toast msgIn range values are not saved successfully for UTTemp Farhenit unit");
		log.info("Toast msg In range values are saved successfully for UTTemp Farhenit unit");
		Thread.sleep(2000);

		boolean stusfh = Trs.getbtnstatus();
		softAssert.assertEquals(false, stusfh, "In range values are not saved successfully for UTTemp Farhenit unit");
		log.info("In range values are saved successfully for UTTemp Farhenit unit");
		Thread.sleep(1200);

		UTTtempfarnh = Trs.getUTTemperature();
		Thread.sleep(2000);
		
	}
    
	@Test(priority = 10)
	public void Test_Farnhit_ToCelsius_Conversion_UTTfield() throws InterruptedException {

		
		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		Thread.sleep(1500);

		Trs.clickCelsiusUnit();
		log.info("Temperature Unit Celsius is selected by clicking to verfiy conversion");
		Thread.sleep(3200);

		Trs.clickSave();
		Thread.sleep(2000);
		log.info("Saved Celsius Option to verfiy conversion");
		Thread.sleep(3000);

		Trs.TemperatureBtnISEnabled();
		Thread.sleep(1200);
		Trs.TemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate OTT farhenit to celsius conversion");
		Thread.sleep(2000);

		String fhtocelsius = ActionMethods.getConversionToCelsiusSys(UTTtempfarnh);
		String OTTtemp = Trs.getOTTemperature();
		softAssert.assertEquals(OTTtemp, fhtocelsius, "Farnhit to Celsius unit conversion not correct");
		log.info("Farnhit to Celsius unit conversion for OTT is correct");
		Thread.sleep(2000);
		XLUtils.setExcelSheetNm("TempsetbckCelsius");

	}

	@Test(priority = 11, dataProvider = "ReadDP", dataProviderClass = com.nordson.utilities.XLUtils.class)
	public void Test_Celsius_SysMinmaxForTmpstbck(String minlssval, String maxplusval, String Inrngval)
			throws InterruptedException, IOException {

		// Null Values validation for Celsius Unit
		
		Trs.clearTemperaturesetbck();
		Thread.sleep(1200);
		Trs.clickSavebtn();

		boolean tststusclrerrmsg = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusclrerrmsg,
				"Toast error message is not shown up for max Tempsetbck val for celsuis unit");
		log.info("Toast error message is shown up for null Tempsetbck val save celsuis unit");
		Thread.sleep(3000);

		boolean stusclrerrmsg = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusclrerrmsg,
				"Error message is not shown up for max Tempsetbck val for celsuis unit");
		log.info("Error message is shown up for null Tempsetbck val save celsuis unit");
		Thread.sleep(3000);

		// min-1 val

		Trs.clearTemperaturesetbck();
		Thread.sleep(1200);
		Trs.setSetbckTemperature(minlssval);
		Thread.sleep(1200);
		Trs.clickSavebtn();

		boolean tststusminerr = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusminerr, "Toast error message is not shown up for Tempsetbck celsuis unit");
		log.info("Toast error message is shown up for min Tempsetbck val celsuis unit");
		Thread.sleep(2000);

		boolean stusminerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusminerr, "Error message is not shown up for Tempsetbck celsuis unit");
		log.info("Error message is shown up for min Tempsetbck val celsuis unit");
		Thread.sleep(2000);

		// max+1 val

		Trs.clearTemperaturesetbck();
		Thread.sleep(1200);
		Trs.setSetbckTemperature(maxplusval);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1000);

		boolean tststusmaxerr = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusmaxerr,
				"Toast error message is not shown up for max Tempsetbck val celsuis unit ");
		log.info("Toast error message is shown up for max Tempsetbck val celsuis unit");
		Thread.sleep(2000);

		boolean stusmaxerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusmaxerr, "Error message is not shown up for max Tempsetbck val celsuis unit ");
		log.info("Error message is shown up for max Tempsetbck val celsuis unit");
		Thread.sleep(2000);

		// In Range value testing

		Trs.clearTemperaturesetbck();
		Thread.sleep(1200);
		Trs.setSetbckTemperature(Inrngval);
		Thread.sleep(1200);
		Trs.clickSavebtn();

		boolean tststus = Trs.getToastmsg();
		softAssert.assertEquals(true, tststus,
				"Toast msg for In range values are not saved successfully for Tempsetbck celsuis unit");
		log.info("Toast msg for In range values are saved successfully for Tempsetbck celsuis unit");
		Thread.sleep(2000);

		boolean stus = Trs.getbtnstatus();
		softAssert.assertEquals(false, stus, "In range values are not saved successfully for Tempsetbck celsuis unit");
		log.info("In range values are saved successfully for Tempsetbck celsuis unit");
		Thread.sleep(2000);

		tmpstbckcsl = Trs.getTemperatureSetback();
		Thread.sleep(2000);
		
	

	}
    
	@Test(priority = 12)
	public void Test_Celsius_Tofarnhit_Conversion_Tempstbck() throws InterruptedException {

		
		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		Thread.sleep(1500);

		Trs.clickFarhenitUnit();
		log.info("Temperature Unit Farhenit is selected by clicking to verfiy conversion");
		Thread.sleep(3200);

		Trs.clickSave();
		Thread.sleep(2000);
		log.info("Saved Farhenit Option to verfiy conversion");
		Thread.sleep(3000);

		Trs.TemperatureBtnISEnabled();
		Thread.sleep(1200);
		Trs.TemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate OTT Celsius to farhenit conversion");
		Thread.sleep(2000);

		String cvtfh = ActionMethods.getConversionToFahrenheitSys(tmpstbckcsl);
		String OTTtemp = Trs.getOTTemperature();
		softAssert.assertEquals(OTTtemp, cvtfh, "Celsius to Farnhit unit conversion not correct");
		log.info("Celsius to Farnhit unit conversion for OTT is correct");
		Thread.sleep(2000);
		XLUtils.setExcelSheetNm("TempsetbckFarnhit");

	}

	@Test(priority = 13, dataProvider = "ReadDP", dataProviderClass = com.nordson.utilities.XLUtils.class)
	public void Test_Farnhit_SysMinmaxForTmpstbck(String minlssvalfh, String maxplusvalfh, String Inrngvalfh)
			throws InterruptedException, IOException {

		// Farhenit Validations for Temperature Set Back
		// Null Values validation for farhenit Unit
        
		
		Trs.clearTemperaturesetbck();
		Thread.sleep(1800);
		Trs.clickSavebtn();

		boolean tststusclrerrmsgfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusclrerrmsgfh,
				"Toast error message is not shown up for max Tempsetbck val for farhenit unit");
		log.info("Toast Error message is shown up for null Tempsetbck val save celsuis unit");
		Thread.sleep(3000);

		boolean stusclrerrmsgfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusclrerrmsgfh,
				"Error message is not shown up for max Tempsetbck val for farhenit unit");
		log.info("Error message is shown up for null Tempsetbck val save farhenit unit");
		Thread.sleep(3000);

		// min-1 val

		Trs.clearTemperaturesetbck();
		Thread.sleep(1200);
		Trs.setSetbckTemperature(minlssvalfh);
		Thread.sleep(1200);
		Trs.clickSavebtn();

		boolean tststusminerrfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusminerrfh,
				"Toast error message is not shown up for Tempsetbck farhenit unit");
		log.info("Toast error message is shown up for min Tempsetbck val celsuis unit");
		Thread.sleep(2000);

		boolean stusminerrfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusminerrfh, "Error message is not shown up for Tempsetbck farhenit unit");
		log.info("Error message is shown up for min Tempsetbck val celsuis unit");
		Thread.sleep(2000);

		// max+1 val

		Trs.clearTemperaturesetbck();
		Thread.sleep(1200);
		Trs.setSetbckTemperature(maxplusvalfh);
		Thread.sleep(1200);
		Trs.clickSavebtn();

		boolean tststusmaxerrfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusmaxerrfh,
				"Toast error message is not shown up for max Tempsetbck val farhenit unit ");
		log.info("Toast error message is shown up for max Tempsetbck val celsuis unit");
		Thread.sleep(2000);

		boolean stusmaxerrfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusmaxerrfh,
				"Error message is not shown up for max Tempsetbck val farhenit unit ");
		log.info("Error message is shown up for max Tempsetbck val celsuis unit");
		Thread.sleep(2000);

		// In Range value testing

		Trs.clearTemperaturesetbck();
		Thread.sleep(1200);
		Trs.setSetbckTemperature(Inrngvalfh);
		Thread.sleep(1200);
		Trs.clickSavebtn();

		boolean tststusfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tststusfh,
				"Toast msg for In range values are not saved successfully for Tempsetbck farhenit unit");
		log.info("Toast msg for In range values are saved successfully for Tempsetbck farhenit unit");
		Thread.sleep(2000);

		boolean stusfh = Trs.getbtnstatus();
		softAssert.assertEquals(false, stusfh,
				"In range values are not saved successfully for Tempsetbck farhenit unit");
		log.info("In range values are saved successfully for Tempsetbck farhenit unit");
		Thread.sleep(2000);

		tmpstbckfarnh = Trs.getTemperatureSetback();
		Thread.sleep(2000);
		

	}
    

	@Test(priority = 14)
	public void Test_Farnhit_ToCelsius_Conversion_Tempstbck() throws InterruptedException {

		
		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		Thread.sleep(1500);

		Trs.clickCelsiusUnit();
		log.info("Temperature Unit Celsius is selected by clicking to verfiy conversion");
		Thread.sleep(3200);

		Trs.clickSave();
		Thread.sleep(2000);
		log.info("Saved Celsius Option to verfiy conversion");
		Thread.sleep(3000);

		Trs.TemperatureBtnISEnabled();
		Thread.sleep(1200);
		Trs.TemperatureBtn();
		log.info("Clicked on Temperature in System settings button to validate OTT farhenit to celsius conversion");
		Thread.sleep(2000);

		String fhtocelsius = ActionMethods.getConversionToCelsiusSys(tmpstbckfarnh);
		String OTTtemp = Trs.getOTTemperature();
		softAssert.assertEquals(OTTtemp, fhtocelsius, "Farnhit to Celsius unit conversion not correct");
		log.info("Farnhit to Celsius unit conversion for OTT is correct");
		Thread.sleep(2000);

	}

}
