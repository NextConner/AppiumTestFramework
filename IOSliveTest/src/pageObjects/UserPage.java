package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import location.LocUserPage;

public class UserPage {

	private static UserPage userPage = null;
	public IOSDriver<MobileElement> driver;
	// public AppiumDriver driver;

	public static UserPage getInstace(IOSDriver<MobileElement> driver) {
		if (userPage == null) {
			userPage = new UserPage(driver);
		}
		return userPage;
	}

	private UserPage(IOSDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = LocUserPage.SETTINGXP)
	public WebElement setting;

	@FindBy(id = LocUserPage.INFO_EDITID)
	public WebElement infoEdit;
	@FindBy(xpath = LocUserPage.EDIT_USERNAME)
	public WebElement editUserName;
	@FindBy(xpath = LocUserPage.EDIT_SEX)
	public WebElement editSex;
	@FindBy(xpath = LocUserPage.EDIT_BIRTHDAY)
	public WebElement editBirthday;
	@FindBy(xpath = LocUserPage.BIRTHDAY)
	public WebElement birthday;
	@FindAll({ @FindBy(className = LocUserPage.BIRTHDAY_PICK_CALSS) })
	public List<WebElement> birthList;
	@FindBy(id = LocUserPage.DONE_ID)
	public WebElement done;
	@FindBy(id = LocUserPage.SAVE_INFOID)
	public WebElement saveInfo;
	@FindBy(className = LocUserPage.USER_NAME_CLASS)
	public WebElement userName;
	@FindBy(id = LocUserPage.COINS_ID)
	public WebElement coins;
	@FindBy(id = "$0.99")
	public WebElement chargeDoller;
	@FindBy(xpath = LocUserPage.COIN_PAGES_COIN)
	public WebElement pageCoins;
	@FindAll({ @FindBy(className = LocUserPage.ABLE_CHARGE_CLASS) })
	public List<WebElement> rechargeCoins;
	@FindBy(id = LocUserPage.COINS_RECHARGE_TITLEID)
	public WebElement recordPage;
	@FindBy(id = LocUserPage.COINS_RECORDID)
	public WebElement rechargeRecord;
	@FindBy(id = LocUserPage.BACK_ID)
	public WebElement back;
	@FindBy(id = LocUserPage.RECHARGE_WINDOWID)
	public WebElement rechargeSiginIn;
	@FindBy(id = LocUserPage.CANCEL_RECHARGEID)
	public WebElement cancelRecharge;

	@FindBy(id = LocUserPage.DIAMONDS_ID)
	public WebElement diamonds;
	@FindBy(xpath = LocUserPage.DIAMONDS_NUM_INPAGE)
	public WebElement diamondsInPage;

	@FindBy(id = LocUserPage.DIAMONDS_EXCHANGEID)
	public WebElement diamondExchange;
	@FindAll({ @FindBy(className = LocUserPage.DIAMONDS_EXCHANGE_PRICE_CLASS) })
	public List<WebElement> diamondExchangePrice;
	@FindBy(className = LocUserPage.DIAMONDS_PRICECLASS)
	public WebElement diamondExchangeCoins;
	@FindBy(xpath = LocUserPage.EXCHANGE_PAGE_DIAMOND)
	public WebElement exchangePageDiamond;

	@FindBy(id = LocUserPage.LEVEL_ID)
	public WebElement level;

	@FindBy(id = LocUserPage.BROADCAST_LEVEL_ID)
	public WebElement broadcastLevel;
	@FindBy(id = LocUserPage.BROADCAST_TITLE)
	public WebElement broadcastTitle;
	@FindBy(xpath = LocUserPage.BROADCAST_CONTINUELY_DAY)
	public WebElement continuebBroadCastDay;
	@FindBy(xpath = LocUserPage.BROADCAST_DAY)
	public WebElement broadcastDay;
	@FindBy(id = LocUserPage.ANCHOR_CERTIFICATION)
	public WebElement anchorCertification;
	@FindBy(xpath = LocUserPage.ANCHOR_CERTIFICATION_ONE)
	public WebElement newAnchorCertification;
	@FindAll({ @FindBy(className = LocUserPage.ANCHOR_CERTIFICATION_CONDITIONS) })
	public List<WebElement> anchorCertificationCnditions;
	@FindBy(id = LocUserPage.CONTRIBUTE_RANK_ID)
	public WebElement contributeRank;
	@FindAll({ @FindBy(className = LocUserPage.CONTRIBUTE_USER_CLASS) })
	public List<WebElement> contributeUserList;// 再次查询uiastatictext获取用户详细信息
	@FindBy(id = LocUserPage.CONTRIBUTE_FIRSTID)
	public WebElement contributeFirst;
	@FindBy(id = LocUserPage.USER_MOREID)
	public WebElement userMoreButton;
	@FindBy(id = LocUserPage.CANCLE_USER_ACTIONID)
	public WebElement cancelUserAction;
	// 徽章
	@FindBy(id = LocUserPage.MY_BADGE_ID)
	public WebElement myBadge;
	@FindBy(id = LocUserPage.MY_BADGETITLE_ID)
	public WebElement badgePageTitle;
	@FindBy(xpath = LocUserPage.MY_BADGE_NUMBER)
	public WebElement badgeNum;
	@FindBy(className = LocUserPage.MY_BADGE_CLASS)
	public WebElement badgeType;
	@FindAll({ @FindBy(className = LocUserPage.MY_EXIT_BADGE_CLASS) })
	public List<WebElement> exitBadge;// 使用当前className信息获取到的元素，下标从3开始
	@FindBy(id = LocUserPage.BADGE_NOT_OBTAINID)
	public WebElement badgeNotObtain;
	@FindBy(xpath = LocUserPage.BADGE_USEFUL_DAY)
	public WebElement badgeUsefulDay;

	@FindBy(id = LocUserPage.BACK_ID)
	public WebElement infoBack;
	@FindBy(id = LocUserPage.SEX_SECRETID)
	public WebElement secret;
	@FindBy(id = LocUserPage.SEX_FEMALEID)
	public WebElement female;
	@FindBy(id = LocUserPage.SEX_MALEID)
	public WebElement male;
	@FindBy(xpath = LocUserPage.NOW_SEX)
	public WebElement nowSex;
}
