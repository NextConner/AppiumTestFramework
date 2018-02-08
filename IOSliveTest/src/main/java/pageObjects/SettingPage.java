package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import location.Loc;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SettingPage {

	private static SettingPage settingPage=null;
	
	public IOSDriver<MobileElement> driver;
	
	public static SettingPage getInstance(IOSDriver<MobileElement> driver) {
		if(settingPage==null) {
			settingPage=new SettingPage(driver);
		}
		return settingPage;
	}
	
	private SettingPage(IOSDriver<MobileElement> driver) {
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
