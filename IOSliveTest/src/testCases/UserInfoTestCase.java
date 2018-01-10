package testCases;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Point;
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
		// if (count == 0) {
		// common.isAlert(driver);
		// }

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

	@Ignore
	@Test
	public void getUserInfo() {
		log.info("当前登录用户 ： " + userPage.userName.getAttribute("name"));
		// log.info("用户金币数 ：
		// "+userPage.coins.findElement(By.xpath("")).getAttribute("name"));
		// log.info("用户钻石数 ： "+userPage.diamonds.getText().substring(7));
		// log.info("用户等级 ： "+userPage.level.getText().substring(4));
		// log.info("用户等级 ： "+userPage.broadcastLevel.getText().substring(14));
		userPage.infoEdit.click();
	}

	@Ignore
	// @Parameters({"testName"}) String testName
	@Test
	public void editUserName() throws InterruptedException {
		String userName = userPage.userName.getAttribute("name").trim();
		log.info("当前登录用户 ： " + userName);

		userPage.infoEdit.click();
		userPage.editUserName.clear();
		userPage.editUserName.sendKeys("UserName");
		userPage.editUserName.click();
		userPage.saveInfo.click();
		log.info("保存");
		assertEquals(userPage.userName.getAttribute("name"), "testName");

	}

	@Ignore
	@Test
	public void editUserSex() {
		String[] sexs = { "Secret", "Female", "Male" };
		int i = 0;
		userPage.infoEdit.click();
		userPage.editSex.click();
		String nowSex = userPage.nowSex.getAttribute("value").trim();
		switch (nowSex) {
		case "Secret":
			i = 1;
			userPage.female.click();
			break;
		case "Male":
			i = 0;
			userPage.secret.click();
			break;
		case "Female":
			i = 2;
			userPage.male.click();
			break;
		default:
			log.info("未获取到当前性别 ： " + nowSex);
			break;
		}
		userPage.saveInfo.click();
		log.info("保存");
		userPage.infoEdit.click();
		assertEquals(userPage.nowSex.getAttribute("value").trim(), sexs[i]);

	}

	// @Ignore
	// int i
	@Test
	public void editUserBirth() throws InterruptedException {
		int startX = 0;
		int startY = 0;
		int height = 0;
		int i = 1;
		userPage.infoEdit.click();
		String nowBirthday = userPage.birthday.getAttribute("value").split("-")[0].trim();
		log.info(nowBirthday);
		userPage.editBirthday.click();
		if (userPage.birthList.size() > 0) {
			Point point = userPage.birthList.get(2).getLocation();
			height = userPage.birthList.get(2).getSize().getHeight();
			startX = point.x;
			startY = point.y + (height / 2) - 25;
		} else {
			log.info("未获取到选择日期的UI!");
		}
		log.info(startX + " : " + startY + " : ");
		for (;i<3; i++) {
			driver.tap(1, startX, startY, 500);
		}
		userPage.done.click();
		assertEquals(userPage.birthday.getAttribute("value").split("-")[0].trim(), String.valueOf(2018 - i).trim());
		userPage.saveInfo.click();
		log.info("保存");
		count++;
	}

	@AfterMethod
	public void tearDown(Method method) throws InterruptedException {

		TimeUnit.SECONDS.sleep(5);
	}

	@AfterClass
	public void destory() {
		log.info("uninstall app");
		// driver.removeApp("com.gomo.ios.gLive");
		driver.quit();
	}
}
