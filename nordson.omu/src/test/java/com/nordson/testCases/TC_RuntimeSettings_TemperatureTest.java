package com.nordson.testCases;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nordson.pageObjects.TemperatureRuntimeSettings;
import com.nordson.utilities.ActionMethods;
import com.nordson.utilities.Constants;




public class TC_RuntimeSettings_TemperatureTest extends BaseClass
{
	
	TemperatureRuntimeSettings Trs;
	ActionMethods Am;	    

	@Test
	public void TestAdminLogin() throws InterruptedException, IOException {

		log.info("URL is launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		log.info("Wait for the page load time out");
		

		Trs = new TemperatureRuntimeSettings(driver);
		log.info("Webdriver driver is instantiated");

		Trs.setUserName(AdminUsername);
		log.info("Username is set");

		Trs.setPassword(AdminPassword);
		log.info("Password is set");
		
		try {

			Trs.loginBtnEnabled();
			log.info("Login Button is enabled");
		}

		catch (Exception e) {
			log.error("Login Button is disbaled");

		}
		
		Trs.waitForLoginBtnEnable();
		Trs.clickLoginBtn();
		log.info("Clicked on Login button");
		Thread.sleep(5000);
		
	}
	
	@Test
	public void CreateNORFile() throws InterruptedException, IOException 
	{
	    Trs.SetUpToolBtnISEnabled();
		Trs.clickSetUpToolBtn();
		log.info("Clicked on SetUp Tool button");
		Thread.sleep(5000);
		
		Trs.CreateNewBtnISEnabled();
		Trs.clickCreateNewBtn();
		log.info("Clicked on CreateNew button");
		Thread.sleep(2000);
		
		Trs.clickSubmitBtn();
		log.info("Clicked on Submit button");
		Thread.sleep(5000);
		
	}
	

	@Test
	public void TestRuntimeSettingTempCelsius() throws InterruptedException, IOException 
	{
		TestAdminLogin();
		CreateNORFile();
	    Trs.SystemSettingsBtnISEnabled();
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");
		Thread.sleep(3000);
		
		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		log.info("Clicked on Preferences button");
		Thread.sleep(4000);
		
		String tempunt=Trs.getTemperatureunit();
		System.out.println(tempunt +"temperature unit");
		if(tempunt.equalsIgnoreCase("°C"))
		{
			log.info("Temperature Unit celsius is selected");	
		}
		else
			Trs.clickCelsiusUnit();	
			Thread.sleep(3000);	
		
		Trs.RuntimeSettingsBtnISEnabled();
		Trs.RuntimeSettingsBtn();
		
		Trs.ZoneTemperatureBtnISEnabled();
		Trs.ZoneTemperatureBtn();
		
		String globalSetPoint=Trs.getGlobalSetPoint();	
		Assert.assertTrue(globalSetPoint.isEmpty(), "Global set point is set null");
		log.info("Global set point is set null");
		
		String tanksp=Trs.getTankSetPoint();
		Assert.assertEquals(Constants.Tank,tanksp,"Tank set point is not set to Default value : "+Constants.Tank);
		log.info("Tank set point is set to Default value :"+Constants.Tank);
		
		String manifold=Trs.getManifold();
		Assert.assertEquals(Constants.Manifold, manifold,"Manifold set point is not set to Default value : "+Constants.Manifold);
		log.info("Manifold set point is set to Default value :"+ Constants.Manifold);
		
		int count=1;
		List<Integer> hoseEnableststus=Trs.getHoseEnableStatus();
		
		for(int i=0;i<hoseEnableststus.size();i++)
		{
			if(hoseEnableststus.get(i)>0)
			{
				log.info("Hose"+count+"set point temperature is disabled by default");
			 }
			else 
				
				log.info("Hose"+count+"set point temperature is not disabled by default");
			count++;
		}	
			
			
		List<Integer> applicatorEnableststus=Trs.getApplicatorEnableStatus();
		count=1;
		for(int i=0;i<hoseEnableststus.size();i++)
		{
			if(applicatorEnableststus.get(i)>0)
			{
				log.info("Applicator"+count+" Set point is disbaled by default");
			}
			else 
				Assert.fail("Applicator"+count+"Set point is enabled and not disabled by default");
			count++;
		}	
		  
		List<String> hosestpnt=Trs.getHoseSetTemp();
		int hosestpntsz=hosestpnt.size();
		count=1;
   		for(int i=0;i<hosestpntsz;i++)
		{
			if(hosestpnt.get(i).equals(Constants.HoseSetTemp))
			{
				log.info("Hose"+count+"set point temperature set to default value"+Constants.HoseSetTemp);
			 }
			else 
				
				log.info("Hose"+count+"set point temperature not set to default value"+Constants.HoseSetTemp);
			count++;
		}
	
		List<String> applicatorsetpnt=Trs.getApplicatorSetTemp();
		int applicatorsetpntsz=hosestpnt.size();
		count=1;
		for(int i=0;i<applicatorsetpntsz;i++)
		{
			if(applicatorsetpnt.get(i).equals(Constants.ApplicatorSetTemp))
			{
				log.info("Applicator"+count+"set point temperature set to default value"+Constants.ApplicatorSetTemp);
			 }
			else 
				
				log.info("Applicator"+count+"set point temperature not set to default value"+Constants.ApplicatorSetTemp);
			count++;
		}
		
	 }
	

	@Test
	public void TestRuntimeSettingTempFarhenit() throws InterruptedException, IOException 
	{
		TestAdminLogin();
		CreateNORFile();
	    Trs.SystemSettingsBtnISEnabled();
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");
		
		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		log.info("Clicked on Preferences button");
		Thread.sleep(4000);
		
		String tempunt=Trs.getTemperatureunit();
		System.out.println(tempunt +"temperature unit");
		if(tempunt.equalsIgnoreCase("°F"))
		{
			log.info("Temperature Unit celsius is selected");	
		}
		else
			Trs.clickFarhenitUnit();	
			Thread.sleep(3000);
			Trs.clickSave();
			Thread.sleep(5000);
			
			Trs.RuntimeSettingsBtnISEnabled();
			Trs.RuntimeSettingsBtn();
			log.info("Runtime Setting is clicked");
			Thread.sleep(2000);
			
			Trs.ZoneTemperatureBtnISEnabled();
			Trs.ZoneTemperatureBtn();
			log.info("Zone temperature is clicked");
			Thread.sleep(3000);
			
			String globalSetPoint=Trs.getGlobalSetPoint();	
			Assert.assertTrue(globalSetPoint.isEmpty(), "Global set point is set null");
			log.info("Global set point is set null");
			
			String tanksp=Trs.getTankSetPoint();
			String farhenitvalutp=ActionMethods.getConversionToFahrenheit(Constants.Tank);
			Assert.assertEquals(farhenitvalutp,tanksp,"Tank set point is not set to Default value : "+farhenitvalutp);
			log.info("Tank set point is set to Default value :"+farhenitvalutp);
			
			String manifold=Trs.getManifold();
			String farhenitvalump=ActionMethods.getConversionToFahrenheit(Constants.Manifold);
			Assert.assertEquals(farhenitvalump, manifold,"Manifold set point is not set to Default value : "+farhenitvalump);
			log.info("Manifold set point is set to Default value :"+ farhenitvalump);
			
			List<Integer> hoseEnableststus=Trs.getHoseEnableStatus();
			int count=1;
			for(int i=0;i<hoseEnableststus.size();i++)
			{
				if(hoseEnableststus.size()>0)
				{
					log.info("Hose "+count+"set point temperature is disabled by default");
				 }
				else 
					
					log.info("Hose "+count+"set point temperature is not disabled by default");
				
				count++;
			}	
				
			List<Integer> applicatorEnableststus=Trs.getApplicatorEnableStatus();
			count=1;
			for(int i=0;i<hoseEnableststus.size();i++)
			{
				if(applicatorEnableststus.get(i)>0)
				{
					log.info("Applicator "+count+" Set point temperature is disbaled by default");
				}
				else
					log.info("Applicator "+count+"Set point temperature is enabled and not disabled by default");
				count++;
			}	
				List<String> hosestpnt=Trs.getHoseSetTemp();
				String fahrenitSetpointtemp=ActionMethods.getConversionToFahrenheit(Constants.HoseSetTemp);
				count=1;
				for(int i=0;i<hosestpnt.size();i++)
				{
					if(hosestpnt.get(i).equals(fahrenitSetpointtemp))
					{
						log.info("Hose"+count+"set point temperature set to default value"+fahrenitSetpointtemp);
					 }
					else 
						
						log.info("Hose"+count+"set point temperature not set to default value"+fahrenitSetpointtemp);
				}
			
				List<String> applicatorsetpnt=Trs.getApplicatorSetTemp();
				String appfahrenitSetpointtemp=ActionMethods.getConversionToFahrenheit(Constants.ApplicatorSetTemp);
				count=1;
				for(int i=0;i<applicatorsetpnt.size();i++)
				{
					if(applicatorsetpnt.get(i).equals(appfahrenitSetpointtemp))
					{
						log.info("Applicator"+count+"set point temperature set to default value"+appfahrenitSetpointtemp);
					 }
					else 
						
						log.info("Applicator"+count+"set point temperature not set to default value"+appfahrenitSetpointtemp);
				}
			
	}
	
	
	@Test
	public void TestRuntimeMinmaxCelsiusTempZonesval() throws InterruptedException, IOException 
	{
		TestAdminLogin();
		CreateNORFile();
	    Trs.SystemSettingsBtnISEnabled();
		Trs.clickSystemSettingsBtn();
		log.info("Clicked on System settings button");
		Thread.sleep(3000);
		
		Trs.PreferencesBtnISEnabled();
		Trs.clickPreferencesBtn();
		log.info("Clicked on Preferences button");
		Thread.sleep(4000);
		
		String tempunt=Trs.getTemperatureunit();
		System.out.println(tempunt +"temperature unit");
		if(tempunt.equalsIgnoreCase("°C"))
		{
			log.info("Temperature Unit celsius is selected");	
		}
		else
			Trs.clickCelsiusUnit();	
			Thread.sleep(3000);	
		
		Trs.RuntimeSettingsBtnISEnabled();
		Trs.RuntimeSettingsBtn();
		
		Trs.ZoneTemperatureBtnISEnabled();
		Trs.ZoneTemperatureBtn();
		
			
	}
}
