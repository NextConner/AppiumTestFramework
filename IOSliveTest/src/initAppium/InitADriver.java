package initAppium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class InitADriver {

	public IOSDriver<MobileElement> driver;
	WebDriverWait wait;

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
		desiredCapabilities.setCapability("deviceName", "iPhone 6s Plus");
		desiredCapabilities.setCapability("platformVersion", "9.2");
		try {
			driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		return driver;
	}

}
