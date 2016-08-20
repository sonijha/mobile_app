package Day3;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Screenorientation1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		
		
		//app details
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", "com.android.contacts.activities.DialtactsActivity");
		
		//Appium details
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(3000);
		
		driver.findElementByXPath("//*[@index='3'][@class='android.app.ActionBar$Tab']").click();
		Thread.sleep(3000);
		
		driver.rotate(ScreenOrientation.LANDSCAPE);
		Thread.sleep(10000);
		
		driver.rotate(ScreenOrientation.PORTRAIT);
		Thread.sleep(10000);
		
		
		
	}

}
