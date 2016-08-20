package Day6;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hybrid_learning {

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
		
		//**************************************************
		
			
		//zip element is web view
		for(String contextname:contextHandles)
		{
			System.out.println("-------Zip element--------");
			System.out.println(contextname);
			
			if(contextname.contains("WEBVIEW"))
			{
				driver.context(contextname);
			}			
			
		}
		
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
		for(String contextname:contextHandles)
		{
			System.out.println("-------Get Started--------");
			System.out.println(contextname);
			
			if(contextname.contains("NATIVE"))
			{
				driver.context(contextname);
			}			
			
		}
		
		Thread.sleep(4000);
		
		driver.findElementByXPath("//*[@index='17'][@class='android.view.View'][@content-desc='GET STARTED']").click();
		Thread.sleep(4000);
		
		//***********************************************************
		
		//Register is web view
		
		for(String contextname:contextHandles)
		{
			System.out.println("-------Register--------");
			System.out.println(contextname);
			
			if(contextname.contains("WEBVIEW"))
			{
				driver.context(contextname);
			}			
			
		}
		
		Thread.sleep(4000);
		
		boolean Actual_Res = driver.findElementByClassName("intro-slide-register").isDisplayed();
		System.out.println("Register is dispalayed  " +Actual_Res);
		
		
		
	}

}
