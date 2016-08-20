package Day4;

import io.appium.java_client.android.AndroidKeyCode;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class driver_Flipkart extends Base_Class_Flipkart {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
				
		Start_Server();
		Init_app();
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/search_widget_textbox")));
			
		System.out.println(until.isDisplayed());
		
		driver.findElementById("com.flipkart.android:id/search_widget_textbox").click();
		Thread.sleep(3000);
		
		driver.findElementById("com.flipkart.android:id/search_autoCompleteTextView").sendKeys("Reebok shoes");
		Thread.sleep(3000);
		
		driver.sendKeyEvent(AndroidKeyCode.ENTER);
		Thread.sleep(3000);
		
		//Swipe bottom to top
		
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		
		int Starty=(int)(size.height*0.80);
		int Endy=(int)(size.height*0.10);
		
		
		int Startx=(int)(size.width*0.50);
		
		for(int i=1;i<=25;i++)
		{
		List<WebElement> ele = driver.findElementsByXPath("//*[@resource-id='com.flipkart.android:id/product_list_product_item_main_text'][@text='Reebok Running Shoes']");
		int size2 = ele.size();
		System.out.println(size2);
		
		if(size2>0)
		{
			driver.findElementByXPath("//*[@resource-id='com.flipkart.android:id/product_list_product_item_main_text'][@text='Reebok Running Shoes']").click();
			break;
		}
		
		driver.swipe(Startx, Starty, Startx, Endy, 1000);
		Thread.sleep(3000);
		}
		
		WebDriverWait wait1= new WebDriverWait(driver, 30);
		WebElement until1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/product_addtocart_1")));
			
		System.out.println(until1.isDisplayed());
		
		driver.findElementById("com.flipkart.android:id/product_addtocart_1").click();
		Thread.sleep(5000);
		
		driver.findElementByXPath("//*[@class='android.widget.TextView'][@text='8'][@index='0']").click();
		Thread.sleep(5000);
		
		driver.findElementById("com.flipkart.android:id/apply_variant").click();
		Thread.sleep(5000);
		
		driver.findElementById("com.flipkart.android:id/product_addtocart_1").click();
		Thread.sleep(5000);
		
		driver.findElementById("com.flipkart.android:id/cart_bg_icon").click();
		Thread.sleep(5000);
		
		
		
		
		
		
		
		

	}

}
