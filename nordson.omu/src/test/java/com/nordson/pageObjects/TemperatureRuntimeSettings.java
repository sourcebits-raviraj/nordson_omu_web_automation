package com.nordson.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nordson.utilities.ActionMethods;

public class TemperatureRuntimeSettings {

	WebDriver ldriver;
	WebDriverWait wait;
	ActionMethods Am = new ActionMethods();

	// Constructor of the LoginPage to initiate driver
	public TemperatureRuntimeSettings(WebDriver rdriver) {
		// TODO Auto-generated constructor stub

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "bt")

	WebElement SetUpToolButton;

	@FindBy(xpath = "//*[contains(text(),'CREATE NEW')]")

	WebElement CreateNewButton;

	@FindBy(xpath = "//*[@class='btn-set-up submit-btn-color']")

	WebElement SubmitButton;

	@FindBy(xpath = "//*[contains(text(),'System Settings')]")

	WebElement SystemSettings;

	@FindBy(xpath = "//*[contains(text(),'Preferences')]")

	WebElement Preferences;

	@FindBy(xpath = "//*[@formcontrolname='TempUnits']//*[contains(@class,'mat-radio-checked')]//div[@class='mat-radio-container']")

	List<WebElement> Temperatureunit;

	@FindBy(xpath = "//*[@formcontrolname='TempUnits']/*[contains(@class,'mat-radio-checked')]//div[@class='mat-radio-label-content']")

	WebElement SelectedTemperatureunit;

	@FindBy(xpath = "//*[@formcontrolname='TempUnits']//*[contains(text(),'C')]//preceding-sibling::div")

	WebElement CelsiusTemperatureunit;

	@FindBy(xpath = "//*[@formcontrolname='TempUnits']//*[contains(text(),'F')]//preceding-sibling::div")

	WebElement FarhenitTemperatureunit;
	

	@FindBy(xpath = "(//span[@class='min'])[1]")
    WebElement Temperatureunt;
	

	@FindBy(xpath = "//*[@class='btn apply']")

	WebElement SAVE;

	@FindBy(xpath = "//*[@class='apply btn submit-bt']")

	WebElement SAVE1;

	@FindBy(xpath = "//*[contains(text(),'Runtime settings')]")

	WebElement RuntimeSettings;

	@FindBy(xpath = "//*[contains(@routerlink,'settings/temp-zone')]")

	WebElement ZoneTemperature;

	@FindBy(xpath = "//*[contains(@routerlink,'settings/temperaturesettings')]")

	WebElement Temperature;

	@FindBy(xpath = "//*[contains(text(),'Global Setpoint')]/../following-sibling::tr/td//input")

	WebElement GlobalSetPoint;

	@FindBy(xpath = "//*[@formcontrolname='globalSetPoint']")

	WebElement MinmaxGlobalSetPoint;

	@FindBy(xpath = "//*[contains(text(),'Tank')]/../following-sibling::tr/td//input")

	WebElement Tank;

	@FindBy(xpath = "//*[contains(text(),'Manifold')]/../following-sibling::tr/td//input")

	WebElement Manifold;

	@FindBy(xpath = "//*[contains(text(),'Hose')]")

	List<WebElement> Hose;

	@FindBy(xpath = "//*[contains(text(),'Applicator')]")

	List<WebElement> Applicator;

	@FindBy(xpath = "//*[contains(@name,'hose')]")

	List<WebElement> HoseSetpoint;

	@FindBy(xpath = "//*[contains(@name,'applicator')]")

	List<WebElement> ApplicatorSetpoint;

	@FindBy(xpath = "//*[@formcontrolname='OTDelta']")
	WebElement OTTemperature;

	@FindBy(xpath = "//*[@formcontrolname='UTDelta']")
	WebElement UTTemperature;

	@FindBy(xpath = "//*[@formcontrolname='StandbyDelta']")
	WebElement TemperatureSetback;

	@FindBy(xpath = "//*[@name='hose1']")
	WebElement Hose1;

	@FindBy(xpath = "//*[@name='applicator1']")
	WebElement Applicator1;

	@FindBy(xpath = "//*[text()='Hose 1']/following-sibling::td//*[not(contains(@class,'mat-checked'))]//input[@aria-checked='false']/..")
	WebElement HoseEnbbtn;

	@FindBy(xpath = "//*[text()='Applicator 1']/following-sibling::td//*[not(contains(@class,'mat-checked'))]//input[@aria-checked='false']/..")
	WebElement ApplicatorEnbbtn;

	@FindBy(xpath = "//div[contains(@class,'toast-message ng-star-inserted')]")
	WebElement Toastmsg;

	public void clickSetUpToolBtn() {
		SetUpToolButton.click();

	}

	public void SetUpToolBtnISEnabled() {
		try {

			Am.waitForAnElementToBeClickable(SetUpToolButton);
		}

		catch (TimeoutException e) {
			System.out.println("SetUp Tool Element isn't clickable");
		}

	}

	public void CreateNewBtnISEnabled() {

		try {
			Am.waitForAnElementToBeClickable(CreateNewButton);

		}

		catch (TimeoutException e) {
			System.out.println("Create New Element isn't clickable");
		}
	}

	public void clickCreateNewBtn() {
		CreateNewButton.click();

	}

	public void clickSubmitBtn() {
		SubmitButton.click();

	}

	public void SystemSettingsBtnISEnabled() {

		try {

			Am.waitForAnElementToBeClickable(SystemSettings);

		}

		catch (TimeoutException e) {
			System.out.println("System Settings Element isn't clickable");
		}

	}

	public void clickSystemSettingsBtn() {
		SystemSettings.click();

	}

	public void PreferencesBtnISEnabled() {

		try {
            
			Am.waitForAnElementPresence(Preferences);
			Am.waitForAnElementToBeClickable(Preferences);

		}

		catch (TimeoutException e) {
			System.out.println("Preferences Settings Element isn't clickable");
		}

	}

	public void clickPreferencesBtn() {
		
		Am.waitForAnElementPresence(Preferences);
		Preferences.click();

	}

	public Boolean getTemperatureunitstut()

	{
		
		Boolean tempvalue =false;
	    
		if(Temperatureunit.size()==1)
			tempvalue=true;
		
		else 
			tempvalue=false;
		
		return tempvalue;
	}
	public String getSelectedTemperatureunit()
	{
		String tempunt;
		tempunt=SelectedTemperatureunit.getText();
		return tempunt;
	}
	public String getTemperatureunt()
	{
		String tempunt;
		tempunt=Temperatureunt.getText();
		return tempunt;
		
	}

	public void clickCelsiusUnit() {

		CelsiusTemperatureunit.click();

	}

	public void clickFarhenitUnit() {

		Am.waitForAnElementPresence(FarhenitTemperatureunit);
		FarhenitTemperatureunit.click();

	}

	public void clickSave() {

		SAVE.click();

	}

	public void clickSavebtn() {

		Am.waitForAnElementPresence(SAVE1);
		SAVE1.click();

	}

	public void RuntimeSettingsBtnISEnabled() {

		try {
			wait = new WebDriverWait(ldriver, 60);
			Am.waitForAnElementToBeClickable(RuntimeSettings);
		} catch (TimeoutException e) {
			System.out.println("Runtime Settings Element isn't clickable");
		}
	}

	public void RuntimeSettingsBtn() {

		Am.waitForAnElementPresence(RuntimeSettings);
		RuntimeSettings.click();

	}

	public void ZoneTemperatureBtnISEnabled() {

		try {
			Am.waitForAnElementToBeClickable(ZoneTemperature);

		}

		catch (TimeoutException e) {
			System.out.println("Zone Temperature Element isn't clickable");
		}

	}

	public void ZoneTemperatureBtn() {

		Am.waitForAnElementPresence(ZoneTemperature);
		ZoneTemperature.click();

	}

	public void TemperatureBtnISEnabled() {

		try {
			Am.waitForAnElementToBeClickable(Temperature);

		}

		catch (TimeoutException e) {
			System.out.println("Temperature Element isn't clickable");
		}

	}

	public void TemperatureBtn() {

		Am.waitForAnElementPresence(Temperature);
		Temperature.click();

	}

	public String getGlobalSetPoint() {

		Am.waitForAnElementPresence(GlobalSetPoint);
		String globalSetPoint = GlobalSetPoint.getAttribute("value");
		return globalSetPoint;

	}

	public void setGlobalSetPoint(String globalpnt) {

		Am.waitForAnElementPresence(GlobalSetPoint);
		Actions Sndinput =new Actions(ldriver);
		Sndinput.sendKeys(GlobalSetPoint, globalpnt).build().perform();	

	}

	public void MinmaxsetGlobalSetPoint(String globalpnt) {

		Am.waitForAnElementPresence(MinmaxGlobalSetPoint);
		MinmaxGlobalSetPoint.sendKeys(globalpnt);

	}

	public String getTankSetPoint() {

		Am.waitForAnElementPresence(Tank);
		String tanksetpoint = Tank.getAttribute("value");
		return tanksetpoint;
	}

	public void setTankSetPoint(String tnkpnt) {
		Am.waitForAnElementPresence(Tank);
		Tank.sendKeys(tnkpnt);

	}

	public String getManifold() {

		Am.waitForAnElementPresence(Manifold);
		String manifold = Manifold.getAttribute("value");
		return manifold;
	}

	public List<Integer> getHoseEnableStatus() {
		String hose = "";
		int hosewebelcunt = 0;
		List<Integer> hosecuntele = new ArrayList<Integer>();

		for (int i = 1; i <= Hose.size(); i++) {
			hose = "//*[text()='Hose " + i
					+ "']/following-sibling::td//*[not(contains(@class,'mat-checked'))]//input[@aria-checked='false']";
			hosewebelcunt = ldriver.findElements(By.xpath(hose)).size();
			hosecuntele.add(hosewebelcunt);

		}

		return hosecuntele;

	}

	public List<Integer> getApplicatorEnableStatus() {
		String applicator = "";
		int applicatorWebenblcunt = 0;
		List<Integer> applicatorlscunt = new ArrayList<Integer>();
		for (int i = 1; i <= Applicator.size(); i++) {
			applicator = "//*[text()='Applicator " + i
					+ "']/following-sibling::td//*[not(contains(@class,'mat-checked'))]//input[@aria-checked='false']";
			applicatorWebenblcunt = ldriver.findElements(By.xpath(applicator)).size();
			applicatorlscunt.add(applicatorWebenblcunt);

		}
		return applicatorlscunt;
	}

	public List<String> getHoseSetTemp() {
		String hosesetpnt = "";
		List<String> Hosesetpointslst = new ArrayList<String>();

		for (int i = 1; i <= HoseSetpoint.size(); i++) {
			hosesetpnt = "//*[@name='hose" + i + "']";
			WebElement el = ldriver.findElement(By.xpath(hosesetpnt));
			String hosesettemppnt = el.getAttribute("value");
			Hosesetpointslst.add(hosesettemppnt);

		}

		return Hosesetpointslst;
	}

	public List<String> getApplicatorSetTemp() {
		String applicatorsetpnt = "";
		List<String> Applicatorsetpointslst = new ArrayList<String>();

		for (int i = 1; i <= Applicator.size(); i++) {
			applicatorsetpnt = "//*[@name='applicator" + i + "']";
			WebElement el = ldriver.findElement(By.xpath(applicatorsetpnt));
			String hosesettemppnt = el.getAttribute("value");
			Applicatorsetpointslst.add(hosesettemppnt);

		}

		return Applicatorsetpointslst;
	}
	
	
	public String getHosetemp1()
	
	{
		String hsettemp=Hose1.getAttribute("value");
		return hsettemp;
		
	}
	
  public String getAPP1temp1()
	
	{
		String appl1=Applicator1.getAttribute("value");
		return appl1;
		
	}

	public void clearTanktemperature() {

		Am.waitForAnElementPresence(Tank);
		Tank.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

	}

	public void clearHosesetTemperature() {

		Am.waitForAnElementPresence(Hose1);
		Hose1.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

	}

	public void clearApplicator1setTemperature() {

		Am.waitForAnElementPresence(Applicator1);
		Applicator1.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

	}

	public void setHose1emperature(String hosetemp) {

		Am.waitForAnElementPresence(Hose1);
		Hose1.sendKeys(hosetemp);

	}

	public void Applicator1temperature(String Appl1temp) {

		Am.waitForAnElementPresence(Applicator1);
		Applicator1.sendKeys(Appl1temp);

	}

	public void setOTTemperature(String OTtemp) {
		Am.waitForAnElementPresence(OTTemperature);
		OTTemperature.sendKeys(OTtemp);

	}

	public void setUTTemperature(String UTTtemp) {

		Am.waitForAnElementPresence(UTTemperature);
		UTTemperature.sendKeys(UTTtemp);

	}

	public void setSetbckTemperature(String tempstbck) {
		Am.waitForAnElementPresence(TemperatureSetback);
		TemperatureSetback.sendKeys(tempstbck);

	}

	public String getOTTemperature() {

		Am.waitForAnElementPresence(OTTemperature);
		String OTTemp = OTTemperature.getAttribute("value");
		return OTTemp;
	}

	public String getUTTemperature() {

		Am.waitForAnElementPresence(UTTemperature);
		String UTTemp = UTTemperature.getAttribute("value");
		return UTTemp;
	}

	public String getTemperatureSetback() {

		Am.waitForAnElementPresence(TemperatureSetback);
		String TempSB = TemperatureSetback.getAttribute("value");
		return TempSB;
	}

	public void clearOTTemperature() {

		Am.waitForAnElementPresence(OTTemperature);
		OTTemperature.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

	}

	public void clearUTTemperature() {

		Am.waitForAnElementPresence(UTTemperature);
		UTTemperature.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

	}

	public void clearTemperaturesetbck() {

		Am.waitForAnElementPresence(TemperatureSetback);
		TemperatureSetback.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

	}

	public Boolean getbtnstatus() {

		Am.waitForAnElementPresence(SAVE1);
		Boolean sttus = SAVE1.isEnabled();
		return sttus;
	}

	public void clickOnHose1toEnable() {

		List<Integer> hosestuts = getHoseEnableStatus();
		int hose1ele = hosestuts.get(0);

		if (hose1ele == 1) {

			HoseEnbbtn.click();
		}
	}

	public void clickApplicator1toEnable() {

		List<Integer> hosestuts = getApplicatorEnableStatus();
		int Applicator1 = hosestuts.get(0);

		if (Applicator1 == 1)

		{
			Am.waitForAnElementPresence(ApplicatorEnbbtn);
			ApplicatorEnbbtn.click();
		}

	}

	public Boolean getToastmsg() {

		Am.waitForAnElementPresence(Toastmsg);
		Boolean toastmsg = Toastmsg.isDisplayed();
		return toastmsg;
	}

}
