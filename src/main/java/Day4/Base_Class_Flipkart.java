package Day4;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Base_Class_Flipkart {
	
	static Process process;
	public static AndroidDriver driver;
	
	//Start server
	
	public static void Start_Server() throws IOException, InterruptedException
	{
		String Start_Server="E:\\Appium\\node.exe  E:\\Appium\\node_modules\\appium\\bin\\appium.js";
		
		 process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!=null)
		{
			System.out.println("Started the Appium serever");
		}
		else
		{
			System.out.println("NOT Initialized");
		}
			
		Thread.sleep(12000);
				
	}
	
	//********************************************
	
	public static void Init_app() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
		
		//Appium details
		
		driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(3000);
		
		
		
	}
	
	
	
	
	
	
	//******************************************
	// Stop server
	
	public static void Stop_Server() throws InterruptedException
	{
		Thread.sleep(4000);
		if(process!=null)
		{
			process.destroy();
			Thread.sleep(4000);
			System.out.println("Stopped the appium server");
			
		}
	}

}
