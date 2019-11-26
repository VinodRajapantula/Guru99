package com.epam.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver driver;

	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='name']")
	WebElement customerNameTextbox;

	@CacheLookup
	@FindBy(css = "input[name='rad1'][value='m']")
	WebElement maleRadioButton;

	@CacheLookup
	@FindBy(css = "input[name='rad1'][value='f']")
	WebElement femaleRadioButton;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement dateOfBirthText;

	@CacheLookup
	@FindBy(css = "textarea[name='addr']")
	WebElement addressText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement cityText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement stateText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement pinText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement mobileText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement emailText;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement passwordText;

	@CacheLookup
	@FindBy(css = "input[value='Submit']")
	WebElement submitButton;

	public void enterCustomerName(String cusromerName) {
		System.out.println("Inside NewCustomer Page cusromerName:" + cusromerName);
		customerNameTextbox.sendKeys(cusromerName);
	}

	public void selectGender(String gender) {
		if (gender.equalsIgnoreCase("male")) {
			maleRadioButton.click();
		} else {
			femaleRadioButton.click();
		}
	}

	public void enterdateOfBirth(String month, String date, String year) {
		dateOfBirthText.sendKeys(month);
		dateOfBirthText.sendKeys(date);
		dateOfBirthText.sendKeys(year);
	}

	public void enterAddress(String address) {
		addressText.sendKeys(address);
	}

	public void enterCity(String city) {
		cityText.sendKeys(city);
	}

	public void enterState(String state) {
		stateText.sendKeys(state);
	}

	public void enterPin(String pin) {
		pinText.sendKeys(pin);
	}

	public void enterMobile(String mobile) {
		mobileText.sendKeys(mobile);

	}

	public void enterEmail(String email) {
		emailText.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordText.sendKeys(password);
	}

	public void clickOnSubmitButton() {
		submitButton.click();
	}

	public boolean isNewCustomerRegisted() {
		if (isAlertPresent()){
			acceptAlert();
			return false;
		}else{
			return driver.getPageSource().contains("Customer Registered Successfully!!!");
		}
	}

	

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}

}
