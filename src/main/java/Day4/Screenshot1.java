package Day4;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Screenshot1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String Start_Server="D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		
		Process process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!=null)
		{
			System.out.println("Started the Appium serever");
		}
		else
		{
			System.out.println("NOT Initialized");
		}
			
		Thread.sleep(12000);
		//*************************************************
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		
		//Appium details
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(8000);
		
		//taking screenshot
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		
		System.out.println(screenshotAs);
		
		FileUtils.copyFile(screenshotAs, new File("E:\\Testing\\July_batch_screenshot.png"));
		
		Thread.sleep(4000);
		//***********************************************************
		//stop the appium server
		
		if(process!=null)
		{
			process.destroy();
			Thread.sleep(4000);
			System.out.println("Stopped the appium server");
			
		}
		
		

	}

}
