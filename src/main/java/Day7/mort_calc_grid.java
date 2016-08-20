package Day7;

import org.testng.annotations.Test;

public class mort_calc_grid extends Base_Class {
	
	
	@Test
		public void testmortgage()
	{
		String Expected_Res="222.44";
		System.out.println("Expected Result is  "+Expected_Res);
		
		//Enter the Amount, years, Interest
		driver.findElementById("com.boondoggle.mortcalc:id/var_amount").sendKeys("10000");
		driver.findElementById("com.boondoggle.mortcalc:id/var_years").sendKeys("5");
		driver.findElementById("com.boondoggle.mortcalc:id/var_interest").sendKeys("12");
					
		//click on calculate
		driver.findElementById("com.boondoggle.mortcalc:id/buttoncalc").click();
		
		//get the output
		String Output = driver.findElementById("com.boondoggle.mortcalc:id/var_mortgage").getText();
		System.out.println(Output);
		
		String Actual_Res = Output.replace("$", "");
		
		System.out.println("Actual result is " +Actual_Res);
		
		//validation
		
		if(Actual_Res.equals(Expected_Res))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
	}
	
	

}
