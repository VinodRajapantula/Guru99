package com.epam.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.pages.LoginPage;

public class LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException {
		log.info("loginTest - Started");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLoginCredentials(userName, password);
		
		if (loginPage.verifyHomePageDisplayed()){
			Assert.assertTrue(true);
			log.info("Login Test is successful");
		}else{
			takeScreenshot("loginTest");
			log.info("Login Test is failed");
			Assert.assertTrue(false);
		}
		
		log.info("loginTest - Ended");
	}

}
