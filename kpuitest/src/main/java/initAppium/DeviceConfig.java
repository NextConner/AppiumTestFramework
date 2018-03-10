package initAppium;

import io.appium.java_client.remote.MobileCapabilityType;

public class DeviceConfig {


    public static final String PLATFORM_NAME = "android";
    public static final String PLATFORM_VERSION = "7.1";
    public static final String DEVICE_NAME = "xiaomi";
    public static final String APP = "C:\\Users\\11157\\Downloads\\app-kp-debug-3-6.apk";
    public static final boolean NORESET = true;
    public static final String AUTOMATION_NAME = "UiAutomator2";
    public static final String APPLICATION_NAME = "xyz.kptech";
    public static final String WAIT_ACTIVITY = "xyz.kptech.biz.login.*";
//    public static final String WAIT_ACTIVITY = "xyz.kptech.biz.home.MainActivity";
//    public static final String WAIT_ACTIVITY = "xyz.kptech.biz.login.SplashActivity";
//
//        desCa.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
//        desCa.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
//        desCa.setCapability(MobileCapabilityType.DEVICE_NAME, "xiaomi");
//        desCa.setCapability(MobileCapabilityType.APP, "C:\\Users\\11157\\Downloads\\app-kp-debug-3-6.apk");
//        desCa.setCapability(MobileCapabilityType.NO_RESET, true);
//        desCa.setCapability("automationName", "UiAutomator2");
//        desCa.setCapability(MobileCapabilityType.APPLICATION_NAME, "xyz.kptech");
//        desCa.setCapability("WaitActivity", "xyz.kptech.biz.home.MainActivity");

}
