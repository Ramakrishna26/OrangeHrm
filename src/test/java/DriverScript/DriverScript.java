package DriverScript;

import utils.ExcelFileUtils;

public class DriverScript 
{
	public void startTest() throws Exception
	{
		ExcelFileUtils excel = new ExcelFileUtils();
		
		for (int i = 0; i < excel.getRowCount("MasterTestCases"); i++) 
		{
			String ModuleStatus = "";
			if (excel.getData("MasterTestCases", i, 2).equalsIgnoreCase("y")) 
			{
				String TC_Module = excel.getData("MasterTestCases", i, 1);
				int rowcount = excel.getRowCount(TC_Module);
				
			}
			
		}
	}

}
