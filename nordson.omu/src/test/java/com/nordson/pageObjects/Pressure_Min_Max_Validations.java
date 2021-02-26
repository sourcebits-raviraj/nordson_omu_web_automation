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

public class Pressure_Min_Max_Validations {

	WebDriver ldriver;
	WebDriverWait wait;
	ActionMethods customwait = new ActionMethods();

	// Constructor of the Pressure_Min_Max_Validations class to initiate driver
	public Pressure_Min_Max_Validations(WebDriver rdriver) {

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

	@FindBy(xpath = "//input[contains(@name,'ulPressureMinSetPoint')]")
	WebElement clearKPAMinSetPoint;

	@FindBy(xpath = "//input[contains(@name,'ulPressureMaxSetPoint')]")
	WebElement clearKPAMaxSetPoint;

	@FindBy(xpath = "//input[contains(@name,'ulPressureMinSetPoint')]/following::span[1]")
	WebElement kPaText;

	@FindBy(xpath = "//input[contains(@name,'ulPressureMinSetPoint')]/following::span[1]")
	WebElement BARText;

	@FindBy(xpath = "//article[normalize-space()='Pressure Unit']/following::div[8]")
	WebElement BARUnit;

	@FindBy(xpath = "//div[contains(@class,'row row-margin')]//span[contains(@class,'min')][normalize-space()='BAR']/preceding::input[1]")
	WebElement BARMinSetPoint;

	@FindBy(xpath = "//div[contains(@class,'row display-flex-align-center')]//span[contains(@class,'min')][normalize-space()='BAR']/preceding::input[1]")
	WebElement BARMaxSetPoint;

	@FindBy(xpath = "//article[normalize-space()='Pressure Unit']/following::div[14]")
	WebElement PSIUnit;

	@FindBy(xpath = "//div[contains(@class,'row row-margin')]//span[contains(@class,'min')][normalize-space()='PSI']/preceding::input[1]")
	WebElement PSIMinSetPoint;

	@FindBy(xpath = "//div[contains(@class,'row display-flex-align-center')]//span[contains(@class,'min')][normalize-space()='PSI']/preceding::input[1]")
	WebElement PSIMaxSetPoint;

	@FindBy(xpath = "//div[contains(@class,'row row-margin')]//span[contains(@class,'min')][normalize-space()='PSI']")
	WebElement PSIText;

	@FindBy(xpath = "//span[contains(text(),'Pneumatic')]")
	WebElement SelectHydaulic;

	@FindBy(xpath = "//span[@class='mat-option-text'][normalize-space()='Hydraulic']")
	WebElement SelectHydaulicValue;

	@FindBy(css = "div#toast-container")
	WebElement ToastMessage;

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
		Thread.sleep(2000);
		customwait.waitForAnElementPresence(By.xpath("//button[normalize-space()='SUBMIT']"));
		SubmitButton.click();
		Thread.sleep(2000);

	}

	public void ClickSystemSettingsLink() throws InterruptedException {
		Thread.sleep(3000);
		customwait.waitForAnElementPresence(
				By.xpath("//span[@class='heading-text-sidenav']/following::mat-expansion-panel-header[2]"));
		Thread.sleep(3000);
		SystemSettingsLink.click();

	}

	public void ClickPreferencesLink() throws InterruptedException {
		Thread.sleep(3000);
		customwait.waitForAnElementPresence(By.xpath("//div[contains(text(),'Preferences')]"));
		PreferencesLink.click();

	}

	public void SelectKPAUnit() throws InterruptedException {
		Thread.sleep(2000);
		customwait.waitForAnElementPresence(By.xpath("//article[normalize-space()='Pressure Unit']/following::div[2]"));
		KPAUnit.click();

	}

	public void saveButton() throws InterruptedException {
		Thread.sleep(2000);
		customwait.waitForAnElementClickable(By.xpath("//button[normalize-space()='SAVE']"));
		SaveButton.click();

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
		}

		catch (Exception e) {

			System.out.println("Unable to click on Pressure link");
		}

	}

	public void clearMinSetPoint() throws InterruptedException {

		Thread.sleep(2000);
		clearKPAMinSetPoint.click();
		for (int i = 0; i <= 4; i++) {
			clearKPAMinSetPoint.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}

	}

	public void clearMaxSetPoint() throws InterruptedException {

		Thread.sleep(2000);
		clearKPAMaxSetPoint.click();

		for (int i = 0; i <= 4; i++) {

			clearKPAMaxSetPoint.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}

	}

	public boolean saveButtonEnabled() throws InterruptedException {

		// Alert getPressureMinMax = ldriver.switchTo().alert();
		// String getPressureMinMax1 = getPressureMinMax.getText();
		// System.out.println("The alert is = " + getPressureMinMax1);
		// Robot robot = new Robot();
		// robot.mouseMove(1224, 67);
		// Alert getPressureMinMax = ldriver.switchTo().alert();
		// getPressureMinMax.getText();
		// customwait.waitForAnElementClickable(By.xpath("//button[normalize-space()='SAVE']"));
		boolean button;
		if (button = SaveButton.isEnabled()) {
			System.out.println(button);
			return button = true;

		} else {
			System.out.println(button);
			return button = false;

		}

	}

	public void setMinValue(String minvalue) throws InterruptedException {

		Thread.sleep(1000);
		clearKPAMinSetPoint.click();
		Thread.sleep(1000);
		clearKPAMinSetPoint.sendKeys(minvalue);
		// Thread.sleep(1000);

	}

	public void setMaxValue(String maxvalue) throws InterruptedException {

		Thread.sleep(1000);
		clearKPAMaxSetPoint.click();
		Thread.sleep(1000);
		clearKPAMaxSetPoint.sendKeys(maxvalue);
		// Thread.sleep(1000);

	}

	// Action Methods For BAR Pressure Unit

	public void SelectBARUnit() throws InterruptedException {
		try {
			Thread.sleep(2000);
			customwait.waitForAnElementPresence(
					By.xpath("//article[normalize-space()='Pressure Unit']/following::div[8]"));
			BARUnit.click();
		} catch (Exception e) {
			System.out.println("Unable to click on BAR Radio button");
		}
	}

	public String getBARMinSetPoint() throws InterruptedException {

		// MinSetPoint.click();
		Thread.sleep(3000);
		boolean bool = BARMinSetPoint.isDisplayed();
		System.out.println("Min Set Point text box  for BAR is displayed=" + bool);
		String min = BARMinSetPoint.getAttribute("value");
		System.out.println("The default Minimum Set Point value for BAR unit=" + min);
		return min;

	}

	public String getBARMaxSetPoint() throws InterruptedException {

		Thread.sleep(2000);
		// MaxSetPoint.click();
		boolean bool1 = BARMaxSetPoint.isDisplayed();
		System.out.println("Max Set Point text box for BAR is displayed=" + bool1);
		String max = BARMaxSetPoint.getAttribute("value");
		System.out.println("The default Maximum Set Point value for BAR unit=" + max);
		return max;
	}

	public boolean getBARText() throws InterruptedException {

		Thread.sleep(2000);
		boolean BAR = BARText.isDisplayed();
		System.out.println("The BAR Text value is displayed=" + BAR);
		return BAR;
	}
	// PSI Action methods

	public void SelectPSIUnit() throws InterruptedException {
		try {
			Thread.sleep(2000);
			customwait.waitForAnElementPresence(
					By.xpath("//article[normalize-space()='Pressure Unit']/following::div[14]"));
			PSIUnit.click();
		} catch (Exception e) {
			System.out.println("Unable to click on PSI Radio button");
		}
	}

	public String getPSIMinSetPoint() throws InterruptedException {

		// customwait.waitForAnElementPresence(By.xpath(
		// "//div[contains(@class,'row
		// row-margin')]//span[contains(@class,'min')][normalize-space()='PSI']/preceding::input[1]"));
		// MinSetPoint.click();
		Thread.sleep(2000);
		// boolean bool = PSIMinSetPoint.isDisplayed();
		// System.out.println("Min Set Point for PSI text box is displayed=" + bool);
		String min = PSIMinSetPoint.getAttribute("value");
		System.out.println("The default Minimum Set Point value for PSI unit=" + min);
		return min;

	}

	public String getPSIMaxSetPoint() throws InterruptedException {

		Thread.sleep(2000);
		// boolean bool1 = PSIMaxSetPoint.isDisplayed();
		// System.out.println("Max Set Point for PSI text box is displayed=" + bool1);
		String max = PSIMaxSetPoint.getAttribute("value");
		System.out.println("The default Maximum Set Point value for PSI unit is =" + max);
		return max;
	}

	public boolean getPSIText() throws InterruptedException {
		Thread.sleep(2000);
		boolean psi = PSIText.isDisplayed();
		System.out.println("The PSI Text value is displayed=" + psi);
		return psi;
	}

	public void SelectHydaulicDropdown() throws InterruptedException {

		Thread.sleep(2000);
		SelectHydaulic.click();
		Thread.sleep(2000);
		SelectHydaulicValue.click();
		Thread.sleep(2000);

	}

	public boolean toastmessageDisplayed() {

		boolean tmsg = ToastMessage.isDisplayed();
		System.out.println("The toast message is displayed=" + tmsg);
		return tmsg;
	}

	public String getToastMessageText() {

		String tm = ToastMessage.getText();
		System.out.println("Value of the toast message is=" + tm);
		return tm;
	}

}
