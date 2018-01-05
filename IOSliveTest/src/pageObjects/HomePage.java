package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import location.LocHomePage;

public class HomePage {

	public IOSDriver<MobileElement> driver;

	public HomePage(IOSDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath = LocHomePage.USER_INFO)
	// public WebElement userInfo;

	@FindBy(id = LocHomePage.START_LIVEID)
	public WebElement startLive;

	@FindBy(id = LocHomePage.SIGN_TITLEID)
	public WebElement signWindow;

	@FindBy(xpath=LocHomePage.SIGN)
	public WebElement signClick;
	
	@FindBy(xpath=LocHomePage.SIGN_DAYS)
	public WebElement signDay;
	
	
}
