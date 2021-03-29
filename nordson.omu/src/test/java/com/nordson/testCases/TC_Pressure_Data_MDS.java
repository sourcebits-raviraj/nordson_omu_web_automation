package com.nordson.testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nordson.pageObjects.LoginPage;
import com.nordson.pageObjects.Pressure_MDS_File;
import com.nordson.utilities.ActionMethods;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("Regression Tests")
@Feature("Pressure Min and Max Validations from mds file")
public class TC_Pressure_Data_MDS extends TC_LoginTest_DDT_001 {
	LoginPage lp;
	Pressure_MDS_File pmf;
	ActionMethods Am = new ActionMethods();

	private SoftAssert softAssert = new SoftAssert();

	@Test(priority = 1, enabled = true)
	public void Pressure_Data_MDS_File() throws InterruptedException, IOException, AWTException {

		pmf = new Pressure_MDS_File(driver);
		log.info("Clicked on Set Up Tool Link");
		pmf.clickSetUpToolLink();

		log.info("Clicked on Create New .NOR file button");
		pmf.clickCreateNewFile();

		log.info("Added Description");
		pmf.addDescription();

		log.info("Submitted NOR file");
		pmf.clickSubmit();

		log.info("Clicked on System Setting Link");
		pmf.ClickSystemSettingsLink();

		log.info("Clicked on Preferences Link");
		pmf.ClickPreferencesLink();

		log.info("Selected Kpa Raido button");
		pmf.SelectKPAUnit();

		log.info("Save the preferences");
		pmf.saveButton();

		log.info("Clicked on Run Time Settings Link");
		pmf.clickRunTimeSettings();

		log.info("Clicked on Pressure Link");
		pmf.clickPressure();

	}

	@Test(priority = 2, enabled = true)
	@Story("Pressure Unit Min 40min")
	public void PressureValues_Kpa_Min_40() throws InterruptedException {

		// pmv = new Pressure_Min_Max_Validations(driver);

		log.info("Set the min value as 40");
		pmf.clearMinSetPoint();
		pmf.passpressurevaluemds();
		Thread.sleep(5000);

	}
}