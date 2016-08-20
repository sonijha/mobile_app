package Day7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

public class dataprovider_summation {
	
	@DataProvider(name="dp_Sum")	
	public static Iterator<String[]> getdata_summation() throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("E:\\TestData\\Sum1.xls");
		
		HSSFSheet Sheet1 = xl.Setsheet("Sheet1");
		
		int RowCount = xl.getrowcount(Sheet1);
		//*****************************************
		//create a list
		
		List<String[]> arrlist= new ArrayList<String[]>();
		
		
		for(int i=1;i<=RowCount;i++)
		{
			String [] arr=new String[3];
			
			arr[0]=xl.Readvalue(Sheet1, i, "Num1");
			arr[1]=xl.Readvalue(Sheet1, i, "Num2");
			arr[2]=xl.Readvalue(Sheet1, i, "Exp_Result");
			
			
			arrlist.add(arr);	
			
		}
		
		
		return arrlist.iterator();
		
	}
	
	
	
	

}
