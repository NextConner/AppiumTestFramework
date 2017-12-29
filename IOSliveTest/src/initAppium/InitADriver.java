package initAppium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class InitADriver {

	public IOSDriver driver;
	
	public IOSDriver setUpAppium() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("platformVersion", "9.2");		
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME
				//, "XCUITest");
		
		try {
			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			
			if (driver == null) {
				System.out.println("File to obtain driver!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
	
	public void destory() throws InterruptedException {
		driver.closeApp();
		if (driver != null) {
			driver.quit();
		}
	}
}
