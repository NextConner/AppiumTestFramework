package testCases;

import static org.testng.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import initAppium.InitADriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SettingPage;
import pageObjects.UserPage;
import utils.Common;

@Test
public class LoginTestCase {

	Log log = LogFactory.getLog(LoginTestCase.class);
	public InitADriver initDriver;
	public IOSDriver<MobileElement> driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public UserPage userPage;
	public SettingPage settingPage;
	public MobileElement account;
	public MobileElement password;
	public MobileElement commonUserInfo;
	public Common common;
	public Long sTime;
	public Long eTime;
	public int winWidth = 0;
	public int winHeight = 0;
	public int count;
	// JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeClass
	public void setUpTest() throws MalformedURLException {
		this.initDriver = new InitADriver();
		this.driver = initDriver.setUpAppium();
		this.loginPage = new LoginPage(driver);
		this.homePage = new HomePage(driver);
		this.settingPage = new SettingPage(driver);
		this.userPage = new UserPage(driver);
		this.common = new Common();
		sTime = System.currentTimeMillis();
		this.count = 0;
		// methods = this.getClass().getMethods();
		// for (Method meth : methods) {
		// if (meth.getName().startsWith("test")) {
		// log.info(meth.getName());
		// }
		// }
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException {
		log.info("-----------------------------START!-----------------------------");
	}

	// @Parameters({ "normalAccount", "normalPassword" }) String normalAccount,
	// String normalPassword
	// @Ignore
	@Test
	public void testNormalLogin() throws InterruptedException {
		log.info("-------------------------start test case  testNormalLogin-------------------------");
		winWidth = driver.manage().window().getSize().width;
		winHeight = driver.manage().window().getSize().height;
		if (loginPage.otherLogin != null) {
			loginPage.otherLogin.click();
		} else {
			log.info(" is first login!！");
		}

		loginPage.phoneLogin.click();
		loginPage.changeLogin.click();
		log.info(winWidth + "--------------   :   --------------" + winHeight);
		account = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
		password = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");
		// account.setValue(normalAccount);
		// password.setValue(normalPassword);
		account.setValue("13576046405");
		password.setValue("123456");
		common.tapByXY(driver, winWidth, winHeight, 5, 3, 1);
		loginPage.chinaCode.click();
		loginPage.login.click();
		TimeUnit.SECONDS.sleep(3);

		driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();
		userPage.setting.click();
		settingPage.logOut.click();
		settingPage.sure.click();
		// driver.switchTo().alert().accept();
		TimeUnit.SECONDS.sleep(3);
		assertNotNull(loginPage.changeLogin, "登出失败！");
	}

	// @Ignore
	@Test
	public void testNoti() throws InterruptedException {
		log.info("testCase : " + count);
		TimeUnit.SECONDS.sleep(3);
		loginPage.otherLogin.click();
		loginPage.fbLogin.click();
		assertNotNull(driver.manage().window(), "断言失败！");
	}

	@AfterMethod
	public void tearDown() throws InterruptedException, MalformedURLException {
		// TODO
		log.info("reset appStatues after every testcase ");
		driver.closeApp();
		driver.launchApp();
	}

	@AfterClass
	public void destory() throws InterruptedException {
		initDriver.destory();
		log.info("-----------------------------END!-----------------------------");
		eTime = System.currentTimeMillis();
		log.info("当前测试类" + this.getClass().getName().toString() + "运行时间为：" + (eTime - sTime) / 1000 + "s");
	}

}
