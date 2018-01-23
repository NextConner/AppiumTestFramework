package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
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
import location.LocUserPage;
import pageObjects.LoginPage;
import pageObjects.UserPage;
import utils.Common;

@Test
public class UserInfoTestCase {

	IOSDriver<MobileElement> driver;
	String appBudleId = "com.gomo.ios.glive";
	String appPath = "/Users/xuqin/Desktop/liveApp/GLive1.6.1.app";
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
	String[] sexs = { "Secret", "Female", "Male" };
	String[] rechargeCoins = { "69", "349", "699", "1399", "3499", "6999" };
	String[] recargePrice = { "$0.99", "$4.99", "$9.99", "$19.90", "$49.90", "$99.90" };

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
		log.info("用户金币数 ： " + userPage.coins.findElements(By.className("UIAStaticText")).get(1).getAttribute("name"));
		log.info(
				"用户钻石数 ： " + userPage.diamonds.findElements(By.className("UIAStaticText")).get(1).getAttribute("name"));
		log.info("用户等级 ： " + userPage.level.findElements(By.className("UIAStaticText")).get(1).getAttribute("name"));
		log.info("用户等级 ： "
				+ userPage.broadcastLevel.findElements(By.className("UIAStaticText")).get(1).getAttribute("name"));
		// userPage.infoEdit.click();
	}

	@Ignore
	// @Parameters({"testName"}) String testName
	@Test
	public void editUserName() throws InterruptedException {
		String userName = userPage.userName.getAttribute("name").trim();
		log.info("当前登录用户 ： " + userName);

		userPage.infoEdit.click();
		MobileElement user = driver
				.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]");
		user.clear();
		String changeName = common.getRandomString(6);
		user.setValue(changeName);
		userPage.saveInfo.click();
		log.info("保存");
		assertEquals(userPage.userName.getAttribute("name"), changeName);
	}

	@Ignore
	@Test
	public void editUserSex() {
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

	@Ignore
	// int i
	@Test
	public void editUserBirth() throws InterruptedException {
		int startX = 0;
		int startY = 0;
		int height = 0;
		int i = 0;
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
		for (; i < 3; i++) {
			driver.tap(1, startX, startY, 500);
		}
		userPage.done.click();
		assertEquals(userPage.birthday.getAttribute("value").split("-")[0].trim(), String.valueOf(2018 - i).trim());
		userPage.saveInfo.click();
		log.info("保存");
		count++;
	}

	@Ignore
	@Test
	public void editUserInfo() throws InterruptedException {
		String userName = userPage.userName.getAttribute("name").trim();
		log.info("当前登录用户 ： " + userName);
		// 更改用户名
		userPage.infoEdit.click();
		MobileElement user = driver
				.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]");
		user.clear();
		String changeName = common.getRandomString(6);
		user.setValue(changeName);
		// 更改用户性别
		int i = 0;
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
		// 更改用户出生日期
		int startX = 0;
		int startY = 0;
		int height = 0;
		int j = 0;

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
		for (; j < 3; j++) {
			driver.tap(1, startX, startY, 500);
		}
		userPage.done.click();
		assertEquals(userPage.birthday.getAttribute("value").split("-")[0].trim(), String.valueOf(2018 - j).trim(),
				"更改后生日不匹配！");
		userPage.saveInfo.click();
		assertEquals(userPage.userName.getAttribute("name"), changeName, "用户名断言不匹配！");
		userPage.infoEdit.click();
		assertEquals(userPage.nowSex.getAttribute("value").trim(), sexs[i], "性别断言不匹配！");
	}

	@Ignore
	@Test
	public void coinsRecharge() throws InterruptedException {
		String coins = userPage.coins.findElements(By.className("UIAStaticText")).get(1).getAttribute("name").trim();
		log.info("用户金币数 ： " + coins);
		userPage.coins.click();
		assertEquals(coins, userPage.pageCoins.getAttribute("name").trim());
		assertEquals(userPage.chargeDoller.getAttribute("name").trim(), recargePrice[0].trim());
		List<WebElement> list = userPage.rechargeCoins;
		for (WebElement we : list) {
			log.info("可充值金币数：" + we.getAttribute("name"));
		}
		userPage.rechargeRecord.click();
		assertNotNull(userPage.recordPage);
		userPage.back.click();
	}

	@Ignore
	@Test
	public void diamondsExchange() throws InterruptedException {
		String nowDiamonds = userPage.diamonds.findElements(By.className("UIAStaticText")).get(1).getAttribute("name")
				.trim();
		log.info("当前用户钻石数 ： " + nowDiamonds);
		userPage.diamonds.click();
		assertEquals(userPage.diamondsInPage.getAttribute("name").trim(), nowDiamonds, "个人信息页面钻石数不符！");
		userPage.diamondExchange.click();
		assertNotNull(userPage.diamondExchangeCoins, "可兑换金币为空！");
		userPage.diamondExchangePrice.get(0).findElement(By.className("UIAButton")).click();
		assertNotNull(driver.findElementByClassName("UIAAlert"));
		driver.switchTo().alert().accept();
		TimeUnit.SECONDS.sleep(3);
		String afterExchange = String.valueOf(Integer.valueOf(nowDiamonds) - 100);
		assertEquals(userPage.exchangePageDiamond.getAttribute("name").trim(), afterExchange.trim(), "兑换后钻石数不符");
		Point p = userPage.back.getLocation();
		for (int i = 0; i < 2; i++) {
			driver.tap(1, p.x, p.y, 300);
		}
	}

	@Ignore
	@Test
	public void userLevelInfo() {
		String userLevel = userPage.level.findElements(By.className("UIAStaticText")).get(1).getAttribute("name")
				.trim();
		log.info("当前用户等级 " + userLevel);
		userPage.level.click();
		assertEquals(userLevel, driver.findElementById(userLevel).getAttribute("name").trim(), "用户等级不匹配！");
		userPage.back.click();
		log.info("返回用户个人信息页面");
	}

	@Ignore
	@Test
	public void userBroadcastLevel() {
		String userBroadcastLevel = userPage.level.findElements(By.className("UIAStaticText")).get(1)
				.getAttribute("name").trim();
		log.info("当前用户主播等级  ：" + userBroadcastLevel);
		userPage.broadcastLevel.click();
		log.info("查看认证主播");
		userPage.anchorCertification.click();
		userPage.newAnchorCertification.click();
		List<WebElement> list = userPage.anchorCertificationCnditions;
		log.info("－－－－－－－－－－－－认证主播条件！－－－－－－－－－－－－－");
		log.info(list.size());
		for (WebElement we : list) {
			log.info(we.getAttribute("name"));
		}
		Point p = userPage.back.getLocation();
		for (int i = 0; i < 3; i++) {
			driver.tap(1, p.x, p.y, 300);
		}
		log.info("返回到个人信息页面！");
	}

	@Test
	public void contributeRank() throws InterruptedException {
		log.info("－－－－－－－－－－－－－－－－执行滑动操作－－－－－－－－－－－－－－－－－－");
		driver.swipe(winWidth / 2, winHeight / 2, winWidth / 2, winHeight / 4, 300);
		userPage.contributeRank.click();
		log.info("进入观众贡献列表！");
		List<WebElement> list = userPage.contributeUserList;
		StringBuilder sb = new StringBuilder();
		for (WebElement we : list) {
			List<WebElement> li = we.findElements(By.className(LocUserPage.CONTRIBUTE_USER_INFO_CLASS));
			if (li.size() == 3) {
				sb.append(" 用户: " + li.get(1).getAttribute("name") + " ; 贡献值: " + li.get(0).getAttribute("name"));
			} else if (li.size() == 4) {
				sb.append(" 用户: " + li.get(2).getAttribute("name") + " ; 贡献值: " + li.get(1).getAttribute("name"));
			} else {
				log.info("第一页贡献榜已打印完毕！");
				break;
			}
			log.info(sb.toString());
			sb.setLength(0);
		}	
		assertNotNull(driver.findElementById(LocUserPage.CONTRIBUTE_RANK_ID));
		
		userPage.back.click();
		
		
	}

	@AfterMethod
	public void tearDown(Method method) throws InterruptedException {
		log.info("-------------------------------" + method.getName() + " : 方法测试结束---------------------------");
		TimeUnit.SECONDS.sleep(3);
		driver.closeApp();
	}

	@AfterClass
	public void destory() {
		log.info("uninstall app after " + this.getClass().getName() + " testClass!");
		// driver.removeApp("com.gomo.ios.gLive");
		driver.quit();
	}
}
