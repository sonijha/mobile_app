package Day5;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Webbased_Search {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//capabilities.setBrowserName("Chrome");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		
		capabilities.setCapability("appPackage", "com.android.chrome");
     	capabilities.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(3000);
		
		driver.get("http://www.google.com/");
		Thread.sleep(3000);
		
		driver.findElementById("lst-ib").sendKeys("Sachin");
		driver.findElementById("tsbb").click();
		Thread.sleep(5000);
		
		String Actual_Result = driver.findElementByXPath("//span[contains(text(),'Cricketer')]").getText();
		System.out.println(Actual_Result);
		
		
		

	}

}
