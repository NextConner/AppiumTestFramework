package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class LoginPage {

	public  IOSDriver<MobileElement> driver;

	public LoginPage(IOSDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=Loc.LIVE_LOGO)
	public WebElement logo;
	@FindBy(id=Loc.PHONE_LOGINID)
	public WebElement phoneLogin;
	@FindBy(xpath=Loc.CHANGE_LOGIN)
	public WebElement changeLogin;
	@FindBy(id=Loc.COUNTRY_CODEID)
	public WebElement countryCode;
	@FindBy(id=Loc.CHINA_CODEID)
	public WebElement chinaCode;
	@FindBy(xpath=Loc.ACCOUNT)
	public WebElement acccount;
	@FindBy(xpath=Loc.PASSWORD)
	public WebElement password;
	@FindBy(xpath=Loc.LOGIN)
	public WebElement login;
	@FindBy(id=Loc.CHOSE_OTHER_LOGIN)
	public WebElement otherLogin;
	@FindBy(xpath=Loc.QUICK_LOGIN)
	public WebElement quickLogin; 
	@FindBy(xpath=Loc.USER_INFO)
	public WebElement commonUserInfo;
	@FindBy(id=Loc.FB_LOGINID)
	public WebElement fbLogin;
}
