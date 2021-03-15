package com.nordson.MDS;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nordson.pageObjects.TemperatureRuntimeSettings;
import com.nordson.testCases.TC_LoginTest_DDT_001;
import com.nordson.utilities.ActionMethods;
import com.nordson.utilities.Constants;
import com.nordson.utilities.ReadConfig;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("Regression Tests")
@Feature("Temperature Runtime settings verification of default values")
public class TC_RuntimeSettings_MDSVal extends TC_LoginTest_DDT_001 {

	TemperatureRuntimeSettings Trs;
	ActionMethods Am;
	private SoftAssert softAssert = new SoftAssert();
	MDSGetterandSetters mds=new MDSGetterandSetters();
	RetriveMDSdata rmds=new RetriveMDSdata();
	ReadConfig rcf=new ReadConfig();

	@Description("Verify the default for Celsius Temperature Unit")
	@Test(priority = 1)
	public void Test_Celsius_Default_RuntimeSetting_MDS_Val()
			throws InterruptedException, IOException {

		Trs = new TemperatureRuntimeSettings(driver);
		
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_TP());
		String defaultcelsiusvalTP=mds.getDefault1();
		String prmunt=mds.getPrmryunt();
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_MFP());
		String defaultmanifoldclsiustp=mds.getDefault1();
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_HoseApp());
		String defaulthseclsius=mds.getDefault1();
		
		Trs.clickSetUpToolBtn();
		log.info("Clicked on SetUp Tool button");
		Thread.sleep(1000);

		Trs.clickCreateNewBtn();
		log.info("Clicked on CreateNew button");
		Thread.sleep(1000);

		Trs.clickSubmitBtn();
		log.info("Clicked on Submit button");

		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");

		Trs.clickPreferencesBtn();
		log.info("Clicked on Preferences button");

		Trs.clickCelsiusTempUnit();
		log.info("Clicked on Celsius temperature button");

		Trs.RuntimeSettingsBtn();

		Trs.ZoneTemperatureBtn();
		log.info("Clicked on Runtime settings button");
		
		String tempunt = Trs.getTemperatureunt();
		if(tempunt.contains(prmunt))
			log.info("Global set point is set to Default  celsius unit");
		else
			log.info("Global set point is not set to Default  celsius unit");
			

		String tanksp = Trs.getTankSetPoint();
		softAssert.assertEquals( tanksp,defaultcelsiusvalTP,
				"Tank set point is not set to Default value for celsius unit : " + defaultcelsiusvalTP);
		log.info("Tank set point is set to Default value for celsius unit :" + defaultcelsiusvalTP);

		String manifold = Trs.getManifold();
		softAssert.assertEquals( manifold,defaultmanifoldclsiustp,
				"Manifold set point is not set to Default value for celsius unit : " + defaultmanifoldclsiustp);
		log.info("Manifold set point is set to Default value for celsius unit :" + defaultmanifoldclsiustp);
		
		// To check the Hose set point temperature
				 Trs.getHosesSettempStatus(defaulthseclsius);
				 log.info("All Hoses are set to default values");

				// To check the Applicator set point temperature
				Trs.getApplicatorsSettempStatus(defaulthseclsius);
				log.info("All Applicators are set to default values");

				softAssert.assertAll();
		
	}
	
	@Description("Verify the default for Farnheit Temperature Unit")
	@Test(priority = 2)
	public void Test_Farnhiet_Default_RuntimeSetting_MDS_Val()
			throws InterruptedException, IOException {
		
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_TP());
		String defaultFHvalTP=mds.getDefault2();
		String scndryunt=mds.getScndryunt();
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_MFP());
		String defaultmanifoldFHtp=mds.getDefault2();
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_HoseApp());
		String defaulthseFH=mds.getDefault2();
		

		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");

		Trs.clickPreferencesBtn();
		log.info("Clicked on Preferences button");

		Trs.clickFarnheitTempUnit();
		log.info("Clicked on Farnheit temperature button");
		
		Trs.clickSave();
		if (Trs.getToastmsgststus() == true)
			log.info("Preferences sucessfully updated");
		else
			log.info("Preferences sucessfully not updated");

		Trs.RuntimeSettingsBtn();

		Trs.ZoneTemperatureBtn();
		log.info("Clicked on Runtime settings button");
		
		
		String tempunt = Trs.getTemperatureunt();
		if(tempunt.contains(scndryunt))
			log.info("Global set point is set to Default  Farnhit unit");
		else
			log.info("Global set point is not set to Default  Farnhit unit");
			

		String tanksp = Trs.getTankSetPoint();
		softAssert.assertEquals( tanksp,defaultFHvalTP,
				"Tank set point is not set to Default value for Farnhit unit : " + defaultFHvalTP);
		log.info("Tank set point is set to Default value for Farnhit unit :" + defaultFHvalTP);

		String manifold = Trs.getManifold();
		softAssert.assertEquals( manifold,defaultmanifoldFHtp,
				"Manifold set point is not set to Default value for Farnhit unit : " + defaultFHvalTP);
		log.info("Manifold set point is set to Default value for Farnhit unit :" + defaultFHvalTP);
		
		// To check the Hose set point temperature
				 Trs.getHosesSettempStatus(defaulthseFH);
				 log.info("All Hoses are set to default values");

				// To check the Applicator set point temperature
				Trs.getApplicatorsSettempStatus(defaulthseFH);
				log.info("All Applicators are set to default values");

				softAssert.assertAll();
		
	}

	
	@Description("Verify the min mand max values for Celsius Temperature Unit")
	@Test(priority = 3)
	public void Test_Celsius_GP_RuntimeSetting_MDSminmax_Val()
			throws InterruptedException, IOException {

		Trs = new TemperatureRuntimeSettings(driver);
		
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_GP());
		String min1=mds.getMin1();
		String max1=mds.getMax1();
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_TP());
		String TPmax=mds.getMax1();

		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");

		Trs.clickPreferencesBtn();
		log.info("Clicked on Preferences button");

		Trs.clickCelsiusTempUnit();
		log.info("Clicked on Celsius temperature button");
		
		Trs.clickSave();
		if (Trs.getToastmsgststus() == true)
			log.info("Preferences sucessfully updated");
		else
			log.info("Preferences sucessfully not updated");

		Trs.RuntimeSettingsBtn();

		Trs.ZoneTemperatureBtn();
		log.info("Clicked on Runtime settings button");

		// setting global point to min and verfiying

		Trs.setGlobalSetPoint(min1);
		log.info("global set point temperature set to minimum value " + min1 + "for celsius unit");

		Trs.clickSavebtn();
		log.info("global point saved to " + min1 + "for celsius unit");

		if (Trs.getToastmsgststus() == true) {
			log.info("Preferences sucessfully updated");
		}

		String tankspforgpmin = Trs.getTankSetPoint();
		softAssert.assertEquals(tankspforgpmin, min1,
				"Tank set point is not set to Minimum value : " + min1 + "for celsius unit");

		log.info("Tank set point for global minimun point is set to :" + tankspforgpmin + "for celsius unit");

		String manifoldforgpmin = Trs.getManifold();
		softAssert.assertEquals(manifoldforgpmin, min1,
				"Manifold set point is not set to min value : " + manifoldforgpmin + "for celsius unit");
		log.info("Manifold set point is set to Minium value :" + manifoldforgpmin + "for celsius unit");

		Trs.getHosesSettempStatus(min1);
		log.info("All the Hoses are set to min value for minium global set point");

		Trs.getApplicatorsSettempStatus(min1);
		log.info("All the Applicators are set to min value for minimun global set point");

 // Setting Global point to max1 value and verfiying the fields

		// Max Value validation

		Trs.setGlobalSetPoint(max1);
		log.info("global set point temperature set to max value " + max1 + "for celsius unit");

		Trs.clickSavebtn();
		log.info("global point saved to " + max1 + "for celsius unit");

		if (Trs.getToastmsgststus() == true) {
			log.info("Preferences sucessfully updated");
		}

		String tankspforgpmax = Trs.getTankSetPoint();
		softAssert.assertEquals(tankspforgpmax,TPmax,
				"Tank set point is not set to maximum value : " + tankspforgpmax + "for celsius unit");
		log.info("Tank set point for global maximum point is set to :" + tankspforgpmax + "for celsius unit");

		String manifoldforgpmax = Trs.getManifold();
		softAssert.assertEquals(manifoldforgpmax,TPmax,
				"Manifold set point is not set to maximum value : " + max1 + "for celsius unit");
		log.info("Manifold set point is set to Maximum value :" + max1 + "for celsius unit");

		Trs.getHosesSettempStatus(max1);
		log.info("All Hoses set point temperature for global max value set to max for celsius unit");

		Trs.getApplicatorsSettempStatus(max1);
		log.info("All Applicators set point temperature for global max value set to max for celsius unit");
		
		softAssert.assertAll();

	}

	@Description("Verify the min mand max values for Farnhenit Temperature Unit")
	@Test(priority = 4)
	public void Test_Farnhit_GP_RuntimeSetting_MDSminmax_Val()
			throws InterruptedException, IOException {
		
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_GP());
		String min2=mds.getMin2();
		String max2=mds.getMax2();
		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_TP());
		String max2TP=mds.getMax2();
		
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");

		Trs.clickPreferencesBtn();
		log.info("Clicked on Preferences button");

		Trs.clickFarnheitTempUnit();
		log.info("Clicked on Farnheit temperature button");
		
		Trs.clickSave();

		if (Trs.getToastmsgststus() == true)
			log.info("Preferences sucessfully updated");
		else
			log.info("Preferences sucessfully not updated");

		Trs.RuntimeSettingsBtn();
		log.info("Clicked on Runtime settings button");

		Trs.ZoneTemperatureBtn();
		log.info("Clicked on Runtime settings button");

		// setting global point to Min2 value and validating tank,Manifold,hose and
		// applicator values for farnheit unit

		Trs.setGlobalSetPoint(min2);
		log.info("global set point temperature set to min value " + min2 + "for farnhenit unit");

		Trs.clickSavebtn();
		log.info("global point saved to " + min2 + "for farnhenit unit");

		if (Trs.getToastmsgststus() == true) {
			log.info("Preferences sucessfully updated");
		} else
			log.info("Preferences not sucessfully updated");

		String tankspforgpminfh = Trs.getTankSetPoint();
		softAssert.assertEquals(tankspforgpminfh, min2,
				"Tank set point is not set to Minimum value : " + min2 + "for farnhenit unit");
		log.info("Tank set point for global minimun point is set to :" + tankspforgpminfh + "for farnhenit unit");

		String manifoldforgpminfh = Trs.getManifold();
		softAssert.assertEquals(manifoldforgpminfh, min2,
				"Manifold set point is not set to minium value : " + min2
						+ "for farnhenit unit");
		log.info("Manifold set point is set to Minium value :" + min2 + "for farnhenit unit");

		Trs.getHosesSettempStatus(min2);
		log.info("All the Hoses are set to min value for min-1 global set point for farnheit unit");

		Trs.getApplicatorsSettempStatus(min2);
		log.info("All the Applicators are set to min value for min-1 global set point for farnheit unit");

// setting global point to Max+1 value and validating tank,Manifold,hose and
// applicator values for farnheit unit

		Trs.setGlobalSetPoint(max2);
		log.info("global set point temperature set to max+1 value " + max2 + "for farnhenit unit");

		Trs.clickSavebtn();
		log.info("global point saved to " + max2 + "for farnhenit unit");

		if (Trs.getToastmsgststus() == true)
			log.info("Preferences sucessfully updated");
		else
			log.info("Preferences not sucessfully updated");

		String tankspforgpmaxfh = Trs.getTankSetPoint();
		softAssert.assertEquals(tankspforgpmaxfh,max2TP,
				"Tank set point is not set to maximum value : " + max2TP
						+ "for farnhenit unit");
		log.info("Tank set point for global maximum point is set to :" + max2TP
				+ "for farnhenit unit");

		String manifoldforgpmaxfh = Trs.getManifold();
		softAssert.assertEquals( manifoldforgpmaxfh, max2TP,
				"Manifold set point is not set to Default value : " + max2TP
						+ "for farnhenit unit");
		log.info("Manifold set point is set to Maximum value :" +max2TP
				+ "for farnhenit unit");

		Trs.getHosesSettempStatus(max2);
		log.info("All the Hoses are set to max value for max+1 global set point for farnheit unit");

		Trs.getApplicatorsSettempStatus(max2);
		log.info("All the Applicators are set to min value for max+1 global set point for farnheit unit");

		softAssert.assertAll();
		
	}
	
	@Test(priority = 5)
	@Story("Temperature Runtimesettings Tank set Point validations with boundary values in celsius unit")
	public void Test_Celsius_TP_RuntimeSetting_MDSminmax_Val()
			throws InterruptedException, IOException {
		
		// Setting back to celsius unit to verfiy tank setpoint
		
		

		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_TP());
		String min1TP=mds.getMin1();
		String max1TP=mds.getMax1();
		String default1temp=mds.getDefault1();
		
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");

		Trs.clickPreferencesBtn();
		log.info("Preferences is clicked to opt Unit celsius temperature");
		Thread.sleep(1000);

		Trs.clickCelsiusUnit();
		log.info("Temperature Unit celsuis is selected by clicking");

		Trs.clickSave();
		log.info("Temperature Unit celsuis is saved ");
		
		if (Trs.getToastmsgststus() == true) 
			log.info("Preferences sucessfully updated");
		else
			log.info("Preferences not sucessfully updated");
		

		Trs.RuntimeSettingsBtn();
		log.info("Clicked on Runtime settings button to verfiy temperature Celsius Unit vals");

		Trs.ZoneTemperatureBtn();
		log.info("Clicked on Zone temperature button to setglobal min value in Celsuis");

	// Min value validations for Tank point in celsius
	 
	 Trs.clearTanktemperature();
	 log.info("Tank temperature cleared to enter Inrange value for Celsius unit");
	 Trs.setTankSetPoint(min1TP);
	 Trs.clickSavebtn();
		
	 String tstsucssmsgmin1 = Trs.getToastmsg();
	 softAssert.assertEquals(tstsucssmsgmin1,Constants.SucssmsgRuntime, 
				"Toast msg"+ min1TP+ "values are not saved for Celsius unit");
		log.info("Toast msg In range values are saved successfully for Celsius unit");
		

		String manifoldforgpmaxfh = Trs.getManifold();
		softAssert.assertEquals( manifoldforgpmaxfh, min1TP,
				"Manifold set point is not set to min value : " + min1TP
						+ "for celsius unit");
		log.info("Manifold set point is set to Maximum value :" +min1TP
				+ "for celsius unit");
		
	

	// Max value validations for Tank point in celsius
		
		 Trs.clearTanktemperature();
		 log.info("Tank temperature cleared to enter Inrange value for Celsius unit");
		 Trs.setTankSetPoint(max1TP);
		 Trs.clickSavebtn();
			
		 String tstsucssmsgmax1 = Trs.getToastmsg();
		 softAssert.assertEquals(tstsucssmsgmax1,Constants.SucssmsgRuntime, 
					"Toast msg"+ max1TP+ "values are not saved for Celsius unit");
			log.info("Toast msg for max val are saved successfully for Celsius unit");
		
			String manifoldforTPmax = Trs.getManifold();
			softAssert.assertEquals( manifoldforTPmax, max1TP,
					"Manifold set point is not set to min value : " + max1TP
							+ "for celsius unit");
			log.info("Manifold set point is set to Maximum value :" +max1TP
					+ "for celsius unit");			


	     softAssert.assertAll();
     }
	
	@Test(priority = 6)
	@Story("Temperature Runtimesettings Tank set Point validations with boundary values in Farnhit unit")
	public void Test_Farnheit_TP_RuntimeSetting_MDSminmax_Val()
			throws InterruptedException, IOException {
		
		// Setting back to celsius unit to verfiy tank setpoint
		
		String min2TP=mds.getMin2();
		String max2TP=mds.getMax2();
		String default2temp=mds.getDefault2();
		

		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");

		Trs.clickPreferencesBtn();
		log.info("Preferences is clicked to opt Unit farnhit temperature");
		Thread.sleep(1000);

		Trs.clickFarhenitUnit();
		log.info("Temperature Unit celsuis is selected by clicking");

		Trs.clickSave();
		log.info("Temperature Unit celsuis is saved ");
		
		if (Trs.getToastmsgststus() == true) 
			log.info("Preferences sucessfully updated");
		else
			log.info("Preferences not sucessfully updated");
		

		Trs.RuntimeSettingsBtn();
		log.info("Clicked on Runtime settings button to verfiy temperature farnhit Unit vals");

		Trs.ZoneTemperatureBtn();
		log.info("Clicked on Zone temperature button to setglobal min value in farnhit");

	// Min value validations for Tank point in farnhit
	 
	 Trs.clearTanktemperature();
	 log.info("Tank temperature cleared to enter Inrange value for farnhit unit");
	 Trs.setTankSetPoint(min2TP);
	 Trs.clickSavebtn();
		
	 String tstsucssmsgmin1 = Trs.getToastmsg();
	 softAssert.assertEquals(Constants.SucssmsgRuntime, tstsucssmsgmin1,
				"Toast msg"+ min2TP+ "values are not saved for farnhit unit");
		log.info("Toast msg for "+min2TP+" values are saved successfully for farnhit unit");
		
		String manifoldforgpmaxfh = Trs.getManifold();
		softAssert.assertEquals( manifoldforgpmaxfh, min2TP,
				"Manifold set point is not set to minium value : " + min2TP
						+ "for farnhit unit");
		log.info("Manifold set point is set to minium value :" +min2TP
				+ "for farnhit unit");
		
	

	// Max value validations for Tank point in farnhit
		
		 Trs.clearTanktemperature();
		 log.info("Tank temperature cleared to enter Inrange value for farnhit unit");
		 Trs.setTankSetPoint(max2TP);
		 Trs.clickSavebtn();
			
		 String tstsucssmsgmax1 = Trs.getToastmsg();
		 softAssert.assertEquals(tstsucssmsgmax1,Constants.SucssmsgRuntime, 
					"Toast msg"+ max2TP+ "values are not saved for farnhit unit");
			log.info("Toast msg "+ max2TP+ " values are saved successfully for farnhit unit");
			
			
	     softAssert.assertAll();
  }
	
	
	@Test(priority = 7)
	@Story("Temperature Runtimesettings Hose and Applicator set Point validations with minmax values in celsius unit")
	public void Test_Celsius_HoseandApp_RuntimeSetting_MDSminmax_Val()
			throws InterruptedException, IOException {
		
		// Setting back to celsius unit to verfiy tank setpoint
			

		rmds.getMDSDataVal(rcf.getUIfieldTobefetched_HoseApp());
		String min1HoseApp=mds.getMin1();
		String max1HoseAPP=mds.getMax1();
		
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");

		Trs.clickPreferencesBtn();
		log.info("Preferences is clicked to opt Unit celsius temperature");
		Thread.sleep(1000);

		Trs.clickCelsiusUnit();
		log.info("Temperature Unit celsuis is selected by clicking");

		Trs.clickSave();
		log.info("Temperature Unit celsuis is saved ");
		
		if (Trs.getToastmsgststus() == true) 
			log.info("Preferences sucessfully updated");
		else
			log.info("Preferences not sucessfully updated");
		

		Trs.RuntimeSettingsBtn();
		log.info("Clicked on Runtime settings button to verfiy temperature Celsius Unit vals");

		Trs.ZoneTemperatureBtn();
		log.info("Clicked on Zone temperature button to setglobal min value in Celsuis");

		
		// checking the status and enabling hose

				Trs.clickOnHose1toEnable();

				// clearing the hose1

				Trs.clearHosesetTemperature();
				
				
				Trs.setHose1emperature(min1HoseApp);
				Trs.clickSavebtn();

				String tstsucssmsg = Trs.getToastmsg();
				softAssert.assertEquals( tstsucssmsg,Constants.SucssmsgRuntime,
					"minium values are not saved for Hose Celsius unit");
				log.info("Minimum values are saved successfully for Hose Celsius unit");

				boolean stus = Trs.getbtnstatus();
				softAssert.assertEquals(stus,false, "Minimum values are saved successfully for Hose Celsius unit");
				log.info("For Minimum values save buttom is enabled successfully for Hose Celsius unit");

				// checking the status and enabling Applicator

				Trs.clickApplicator1toEnable();

				// clearing the Applicator1

				Trs.clearApplicator1setTemperature();
				

				Trs.setApplicator1temperature(min1HoseApp);
				
				Trs.clickSavebtn();

				String tstsucssmsgApp = Trs.getToastmsg();
				softAssert.assertEquals( tstsucssmsgApp,Constants.SucssmsgRuntime,
					"minium values are not saved for Applicator Celsius unit");
				log.info("Minimum values are saved successfully for Applicator Celsius unit");

				boolean Applicatorsavebtnstuts = Trs.getbtnstatus();
				softAssert.assertEquals(Applicatorsavebtnstuts,false, "Minimum values are saved successfully for Applicator Celsius unit");
				log.info("For Minimum values save button is enabled successfully for Applicator Celsius unit");

	// Max value validations for Hose and Applicator point in celsius
		
				Trs.clearHosesetTemperature();
				
				
				Trs.setHose1emperature(max1HoseAPP);
				Trs.clickSavebtn();

				String tstsucssmsgmax = Trs.getToastmsg();
				softAssert.assertEquals( tstsucssmsgmax,Constants.SucssmsgRuntime,
					"minium values are not saved for Hose Celsius unit");
				log.info("maximun values are saved successfully for Hose Celsius unit");

				boolean stusmax = Trs.getbtnstatus();
				softAssert.assertEquals(stusmax,false, "maximum values are saved successfully for Hose Celsius unit");
				log.info("For Maximum values save buttom is enabled successfully for Hose Celsius unit");

			

				// clearing the Applicator1 for max Value

				Trs.clearApplicator1setTemperature();
				

				Trs.setApplicator1temperature(max1HoseAPP);
				
				Trs.clickSavebtn();

				String tstsucssmsgAppmax = Trs.getToastmsg();
				softAssert.assertEquals( tstsucssmsgAppmax,Constants.SucssmsgRuntime,
					"minium values are not saved for Applicator Celsius unit");
				log.info("Minimum values are saved successfully for Applicator Celsius unit");

				boolean Applicatorsavebtnstutsmax = Trs.getbtnstatus();
				softAssert.assertEquals(Applicatorsavebtnstutsmax,false, "Minimum values are saved successfully for Applicator Celsius unit");
				log.info("For Minimum values save button is enabled successfully for Applicator Celsius unit");
			
				
	     softAssert.assertAll();
     }
	

	@Test(priority = 8)
	@Story("Temperature Runtimesettings Hose and Applicator set Point validations with minmax values in Farnhit unit")
	public void Test_Farnhit_HoseandApp_RuntimeSetting_MDSminmax_Val()
			throws InterruptedException, IOException {
		
		// Setting back to celsius unit to verfiy tank setpoint
			

		
		String min2HoseApp=mds.getMin2();
		String max2HoseAPP=mds.getMax2();
		
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");

		Trs.clickPreferencesBtn();
		log.info("Preferences is clicked to opt Unit Farnhit temperature");
		Thread.sleep(1000);

		Trs.clickFarhenitUnit();
		log.info("Temperature Unit celsuis is selected by clicking");

		Trs.clickSave();
		log.info("Temperature Unit celsuis is saved ");
		
		if (Trs.getToastmsgststus() == true) 
			log.info("Preferences sucessfully updated");
		else
			log.info("Preferences not sucessfully updated");
		

		Trs.RuntimeSettingsBtn();
		log.info("Clicked on Runtime settings button to verfiy temperature Farnhit Unit vals");

		Trs.ZoneTemperatureBtn();
		log.info("Clicked on Zone temperature button to setglobal min value in Celsuis");

		
		// checking the status and enabling hose

				Trs.clickOnHose1toEnable();

				// clearing the hose1

				Trs.clearHosesetTemperature();
				
				
				Trs.setHose1emperature(min2HoseApp);
				Trs.clickSavebtn();

				String tstsucssmsg = Trs.getToastmsg();
				softAssert.assertEquals( tstsucssmsg,Constants.SucssmsgRuntime,
					"minium values are not saved for Hose Farnhit unit");
				log.info("Minimum values are saved successfully for Hose Farnhit unit");

				boolean stus = Trs.getbtnstatus();
				softAssert.assertEquals(stus,false, "Minimum values are saved successfully for Hose Farnhit unit");
				log.info("For Minimum values save buttom is enabled successfully for Hose Farnhit unit");

				// checking the status and enabling Applicator

				Trs.clickApplicator1toEnable();

				// clearing the Applicator1

				Trs.clearApplicator1setTemperature();
				

				Trs.setApplicator1temperature(min2HoseApp);
				
				Trs.clickSavebtn();

				String tstsucssmsgApp = Trs.getToastmsg();
				softAssert.assertEquals( tstsucssmsgApp,Constants.SucssmsgRuntime,
					"minium values are not saved for Applicator Farnhit unit");
				log.info("Minimum values are saved successfully for Applicator Farnhit unit");

				boolean Applicatorsavebtnstuts = Trs.getbtnstatus();
				softAssert.assertEquals(Applicatorsavebtnstuts,false, "Minimum values are saved successfully for Applicator Farnhit unit");
				log.info("For Minimum values save button is enabled successfully for Applicator Farnhit unit");

	// Max value validations for Hose and Applicator point in Farnhit
		
				Trs.clearHosesetTemperature();
				
				
				Trs.setHose1emperature(max2HoseAPP);
				Trs.clickSavebtn();

				String tstsucssmsgmax = Trs.getToastmsg();
				softAssert.assertEquals( tstsucssmsgmax,Constants.SucssmsgRuntime,
					"minium values are not saved for Hose Farnhit unit");
				log.info("maximun values are saved successfully for Hose Farnhit unit");

				boolean stusmax = Trs.getbtnstatus();
				softAssert.assertEquals(stusmax,false, "maximum values are saved successfully for Hose Farnhit unit");
				log.info("For Maximum values save buttom is enabled successfully for Hose Farnhit unit");

			

				// clearing the Applicator1 for max Value

				Trs.clearApplicator1setTemperature();
				

				Trs.setApplicator1temperature(max2HoseAPP);
				
				Trs.clickSavebtn();

				String tstsucssmsgAppmax = Trs.getToastmsg();
				softAssert.assertEquals( tstsucssmsgAppmax,Constants.SucssmsgRuntime,
					"minium values are not saved for Applicator Farnhit unit");
				log.info("Minimum values are saved successfully for Applicator Farnhit unit");

				boolean Applicatorsavebtnstutsmax = Trs.getbtnstatus();
				softAssert.assertEquals(Applicatorsavebtnstutsmax,false, "Minimum values are saved successfully for Applicator Farnhit unit");
				log.info("For Minimum values save button is enabled successfully for Applicator Farnhit unit");
			
				
	     softAssert.assertAll();
     }
	
	
}
