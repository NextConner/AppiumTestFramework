package testCases;

import static org.testng.Assert.assertNotNull;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//import org.testng.log4testng.Logger;
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
	public IOSDriver driver;
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
	StringBuilder sbl = new StringBuilder();
	public Method[] methods;
	// public CheckNotifiWindow checkNotiWin;
	// public Thread check;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeClass
	public void setUpTest() throws MalformedURLException {
		this.initDriver = new InitADriver();
		this.driver = initDriver.setUpAppium();
		this.loginPage = new LoginPage(driver);
		this.common = new Common();
		this.homePage = new HomePage(driver);
		this.userPage = new UserPage(driver);
		this.settingPage = new SettingPage(driver);
		sTime = System.currentTimeMillis();
		methods = this.getClass().getMethods();
		for (Method meth : methods) {
			if (meth.getName().startsWith("test")) {
				log.info(meth.getName());
			}
		}

	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		log.info("-----------------------------START!-----------------------------");
		// sbl.append("var target = UIATarget.localTarget();");
		// sbl.append("target.setDeviceOrientation(UIA_DEVICE_ORIENTATION_PORTRAIT);");
		// sbl.append("target.frontMostApp().tabBar().buttons()[3].tap();");
		// log.info(sbl);

	}

	// @Parameters({ "normalAccount", "normalPassword" }) String normalAccount,
	// String normalPassword
	// @Ignore
	@Test
	public void testNormalLogin() throws InterruptedException {

		log.info("-------------------------start test case  testNormalLogin-------------------------");
		winWidth = driver.manage().window().getSize().width;
		winHeight = driver.manage().window().getSize().height;
		// TimeUnit.SECONDS.sleep(3);
		// if (driver.findElementById("ic golive") != null) {
		// log.info("不是登陆页面！");
		// driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();
		// //
		// driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();
		// userPage.setting.click();
		// settingPage.logOut.click();
		// settingPage.sure.click();
		// loginPage.otherLogin.click();
		// } else {
		// assertNotNull(loginPage.otherLogin, "不是登陆页面！");
		// loginPage.otherLogin.click();
		// }
		if (loginPage.otherLogin != null) {
			loginPage.otherLogin.click();
		} else {
			log.info("fail");
			return;
		}
		TimeUnit.SECONDS.sleep(3);
		// loginPage.otherLogin.click();
		// winWidth = driver.manage().window().getSize().width;
		// winHeight = driver.manage().window().getSize().height;
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
		// TODO 以下执行速度过慢，需要优化
		// assertNotNull(driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]"),
		// "登录失败！");
		// homePage.startLive.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[4]")).click();
		// ;
		driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();
		userPage.setting.click();
		settingPage.logOut.click();
		assertNotNull(settingPage.sure);
		settingPage.sure.click();
		// driver.switchTo().alert().accept();
		TimeUnit.SECONDS.sleep(3);
	}

	@Ignore
	@Test
	public void testNoti() throws InterruptedException {
		log.info("here");
		TimeUnit.SECONDS.sleep(3);
		driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();
		driver.manage().window().getSize();
		// js.executeScript(sbl.toString());
		log.debug("tap");
		TimeUnit.SECONDS.sleep(3);
	}

	@AfterTest
	public void afterTest() {
		//TODO 
		
	}
	
	@AfterClass
	public void destory() throws InterruptedException {
		log.info("-----------------------------END!-----------------------------");
		initDriver.destory();
		eTime = System.currentTimeMillis();
		log.info("当前测试类" + this.getClass().getName().toString() + "运行时间为：" + (eTime - sTime) / 1000 + "s");

	}

}
