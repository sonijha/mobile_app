package Day5;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ola_app_alert {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage", "com.olacabs.customer");
		capabilities.setCapability("appActivity", "com.olacabs.customer.ui.SplashActivity");
		
		//Appium details
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(3000);
		
		//alert not supported
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		
		driver.findElementById("android:id/button1").click();
		
		WebDriverWait wait= new WebDriverWait(driver, 25);
		WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.olacabs.customer:id/button_ride_now")));
		
		System.out.println(until.isDisplayed());
		
		driver.findElementByXPath("//*[@index='2'][@resource-id='com.olacabs.customer:id/button_ride_now'][@text='RIDE NOW']").click();
		//driver.findElementById("com.olacabs.customer:id/button_ride_now").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//*[@index='2'][@resource-id='com.olacabs.customer:id/other_panel']").click();
		Thread.sleep(3000);
		
		String Actual_msg = driver.findElementById("com.olacabs.customer:id/button_ride_conform").getText();
		System.out.println(Actual_msg);
		Thread.sleep(3000);
		
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		

	}

}
