package initAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static initAppium.DeviceConfig.*;

public class AndroidDeviceDriverInit {
    public AndroidDriver<MobileElement> driver;

    public AndroidDriver setUpAppium() throws MalformedURLException {

        DesiredCapabilities desCa = new DesiredCapabilities();

        desCa.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        desCa.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        desCa.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        desCa.setCapability(MobileCapabilityType.APP, APP);
        desCa.setCapability(MobileCapabilityType.NO_RESET, NORESET);
        desCa.setCapability("automationName",AUTOMATION_NAME);
        desCa.setCapability(MobileCapabilityType.APPLICATION_NAME, APPLICATION_NAME);
        desCa.setCapability("appWaitActivity",WAIT_ACTIVITY);

        URL serverUri = new URL("http://127.0.0.1:4723/wd/hub");
        try {
            if (driver == null) {
                driver = new AndroidDriver<MobileElement>(serverUri, desCa);
            }
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        } catch (NullPointerException n) {
            throw new RuntimeException(n);
        }
        System.out.print(driver.toString());
        return driver;
    }
}
