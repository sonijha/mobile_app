package Day2;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Is_app_installed {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		File app= new File("E:/Testing/Drag_and_Drop/com.mobeta.android.demodslv.apk");
		
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("app",app.getAbsolutePath());
		
		//Appium details
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(12000);
		
		if(driver.isAppInstalled("com.mobeta.android.demodslv"))
		{
			System.out.println("Successfully Installed");
			
			//Remove thrugh code
			driver.removeApp("com.mobeta.android.demodslv");
			Thread.sleep(8000);
			System.out.println("Removed sucessfully");
			
			
			driver.installApp("E:/Testing/Drag_and_Drop/com.mobeta.android.demodslv.apk");
			Thread.sleep(8000);
			System.out.println("Again Installed the app");
			
			
		}
		else
		{
			System.out.println("NOT Installed the app");
		}

		

	}

}
