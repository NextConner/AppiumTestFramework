package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import location.LocUserPage;

public class UserPage {

	public IOSDriver<MobileElement> driver;
	//public AppiumDriver driver;
	
	public UserPage(IOSDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	 @FindBy(xpath = LocUserPage.SETTINGXP) 
	public WebElement setting;

	@FindBys(value = { @FindBy(id = LocUserPage.INFO_EDITID), @FindBy(xpath = LocUserPage.INFO_EDITXP) })
	public WebElement infoEdit;
	
	
}
