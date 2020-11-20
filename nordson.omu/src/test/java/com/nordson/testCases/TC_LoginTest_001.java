package com.nordson.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nordson.pageObjects.LoginPage;
import com.nordson.utilities.ActionMethods;

public class TC_LoginTest_001 extends BaseClass {

	LoginPage lp;
	ActionMethods Am;
	// WebDriverWait wait;

	@Test(priority = 1, enabled = true)
	public void LoginTest() throws InterruptedException, IOException {

		log.info("URL is launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		log.info("Wait for the page load time out");

		lp = new LoginPage(driver);
		log.info("Webdriver driver is instantiated");

		lp.setUserName(SuperUsername);
		log.info("Username is set");

		lp.setPassword(SuperPassword);
		log.info("Password is set");

		try {

			lp.loginBtnEnabled();
			log.info("Login Button is enabled");
		}

		catch (Exception e) {
			log.info("Login Button is disbaled");

		}

		lp.waitForLoginBtnEnable();
		lp.clickLoginBtn();
		log.info("Clicked on Login button");
		Thread.sleep(5000);

		// Assertion to verify the title is matching with expected Title
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {

			System.out.println("Title Matched");
			Assert.assertTrue(true);
			log.debug("Title of the page is matching");
		} else {
			System.out.println("Title didn't match");
			Assert.assertTrue(false);
			log.error("Title of the page is not matching");
		}
		// verify the login is successful
		if (driver.getPageSource().contains("ADD NEW ADMIN")) {
			System.out.println("Login Successful");
			Assert.assertTrue(true);
		}

		else {

			Am = new ActionMethods();
			Am.captureScreen(driver, "LoginTest");
			System.out.println("Invalid Login Credentials");
			Assert.assertTrue(false);

		}
	}
}
