package com.nordson.testCases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nordson.pageObjects.TemperatureRuntimeSettings;
import com.nordson.utilities.ActionMethods;
import com.nordson.utilities.Constants;


public class TC_RuntimeDefaultSettings_TemperatureTest extends TC_LoginTest_DDT_001 {

	TemperatureRuntimeSettings Trs;
	ActionMethods Am;
	TC_LoginTest_DDT_001 lg;
	private SoftAssert softAssert = new SoftAssert();

	@Test(priority = 1, enabled = true)
	public void TestRuntimeSettingDefaultTempValidations() throws InterruptedException, IOException {

		Trs = new TemperatureRuntimeSettings(driver);
		Trs.SetUpToolBtnISEnabled();
		Thread.sleep(1800);
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
		Thread.sleep(2000);
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");
		Thread.sleep(2000);

		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		log.info("Clicked on Preferences button");
		Thread.sleep(2000);

		Boolean tempvalue = Trs.getTemperatureunit();
		Thread.sleep(2000);
		if (tempvalue == true) {
			Trs.clickCelsiusUnit();
			Thread.sleep(2000);
			log.info("Temperature Unit celsius is selected by clicking");
		} else
			log.info("Temperature Unit celsius is selected by default");

		Trs.RuntimeSettingsBtnISEnabled();
		Thread.sleep(2000);
		Trs.RuntimeSettingsBtn();
		Thread.sleep(2000);

		Trs.ZoneTemperatureBtnISEnabled();
		Thread.sleep(2000);
		Trs.ZoneTemperatureBtn();
		Thread.sleep(2000);

       // Verfication of Default Values for Celsius unit		
		
		String globalSetPoint = Trs.getGlobalSetPoint();
		softAssert.assertTrue(globalSetPoint.isEmpty(), "Global set point is set null for celsius unit");
		log.info("Global set point is set null for celsius unit");
		
		String tempunt=Trs.getTemperatureunt();
		softAssert.assertEquals("oC", tempunt,
				"Global set point is not set to Default  celsius unit");
		log.info("Global set point is set to Default  celsius unit");
	

		String tanksp = Trs.getTankSetPoint();
		softAssert.assertEquals(Constants.Tank, tanksp,
				"Tank set point is not set to Default value for celsius unit : " + Constants.Tank);
		log.info("Tank set point is set to Default value for celsius unit :" + Constants.Tank);

		String manifold = Trs.getManifold();
		softAssert.assertEquals(Constants.Manifold, manifold,
				"Manifold set point is not set to Default value for celsius unit : " + Constants.Manifold);
		log.info("Manifold set point is set to Default value for celsius unit :" + Constants.Manifold);

		// To check the toggle bar status is enabled or not

		int count = 1;
		List<Integer> hoseEnableststus = Trs.getHoseEnableStatus();

		for (int i = 0; i < hoseEnableststus.size(); i++) {
			if (hoseEnableststus.get(i) > 0) {
				log.info("Hose" + count + "set point temperature is disabled by default for celsius unit");
			} else

				log.info("Hose" + count + "set point temperature is not disabled by default for celsius unit");
			count++;
		}

		// To check all the applicators are enabled or not
		List<Integer> applicatorEnableststus = Trs.getApplicatorEnableStatus();
		count = 1;
		for (int i = 0; i < hoseEnableststus.size(); i++) {
			if (applicatorEnableststus.get(i) > 0) {
				log.info("Applicator" + count + " Set point is disbaled by default for celsius unit");
			} else
				Assert.fail("Applicator" + count + "Set point is enabled and not disabled by default for celsius unit");
			count++;
		}

		// To check the Hose set point temperature
		List<String> hosestpnt = Trs.getHoseSetTemp();
		int hosestpntsz = hosestpnt.size();
		count = 1;
		for (int i = 0; i < hosestpntsz; i++) {
			if (hosestpnt.get(i).equals(Constants.HoseSetTemp)) {
				log.info("Hose" + count + "set point temperature set to default value for celsius unit " + Constants.HoseSetTemp);
			} else

				log.info("Hose" + count + "set point temperature not set to default value for celsius unit " + Constants.HoseSetTemp);
			count++;
		}

		// To check the Applicator set point temperature
		List<String> applicatorsetpnt = Trs.getApplicatorSetTemp();
		int applicatorsetpntsz = hosestpnt.size();
		count = 1;
		for (int i = 0; i < applicatorsetpntsz; i++) {
			if (applicatorsetpnt.get(i).equals(Constants.ApplicatorSetTemp)) {
				log.info("Applicator" + count + "set point temperature set to default value for celsius unit"
						+ Constants.ApplicatorSetTemp);
			} else

				log.info("Applicator" + count + "set point temperature not set to default value for celsius unit"
						+ Constants.ApplicatorSetTemp);
			count++;
		}
		
		// To Validiate the Default Values in Runtime settings for Farnheit Unit
		
		Trs.SystemSettingsBtnISEnabled();
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button to change preferences");
		Thread.sleep(2000);

		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		log.info("Clicked on Preferences to validate Farnheit Default values");
		Thread.sleep(2000);

		Boolean tempvaluefh = Trs.getTemperatureunit();
		if (tempvaluefh == false) {
			Trs.clickFarhenitUnit();
			Thread.sleep(2000);
			log.info("Temperature Unit Farhenit is selected by clicking");
		} else
			log.info("Temperature Unit Farhenit is selected");

		Trs.clickFarhenitUnit();
		Thread.sleep(2000);
		Trs.clickSave();
		Thread.sleep(2500);
		log.info("Farnheit Value saved to verfiy Default values in run time settings");

		Trs.RuntimeSettingsBtnISEnabled();
		Thread.sleep(3000);
		Trs.RuntimeSettingsBtn();
		log.info("Runtime Setting is clicked to verfiy Farnheit Unit deafult values");
		Thread.sleep(2000);

		Trs.ZoneTemperatureBtnISEnabled();
		Thread.sleep(2000);
		Trs.ZoneTemperatureBtn();
		log.info("Zone temperature is clicked to verify default Farnheit Values");
		Thread.sleep(3000);

		String globalSetPointfh = Trs.getGlobalSetPoint();
		softAssert.assertTrue(globalSetPointfh.isEmpty(), "Global set point is not set to null for Farnheit Unit");
		log.info("Global set point is set null for Farnheit Unit");
		
		String tempuntfh=Trs.getTemperatureunt();
		softAssert.assertEquals("oF", tempuntfh,
				"Global set point is not set to Default  celsius unit");
		log.info("Global set point is set to Default  celsius unit");

		String tankspfh = Trs.getTankSetPoint();
		String farhenitvalutp = ActionMethods.getConversionToFahrenheit(Constants.Tank);
		softAssert.assertEquals(farhenitvalutp, tankspfh,
				"Tank set point is not set to Default value : " + farhenitvalutp);
		log.info("Tank set point is set to Default value for Farnheit Unit :" + farhenitvalutp);

		String manifoldfh = Trs.getManifold();
		String farhenitvalump = ActionMethods.getConversionToFahrenheit(Constants.Manifold);
		softAssert.assertEquals(farhenitvalump, manifoldfh,
				"Manifold set point is not set to Default value for Farnheit Unit: " + farhenitvalump);
		log.info("Manifold set point is set to Default value for Farnheit Unit:" + farhenitvalump);

		List<Integer> hoseEnableststusfh = Trs.getHoseEnableStatus();
		count = 1;
		for (int i = 0; i < hoseEnableststusfh.size(); i++) {
			if (hoseEnableststusfh.size() > 0) {
				log.info("Hose " + count + "set point temperature is disabled by default for Farnheit Unit");
			} else

				log.info("Hose " + count + "set point temperature is not disabled by default for Farnheit Unit");

			count++;
		}

		List<Integer> applicatorEnableststusfh = Trs.getApplicatorEnableStatus();
		count = 1;
		for (int i = 0; i < hoseEnableststusfh.size(); i++) {
			if (applicatorEnableststusfh.get(i) > 0) {
				log.info("Applicator " + count + " Set point temperature is disbaled by default");
			} else
				log.info("Applicator " + count + "Set point temperature is enabled and not disabled by default");
			count++;
		}
		List<String> hosestpntfh = Trs.getHoseSetTemp();
		String fahrenitSetpointtemp = ActionMethods.getConversionToFahrenheit(Constants.HoseSetTemp);
		count = 1;
		for (int i = 0; i < hosestpntfh.size(); i++) {
			if (hosestpntfh.get(i).equals(fahrenitSetpointtemp)) {
				log.info("Hose" + count + "set point temperature set to default value for Farnheit Unit" + fahrenitSetpointtemp);
			} else

				log.info("Hose" + count + "set point temperature not set to default value for Farnheit Unit" + fahrenitSetpointtemp);
			count++;
		}

		List<String> applicatorsetpntfh = Trs.getApplicatorSetTemp();
		String appfahrenitSetpointtemp = ActionMethods.getConversionToFahrenheit(Constants.ApplicatorSetTemp);
		count = 1;
		for (int i = 0; i < applicatorsetpntfh.size(); i++) {
			if (applicatorsetpntfh.get(i).equals(appfahrenitSetpointtemp)) {
				log.info("Applicator" + count + "set point temperature set to default value for Farnheit Unit" + appfahrenitSetpointtemp);
			} else

				log.info("Applicator" + count + "set point temperature not set to default value for Farnheit Unit"
						+ appfahrenitSetpointtemp);
			count++;
		}

	}

	}
