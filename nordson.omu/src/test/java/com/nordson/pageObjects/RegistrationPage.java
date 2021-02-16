package com.nordson.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	WebDriver ldriver;
	WebDriverWait wait;

	// Constructor of the LoginPage to initiate driver
	public RegistrationPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	@CacheLookup
	WebElement SignUp;

	@FindBy(id = "fname")
	@CacheLookup
	WebElement FullName;

	@FindBy(id = "cname")
	@CacheLookup
	WebElement CompanyName;

	@FindBy(xpath = "//mat-select[@id='mat-select-0']")
	@CacheLookup
	WebElement CompanyType;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text')][normalize-space()='End User']")
	@CacheLookup
	WebElement CompanyTypeValue;

	@FindBy(id = "address")
	@CacheLookup
	WebElement Address;

	@FindBy(xpath = "//mat-form-field[@id='register-mat-sel-1']//div[@class='mat-form-field-infix']")
	@CacheLookup
	WebElement Country;

	@FindBy(xpath = "//span[normalize-space()='Afghanistan']")
	@CacheLookup
	WebElement CountryValue;

	@FindBy(id = "plant")
	@CacheLookup
	WebElement Plant;

	@FindBy(xpath = "//input[@id='padding-left-66']")
	@CacheLookup
	WebElement PhoneNumber;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	@CacheLookup
	WebElement Continue;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	@CacheLookup
	WebElement Continue2;

	@FindBy(id = "sno")
	@CacheLookup
	WebElement SerialNo;

	@FindBy(name = "uid")
	@CacheLookup
	WebElement UnqiueID;

	@FindBy(name = "description")
	@CacheLookup
	WebElement Desc;

	@FindBy(name = "email")
	@CacheLookup
	WebElement EmailAddress;

	@FindBy(name = "cemail")
	@CacheLookup
	WebElement ConfirmEmailAddress;

	@FindBy(name = "password")
	@CacheLookup
	WebElement Password;

	@FindBy(id = "ccpwd")
	@CacheLookup
	WebElement ConfirmPassword;

	@FindBy(xpath = "//div[@class='mat-checkbox-inner-container']")
	WebElement AgreeCheckBox;

	@FindBy(xpath = "//button[normalize-space()='Accept and Sign Up']")
	@CacheLookup
	WebElement AcceptAndSignup;

	// Page Action Methods for all the WebElements declared
	public void clickSingUp() {
		SignUp.click();

	}

	public void setFullName(String fullname) {
		FullName.sendKeys(fullname);

	}

	public void setCompanyName(String companyname) {
		CompanyName.sendKeys(companyname);

	}

	public void setCompanyType() throws InterruptedException {

		CompanyType.click();
		Thread.sleep(2000);
		CompanyTypeValue.click();
		// Select comptypes = new Select(CompanyType);
		// comptypes.selectByVisibleText("Nordson");

	}

	public void setAddress(String address) {

		Address.sendKeys(address);

	}

	public void selectCountry() throws InterruptedException {

		Country.click();
		Thread.sleep(1000);
		CountryValue.click();
		// countries.selectByVisibleText("Iraq");
		// Select countries = new Select(Country);
	}

	public void setPlant(String plant) {
		Plant.sendKeys(plant);

	}

	public void setPhoneNumber(String phonenumber) {
		PhoneNumber.sendKeys(phonenumber);
	}

	public void clickContinue() {
		Continue.click();
	}

	public void addSerialNo(String sno) {
		SerialNo.sendKeys(sno);
	}

	public void addUniqueNo(String uno) {
		UnqiueID.sendKeys(uno);
	}

	public void addDescription(String desc) {
		Desc.sendKeys(desc);
	}

	public void clickoNContinue() {
		Continue2.click();
	}

	public void setEmailId(String emailid) {

		EmailAddress.sendKeys(emailid);
	}

	public void setConfirmEmail(String confemail) {
		ConfirmEmailAddress.sendKeys(confemail);
	}

	public void setPassword(String pass) {
		Password.sendKeys(pass);
	}

	public void setConfirmPassword(String confpass) {
		ConfirmPassword.sendKeys(confpass);
	}

	public void checkboxAgreeTerms() {
		AgreeCheckBox.click();
	}

	public boolean acceptAndSignUPEnabled() {
		return AcceptAndSignup.isEnabled();

	}

	public void waitForElementClickabled() {
		WebDriverWait wait = new WebDriverWait(ldriver, 45);
		wait.until(ExpectedConditions.elementToBeClickable(AcceptAndSignup));

	}

	public void acceptAndSignUP() {
		AcceptAndSignup.click();

	}

}
