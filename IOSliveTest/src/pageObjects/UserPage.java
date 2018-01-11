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

	public IOSDriver<MobileElement> driver;
	// public AppiumDriver driver;

	public UserPage(IOSDriver<MobileElement> driver) {
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
	@FindBy(xpath = LocUserPage.COIN_PAGES_COIN)
	public WebElement pageCoins;
	@FindBy(id = LocUserPage.COINS_RECHARGE_TITLEID)
	public WebElement recordPage;
	@FindBy(id = LocUserPage.COINS_RECORDID)
	public WebElement rechargeRecord;
	@FindBy(id=LocUserPage.BACK_ID)
	public WebElement back;
	
	@FindBy(id = LocUserPage.DIAMONDS_ID)
	public WebElement diamonds;
	@FindBy(id = LocUserPage.LEVEL_ID)
	public WebElement level;
	@FindBy(id = LocUserPage.BROADCAST_LEVEL_ID)
	public WebElement broadcastLevel;
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
