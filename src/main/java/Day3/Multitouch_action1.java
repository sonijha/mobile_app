package Day3;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Multitouch_action1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
File app= new File("D:/Testing/com.davemorrissey.labs.subscaleview.sample.apk");
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
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
		
		//Touch action for finger1
		
		int x= image_ele.getLocation().getX()+image_ele.getSize().getWidth()/2;
		int y= image_ele.getLocation().getY()+image_ele.getSize().getHeight()/2;
		
		
		TouchAction finger1= new TouchAction(driver);
		finger1.press(image_ele, x, y-20).moveTo(image_ele, x, y-50);
		
		TouchAction finger2= new TouchAction(driver);
		finger2.press(image_ele, x, y+20).moveTo(image_ele, x, y+50);
		
		Thread.sleep(2000);
		MultiTouchAction action= new MultiTouchAction(driver);
		action.add(finger1).add(finger2).perform();
		
		Thread.sleep(5000);
		
		//***********************************************************
		
		TouchAction finger3= new TouchAction(driver);
		finger3.press(image_ele, x, y-20).moveTo(image_ele, x, y-10);
		
		TouchAction finger4= new TouchAction(driver);
		finger4.press(image_ele, x, y+20).moveTo(image_ele, x, y+10);
		
		Thread.sleep(2000);
		MultiTouchAction action2= new MultiTouchAction(driver);
		action2.add(finger3).add(finger4).perform();
		
		Thread.sleep(5000);
		
		//**********************************************************
		

	}

}
