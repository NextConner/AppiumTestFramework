package initAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static initAppium.DeviceConfig.*;

public class AndroidDeviceDriverInit {

    static Log log = LogFactory.getLog(AndroidDeviceDriverInit.class);
    public AndroidDriver<MobileElement> driver;
    static final AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
            .withAppiumJS(new File("C:\\Users\\11157\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
            .withLogFile(new File("C:\\Users\\11157\\Documents\\appiumLog\\appium-"+ System.currentTimeMillis()+".log")).withIPAddress("127.0.0.1");
    static AppiumDriverLocalService APPIUM_SERVICE;
    boolean isServerRuning = false;

    //service
    public AppiumDriverLocalService getService() {
        if (APPIUM_SERVICE == null) {
            APPIUM_SERVICE = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        }
        return APPIUM_SERVICE;
    }

    //driver
    public AndroidDriver setUpAppium() throws MalformedURLException {
        //server start by using AppiumServerBuilder  API
        try {
            getService();
            APPIUM_SERVICE.start();
            TimeUnit.SECONDS.sleep(5);
            isServerRuning = APPIUM_SERVICE.isRunning();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //driver args
        DesiredCapabilities desCa = new DesiredCapabilities();
        desCa.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        desCa.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        desCa.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        desCa.setCapability(MobileCapabilityType.APP, APP);
        desCa.setCapability(MobileCapabilityType.NO_RESET, NORESET);
        desCa.setCapability("automationName", AUTOMATION_NAME);
        desCa.setCapability(MobileCapabilityType.APPLICATION_NAME, APPLICATION_NAME);
        desCa.setCapability("appWaitActivity", WAIT_ACTIVITY);

        URL serverUri = new URL("http://127.0.0.1:4723/wd/hub");
        try {
            if (driver == null && isServerRuning == true) {
                driver = new AndroidDriver<MobileElement>(serverUri, desCa);
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//global setting of timeout
        } catch (NullPointerException n) {
            throw new RuntimeException(n);
        }
        return driver;
    }

    public static void main(String[] args) {

//        AndroidDeviceDriverInit a = new AndroidDeviceDriverInit();
//        AppiumDriverLocalService APP_SERVICE = a.getService();
//        try {
//            AndroidDriver driver = a.setUpAppium();
//            if (APP_SERVICE.isRunning()) {
//                log.info("sessionID : " + driver.getSessionId());
//                driver.quit();
//                APP_SERVICE.stop();
//            }
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
        String s=null;
        log.info(s.length());
    }
}
