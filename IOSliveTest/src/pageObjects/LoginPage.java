package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import location.LocLoginPage;

public class LoginPage {

	public IOSDriver<MobileElement> driver;

	// public AppiumDriver driver;
	// public static final long=;
	//
	public LoginPage(IOSDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = LocLoginPage.LIVE_LOGO)
	public WebElement logo;
	@FindBy(id = LocLoginPage.PHONE_LOGINID)
	public WebElement phoneLogin;
	@FindBy(xpath = LocLoginPage.CHANGE_LOGIN)
	public WebElement changeLogin;
	@FindBy(id = LocLoginPage.COUNTRY_CODEID)
	public WebElement countryCode;
	@FindBy(id = LocLoginPage.CHINA_CODEID)
	public WebElement chinaCode;
	@FindBy(xpath = LocLoginPage.ACCOUNT)
	public WebElement acccount;
	@FindBy(xpath = LocLoginPage.PASSWORD)
	public WebElement password;
	@FindBy(xpath = LocLoginPage.LOGIN)
	public WebElement login;
	@FindBy(id = LocLoginPage.CHOSE_OTHER_LOGIN)
	public WebElement otherLogin;
	@FindBy(xpath = LocLoginPage.QUICK_LOGIN)
	public WebElement quickLogin;
	// @FindBy(xpath = LocLoginPageHomePage.USER_INFO)
	// public WebElement commonUserInfo;
	@FindBy(id = LocLoginPage.LOGIN_BAR)
	public WebElement loginBar;
	@FindBy(id = LocLoginPage.MORE_LOGINID)
	public WebElement moreLogin;
	// fb
	@FindBy(id = LocLoginPage.FB_ID)
	public WebElement fbLogin;
	@FindBy(id = LocLoginPage.FB_LOGOID)
	public WebElement fbTitle;
	@FindBy(xpath = LocLoginPage.FB_ACCOUNT)
	public WebElement fbAccount;
	@FindBy(xpath = LocLoginPage.FB_PASSWORD)
	public WebElement fbPassword;
	@FindBy(xpath = LocLoginPage.FB_LOGINXP)
	public WebElement fbSignIn;
	@FindBy(xpath = LocLoginPage.FB_GOON)
	public WebElement fbGoOn;
	@FindBy(xpath = LocLoginPage.FB_SURE)
	public WebElement fbSure;

	// tw
	@FindBy(id = LocLoginPage.TW_ID)
	public WebElement twitterLogin;
	@FindBy(id = LocLoginPage.TW_LOGOID)
	public WebElement twitterLogo;
	@FindBy(xpath = LocLoginPage.TW_ACCOUNT)
	public WebElement twitterAccount;
	@FindBy(xpath = LocLoginPage.TW_PASSWORD)
	public WebElement twitterPassword;
	@FindBy(xpath = LocLoginPage.REMEMBERXP)
	public WebElement rememberMe;
	@FindBy(xpath = LocLoginPage.TW_LOGINXP)
	public WebElement twitterSignIn;
	@FindBy(xpath = LocLoginPage.TW_AUTH)
	public WebElement twitterAuth;

	// google
	@FindBy(id = LocLoginPage.GOOGLEID)
	public WebElement googleLogin;
	@FindBy(id = LocLoginPage.GOOGLE_LOGOID)
	public WebElement googleLogo;
	@FindBy(className = LocLoginPage.GOOGLE_ACCOUNT_CLASS)
	public WebElement googleAccount;
	@FindBy(id = LocLoginPage.GOOGLE_NEXTID)
	public WebElement nextStep;
	@FindBy(className = LocLoginPage.GOOGLE_PASSWORD_CLASS)
	public WebElement googlePassword;
	@FindBy(className = LocLoginPage.GOOGLE_NEXT_CLASS)
	public WebElement googleSign;

	public void isFirstLogin() {
		if (quickLogin.getText().length() <= 0) {
			System.out.println(" is first login!！");
		} else {
			System.out.println(" not first login!！");
			otherLogin.click();
		}
	}
	/*
	 * element 模版
	 * 
	 * @FindBy( =LocLoginPage ) public WebElement ;
	 */
}
