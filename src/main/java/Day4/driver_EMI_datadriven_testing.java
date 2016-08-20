package Day4;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;

public class driver_EMI_datadriven_testing extends Base_Class_EMI{

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		Start_Server();
		Init_app();
		
		ExcelReadWrite xl= new ExcelReadWrite("E:\\TestData\\EMI_Data1.xls");
		
		HSSFSheet Sheet1 = xl.Setsheet("Sheet1");
		
		int RowCount = xl.getrowcount(Sheet1);
		System.out.println(RowCount);
		
		
		for(int i=1;i<=RowCount;i++)
		{
			
			String Amount = xl.Readvalue(Sheet1, i, "Amount");
			Amount= Amount.replace(".0", "");
			
			String Interest = xl.Readvalue(Sheet1, i, "Interest");
			Interest= Interest.replace(".0", "");
			
			String Tenure = xl.Readvalue(Sheet1, i, "Tenure");
			Tenure= Tenure.replace(".0", "");
			
			String Exp_Result = xl.Readvalue(Sheet1, i, "Exp_Result");
			
			//Enter the Amount, years, Interest
			driver.findElementById("com.boondoggle.mortcalc:id/var_amount").sendKeys(Amount);
			driver.findElementById("com.boondoggle.mortcalc:id/var_years").sendKeys(Tenure);
			driver.findElementById("com.boondoggle.mortcalc:id/var_interest").sendKeys(Interest);
						
			//click on calculate
			driver.findElementById("com.boondoggle.mortcalc:id/buttoncalc").click();
			
			//get the output
			String Output = driver.findElementById("com.boondoggle.mortcalc:id/var_mortgage").getText();
			System.out.println(Output);
			
			String Actual_Res = Output.replace("$", "");
			xl.writecell(Sheet1, i, "Actual_Result", Actual_Res);
						
			//validation
			
			if(Actual_Res.equals(Exp_Result))
			{
				xl.writecell(Sheet1, i, "Status", "Pass");
			}
			else
			{
				xl.writecell(Sheet1, i, "Status", "Fail");
			}
			
					
			
		}
		
		
		xl.save_excel("E:\\TestData\\EMI_Data1.xls");
		
		//Stop the Server
		Stop_Server();
		

	}

}
