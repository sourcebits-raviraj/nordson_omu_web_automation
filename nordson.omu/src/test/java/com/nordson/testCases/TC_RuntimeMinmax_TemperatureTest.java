package com.nordson.testCases;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nordson.pageObjects.TemperatureRuntimeSettings;
import com.nordson.utilities.ActionMethods;
import com.nordson.utilities.Constants;
import com.nordson.utilities.XLUtils;

public class TC_RuntimeMinmax_TemperatureTest extends TC_LoginTest_DDT_001 {

	TemperatureRuntimeSettings Trs;
	ActionMethods Am;
	TC_LoginTest_DDT_001 lg;
	private SoftAssert softAssert = new SoftAssert();
	
     
      static String Tankpoint="";
      static String Manifoldpoint="";
      static String Hosepnt="";
      static String Applicatorpnt="";
      
	

	// Global Point Validations
	@Test(priority = 1, dataProvider = "TemperatureTestData")
	public void Test_RuntimeMinmaxGlobalPointValidations(String lessminval, String moremaxval, String Inrng
			) throws InterruptedException, IOException {

		Trs = new TemperatureRuntimeSettings(driver);

		Trs.SetUpToolBtnISEnabled();

		// Celsuis Unit Validations

		Trs.clickSetUpToolBtn();
		log.info("Clicked on SetUp Tool button");
		Thread.sleep(2000);

		Trs.CreateNewBtnISEnabled();
		Trs.clickCreateNewBtn();
		log.info("Clicked on CreateNew button");
		Thread.sleep(2000);

		Trs.clickSubmitBtn();
		log.info("Clicked on Submit button");
		Thread.sleep(2000);

		Trs.SystemSettingsBtnISEnabled();
		Thread.sleep(1200);
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");
		Thread.sleep(2000);

		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		log.info("Clicked on Preferences button");
		Thread.sleep(3000);

		Trs.clickCelsiusUnit();
		log.info("Temperature Unit celsius is selected");
		Thread.sleep(1000);

		Trs.RuntimeSettingsBtnISEnabled();
		Thread.sleep(2000);
		Trs.RuntimeSettingsBtn();
		Thread.sleep(2000);
		log.info("Clicked on Runtime settings button to verfiy Global set temperature for celsius unit");

		Trs.ZoneTemperatureBtnISEnabled();
		Trs.ZoneTemperatureBtn();
		Thread.sleep(3200);
		log.info("Clicked on Zone temperature button to setglobal min value for celsius unit");

		// setting global point to Min-1 value and validating tank,Manifold,hose and
		// applicator values

		Trs.setGlobalSetPoint(lessminval);
		log.info("global set point temperature set to min-1 value " + lessminval + "for celsius unit");
		Thread.sleep(3000);

		Trs.clickSavebtn();
		Thread.sleep(3200);
		log.info("global point saved to " + lessminval + "for celsius unit");

		String tankspforgpmin = Trs.getTankSetPoint();
		softAssert.assertEquals(Constants.Minglobaltankpntpnt, tankspforgpmin,
				"Tank set point is not set to Minimum value : " + Constants.Minglobaltankpntpnt + "for celsius unit");
		log.info("Tank set point for global minimun point is set to :" + Constants.Minglobaltankpntpnt
				+ "for celsius unit");

		String manifoldforgpmin = Trs.getManifold();
		softAssert.assertEquals(Constants.Minglobaltankpntpnt, manifoldforgpmin,
				"Manifold set point is not set to Default value : " + Constants.Minglobaltankpntpnt
						+ "for celsius unit");
		log.info("Manifold set point is set to Minium value :" + Constants.Minglobaltankpntpnt + "for celsius unit");
		Thread.sleep(1500);

		List<String> hosestpnt = Trs.getHoseSetTemp();
		int count = 1;
		for (int i = 0; i < hosestpnt.size(); i++) {
			if (hosestpnt.get(i).equals(Constants.Minglobaltankpntpnt)) {
				log.info("Hose" + count + "set point temperature for global min value set to"
						+ Constants.Minglobaltankpntpnt + "for celsius unit");

			}

			else

				log.info("Hose" + count + "set point temperature for global min  value not set to"
						+ Constants.Minglobaltankpntpnt + "for celsius unit");
			count++;
		}

		Thread.sleep(2000);
		List<String> applicatorsetpnt = Trs.getApplicatorSetTemp();
		count = 1;
		for (int i = 0; i < applicatorsetpnt.size(); i++) {
			if (applicatorsetpnt.get(i).equals(Constants.Minglobaltankpntpnt)) {
				log.info("Applicator" + count + "set point temperature for global min value set to"
						+ applicatorsetpnt.get(i) + "for celsius unit");
			} else

				log.info("Applicator" + count + "set point temperature for global min value not set to "
						+ applicatorsetpnt.get(i) + "for celsius unit");
			count++;
		}

		// setting global point to Max+1 value and validating tank,Manifold,hose and
		// applicator values

		Trs.setGlobalSetPoint(moremaxval);
		log.info("global set point temperature set to max+1 value " + moremaxval + "for celsius unit");
		Thread.sleep(3000);

		Trs.clickSavebtn();
		Thread.sleep(3200);
		log.info("global point saved to " + moremaxval + "for celsius unit");

		String tankspforgpmax = Trs.getTankSetPoint();
		softAssert.assertEquals(Constants.Maxsetglobaltankpntpnt, tankspforgpmax,
				"Tank set point is not set to maximum value : " + Constants.Maxsetglobaltankpntpnt
						+ "for celsius unit");
		log.info("Tank set point for global maximum point is set to :" + Constants.Minglobaltankpntpnt
				+ "for celsius unit");

		String manifoldforgpmax = Trs.getManifold();
		softAssert.assertEquals(Constants.Maxsetglobalmanifldpnt, manifoldforgpmax,
				"Manifold set point is not set to Default value : " + Constants.Maxsetglobalmanifldpnt
						+ "for celsius unit");
		log.info(
				"Manifold set point is set to Maximum value :" + Constants.Maxsetglobalmanifldpnt + "for celsius unit");
		Thread.sleep(1500);

		List<String> hosestpntmax = Trs.getHoseSetTemp();
		count = 1;
		for (int i = 0; i < hosestpntmax.size(); i++) {
			if (hosestpnt.get(i).equals(Constants.MaxsetglobalHosepnt)) {
				log.info("Hose" + count + "set point temperature for global min value set to"
						+ Constants.MaxsetglobalHosepnt + "for celsius unit");

			}

			else

				log.info("Hose" + count + "set point temperature for global min  value not set to"
						+ Constants.MaxsetglobalHosepnt + "for celsius unit");
			count++;
		}

		Thread.sleep(2000);
		List<String> applicatorsetpntmax = Trs.getApplicatorSetTemp();
		count = 1;
		for (int i = 0; i < applicatorsetpntmax.size(); i++) {

			if (applicatorsetpntmax.get(i).equals(Constants.MaxsetglobalApplicatorpnt)) {
				log.info("Applicator" + count + "set point temperature for global min value set to"
						+ applicatorsetpntmax.get(i) + "for celsius unit");
			} else

				log.info("Applicator" + count + "set point temperature for global min value not set to "
						+ applicatorsetpntmax.get(i) + "for celsius unit");
			count++;
		}

		// setting global point to Inrange value and validating tank,Manifold,hose and
		// applicator values
		Trs.setGlobalSetPoint(Inrng);
		log.info("global set point temperature set to in range" + Inrng + "for celsius unit");
		Thread.sleep(3000);

		Trs.clickSavebtn();
		Thread.sleep(3200);
		log.info("global point saved to " + Inrng + "for celsius unit");

		String tankspforInrng = Trs.getTankSetPoint();
		softAssert.assertEquals(Inrng, tankspforInrng,
				"Tank set point is not set to Inrng value : " + Inrng + "for celsius unit");
		log.info("Tank set point for global Inrng point is set to :" + Inrng + "for celsius unit");

		String manifoldforInrng = Trs.getManifold();
		softAssert.assertEquals(Inrng, manifoldforInrng,
				"Manifold set point is not set to Default value : " + Inrng + "for celsius unit");
		log.info("Manifold set point is set to Inrng value :" + Inrng + "for celsius unit");
		Thread.sleep(1500);

		List<String> hosestpntInrng = Trs.getHoseSetTemp();
		count = 1;
		for (int i = 0; i < hosestpntInrng.size(); i++) {
			if (hosestpntInrng.get(i).equals(Inrng)) {
				log.info("Hose" + count + "set point temperature for global Inrng value set to" + Inrng
						+ "for celsius unit");

			}

			else

				log.info("Hose" + count + "set point temperature for global Inrng value not set to" + Inrng
						+ "for celsius unit");
			count++;
		}

		Thread.sleep(2000);
		List<String> applicatorsetpntInrng = Trs.getApplicatorSetTemp();
		count = 1;
		for (int i = 0; i < applicatorsetpntInrng.size(); i++) {
			if (applicatorsetpntInrng.get(i).equals(Inrng)) {
				log.info("Applicator" + count + "set point temperature for global min value set to"
						+ applicatorsetpntInrng.get(i) + "for celsius unit");
			} else

				log.info("Applicator" + count + "set point temperature for global min value not set to "
						+ applicatorsetpntInrng.get(i) + "for celsius unit");
			count++;
			Thread.sleep(2600);
		}
		
		
		XLUtils.setExcelSheetNm("GlobalPointFarnhit");

	}
	
	
	

	@Test(priority = 2, dataProvider = "ReadDP", dataProviderClass = com.nordson.utilities.XLUtils.class)
	public void Test_Runtime_Farnhit_MinmaxGlobalPointValidations(String lessfhminval, String maxplusfhval, String Inrngfh
			) throws InterruptedException, IOException {

		// Validations for Farnheit Unit for Global Set Point

		Trs.SystemSettingsBtnISEnabled();
		Thread.sleep(1200);
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");
		Thread.sleep(2000);

		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		log.info("Clicked on Preferences button");
		Thread.sleep(3000);

		Trs.clickFarhenitUnit();
		log.info("Temperature Unit farnhenit is selected");
		Thread.sleep(2000);

		Trs.clickSave();
		Thread.sleep(2000);

		Trs.RuntimeSettingsBtnISEnabled();
		Thread.sleep(2000);
		Trs.RuntimeSettingsBtn();
		Thread.sleep(2000);
		log.info("Clicked on Runtime settings button to verfiy Global set temperature for farnhenit unit");

		Trs.ZoneTemperatureBtnISEnabled();
		Thread.sleep(1200);
		Trs.ZoneTemperatureBtn();
		Thread.sleep(2200);
		log.info("Clicked on Zone temperature button to setglobal min value for farnhenit unit");

		// setting global point to Min-1 value and validating tank,Manifold,hose and
		// applicator values for farnheit unit

		Trs.setGlobalSetPoint(lessfhminval);
		log.info("global set point temperature set to min-1 value " + lessfhminval + "for farnhenit unit");
		Thread.sleep(3000);

		Trs.clickSavebtn();
		Thread.sleep(3200);
		log.info("global point saved to " + lessfhminval + "for farnhenit unit");

		String tankspforgpminfh = Trs.getTankSetPoint();
		softAssert.assertEquals(Constants.MinglobalMinFarh, tankspforgpminfh,
				"Tank set point is not set to Minimum value : " + Constants.MinglobalMinFarh + "for farnhenit unit");
		log.info("Tank set point for global minimun point is set to :" + Constants.MinglobalMinFarh
				+ "for farnhenit unit");

		String manifoldforgpminfh = Trs.getManifold();
		softAssert.assertEquals(Constants.MinglobalMinFarh, manifoldforgpminfh,
				"Manifold set point is not set to Default value : " + Constants.MinglobalMinFarh
						+ "for farnhenit unit");
		log.info("Manifold set point is set to Minium value :" + Constants.MinglobalMinFarh + "for farnhenit unit");
		Thread.sleep(1500);

		List<String> hosestpntfh = Trs.getHoseSetTemp();
		int count = 1;
		for (int i = 0; i < hosestpntfh.size(); i++) {
			if (hosestpntfh.get(i).equals(Constants.MinglobalMinFarh)) {
				log.info("Hose" + count + "set point temperature for global min value set to"
						+ Constants.MinglobalMinFarh + "for farnhenit unit");

			}

			else

				log.info("Hose" + count + "set point temperature for global min  value not set to"
						+ Constants.MinglobalMinFarh + "for farnhenit unit");
			count++;
		}

		Thread.sleep(2000);
		List<String> applicatorsetpntfh = Trs.getApplicatorSetTemp();
		count = 1;
		for (int i = 0; i < applicatorsetpntfh.size(); i++) {
			if (applicatorsetpntfh.get(i).equals(Constants.MinglobalMinFarh)) {
				log.info("Applicator" + count + "set point temperature for global min value set to"
						+ applicatorsetpntfh.get(i) + "for farnhenit unit");
			} else

				log.info("Applicator" + count + "set point temperature for global min value not set to "
						+ applicatorsetpntfh.get(i) + "for farnhenit unit");
			count++;
		}

		// setting global point to Max+1 value and validating tank,Manifold,hose and
		// applicator values

		Trs.setGlobalSetPoint(maxplusfhval);
		log.info("global set point temperature set to max+1 value " + maxplusfhval + "for farnhenit unit");
		Thread.sleep(3000);

		Trs.clickSavebtn();
		Thread.sleep(3200);
		log.info("global point saved to " + maxplusfhval + "for farnhenit unit");

		String tankspforgpmaxfh = Trs.getTankSetPoint();
		softAssert.assertEquals(Constants.MaxsetglobaltankpntpntFarh, tankspforgpmaxfh,
				"Tank set point is not set to maximum value : " + Constants.MaxsetglobaltankpntpntFarh
						+ "for farnhenit unit");
		log.info("Tank set point for global maximum point is set to :" + Constants.MaxsetglobaltankpntpntFarh
				+ "for farnhenit unit");

		String manifoldforgpmaxfh = Trs.getManifold();
		softAssert.assertEquals(Constants.MaxsetglobalManifoldpntFarh, manifoldforgpmaxfh,
				"Manifold set point is not set to Default value : " + Constants.MaxsetglobalManifoldpntFarh
						+ "for farnhenit unit");
		log.info("Manifold set point is set to Maximum value :" + Constants.MaxsetglobalManifoldpntFarh
				+ "for farnhenit unit");
		Thread.sleep(1500);

		List<String> hosestpntmaxfh = Trs.getHoseSetTemp();
		count = 1;
		for (int i = 0; i < hosestpntmaxfh.size(); i++) {
			if (hosestpntmaxfh.get(i).equals(maxplusfhval)) {
				log.info("Hose" + count + "set point temperature for global min value set to" + hosestpntmaxfh.get(i)
						+ "for farnhenit unit");

			}

			else

				log.info("Hose" + count + "set point temperature for global min  value not set to"
						+ hosestpntmaxfh.get(i) + "for farnhenit unit");
			count++;
		}

		Thread.sleep(2000);
		List<String> applicatorsetpntmaxfh = Trs.getApplicatorSetTemp();
		count = 1;
		for (int i = 0; i < applicatorsetpntmaxfh.size(); i++) {

			if (applicatorsetpntmaxfh.get(i).equals(maxplusfhval)) {
				log.info("Applicator" + count + "set point temperature for global min value set to"
						+ applicatorsetpntmaxfh.get(i) + "for farnhenit unit");
			} else

				log.info("Applicator" + count + "set point temperature for global min value not set to "
						+ applicatorsetpntmaxfh.get(i) + "for farnhenit unit");
			count++;
		}

		// setting global point to Inrange value and validating tank,Manifold,hose and
		// applicator values

		Trs.setGlobalSetPoint(Inrngfh);
		log.info("global set point temperature set to min-1 value " + Inrngfh + "for farnhenit unit");
		Thread.sleep(3000);

		Trs.clickSavebtn();
		Thread.sleep(3200);
		log.info("global point saved to " + Inrngfh + "for farnhenit unit");

		String tankspforInrngfh = Trs.getTankSetPoint();
		softAssert.assertEquals(Inrngfh, tankspforInrngfh,
				"Tank set point is not set to Inrng value : " + Inrngfh + "for farnhenit unit");
		log.info("Tank set point for global Inrng point is set to :" + Inrngfh + "for farnhenit unit");

		String manifoldforInrngfh = Trs.getManifold();
		softAssert.assertEquals(Inrngfh, manifoldforInrngfh,
				"Manifold set point is not set to Default value : " + Inrngfh + "for farnhenit unit");
		log.info("Manifold set point is set to Inrng value :" + Inrngfh + "for farnhenit unit");
		Thread.sleep(1500);

		List<String> hosestpntInrngfh = Trs.getHoseSetTemp();
		count = 1;
		for (int i = 0; i < hosestpntInrngfh.size(); i++) {
			if (hosestpntInrngfh.get(i).equals(Inrngfh)) {
				log.info("Hose" + count + "set point temperature for global Inrng value set to" + Inrngfh
						+ "for farnhenit unit");

			}

			else

				log.info("Hose" + count + "set point temperature for global Inrng value not set to" + Inrngfh
						+ "for farnhenit unit");
			count++;
		}

		Thread.sleep(2000);
		List<String> applicatorsetpntInrngfh = Trs.getApplicatorSetTemp();
		count = 1;
		for (int i = 0; i < applicatorsetpntInrngfh.size(); i++) {
			if (applicatorsetpntInrngfh.get(i).equals(Inrngfh)) {
				log.info("Applicator" + count + "set point temperature for global min value set to"
						+ applicatorsetpntInrngfh.get(i) + "for farnhenit unit");
			} else

				log.info("Applicator" + count + "set point temperature for global min value not set to "
						+ applicatorsetpntInrngfh.get(i) + "for farnhenit unit");
			count++;
		}

		XLUtils.setExcelSheetNm("TankPointCelsius");

	}

	// tank field validations

	@Test(priority = 3, dataProvider = "ReadDP", dataProviderClass = com.nordson.utilities.XLUtils.class)
	public void Test_Celsius_RuntimeMinmaxTankval(String minlsvalue, String maxplusval, String Inrngval
			) throws InterruptedException, IOException {

		Trs = new TemperatureRuntimeSettings(driver);

		// Setting back to celsius unit to verfiy tank setpoint

		Trs.SystemSettingsBtnISEnabled();
		Thread.sleep(1200);
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");
		Thread.sleep(2000);

		Trs.PreferencesBtnISEnabled();
		Thread.sleep(2000);
		Trs.clickPreferencesBtn();
		Thread.sleep(1200);
		log.info("Preferences is clicked to opt Unit celsius temperature");

		Trs.clickCelsiusUnit();
		log.info("Temperature Unit celsuis is selected by clicking");
		Thread.sleep(2000);

		Trs.clickSave();
		Thread.sleep(2000);

		Trs.RuntimeSettingsBtnISEnabled();
		Thread.sleep(1200);
		Trs.RuntimeSettingsBtn();
		Thread.sleep(2000);
		log.info("Clicked on Runtime settings button to verfiy temperature Celsius Unit vals");

		Trs.ZoneTemperatureBtnISEnabled();
		Trs.ZoneTemperatureBtn();
		Thread.sleep(3200);
		log.info("Clicked on Zone temperature button to setglobal min value in Celsuis");

		// clearing the Tank Point and verifying the Error for Celsius unit

		Trs.clearTanktemperature();
		Thread.sleep(2000);
		Trs.clickSavebtn();

		boolean tsterrmsg = Trs.getToastmsg();
		softAssert.assertEquals(true, tsterrmsg, "Toast Error message is shown up for null val for Celsius unit");
		log.info("Toast Error message is shown up for null val save for Celsius unit");
		Thread.sleep(3000);

		boolean stusclrerrmsg = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusclrerrmsg, "Error message is shown up for null val for Celsius unit");
		log.info("Error message is shown up for null val save for Celsius unit");
		Thread.sleep(3000);

		// min-1 val

		Trs.clearTanktemperature();
		Thread.sleep(1200);
		Trs.setTankSetPoint(minlsvalue);
		Thread.sleep(1200);
		Trs.clickSavebtn();

		boolean tstminerr = Trs.getToastmsg();
		softAssert.assertEquals(true, tstminerr, "Toast Error message is shown up for Celsius unit");
		log.info("Toast Error message is shown up for " + minlsvalue + " min-1 val for Celsius unit");
		Thread.sleep(2000);

		boolean stusminerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusminerr, "Error message is shown up for Celsius unit");
		log.info("Error message is shown up for " + minlsvalue + " min-1 val for Celsius unit");
		Thread.sleep(2000);

		// max+1 val

		Trs.clearTanktemperature();
		Thread.sleep(1200);
		Trs.setTankSetPoint(maxplusval);
		Thread.sleep(1200);
		Trs.clickSavebtn();

		boolean tstmaxerr = Trs.getToastmsg();
		softAssert.assertEquals(true, tstmaxerr,
				"Toast Error message is shown up for " + maxplusval + " val for Celsius unit");
		log.info("Toast Error message is shown up for max val");
		Thread.sleep(2000);

		boolean stusmaxerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusmaxerr,
				"Error message is shown up for " + maxplusval + " val for Celsius unit");
		log.info("Error message is shown up for max val");
		Thread.sleep(2000);

		// In Range value testing

		Trs.clearTanktemperature();
		Thread.sleep(1200);
		log.info("Tank temperature cleared to enter Inrange value for Celsius unit");
		Trs.setTankSetPoint(Inrngval);
		Thread.sleep(200);
		Trs.clickSavebtn();

		boolean tstmsgstus = Trs.getToastmsg();
		System.out.println(tstmsgstus);
		softAssert.assertEquals(true, tstmsgstus,
				"Toast msg for In range values are saved successfully for Celsius unit");
		log.info("Toast msg for In range value " + Inrngval + " are saved successfully for Celsius unit");

		boolean stus = Trs.getbtnstatus();
		softAssert.assertEquals(false, stus, "In range values are saved successfully for Celsius unit");
		log.info("In range value " + Inrngval + " are saved successfully for Celsius unit");
		Thread.sleep(3000);
		XLUtils.setExcelSheetNm("TankPointFarnhit");

	}
  
	@Test(priority = 4, dataProvider = "ReadDP", dataProviderClass = com.nordson.utilities.XLUtils.class)
	public void Test_Farnhit_RuntimeMinmaxTankval(String minlsvaluefh, String maxplusvalfh, String Inrngvaluefh) throws InterruptedException, IOException {

		{
			// clearing the Tank Point and verifying the Error for Farnheit unit

			Am = new ActionMethods();

			Trs.SystemSettingsBtnISEnabled();
			Thread.sleep(1200);
			Trs.clickSystemSettingsBtn();
			log.info("Clicked on System settings button");
			Thread.sleep(2000);

			Trs.PreferencesBtnISEnabled();
			Thread.sleep(2000);
			Trs.clickPreferencesBtn();
			Thread.sleep(1200);
			log.info("Preferences is clicked to opt Unit Farhenit temperature");

			Trs.clickFarhenitUnit();
			log.info("Temperature Unit Farhenit is selected by clicking");
			Thread.sleep(2000);

			Trs.clickSave();
			Thread.sleep(3000);
			log.info("Clicked on Save button to Opt farnheit Unit temperature");

			Trs.RuntimeSettingsBtnISEnabled();
			Thread.sleep(1200);
			Trs.RuntimeSettingsBtn();
			Thread.sleep(2000);
			log.info("Clicked on Runtime settings button to verfiy temperature farnheit Unit vals");

			Trs.ZoneTemperatureBtnISEnabled();
			Trs.ZoneTemperatureBtn();
			Thread.sleep(3200);
			log.info("Clicked on Zone temperature button to setglobal min value in farheit");

			// Null value Err tst verfication

			Trs.clearTanktemperature();
			Thread.sleep(1200);
			log.info("Tank temperature cleared to verfiy err msg");
			Trs.clickSavebtn();
			Thread.sleep(1500);

			boolean tstnullerrfhmsg = Trs.getToastmsg();
			softAssert.assertEquals(true, tstnullerrfhmsg,
					"Toast Error message is shown up for farnheit unit null val save");
			log.info("Toast Error message is shown up for null val for farnheit unit");
			Thread.sleep(2000);

			boolean stusnullerrfh = Trs.getbtnstatus();
			softAssert.assertEquals(true, stusnullerrfh, "Error message is shown up for farnheit unit null val save");
			log.info("Error message is shown up for null val for farnheit unit");
			Thread.sleep(2000);

			// min-1 val

			Trs.clearTanktemperature();
			Thread.sleep(1200);
			Trs.setTankSetPoint(minlsvaluefh);
			Thread.sleep(1200);
			Trs.clickSavebtn();
			Thread.sleep(1500);

			boolean tstminerrfh = Trs.getToastmsg();
			softAssert.assertEquals(true, tstminerrfh, "Toast Error message is shown up for farnheit unit");
			log.info("Toast Error message is shown up for " + minlsvaluefh + " min-1 val for farnheit unit");
			Thread.sleep(2000);

			boolean stusminerrfh = Trs.getbtnstatus();
			softAssert.assertEquals(true, stusminerrfh, "Error message is shown up for farnheit unit");
			log.info("Error message is shown up for " + minlsvaluefh + " min-1 val for farnheit unit");
			Thread.sleep(2000);

			// max+1 val

			Trs.clearTanktemperature();
			Thread.sleep(1200);
			Trs.setTankSetPoint(maxplusvalfh);
			Thread.sleep(1200);
			Trs.clickSavebtn();
			Thread.sleep(1200);

			boolean tstmaxerrfh = Trs.getToastmsg();
			softAssert.assertEquals(true, tstmaxerrfh,
					"Toast Error message is shown up for " + maxplusvalfh + " val for Farnheit unit");
			log.info("Toast Error message is shown up for" + maxplusvalfh + " for Farnheit unit");
			Thread.sleep(2000);

			boolean stusmaxerrfh = Trs.getbtnstatus();
			softAssert.assertEquals(true, stusmaxerrfh,
					"Error message is shown up for " + maxplusvalfh + " val for Farnheit unit");
			log.info("Error message is shown up for" + maxplusvalfh + " for Farnheit unit");
			Thread.sleep(2000);

			// In Range value testing

			Trs.clearTanktemperature();
			Thread.sleep(1200);
			log.info("Tank temperature cleared to enter Inrange value for Farnheit unit");

			Thread.sleep(1200);
			Tankpoint=Inrngvaluefh;
			Trs.setTankSetPoint(Inrngvaluefh);
			Thread.sleep(1200);
			Trs.clickSavebtn();
			Thread.sleep(2000);

			boolean tstfh = Trs.getToastmsg();
			softAssert.assertEquals(true, tstfh,
					" Toast msg for In range values are saved successfully for Farnheit unit");
			log.info("Toast msg for In range values are saved successfully for Farnheit unit");
			Thread.sleep(3000);

			boolean stusfh = Trs.getbtnstatus();
			softAssert.assertEquals(false, stusfh, "In range values are saved successfully for Farnheit unit");
			log.info("In range values are saved successfully for Farnheit unit");
			Thread.sleep(2000);

			// Verifying the Tankpnt, Manifold,Hose and Applicators

			String tankspforInrngfh = Trs.getTankSetPoint();
			softAssert.assertEquals(Inrngvaluefh, tankspforInrngfh,
					"Tank set point is not set to Inrng value : " + Inrngvaluefh + "for farnhenit unit");
			log.info("Tank set point for global Inrng point is set to :" + Inrngvaluefh + "for farnhenit unit");

			String manifoldforInrngfh = Trs.getManifold();
			softAssert.assertEquals(Inrngvaluefh, manifoldforInrngfh,
					"Manifold set point is not set to Default value : " + Inrngvaluefh + "for farnhenit unit");
			log.info("Manifold set point is set to Inrng value :" + Inrngvaluefh + "for farnhenit unit");
			Thread.sleep(1500);

			XLUtils.setExcelSheetNm("HoseCelsius");
		}

	}

	@Test(priority = 5, dataProvider = "ReadDP", dataProviderClass = com.nordson.utilities.XLUtils.class)
	public void Test_Celsius_RuntimeMinmaxHoseval(String minlsvalue, String maxplusval, String Inrngval) throws InterruptedException, IOException {

		// Verfiying the values by checking the status and enabling hose for celsius
		// unit

		Trs.SystemSettingsBtnISEnabled();
		Thread.sleep(1200);
		Trs.clickSystemSettingsBtn();
		Thread.sleep(2000);
		log.info("Clicked on System settings button");

		Trs.PreferencesBtnISEnabled();
		Thread.sleep(1200);
		Trs.clickPreferencesBtn();
		Thread.sleep(1500);
		log.info("Preferences is clicked to opt Unit Celsius temperature");

		Trs.clickCelsiusUnit();
		log.info("Temperature Unit Celsius is selected by clicking");
		Thread.sleep(3200);

		Trs.clickSave();
		Thread.sleep(3000);
		log.info("Clicked on Save button to Opt Celsius Unit temperature");

		Trs.RuntimeSettingsBtnISEnabled();
		Trs.RuntimeSettingsBtn();
		Thread.sleep(2000);
		log.info("Clicked on Runtime settings button to verfiy temperature Celsius Unit vals");

		Trs.ZoneTemperatureBtnISEnabled();
		Trs.ZoneTemperatureBtn();
		Thread.sleep(3200);
		log.info("Clicked on Zone temperature button to setglobal min value in Celsius");

		// checking the status and enabling hose

		Trs.clickOnHose1toEnable();
		Thread.sleep(2200);

		// clearing the hose1

		Trs.clearHosesetTemperature();
		Thread.sleep(2000);
		Trs.clickSavebtn();
		Thread.sleep(1200);

		boolean stusclrerrmsgtst = Trs.getToastmsg();
		softAssert.assertEquals(true, stusclrerrmsgtst, "Toast Error message is not shown up for max Celsius val");
		log.info("Toast Error message is shown up for null Celsius val save");
		Thread.sleep(1000);

		boolean stusclrerrmsg = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusclrerrmsg, "Error message is not shown up for max Celsius val");
		log.info("Error message is shown up for null Celsius val save");
		Thread.sleep(1200);

		// min-1 val

		Trs.clearHosesetTemperature();
		Thread.sleep(1200);
		Trs.setHose1emperature(minlsvalue);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1200);

		boolean tstminerr = Trs.getToastmsg();
		softAssert.assertEquals(true, tstminerr, "ToastError message is not shown up for Celsius unit");
		log.info("Toast Error message is shown up for min-1" + minlsvalue + "for Celsius unit");
		Thread.sleep(2000);

		boolean stusminerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusminerr, "Error message is not shown up for Celsius unit");
		log.info("Error message is shown up for min-1" + minlsvalue + "for Celsius unit");
		Thread.sleep(2000);

		// max+1 val

		Trs.clearHosesetTemperature();
		Thread.sleep(1200);
		Trs.setHose1emperature(maxplusval);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(2000);

		boolean tstmaxerr = Trs.getToastmsg();
		softAssert.assertEquals(true, tstmaxerr,
				"Toast Error message is  not shown up for max plus val for Celsius unit");
		log.info("Toast Error message is shown up for max val plus " + maxplusval + " for Celsius unit");
		Thread.sleep(2000);

		boolean stusmaxerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusmaxerr, "Error message is  not shown up for max plus val for Celsius unit");
		log.info("Error message is shown up for max val plus " + maxplusval + " for Celsius unit");
		Thread.sleep(2000);

		// In Range value testing

		Trs.clearHosesetTemperature();
		Thread.sleep(1200);
		log.info("Tank temperature cleared to enter Inrange value");

		Thread.sleep(1200);
		
		Trs.setHose1emperature(Inrngval);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(2000);

		boolean tstsucssmsg = Trs.getToastmsg();
		softAssert.assertEquals(true, tstsucssmsg, "Toast msg In range values are not saved for Celsius unit");
		log.info("Toast msg In range values are saved successfully for Celsius unit");
		Thread.sleep(3000);

		boolean stus = Trs.getbtnstatus();
		softAssert.assertEquals(false, stus, "In range values are saved successfully for Celsius unit");
		log.info("In range values are saved successfully for Celsius unit");
		Thread.sleep(3000);

		String hstmp1 = Trs.getHosetemp1();
		softAssert.assertEquals(Inrngval, hstmp1, "Hose1 set temp value is not " + Inrngval + " Celsius unit");
		log.info("Hose1 set temp value is not " + Inrngval + " Celsius unit");
		Thread.sleep(2000);

		// checking the status and enabling Applicator

		Trs.clickApplicator1toEnable();
		Thread.sleep(2000);

		// clearing the Applicator1

		Trs.clearApplicator1setTemperature();
		Thread.sleep(2000);
		Trs.clickSavebtn();
		Thread.sleep(1200);

		boolean appclrerrmsgtst = Trs.getToastmsg();
		softAssert.assertEquals(true, appclrerrmsgtst,
				"Toast Error message is not shown up for max Celsius val for Applicator1");
		log.info("Toast Error message is shown up for null Celsius val save for Applicator1");
		Thread.sleep(3000);

		boolean appclrerrmsg = Trs.getbtnstatus();
		softAssert.assertEquals(true, appclrerrmsg,
				"Error message is not shown up for max Celsius val for Applicator1");
		log.info("Error message is shown up for null Celsius val save for Applicator1");
		Thread.sleep(3000);

		// min-1 val

		Trs.clearApplicator1setTemperature();
		Thread.sleep(1200);
		Trs.Applicator1temperature(minlsvalue);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1200);

		boolean apptstminerr = Trs.getToastmsg();
		softAssert.assertEquals(true, apptstminerr, "ToastError message is not shown up for Celsius unit Applicator1 ");
		log.info("Toast Error message is shown up for min-1" + minlsvalue + "for Celsius unit Applicator1");
		Thread.sleep(2000);

		boolean appstusminerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, appstusminerr, "Error message is not shown up for Celsius unit Applicator1");
		log.info("Error message is shown up for min-1" + minlsvalue + "for Celsius unit Applicator1");
		Thread.sleep(2000);

		// max+1 val

		Trs.clearApplicator1setTemperature();
		Thread.sleep(1200);
		Trs.Applicator1temperature(maxplusval);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1200);

		boolean apptstmaxerr = Trs.getToastmsg();
		softAssert.assertEquals(true, apptstmaxerr,
				"Toast Error message is  not shown up for max plus val for Celsius unit Applicator1");
		log.info("Toast Error message is shown up for max val plus " + maxplusval + " for Celsius unit Applicator1");
		Thread.sleep(2000);

		boolean appstusmaxerr = Trs.getbtnstatus();
		softAssert.assertEquals(true, appstusmaxerr,
				"Error message is  not shown up for max plus val for Celsius unit Applicator1");
		log.info("Error message is shown up for max val plus " + maxplusval + " for Celsius unit Applicator1");
		Thread.sleep(2000);

		// In Range value testing

		Trs.clearApplicator1setTemperature();
		Thread.sleep(1200);
		log.info("Tank temperature cleared to enter Inrange value");

		
		Trs.Applicator1temperature(Inrngval);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(2000);

		boolean apptstsucssmsg = Trs.getToastmsg();
		softAssert.assertEquals(true, apptstsucssmsg,
				"Toast msg In range values are not saved for Celsius unit Applicator1");
		log.info("Toast msg In range values are saved successfully for Celsius unit Applicator1");
		Thread.sleep(3000);

		boolean appstus = Trs.getbtnstatus();
		softAssert.assertEquals(false, appstus, "In range values are saved successfully for Celsius unit Applicator1");
		log.info("In range values are saved successfully for Celsius unit Applicator1");
		Thread.sleep(3000);
		
		XLUtils.setExcelSheetNm("HoseFarnhit");
	}
	
	@Test(priority = 6, dataProvider = "ReadDP", dataProviderClass = com.nordson.utilities.XLUtils.class)
	public void Test_Farnhit_RuntimeMinmaxHoseApplicator1val(String minlsvaluefh, String maxplusvalfh, String Inrngvaluefh) throws InterruptedException, IOException {

		// Farnheit Validations

		Trs.SystemSettingsBtnISEnabled();
		Thread.sleep(1200);
		Trs.clickSystemSettingsBtn();
		Thread.sleep(1500);
				
		
		Trs.PreferencesBtnISEnabled();
		Thread.sleep(1200);
		Trs.clickPreferencesBtn();
		Thread.sleep(1500);

		Trs.clickFarhenitUnit();
		log.info("Temperature Unit Farhenit is selected for verfying hose and applicator value");
		Thread.sleep(2500);
		
		Trs.clickSave();
		Thread.sleep(2000);
		
		log.info("Saved Farhenit option for verfying hose and applicator value");
		

		Trs.RuntimeSettingsBtnISEnabled();
		Thread.sleep(1200);
		Trs.RuntimeSettingsBtn();
		log.info("Clicked on Temperature in Runtime settings to validate Celsius to farhenit conversion");
		Thread.sleep(2000);
		
		Trs.ZoneTemperatureBtnISEnabled();
		Thread.sleep(2000);
		Trs.ZoneTemperatureBtn();

		// Null value Validations

		Trs.clearHosesetTemperature();
		Thread.sleep(2000);
		Trs.clickSavebtn();
		Thread.sleep(2000);
		log.info("Cleared the hose to verfiy error toast msg");

		boolean tstclrerrmsgfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tstclrerrmsgfh, "Toast Error message is not shown up for null farnheit val");
		log.info("Toast Error message is shown up for null farnheit val save");

		boolean stusclrerrmsgfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusclrerrmsgfh, "Error message is not shown up for null farnheit val");
		log.info("Error message is shown up for null farnheit val save");
		Thread.sleep(3000);

		// min-1 val

		Trs.clearHosesetTemperature();
		Thread.sleep(1200);
		Trs.setHose1emperature(minlsvaluefh);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1200);

		boolean tstminerrfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tstminerrfh, "Toast error message is not shown up for farnheit unit");
		log.info("Toast error message is shown up for min-1" + minlsvaluefh + "for farnheit unit");
		Thread.sleep(2000);

		boolean stusminerrfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusminerrfh, "Error message is not shown up for farnheit unit");
		log.info("Error message is shown up for min-1" + minlsvaluefh + "for farnheit unit");
		Thread.sleep(2000);

		// max+1 val

		Trs.clearHosesetTemperature();
		Thread.sleep(1200);
		Trs.setHose1emperature(maxplusvalfh);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1500);

		boolean tstmaxerrfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tstmaxerrfh,
				"Toast error message is  not shown up for max plus val for farnheit unit");
		log.info("Toast error message is shown up for max val plus " + maxplusvalfh + " for farnheit unit");
		Thread.sleep(2000);

		boolean stusmaxerrfh = Trs.getbtnstatus();
		softAssert.assertEquals(true, stusmaxerrfh,
				"Error message is  not shown up for max plus val for farnheit unit");
		log.info("Error message is shown up for max val plus " + maxplusvalfh + " for farnheit unit");
		Thread.sleep(2000);

		// In Range value testing

		Trs.clearHosesetTemperature();
		Thread.sleep(1200);
		log.info("Tank temperature cleared to enter Inrange value for farnheit unit");

		Hosepnt=Inrngvaluefh;
		Trs.setHose1emperature(Inrngvaluefh);
		Thread.sleep(1200);
		Trs.clickSavebtn();
		Thread.sleep(1000);

		boolean tstmsgfh = Trs.getToastmsg();
		softAssert.assertEquals(true, tstmsgfh, "Toast msg In range values are saved successfully for farnheit unit");
		log.info("Toast msg In range values are saved successfully for farnheit unit");
		Thread.sleep(3000);

		boolean stusfh = Trs.getbtnstatus();
		softAssert.assertEquals(false, stusfh, "In range values are saved successfully for farnheit unit");
		log.info("In range values are saved successfully for farnheit unit");
		Thread.sleep(3000);
		
		// checking the status and enabling Applicator

				// clearing the Applicator1

				Trs.clearApplicator1setTemperature();
				Thread.sleep(2000);
				Trs.clickSavebtn();
				Thread.sleep(1200);

				boolean appclrerrmsgtst = Trs.getToastmsg();
				softAssert.assertEquals(true, appclrerrmsgtst,
						"Toast Error message is not shown up for max Farnhit val for Applicator1");
				log.info("Toast Error message is shown up for null Farnhit val save for Applicator1");
				Thread.sleep(3000);

				boolean appclrerrmsg = Trs.getbtnstatus();
				softAssert.assertEquals(true, appclrerrmsg,
						"Error message is not shown up for max Farnhit val for Applicator1");
				log.info("Error message is shown up for null Farnhit val save for Applicator1");
				Thread.sleep(3000);

				// min-1 val

				Trs.clearApplicator1setTemperature();
				Thread.sleep(1200);
				Trs.Applicator1temperature(minlsvaluefh);
				Thread.sleep(1200);
				Trs.clickSavebtn();
				Thread.sleep(1200);

				boolean apptstminerr = Trs.getToastmsg();
				softAssert.assertEquals(true, apptstminerr, "ToastError message is not shown up for Farnhit unit Applicator1 ");
				log.info("Toast Error message is shown up for min-1" + minlsvaluefh + "for Farnhit unit Applicator1");
				Thread.sleep(2000);

				boolean appstusminerr = Trs.getbtnstatus();
				softAssert.assertEquals(true, appstusminerr, "Error message is not shown up for Farnhit unit Applicator1");
				log.info("Error message is shown up for min-1" + minlsvaluefh + "for Farnhit unit Applicator1");
				Thread.sleep(2000);

				// max+1 val

				Trs.clearApplicator1setTemperature();
				Thread.sleep(1200);
				Trs.Applicator1temperature(maxplusvalfh);
				Thread.sleep(1200);
				Trs.clickSavebtn();
				Thread.sleep(1200);

				boolean apptstmaxerr = Trs.getToastmsg();
				softAssert.assertEquals(true, apptstmaxerr,
						"Toast Error message is  not shown up for max plus val for Farnhit unit Applicator1");
				log.info("Toast Error message is shown up for max val plus " + maxplusvalfh + " for Farnhit unit Applicator1");
				Thread.sleep(2000);

				boolean appstusmaxerr = Trs.getbtnstatus();
				softAssert.assertEquals(true, appstusmaxerr,
						"Error message is  not shown up for max plus val for Farnhit unit Applicator1");
				log.info("Error message is shown up for max val plus " + maxplusvalfh + " for Farnhit unit Applicator1");
				Thread.sleep(2000);

				// In Range value testing

				Trs.clearApplicator1setTemperature();
				Thread.sleep(1200);
				log.info("Applicator1 temperature cleared to enter Inrange value");

				Applicatorpnt=Inrngvaluefh;
				Trs.Applicator1temperature(Inrngvaluefh);
				Thread.sleep(1200);
				Trs.clickSavebtn();
				Thread.sleep(2000);

				boolean apptstsucssmsg = Trs.getToastmsg();
				softAssert.assertEquals(true, apptstsucssmsg,
						"Toast msg In range values are not saved for Farnhit unit Applicator1");
				log.info("Toast msg In range values are saved successfully for Farnhit unit Applicator1");
				Thread.sleep(3000);

				boolean appstus = Trs.getbtnstatus();
				softAssert.assertEquals(false, appstus, "In range values are saved successfully for Farnhit unit Applicator1");
				log.info("In range values are saved successfully for Farnhit unit Applicator1");
				Thread.sleep(3000);
	
	}
	
	
	@Test(priority = 7)
	public void Test_farnhit_ToCelsius_RuntimeSetttings_Conversion() throws InterruptedException {
		
		
		
		Trs.SystemSettingsBtnISEnabled();
		Thread.sleep(1200);
		Trs.clickSystemSettingsBtn();
		Thread.sleep(1500);
				
		
		Trs.PreferencesBtnISEnabled();
		Thread.sleep(1200);
		Trs.clickPreferencesBtn();
		Thread.sleep(1500);

		Trs.clickCelsiusUnit();
		log.info("Temperature Unit Farhenit is selected by clicking to verfiy conversion");
		Thread.sleep(2500);
		
		Trs.clickSave();
		Thread.sleep(2000);
		
		log.info("Saved Farhenit option to verfiy conversion");
		

		Trs.RuntimeSettingsBtnISEnabled();
		Thread.sleep(1200);
		Trs.RuntimeSettingsBtn();
		log.info("Clicked on Temperature in Runtime settings to validate Celsius to farhenit conversion");
		Thread.sleep(2000);
		
		Trs.ZoneTemperatureBtnISEnabled();
		Thread.sleep(2000);
		Trs.ZoneTemperatureBtn();

		//Tank point
		String Tnkclspnt = ActionMethods.getConversionToCelsius(Tankpoint);
		String tspui=Trs.getTankSetPoint();
		System.out.println(tspui);
		softAssert.assertEquals(Tnkclspnt, tspui, "Celsius to Farnhit unit conversion not correct for tank point");
		log.info("Celsius" +Tankpoint+"is converted to Farnhit unit"+Tnkclspnt+" conversion for Tank point is correct");
		Thread.sleep(1000);
		
		// Hose Point
		String hosetemp1=Trs.getHosetemp1();
		System.out.println(hosetemp1);
		String hoseclspnt = ActionMethods.getConversionToCelsius(Hosepnt);
		softAssert.assertEquals(hoseclspnt,hosetemp1, "Celsius to Farnhit unit conversion not correct for Hose point");
		log.info("Celsius" +Hosepnt+"is converted to Farnhit unit"+hoseclspnt+" conversion for Tank point is correct");
		Thread.sleep(1000);
		
		// Applicator
		
		String Applicatorpntcvtd = ActionMethods.getConversionToCelsius(Applicatorpnt);
		String apptemp1=Trs.getAPP1temp1();
		System.out.println(apptemp1);
		softAssert.assertEquals(Applicatorpntcvtd,apptemp1, "Celsius to Farnhit unit conversion not correct for applicator point");
		log.info("Celsius" +Hosepnt+"is converted to Farnhit unit"+Applicatorpntcvtd+" conversion for applicator point is correct");
		
		

	}
	
	
	@DataProvider(name = "TemperatureTestData")
	public static String[][] getDataTemp() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nordson/testData/Temperature.xlsx";

		int rownum = XLUtils.getRowCount(path, "GlobalPointCelsius");
		int colcount = XLUtils.getCellCount(path, "GlobalPointCelsius", 1);
		int colcnt = colcount - 1;

		System.out.println("No of Rows= " + rownum);
		System.out.println("No of Columns= " + colcnt);
		String tempdata[][] = new String[rownum][colcnt];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 1; j <= colcnt; j++) {
				tempdata[i - 1][j - 1] = XLUtils.getCellData(path, "GlobalPointCelsius", i, j);// 1 1

			}

		}
		return tempdata;
	}
}
