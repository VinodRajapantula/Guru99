package com.epam.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.epam.utilities.ReadConfigFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfigFile configReader =  new ReadConfigFile();
	WebDriver driver;
	String baseUrl = configReader.getProperty("baseUrl");
	String userName = configReader.getProperty("userName");
	String password = configReader.getProperty("password");
	
	Logger log;
	
	@Parameters("browser")
	@BeforeClass
	public void init(String currentBrowser){
		
		log = LogManager.getLogger(this.getClass());
		if (currentBrowser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (currentBrowser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (currentBrowser.equalsIgnoreCase("ie")){
			WebDriverManager.iedriver().setup();
			driver =  new InternetExplorerDriver();
		}
		
		log.info("Browser got initiated");
		driver.get(baseUrl);
		log.info("Accessing the url");
		driver.manage().window().maximize();
		log.info("Browser maximizing");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown(){
		if (driver!=null){
			driver.close();
		}
	}
	

	public void takeScreenshot(String testName){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,new File(System.getProperty("user.dir") + "/Screenshots/" + testName + ".png") );
		} catch (IOException e) {
			System.out.println("Unable to copy screenshot");
			log.info("Unable to copy screenshot for Test Case:" + testName);
			e.printStackTrace();
		}
	}

}
