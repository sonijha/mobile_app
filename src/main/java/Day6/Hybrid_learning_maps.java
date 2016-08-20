package Day6;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hybrid_learning_maps {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		File app= new File("E:\\Testing\\Burger_King\\bk-mobile-native.apk");
		
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("app",app.getAbsolutePath());
		
		//Appium details
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(10000);
		
		driver.findElementById("android:id/button1").click();
		
		//***********************************************
		
		Set<String> contextHandles = driver.getContextHandles();
		HashMap<String,String> hashmap= new HashMap<String,String>();
		
		//**************************************************
		
			
		
		for(String contextname:contextHandles)
		{
			if(contextname.contains("WEBVIEW"))
			{
				hashmap.put("webview", contextname);
				//driver.context(contextname);
				
			}
			else
			{
				hashmap.put("native", contextname);
				//driver.context(contextname);
				
			}
			
					
		}
		
		//***************************************************
		
		driver.context(hashmap.get("webview"));
		
		Thread.sleep(5000);
		WebDriverWait wait= new WebDriverWait(driver, 75);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("zip")));
		
		System.out.println(until.isDisplayed());
		Thread.sleep(5000);
		
		
		driver.findElementByName("zip").clear();
		Thread.sleep(4000);
		
		driver.findElementByName("zip").sendKeys("27102");
		Thread.sleep(4000);
		
		//*********************************************************
		//Get started is native element
		
		driver.context(hashmap.get("native"));
		
		Thread.sleep(4000);
		
		driver.findElementByXPath("//*[@index='17'][@class='android.view.View'][@content-desc='GET STARTED']").click();
		Thread.sleep(4000);
		
		//***********************************************************
		
		//Register is web view
		
		driver.context(hashmap.get("webview"));
		
		Thread.sleep(4000);
		
		boolean Actual_Res = driver.findElementByClassName("intro-slide-register").isDisplayed();
		System.out.println("Register is dispalayed  " +Actual_Res);
		
		
		

	}

}
