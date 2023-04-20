package explore;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import khan_cap.capiiiii;

public class science extends capiiiii {
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void tt() throws IOException, InterruptedException {
		service = startServer();
		driver = bt1(appactivity1, apppackage1, devicename1, appactivity1);}
 
	@Test
	public void explore() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("Search")).click();
		driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
		driver.findElement(By.xpath("//*[@text='Science']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='Class 9 Physics (India)']")).click();
		Thread.sleep(7000);
		//driver.findElement(By.xpath("//*[@text='Ultrasound']")).click();
        //Thread.sleep(5000);
        //driver.findElement(By.xpath("//*[@text='Human ear - structure & working']")).click();
		 
		
	}

}
