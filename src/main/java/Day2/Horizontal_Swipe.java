package Day2;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Horizontal_Swipe {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage", "flipboard.app");
		capabilities.setCapability("appActivity", "flipboard.activities.LaunchActivity");
		
		//Appium details
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		//Thread.sleep(5000);
		
		WebDriverWait wait= new WebDriverWait(driver, 60);
		WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flipboard.app:id/main_activity_pager")));
		
		System.out.println(until.isDisplayed());
			
		Thread.sleep(5000);
		//swipe from right to left
		
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		
		
		int Startx=(int)(size.width*0.90);
		System.out.println("Startx is  "+Startx);
		
		int Endx=(int)(size.width*0.10);
		System.out.println("Endx is "+Endx);
		
		int Starty=(int)(size.height*0.50);
		System.out.println("Starty is "+Starty);
		
		
		driver.swipe(Startx, Starty, Endx, Starty, 1000);
		Thread.sleep(4000);
		
		driver.swipe(Startx, Starty, Endx, Starty, 1000);
		Thread.sleep(4000);
		
		driver.swipe(Startx, Starty, Endx, Starty, 1000);
		Thread.sleep(4000);
		
		driver.swipe(Startx, Starty, Endx, Starty, 1000);
		Thread.sleep(4000);
		
		System.out.println("Right to left swipe is completed");
		
		Thread.sleep(4000);
		
		//*****************************************************
		
		//Reverse from Left to Right
		Thread.sleep(4000);
		
		int Startx1=(int)(size.width*0.10);
		System.out.println("Startx1 is  "+Startx1);
		
		int Endx1=(int)(size.width*0.90);
		System.out.println("Endx1 is "+Endx1);
		
		int Starty1=(int)(size.height*0.50);
		System.out.println("Starty1 is "+Starty1);
		
		
		driver.swipe(Startx1, Starty1, Endx1, Starty1, 1000);
		Thread.sleep(4000);
		
		driver.swipe(Startx1, Starty1, Endx1, Starty1, 1000);
		Thread.sleep(4000);
		
		driver.swipe(Startx1, Starty1, Endx1, Starty1, 1000);
		Thread.sleep(4000);
		
		driver.swipe(Startx1, Starty1, Endx1, Starty1, 1000);
		Thread.sleep(4000);
		
		
		

	}

}
