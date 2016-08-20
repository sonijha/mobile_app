package Demo;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Testcase2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//launch the app
		
		//device deatils
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage", "com.ebay.mobile");
		capabilities.setCapability("appActivity", "com.ebay.mobile.activities.eBay");
		
		//Appium details
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		
		Thread.sleep(12000);
		
		String Expected_Res="100,115";
				
		//click on the search
		
		driver.findElementById("com.ebay.mobile:id/search_box").click();	
		Thread.sleep(3000);
		
		//Enter search
		driver.findElementById("com.ebay.mobile:id/search_src_text").sendKeys("shoes" +"\n");
		Thread.sleep(12000);
		
		
		String Output = driver.findElementById("com.ebay.mobile:id/textview_item_count").getText();
		System.out.println(Output);
		
		String Actual_Res = Output.replace(" Items", "");
		System.out.println("Actual Result is "+Actual_Res);
			
		//validate
		
		if(Actual_Res.equals(Expected_Res))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
		//close the app

	}

}
