package Day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Start_stop_server_through_code {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	String Start_Server="C:\\Progra~1\\Appium\\node.exe C:\\Progra~1\\Appium\\node_modules\\appium\\bin\\appium.js";
	
	Process process = Runtime.getRuntime().exec(Start_Server);
	
	if(process!=null)
	{
		System.out.println("Started the Appium serever");
	}
	else
	{
		System.out.println("NOT Initialized");
	}
		
	Thread.sleep(5000);
	//*************************************************
	
	DesiredCapabilities capabilities= new DesiredCapabilities();
	
	capabilities.setCapability("deviceName", "XT1033");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("platformVersion", "4.4.4");
	
	//app details
	capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
	capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
	
	//Appium details
	
	System.out.println("xyz");
	AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	System.out.println("abc");

	Thread.sleep(5000);


//click on the element
//	driver.findElementById("com.mobeta.android.demodslv:id/activity_title").click();

	WebElement ele1 = driver.findElementById("com.mobeta.android.demodslv:id/activity_title");
	ele1.click();
//drag and drop
	
	List<WebElement> drag_ele = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle");
	System.out.println(drag_ele.size());
	
	//Touch action
	
	TouchAction action= new TouchAction(driver);
	//action.longPress(drag_ele.get(0)).moveTo(drag_ele.get(5)).release().perform();
	
	Thread.sleep(6000);
	action.longPress(drag_ele.get(6)).moveTo(drag_ele.get(2)).release().perform();
	
	Thread.sleep(4000);
	//***********************************************************
	//stop the appium server
	
	if(process!=null)
	{
		process.destroy();
		Thread.sleep(4000);
		System.out.println("Stopped the appium server");
		
	}
	
		
	//*******************************************************	

	}

}
