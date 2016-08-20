package Day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

public class RealEstate {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch app		
		//device details
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage","com.edmund.mortgageCalculator");
		capabilities.setCapability("appActivity","com.edmund.mortgageCalculator.MortgageCalculator");
		
		//Appium server
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//***************************************************
		for(int i=1;i<=3;i++)
		{
		
	    System.out.println("----------- Iterations "+i+"----------");
		Scanner input= new Scanner(System.in);
		
		System.out.println("Enter the Amount");
		String Amount = input.next();
		
		System.out.println("Enter the Interest");
		String Interest = input.next();
		
		System.out.println("Enter the Tenure");
		String Tenure = input.next();
		
		System.out.println("Enter the Expected Result");
		String Exp_Result = input.next();
		
		//String Exp_Result="222.44";
		
		//Enter the amount, Interest, tenure
		driver.findElementById("com.edmund.mortgageCalculator:id/loan_amount_field").sendKeys(Amount);
		driver.findElementById("com.edmund.mortgageCalculator:id/interest_rate_field").sendKeys(Interest);
		driver.findElementById("com.edmund.mortgageCalculator:id/loan_term_field").sendKeys(Tenure);
		
		//click on calculate
		driver.findElementById("com.edmund.mortgageCalculator:id/calculate").click();
		
		Thread.sleep(3000);
		//get the output
		String Output = driver.findElementById("com.edmund.mortgageCalculator:id/monthly_payment_field").getText();
		System.out.println(Output);
		
		String Result = Output.replace(". Double tap to edit.", "");
		System.out.println(Result);
		
		//wrapper class
		
		double final_result=Double.parseDouble(Result);
		System.out.println("Converted to double  "+final_result);
		
				
		DecimalFormat df= new DecimalFormat(".00");
		String Actual_Result = df.format(final_result);
		
		System.out.println("Actual Result  is "+Actual_Result);
		
		System.out.println("Expected Result is "+Exp_Result);
		
		
		//validate
		
		if(Actual_Result.equals(Exp_Result))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		}
		//close the app
		driver.quit();

	}

}
