package initAppium;

public class  IOSDeviceConfig {

	/**
	 * iOS 设备初始化参数
	 */
	public static final String DEVICE_NAME = "Iphone7";
	public static final String PLATFORM_NAME = "ios";
	public static final String PLATFORM_VERSION = "11.0";
	public static final String AUTOMATION_NAME = "XCUITest";
	public static final String APP_PATH = "/Users/admin/Desktop/app/GLive.ipa";
	public static final boolean RESET = false;
	public static final String BUNDLE_ID = "com.gomo.ios.gLive";
	public static final String UDID = "f2058d372485dba529d0ef75442b007a20593773";
	public static final String XCODE_ORG_ID = "W6H2SP9PND";
	public static final String XCODE_SIGNINGID = "iPhone Developer";
	public static final boolean USE_NEW_WDA = false;

	//可以使用Spring 配置文件代替
	/*
	 * "platformName": "ios", "platformVersion": "11.0", "deviceName": "iphone7",
	 * "app": "/Users/admin/Desktop/app/GLive.ipa", "noReset": true, "bundleId":
	 * "com.gomo.ios.gLive", "udid": "f2058d372485dba529d0ef75442b007a20593773",
	 * "xcodeOrgId": "W6H2SP9PND", "xcodeSigningId": "iPhone Developer",
	 * "useNewWDA": false
	 * 
	 */

}
