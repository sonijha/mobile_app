package Day3;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Sending_sms {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage", "com.android.mms");
		capabilities.setCapability("appActivity", "com.android.mms.ui.ConversationComposer");
		
		//Appium details
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(3000);
		
		driver.findElementByXPath("//*[@index='0'][@class='android.widget.TextView'][@content-desc='Compose Button']").click();
		Thread.sleep(3000);
		
		driver.findElementById("com.android.mms:id/recipients_editor_to").sendKeys("9902777922");
		driver.findElementById("com.android.mms:id/edit_text_bottom").sendKeys("Welcome");
		
		driver.findElementById("com.android.mms:id/send_button").click();
		
		Thread.sleep(3000);
		
		//click on the back button
		
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		
		Thread.sleep(2000);
		
		List<WebElement> msg_ele = driver.findElementsById("com.android.mms:id/from");
		String Actual_Res = msg_ele.get(0).getText();
		
		System.out.println(Actual_Res);	
	}

}
