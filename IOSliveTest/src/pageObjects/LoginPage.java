package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;

public class LoginPage {

	public static IOSDriver driver;

	public LoginPage(IOSDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=Loc.LIVE_LOGO)
	public WebElement logo;
	@FindBys(value={@FindBy(xpath=Loc.PHONE_LOGINXP),@FindBy(id=Loc.PHONE_LOGINID)})
	public WebElement phoneLogin;
	@FindBy(xpath=Loc.CHANGE_LOGIN)
	public WebElement changeLogin;
	@FindBy(id=Loc.CHINA_CODEID)
	public WebElement chinaCode;
	@FindBy(xpath=Loc.ACCOUNT)
	public WebElement acccount;
	@FindBy(xpath=Loc.PASSWORD)
	public WebElement password;
	@FindBy(xpath=Loc.LOGIN)
	public WebElement login;
	@FindBy(xpath=Loc.CHOSE_OTHER_LOGIN)
	public WebElement otherLogin;
	@FindBy(xpath=Loc.QUICK_LOGIN)
	public WebElement quickLogin; 
	@FindBy(xpath=Loc.USER_INFO)
	public WebElement commonUserInfo;

}
