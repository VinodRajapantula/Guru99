package com.epam.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.pages.HomePage;
import com.epam.pages.LoginPage;
import com.epam.pages.NewCustomerPage;
import com.epam.utilities.XLUtils;

public class CreateNewCustomer_002 extends BaseClass {
	
	NewCustomerPage customerPage;
	HomePage homePage;
	boolean isLogin =  false;
	
	
	/*@BeforeTest
	public void login() throws InterruptedException{
		log.info("CreateNewCustomer_002 - Started");
		LoginPage loginPage = new LoginPage(driver);
		homePage = loginPage.enterLoginCredentials(userName, password);
		customerPage = homePage.getNewCustomerPage();
	}
	*/
	
	@Test(dataProvider = "CustomerData")	
	public void registerNewCustomer(String cusromerName,String gender,String month,String date,String year,String address,String city,String state,String pin,String mobile,String email,String customerPassword ) throws InterruptedException{
		
		log.info("CreateNewCustomer_002 - Started");
		if (isLogin == false){
			LoginPage loginPage = new LoginPage(driver);
			homePage = loginPage.enterLoginCredentials(userName, password);
			customerPage = homePage.getNewCustomerPage();
			isLogin = true;
		}
		
		
		System.out.println("*****cusromerName:" + cusromerName);
		customerPage.enterCustomerName(cusromerName);
		customerPage.selectGender(gender);
		customerPage.enterdateOfBirth(month,date,year);
		customerPage.enterAddress(address);
		customerPage.enterCity(city);
		customerPage.enterState(state);
		customerPage.enterPin(pin);
		customerPage.enterMobile(mobile);
		customerPage.enterEmail(email);
		customerPage.enterPassword(customerPassword);
		customerPage.clickOnSubmitButton();
		Thread.sleep(2000);
		
		if (customerPage.isNewCustomerRegisted()){
			Assert.assertTrue(true);
			log.info("User Registration is successful with "+ cusromerName);
			System.out.println("Success");
			//customerPage = homePage.getNewCustomerPage();			
			Thread.sleep(2000);
		}else{
			takeScreenshot("registerNewCustomer");
			log.info("User Registration is failed for "+ cusromerName);
			System.out.println("fail");
			Assert.assertTrue(false);
			customerPage = homePage.getNewCustomerPage();			
			Thread.sleep(2000);
		}
		
		log.info("CreateNewCustomer_002 - Ended");
		
		
	}
	
	@DataProvider(name="CustomerData")
	public Object[][] getCustomerData() throws IOException{
			
		String filePath= "./src/test/resources/CustomerData.xlsx";
		String sheetName = "Sheet1";

		int rowCount = XLUtils.getRowCount(filePath, sheetName);
		int CellCount = XLUtils.getCellCount(filePath, sheetName, 1);
		System.out.println("rowCount: " + rowCount);
		System.out.println("CellCount: " + CellCount);
		
		Object[][] data =  new Object[rowCount-1][CellCount];
		
		for (int i=0;i<rowCount-1;i++){
			for (int j=0;j<CellCount;j++){				
				data[i][j] = XLUtils.getCellData(filePath, sheetName, i+1, j);	
				//System.out.print(data[i][j] + " ");
			}
			//System.out.println();
		}
		return data;
	}

}
