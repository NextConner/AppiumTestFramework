package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class LoginPage {

	public IOSDriver<MobileElement> driver;
	// public AppiumDriver driver;

	public LoginPage(IOSDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = Loc.LIVE_LOGO)
	public WebElement logo;
	@FindBy(id = Loc.PHONE_LOGINID)
	public WebElement phoneLogin;
	@FindBy(xpath = Loc.CHANGE_LOGIN)
	public WebElement changeLogin;
	@FindBy(id = Loc.COUNTRY_CODEID)
	public WebElement countryCode;
	@FindBy(id = Loc.CHINA_CODEID)
	public WebElement chinaCode;
	@FindBy(xpath = Loc.ACCOUNT)
	public WebElement acccount;
	@FindBy(xpath = Loc.PASSWORD)
	public WebElement password;
	@FindBy(xpath = Loc.LOGIN)
	public WebElement login;
	@FindBy(id = Loc.CHOSE_OTHER_LOGIN)
	public WebElement otherLogin;
	@FindBy(xpath = Loc.QUICK_LOGIN)
	public WebElement quickLogin;
	@FindBy(xpath = Loc.USER_INFO)
	public WebElement commonUserInfo;
	@FindBy(id = Loc.LOGIN_BAR)
	public WebElement loginBar;
	@FindBy(id = Loc.MORE_LOGINID)
	public WebElement moreLogin;
	// fb
	@FindBy(id = Loc.FB_ID)
	public WebElement fbLogin;
	@FindBy(id = Loc.FB_LOGOID)
	public WebElement fbTitle;
	@FindBy(xpath = Loc.FB_ACCOUNT)
	public WebElement fbAccount;
	@FindBy(xpath = Loc.FB_PASSWORD)
	public WebElement fbPassword;
	@FindBy(xpath = Loc.FB_LOGINXP)
	public WebElement fbSignIn;
	@FindBy(xpath = Loc.FB_GOON)
	public WebElement fbGoOn;
	@FindBy(xpath=Loc.FB_SURE)
	public WebElement fbSure;

	// tw
	@FindBy(id = Loc.TW_ID)
	public WebElement twitterLogin;
	@FindBy(id = Loc.TW_LOGOID)
	public WebElement twitterLogo;
	@FindBy(xpath = Loc.TW_ACCOUNT)
	public WebElement twitterAccount;
	@FindBy(xpath = Loc.TW_PASSWORD)
	public WebElement twitterPassword;
	@FindBy(xpath = Loc.REMEMBERXP)
	public WebElement rememberMe;
	@FindBy(xpath = Loc.TW_LOGINXP)
	public WebElement twitterSignIn;
	@FindBy(xpath = Loc.TW_AUTH)
	public WebElement twitterAuth;

	// google
	@FindBy(id = Loc.GOOGLEID)
	public WebElement googleLogin;
	@FindBy(id = Loc.GOOGLE_LOGOID)
	public WebElement googleLogo;
	@FindBy(xpath = Loc.GOOGLE_ACCOUNT)
	public WebElement googleAccount;
	@FindBy(id = Loc.GOOGLE_NEXTID)
	public WebElement nextStep;
	@FindBy(id = Loc.GOOGLE_PASSWORD)
	public WebElement googlePassword;
	@FindBy(id = Loc.GOOGLE_LOGINID)
	public WebElement googleSignIn;

	/*
	 * element 模版
	 * 
	 * @FindBy( =Loc ) public WebElement ;
	 */
}
