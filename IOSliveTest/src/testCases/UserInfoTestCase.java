package testCases;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import initAppium.InitADriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjects.LoginPage;
import pageObjects.UserPage;
import utils.Common;

@Test
public class UserInfoTestCase {

	IOSDriver<MobileElement> driver;
	Log log = LogFactory.getLog(UserInfoTestCase.class);
	public InitADriver initDriver;
	public LoginPage loginPage;
	public UserPage userPage;
	public MobileElement account;
	public MobileElement password;
	public Common common;

	public int winWidth = 0;
	public int winHeight = 0;
	public int count = 0;
	public WebDriverWait wait;

	@BeforeClass
	public void setUpClass() throws MalformedURLException {
		this.initDriver = new InitADriver();
		this.driver = initDriver.setUpAppium();
		this.loginPage = new LoginPage(driver);
		this.userPage = new UserPage(driver);
		this.common = new Common();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		log.info("-----------------------------START!-----------------------------");
		// TODO 在每条测试用例执行之前保证测试环境的一致性,建议使用reset 设置
		if (count == 0) {
			common.isAlert(driver);
		}
		winWidth = driver.manage().window().getSize().getWidth();
		winHeight = driver.manage().window().getSize().getHeight();
		// 判断是否已经登录
		// if (loginPage.logo == null) {
		// log.info("已经是登录状态！");
		// driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();
		// } else {
		// common.oneTimeLogin(driver, loginPage, winWidth, winHeight);
		// }
		driver.findElementByIosUIAutomation("target.frontMostApp().tabBar().buttons()[3]").click();

	}

	@Test
	public void getUserInfo() {
		log.info("当前登录用户 ： " + userPage.userName.getAttribute("name"));
		log.info("用户金币数 ： "+userPage.coins.findElement(By.xpath("")).getAttribute("value"));
		log.info("用户钻石数 ： "+userPage.diamonds.getText().substring(7));
		log.info("用户等级 ： "+userPage.level.getText().substring(4));
		log.info("用户等级 ： "+userPage.broadcastLevel.getText().substring(14));
	}

	@AfterMethod
	public void tearDown(Method method) throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		driver.quit();
	}
}
