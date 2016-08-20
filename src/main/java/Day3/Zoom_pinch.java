package Day3;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Zoom_pinch {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		File app= new File("D:/Testing/com.davemorrissey.labs.subscaleview.sample.apk");
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("app",app.getAbsolutePath());
	
		
		//Appium details
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(3000);
		
		driver.findElementById("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures").click();
		
		Thread.sleep(2000);
		
		WebElement image_ele = driver.findElementById("com.davemorrissey.labs.subscaleview.sample:id/imageView");
		System.out.println(image_ele);
		
		//zoom
		driver.zoom(image_ele);
		Thread.sleep(12000);
		
		//pinch		
		driver.pinch(image_ele);
		Thread.sleep(12000);
	}

}
