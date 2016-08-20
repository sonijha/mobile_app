package Day5;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Webbased_Cart {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		capabilities.setBrowserName("Chrome");
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(3000);
		
		driver.get("http://books.rediff.com/");
		Thread.sleep(3000);
				
		driver.findElementByName("srch").sendKeys("Modi");
		driver.findElementByClassName("srchbtn_n").click();
		Thread.sleep(3000);
		
		List<WebElement> all_Links = driver.findElementsByTagName("a");
		System.out.println(all_Links.size());
//********************************************************		
		//for each loop
		
//		for(WebElement element:all_Links)
//		{
//			System.out.println(element.getText());
//			
//			if((element.getText()).contains("Gamechanger"))
//			{
//				element.click();
//				break;				
//				
//			}
//			
//		}
		
//****************************************************
		//Normal for loop
		for(int i=0;i<all_Links.size();i++)
		{
			System.out.println(all_Links.get(i).getText());
			
			if((all_Links.get(i).getText()).contains("Gamechanger"))
			{
				all_Links.get(i).click();
				break;
				
			}
			
			
		}
		
		
		
		
		
		Thread.sleep(3000);
		
		driver.findElementByClassName("buynowbtn").click();
		Thread.sleep(3000);
		
		String Actual_Result = driver.findElementByCssSelector("#currentcartdiv > div.cart_prd_row > div.prddetail > span:nth-child(1)").getText();
		System.out.println(Actual_Result);
		
		if(Actual_Result.contains("Gamechanger"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
		
		
		
		

	}

}
