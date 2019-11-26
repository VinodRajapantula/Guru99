package com.epam.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {
	
	private static Properties prop;
	private FileInputStream fis;
	
	public ReadConfigFile(){
		try {
			fis = new FileInputStream("C:\\Users\\Vinod_Rajapantula\\workspace\\Guru99\\src\\test\\resources\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public String getProperty(String propertyName){
		
		if ( prop.getProperty(propertyName)!= ""){
			return prop.getProperty(propertyName);
		}else{
			System.out.println("Property does not exists");
			return "";
		}
	}

}
