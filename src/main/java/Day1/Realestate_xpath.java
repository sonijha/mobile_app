package Day1;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Realestate_xpath {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		//Launch app		
				//device details
				
				DesiredCapabilities capabilities=new DesiredCapabilities();
				
				capabilities.setCapability("deviceName", "XT1033");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("platformVersion", "4.4.4");
				
				//app details
				capabilities.setCapability("appPackage","com.edmund.mortgageCalculator");
				capabilities.setCapability("appActivity","com.edmund.mortgageCalculator.MortgageCalculator");
				
				//Appium server
				
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				driver.findElementByXPath("//*[@index='1']").sendKeys("10000");
				driver.findElementByXPath("//*[@index='3'][@class='android.widget.EditText']").sendKeys("12");
				driver.findElementByXPath("//*[@index='5']").sendKeys("5");
				
				driver.findElementByXPath("//*[@index='7'][@text='CALCULATE']").click();
				
				
				String Output = driver.findElementByXPath("//*[@index='9']").getText();
				System.out.println(Output);
				
				String Result = Output.replace(". Double tap to edit.", "");
				System.out.println(Result);
				
				String Actual_Result = Result.substring(0, 6);
				System.out.println("Actual Result is "+Actual_Result);
				
				
	}

}
