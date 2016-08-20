package Day2;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Implicit_wait {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		//launch app
				//Device details
						DesiredCapabilities capabilities= new DesiredCapabilities();
						
						capabilities.setCapability("deviceName", "GT-I9300I");
						capabilities.setCapability("platformName", "Android");
						capabilities.setCapability("platformVersion", "4.4.4");
						
						//app details
						capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
						capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
						
						//Appium details
						
						AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

						Thread.sleep(3000);
				
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//click on the element
					//	driver.findElementById("com.mobeta.android.demodslv:id/activity_title").click();
					
						WebElement ele1 = driver.findElementById("com.mobeta.android.demodslv:id/activity_title");
						ele1.click();
				//drag and drop
						
						List<WebElement> drag_ele = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle");
						System.out.println(drag_ele.size());
						
						//Touch action
						
						TouchAction action= new TouchAction(driver);
						//action.longPress(drag_ele.get(0)).moveTo(drag_ele.get(5)).release().perform();
						
						Thread.sleep(6000);
						action.longPress(drag_ele.get(6)).moveTo(drag_ele.get(2)).release().perform();
						


	}

}
