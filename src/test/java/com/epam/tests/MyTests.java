package com.epam.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyTests {
	
	@Test(dataProvider ="mydata")
	public void getData(int first, int second){
		System.out.println("getdata");
		System.out.println(first);
		System.out.println(second);
	}
	
	
	
	
	
	@DataProvider(name="mydata")
	public Object[][] getExcelData(){
		
			System.out.println("data provider");
		
		/*String filePath= "./src/test/resources/CustomerData.xlsx";
		//String filePath=System.getProperty("user.dir")+"/src/test/resources/CustomerData.xlsx";
		String sheetName = "Sheet1";
		int rowCount = XLUtils.getRowCount(filePath, sheetName);
		System.out.println("rowCount: " + rowCount);
		int CellCount = XLUtils.getCellCount(filePath, sheetName, 1);
		System.out.println("CellCount: " + CellCount);
		
		String[][] data =  new String[rowCount][CellCount];
		for (int i=1;i<rowCount;i++){
			for (int j=0;j<CellCount;j++){				
				data[i][j] = XLUtils.getCellData(filePath, sheetName, i, j);
				//System.out.print(data[i][j] + " ");
				
			}
			//System.out.println();
			
		}*/
		
			Object data[][] = new Object[2][2];
		data[0][0]=0;
		data[0][1]=1;
		data[1][0]=2;
		data[1][1]=3;
		
		return data;
		
	}

}
