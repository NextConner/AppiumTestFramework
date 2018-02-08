package initAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static initAppium.IOSDeviceConfig.*;


/**
 *  IOS11 真机测试初始化
 * @author admin
 *
 */
public class RealDeviceInit {

	public IOSDriver<MobileElement> driver = null;
	// appium提供的等待方法，在此对象的构造方法中传参进行等待
	// WebDriverWait wait;

	public IOSDriver<MobileElement> setUpAppium() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
		desiredCapabilities.setCapability(MobileCapabilityType.APP, APP_PATH);
		desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, RESET);
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, UDID);
		desiredCapabilities.setCapability("bundleId", BUNDLE_ID);
		desiredCapabilities.setCapability("xcodeOrgId", XCODE_ORG_ID);
		desiredCapabilities.setCapability("xcodeSigningId", XCODE_SIGNINGID);
		desiredCapabilities.setCapability("useNewWDA", USE_NEW_WDA);
		
		// 实例driver对象之前判空
		if (driver == null) {
			driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		return driver;
	}
	
}
