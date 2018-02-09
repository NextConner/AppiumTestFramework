package initAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class InitADriver {

	
	public IOSDriver<MobileElement> driver = null;
	// appium提供的等待方法，在此对象的构造方法中传参进行等待
	// WebDriverWait wait;

	public IOSDriver<MobileElement> setUpAppium() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		// desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone
		// 6s Plus");
		// desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
		// "9.2");
		// desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
		// "XCUITest");
		// desiredCapabilities.setCapability(MobileCapabilityType.APP,
		// "/Users/taoge/Desktop/liveApp/GLive.app");
		// desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
		// desiredCapabilities.setCapability("deviceName", "iPhone 6s Plus");
		// desiredCapabilities.setCapability("platformVersion", "9.2");
		// 实例driver对象之前判空
		if (driver == null) {
			driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		return driver;

	}

}
