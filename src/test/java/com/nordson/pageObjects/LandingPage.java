package com.nordson.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver ldriver;

	// Constructor of the LoginPage to initiate driver
	public LandingPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[normalize-space()='DASHBOARD']")
	@CacheLookup
	WebElement DashBoard;

	// Page Action Methods for all the WebElements declared
	public void dashBoardLink() {
		DashBoard.click();

	}

}
