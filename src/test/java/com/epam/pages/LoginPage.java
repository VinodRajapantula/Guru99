package com.epam.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name='uid']")
	WebElement userName;
	
	@FindBy(css="input[name='password']")
	WebElement password;
	
	@FindBy(css="input[name='btnLogin']")
	WebElement loginButton;
	
	public HomePage enterLoginCredentials(String uName, String pwd) throws InterruptedException{
		userName.sendKeys(uName);
		password.sendKeys(pwd);
		loginButton.click();	
		Thread.sleep(3000);
		return new HomePage(driver);
	}
	
	public boolean verifyHomePageDisplayed(){
			acceptAlert();
			return driver.getTitle().equals("Guru99 Bank Manager HomePage");
	}
	
	
	public void acceptAlert(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
	
	
	
	

}
