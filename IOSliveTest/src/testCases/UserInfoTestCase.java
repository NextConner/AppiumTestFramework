package testCases;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import initAppium.InitADriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

@Test
public class UserInfoTestCase {
	
	IOSDriver<MobileElement> driver;
	Log log = LogFactory.getLog(this.getClass());
	public InitADriver initDriver;
	
	@BeforeMethod
	public void setUp() {
	
	}
}	
