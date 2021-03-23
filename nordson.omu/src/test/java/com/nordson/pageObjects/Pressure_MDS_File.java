package com.nordson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nordson.utilities.ActionMethods;
import com.nordson.utilities.Xls_Reader;

public class Pressure_MDS_File {
	WebDriver ldriver;
	WebDriverWait wait;
	Xls_Reader reader;
	ActionMethods customwait = new ActionMethods();

	// Constructor of the Pressure_Min_Max_Validations class to initiate driver
	public Pressure_MDS_File(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// WebElements Locators
	@FindBy(xpath = "//div[contains(text(),' SETUP TOOL ')]")
	@CacheLookup
	WebElement SetUpToolLink;

	@FindBy(xpath = "//div[contains(text(),'CREATE NEW')]")
	@CacheLookup
	WebElement CreateNewNorFileButton;

	@FindBy(xpath = "//textarea[@placeholder='Write Description here...']")
	@CacheLookup
	WebElement AddDescriptionText;

	@FindBy(xpath = "//button[normalize-space()='SUBMIT']")
	@CacheLookup
	WebElement SubmitButton;

	@FindBy(xpath = "//span[@class='heading-text-sidenav']/following::mat-expansion-panel-header[2]")
	WebElement SystemSettingsLink;

	@FindBy(xpath = "//div[contains(text(),'Preferences')]")
	WebElement PreferencesLink;

	@FindBy(xpath = "//article[normalize-space()='Pressure Unit']/following::div[2]")
	WebElement KPAUnit;

	@FindBy(xpath = "//button[normalize-space()='SAVE']")
	WebElement SaveButton;

	@FindBy(xpath = "//span[contains(text(), 'DASHBOARD')]/following::mat-panel-description[1]")
	@CacheLookup
	WebElement RunTimeSettings;

	@FindBy(xpath = "//div[normalize-space()='Pressure']")
	WebElement Pressure;

	@FindBy(xpath = "//div[contains(@class,'row row-margin')]//span[contains(@class,'min')][normalize-space()='kPa']/preceding::input[1]")
	WebElement MinSetPoint;

	@FindBy(xpath = "//input[contains(@name,'ulPressureMinSetPoint')]")
	WebElement clearKPAMinSetPoint;

	// Page Action Methods for all the WebElements declared
	public void clickSetUpToolLink() throws InterruptedException {

		customwait.waitForAnElementPresence(By.xpath("//div[contains(text(),' SETUP TOOL ')]"));
		SetUpToolLink.click();

	}

	public void clickCreateNewFile() {
		customwait.waitForAnElementPresence(By.xpath("//div[contains(text(),'CREATE NEW')]"));
		CreateNewNorFileButton.click();

	}

	public void addDescription() {
		customwait.waitForAnElementPresence(By.xpath("//textarea[@placeholder='Write Description here...']"));
		AddDescriptionText.sendKeys("Description");

	}

	public void clickSubmit() throws InterruptedException {
		customwait.waitForAnElementPresence(By.xpath("//button[normalize-space()='SUBMIT']"));
		SubmitButton.click();
		Thread.sleep(2000);

	}

	public void ClickSystemSettingsLink() throws InterruptedException {
		Thread.sleep(2000);
		customwait.waitForAnElementPresence(
				By.xpath("//span[@class='heading-text-sidenav']/following::mat-expansion-panel-header[2]"));
		SystemSettingsLink.click();
		Thread.sleep(2000);

	}

	public void ClickPreferencesLink() throws InterruptedException {
		Thread.sleep(4000);
		customwait.waitForAnElementPresence(By.xpath("//div[contains(text(),'Preferences')]"));
		PreferencesLink.click();
		Thread.sleep(2000);

	}

	public void SelectKPAUnit() throws InterruptedException {
		customwait.waitForAnElementPresence(By.xpath("//article[normalize-space()='Pressure Unit']/following::div[2]"));
		Thread.sleep(2000);
		KPAUnit.click();
		Thread.sleep(2000);

	}

	public void saveButton() throws InterruptedException {
		Thread.sleep(2000);
		customwait.waitForAnElementClickable(By.xpath("//button[normalize-space()='SAVE']"));
		SaveButton.click();
		Thread.sleep(2000);
	}

	public void clickRunTimeSettings() throws InterruptedException {
		try {
			Thread.sleep(3000);
			customwait.waitForAnElementPresence(
					By.xpath("//span[@class='heading-text-sidenav']/following::mat-expansion-panel-header[1]"));
			RunTimeSettings.click();
		} catch (Exception e) {
			System.out.println("Unable to click on Run Time Settings link");
		}

	}

	public void clickPressure() throws InterruptedException {

		try {
			Thread.sleep(2000);
			customwait.waitForAnElementPresence(By.xpath("//div[normalize-space()='Pressure']"));
			Pressure.click();
			Thread.sleep(2000);
		}

		catch (Exception e) {

			System.out.println("Unable to click on Pressure link");
		}
	}

	public String getkPaMinSetPoint() throws InterruptedException {

		// customwait.waitForAnElementPresence(By.xpath(
		// "//div[contains(@class,'row
		// row-margin')]//span[contains(@class,'min')][normalize-space()='kPa']/preceding::input[1]"));
		// MinSetPoint.click();
		Thread.sleep(2000);
		boolean bool = MinSetPoint.isDisplayed();
		System.out.println("Min Set Point text box is displayed=" + bool);
		String min = MinSetPoint.getAttribute("value");
		Thread.sleep(2000);
		System.out.println("The default Minimum Set Point value for Kpa unit=" + min);
		return min;

	}

	public void clearMinSetPoint() throws InterruptedException {

		Thread.sleep(2000);
		clearKPAMinSetPoint.click();
		for (int i = 0; i <= 4; i++) {
			clearKPAMinSetPoint.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}
	}

	public void passpressurevaluemds() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("c:\\Users\\Ravi Raj\\eclipse-workspace\\QAPractices\\src\\MDS.xlsx");

		String sheetName = "ProBlue Flex";

		System.out.println(reader.getCellData(sheetName, "Min1", 6));
		String minvalue = reader.getCellData(sheetName, 13, 6);
		// int ivalue = Integer.parseInt(minvalue);
		System.out.println(minvalue);
		// System.out.println(ivalue);
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows: " + rowCount);

		// Thread.sleep(5000);
		// clearMinSetPoint.click();
		Thread.sleep(5000);
		// clearKPAMinSetPoint.sendKeys(minvalue);
		Thread.sleep(5000);
	}

}