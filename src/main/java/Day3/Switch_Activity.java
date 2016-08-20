package Day3;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Switch_Activity {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "GT-I9300I");
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
		
		driver.findElementById("com.android.contacts:id/create_button").click();
		
		driver.findElementByXPath("//*[@index='0'][@class='android.widget.EditText'][@text='Name. Editing.']").sendKeys("Archana2");
		driver.findElementByXPath("//*[@index='0'][@class='android.widget.EditText'][@text='Phone number. Double tap to edit.']").sendKeys("8956565647");
		
		driver.findElementById("com.android.contacts:id/menu_done").click();
		
		Thread.sleep(3000);
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
		Thread.sleep(3000);
		driver.scrollTo("Archana2");
		
		
		boolean Contact1 = driver.findElementByXPath("//*[@index='1'][@class='android.widget.TextView'][@text='Archana2']").isDisplayed();
		
		System.out.println("Archana2 is displayed  "+Contact1);
		
		//******************************************************
		//switch to alarm
		driver.startActivity("com.sec.android.app.clockpackage", "com.sec.android.app.clockpackage.ClockPackage");
		Thread.sleep(5000);
		
		driver.findElementById("com.sec.android.app.clockpackage:id/txtCreateButton").click();
		Thread.sleep(2000);
		
		List<WebElement> alm_ele = driver.findElementsById("com.sec.android.app.clockpackage:id/timepicker_input");
		System.out.println(alm_ele.size());
		
		alm_ele.get(0).clear();
		alm_ele.get(0).sendKeys("7");
		
		Thread.sleep(2000);
		
		alm_ele.get(1).clear();
		alm_ele.get(1).sendKeys("15");
		Thread.sleep(2000);
		
		driver.findElementById("com.sec.android.app.clockpackage:id/repeat_at_day0").click();
		
		String Actual_Remaintime = driver.findElementById("com.sec.android.app.clockpackage:id/alarm_remaintime").getText();
		System.out.println(Actual_Remaintime);
		
		//**********************************************************
		
		//switch to contacts
		
		driver.startActivity("com.android.contacts", "com.android.contacts.activities.DialtactsActivity");
		Thread.sleep(8000);
		
		driver.rotate(ScreenOrientation.LANDSCAPE);
		Thread.sleep(2000);
		
		driver.findElementByXPath("//*[@index='3'][@class='android.app.ActionBar$Tab']").click();
		Thread.sleep(3000);
		
		
		driver.findElementById("com.android.contacts:id/create_button").click();
		
		driver.findElementByXPath("//*[@index='0'][@class='android.widget.EditText'][@text='Name. Editing.']").sendKeys("Archana3");
		
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@index='0'][@class='android.widget.EditText'][@text='Phone number. Double tap to edit.']").sendKeys("9956787877");
		
		driver.findElementById("com.android.contacts:id/menu_done").click();
		
		Thread.sleep(3000);
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
		Thread.sleep(3000);
		driver.scrollTo("Archana3");
		
		boolean Contact2 = driver.findElementByXPath("//*[@index='1'][@class='android.widget.TextView'][@text='Archana3']").isDisplayed();
		
		System.out.println("Archana3 is displayed  "+Contact2);
		Thread.sleep(3000);
		
		driver.rotate(ScreenOrientation.PORTRAIT);
		Thread.sleep(3000);
		
		//********************************************************

	}

}
