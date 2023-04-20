package khan_cap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class capiiiii {
	public static String appactivity1;
	public static String apppackage1;
	public static String devicename1;
	public static String platfornname1;
	public AppiumDriverLocalService service;
    //for starting the server
    public AppiumDriverLocalService startServer()
    {
        boolean flag = checkifserverisRunning(4723); // port number when we start appium
        if(!flag)
        {
    service = AppiumDriverLocalService.buildDefaultService(); // if the same service avalbe tham appium will start
    service.start();
            }
        return service; // like returnback in appium
    }
    
    public static boolean checkifserverisRunning(int port)
    {
        boolean isServerRunning=false;
        ServerSocket serversocket;
        try{
            serversocket = new ServerSocket(port);
            serversocket.close();
        }
        catch(IOException e)
        {
            isServerRunning = true;
        }
        finally {
            serversocket=null;
        }
        return isServerRunning;
    } 
	
	
	public static void startemulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"//src//main//resources//extension.bat");
		Thread.sleep(10000);
		
	}
	
	public AndroidDriver<AndroidElement> bt1(String appactivity1, String apppackage1, String devicename1,String plateform1 ) throws IOException, InterruptedException {
		FileReader gp =new FileReader(System.getProperty("user.dir")+"//src//main//java//khan_cap//globalproperties");   //dir=directory we are saying program that go to there
		Properties pro =new Properties();
		pro.load(gp);
		appactivity1 = pro.getProperty("appactivity1");
		apppackage1 = pro.getProperty("apppackage1");
		devicename1 = pro.getProperty("devicename1");
		platfornname1 = pro.getProperty("platformname1");
		if(devicename1.equals("NikkPhone")) {
			startemulator();
	}

		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,  devicename1);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platfornname1);
		dc.setCapability(MobileCapabilityType. AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, apppackage1);
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appactivity1);
		  AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
          return driver;
        
}
}
