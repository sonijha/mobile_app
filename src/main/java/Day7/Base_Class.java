package Day7;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base_Class {
	
	public AppiumDriver driver;
	
	
	@BeforeClass
	@Parameters({"deviceID"})
	public void InitApp(String deviceID) throws MalformedURLException
	{
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("appPackage", "com.boondoggle.mortcalc");
		capabilities.setCapability("appActivity", "com.boondoggle.mortcalc.MortCalc");
		
		if(deviceID.equalsIgnoreCase("d1"))
		{
			System.out.println("Executing in Device1");
			
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		}
		
		else if(deviceID.equalsIgnoreCase("d2"))
		{
			System.out.println("Executing in Device2");
			
			capabilities.setCapability("deviceName", "GT-I9070");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "4.4.2");
			
		}
			
		
		//Appium grid details
		
		 driver= new AndroidDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

}
