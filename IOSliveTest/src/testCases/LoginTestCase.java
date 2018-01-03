package testCases;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
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
	// public AppiumDriver driver;
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
	public int count = 0;
	public WebDriverWait wait;
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
		Method[] m = this.getClass().getMethods();
		// log.info("----------------------" + m.length +
		// "------------------------------------");
		for (Method me : m) {
			if (me.getName().startsWith("test")) {
				count++;
			}
		}
		// log.info(count + "----------------------------------");
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException {
		log.info("-----------------------------START!-----------------------------");
		count--;
		TimeUnit.SECONDS.sleep(2);
	}

	// @Parameters({ "normalAccount", "normalPassword" }) String normalAccount,
	// String normalPassword
	@Ignore
	@Test
	public void testNormalLogin() throws InterruptedException {
		// log.info("normalID:" + driver.getSessionId());
		log.info("-------------------------start test case  test Normal Login-------------------------");
		winWidth = driver.manage().window().getSize().width;
		winHeight = driver.manage().window().getSize().height;
		if (loginPage.quickLogin.getText().length() <= 0) {
			log.info(" is first login!！");
		} else {
			log.info(" not first login!！");
			loginPage.otherLogin.click();
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
		account = null;
		password = null;
		common.tapByXY(driver, winWidth, winHeight, 5, 3, 1);
		loginPage.chinaCode.click();
		loginPage.login.click();
		wait = new WebDriverWait(driver, 3);
		common.snapshot(driver, ".jpg");
		log.info("截图");
		assertNull(loginPage.loginBar, "登录失败！");
		// driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();
		userPage.setting.click();
		settingPage.logOut.click();
		settingPage.sure.click();
		// driver.switchTo().alert().accept();
		TimeUnit.SECONDS.sleep(3);
		assertNotNull(loginPage.changeLogin, "登出失败！");
	}

	/**
	 * 测试FB 登陆
	 * 
	 * @throws InterruptedException
	 */
	@Ignore
	@Test
	public void testFBLogin() throws InterruptedException {
		log.info("-------------------------start test case  test FB Login-------------------------");
		winWidth = driver.manage().window().getSize().width;
		winHeight = driver.manage().window().getSize().height;
		if (loginPage.quickLogin.getText().length() <= 0) {
			log.info(" is first login!！");
		} else {
			log.info(" not first login!！");
			loginPage.otherLogin.click();
		}

		loginPage.fbLogin.click();
		TimeUnit.SECONDS.sleep(5);
		assertNotNull(loginPage.fbTitle, "未跳转到FB登陆页面");
		account = driver
				.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]");
		account.setValue("1115785160@qq.com");
		password = driver.findElementByXPath(
				"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]");
		password.setValue("zjt3461829");
		// loginPage.fbClick.click();
		// log.info("ios find");

		// driver.context("WEBVIEW_1140.20");
		/*
		 * 解决第三方账号授权登陆的ui获取问题，混合应用范畴
		 */
		for (String context : driver.getContextHandles()) {
			log.info(context);
			if (!context.contains("NATIVE")) {
				if (!context.contains("1140")) {
					driver.context(context);
					loginPage.fbSignIn.click();
					loginPage.fbGoOn.click();
				}
			}
		}
		TimeUnit.SECONDS.sleep(2);
		driver.context("NATIVE_APP");
		assertNotNull(homePage.startLive, "fb登录失败！");
	}

	/**
	 * 测试Twitter 登陆
	 * 
	 * @throws InterruptedException
	 */
	 @Ignore
	@Test
	public void testTwitterLogin() throws InterruptedException {
		log.info("-------------------------start test case  test Twitter Login-------------------------");
		winWidth = driver.manage().window().getSize().width;
		winHeight = driver.manage().window().getSize().height;
		if (loginPage.quickLogin.getText().length() <= 0) {
			log.info(" is first login!！");
		} else {
			log.info(" not first login!！");
			loginPage.otherLogin.click();
		}
		loginPage.twitterLogin.click();
		assertNotNull(loginPage.twitterLogo, "未跳转到Twitter登陆页面");
		account = driver
				.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]");
		account.setValue("m13576046405@163.com");
		password = driver.findElementByXPath(
				"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]");
		password.setValue("zjt3461829");
		loginPage.twitterSignIn.click();
		if (null != loginPage.twitterAuth) {
			loginPage.twitterAuth.click();
		}
		TimeUnit.SECONDS.sleep(3);
		driver.context("NATIVE_APP");
		assertNotNull(homePage.startLive, "twitter登录失败！");
	}

	/**
	 * 测试Google 登陆
	 * 
	 * @throws InterruptedException
	 */
	//@Ignore
	@Test
	public void testGoogleLogin() throws InterruptedException {
		log.info("-------------------------start test case  test Google Login-------------------------");
		winWidth = driver.manage().window().getSize().width;
		winHeight = driver.manage().window().getSize().height;
		if (loginPage.quickLogin.getText().length() <= 0) {
			log.info(" is first login!！");
		} else {
			log.info(" not first login!！");
			loginPage.otherLogin.click();
		}
		loginPage.moreLogin.click();
		loginPage.googleLogin.click();
		assertNotNull(loginPage.googleLogo, "未跳转到Google登陆页面");
		for (String context : driver.getContextHandles()) {
			log.info(context);
//			if (!context.contains("NATIVE")) {
//				if (!context.contains("1140")) {
//					driver.context(context);
//					loginPage.fbSignIn.click();
//					loginPage.fbGoOn.click();
//				}
//			}
		}
		loginPage.googleAccount.click();
		loginPage.googleAccount.sendKeys("1115785160@qq.com");
		loginPage.nextStep.click();
		loginPage.googleAccount.click();
		loginPage.googleAccount.sendKeys("1115785160@qq.com");
		loginPage.nextStep.click();
//		loginPage.googlePassword.click();
//		loginPage.googlePassword.sendKeys("zjt3461829");
//		loginPage.googleSignIn.click();
		TimeUnit.SECONDS.sleep(3);
		assertNotNull(homePage.startLive, "twitter登录失败！");
	}

	@AfterMethod
	public void tearDown() throws InterruptedException, MalformedURLException {
		log.info("reset appStatues after every testcase  : count:" + count);
		driver.closeApp();
		if (count == 0) {
			log.info(count + " : 最后一条测试用例，不用再次启动应用！");
		} else {
			driver.launchApp();
		}
	}

	@AfterClass
	public void destory() throws InterruptedException {
		initDriver.destory();
		log.info("-----------------------------END!-----------------------------");
		eTime = System.currentTimeMillis();
		log.info("当前测试类" + this.getClass().getName().toString() + "运行时间为：" + (eTime - sTime) / 1000 + "s");
	}

}
