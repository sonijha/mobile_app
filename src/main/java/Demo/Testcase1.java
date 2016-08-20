package Demo;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Testcase1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch the  app
		
		//Device details
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage", "com.boondoggle.mortcalc");
		capabilities.setCapability("appActivity", "com.boondoggle.mortcalc.MortCalc");
		
		//Appium details
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(8000);
		
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
		
		
		//close app
		driver.quit();
		
		

	}

}
