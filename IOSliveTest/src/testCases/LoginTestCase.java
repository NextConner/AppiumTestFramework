package testCases;

import static org.testng.Assert.assertNotNull;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import initAppium.InitADriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SettingPage;
import pageObjects.UserPage;
import utils.CheckNotifiWindow;
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
	public Common common;
	public Long sTime;
	public Long eTime;
	public int winWidth = 0;
	public int winHeight = 0;
	public int count = 0;
	public WebDriverWait wait;

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
		// Method[] m = this.getClass().getMethods();
		// for (Method me : m) {
		// if (me.getName().startsWith("test")) {
		// count++;
		// }
		// }
		//使用后台线程查找非预期弹窗代替硬等待
		// CheckNotifiWindow chk=new CheckNotifiWindow(driver);
		// Thread t=new Thread(chk);
		// t.setDaemon(true);
		// log.info("启动后台线程");
		// t.start();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException {
		log.info("-----------------------------START!-----------------------------");
		// TODO 在每条测试用例执行之前保证测试环境的一致性,建议使用reset 设置
		 if (count == 0) {
		 common.isAlert(driver);
		 }
	}

	// @Ignore
	@Parameters({ "normalAccount", "normalPassword" })
	@Test
	public void testNormalLogin(String normalAccount, String normalPassword) throws InterruptedException {
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
		account.setValue(normalAccount);
		password.setValue(normalPassword);
		account = null;
		password = null;
		common.tapByXY(driver, winWidth, winHeight, 5, 3, 1);
		loginPage.chinaCode.click();
		loginPage.login.click();
		TimeUnit.SECONDS.sleep(5);
		// assertNull(loginPage.loginBar, "登录失败！");
		// 判断签到弹窗

		common.ifExistSign(driver, homePage);
		driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();
		userPage.setting.click();
		settingPage.logOut.click();
		settingPage.sure.click();
		// driver.switchTo().alert().accept();
		TimeUnit.SECONDS.sleep(3);
		assertNotNull(loginPage.changeLogin, "登出失败！");
		driver.resetApp();
	}

	/**
	 * 测试异常登陆场景
	 * 
	 * @throws InterruptedException
	 */
	// @Ignore
	@Parameters({ "nullAccount", "normalPassword" })
	@Test
	public void testNullAccount(String nullAccount, String normalPassword) throws InterruptedException {
		log.info("-------------------------start test case  test nullAccount Login-------------------------");
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
		// log.info(winWidth + "-------------- : --------------" + winHeight);
		account = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
		password = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");
		account.setValue(nullAccount);
		password.setValue(normalPassword);
		common.tapByXY(driver, winWidth, winHeight, 5, 3, 1);

		loginPage.chinaCode.click();
		loginPage.login.click();
		TimeUnit.SECONDS.sleep(2);
		assertNotNull(loginPage.loginBar, "断言失败！");
	}

	// @Ignore
	@Parameters({ "wrongAccount", "normalPassword" })
	@Test
	public void testWrongAccount(String wrongAccount, String normalPassword) throws InterruptedException {
		log.info("-------------------------start test case  test WrongAccount Login-------------------------");
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
		// log.info(winWidth + "-------------- : --------------" + winHeight);
		account = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
		password = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");
		account.setValue(wrongAccount);
		password.setValue(normalPassword);
		common.tapByXY(driver, winWidth, winHeight, 5, 3, 1);

		loginPage.chinaCode.click();
		loginPage.login.click();
		TimeUnit.SECONDS.sleep(2);
		assertNotNull(loginPage.loginBar, "断言失败！");
	}

	// @Ignore
	@Parameters({ "unNormalAccount", "normalPassword" })
	@Test
	public void testUnNormalAccount(String unNormalAccount, String normalPassword) throws InterruptedException {
		log.info("-------------------------start test case  test UnNormalAccount Login-------------------------");
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
		// log.info(winWidth + "-------------- : --------------" + winHeight);
		account = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
		password = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");
		account.setValue(unNormalAccount);
		password.setValue(normalPassword);
		common.tapByXY(driver, winWidth, winHeight, 5, 3, 1);
		loginPage.chinaCode.click();
		loginPage.login.click();
		TimeUnit.SECONDS.sleep(2);
		assertNotNull(loginPage.loginBar, "断言失败！");
	}

	// @Ignore
	@Parameters({ "normalAccount", "normalPassword" })
	@Test
	public void testErroeCodeAccount(String normalAccount, String normalPassword) throws InterruptedException {
		log.info("-------------------------start test case  test ErroeCodeAccount Login-------------------------");
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
		// log.info(winWidth + "-------------- : --------------" + winHeight);
		account = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
		password = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");
		account.setValue(normalAccount);
		password.setValue(normalPassword);
		loginPage.login.click();
		TimeUnit.SECONDS.sleep(2);
		assertNotNull(loginPage.loginBar, "断言失败！");
	}

	// @Ignore
	@Parameters({ "normalAccount", "nullPassword" })
	@Test
	public void testNullPassword(String normalAccount, String nullPassword) throws InterruptedException {
		log.info("-------------------------start test case  test NullPassword Login-------------------------");
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
		// log.info(winWidth + "-------------- : --------------" + winHeight);
		account = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
		password = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");
		account.setValue(normalAccount);
		password.setValue(nullPassword);
		common.tapByXY(driver, winWidth, winHeight, 5, 3, 1);
		loginPage.chinaCode.click();
		TimeUnit.SECONDS.sleep(1);
		loginPage.login.click();
		TimeUnit.SECONDS.sleep(2);
		assertNotNull(loginPage.loginBar, "断言失败！");
	}

	// @Ignore
	@Parameters({ "normalAccount", "wrongPassword" })
	@Test
	public void testWrongPassword(String normalAccount, String wrongPassword) throws InterruptedException {
		// log.info("-------------------------start test case test WrongPassword
		// Login-------------------------");
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
		// log.info(winWidth + "-------------- : --------------" + winHeight);
		account = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
		password = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");
		account.setValue(normalAccount);
		password.setValue(wrongPassword);
		common.tapByXY(driver, winWidth, winHeight, 5, 3, 1);
		loginPage.chinaCode.click();
		TimeUnit.SECONDS.sleep(1);
		loginPage.login.click();
		TimeUnit.SECONDS.sleep(2);
		assertNotNull(loginPage.loginBar, "断言失败！");
	}

	// @Ignore
	@Parameters({ "normalAccount", "unNormalPassword" })
	@Test
	public void testUnNormalPassword(String normalAccount, String unNormalPassword) throws InterruptedException {
		// log.info("-------------------------start test case test UnNormalPassword
		// Login-------------------------");
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
		// log.info(winWidth + "-------------- : --------------" + winHeight);
		account = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
		password = (MobileElement) driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");
		account.setValue(normalAccount);
		password.setValue(unNormalPassword);
		common.tapByXY(driver, winWidth, winHeight, 5, 3, 1);
		loginPage.chinaCode.click();
		TimeUnit.SECONDS.sleep(1);
		loginPage.login.click();
		TimeUnit.SECONDS.sleep(2);
		assertNotNull(loginPage.loginBar, "断言失败！");
	}

	/**
	 * 测试FB 登陆
	 * 
	 * @throws InterruptedException
	 */
	// @Ignore
	@Test
	public void testFBLogin() throws InterruptedException {
		// log.info("-------------------------start test case test FB
		// Login-------------------------");
		winWidth = driver.manage().window().getSize().width;
		winHeight = driver.manage().window().getSize().height;
		if (loginPage.quickLogin.getText().length() <= 0) {
			log.info(" is first login!！");
		} else {
			log.info(" not first login!！");
			loginPage.otherLogin.click();
		}
		loginPage.fbLogin.click();
		TimeUnit.SECONDS.sleep(4);
		assertNotNull(loginPage.fbTitle, "未跳转到FB登陆页面");
		List<MobileElement> li = new ArrayList<MobileElement>();
		// li = driver.findElementsByClassName("UIAButton");
		li = driver.findElementsByClassName("UIAStaticText");
		StringBuilder sbr = new StringBuilder();
		for (MobileElement mo : li) {
			sbr.append(mo.getAttribute("name"));
		}
		log.info(sbr);
		if (sbr.toString().contains("确认登录")) {
			log.info("fb授权界面");
			li = driver.findElementsByClassName("UIAButton");
			for (MobileElement mobEl : li) {
				if (mobEl.getAttribute("name").equals("继续")) {
					mobEl.click();
					TimeUnit.SECONDS.sleep(4);
					// 判断弹框
					common.isAlert(driver);
					// 判断签到弹窗
					common.ifExistSign(driver, homePage);
					driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();
					userPage.setting.click();
					settingPage.logOut.click();
					settingPage.sure.click();
					// driver.switchTo().alert().accept();
					TimeUnit.SECONDS.sleep(3);
					assertNotNull(loginPage.changeLogin, "登出失败！");

					break;
				} else {
					continue;
				}
			}
		} else {
			log.info("fb登录界面！");
			account = driver.findElementByXPath(
					"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]");
			account.setValue("1115785160@qq.com");
			password = driver.findElementByXPath(
					"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]");
			password.setValue("zjt3461829");
			loginPage.fbSignIn.click();
			TimeUnit.SECONDS.sleep(3);
			li = driver.findElementsByClassName("UIAButton");
			for (MobileElement mobEl : li) {
				if (mobEl.getAttribute("name").equals("继续")) {
					mobEl.click();
					TimeUnit.SECONDS.sleep(3);
					// 判断弹框
					common.isAlert(driver);
					// 判断签到弹窗
					common.ifExistSign(driver, homePage);
					driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();
					userPage.setting.click();
					settingPage.logOut.click();
					settingPage.sure.click();
					// driver.switchTo().alert().accept();
					TimeUnit.SECONDS.sleep(3);
					assertNotNull(loginPage.changeLogin, "登出失败！");
					break;
				} else {
					log.info("continue!");
				}
			}
		}
	}

	/**
	 * 测试Twitter 登陆
	 * 
	 * @throws InterruptedException
	 */
	 @Ignore
	@Test
	public void testTwitterLogin() throws InterruptedException {
		// log.info("-------------------------start test case test Twitter
		// Login-------------------------");
		winWidth = driver.manage().window().getSize().width;
		winHeight = driver.manage().window().getSize().height;
		if (loginPage.quickLogin.getText().trim().length() <= 0) {
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
		TimeUnit.SECONDS.sleep(5);
		// 判断弹框
		common.isAlert(driver);
		// assertNotNull(homePage.startLive, "twitter登录失败！");
		// common.ifExistSign(driver, homePage);
		List we = driver.findElementsById("Check in");
		if (we.size() > 0) {
			log.info("有签到弹窗！");
			// int signDays=driver.findElementsById("ic_checkin_check").size();
			homePage.signClick.click();
			TimeUnit.SECONDS.sleep(3);
		} else {
			log.info("无签到");
		}
		driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();
		userPage.setting.click();
		settingPage.logOut.click();
		settingPage.sure.click();
		// driver.switchTo().alert().accept();
		TimeUnit.SECONDS.sleep(3);
		assertNotNull(loginPage.changeLogin, "登出失败！");
	}

	/**
	 * 测试Google 登陆
	 * 
	 * @throws InterruptedException
	 */
	@Ignore
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
		TimeUnit.SECONDS.sleep(2);
		assertNotNull(loginPage.googleLogo, "未跳转到Google登陆页面");
		Set<String> se = driver.getContextHandles();
		List<String> list = new ArrayList<String>();
		for (String str : se) {
			list.add(str);
		}
		// loginPage.googleAccount.click();
		// loginPage.googleAccount.sendKeys("1115785160@qq.com");
		// loginPage.nextStep.click();
		// loginPage.googleAccount.click();
		// loginPage.googleAccount.sendKeys("1115785160@qq.com");
		// loginPage.nextStep.click();
		// loginPage.googlePassword.click();
		// loginPage.googlePassword.sendKeys("zjt3461829");
		// loginPage.googleSignIn.click();
		TimeUnit.SECONDS.sleep(3);
		assertNotNull(homePage.startLive, "twitter登录失败！");
	}

	@AfterMethod
	public void tearDown(Method method) throws InterruptedException, MalformedURLException {
		count++;
		// log.info("reset appStatues after every testcase : count:" + count);
		if (!method.getName().contains("Login")) {
			log.info(count + " : 非登录方法，仅关闭app");
			driver.closeApp();
			if (count < 10) {
				driver.launchApp();
			} else {
				log.info("最后一条测试用例，不需要再次启动应用");
			}
		} else {
			log.info("登录方法，重置app环境");
			driver.resetApp();
		}
	}

	@AfterClass
	public void destory() throws InterruptedException {
		if (driver != null) {
			driver.quit();
		}
		log.info("-----------------------------END!-----------------------------");
		eTime = System.currentTimeMillis();
		log.info("当前测试类" + this.getClass().getName().toString() + "运行时间为：" + (eTime - sTime) / 1000 + "s");
	}

}
