package Day7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class driver_Summation {
	
	
//	@Test(dataProvider="dp_Sum", dataProviderClass=Day7.dataprovider_summation.class)
//	public void testSummation(String Num1, String Num2, String Exp_Result)
//	{
//		
//		double Actual_Result= Double.parseDouble(Num1)+Double.parseDouble(Num2);
//		
//		if(Actual_Result==Double.parseDouble(Exp_Result))
//		{
//			System.out.println("Pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
//		
//		
//	}
//	
	
	//assert used
	@Test(dataProvider="dp_Sum", dataProviderClass=Day7.dataprovider_summation.class)
	public void testSummation(String Num1, String Num2, String Exp_Result)
	{
		
		double Actual_Result= Double.parseDouble(Num1)+Double.parseDouble(Num2);
		
		double Expected_Final=  Double.parseDouble(Exp_Result);
		
		//hard assert
		Assert.assertEquals(Actual_Result, Expected_Final);
		
	}
	

}
