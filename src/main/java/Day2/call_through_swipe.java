package Day2;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class call_through_swipe {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//launch app
				//Device details
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
				
						Thread.sleep(2000);
						
						//scroll to method used to reach the caller
						driver.scrollTo("Office2");
						
						
						
						Thread.sleep(2000);
						
						Dimension size = driver.manage().window().getSize();
						System.out.println(size);
						
						int Startx= (int)(size.width*0.10);
						System.out.println("Startx is "+Startx);
						
						int Endx= (int)(size.width*0.90);
						System.out.println("Endx is "+Endx);
						
						//find the element of the caller
						Thread.sleep(2000);
						WebElement call_ele = driver.findElementByXPath("//*[@index='1'][@text='Office2'][@class='android.widget.TextView']");
						
						//element x and co- ordinate in that we are taking y
						int Starty = call_ele.getLocation().getY();
						Thread.sleep(4000);
						
						
						//swipe
						
						driver.swipe(Startx, Starty, Endx, Starty, 1000);
						
						
						
						
						
						
	}

}
