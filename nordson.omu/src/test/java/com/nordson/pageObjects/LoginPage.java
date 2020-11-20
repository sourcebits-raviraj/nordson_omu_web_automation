package com.nordson.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver ldriver;
	WebDriverWait wait;

	// Constructor of the LoginPage to initiate driver
	public LoginPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "email")
	@CacheLookup
	WebElement EmailID;

	@FindBy(id = "pwd")
	@CacheLookup
	WebElement Password;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	@CacheLookup
	WebElement LoginButton;

	@FindBy(xpath = "//span[@class='text-captalize now-wrap new-menu-bt']")
	@CacheLookup
	WebElement LogoutMenu;

	@FindBy(xpath = "//div[@class='header-dropdown-menu new-menu-singout profile-hover']")
	@CacheLookup
	WebElement LogoutButton;

	@FindBy(xpath = "//button[normalize-space()='LOG OUT']")
	@CacheLookup
	WebElement LogoutAlert;

	@FindBy(xpath = "//div[@class='landing-signin']")
	@CacheLookup
	WebElement SignIn;

	// Page Action Methods for all the WebElements declared
	public void setUserName(String username) {
		EmailID.sendKeys(username);

	}

	public void setPassword(String pass) {
		Password.sendKeys(pass);

	}

	public void clickLoginBtn() {
		LoginButton.click();

	}

	public void waitForLoginBtnEnable() {

		wait = new WebDriverWait(ldriver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Sign In']")));
	}

	public void loginBtnEnabled() {

		LoginButton.isEnabled();

	}

	public void clickLogoutBtn() {
		LogoutMenu.click();
		LogoutButton.click();
		LogoutAlert.click();

	}

	public void SignIn() {
		SignIn.click();

	}

	public void ClearUsername() {
		EmailID.clear();
	}

	public void ClearPassword() {
		Password.clear();
	}
}
