package Day4;

import io.appium.java_client.TouchAction;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

public class driver_drag_drop extends Base_Class_drag_drop {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		Start_Server();
		Init_app();
		
		//*************************************
		//functionality starts
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
		
		Thread.sleep(4000);
		//***************************
		//End of functionality
		
		//Stop server
		
		Stop_Server();
		
		
		

	}

}
