package testutility;

import java.util.ArrayList;

public class TestUtil 
{
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDatafromExcel()
	{ 
		
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		
		try{
			reader=new Xls_Reader("C:/Users/suresh/workspace1/TestNg/src/main/java/testdata/Testdata.xlsx");	
		} catch (Exception e){
			
			e.printStackTrace();
		}
		
		
		
		for(int rowNum=2;rowNum<=reader.getRowCount("RegTestData");rowNum++)
				{
			
			String firstname=reader.getCellData("RegTestData", "firstName", rowNum);
			String lastname=reader.getCellData("RegTestData", "lastName", rowNum);
			String emailid=reader.getCellData("RegTestData", "EmailId", rowNum);
			String Password=reader.getCellData("RegTestData", "Password", rowNum);
			
			Object ob[]={firstname,lastname,emailid,Password};
			
			myData.add(ob);
				
				}
		
		return myData;
		
		
	}

}
