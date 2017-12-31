package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class SettingPage {

	public IOSDriver<MobileElement> driver;
	
	public SettingPage(IOSDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=Loc.LOG_OUT)
	public WebElement logOut;
	
	@FindBy(xpath=Loc.SURE)
	public WebElement sure;

	@FindBy(xpath=Loc.CANCLE)
	public WebElement cancle;


}
